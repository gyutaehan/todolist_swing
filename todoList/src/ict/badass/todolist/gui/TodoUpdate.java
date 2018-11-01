/*
 * Created by JFormDesigner on Wed May 16 00:58:32 KST 2018
 */

package ict.badass.todolist.gui;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.*;

import ict.badass.todolist.service.TodoManagerImpl;
import ict.badass.todolist.vo.Todo;
import ict.badass.todolist.vo.User;

/**
 * @author gyutae Han
 */
public class TodoUpdate extends JFrame{
	protected Todo currentTodo;
	protected TodoUpdateHandler todoHandler;
	protected TodoManagerImpl manager;
	protected User user;
	protected DefaultTableModel model;
	protected int selectedTableRow;
	
	
	
	
    public Todo getCurrenttodo() {
		return currentTodo;
	}

	public void setCurrenttodo(Todo currentTodo) {
		this.currentTodo = currentTodo;
	}

	public TodoUpdate(Todo currentTodo, User user,DefaultTableModel model,int selectedTableRow) throws Exception {
    	todoHandler  = new TodoUpdateHandler(this);
    	this.currentTodo = currentTodo;
    	this.user = user;
    	this.manager = new TodoManagerImpl(user);
    	this.model = model;
    	this.selectedTableRow = selectedTableRow;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - gyutae Han
    	todo = new JTextField();
    	date = new JDateChooser();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(todo);
        todo.setBounds(0, 0, 265, 45);
        contentPane.add(date);
        date.setBounds(265, 0, 132, 45);
        todo.setText(currentTodo.getTodo());
        date.setDate(currentTodo.getDate());


        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        addKeyListener(todoHandler);
        todo.addKeyListener(todoHandler);
        date.addKeyListener(todoHandler);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - gyutae Han
    protected JTextField todo;
    protected JDateChooser date;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
