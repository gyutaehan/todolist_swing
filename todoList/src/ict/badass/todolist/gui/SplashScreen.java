package ict.badass.todolist.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;

public class SplashScreen extends JWindow{
	
	static JProgressBar progressBar = new JProgressBar();
	static int count = 1, TIMER_PAUSE = 25, PROGBAR_MAX = 50;
	static Timer progressBarTimer;
	ActionListener al = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			progressBar.setValue(count);
			if( PROGBAR_MAX == count){
				progressBarTimer.stop();
				SplashScreen.this.setVisible(false);
				loginFrameShow();
			}
			count++;
			
		}
	};
	
	public SplashScreen() throws Exception{
		Container container = getContentPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder());
		container.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("TODOLIST PROGRAM");
		
		label.setFont(new Font("Segoe UI", Font.BOLD, 28));
		panel.add(label);
		
		progressBar.setMaximum(PROGBAR_MAX);
		container.add(progressBar, BorderLayout.SOUTH);
		container.add(
				new JLabel(
						new ImageIcon
							("logo.png")));
		pack();
		setSize(600, 400);
		setLocation(500, 300);
		setVisible(true);
		startProgressBar();
	
	}
	private void startProgressBar(){
		progressBarTimer = new Timer(TIMER_PAUSE, al);
		progressBarTimer.start();
		
	}
	private void loginFrameShow(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ImageIcon icon = new ImageIcon("main.png");
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
