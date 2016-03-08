package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 工具类 md5加密
 * @author Administrator
 *
 */

public class MD5 {
	public synchronized static String MD5_32(String plainText){
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte []b = md.digest();
			int i;
			StringBuffer bf = new StringBuffer("");
			for(int offset=0;offset<b.length;offset++){
				i = b[offset];
				System.out.println(i);
				if(i<0)
					i += 256;
				if(i<16)
					bf.append("0");
				bf.append(Integer.toHexString(i));
				System.out.println(bf.toString());
			}
			return bf.toString();
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String []args){
		System.out.println(MD5_32("123456"));
	}

}
