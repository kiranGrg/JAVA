

import javax.swing.*;
import java.awt.*;

public class FrmSplash extends JWindow implements Runnable{
	public void run(){
		JLabel SplashLabel = new JLabel(new ImageIcon(getClass().getResource("/images/naruto.jpg")));
		Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();
		
		getContentPane().add(SplashLabel,BorderLayout.CENTER);
		
		setSize(422,316);
		setLocation((screen.width - 490)/2,((screen.height-300)/2));
		setVisible(true);
	}


//	public static void main(String args[])
//		{
//			new FrmSplash();
//		}
}

