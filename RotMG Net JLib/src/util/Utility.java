package util;

public class Utility {

	public static byte[] hexStringToBytes(String s) {  
        byte[] b = new byte[s.length() / 2];
        for(int i = 0; i < b.length; i++)
            b[i] = (byte)Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16);
    	return b;
    }
}
