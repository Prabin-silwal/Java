package Gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPage extends JFrame implements ActionListener {
	JLabel label1, label2, label3;
	JButton Jbutton,button;
	JFrame frame;

	MainPage() {
		this.getContentPane().setLayout(new FlowLayout());
		setTitle("AP Cinema");
		setVisible(true);
		setBounds(400, 100, 600, 500);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label1 = new JLabel("AP Cinema");
		label1.setForeground(Color.blue);
		label1.setFont(new Font("Serif", Font.BOLD, 50));
		label2=new JLabel("Choose your catagory:");
		Jbutton=new JButton("Admin");
		button=new JButton("Customer");
		label3 =new JLabel("Copyright AP Cinemas 2019 . All Rights Reserved");
		label3.setFont(new Font("Tekton Pro", Font.PLAIN, 14));
		label3.setBounds(100, 400, 292, 50);
		Jbutton.setBounds(200,200, 100, 30);
		button.setBounds(200,250,100,30);
		label1.setBounds(150, 50, 350, 50);
		add(label1);
		add(Jbutton);
		add(button);
		add(label3);
		Jbutton.addActionListener(this);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action=e.getActionCommand();
		if(action.equals("Admin"))
		{
			Login l=new Login();
			
		}
		else if(action.equals("Customer"))
		{/*
			 * MoviePage movie1=new MoviePage(); movie1.moviepage();
			 */
			//ImageIconDemo img=new ImageIconDemo();
		}
		
	}
	public static void main(String args[]) {
		new MainPage();
	}
	}