package http.test;

import java.io.File;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;


public class test {

	public static void main(String[] args) throws SecurityException, IOException {
		//删除文件夹下面的所有文件
//		Logger.getGlobal().setLevel(Level.INFO);
//		Logger.getGlobal().info("File->Open menu item selected");
		String url = "D:\\apache-tomcat-7.0.62\\webapps\\ImageServiceNetgate\\tmp\\";
		File file = new File(url);
		if(file.isDirectory()){
			String []children = file.list();
			for(int i=0;i<children.length;i++){
				System.out.println(url+children[i]);
				File f = new File(url+children[i]);
				f.delete();
			}
		}
//		
//		 Logger log = Logger.getLogger("lavasoft"); 
//         log.setLevel(Level.INFO); 
//         Logger log1 = Logger.getLogger("lavasoft"); 
//         System.out.println(log==log1);     //true 
//         Logger log2 = Logger.getLogger("lavasoft.blog"); 
//         log2.setLevel(Level.WARNING); 
//
//         log.info("aaa"); 
//         log2.info("bbb"); 
//         log2.fine("fine");
		
//		 Logger log = Logger.getLogger("lavasoft"); 
//         log.setLevel(Level.INFO); 
//         Logger log1 = Logger.getLogger("lavasoft"); 
//         System.out.println(log==log1);     //true 
//         Logger log2 = Logger.getLogger("lavasoft.blog"); 
////         log2.setLevel(Level.WARNING); 
//
//         ConsoleHandler consoleHandler =new ConsoleHandler(); 
//         consoleHandler.setLevel(Level.ALL); 
//         log.addHandler(consoleHandler); 
//         FileHandler fileHandler = new FileHandler("E:/testlog%g.log"); 
//         fileHandler.setLevel(Level.INFO); 
//         log.addHandler(fileHandler); 
//         log.info("aaa"); 
//         log2.info("bbb"); 
//         log2.fine("fine"); 
//		
//		 Logger log = Logger.getLogger("lavasoft"); 
//         log.setLevel(Level.INFO); 
//         Logger log1 = Logger.getLogger("lavasoft"); 
//         System.out.println(log == log1);     //true 
//         Logger log2 = Logger.getLogger("lavasoft.blog"); 
////         log2.setLevel(Level.WARNING); 
//
//         ConsoleHandler consoleHandler = new ConsoleHandler(); 
//         consoleHandler.setLevel(Level.ALL); 
//         log.addHandler(consoleHandler); 
//         FileHandler fileHandler = new FileHandler("E:/testlog%g.log"); 
//         fileHandler.setLevel(Level.INFO); 
//         fileHandler.setFormatter(new MyLogHander()); 
//         log.addHandler(fileHandler); 
//
//         log.info("aaa"); 
//         log2.info("bbb"); 
//         log2.fine("fine"); 
//		 LevelTest test = new LevelTest();
//	        test.sub();
		
	}

}

class MyLogHander extends Formatter { 
    @Override 
    public String format(LogRecord record) { 
            return record.getLevel() + ":" + record.getMessage()+"\n"; 
    }
}

class LevelTest {
	
    private static String name = test.class.getName();
    private static Logger log = Logger.getLogger(name);
    public void sub() {
        log.severe("severe level");        // <= (1)
        log.warning("warning level");    // <= (2)
        log.info("info level");            // <= (3)
        log.config("config level");        // <= (4)
        log.fine("fine level");            // <= (5)
        log.finer("finer level");            // <= (6)
        log.finest("finest level");        // <= (7)
    }
}
