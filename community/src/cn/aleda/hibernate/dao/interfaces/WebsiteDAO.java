package cn.aleda.hibernate.dao.interfaces;

import java.util.List;

import cn.aleda.hibernate.entity.Website;

public interface WebsiteDAO {
	public void save(Website website);
	public void delete(Website website);
	public void motify(Website website);
	public boolean exists(String username, String sitename);
	public List<Website> load(String username);
	public int queryID(String username, String sitename);
}
