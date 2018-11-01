package unitTest;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ict.badass.todolist.gui.TestUtil;
import ict.badass.todolist.vo.Todo;
import ict.badass.todolist.vo.User;

public class UnitTest {

	public static void main(String[] args) throws Exception{
		TestUtil util = new TestUtil();
		
		SqlSessionFactory factory = util.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		User user = new User("email3","id3","password");
		
		

/*		session.insert("todoMapper.addTodo",todo);
		session.commit();*/
		
/*		session.delete("todoMapper.removeTodo","6");
		session.commit();*/
		
/*		session.update("todoMapper.updateTodo","");
		session.commit();
		System.out.println("update 실행"+" "+ todo.getTodo());*/
		
/*		Todo todo2 =session.selectOne("todoMapper.getTodo","8");
		session.commit();
		System.out.println("select 실행"+" "+ todo.getTodo());*/
		
		List<Todo> todoList1 =session.selectList("todoMapper.getTodoList");
		session.commit();
		System.out.println("select 실행"+" "+ todoList1);
		
/*		session.insert("userMapper.addUser",user);
		session.commit();*/

/*		session.delete("userMapper.removeUser","5");
		session.commit();*/
		
/*		session.update("userMapper.updateUser","4");
		session.commit();*/
		
/*		User user2 = session.selectOne("userMapper.getUser","12");
		session.commit();
		System.out.println("select 실행됨"+""+user2.getUserId());*/
		
		List<User> user2 = session.selectList("userMapper.getUserList");
		session.commit();
		System.out.println("selectALL 실행됨"+user2);
		
		
	}

}
