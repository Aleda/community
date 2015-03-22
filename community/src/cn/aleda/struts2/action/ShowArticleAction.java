package cn.aleda.struts2.action;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import cn.aleda.hibernate.entity.Article;
import cn.aleda.spring.service.ServiceManager;
import cn.aleda.spring.service.interfaces.ArticleService;

import com.opensymphony.xwork2.ActionSupport;

public class ShowArticleAction extends ActionSupport implements ServletRequestAware {
	
	private List<Article> articles;
	private HttpServletRequest request;
	private ServiceManager serviceManager;
	private ArticleService articleService;
	private int size;

	public String execute() throws Exception {
		articleService =  serviceManager.getArticleService();
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		articles = articleService.loadArticle(username);
		int count = articles.size();
		System.out.println("count = " + count);
		setSize(count);
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
