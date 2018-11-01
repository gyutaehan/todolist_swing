package ict.badass.todolist.service;

import java.util.List;


import ict.badass.todolist.dao.TodoDAOImpl;
import ict.badass.todolist.vo.Todo;
import ict.badass.todolist.vo.User;

public class TodoManagerImpl implements TodoManager{
	List<Todo> todoList;
	TodoDAOImpl dao;
	User user;

	
	public List<Todo> reTodoList() throws Exception {
		todoList = dao.getTodoListUsers(user.getUserNo());
		return todoList;
	}

	public TodoManagerImpl(User user) throws Exception {
		super();
		dao = new TodoDAOImpl();		
		todoList = dao.getTodoListUsers(user.getUserNo());
		
		this.user = user;
	}
	
	public void addTodo(Todo todo) throws Exception {
		dao.addTodo(todo);
	}

	public void updateTodo(Todo todo) throws Exception {
		dao.updateTodo(todo);
	}
	
	public void removeTodo(String todoNo) throws Exception {
		dao.removeTodo(todoNo);
	}

	@Override
	public List<Todo> getTodoListUsers() {
		return todoList;
	}
	
}