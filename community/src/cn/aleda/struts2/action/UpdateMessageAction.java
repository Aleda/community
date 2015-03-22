package cn.aleda.struts2.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import cn.aleda.spring.service.ServiceManager;
import cn.aleda.spring.service.interfaces.MessageService;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateMessageAction extends ActionSupport implements
		ServletRequestAware {
	private HttpServletRequest request;
	private String send_name;
	private String message;
	private ServiceManager serviceManager;
	
	public String execute() throws Exception {
		System.out.println("send_name = " + send_name);
		System.out.println("message = " + message);
		String utf_name = new String(send_name.getBytes("iso-8859-1"), "utf-8");
		String utf_message = new String(message.getBytes("iso-8859-1"), "utf-8");
		HttpSession session = request.getSession();
		String receive_name = (String)session.getAttribute("username");
		MessageService service = serviceManager.getMessageService();
		service.updateMessage(utf_name, receive_name, utf_message);
		System.out.println("come on!!~");
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getSend_name() {
		return send_name;
	}

	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}
	
}
