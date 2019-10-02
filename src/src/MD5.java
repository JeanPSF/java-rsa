package src;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	private static final String ALGORITHM = "MD5";
	
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
}
