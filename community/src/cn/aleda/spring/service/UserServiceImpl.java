package cn.aleda.spring.service;

import java.util.List;

import cn.aleda.common.Encrypter;
import cn.aleda.hibernate.dao.interfaces.UserDAO;
import cn.aleda.hibernate.entity.User;
import cn.aleda.spring.service.interfaces.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO;
	
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void addUser(User user) throws Exception {
		if (!userDAO.exists(user)) {
			//将密码改为md5存储，防止在数据库中导出的密码就可以让别人看到
			Encrypter en = new Encrypter();
			String password_md5 = en.md5Encrypt(user.getPassword());
			user.setPassword_md5(password_md5);
			userDAO.save(user);
		}
	}

	public User loadUser(String username) {
		try {
			return userDAO.load(username);
		} catch(Exception e) {
			System.out.println("抛出异常（loadUser）");
		}
		return null;
	}

	public boolean verifyUser(User user) {
		if (!userDAO.exists(user)) {
			return true;
		}
		return false;
	}

	public List<User> loadAllUsers() {
		return userDAO.loadAll();
	}

}
