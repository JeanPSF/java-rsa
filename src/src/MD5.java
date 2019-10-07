package src;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	private static final String ALGORITHM = "MD5";
	private static final String tokens = "0123456789abcdefghijklmnopqrstuvwxyz ";
	private static final String tokensJean = "aejn";
	MD5() { }
	
	public void stringTest() {
		String a = "a";
		String a1 = "a";
		if(a == a1) {
			System.out.println("a");
		} else {			
			System.out.println("b");
		}
	}
	
	public String encrypt(String msg) {
		MessageDigest ecryptedMsg = null;
		String result = null;
		try {
			ecryptedMsg = MessageDigest.getInstance(ALGORITHM);
			ecryptedMsg.update(msg.getBytes(), 0, msg.length());
			result = new BigInteger(1, ecryptedMsg.digest()).toString(16);
			return result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String generateAvailableTokens(int passSize) {
		String availableTokens = "";
		for(int i = 0; i < passSize+1; i++) {
			availableTokens = availableTokens + tokensJean;
		}
		return availableTokens;
	}
	
    public String swap(String a, int i, int j) { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i]; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 
	
	public void tryDecrypt(String tokensAvailable, int l, int r, String answer) {
		try {
	        if (l == r) { 
	        	System.out.println(tokensAvailable);
	        	String checking = encrypt(tokensAvailable);
	        	System.out.println(checking);
	        	System.out.println(answer);
	        	if (checking.toString() == answer.toString()) {
	        		System.out.println("RESPOSTA AQUI TIO! => "+tokensAvailable);
	        	}
	        	System.out.println("------------------------------------------");
	        } else {        	
	        	for (int i = l; i <= r; i++) { 
	        		tokensAvailable = swap(tokensAvailable, l, i); 
	                tryDecrypt(tokensAvailable, l + 1, r, answer); 
	                tokensAvailable = swap(tokensAvailable, l, i); 
	        	}
	        }
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String bruteForceDecrypt(String encryptedMsg, int maxSizeOfOriginalPass) {
		try {
			System.out.println("Inicializando");
			System.out.println("Procurando " + encryptedMsg);
			//Generate string to calculate permutations of string of size n,
			//being n the max size of the string and shorter
			for(int i = 0; i < maxSizeOfOriginalPass; i++) {
				System.out.println("Decrypt " + i);
				//generate all permutations of a string of size i
				//the tokens available are fixed in this class
				String tokens = generateAvailableTokens(i);
				System.out.println("Tokens: "+tokens);
				tryDecrypt(tokens, 0, tokens.length()-1, encryptedMsg);
			} 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "finish";	
	}
}
