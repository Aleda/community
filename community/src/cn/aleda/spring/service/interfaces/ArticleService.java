package cn.aleda.spring.service.interfaces;

import java.sql.Timestamp;
import java.util.List;

import cn.aleda.hibernate.entity.Article;

public interface ArticleService {
	public void addArticle(Article article);
	public void deleteArticle(Article article);
	public void updateArticle(Article article);
	public boolean existsArticle(int id);
	public List<Article> loadArticle(String username);
	public Article loadArticle(String username, String title);
}
