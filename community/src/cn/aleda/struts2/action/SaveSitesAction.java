package cn.aleda.struts2.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import cn.aleda.hibernate.entity.Website;
import cn.aleda.spring.service.ServiceManager;
import cn.aleda.spring.service.interfaces.WebsiteService;

import com.opensymphony.xwork2.ActionSupport;

public class SaveSitesAction extends ActionSupport implements ServletRequestAware {
	private String[] sites;
	private String[] names;
	private HttpServletRequest request;
	private ServiceManager serviceManager;
	
	public String execute() throws Exception {
		System.out.println("come in!!~");
		for (int i = 0; i < sites.length; i++) {
			System.out.println("sites[i] = " + sites[i]);
			System.out.println("names[i] = " + names[i]);
			names[i] = new String(names[i].getBytes("iso-8859-1"), "utf-8");
			sites[i] = new String(sites[i].getBytes("iso-8859-1"), "utf-8");
		}
		WebsiteService websiteService = serviceManager.getWebsiteService();
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		Website website = new Website();
		website.setUser_name(username);
		for (int i = 0; i < sites.length; i++) {
			website.setSite_name(names[i]);
			website.setWebsite(sites[i]);
			if (!websiteService.existsSite(username, sites[i])) {
				websiteService.addSite(website);
			}
		}
		System.out.println("we have stored,");
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String[] getSites() {
		return sites;
	}

	public void setSites(String[] sites) {
		this.sites = sites;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}
	
}
