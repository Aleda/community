package cn.aleda.spring.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.aleda.hibernate.entity.Article;
import cn.aleda.hibernate.entity.User;
import cn.aleda.spring.service.interfaces.ArticleService;
import cn.aleda.spring.service.interfaces.UserService;

public class test {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src\\applicationContext.xml");
		/*
		UserService userService = (UserService) context.getBean("userService");*/
//		User user = userService.loadUser("aleda");
		
		/*System.out.println("name = " + user.getName());
		User user1 = new User();
		user1.setId(2);
		user1.setUsername("monique");
		user1.setName("Monique");
		try {
			userService.addUser(user1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*User user = new User();
		user.setUsername("aleda");
		if (userService.verifyUser(user)) {
			System.out.println("this user  were already exists!");
		}*/
		UserService userService = (UserService) context.getBean("userService");
		/*Session session = HibernateSessionFactory.getSession();
		String hql = "from MyMessage";
		Query query = session.createQuery(hql);
		List<MyMessage> messages = query.list();
		for (MyMessage message: messages) {
			System.out.println("id = " + message.getId());
			System.out.println("name = " + message.getName());*/
		User user = userService.loadUser("aleda");
		User user1 = new User();
		user1.setId(2);
		user1.setUsername("monique");
		user1.setPassword("lishuo1992");
		try {
			userService.addUser(user1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(userService.verifyUser(user1));
		System.out.println(user.getUsername());
		System.out.println("?");
		
	}
}
