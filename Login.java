package Gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	JLabel label, label1, label2, label3;
	JTextField text1;
	JTextField text2;
	JButton Jbutton;
	JPanel panel, panel1, panel2, panel3, panel4;
	JFrame frame;
	final static Color[] cList = { Color.WHITE, Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW,
			Color.CYAN, Color.darkGray, Color.MAGENTA, Color.PINK };

	public Login() {
		this.getContentPane().setLayout(new FlowLayout());
		setTitle("Login");

		setBounds(400, 100, 600, 500);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label1 = new JLabel("AP Cinema");
		label1.setForeground(Color.blue);
		label1.setFont(new Font("Serif", Font.BOLD, 50));
		label2 = new JLabel("Username:");
		label3 = new JLabel("Password:");
		text1 = new JTextField();
		text2 = new JPasswordField();
		Jbutton = new JButton("Login");
		label1.setBounds(200, 30, 400, 50);
		label2.setBounds(100, 150, 200, 30);
		label3.setBounds(100, 200, 200, 30);
		text1.setBounds(200, 150, 200, 30);
		text2.setBounds(200, 200, 200, 30);
		Jbutton.setBounds(220, 250, 100, 30);
		setBackground(Color.black);
		label1.setBackground(Color.DARK_GRAY);
		Jbutton.setForeground(Color.BLUE);
		Jbutton.setBackground(Color.BLACK);
		setForeground(Color.DARK_GRAY);
		setResizable(false);
		setVisible(true);
		add(label1);
		add(label2);
		add(text1);
		add(label3);
		add(text2);
		add(Jbutton);
		Jbutton.addActionListener(this);
		// splashscreen sc=new splashscreen();

	}

	public void actionPerformed(ActionEvent e) {
		String value1 = text1.getText();
		String value2 = text2.getText();
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/database";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String pass = "";
		String user1 = "";
		String pass1 = "";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
			ResultSet res = st
					.executeQuery("SELECT * FROM login where username='" + value1 + "' && password='" + value2 + "'");
			while (res.next()) {
				user1 = res.getString("username");
				pass1 = res.getString("password");

			}
			if (value1.equals(user1) && value2.equals(pass1)) {
				JOptionPane.showMessageDialog(this, "Login Successful");
				setVisible(false);
				Adminpage adds = new Adminpage();

			} else {
				JOptionPane.showMessageDialog(this, "Incorrect login or password", "Error", JOptionPane.ERROR_MESSAGE);
				text1.setText(" ");
				text2.setText("");
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
	}

	public static void main(String args[]) {
		SplashScreen sp = new SplashScreen();

		// sp.setVisible(true);
		try {

			for (int i = 0; i <= 100; i++) {

				Thread.sleep(30);

				sp.label.setText(Integer.toString(i));

				sp.progressbar.setValue(i);
				sp.progressbar.setForeground(Color.black);
				if (i == 100) {
					sp.frame.setVisible(false);
					new Login();

				}

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
