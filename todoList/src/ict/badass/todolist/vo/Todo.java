package ict.badass.todolist.vo;

import java.util.Date;

public class Todo {
	String todoNo;
	String todo;
	Date todoDate; 
	String todoCompl; 
	String userNo; 
	
	public Todo() {
		super();
	}
	public Todo(String todoNo, String todo, Date todoDate) {
		super();
		this.todoNo = todoNo;
		this.todo = todo;
		this.todoDate = todoDate;	
	}
	public Todo(String todo, Date todoDate, String userNo) {
		super();
		this.todo = todo;
		this.todoDate = todoDate;
		this.userNo = userNo;
	}
	public Todo(String todoNo, String todo,Date todoDate, String todoCompl, String userNo) {
		super();
		this.todoNo = todoNo;
		this.todo = todo;
		this.todoDate = todoDate;
		this.todoCompl = todoCompl;
		this.userNo = userNo;
	}
	public String getTodoNo() {
		return todoNo;
	}
	public void setTodoNo(String todoNo) {
		this.todoNo = todoNo;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public Date getDate() {
		return todoDate;
	}
	public void setDate(Date todoDate) {
		this.todoDate = todoDate;
	}
	public String getTodoCompl() {
		return todoCompl;
	}
	public void setTodoCompl(String todoCompl) {
		this.todoCompl = todoCompl;
	}
	public Date getTodoDate() {
		return todoDate;
	}
	public void setTodoDate(Date todoDate) {
		this.todoDate = todoDate;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	@Override
	public String toString() {
		return "Todo [todoNo=" + todoNo + ", todo=" + todo + ", todoDate=" + todoDate + ", todoCompl=" + todoCompl
				+ ", userNo=" + userNo + "]";
	}
	
	

	
}
