package cn.aleda.struts2.action;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class ShowSmallAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String username;
	private String filename;
	private String userFilePath;

	public String execute() throws Exception {
		response.setContentType("image/jpeg");//设置显示文件或图片的格式如:application/pdf
		response.setHeader("ragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		try {
//			System.out.println("username = " + username);
//			System.out.println("filename = " + filename);
			String imgName = request.getParameter("fileName");
			System.out.println("imgName = " + imgName);
			String imgPath1 = userFilePath + username + "\\images\\__" + filename;
			// 判断该路径下的文件是否存在
			File file = new File(imgPath1);
			if (file.exists() && !filename.equals("")) {
				DataOutputStream temps = new DataOutputStream(
						response.getOutputStream());
				DataInputStream in = new DataInputStream(new FileInputStream(
						imgPath1));
				byte[] b = new byte[2048];
				while ((in.read(b)) != -1) {
					temps.write(b);
					temps.flush();
				}

				in.close();
				temps.close();
			} 

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getUserFilePath() {
		return userFilePath;
	}

	public void setUserFilePath(String userFilePath) {
		this.userFilePath = userFilePath;
	}
	
}
