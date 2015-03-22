package cn.aleda.struts2.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class ShowFileAction extends ActionSupport implements ServletRequestAware {
	private HttpServletRequest request;
	private String usersFilePath;
	private String[] filesName;
	private int size;
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String execute() throws Exception {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		String path = usersFilePath + username + "\\files";
		File file = new File(path);
		filesName = file.list();
		for (String nm: filesName) {
			System.out.println("filename = " + nm);
		}
		size = filesName.length;
		System.out.println("size = " + size);
		return SUCCESS;
	}

	public String getUsersFilePath() {
		return usersFilePath;
	}

	public void setUsersFilePath(String usersFilePath) {
		this.usersFilePath = usersFilePath;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String[] getFilesName() {
		return filesName;
	}

	public void setFilesName(String[] filesName) {
		this.filesName = filesName;
	}
}
