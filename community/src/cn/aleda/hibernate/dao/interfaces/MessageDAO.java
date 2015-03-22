package cn.aleda.hibernate.dao.interfaces;

import java.util.List;

import cn.aleda.hibernate.entity.Message;

public interface MessageDAO {
	public void save(Message message);
	public List<Message> load(String receive_name);
	public void delete(Message message);
	public void update(String send_name, String receive_name, String message);
}
