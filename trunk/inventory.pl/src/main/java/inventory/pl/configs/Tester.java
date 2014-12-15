/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.pl.configs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author ahmed_darweeesh
 */
public class Tester {

    public static void main(String[] args) {
        char[]chars="nonni".toCharArray();
      Collections.reverse(Arrays.asList(chars));
        System.out.println("revers:"+Arrays.toString(chars));
//        List<Integer> numbers=new ArrayList<>();
//        Random r=new Random();
//        for (int i = 0; i < 1000; i++) {
//            
//            numbers.add(r.nextInt((i+1)*(i+1)));
          /*  Runnable r = new Runnable() {
                int counter = 0;

                public void run() {
                    while (counter < 10) {
                        System.out.println("executing thread:" + Thread.currentThread().getName()+" at "+System.currentTimeMillis());
                        counter++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    System.out.println("ending thread:" + Thread.currentThread().getName()+" at "+System.currentTimeMillis()/10000000);
                }
            };
            Thread t = new Thread(r, "Thread " + i);
            t.start();
        */}
//        List<Integer>unique=numbers.stream().filter(e->{
//            return e>10&&e<1000;
//        }).sorted().distinct().collect(Collectors.toList());
//        System.out.println(Arrays.toString(unique.toArray()));
        
        
   // }

}
