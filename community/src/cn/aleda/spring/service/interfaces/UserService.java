package cn.aleda.spring.service.interfaces;

import java.util.List;

import cn.aleda.hibernate.entity.User;

public interface UserService {
	public void addUser(User user) throws Exception;
	public User loadUser(String username);
	public boolean verifyUser(User user);
	public List<User> loadAllUsers();
}
