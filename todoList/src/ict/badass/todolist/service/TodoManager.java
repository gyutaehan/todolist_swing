package ict.badass.todolist.service;

import java.util.Date;
import java.util.List;

import ict.badass.todolist.vo.Todo;

public interface TodoManager {
	public void addTodo(Todo todo) throws Exception;
	public void updateTodo(Todo todo) throws Exception;
	public void removeTodo(String todoNo) throws Exception;
	public List<Todo> getTodoListUsers() throws Exception;
}
