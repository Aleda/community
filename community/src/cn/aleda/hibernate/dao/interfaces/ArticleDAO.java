package cn.aleda.hibernate.dao.interfaces;

import java.sql.Timestamp;
import java.util.List;

import cn.aleda.hibernate.entity.Article;

public interface ArticleDAO {
	public void save(Article article);
	public void delete(Article article);
	public void update(Article article);
	public List<Article> load(String username);
	public boolean exists(int id);
	public Article load(String username, String title);
}
