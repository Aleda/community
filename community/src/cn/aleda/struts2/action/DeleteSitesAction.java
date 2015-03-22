package cn.aleda.struts2.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import cn.aleda.hibernate.entity.Website;
import cn.aleda.spring.service.ServiceManager;
import cn.aleda.spring.service.interfaces.WebsiteService;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteSitesAction extends ActionSupport implements ServletRequestAware {
	private String sitesStr;
	private HttpServletRequest request;
	private ServiceManager serviceManager;
	
	public String execute() throws Exception {
		WebsiteService service = serviceManager.getWebsiteService();
		String utfStr = new String(sitesStr.getBytes("iso-8859-1"), "utf-8");
		Website site = new Website();
		HttpSession session = request.getSession();
		String[] sites = utfStr.split(", ");
		for (int i = 0; i < sites.length; i++) {
			System.out.println("sites[i] = " + sites[i]);
		}
		String username = (String)session.getAttribute("username");
		for (String sitename: sites) {
			site.setId(service.queryID(username, sitename));
			site.setUser_name(username);
			site.setSite_name(sitename);
			service.deleteSite(site);
		}
		System.out.println("yeah,, sites have deleted!~");
		return SUCCESS;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public String getSitesStr() {
		return sitesStr;
	}

	public void setSitesStr(String sitesStr) {
		this.sitesStr = sitesStr;
	}
	
	
}
