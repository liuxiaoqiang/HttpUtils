package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SendPost {
	public static void main(String []args) throws IOException{
		String url = "http://stackoverflow.com/questions/2835505";
        Document document = Jsoup.connect(url).get();

        String question = document.select("#question .post-text").text();
        System.out.println("Question: " + question);

        Elements answerers = document.select("#answers .user-details a");
        for (Element answerer : answerers) {
            System.out.println("Answerer: " + answerer.text());
        }
//		String url = "http://localhost:8080/MultiStruts/login";
//		String charset = "UTF-8";
//		String username = "crazyit";
//		String password = "leegang";
//		String query = String.format("username=%s&password=%s", 
//				URLEncoder.encode(username,charset),URLEncoder.encode(password, charset));
////		URLConnection conn = new URL(url).openConnection();
//		HttpURLConnection http = (HttpURLConnection)new URL(url).openConnection();
//		http.setRequestMethod("POST");
//		http.setRequestProperty("Accept-Charset", charset);
//		http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset="+charset);
//		http.setDoOutput(true);
//		http.setDoInput(true);
//		OutputStreamWriter out = new OutputStreamWriter(http.getOutputStream(),"UTF-8");
//		out.write(query);
//		out.flush();
//		InputStream in = http.getInputStream();
//		BufferedReader buf = new BufferedReader(new InputStreamReader(in,"UTF-8"));
//		String line = "";
//		while((line = buf.readLine()) != null){
//			System.out.println(line+"\n");
//		}
	}
	
	public static void sendPost(String url1,String param) throws IOException{
		 
		OutputStreamWriter out = null;
		BufferedReader in = null;
		StringBuffer result = new StringBuffer();
		try{
			URL url = new URL(url1);
			URLConnection conn = url.openConnection();
			conn.setConnectTimeout(60*1000);
			conn.setReadTimeout(60*1000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.3) Gecko/20100401");
//			conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			out = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
			out.write(param);
			out.flush();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			String line = "";
			while((line = in.readLine()) != null){
				result.append(line);
				result.append("\n");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
			in.close();
		}
		System.out.println(result.toString());
	}
	
	public static void sendGet(String url1,String []param){
		
	}
}
