package cn.aleda.spring.service;

import java.util.List;

import cn.aleda.hibernate.dao.interfaces.WebsiteDAO;
import cn.aleda.hibernate.entity.Website;
import cn.aleda.spring.service.interfaces.WebsiteService;

public class WebsiteServiceImpl implements WebsiteService{
	
	private WebsiteDAO websiteDAO;
	
	public WebsiteServiceImpl(WebsiteDAO websiteDAO) {
		this.websiteDAO = websiteDAO;
	}

	public void addSite(Website website) {
		websiteDAO.save(website);
	}

	public void deleteSite(Website website) {
		websiteDAO.delete(website);
	}

	public List<Website> loadSites(String username) {
		return websiteDAO.load(username);
	}

	public void motifySite(Website website) {
		websiteDAO.motify(website);
	}

	public boolean existsSite(String username, String site) {
		if (websiteDAO.exists(username, site)) {
			return true;
		}
		return false;
	}

	public int queryID(String username, String site) {
		return websiteDAO.queryID(username, site);
	}
	
}
