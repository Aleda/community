package cn.aleda.spring.service.interfaces;

import java.util.List;

import cn.aleda.hibernate.entity.Website;

public interface WebsiteService {
	public void addSite(Website website);
	public void deleteSite(Website website);
	public List<Website> loadSites(String username);
	public void motifySite(Website website);
	public boolean existsSite(String username, String site);
	public int queryID(String username, String site);
}
