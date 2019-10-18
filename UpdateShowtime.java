package Gui;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Model.Database;

public class UpdateShowtime extends JFrame implements ListSelectionListener, ActionListener {
	String[] Showlist = { "8:00 AM", "12:00 PM", "4:00 PM", "8:00 PM" };
	static ArrayList<String> Movienames = new ArrayList<String>();
	JButton button1;

	public Database db;
	JList<String> MList;
	JList<String> SList;
	JTextField choose;
	JTextField Show;

	public UpdateShowtime() {
		try {
			db = new Database();
			Movienames = db.getMovie();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String[] str = new String[Movienames.size()];
		choose = new JTextField(20);
		choose.setBounds(50, 50, 200, 100);
		choose.setText("You have chosen:");
		choose.setEditable(false);
		Show = new JTextField(20);
		Show.setText("You have chosen:");
		Show.setEditable(false);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 50));
		MList = new JList<>(Movienames.toArray(str));
		MList.addListSelectionListener(this);
		MList.setBorder(BorderFactory.createLineBorder(Color.green, 5));
		SList = new JList<>(Showlist);
		SList.addListSelectionListener(this);
		SList.setBorder(BorderFactory.createLineBorder(Color.green, 5));
			button1 = new JButton("Okay");
		button1.addActionListener(this);

		// uncomment this and comment the next line to see demo of scrollbar
		/*
		 * nameList.setVisibleRowCount(3); JScrollPane scrollPane=new
		 * JScrollPane(nameList); panel.add(scrollPane);
		 */
		// uncomment below to set monthList to JList
		SList.setListData(Showlist);

		panel.add(MList);
		panel.add(choose);
		panel.add(SList);
		panel.add(Show);
		panel.add(button1);
		add(panel);

		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void listmain(String[] args) {
		new Movielist();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		choose.setText("You have chosen:" + MList.getSelectedValue());
		Show.setText("You have chosen:" + SList.getSelectedValue());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		if (action.equals("Okay")) {
			try {
				int mid = db.getMovieid(MList.getSelectedValue());
				String stime = SList.getSelectedValue();
				db.updateshowtime(mid, stime);

				JOptionPane.showMessageDialog(this, MList.getSelectedValue() + " movie showtime is update to " + stime);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setVisible(false);
		}

	}
}
