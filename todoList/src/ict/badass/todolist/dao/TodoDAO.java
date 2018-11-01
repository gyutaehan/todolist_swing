package ict.badass.todolist.dao;

import java.util.List;

import ict.badass.todolist.vo.Todo;
import ict.badass.todolist.vo.User;

public interface TodoDAO {
	int addTodo(Todo todo) throws Exception;
	int removeTodo(String todoNo) throws Exception;
	int updateTodo(Todo todo) throws Exception;
	Todo getTodo(String todoNo) throws Exception;
	List<Todo> getTodoList(Todo todo) throws Exception;
	List<Todo> getTodoListUsers(String userNo) throws Exception;
}
