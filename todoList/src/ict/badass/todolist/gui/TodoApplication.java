package ict.badass.todolist.gui;


public class TodoApplication {

	public static void main(String[] args) throws Exception{
/*		JWindow window = new JWindow();
		window.getContentPane().add(
				new JLabel("", 
						new ImageIcon
							(new URL("https://docs.oracle.com/javase/tutorial/figures/uiswing/misc/splash.gif")), SwingConstants.CENTER));
		window.setBounds(500,150,300,200);
		window.setVisible(true);
		
		Thread.sleep(5000);
		
		window.setVisible(false);*/
		
		SplashScreen screen = new SplashScreen();
		screen.setLocationRelativeTo(null);
		
/*		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null); 
					//window.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		
	}

}
