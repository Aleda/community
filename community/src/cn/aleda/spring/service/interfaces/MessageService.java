package cn.aleda.spring.service.interfaces;

import java.util.List;

import cn.aleda.hibernate.entity.Message;

public interface MessageService {
	public void addMessage(Message message);
	public void deleteMessage(Message message);
	public List<Message> loadMessage(String receive_name);
	public void updateMessage(String send_name, String receive_name, String message);
}
