package cn.aleda.struts2.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import cn.aleda.hibernate.entity.Article;
import cn.aleda.spring.service.ServiceManager;
import cn.aleda.spring.service.interfaces.ArticleService;

import com.opensymphony.xwork2.ActionSupport;


public class DeleteArticlesAction extends ActionSupport implements
		ServletRequestAware {
	private HttpServletRequest request;
	private String articlesName;
	private ServiceManager serviceManager;
	
	public String execute() throws Exception {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		System.out.println("____" + articlesName);
		String utf8 = new String(articlesName.getBytes("iso-8859-1"), "utf-8");
		System.out.println("utf_8 = " + utf8);
		String[] articles = utf8.split(", ");
		ArticleService service = serviceManager.getArticleService();
		for (int i = 0; i < articles.length; i++) {
			Article ar = service.loadArticle(username, articles[i]);
			service.deleteArticle(ar);
		}
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getArticlesName() {
		return articlesName;
	}

	public void setArticlesName(String articlesName) {
		this.articlesName = articlesName;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}
	
}
