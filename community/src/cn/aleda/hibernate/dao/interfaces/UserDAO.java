package cn.aleda.hibernate.dao.interfaces;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.aleda.hibernate.entity.User;

public interface UserDAO {
	public User load(String username);
	public void save(User user);
	public boolean exists(User user);
	public String getPasswordmd5(String username);
	public List<User> loadAll();
}
