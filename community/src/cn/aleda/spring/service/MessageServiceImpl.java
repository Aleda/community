package cn.aleda.spring.service;

import java.util.List;

import cn.aleda.hibernate.dao.interfaces.MessageDAO;
import cn.aleda.hibernate.entity.Message;
import cn.aleda.spring.service.interfaces.MessageService;

public class MessageServiceImpl implements MessageService {

	private MessageDAO messageDAO;
	
	public MessageServiceImpl(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

	public void addMessage(Message message) {
		messageDAO.save(message);
	}

	public void deleteMessage(Message message) {
		messageDAO.delete(message);
	}

	public List<Message> loadMessage(String receive_name) {
		return messageDAO.load(receive_name);
	}

	public void updateMessage(String send_name, String receive_name,
			String message) {
		messageDAO.update(send_name, receive_name, message);
		return ;
	}
}
