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

public class Movielist extends JFrame implements ListSelectionListener, ActionListener {
	// String[] Movienames =new String[25];
	static ArrayList<String> Movienames = new ArrayList<String>();
	JButton button1;

	public Database db;

	// String[] Movienames = { "Janaury", "Febuary", "March", "April", "May",
	// "June", "July","August","September","October","November","December" };
	JList<String> MList;
	JTextField choose;

	public Movielist() {
		setTitle("MovieList");
		try {
			db = new Database();
			Movienames = db.getMovie();
			// String Moviename=choiceMovies(Movienames);
			//

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] str = new String[Movienames.size()];
		choose = new JTextField(20);
		choose.setText("You have choosen:");
		choose.setEditable(false);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
		MList = new JList<>(Movienames.toArray(str));
		MList.addListSelectionListener(this);
		MList.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		button1 = new JButton("Okay");
	//	MList.setBounds(100, 300, 400, 500);
		button1.addActionListener(this);

		// uncomment this and comment the next line to see demo of scrollbar
		/*
		 * nameList.setVisibleRowCount(3); JScrollPane scrollPane=new
		 * JScrollPane(nameList); panel.add(scrollPane);
		 */
		// uncomment below to set monthList to JList
		// nameList.setListData(monthList);

		panel.add(MList);
		panel.add(choose);
		panel.add(button1);
		add(panel);
		panel.setBounds(100, 100, 100, 100);
		setBounds(400, 100, 600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);

	}

	public static void listmain(String[] args) {
		new Movielist();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		choose.setText("You have chosen:" + MList.getSelectedValue());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("Okay")) {
			try {
				db.deleteMovies(MList.getSelectedValue());
				JOptionPane.showMessageDialog(this, MList.getSelectedValue() + " is successfully removed");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

	}
}
