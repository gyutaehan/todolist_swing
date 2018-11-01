package ict.badass.todolist.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import ict.badass.todolist.service.UserManagerImpl;
import ict.badass.todolist.vo.User;

public class LoginHandler implements ActionListener{
	private Login login;
	private UserManagerImpl manager;
	private User loginUser;
	private ImageIcon icon;
	

	public LoginHandler(Login login) throws Exception{
		super();
		this.login = login;
		manager = new UserManagerImpl();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == login.btnLogin) {
			String id = login.txtId.getText();
			String password = new String(login.txtPassword.getPassword());
			User user = new User();
			user.setUserId(id);
			user.setPassword(password);
			
			try {
				loginUser = manager.tryLogin(user);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			if(loginUser != null){
				 login.dispose();
				 EventQueue.invokeLater(new Runnable() {
						public void run() {
							icon = new ImageIcon("main.png");
							try {
								ToDoList frame = new ToDoList(loginUser);
								frame.setVisible(true);
								frame.setIconImage(icon.getImage());
								frame.setLocationRelativeTo(null);	
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
				});	
			}else{
				JOptionPane.showMessageDialog(null,"아이디 또는 비밀번호가 맞지 않습니다.");
			}
		}
		
		else if(e.getSource() == login.btnRegister) {
			login.dispose();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					icon = new ImageIcon("main.png");
					try {
						Register frame = new Register();
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
}
