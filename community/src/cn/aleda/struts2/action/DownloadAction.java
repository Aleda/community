package cn.aleda.struts2.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport implements ServletRequestAware {
	private String downloadPath;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String fileName;
	private String usersFilePath;
	private HttpServletRequest request;
	private InputStream inputStream;

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

	public String getDownloadPath() {
		return downloadPath;
	}

	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}
	
	public InputStream getInputStream() {
		 HttpSession session = request.getSession();
		 String username = (String) session.getAttribute("username");
		 String utfPath = null;
		 try {
			utfPath = new String(fileName.getBytes("iso-8859-1"), "utf-8");
		 } catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		 }
		 String path = usersFilePath + username + "\\files\\" + utfPath;
		 File file = new File(path);
		 InputStream is = null;
		 try {
			is = new FileInputStream(file);
		 } catch (FileNotFoundException e) {
			e.printStackTrace();
		 }
		 return is;
	}

	public String execute() throws Exception {
		System.out.println("come in??!");
		return SUCCESS;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUsersFilePath() {
		return usersFilePath;
	}

	public void setUsersFilePath(String usersFilePath) {
		this.usersFilePath = usersFilePath;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
}
