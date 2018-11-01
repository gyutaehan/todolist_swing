package ict.badass.todolist.gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import ict.badass.todolist.service.UserManagerImpl;
import java.awt.Toolkit;


public class Register extends JFrame {

	protected JPanel contentPane,panel,panel_1;
	protected JTextField txtEmail;
	protected JTextField txtId;
	protected JPasswordField txtPassword;
	protected UserManagerImpl manager;
	protected JRootPane jRootPane;
	protected JLabel label,lblRegister,lblEmail,lblId,lblPassword,lblAlready;
	protected JButton btnCreateYourAccount,btnLogin;
	private RegisterHandler registerHandler;

	


	public Register() throws Exception{
		manager = new UserManagerImpl();
		contentPane = new JPanel();	
		label = new JLabel("My ToDoList");
		lblRegister = new JLabel("Register");
		lblEmail = new JLabel("E-mail");
		txtEmail = new JTextField();
		lblId = new JLabel("Id");
		txtId = new JTextField();
		lblPassword = new JLabel("Password");
		txtPassword = new JPasswordField();
		btnCreateYourAccount = new JButton("Create your account");
		btnLogin = new JButton("Login");
		lblAlready = new JLabel("Already have an account?");
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		registerHandler = new RegisterHandler(this);
		launchFrame();
		jRootPane = SwingUtilities.getRootPane(btnCreateYourAccount);
		jRootPane.setDefaultButton(btnCreateYourAccount);
	}
	
	
	private void launchFrame() {
		setTitle("My ToDoList");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 500);
		
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		label.setForeground(new Color(255, 108, 108));
		label.setFont(new Font("Segoe UI", Font.BOLD, 28));
		label.setBounds(131, 0, 176, 40);
		
		lblRegister.setForeground(new Color(255, 108, 108));
		lblRegister.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblRegister.setBounds(36, 66, 165, 43);
		
		lblEmail.setForeground(new Color(255, 126, 126));
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblEmail.setBounds(83, 119, 57, 15);
		
		txtEmail.setColumns(10);
		txtEmail.setBounds(103, 144, 239, 21);
		
		txtId.setColumns(10);
		txtId.setBounds(104, 215, 238, 21);
		
		lblId.setForeground(new Color(255, 126, 126));
		lblId.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblId.setBounds(83, 188, 57, 15);
		
		lblPassword.setForeground(new Color(255, 126, 126));
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblPassword.setBounds(83, 260, 84, 15);
		
		txtPassword.setColumns(10);
		txtPassword.setBounds(104, 285, 238, 21);
		
		btnCreateYourAccount.setForeground(Color.WHITE);
		btnCreateYourAccount.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCreateYourAccount.setBorderPainted(false);
		btnCreateYourAccount.setBackground(new Color(255, 108, 108));
		btnCreateYourAccount.setBounds(103, 337, 239, 30);
		btnCreateYourAccount.addActionListener(registerHandler);
				
		btnLogin.addActionListener(registerHandler);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnLogin.setBorderPainted(false);
		btnLogin.setBackground(new Color(255, 108, 108));
		btnLogin.setBounds(260, 411, 103, 30);
		
		lblAlready.setForeground(new Color(255, 126, 126));
		lblAlready.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblAlready.setBounds(36, 411, 212, 21);
		
		panel.setBorder(new LineBorder(Color.PINK, 2));
		panel.setBounds(24, 45, 383, 339);
		panel.setLayout(null);
		panel_1.setBorder(new LineBorder(Color.PINK, 2));
		panel_1.setBounds(24, 394, 383, 58);
		panel_1.setLayout(null);
		
		contentPane.add(label);
		contentPane.add(lblRegister);
		contentPane.add(lblEmail);
		contentPane.add(txtEmail);
		contentPane.add(txtId);
		contentPane.add(lblId);
		contentPane.add(lblPassword);
		contentPane.add(txtPassword);
		contentPane.add(btnCreateYourAccount);
		contentPane.add(btnLogin);
		contentPane.add(lblAlready);
		contentPane.add(panel);
		contentPane.add(panel_1);
		
		setContentPane(contentPane);
	}
}
				
