package Gui;

import javax.swing.JFrame;
import Model.Database;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class sliderscreen extends JFrame implements ActionListener {
	private JFrame frame;
	private Component layeredPane;
	int i = 0;
	private JLabel label, label2;
	JComboBox cb;

	static ArrayList<String> imagelist = new ArrayList<String>();

	public void switchPanels(PopupMenu panel) {
		layeredPane.removeNotify();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	public void initialize() {
		try {
			Database db = new Database();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String[] movies = { "8:00 AM", "12:00 AM", "4:00 PM", "8:00 PM" };
		cb = new JComboBox(movies);
		setTitle("Choose Movie");
		imagelist.add("C:\\\\Users\\\\acer\\\\Desktop\\\\mib.jpg");
		imagelist.add("C:\\\\Users\\\\acer\\\\Desktop\\\\hobbs.jpg");
		imagelist.add("C:\\\\Users\\\\acer\\\\Desktop\\\\endgame.jpg");
		imagelist.add("C:\\Users\\acer\\Desktop\\spiderman.jpg");

		setBounds(400, 100, 600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		/*
		 * label2 = new JLabel("prabin"); label2.setBounds(256, 327, 228, 27);
		 * getContentPane().add(label2);
		 */
		JButton next = new JButton("-->");

		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(494, 254, -423, -203);
		getContentPane().add(layeredPane_1);

		JPanel panel = new JPanel();
		panel.setBounds(77, 36, 407, 227);
		getContentPane().add(panel);
		panel.setLayout(null);

		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\acer\\Desktop\\giphy.gif"));
		label.setBounds(0, 0, 407, 227);
		panel.add(label);
		next.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		next.setForeground(Color.BLACK);
		next.setBounds(494, 118, 68, 23);
		getContentPane().add(next);

		JButton button = new JButton("<--");
		button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button.setBounds(-18, 118, 89, 23);
		getContentPane().add(button);

		JLabel lblNowShowing = new JLabel("Now Showing");
		lblNowShowing.setFont(new Font("Tempus Sans ITC", Font.ITALIC, 16));
		lblNowShowing.setBounds(195, 11, 147, 20);
		getContentPane().add(lblNowShowing);

		JLabel lblNewLabel = new JLabel("anamol");
		lblNewLabel.setBounds(213, 274, 147, 14);
		getContentPane().add(lblNewLabel);

		cb = new JComboBox(movies);
		cb.setBounds(210, 327, 70, 28);
		getContentPane().add(cb);

		JLabel lblSelectShowTime = new JLabel("Select Show time");
		lblSelectShowTime.setBounds(77, 334, 101, 14);
		getContentPane().add(lblSelectShowTime);
		JButton btnOkay = new JButton("OKAY");
		btnOkay.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 16));
		btnOkay.setBounds(225, 397, 89, 23);
		getContentPane().add(btnOkay);
		cb.addActionListener(this);
		next.addActionListener(this);
		button.addActionListener(this);
		btnOkay.addActionListener(this);
	//	label2.setVisible(true);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String arry = imagelist.get(i);

		try {
			for (int i = 0; i < 2; i++) {
				Thread.sleep(30);
				label.setIcon(new ImageIcon(arry));
			}

		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (e.getActionCommand() == "-->") {

			label.setIcon(new ImageIcon(arry));

			i++;

			if (i == (imagelist.size() - 1)) {
				i = 0;
			}

		} else if (e.getActionCommand() == ("<--")) {
			if (i == 0) {
				i = (imagelist.size() - 1);
			}
			label.setIcon(new ImageIcon(arry));

			i--;

		} else if (e.getActionCommand() == "OKAY") {
			int yesno = JOptionPane.showConfirmDialog(this, "Do you want to Proceed!!!", null,
					JOptionPane.YES_NO_OPTION);
			if (yesno == 0) {
				bookingseats book = new bookingseats();
				book.bookseat();

			} else {

			}
		}
	}

}
