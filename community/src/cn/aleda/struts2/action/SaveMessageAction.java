package cn.aleda.struts2.action;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import cn.aleda.hibernate.entity.Message;
import cn.aleda.spring.service.ServiceManager;
import cn.aleda.spring.service.interfaces.MessageService;

import com.opensymphony.xwork2.ActionSupport;

public class SaveMessageAction extends ActionSupport implements ServletRequestAware {
	private HttpServletRequest request;
	private ServiceManager serviceManager;
	private MessageService messageService;
	private String receive_name;
	private String message;
	
	public String execute() throws Exception {
		messageService = serviceManager.getMessageService();
		HttpSession session = request.getSession();
		String send_name = (String)session.getAttribute("username");
		Timestamp create_time = new Timestamp(new Date().getTime());
		Message m = new Message();
		m.setSend_name(send_name);
		m.setReceive_name(receive_name);
		m.setCreate_time(create_time);
		//注意将参数改成utf8的- -#java默认的事iso-8859-1
		String utf8 = new String(message.getBytes("iso-8859-1"), "utf-8");
		m.setMessage(utf8);
		messageService.addMessage(m);
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public String getReceive_name() {
		return receive_name;
	}

	public void setReceive_name(String receive_name) {
		this.receive_name = receive_name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
