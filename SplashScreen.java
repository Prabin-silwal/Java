package Gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Window.Type;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
public class SplashScreen{
public JFrame frame;
	JLabel label;
	JProgressBar progressbar;
	JLabel label1;
	JLabel label2 ;
	
public SplashScreen() {
		
		
		frame = new JFrame();
		frame.setBounds(new Rectangle(400, 200, 434, 261));
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setType(Type.POPUP);
		frame.setAlwaysOnTop(true);
		frame.setForeground(Color.RED);
		frame.getContentPane().setForeground(Color.GREEN);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setForeground(Color.ORANGE);
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		label1= new JLabel("Welcome");
		label1.setFont(new Font("Tekton Pro Ext", Font.BOLD | Font.ITALIC, 17));
		label1.setBounds(157, 38, 125, 47);
		panel.add(label1);

		label2 = new JLabel("AP Cinemas");
		label2.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 16));
		label2.setBounds(164, 112, 118, 14);
		panel.add(label2);

		progressbar = new JProgressBar();
		progressbar.setBounds(34, 179, 371, 14);
		panel.add(progressbar);

		label = new JLabel("0%");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(209, 205, 46, 14);
		panel.add(label);
		
	}



	public void setVisible(boolean b) {
	
	}

}


