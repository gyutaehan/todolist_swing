package ict.badass.todolist.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import ict.badass.todolist.service.UserManagerImpl;
import ict.badass.todolist.vo.User;
import java.awt.Toolkit;

public class Login extends JFrame {

	protected JPanel contentPane, panel;
	protected JTextField txtId;
	protected JPasswordField txtPassword;
	protected JLabel lblMyToDoList, lblLogin;
	protected JLabel lblId, lblPassword;
	protected UserManagerImpl manager;
	protected JRootPane jRootPane;
	protected JButton btnLogin, btnRegister;
	private LoginHandler loginHandler;
	

	public Login() throws Exception{

		
		manager = new UserManagerImpl();
		contentPane = new JPanel();		
		lblMyToDoList = new JLabel("My ToDoList");	
		lblLogin = new JLabel("Login");
		lblId = new JLabel("Id");
		lblPassword = new JLabel("Password");
		txtId = new JTextField();
		txtId.setForeground(Color.DARK_GRAY);
		txtPassword = new JPasswordField();
		txtPassword.setForeground(Color.DARK_GRAY);
		btnLogin = new JButton("Login");
		btnRegister = new JButton("Register");		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		loginHandler = new LoginHandler(this);
		launchFrame();
		jRootPane = SwingUtilities.getRootPane(btnLogin);
		jRootPane.setDefaultButton(btnLogin);
	}
	
	private void launchFrame() {
		setTitle("My ToDoList");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 400, 400);
		
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		lblMyToDoList.setFont(new Font("Segoe UI", Font.BOLD, 28));
		lblMyToDoList.setForeground(new Color(255, 108, 108));
		lblMyToDoList.setBounds(101, 0, 176, 47);
		
		lblLogin.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblLogin.setForeground(new Color(255, 108, 108));
		lblLogin.setBounds(41, 57, 78, 43);
		
		lblId.setForeground(new Color(255, 126, 126));
		lblId.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblId.setBounds(78, 110, 57, 15);
		
		txtId.setBounds(91, 136, 203, 21);
		txtId.setColumns(10);
		
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblPassword.setForeground(new Color(255, 126, 126));
		lblPassword.setBounds(78, 183, 78, 15);
		
		txtPassword.setBounds(91, 212, 203, 21);
		txtPassword.setColumns(10);
		
		btnLogin.setBackground(new Color(255, 108, 108));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBorderPainted(false);
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnLogin.addActionListener(loginHandler);
		btnLogin.setBounds(101, 254, 179, 32);
		
		
		btnRegister.setBackground(new Color(255, 108, 108));
		btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setBorderPainted(false);
		btnRegister.addActionListener(loginHandler);
		btnRegister.setBounds(101, 320, 179, 32);
		
		panel.setBorder(new LineBorder(Color.PINK, 2));
		panel.setBounds(12, 46, 360, 257);
		panel.setLayout(null);
		
		
		contentPane.add(lblMyToDoList);
		contentPane.add(lblLogin);
		contentPane.add(lblId);
		contentPane.add(lblPassword);
		contentPane.add(txtId);
		contentPane.add(txtPassword);
		contentPane.add(btnLogin);
		contentPane.add(btnRegister);
		contentPane.add(panel);
		setContentPane(contentPane);
	}
	
}
