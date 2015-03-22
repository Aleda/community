package cn.aleda.spring.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.aleda.hibernate.entity.Article;
import cn.aleda.spring.service.interfaces.ArticleService;

public class testforarticle {
	public static void main(String[] args) {
/*		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src\\applicationContext.xml");
		ArticleService articleService = (ArticleService) context.getBean("articleService");
		int id = 2;
		if (articleService.existsArticle(id)) {
			System.out.println("Yes, it exists!");
		} else {
			System.out.println("No, it not exists!");
		}*/
		Timestamp tt = new Timestamp(new Date().getTime());
		System.out.println("time = " + tt);
	}
}
