package cn.aleda.struts2.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class UploadMoreAction extends ActionSupport implements ServletRequestAware {
	private File[] upload;
	private String[] uploadFileName;
	private String[] uploadContentType;
	private String uploadPath;
	
	private String result;
	
	private HttpServletRequest request;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
	
	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String execute() throws Exception {
		System.out.println("????");
		HttpSession session = request.getSession();
		String userPath = (String)session.getAttribute("username");
		for (int i = 0; i < uploadFileName.length; i++) {
			String fn = uploadPath  + userPath + "\\files\\" + uploadFileName[i];
			System.out.println("fn = " + fn);
			FileOutputStream fos = new FileOutputStream(fn);
			InputStream is = new FileInputStream(upload[i]);
			
			byte[] buffer = new byte[8192];
			int count = 0;
			while ((count = is.read(buffer)) > 0) {
				fos.write(buffer, 0, count);
			}
			fos.close();
			is.close();
			
		}
		//setResult("文件上传成功,其中如果存在，默认覆盖");
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
