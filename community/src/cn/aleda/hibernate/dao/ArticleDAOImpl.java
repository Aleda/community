package cn.aleda.hibernate.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.aleda.hibernate.dao.interfaces.ArticleDAO;
import cn.aleda.hibernate.entity.Article;

public class ArticleDAOImpl extends DAOSupport implements ArticleDAO {
	
	public ArticleDAOImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

	public void save(Article article) {
		hibernateTemplate.save(article);
	}

	public void delete(Article article) {
		hibernateTemplate.delete(article);
	}

	public void update(Article article) {
		hibernateTemplate.update(article);
	}

	public List<Article> load(String username) {
		String hql = "from Article as article where article.username = ?";
		List<Article> articles = hibernateTemplate.find(hql, username);
		return articles;
	}

	public boolean exists(int id) {
		String hql = "from Article as article where article.id = ?";
		List<Article> articles = hibernateTemplate.find(hql, id);
		if (articles.size() > 0) {
			return true;
		}
		return false;
	}

	public Article load(String username, String title) {
		String hql = "from Article as article where article.username = ? and article.title = ?";
		Object[] args = {username, title};
		List<Article> articles = hibernateTemplate.find(hql, args);
		return articles.get(0);
	}
	
}
