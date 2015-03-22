package cn.aleda.struts2.action;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import cn.aleda.hibernate.entity.Photo;
import cn.aleda.spring.service.ServiceManager;
import cn.aleda.spring.service.interfaces.PhotoService;

import com.opensymphony.xwork2.ActionSupport;

public class UploadPhotosAcion extends ActionSupport implements
		ServletRequestAware {
	//这里的带有upload前缀的文件都是必须的，这是上传文件所必须要的格式
	private File[] upload;
	private String[] uploadFileName;
	private String[] uploadContentType;
	private String[] photoName;
	private HttpServletRequest request;
	private String userFilePath;
	private ServiceManager serviceManager;
	private static final int HEIGHT = 185;
	private static final int WIDTH = 145;
	
	 /*** 
     * 功能 :调整图片大小 开发：wuyechun 2011-7-22 
     * @param srcImgPath 原图片路径 
     * @param distImgPath  转换大小后图片路径 
     * @param width   转换后图片宽度  default = 145
     * @param height  转换后图片高度 default = 185
     */  
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
	
	
	public String execute() throws Exception {
		System.out.println("come in!!~");
		PhotoService service = serviceManager.getPhotoService();
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		Photo photo = new Photo();
		photo.setUser_name(username);
		Timestamp create_time = new Timestamp(new Date().getTime());
		photo.setCreate_time(create_time);
		for (int i = 0; i < upload.length; i++) {
			String srcImgPath = userFilePath + username + "\\images\\" + uploadFileName[i];
			File distFile = new File(srcImgPath);
			FileUtils.copyFile(upload[i], distFile);
			System.out.println("照片已经存好了，你可以看一看！~~~哈哈哈~");
			//every one look at here！！~~
			photo.setBig_path("F:\\usersfile\\" + username + "\\images\\" + uploadFileName[i]);
			photo.setFile_name(uploadFileName[i]);
			photo.setPhoto_name(photoName[i]);
			String distImgPath = userFilePath + username + "\\images\\" + "__" + uploadFileName[i];
			resizeImage(srcImgPath, distImgPath, WIDTH, HEIGHT);
			photo.setSmall_path(distImgPath);
			service.addPhoto(photo);
		}
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getUserFilePath() {
		return userFilePath;
	}

	public void setUserFilePath(String userFilePath) {
		this.userFilePath = userFilePath;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String[] getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String[] photoName) {
		this.photoName = photoName;
	}
	
}
