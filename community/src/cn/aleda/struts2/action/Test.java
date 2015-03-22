package cn.aleda.struts2.action;

import cn.aleda.hibernate.entity.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Test extends ActionSupport {
	private String username;
	private String name;
	private String phone;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String execute() throws Exception {
		System.out.println("username = " + username);
		return SUCCESS;
	}

}
