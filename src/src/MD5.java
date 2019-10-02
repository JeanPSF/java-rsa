package src;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	private static final String ALGORITHM = "MD5";
	private static final String tokens[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	MD5() { }
	
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
	
	public String bruteForceDecrypt(int maxSize) {
		String result = null;
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;	
	}
}
