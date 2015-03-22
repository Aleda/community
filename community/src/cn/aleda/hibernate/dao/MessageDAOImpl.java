package cn.aleda.hibernate.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.aleda.hibernate.dao.interfaces.MessageDAO;
import cn.aleda.hibernate.entity.Message;

public class MessageDAOImpl extends DAOSupport implements MessageDAO {

	public MessageDAOImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

	public void save(Message message) {
		hibernateTemplate.save(message);
	}

	public List<Message> load(String receive_name) {
		String hql = "from Message where receive_name = ? and isread = ?";
		Object[] args = {receive_name, 0};
		List<Message> messages = hibernateTemplate.find(hql, args);
		return messages;
	}

	public void delete(Message message) {
		hibernateTemplate.delete(message);
	}

	public void update(String send_name, String receive_name, String message) {
		String hql = "from Message where send_name = ? and receive_name = ? and message = ?";
		Object[] args = {send_name, receive_name, message};
		List<Message> messages = hibernateTemplate.find(hql, args);
		Message m = messages.get(0);
		m.setIsread(1);
		hibernateTemplate.update(m);
		return;
	}
	
}
