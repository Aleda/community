package cn.aleda.spring.test;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class testforphotos {
	
	public static void resizeImage(String srcImgPath, String distImgPath,  
            int width, int height) throws IOException {  
  
        File srcFile = new File(srcImgPath);  
        Image srcImg = ImageIO.read(srcFile);  
        BufferedImage buffImg = null;  
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        buffImg.getGraphics().drawImage(  
                srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0,  
                0, null);  
  
        ImageIO.write(buffImg, "JPEG", new File(distImgPath));  
  
    }
	
	public static void main(String[] args) {
		String srcImg = "F:\\usersfile\\aleda\\images\\wusong.jpg";
		String distImg = "F:\\usersfile\\aleda\\images\\wusong__.jpg";
		try {
			resizeImage(srcImg, distImg, 160, 160);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("success!?~");
	}
}
