package cn.aleda.struts2.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import cn.aleda.hibernate.entity.Article;
import cn.aleda.spring.service.ServiceManager;
import cn.aleda.spring.service.interfaces.ArticleService;

import com.opensymphony.xwork2.ActionSupport;

public class DisplayOneArticleAction extends ActionSupport implements ServletRequestAware{

	private String title;
	private ServiceManager serviceManager;
	private ArticleService articleService;
	private Article article;
	private HttpServletRequest request;
	
	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}
	
	public String execute() throws Exception {
		articleService = serviceManager.getArticleService();
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		String utf8_title = new String(title.getBytes("iso-8859-1"), "utf-8");
		article = articleService.loadArticle(username, utf8_title);
		System.out.println("成功了，你该去下一个界面了！！！");
		return SUCCESS;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
}
