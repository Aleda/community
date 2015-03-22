package cn.aleda.spring.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.aleda.hibernate.entity.Message;
import cn.aleda.spring.service.interfaces.MessageService;

public class testformessage {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src\\applicationContext.xml");
		MessageService service = (MessageService) context.getBean("messageService");
		/*Message message = new Message();
		Timestamp tt = new Timestamp(new Date().getTime());
		System.out.println("create_time = " + tt);
		message.setId(1);
		message.setSend_name("aleda");
		message.setReceive_name("monique");
		message.setCreate_time(tt);
		service.addMessage(message);
		service.deleteMessage(message);
		System.out.println("I think I will win!");*/
		service.updateMessage("monique", "aleda", "I love you!");
		List<Message> messages = service.loadMessage("aleda");
		for (Message message: messages) {
			System.out.println("message = " + message.getMessage());
			System.out.println("isread = " + message.isIsread());
		}
		System.out.println("???");
//		come on!!~, 
	}
}
