package cn.aleda.hibernate.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.aleda.hibernate.dao.interfaces.UserDAO;
import cn.aleda.hibernate.entity.User;

public class UserDAOImpl extends DAOSupport implements UserDAO {

	public UserDAOImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
		System.out.println("UserDAOImpl~~");
	}

	public void save(User user) {
		hibernateTemplate.save(user);
	}

	public boolean exists(User user) {
		String hql = "from User where username = ?";
		List<User> users = hibernateTemplate.find(hql, user.getUsername()); //天哪，这里我都能写错啊啊啊
		/*
		for (User tuser: users) {
			System.out.println("username = " + tuser.getUsername());
		}
		*/
		if (users.size() > 0) {
			return true;
		}
		return false;
	}

	public String getPasswordmd5(String username) {
		String hql = "select password_md5 from User where username = ?";
		List<String> password = hibernateTemplate.find(hql, username);
		if (password.size() > 0) {
			return password.get(0);
		}
		return null;
	}

	public User load(String username) {
		String hql = "from User where username = ?";
		List<User> users = hibernateTemplate.find(hql, username); //天哪，这里我都能写错啊啊啊
		if (users.size() > 0) {
			return users.get(0);
		}
		System.out.println("上面有没有执行hibernate语句呢？");
		return null;
	}

	public List<User> loadAll() {
		String hql = "from User";
		return hibernateTemplate.find(hql);
	}
	
}
