package cn.aleda.struts2.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import cn.aleda.hibernate.entity.Message;
import cn.aleda.spring.service.ServiceManager;
import cn.aleda.spring.service.interfaces.MessageService;

import com.opensymphony.xwork2.ActionSupport;

public class ShowMessagesAction extends ActionSupport implements ServletRequestAware {
	
	private HttpServletRequest request;
	private ServiceManager serviceManager;
	private MessageService messageService;
	private List<Message> messages;
	private int size;
	
	public String execute() throws Exception {
		messageService = serviceManager.getMessageService();
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		messages = messageService.loadMessage(username);
		size = messages.size();
		System.out.println("size = " + size);
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
