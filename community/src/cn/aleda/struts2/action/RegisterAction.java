package cn.aleda.struts2.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import cn.aleda.common.Encrypter;
import cn.aleda.hibernate.entity.User;
import cn.aleda.spring.service.ServiceManager;
import cn.aleda.spring.service.interfaces.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ServletRequestAware, ModelDriven<User> {
	
	private User user = new User();
	
	private String result;
	
	private ServiceManager serviceManager;
	private UserService userService;
	
	private String username;
	
	private String usersFilePath;
	
	private HttpServletRequest request;
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public boolean validate(User user) {
		userService = serviceManager.getUserService();
		System.out.println("username = " + user.getUsername());
		if (userService.verifyUser(user)) {
			return true;
		}
		return false;
	}
	
	public void print() {
		System.out.println("username = " + user.getUsername());
		System.out.println("name = " + user.getName());
		System.out.println("password = " + user.getPassword());
		System.out.println("password_md5 = " + user.getPassword_md5());
	}
	
	public String execute() throws Exception {
		User user1 = getModel();
		System.out.println("come in RegisterAction");
		Encrypter enc = new Encrypter();
		String pwd = user.getPassword();
		System.out.println("pwd = " + pwd);
		String password_md5 = enc.md5Encrypt(pwd);
		System.out.println("encryptercode = " + password_md5);
		user.setPassword_md5(password_md5);
		print();
		if (validate(user)) {
			System.out.println("isisisisis");
			userService.addUser(user);
			System.out.println("isisisisis");
			String path = usersFilePath + user.getUsername();
			File file = new File(path);
			if (!file.isDirectory()) {
				file.mkdir();
			}
			String path1 = usersFilePath + user.getUsername() + "\\files";
			String path2 = usersFilePath + user.getUsername() + "\\headphoto";
			String path3 = usersFilePath + user.getUsername() + "\\images";
			File file1 = new File(path1);
			File file2 = new File(path2);
			File file3 = new File(path3);
			if (!file1.isDirectory()) {
				file1.mkdir();
			}
			if (!file2.isDirectory()) {
				file2.mkdir();
			}
			if (!file3.isDirectory()) {
				file3.mkdir();
			}
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUsername());
			session.setAttribute("imagedir", user.getImagedir());
			System.out.println("session seted!");
			return SUCCESS;
		} else {
			System.out.println("用户存在");
			setResult("exists");
			return ERROR;
		}
	}
	
	public User getModel() {
		return user;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
