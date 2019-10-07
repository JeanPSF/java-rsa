package src;

import src.RSA;
import src.MD5;
import java.util.concurrent.TimeUnit;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class main {

	
	
	public static void main(String[] args) {
			
	  String myMsg = "RSA é um algoritmo que deve o seu nome a três professores do MIT: Ronald Rivest, Adi Shamir e Leonard Adleman";
	  String login = "Jean"; 
	  String pass = "523461";
	  MD5 MD5 = new MD5();
	  //MD5.stringTest();
	  String encryptedPass = MD5.encrypt(pass);
	  MD5.bruteForceDecrypt(encryptedPass, 1);
		 
		 
		
		
		/*
		 * long startFirst1024 = System.nanoTime(); tests1024(myMsg); long
		 * finishFirst1024 = System.nanoTime(); long startSecond1024 =
		 * System.nanoTime(); tests1024(myMsg); long finishSecond1024 =
		 * System.nanoTime(); long startThird1024 = System.nanoTime(); tests1024(myMsg);
		 * long finishThird1024 = System.nanoTime();
		 * 
		 * long startFirst2048 = System.nanoTime(); tests2048(myMsg); long
		 * finishFirst2048 = System.nanoTime(); long startSecond2048 =
		 * System.nanoTime(); tests2048(myMsg); long finishSecond2048 =
		 * System.nanoTime(); long startThird2048 = System.nanoTime(); tests2048(myMsg);
		 * long finishThird2048 = System.nanoTime();
		 * 
		 * long startFirst4096 = System.nanoTime(); tests4096(myMsg); long
		 * finishFirst4096 = System.nanoTime(); long startSecond4096 =
		 * System.nanoTime(); tests4096(myMsg); long finishSecond4096 =
		 * System.nanoTime(); long startThird4096 = System.nanoTime(); tests4096(myMsg);
		 * long finishThird4096 = System.nanoTime();
		 * 
		 * long startFirst8192 = System.nanoTime(); tests8192(myMsg); long
		 * finishFirst8192 = System.nanoTime(); long startSecond8192 =
		 * System.nanoTime(); tests8192(myMsg); long finishSecond8192 =
		 * System.nanoTime(); long startThird8192 = System.nanoTime(); tests8192(myMsg);
		 * long finishThird8192 = System.nanoTime();
		 * 
		 * System.out.println("1024 first timing: " + ((finishFirst1024 -
		 * startFirst1024)/1000000) + "ms"); System.out.println("1024 second timing: " +
		 * ((finishSecond1024 - startSecond1024)/1000000) + "ms");
		 * System.out.println("1024 third timing: " + ((finishThird1024 -
		 * startThird1024)/1000000) + "ms");
		 * 
		 * System.out.println("2048 first timing: " + ((finishFirst2048 -
		 * startFirst2048)/1000000) + "ms"); System.out.println("2048 second timing: " +
		 * ((finishSecond2048 - startSecond2048)/1000000) + "ms");
		 * System.out.println("2048 third iming: " + ((finishThird2048 -
		 * startThird2048)/1000000) + "ms");
		 * 
		 * System.out.println("4096 first timing: " + ((finishFirst4096 -
		 * startFirst4096)/1000000) + "ms"); System.out.println("4096 second timing: " +
		 * ((finishSecond4096 - startSecond4096)/1000000) + "ms");
		 * System.out.println("4096 third timing: " + ((finishThird4096 -
		 * startThird4096)/1000000) + "ms");
		 * 
		 * System.out.println("8192 first timing: " + ((finishFirst8192 -
		 * startFirst8192)/1000000) + "ms"); System.out.println("8192 second timing: " +
		 * ((finishSecond8192 - startSecond8192)/1000000) + "ms");
		 * System.out.println("8192 third timing: " + ((finishThird8192 -
		 * startThird8192)/1000000) + "ms");
		 * 
		 * tests512(myMsg);
		 */
	}
	
	public static void testsMD5(String myMsg) {
		MD5 MD5 = new MD5();
		String encrypted = MD5.encrypt(myMsg);
		System.out.println("MD5 encrypted: " + encrypted);
	}
	
	public static void tests512(String myMsg) {
		RSA RSA = new RSA();
		byte[] cipherPublic512 = null;
		byte[] cipherPrivate512 = null;
		String plainPublic512 = null;
		String plainPrivate512 = null;
		
		KeyPair myKeys = RSA.get512KeyPar();
		PrivateKey myPrivateKey = myKeys.getPrivate();
		PublicKey myPublicKey = myKeys.getPublic();

		System.out.println("Original: " + myMsg);
		cipherPublic512 = src.RSA.encrypt(myMsg, myPublicKey);
		cipherPrivate512 = src.RSA.encrypt(myMsg, myPrivateKey);
		
		System.out.println("cipherPublic512: " + cipherPublic512);
		System.out.println("cipherPrivate512: " + cipherPrivate512);
		
		
		plainPublic512 = src.RSA.decrypt(cipherPublic512, myPrivateKey);
		plainPrivate512 = src.RSA.decrypt(cipherPrivate512, myPublicKey);
		
		System.out.println("plainPublic512: " + plainPublic512);
		System.out.println("plainPrivate512: " + plainPrivate512);
	}
	
	public static void tests1024(String myMsg) {
		RSA RSA = new RSA();
		byte[] cipherPublic1024 = null;
		byte[] cipherPrivate1024 = null;
		String plainPublic1024 = null;
		String plainPrivate1024 = null;
		
		KeyPair myKeys = RSA.get1024KeyPar();
		PrivateKey myPrivateKey = myKeys.getPrivate();
		PublicKey myPublicKey = myKeys.getPublic();

		System.out.println("Original: " + myMsg);
		
		cipherPublic1024 = src.RSA.encrypt(myMsg, myPublicKey);
		cipherPrivate1024 = src.RSA.encrypt(myMsg, myPrivateKey);
		
		System.out.println("cipherPublic1024: " + cipherPublic1024);
		System.out.println("cipherPrivate1024: " + cipherPrivate1024);
		
		
		plainPublic1024 = src.RSA.decrypt(cipherPublic1024, myPrivateKey);
		plainPrivate1024 = src.RSA.decrypt(cipherPrivate1024, myPublicKey);
		
		System.out.println("plainPublic1024: " + plainPublic1024);
		System.out.println("plainPrivate1024: " + plainPrivate1024);
	}
	
	public static void tests2048(String myMsg) {
		RSA RSA = new RSA();
		byte[] cipherPublic2048 = null;
		byte[] cipherPrivate2048 = null;
		String plainPublic2048 = null;
		String plainPrivate2048 = null;
		
		KeyPair myKeys = RSA.get2048KeyPar();
		PrivateKey myPrivateKey = myKeys.getPrivate();
		PublicKey myPublicKey = myKeys.getPublic();

		System.out.println("Original: " + myMsg);
		
		cipherPublic2048 = src.RSA.encrypt(myMsg, myPublicKey);
		cipherPrivate2048 = src.RSA.encrypt(myMsg, myPrivateKey);
		
		System.out.println("cipherPublic1024: " + cipherPublic2048);
		System.out.println("cipherPrivate1024: " + cipherPrivate2048);
		
		
		plainPublic2048 = src.RSA.decrypt(cipherPublic2048, myPrivateKey);
		plainPrivate2048 = src.RSA.decrypt(cipherPrivate2048, myPublicKey);
		
		System.out.println("plainPublic2048: " + plainPublic2048);
		System.out.println("plainPrivate2048: " + plainPrivate2048);
	}
	
	public static void tests4096(String myMsg) {
		RSA RSA = new RSA();
		byte[] cipherPublic4096 = null;
		byte[] cipherPrivate4096 = null;
		String plainPublic4096 = null;
		String plainPrivate4096 = null;
		
		KeyPair myKeys = RSA.get2048KeyPar();
		PrivateKey myPrivateKey = myKeys.getPrivate();
		PublicKey myPublicKey = myKeys.getPublic();

		System.out.println("Original: " + myMsg);
		
		cipherPublic4096 = src.RSA.encrypt(myMsg, myPublicKey);
		cipherPrivate4096 = src.RSA.encrypt(myMsg, myPrivateKey);
		
		System.out.println("cipherPublic1024: " + cipherPublic4096);
		System.out.println("cipherPrivate1024: " + cipherPrivate4096);
		
		
		plainPublic4096 = src.RSA.decrypt(cipherPublic4096, myPrivateKey);
		plainPrivate4096 = src.RSA.decrypt(cipherPrivate4096, myPublicKey);
		
		System.out.println("plainPublic4096: " + plainPublic4096);
		System.out.println("plainPrivate4096: " + plainPrivate4096);
	}
	
	public static void tests8192(String myMsg) {
		RSA RSA = new RSA();
		byte[] cipherPublic8192 = null;
		byte[] cipherPrivate8192 = null;
		String plainPublic8192 = null;
		String plainPrivate8192 = null;
		
		KeyPair myKeys = RSA.get2048KeyPar();
		PrivateKey myPrivateKey = myKeys.getPrivate();
		PublicKey myPublicKey = myKeys.getPublic();

		System.out.println("Original: " + myMsg);
		
		cipherPublic8192 = src.RSA.encrypt(myMsg, myPublicKey);
		cipherPrivate8192 = src.RSA.encrypt(myMsg, myPrivateKey);
		
		System.out.println("cipherPublic1024: " + cipherPublic8192);
		System.out.println("cipherPrivate1024: " + cipherPrivate8192);
		
		
		plainPublic8192 = src.RSA.decrypt(cipherPublic8192, myPrivateKey);
		plainPrivate8192 = src.RSA.decrypt(cipherPrivate8192, myPublicKey);
		
		System.out.println("plainPublic8192: " + plainPublic8192);
		System.out.println("plainPrivate8192: " + plainPrivate8192);
	}
}
