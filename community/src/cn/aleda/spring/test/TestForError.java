package cn.aleda.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.aleda.hibernate.entity.User;
import cn.aleda.spring.service.interfaces.UserService;

public class TestForError {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src\\applicationContext.xml");
		UserService userService = (UserService)context.getBean("userService");
		User user = userService.loadUser("aleda");
		System.out.println("username = " + user.getUsername());
		System.out.println("id = " + user.getId());
	}
}
