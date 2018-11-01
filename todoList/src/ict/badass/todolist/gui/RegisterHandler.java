package ict.badass.todolist.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import ict.badass.todolist.service.UserManagerImpl;
import ict.badass.todolist.vo.User;

public class RegisterHandler implements ActionListener{
	private Register register;
	private UserManagerImpl manager;
	private ImageIcon icon;
	
	public RegisterHandler(Register register) throws Exception{
		super();
		this.register = register;
		this.manager = new UserManagerImpl();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == register.btnCreateYourAccount) {
			User user = new User();
			
			String email = register.txtEmail.getText();
			String id = register.txtId.getText();
			String password = new String(register.txtPassword.getPassword());
			
			if(email.equals("") || id.equals("") || password.equals("")) {
				JOptionPane.showMessageDialog(null, "�ʼ� �Է¶��� ��� �Է��ϼ���.");
			}
			else {
				user.setEmail(email);
				user.setUserId(id);
				try {
					if(manager.searchUser(user) != null){
						JOptionPane.showMessageDialog(null, "�̸��϶Ǵ� ���̵� �ߺ��Ǿ����ϴ�.");
					}else{
						manager.createUser(email, id, password);
						JOptionPane.showMessageDialog(null, "ȸ������ �Ǿ����ϴ�.");
						register.dispose();
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									icon = new ImageIcon("main.png");
									Login frame = new Login();
									frame.setVisible(true);
									frame.setIconImage(icon.getImage());
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
		}
		else if(e.getSource() == register.btnLogin) {
			register.dispose();
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
	
	
	
	

}
