package ict.badass.todolist.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ict.badass.todolist.service.TodoManagerImpl;
import ict.badass.todolist.vo.Todo;
import ict.badass.todolist.vo.User;

public class TodoListHandler implements ActionListener, MouseListener {
	private ToDoList todoFrame;
	private TodoManagerImpl manager;
	private User user;
	private Object[] data;
	private DefaultTableModel model;
	private ImageIcon icon;
	private SimpleDateFormat format;
	private Object[][] row;
	private List<Todo> list;
	

	public TodoListHandler(ToDoList todo, User user) throws Exception{
		super();
		this.user = user;
		this.todoFrame = todo;
		this.manager = new TodoManagerImpl(user);
		data = todo.data;
		model = todo.model;
		row = new Object[99999][2];
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource() == todoFrame.btnExit) {
	         
	         int ans = JOptionPane.showConfirmDialog(todoFrame, "종료하겠습니까?", "종료확인창", JOptionPane.YES_NO_OPTION, 
	               JOptionPane.PLAIN_MESSAGE);
	         if(ans==0) {
	            JOptionPane.showMessageDialog(null, "종료되었습니다.");
	            System.exit(0);
	         }

		}else if(e.getSource() == todoFrame.btnAddTask) {
			Todo tempTodo = null;
			format = new SimpleDateFormat("yyyy년 MM월 dd일");
			String todo = todoFrame.txtToDo.getText();
			Date date = todoFrame.dateChooser.getDate();
			String date_tbl = format.format(todoFrame.dateChooser.getDate());
			
			data[0] = todo;
			data[1] = date_tbl;
			model.addRow(data);
			tempTodo = new Todo(todo, date, user.getUserNo());
			try {
				manager.addTodo(tempTodo);
				manager.reTodoList();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			todoFrame.txtToDo.setText("");
			
		}else if(e.getSource() == todoFrame.btnDelete) {
			if(todoFrame.selectedTableRow >= 0) {
				model.removeRow(todoFrame.selectedTableRow);
				try {
					manager.removeTodo(manager.getTodoListUsers().get(todoFrame.selectedTableRow).getTodoNo());
					manager.reTodoList();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "삭제할 대상이 존재하지 않습니다.");
			}
			todoFrame.txtToDo.setText("");
			todoFrame.selectedTableRow = -1;
			
		}else if(e.getSource() == todoFrame.btnUpdate) {
			
			format = new SimpleDateFormat("yyyy년 MM월 dd일");
			try {
				List<Todo> list2 = manager.reTodoList();
				model.setNumRows(0);
				for(int i =0; i<list2.size(); i++) {
					row[i][0] = list2.get(i).getTodo();
					row[i][1] = format.format(list2.get(i).getTodoDate());
					model.addRow(row[i]);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			format = new SimpleDateFormat("HH:mm:ss");
			todoFrame.lblTime.setText(format.format(Calendar.getInstance().getTime())+" 새로고침 완료");

		}else if(e.getSource() == todoFrame.btnLogout) {
			todoFrame.dispose();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					icon = new ImageIcon("main.png");
					try {
						Login frame = new Login();
						frame.setVisible(true);
						frame.setIconImage(icon.getImage());
						frame.setLocationRelativeTo(null);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == todoFrame.tblToDo) {
			try {
				todoFrame.txtToDo.setText(model.getValueAt(todoFrame.selectedTableRow, 0).toString());
				todoFrame.dateChooser.setDate(manager.getTodoListUsers().get(todoFrame.selectedTableRow).getTodoDate());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == todoFrame.tblToDo) {
			todoFrame.selectedTableRow = todoFrame.tblToDo.getSelectionModel().getLeadSelectionIndex();
			if(e.getClickCount() == 2 ) {
				try {
					String todo = todoFrame.txtToDo.getText();
					Date date = todoFrame.dateChooser.getDate();
					
					Todo tempTodo = null;
					tempTodo = new Todo(manager.getTodoListUsers().get(todoFrame.selectedTableRow).getTodoNo(), todo, date);
					TodoUpdate up = new TodoUpdate(tempTodo,user,model,todoFrame.selectedTableRow);
					//up.setUndecorated(true);
					up.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
