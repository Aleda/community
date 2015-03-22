package cn.aleda.struts2.action;

import java.io.File;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteFileAction extends ActionSupport implements
		ServletRequestAware {
	private HttpServletRequest request;
	private String filenames;
	private String userFilePath;

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String execute() throws Exception {
		String utfPath = new String(filenames.getBytes("iso-8859-1"), "utf-8");
		System.out.println("come in???");
		System.out.println(utfPath);
		String[] names = utfPath.split(", ");
		for (int i = 0; i < names.length; i++) {
			System.out.println("name = " + names[i]);
		}
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String path = userFilePath + username + "\\files";
		File[] files = new File(path).listFiles();
		for (File file: files) {
			for (String filename: names) {
				if (filename.equals("$$$$$$")) {
					continue;
				}
				if (filename.equals(file.getName())) {
					FileUtils.forceDelete(file);
					filename = "$$$$$$";
				}
			}
		}
		System.out.println("删除成功！");
		return SUCCESS;
	}

	public String getFilenames() {
		return filenames;
	}

	public void setFilenames(String filenames) {
		this.filenames = filenames;
	}

	public String getUserFilePath() {
		return userFilePath;
	}
	
	public void setUserFilePath(String userFilePath) {
		this.userFilePath = userFilePath;
	}
	
}
