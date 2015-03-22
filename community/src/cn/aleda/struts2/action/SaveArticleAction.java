package cn.aleda.struts2.action;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.http.HttpRequest;

import cn.aleda.hibernate.entity.Article;
import cn.aleda.spring.service.ServiceManager;
import cn.aleda.spring.service.interfaces.ArticleService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaveArticleAction extends ActionSupport implements ServletRequestAware, ModelDriven<Article>{
	
	private Article article = new Article();
	private HttpServletRequest request;
	private ServiceManager serviceManager;
	
	public ServiceManager getServiceManager() {
		return serviceManager;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public void print() {
		System.out.println("username = " + article.getUsername());
		System.out.println("title = " + article.getTitle());
		System.out.println("content = " + article.getContent());
	}

	public String execute() throws Exception {
		print();
		ArticleService articleService = serviceManager.getArticleService();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		System.out.println("the new username: " + username);
		Timestamp tt = new Timestamp(new Date().getTime());
		article.setUsername(username);
		article.setCreate_time(tt);
		if (article.getTitle() == null || article.getContent() == null
				|| article.getContent().equals("") || article.getTitle().equals("")) {
			return ERROR;
		}
		articleService.addArticle(article);
		return SUCCESS;
	}

	public Article getModel() {
		return article;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
