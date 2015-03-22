package cn.aleda.spring.service;

import java.sql.Timestamp;
import java.util.List;

import cn.aleda.hibernate.dao.interfaces.ArticleDAO;
import cn.aleda.hibernate.entity.Article;
import cn.aleda.spring.service.interfaces.ArticleService;

public class ArticleServiceImpl implements ArticleService {

	private ArticleDAO articleDAO;
	
	public ArticleServiceImpl(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	public void addArticle(Article article) {
		articleDAO.save(article);
	}

	public void deleteArticle(Article article) {
		articleDAO.delete(article);
	}

	public void updateArticle(Article article) {
		articleDAO.update(article);
	}

	public boolean existsArticle(int id) {
		if (articleDAO.exists(id)) {
			return true;
		}
		return false;
	}

	public List<Article> loadArticle(String username) {
		return articleDAO.load(username);
	}

	public Article loadArticle(String username, String title) {
		return articleDAO.load(username, title);
	}
}
