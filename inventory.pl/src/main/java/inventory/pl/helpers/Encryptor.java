/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.helpers;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;


/**
 *
 * @author A7med
 */
@Component 
public class Encryptor {
    final static String KEY="InVEntoryDRaGon2015";
     public synchronized String encrypt(String plaintext,boolean useXor) {
        if(useXor) plaintext=getXoredString(plaintext);
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256"); //step 2
        } catch (NoSuchAlgorithmException e) {

        }
        try {
            md.update(plaintext.getBytes("UTF-8")); //step 3
        } catch (UnsupportedEncodingException e) {

        }

        byte raw[] = md.digest(); //step 4
        String hash = Base64.encodeBase64String(raw); //step 5
        return hash; //step 6
    }

    private String getXoredString(String text) {
        char[] keys=KEY.toCharArray();
         char[] mesg=text.toCharArray();

         int ml=mesg.length;
         int kl=keys.length;
         char[] newmsg=new char[ml];

         for (int i=0; i<ml; i++){
            newmsg[i]=(char)(mesg[i]^keys[i%kl]);
         }//for i
         mesg=null; keys=null;
         return new String(newmsg);
    }
}
