package image;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class test {

	public static void main(String[] args) {
//		Image image = new ImageIcon("E:\\1.jpg").getImage();
//		System.out.println(image.getWidth(null));
		
		
		try 
        {   
            BufferedImage src = ImageIO.read(new File("E:\\1.jpg"));  // 读入源图像   
            int width = src.getWidth();        // 源图宽   
            int height = src.getHeight();        // 源图高  
                             
            //  获取一个宽、长是原来scale的图像实例   
            Image image = src.getScaledInstance((int)(width * 0.5), (int)(height * 0.5), Image.SCALE_SMOOTH);  
            
            //缩放图像
            BufferedImage tag = new BufferedImage((int)(width * 0.5), (int)(height * 0.5), BufferedImage.TYPE_INT_RGB);     
            Graphics2D g = tag.createGraphics();   
            
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图   
            g.dispose();   
              
            OutputStream out = new FileOutputStream("E:\\4.jpg");   
            ImageIO.write(tag, "GIF", out);// 输出 
            out.close();   
        } 
        catch (IOException e) 
        {   
            e.printStackTrace();   
        } 

	}

}
