package http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class downloadFile {
	
	public static int saveAs(String sUrl,String sPath) {
		try {
			URL url;
			url = new URL(sUrl);
			int lastChar;
			for(lastChar=sUrl.length()-1;lastChar>=0;lastChar--)
			{
				if(sUrl.charAt(lastChar) == '\\' || sUrl.charAt(lastChar) == '/')
					break;
			}
			String fileName= sUrl.substring(lastChar+1);
			File outFile = new File(sPath + fileName);
			OutputStream os = new FileOutputStream(outFile);
			InputStream is = url.openStream();
			byte[] buff = new byte[1024];
			while (true) {
				int readed = is.read(buff);
				if (readed == -1) {
					break;
				}
				byte[] temp = new byte[readed];
				System.arraycopy(buff, 0, temp, 0, readed);
				os.write(temp);
			}
			is.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		System.out.println();
		return 0;
		
	}

}
