package ict.badass.todolist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ict.badass.todolist.gui.TestUtil;
import ict.badass.todolist.vo.Todo;

public class TodoDAOImpl implements TodoDAO{
	
	SqlSession session;
	

	
	@Override
	public int addTodo(Todo todo) throws Exception {
		int result = 0;
		
		try {
			SqlSessionFactory factory= TestUtil.getSqlSessionFactory();
			SqlSession session = factory.openSession();
			this.session = session;
			result = session.insert("todoMapper.addTodo",todo);
			session.commit();
		} finally {
			if(session != null) session.close();
		}
		
		return result;
	}

	@Override
	public int removeTodo(String todono) throws Exception {
		int result=0;
		
		try {
			SqlSessionFactory factory= TestUtil.getSqlSessionFactory();
			SqlSession session = factory.openSession();
			this.session = session;
			result = session.delete("todoMapper.removeTodo",todono);
			session.commit();
		} finally {
			if(session != null) session.close();
		}
		return result;
	}

	@Override
	public int updateTodo(Todo todo) throws Exception {
		int result = 0;
		try {
			SqlSessionFactory factory= TestUtil.getSqlSessionFactory();
			SqlSession session = factory.openSession();
			this.session = session;
			result =  session.update("todoMapper.updateTodo",todo);
			session.commit();
		} finally {
			if(session != null) session.close();
		}

		return result;
	}

	@Override
	public Todo getTodo(String todono) throws Exception {
		Todo result = null;
		try {
			SqlSessionFactory factory= TestUtil.getSqlSessionFactory();
			SqlSession session = factory.openSession();
			this.session = session;
			result = session.selectOne("todoMapper.getTodo",todono);
		} finally {
			if(session != null) session.close();
		}
		return result;
	}

	@Override
	public List<Todo> getTodoList(Todo todo) throws Exception {
		List<Todo> result = null;
		
		try {
			SqlSessionFactory factory= TestUtil.getSqlSessionFactory();
			SqlSession session = factory.openSession();
			this.session = session;
			result= session.selectList("todoMapper.getTodoList",todo); 
		} finally {
			if(session != null) session.close();
		}
		return result;
	}


	@Override
	public List<Todo> getTodoListUsers(String userNo) throws Exception {
		List<Todo> result = null;
		try {
			SqlSessionFactory factory= TestUtil.getSqlSessionFactory();
			SqlSession session = factory.openSession();
			this.session = session;
			result = session.selectList("todoMapper.getTodoListUsers", userNo);
		} finally {
			if(session != null) session.close();
		}

		return result;
	}

}
