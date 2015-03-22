package cn.aleda.struts2.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import cn.aleda.hibernate.entity.Website;
import cn.aleda.spring.service.ServiceManager;
import cn.aleda.spring.service.interfaces.WebsiteService;

import com.opensymphony.xwork2.ActionSupport;

public class ShowSitesAction extends ActionSupport implements
		ServletRequestAware {
	private HttpServletRequest request;
	private ServiceManager serviceManager;
	private List<Website> sites;
	private int size;
	
	public String execute() throws Exception {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		WebsiteService service = serviceManager.getWebsiteService();
		sites = service.loadSites(username);
		size = sites.size();
		System.out.println("记录全部返回，祝你成功");
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public List<Website> getSites() {
		return sites;
	}

	public void setSites(List<Website> sites) {
		this.sites = sites;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
