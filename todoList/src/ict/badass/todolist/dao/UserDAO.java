package ict.badass.todolist.dao;

import java.util.List;

import ict.badass.todolist.vo.User;


public interface UserDAO {
	int addUser(User user) throws Exception;
	int removeUser(String userNo) throws Exception;
	int updateUser(User user) throws Exception;
	User getUser(User user) throws Exception;
	List<User> getUserList() throws Exception;
}
