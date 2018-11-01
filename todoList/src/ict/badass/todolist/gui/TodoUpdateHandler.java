package ict.badass.todolist.gui;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.annotations.Update;

import ict.badass.todolist.vo.Todo;

public class TodoUpdateHandler implements KeyListener{
	private TodoUpdate updateFrame;
	private SimpleDateFormat format;
	

	public TodoUpdateHandler(TodoUpdate updateFrame) {
		super();
		this.updateFrame = updateFrame;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("keyTyped");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("keyPressed");
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			format = new SimpleDateFormat("yyyy³â MM¿ù ddÀÏ");
			String todo = updateFrame.todo.getText();
			Date date = updateFrame.date.getDate();
			String date_tbl = format.format(updateFrame.date.getDate());
			
			Todo tempTodo = updateFrame.getCurrenttodo();
			tempTodo.setTodo(todo);
			tempTodo.setDate(date);
			try {
					//System.out.println(date);
					updateFrame.manager.updateTodo(tempTodo);
				} catch (Exception e2) {
					e2.printStackTrace();
			}
			updateFrame.model.setValueAt(todo, updateFrame.selectedTableRow, 0);
			updateFrame.model.setValueAt(date_tbl, updateFrame.selectedTableRow, 1);
			updateFrame.dispose();
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("keyReleased");
	}

}
