package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import Model.Audience;
import Model.Database;
import Model.Seat;

public class bookingseats extends JFrame implements ActionListener {
	JPanel panel;
	private ArrayList<JButton> seats;

	JTextField text1, text2;
	JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11,
			button12, button14;
	JButton button13, button15, button16, button17, button18, button19, button20, button21, button22, button23,
			button24, button25;
	JButton book;
	JLabel label2;
	public final Color[] cList= {Color.white,Color.BLACK,Color.RED};
	public void bookseat() {

		setTitle("Seat book");
		JFrame frame = new JFrame();
		frame.setBounds(400, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		setResizable(false);

		JLabel text1 = new JLabel("Select the Seats");
		text1.setFont(new Font("Tekton Pro", Font.PLAIN, 39));
		text1.setBounds(161, 11, 292, 28);
		frame.getContentPane().add(text1);

		JSeparator separator = new JSeparator();
		separator.setBounds(50, 71, 331, -18);
		frame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(48, 46, 485, 2);
		frame.getContentPane().add(separator_1);

		button1 = new JButton("A1");
		button1.setBackground(Color.GREEN);
		button1.setBounds(38, 71, 89, 23);
		frame.getContentPane().add(button1);

		button2 = new JButton("A2");
		button2.setBounds(137, 71, 89, 23);
		frame.getContentPane().add(button2);
		button2.setBackground(Color.GREEN);

		button3 = new JButton("A3");
		button3.setBounds(236, 71, 89, 23);
		frame.getContentPane().add(button3);
		button3.setBackground(Color.GREEN);

		button4 = new JButton("A4");
		button4.setBounds(335, 71, 89, 23);
		frame.getContentPane().add(button4);
		button4.setBackground(Color.GREEN);

		button6 = new JButton("B1");
		button6.setBounds(38, 105, 89, 23);
		frame.getContentPane().add(button6);
		button6.setBackground(Color.GREEN);

		button7 = new JButton("B2");
		button7.setBounds(137, 105, 89, 23);
		frame.getContentPane().add(button7);
		button7.setBackground(Color.GREEN);

		button8 = new JButton("B3");
		button8.setBounds(236, 106, 89, 23);
		frame.getContentPane().add(button8);
		button8.setBackground(Color.GREEN);

		button9 = new JButton("B4");
		button9.setBackground(Color.GREEN);

		button9.setBounds(335, 105, 89, 23);
		frame.getContentPane().add(button9);

		button11 = new JButton("C1");
		button11.setBounds(38, 139, 89, 23);
		frame.getContentPane().add(button11);
		button11.setBackground(Color.GREEN);

		button12 = new JButton("C2");
		button12.setBounds(137, 140, 89, 23);
		frame.getContentPane().add(button12);
		button12.setBackground(Color.GREEN);

		button13 = new JButton("C3");

		button13.setBounds(236, 140, 89, 23);
		frame.getContentPane().add(button13);
		button13.setBackground(Color.GREEN);

		button14 = new JButton("C4");
		button14.setBounds(335, 139, 89, 23);
		frame.getContentPane().add(button14);
		button14.setBackground(Color.GREEN);

		button16 = new JButton("D1");
		button16.setBounds(38, 173, 89, 23);
		frame.getContentPane().add(button16);
		button16.setBackground(Color.GREEN);

		button17 = new JButton("D2");
		button17.setBounds(137, 174, 89, 23);
		frame.getContentPane().add(button17);
		button17.setBackground(Color.GREEN);

		button18 = new JButton("D3");
		button18.setBounds(236, 174, 89, 23);
		frame.getContentPane().add(button18);
		button18.setBackground(Color.GREEN);

		button19 = new JButton("D4");
		button19.setBounds(335, 174, 89, 23);
		frame.getContentPane().add(button19);
		button19.setBackground(Color.GREEN);

		JLabel label1 = new JLabel("A");
		label1.setBounds(10, 75, 46, 14);
		frame.getContentPane().add(label1);
		label1.setForeground(Color.blue);

		JLabel label2 = new JLabel("B");
		label2.setBounds(10, 109, 46, 14);
		frame.getContentPane().add(label2);
		label2.setForeground(Color.blue);

		JLabel label3 = new JLabel("C");
		label3.setBounds(10, 143, 46, 14);
		frame.getContentPane().add(label3);
		label3.setForeground(Color.blue);

		JLabel label4 = new JLabel("D");
		label4.setBounds(10, 177, 46, 14);
		frame.getContentPane().add(label4);
		label4.setForeground(Color.blue);

		button5 = new JButton("A5");
		button5.setBackground(Color.GREEN);

		button5.setBounds(431, 71, 89, 23);
		frame.getContentPane().add(button5);

		button10 = new JButton("B5");
		button10.setBounds(434, 105, 89, 23);
		frame.getContentPane().add(button10);
		button10.setBackground(Color.GREEN);

		button15 = new JButton("C5");
		button15.setBounds(431, 139, 89, 23);
		frame.getContentPane().add(button15);
		button15.setBackground(Color.GREEN);

		button20 = new JButton("D5");
		button20.setBounds(431, 173, 89, 23);
		frame.getContentPane().add(button20);
		button20.setBackground(Color.GREEN);

		button21 = new JButton("E1");
		button21.setBackground(Color.GREEN);

		button21.setBounds(38, 203, 89, 23);
		frame.getContentPane().add(button21);

		button22 = new JButton("E2");
		button22.setBounds(137, 203, 89, 23);
		frame.getContentPane().add(button22);
		button22.setBackground(Color.GREEN);

		button23 = new JButton("E3");
		button23.setBounds(236, 203, 89, 23);
		frame.getContentPane().add(button23);
		button23.setBackground(Color.GREEN);

		button24 = new JButton("E4");
		button24.setBounds(335, 203, 89, 23);
		frame.getContentPane().add(button24);
		button24.setBackground(Color.GREEN);

		button25 = new JButton("E5");
		button25.setBounds(430, 203, 89, 23);
		frame.getContentPane().add(button25);
		button25.setBackground(Color.GREEN);
		book = new JButton("BOOK");
		book.setBounds(400, 400, 100, 30);
		frame.getContentPane().add(book);
		book.setForeground(Color.DARK_GRAY);

		JLabel label5 = new JLabel("E");
		label5.setBounds(10, 207, 46, 14);
		frame.getContentPane().add(label5);
		label5.setForeground(Color.blue);
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(38, 255, 495, 2);
		frame.getContentPane().add(separator_2);
		frame.setVisible(true);
		book.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		button10.addActionListener(this);
		button11.addActionListener(this);
		button12.addActionListener(this);
		button13.addActionListener(this);
		button14.addActionListener(this);
		button15.addActionListener(this);
		button16.addActionListener(this);
		button17.addActionListener(this);
		button18.addActionListener(this);
		button19.addActionListener(this);
		button20.addActionListener(this);
		button21.addActionListener(this);
		button22.addActionListener(this);
		button23.addActionListener(this);
		button24.addActionListener(this);
		button25.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Database db1 = null;
		//int status=0;*/
		try {
			db1 = new Database();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	//	status = db1.istaken;
		
		// int price = Integer.parseInt();
		String action = e.getActionCommand();
		
		Seat s=new Seat();
		
		String action2=e.getActionCommand();
		if (action.equals("BOOK")) {
			JOptionPane.showConfirmDialog(this, "Do you want to proceed!!");
			setVisible(false);
			try {
				db1.add(action, "");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showInputDialog("Enter your Name");
			 try {
				db1=new Database();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//db1.addaudience("","","","");
		}
		
			
		if (action.equals("A1")) {
			
			int takenornot=s.Isbooked('A', 1);
			if(takenornot==0) {
			button1.setBackground(Color.red);
			button1.setText("Taken");
			}
			else if(takenornot==1)
			{
				button1.setBackground(Color.red);
				button1.setText("Booked");
			}

		}
		if (action.equals("A2")) {
			button2.setBackground(Color.red);
			button2.setText("Booked");
		}
		if (action.equals("A3")) {
			button3.setBackground(Color.red);
			button3.setText("Booked");
		}
		if (action.equals("A4")) {
			button4.setBackground(Color.red);
			button4.setText("Booked");
		}
		if (action.equals("A5")) {
			button5.setBackground(Color.red);
			button5.setText("Booked");
		}
		if (action.equals("B1")) {
			button6.setBackground(Color.red);
			button6.setText("Booked");
		}
		if (action.equals("B2")) {
			button7.setBackground(Color.red);
			button7.setText("Booked");
		}
		if (action.equals("B3")) {
			button8.setBackground(Color.red);
			button8.setText("Booked");
		}
		if (action.equals("B4")) {
			button9.setBackground(Color.red);
			button9.setText("Booked");
		}
		if (action.equals("B5")) {
			button10.setBackground(Color.red);
			button10.setText("Booked");
		}
		if (action.equals("C1")) {
			button11.setBackground(Color.red);
			button11.setText("Booked");
		}
		if (action.equals("C2")) {
			button12.setBackground(Color.red);
			button12.setText("Booked");
		}
		if (action.equals("C3")) {
			button13.setBackground(Color.red);
			button13.setText("Booked");
		}
		if (action.equals("C4")) {
			button14.setBackground(Color.red);
			button14.setText("Booked");
		}
		if (action.equals("C5")) {
			button15.setBackground(Color.red);
			button15.setText("Booked");
		}
		if (action.equals("D1")) {
			button16.setBackground(Color.red);
			button16.setText("Booked");
		}
		if (action.equals("D2")) {
			button17.setBackground(Color.red);
			button17.setText("Booked");
		}
		if (action.equals("D3")) {
			button18.setBackground(Color.red);
			button18.setText("Booked");
		}
		if (action.equals("D4")) {
			button19.setBackground(Color.red);
			button19.setText("Booked");
		}
		if (action.equals("D5")) {
			button20.setBackground(Color.red);
			button20.setText("Booked");

		}
		if (action.equals("E1")) {
			button21.setBackground(Color.red);
			button21.setText("Booked");
		}
		if (action.equals("E2")) {
			button22.setBackground(Color.red);
			button22.setText("Booked");
		}
		if (action.equals("E3")) {
			button23.setBackground(Color.red);
			button23.setText("Booked");
		}
		if (action.equals("E4")) {
			button24.setBackground(Color.red);
			button24.setText("Booked");
		}
		if (action.equals("E5")) {
			button25.setBackground(Color.red);
			button25.setText("Booked");
		}
	
		}
		else if(status==1){
	
		button1.setBackground(Color.black);
		button2.setText("Unavailable");
		button3.setBackground(Color.black);
		button4.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		button1.setBackground(Color.black);
		button1.setText("Unavailable");
		}
		
		}
}

