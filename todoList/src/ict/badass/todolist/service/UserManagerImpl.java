package ict.badass.todolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ict.badass.todolist.dao.UserDAOImpl;
import ict.badass.todolist.gui.TestUtil;
import ict.badass.todolist.vo.User;

public class UserManagerImpl implements UserManager{
	List<User> userList;
	UserDAOImpl dao;

	public UserManagerImpl() throws Exception{
		super();
		dao = new UserDAOImpl();
		userList = dao.getUserList();
	}

	@Override
	public User searchUser(User user) throws Exception{
		for(User u : userList) {
			if(u.getEmail().equals(user.getEmail()) || u.getUserId().equals(user.getUserId())) {
				return u;
			}
		}
		return null;
	}
	
	@Override
	public User tryLogin(User user) throws Exception {
		for(User u : userList) {
			if(u.getUserId().equals(user.getUserId()) && u.getPassword().equals(user.getPassword())) {
				return u;
			}
		}
		return null;
	}
	
	@Override
	public int createUser(String email, String username, String password) throws Exception {
		User user = new User();
		user.setEmail(email);
		user.setUserId(username);
		user.setPassword(password);
		return dao.addUser(user);
	}
}
