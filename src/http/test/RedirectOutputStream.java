package http.test;

import java.io.PrintStream;

public class RedirectOutputStream {

	public static void main(String[] args) {
		PrintStream out = System.out;
		try{
			PrintStream ps = new PrintStream("log.txt");
			System.setOut(ps);
			int age = 18;
			String sex = "girl";
			System.out.println(age+" "+sex);
			//System.setOut(out);
		}catch(Exception e){
			
		}

	}

}
