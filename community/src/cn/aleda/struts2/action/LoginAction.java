package cn.aleda.struts2.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.aleda.common.Encrypter;
import cn.aleda.hibernate.entity.User;
import cn.aleda.spring.service.ServiceManager;
import cn.aleda.spring.service.interfaces.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements ServletRequestAware {
	/*private User user = new User();*/
	
	private String username;
	private String password;
	private String validationCode;
	
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	private HttpServletRequest request;
	//这里仅仅需要的是声明一个ServiceManager的对象，struts就会去spring中找对应类的bean，然后给了该引用
	private ServiceManager serviceManager;
	
	public void setServiceManager(ServiceManager serviceManager) {
		/*
		System.out.println("set???");
		UserService userService = serviceManager.getUserService();
		System.out.println("get???");
		User user = userService.loadUser("aleda");
		System.out.println("username = " + user.getUsername());
		*/
		this.serviceManager = serviceManager;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getValidationCode() {
		return validationCode;
	}

	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}
	
	public boolean validateCode() {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("validatorCode");
		System.out.println("code = " + code);
		System.out.println("validationCode = " + validationCode);
		if (validationCode.toLowerCase().equals(code.toLowerCase())) {
			return true;
		} else {
			setResult("codeerror");
			return false;
		}
	}
	public String execute() throws Exception {
		if (!validateCode()) {
			System.out.println("验证码错误");
			return INPUT;
		}
		UserService userService = serviceManager.getUserService();
		System.out.println("username = " + username);
		User user = userService.loadUser(username);
		Encrypter enc = new Encrypter();
		String password_md5 = enc.md5Encrypt(password);
		System.out.println("password_md5 = " + password_md5);
		if (user == null) {
			System.out.println("查询user失败！");
			setResult("usernameerror");
			return INPUT;
		} else {
			if (!password_md5.equals(user.getPassword_md5())) {
				setResult("usernameerror");
				return INPUT;
			}
			System.out.println("success!!!");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("imagedir", user.getImagedir());
			session.setMaxInactiveInterval(1 * 60 * 60);
			return SUCCESS;
		}
	}
	
	/*public User getModel() {
		return user;
	}*/
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
