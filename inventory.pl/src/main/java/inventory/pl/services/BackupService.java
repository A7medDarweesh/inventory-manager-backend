/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.pl.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.stereotype.Service;

/**
 *
 * @author ahmed_darweeesh
 */
@Service
public class BackupService {
    
    List<String> entries = new ArrayList<>();
    String SOURCE_FOLDER = "";
    String outputZipFile = "";
    int batchSize;
    private final static int NO_OF_PROCESSORS = Runtime.getRuntime().availableProcessors();
    private static final ForkJoinPool pool = new ForkJoinPool(NO_OF_PROCESSORS );
    AtomicLong counter = new AtomicLong(0);
    
    public void backup(String inputFolder, String outputFile) {
        
        entries.clear();
        SOURCE_FOLDER = inputFolder;
        outputZipFile = outputFile;
        generateFileList(new File(inputFolder));
        batchSize = 5000;
        System.out.println("no of files in list=" + entries.size() + " and no of processors=" + pool.getParallelism());
        long startTime = System.currentTimeMillis();
        if (entries.size() < 10000) {
            File outArchive = new File(outputFile);
            archive(outArchive);
        } else {
            //pool.invoke(new MultiCoreArchiver(0, entries.size() - 1, entries));
            File outArchive = new File(outputFile);
            archive(outArchive);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("finished execution in" + (endTime - startTime) / 1000 + " secs");
//      

    }
    
    private void archive(File outputFile) {
        try {
            byte[] buffer = new byte[1024];
            
            File f;
            SevenZOutputFile sevenZOutput = new SevenZOutputFile(outputFile);
            
            System.out.println("Output to Zip : " + outputFile);
            
            long startTime = System.currentTimeMillis();
            for (String file : this.entries) {
                f = new File(SOURCE_FOLDER + File.separator + file);
                System.out.println("File Added : " + f.getAbsolutePath());
                SevenZArchiveEntry ze = sevenZOutput.createArchiveEntry(f, file);
                
                try {
                    FileInputStream in = new FileInputStream(SOURCE_FOLDER + File.separator + file);
                    sevenZOutput.putArchiveEntry(ze);
                    int len;
                    while ((len = in.read(buffer)) > 0) {
                        sevenZOutput.write(buffer, 0, len);
                    }
                    sevenZOutput.closeArchiveEntry();
                    in.close();
                    
                } catch (java.util.zip.ZipException zipException) {
                    System.err.println("ex=" + zipException.getMessage());
                }
                
            }
            
            long endTime = System.currentTimeMillis();
            
            sevenZOutput.close();
            System.out.println("Done in " + (endTime - startTime));
        } catch (IOException ex) {
            Logger.getLogger(BackupService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void restore(String source, String outputFolder) {
        byte[] buffer = new byte[1024];
        
        try {

            //create output directory is not exists
            File folder = new File(outputFolder);
            if (!folder.exists()) {
                folder.mkdir();
            }

            //get the zip file content
            SevenZFile sevenZFile = new SevenZFile(new File(source));
            //get the zipped file list entry
            SevenZArchiveEntry ze = sevenZFile.getNextEntry();
            
            while (ze != null) {
                
                String fileName = ze.getName();
                File newFile = new File(outputFolder + File.separator + fileName);
                
                System.out.println("file unzip : " + newFile.getAbsoluteFile());

                //create all non exists folders
                //else you will hit FileNotFoundException for compressed folder
                new File(newFile.getParent()).mkdirs();
                
                FileOutputStream fos = new FileOutputStream(newFile);
                
                int len;
                while ((len = sevenZFile.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                
                fos.close();
                ze = sevenZFile.getNextEntry();
            }
            
            sevenZFile.close();
            
            System.out.println("Done");
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void generateFileList(File node) {

        //add file only
        if (node.isFile()) {
            entries.add(generateZipEntry(node.getAbsoluteFile().toString()));
        }
        
        if (node.isDirectory()) {
            String[] subNote = node.list();
            for (String filename : subNote) {
                generateFileList(new File(node, filename));
            }
        }
        
    }

    /**
     * Format the file path for zip
     *
     * @param file file path
     * @return Formatted file path
     */
    private String generateZipEntry(String file) {
        return file.substring(SOURCE_FOLDER.length() + 1, file.length());
    }
    
    class MultiCoreArchiver extends RecursiveTask<Void> {
        
        int start;
        int end;
        List<String> fileEntirs;
        
        public MultiCoreArchiver(int start, int end, List<String> fileEntirs) {
            this.start = start;
            this.end = end;
            this.fileEntirs = fileEntirs;
        }
        
        private void archive() {
            try {
                byte[] buffer = new byte[1024];
                
                File f;
                long startTime;
                long endTime;
                try (SevenZOutputFile sevenZOutput = new SevenZOutputFile(new File(outputZipFile))) {
                    startTime = System.currentTimeMillis();
                    for (int i = start; i <= end; i++) {
                        
                        f = new File(SOURCE_FOLDER + File.separator + fileEntirs.get(i));
                        System.out.println(counter.addAndGet(1) + ":" + i + ": File Added : " + f.getAbsolutePath() + " from thread:" + Thread.currentThread().getName());
                        SevenZArchiveEntry ze = sevenZOutput.createArchiveEntry(f, fileEntirs.get(i));
                        
                        try {
                            try (FileInputStream in = new FileInputStream(SOURCE_FOLDER + File.separator + fileEntirs.get(i))) {
                                sevenZOutput.putArchiveEntry(ze);
                                int len;
                                while ((len = in.read(buffer)) > 0) {
                                    sevenZOutput.write(buffer, 0, len);
                                }
                                sevenZOutput.closeArchiveEntry();
                            }
                            
                        } catch (java.util.zip.ZipException zipException) {
                            System.err.println("ex=" + zipException.getMessage());
                        }
                        if (counter.get() > 5000) {
                            System.out.println("processed 5000 files, freeieng memory");
                            System.out.println("available memory before:" + Runtime.getRuntime().freeMemory());
                            Runtime.getRuntime().gc();
                            System.out.println("available memory after:" + Runtime.getRuntime().freeMemory());
                            counter.set(0);
                        }
                    }                    
                    endTime = System.currentTimeMillis();
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " Done processing " + (end - start) + " Done in " + (endTime - startTime));
                
            } catch (IOException ex) {
                Logger.getLogger(BackupService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        @Override
        protected Void compute() {
            if (end - start <= batchSize) {
                System.out.println("computing with batch size=" + batchSize + " and difference=" + (end - start));
                archive();
            } else {
                int mid = start + (end - start) / 2;
                System.out.println("creating frok with params:" + start + " :" + mid + " :" + end);
                MultiCoreArchiver left = new MultiCoreArchiver(start, mid, fileEntirs);
                MultiCoreArchiver right = new MultiCoreArchiver(mid, end, fileEntirs);
                invokeAll(left,right);
//                left.fork();
//                right.compute();
//                left.join();
            }
            return null;
        }
        
    }
}
