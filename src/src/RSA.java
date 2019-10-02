package src;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import javax.crypto.Cipher;

public class RSA {
	  private static final String ALGORITHM = "RSA";

	  RSA() { }
	  
	  public KeyPair get512KeyPar() {
		  KeyPair key = null;
		  try {
		  	KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
		    keyGen.initialize(512);
		    key = keyGen.generateKeyPair();
		  } catch(Exception e) {
			  e.printStackTrace();
		  }
		  return key;
	  }
	  
	  public KeyPair get1024KeyPar() {
		  KeyPair key = null;
		  try {
		  	KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
		    keyGen.initialize(1024);
		    key = keyGen.generateKeyPair();
		  } catch(Exception e) {
			  e.printStackTrace();
		  }
		  return key;
	  }
	  
	  public KeyPair get2048KeyPar() {
		  KeyPair key = null;
		  try {
		  	KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
		    keyGen.initialize(2048);
		    key = keyGen.generateKeyPair();
		  } catch(Exception e) {
			  e.printStackTrace();
		  }
		  return key;
	  }
	  
	  public KeyPair get4096KeyPar() {
		  KeyPair key = null;
		  try {
		  	KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
		    keyGen.initialize(4096);
		    key = keyGen.generateKeyPair();
		  } catch(Exception e) {
			  e.printStackTrace();
		  }
		  return key;
	  }
	  
	  public KeyPair get8192KeyPar() {
		  KeyPair key = null;
		  try {
		  	KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
		    keyGen.initialize(8192);
		    key = keyGen.generateKeyPair();
		  } catch(Exception e) {
			  e.printStackTrace();
		  }
		  return key;
	  }
	  
	  public static byte[] encrypt(String text, Key key) {
		    byte[] cipherText = null;
		    try {
			    // get an RSA cipher object and print the provider
			    Cipher cipher = Cipher.getInstance(ALGORITHM);
			    // encrypt the plain text using the key
			    cipher.init(Cipher.ENCRYPT_MODE, key);
			    cipherText = cipher.doFinal(text.getBytes());
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		    return cipherText;
	  }

	  public static String decrypt(byte[] text, Key key) {
			byte[] dectyptedText = null;
			try {
				// get an RSA cipher object and print the provider
				Cipher cipher = Cipher.getInstance(ALGORITHM);				
				// decrypt the text using the key
				cipher.init(Cipher.DECRYPT_MODE, key);
				dectyptedText = cipher.doFinal(text);
			
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			return new String(dectyptedText);
	  }
}
