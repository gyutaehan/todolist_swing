package ict.badass.todolist.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;

import ict.badass.todolist.service.TodoManagerImpl;
import ict.badass.todolist.vo.Todo;
import ict.badass.todolist.vo.User;

public class ToDoList extends JFrame {

	protected JPanel contentPane,panel,panel2;
	protected JTable tblToDo;
	protected JTextField txtToDo;
	protected TodoManagerImpl manager;
	protected int selectedTableRow = -1;
	protected JRootPane jRootPane;
	protected JLabel lblTask,label,lblDate,lblToDo,lblTime;
	protected JButton btnExit, btnLogout, btnUpdate, btnDelete, btnAddTask;
	protected JScrollPane scrollPane;
	protected JDateChooser dateChooser;
	protected List<Todo> list;
	protected Object[][] row;
	protected final String[] columnNames = {" To Do " , " Date "};
	protected Object[] data ;
	protected DefaultTableModel model;
	protected SimpleDateFormat format;
	protected TableCellRenderer renderer;
	private TodoListHandler todoListHandler;

	public ToDoList(User user) throws Exception {
		manager = new TodoManagerImpl(user);
		contentPane = new JPanel();
		label = new JLabel("My ToDoList");
		label.setFont(new Font("Arial", Font.BOLD, 28));
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		lblTask = new JLabel("The task of the day");
		btnExit = new JButton("Exit");
		panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		txtToDo = new JTextField();
		lblDate = new JLabel("Date");
		lblToDo = new JLabel("To Do");
		scrollPane = new JScrollPane();
		list = manager.getTodoListUsers();
		row = new Object[list.size()][2];
		tblToDo = new JTable();
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		dateChooser = new JDateChooser(new Date());
		data = new Object[2];
		renderer = new MyTableCellRenderer();
		btnAddTask = new JButton("Add Task");
		lblTime = new JLabel("");

		btnDelete = new JButton("Delete");
		btnUpdate = new JButton("Update");
		btnLogout = new JButton("Logout");
		todoListHandler = new TodoListHandler(this,user);
		launchFrame();
		jRootPane = SwingUtilities.getRootPane(btnAddTask);
		jRootPane.setDefaultButton(btnAddTask);
		
	}
	
	
	private void launchFrame() throws Exception{
		setTitle("My ToDoList");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 650, 550);
		
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		label.setForeground(new Color(255, 108, 108));
		label.setBounds(225, 0, 176, 47);

		panel.setBorder(new LineBorder(Color.PINK, 2));
		panel.setBounds(12, 45, 610, 320);
		panel.setLayout(null);
		
		lblTask.setForeground(new Color(255, 108, 108));
		lblTask.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblTask.setBounds(12, 24, 178, 30);

		btnExit.addActionListener(todoListHandler);
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnExit.setBorderPainted(false);
		btnExit.setBackground(new Color(255, 108, 108));
		btnExit.setBounds(457, 278, 141, 30);

		panel2.setBorder(new LineBorder(Color.PINK, 2));
		panel2.setBounds(12, 369, 610, 133);
		panel2.setLayout(null);
		
		txtToDo.setBounds(94, 70, 351, 30);
		txtToDo.setColumns(10);
		
		lblDate.setForeground(new Color(255, 108, 108));
		lblDate.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblDate.setBounds(12, 18, 70, 30);

		lblToDo.setForeground(new Color(255, 108, 108));
		lblToDo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblToDo.setBounds(12, 68, 70, 30);

		scrollPane.setBounds(12, 52, 433, 256);
		
		model.setColumnIdentifiers(columnNames);
		format = new SimpleDateFormat("yyyy³â MM¿ù ddÀÏ");
		for(int i =0; i<list.size(); i++) {
			row[i][0] = list.get(i).getTodo();
			row[i][1] = format.format(list.get(i).getTodoDate());
			model.addRow(row[i]);
		}
		dateChooser.setDateFormatString("yyyy³â MM¿ù ddÀÏ");
		dateChooser.setBorder(new LineBorder(Color.PINK));
		dateChooser.setBounds(94, 18, 243, 30);
		
		tblToDo.setModel(model);
		tblToDo.setRowHeight(25);
		tblToDo.setFont(new Font("HY¿±¼­M", Font.PLAIN, 15));
		tblToDo.setDefaultRenderer(Class.forName("java.lang.Object"), renderer);
		tblToDo.addMouseListener(todoListHandler);
		
		
		scrollPane.setViewportView(tblToDo);
		
		btnAddTask.addActionListener(todoListHandler);
		btnAddTask.setForeground(Color.WHITE);
		btnAddTask.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAddTask.setBorderPainted(false);
		btnAddTask.setBackground(new Color(255, 108, 108));
		btnAddTask.setBounds(457, 69, 141, 30);
		
		btnDelete.addActionListener(todoListHandler);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(new Color(255, 108, 108));
		btnDelete.setBounds(457, 52, 141, 30);

		btnUpdate.addActionListener(todoListHandler);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBackground(new Color(255, 108, 108));
		btnUpdate.setBounds(457, 97, 141, 30);

		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnLogout.setBorderPainted(false);
		btnLogout.setBackground(new Color(255, 108, 108));
		btnLogout.setBounds(457, 239, 141, 30);
		btnLogout.addActionListener(todoListHandler);
		
		contentPane.add(label);
		contentPane.add(panel);
		
		panel.add(lblTask);
		panel.add(btnExit);
		panel.add(scrollPane);
		panel.add(btnDelete);
		panel.add(btnUpdate);
		panel.add(btnLogout);
		
		lblTime.setForeground(new Color(255, 108, 108));
		lblTime.setFont(new Font("HY¿±¼­M", Font.PLAIN, 11));
		lblTime.setBounds(457, 147, 141, 37);
		panel.add(lblTime);
		
		contentPane.add(panel2);
		
		panel2.add(txtToDo);
		panel2.add(lblDate);
		panel2.add(lblToDo);
		panel2.add(dateChooser);
		panel2.add(btnAddTask);

		setContentPane(contentPane);
	}
}

