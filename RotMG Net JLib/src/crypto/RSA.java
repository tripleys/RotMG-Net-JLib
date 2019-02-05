package crypto;

import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.xml.bind.DatatypeConverter;


public class RSA {
	
	public static final String SERVER_PUBLIC_KEY = 
			"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDCKFctVrhfF3m2Kes0FBL/"
			+ "JFeOcmNg9eJz8k/hQy1kadD+XFUpluRqa//Uxp2s9W2qE0EoUCu59ugcf/"
			+ "p7lGuL99UoSGmQEynkBvZct+/M40L0E0rZ4BVgzLOJmIbXMp0J4PnPcb6V"
			+ "LZvxazGcmSfjauC7F3yWYqUbZd/HCBtawwIDAQAB\n";
	
	private static PublicKey KEY;

	static {
		try {
			X509EncodedKeySpec spec = new X509EncodedKeySpec(DatatypeConverter.parseBase64Binary(SERVER_PUBLIC_KEY));
			KeyFactory kf = KeyFactory.getInstance("RSA");
			KEY = kf.generatePublic(spec);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static String encrypt(String string) {

		byte[] buf = string.getBytes(Charset.forName("UTF-8"));

		try {
			
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, KEY);

			buf = cipher.doFinal(buf);

			return DatatypeConverter.printBase64Binary(buf);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}