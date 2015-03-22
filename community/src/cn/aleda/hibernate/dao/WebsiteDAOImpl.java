package cn.aleda.hibernate.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.aleda.hibernate.dao.interfaces.WebsiteDAO;
import cn.aleda.hibernate.entity.Website;

public class WebsiteDAOImpl extends DAOSupport implements WebsiteDAO {

	public WebsiteDAOImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

	public void save(Website website) {
		hibernateTemplate.saveOrUpdate(website);
	}

	public void delete(Website website) {
		hibernateTemplate.delete(website);
	}
	
	public List<Website> load(String username) {
		String hql = "from Website where user_name = ?";
		List<Website> sites = hibernateTemplate.find(hql, username);
		return sites;
	}

	public boolean exists(String username, String sitename) {
		String hql = "from Website where user_name = ? and website = ?";
		Object[] params = {username, sitename};
		List<Website> websites = hibernateTemplate.find(hql, params);
		if (websites.size() > 0) {
			return true;
		}
		return false;
	}

	public void motify(Website website) {
		hibernateTemplate.update(website);
	}

	public int queryID(String username, String sitename) {
		String hql = "from Website as w where w.user_name = ? and w.website = ?";
		String[] params = {username, sitename};
		List<Website> sites = hibernateTemplate.find(hql, params);
		int id = sites.get(0).getId();
		System.out.println("id??? = " + id);
		return id;
	}
}
