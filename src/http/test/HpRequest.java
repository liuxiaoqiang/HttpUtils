package http.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class HpRequest {
	
	public static String sendPost(String url,String content){
		
		OutputStreamWriter out = null;
		
		BufferedReader in = null;
		
		StringBuffer result = null;
		try{
			//创建一个URL连接
			URL realUrl = new URL(url);
			//打开URL连接
			URLConnection conn = realUrl.openConnection();
			//设置连接的最长时间
			conn.setConnectTimeout(60*1000);
			//设置读取返回内容的最长时间
			conn.setReadTimeout(60*1000);
			//设置允许发送数据
			conn.setDoOutput(true);
			//设置允许读取数据
			conn.setDoInput(true);
			//是否允许使用cache
			conn.setUseCaches(false);
			
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			//获取URLConnection对象的输出流
			out = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
			//发送请求数据
			out.write(content);
			out.flush();
			
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			
			String line = "";
			while((line=in.readLine())!=null)
				result.append(line);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(out !=null)
					out.close();
				out = null;
				if(in !=null)
					in.close();
				in =null;
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		
		return result.toString();
	}

}
