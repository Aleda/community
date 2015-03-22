package cn.aleda.spring.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.aleda.hibernate.entity.Website;
import cn.aleda.spring.service.interfaces.WebsiteService;

public class testforsite {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src\\applicationContext.xml");
		WebsiteService websiteService = (WebsiteService)context.getBean("websiteService");
		Website website = new Website();
		List<Website> sites = websiteService.loadSites("monique");
		for (Website site: sites) {
			System.out.println("id = " + site.getId());
			System.out.println("username = " + site.getUser_name());
			System.out.println("site_name = " + site.getSite_name());
			System.out.println("site = " + site.getWebsite());
		} 
		/*if (websiteService.existsSite("aleda", "www.aleda.cn")) {
			System.out.println("存在！！~");
			websiteService.deleteSite(website);
			System.out.println("已经删除");
		} else {
			System.out.println("不存在！！~");
		}*/
		int id = websiteService.queryID("aleda", "www.baidu.com");
		website.setId(id);
		System.out.println("id = " + id);
		websiteService.deleteSite(website);
		System.out.println("shanchu?");
	}
}
