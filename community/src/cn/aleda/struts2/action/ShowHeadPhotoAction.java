package cn.aleda.struts2.action;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class ShowHeadPhotoAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String userFilePath;
	
	public String execute() throws Exception {
		response.setContentType("image/jpeg");//设置显示文件或图片的格式如:application/pdf
		response.setHeader("ragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		String path = userFilePath + username + "\\headphoto";
		File f = new File(path);
		if (f.isDirectory()) {
			File[] files = f.listFiles();
			try {
				//		String imgPath1 = userFilePath + username + "\\images\\" + filename;
						// 判断该路径下的文件是否存在
				//		File file = new File(imgPath1);
						if (files[0].exists() && !files[0].getName().equals("")) {
							DataOutputStream temps = new DataOutputStream(
									response.getOutputStream());
							DataInputStream in = new DataInputStream(new FileInputStream(
									files[0].getPath()));
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
		}
		return null;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
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

}
