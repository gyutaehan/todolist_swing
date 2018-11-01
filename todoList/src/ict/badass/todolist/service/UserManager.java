package ict.badass.todolist.service;

import ict.badass.todolist.vo.User;

public interface UserManager {
	public User searchUser(User user) throws Exception;
	public User tryLogin(User user) throws Exception;
	public int createUser(String email, String username, String password) throws Exception;
}
