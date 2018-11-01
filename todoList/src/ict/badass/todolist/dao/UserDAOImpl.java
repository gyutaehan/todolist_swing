package ict.badass.todolist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ict.badass.todolist.gui.TestUtil;
import ict.badass.todolist.vo.Todo;
import ict.badass.todolist.vo.User;

public class UserDAOImpl implements UserDAO{
	
	SqlSession session;

	public UserDAOImpl() throws Exception {
		super();
		SqlSessionFactory factory= TestUtil.getSqlSessionFactory();
		SqlSession session = factory.openSession();
	
		this.session = session;
	}

	@Override
	public int addUser(User user) throws Exception {
		int result = 0;
		
		try {
			SqlSessionFactory factory= TestUtil.getSqlSessionFactory();
			SqlSession session = factory.openSession();
			this.session = session;
			result = session.insert("userMapper.addUser",user);
			session.commit();
			
		} finally {
			if(session != null) session.close();
		}
		return result;
	}

	@Override
	public int removeUser(String userno) throws Exception {
		int result = 0;
		try {
			SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
			SqlSession session = factory.openSession();
			this.session = session;
			result =  session.delete("userMapper.removeUser",userno);
			session.commit();
		} finally {
		if(session!=null)session.close();
		
		}
		return result;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int result  = 0;
		
		try {
			SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
			SqlSession session = factory.openSession();
			this.session = session;
			result = session.update("userMapper.updateUser",user);
			session.commit();
		} finally {
			if(session!=null)session.close();
		}
		return result;
	}

	
	
	@Override
	public User getUser(User user) throws Exception {
		User result = null;
		
		try {
			SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
			SqlSession session = factory.openSession();
			result = session.selectOne("userMapper.getUser",user);
			this.session = session;
			session.commit();
		
		} finally {
			if(session!=null)session.close();
		}
		return result;
		
	}

	@Override
	public List<User> getUserList() throws Exception {
		List<User> result = null;
		try {
			SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
			SqlSession session =  factory.openSession();
			result = session.selectList("userMapper.getUserList");
			this.session = session;
			session.commit();
			
		} finally {
			if(session!=null)session.close();
		}
		
		return result;
	}

}
