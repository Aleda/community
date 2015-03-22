package cn.aleda.struts2.action;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

public class UploadHeadImgAction extends ActionSupport {
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String userFilePath;
	private String username;

	public static void resizeImage(File srcFile, String destImgPath,  
            int width, int height) throws IOException {  
    
        Image srcImg = ImageIO.read(srcFile);  
        BufferedImage buffImg = null;  
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        buffImg.getGraphics().drawImage(  
                srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0,  
                0, null);  
  
        ImageIO.write(buffImg, "JPEG", new File(destImgPath));  
  
    }
	
	//width: 193px;
	//height: 233px; 照片大小是193 * 233
	
	public String execute() throws Exception {
		String destPath = userFilePath + username + "\\headphoto\\" + uploadFileName;
		System.out.println("destPath = " + destPath);
		File destFile = new File(destPath);
		FileUtils.copyFile(upload, destFile);
		resizeImage(upload, destPath, 193, 232);
		System.out.println("head photo upload success!!~");
		return SUCCESS;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUserFilePath() {
		return userFilePath;
	}
	public void setUserFilePath(String userFilePath) {
		this.userFilePath = userFilePath;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
