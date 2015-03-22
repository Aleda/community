package cn.aleda.struts2.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import cn.aleda.hibernate.entity.User;
import cn.aleda.spring.service.ServiceManager;
import cn.aleda.spring.service.interfaces.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class ShowUsersAction extends ActionSupport implements
		ServletRequestAware {
	private HttpServletRequest request;
	private ServiceManager serviceManager;
	private UserService userService;
	private List<User> users;
	private int size;
	
	public String execute() throws Exception {
		System.out.println("you just come in???!");
		userService = serviceManager.getUserService();
		users = userService.loadAllUsers();
		size = users.size();
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
