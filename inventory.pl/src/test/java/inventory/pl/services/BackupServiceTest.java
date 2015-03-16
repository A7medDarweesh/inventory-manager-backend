/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.services;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author ahmed_darweeesh
 */
public class BackupServiceTest {
    BackupService service=new BackupService();
    public BackupServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of backup method, of class BackupService.
     */
    @Test
   // @Ignore
    public void testBackup() {
        System.out.println("backup");
        String inputFolder = "D:/DevPro";
        String outputFile = "D:/programs/back.7z";
        BackupService instance = new BackupService();
        instance.backup(inputFolder, outputFile);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

   

    /**
     * Test of restore method, of class BackupService.
     */
    @Test
    @Ignore
    public void testRestore() {
        System.out.println("restore");
        String source = "D:/programs/back.7z";
        String outputFolder = "D:/programs/backup-restore";
        BackupService instance = new BackupService();
        instance.restore(source, outputFolder);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
