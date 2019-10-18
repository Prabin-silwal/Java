package Gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.Audience;
import Model.Database;
import Model.Movies;
import Model.Seat;

public class Adminpage extends JFrame implements ActionListener {

	JFrame frame1;
	JButton button1, button2;
	JButton button3;
	JButton button4, button5, button6, button7;
	JLabel label;
	static Scanner sc = new Scanner(System.in);

	public Adminpage() {
		JFrame frame = new JFrame("AP Cinema");
		setTitle("Admin Menu");
		setVisible(true);
		setBounds(200, 50, 600, 500);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JButton button = new JButton();
		panel = new JPanel();
		frame.add(panel);
		button1 = new JButton("Add Movie");
		button2 = new JButton("Book Ticket");
		button3 = new JButton("Exit");
		button4 = new JButton("Remove Movie");
		button6 = new JButton("Reset Seat info");
		button5 = new JButton("Update ShowTime");
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		add(button2);
		add(button1);
		add(button4);
		add(button5);
		add(button6);
		add(button3);
		button2.setBounds(175, 100, 300, 30);
		button1.setBounds(175, 150, 300, 30);
		button4.setBounds(175, 200, 300, 30);
		button5.setBounds(175, 250, 300, 30);
		button6.setBounds(175, 300, 300, 30);
		button3.setBounds(175, 350, 300, 30);
		setVisible(true);
		setBackground(Color.black);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		String action = ae.getActionCommand();
		if (action.equals("Book Ticket")) {
			JOptionPane.showMessageDialog(this, "book movie");
			sliderscreen slide = new sliderscreen();
			slide.initialize();
		} else if (action.equals("Add Movie")) {
			AddMovies1 book = new AddMovies1();
			book.addMovies();
			setVisible(false);
		} else if (action.equals("Exit")) {
			int yesno = JOptionPane.showConfirmDialog(this, "You are about to Exit");
			if (yesno == 0) {
				System.exit(0);
			} else {
			}
		} else if (action.equals("Remove Movie")) {
			new Movielist();
		} else if (action.equals("Reset Seat info")) {
			Database db;
			int i = 0;
			try {
				db = new Database();
				i = db.resetseatinfo();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i == 1)
				JOptionPane.showMessageDialog(this, "Reset seat info Successful");
		} else if (action.equals("Update ShowTime")) {
			new UpdateShowtime();

		}

	}

	public static String choiceShowtime(List<String> showlist) {
		System.out.println(showlist);
		System.out.println("Choose the Show time :");
		int ch = sc.nextInt() - 1;
		String Showtime = showlist.get(ch);
		return Showtime;
	}

	public static String chooseshowtime() {
		int ShowNo;
		String i = "";
		do {
			System.out.println("8:00 AM \n12:00 PM\n4:00 PM\n8:00 PM");
			System.out.println("Choice the show time : ");
			ShowNo = sc.nextInt();
			if (ShowNo >= 1 && ShowNo <= 4) {
				if (ShowNo == 1)
					return "8:00 AM";
				else if (ShowNo == 2)
					return "12:00 PM";
				else if (ShowNo == 3)
					return "4:00 PM";
				else if (ShowNo == 4)
					return "8:00 PM";

			} else
				System.out.println("Invalid  ShowNo Try [1-4] !!!");

		} while (ShowNo > 0 || ShowNo < 5);
		return i;
	}

	public static void bookticket() throws SQLException {
		sc = new Scanner(System.in);
		Database db = null;
		Movies movie = new Movies();
		Seat s1 = null;
		Seat s2 = null;
		Seat s3 = null;
		Seat s4 = null;
		Seat s = new Seat();
		ArrayList<String> seatNo = null;
		int[][] isbook = null;
		ArrayList<String> m = new ArrayList<String>();
		List<String> showlist = new ArrayList<String>();
		isbook = new int[5][5];
		String Showtime;
		m = db.getMovie();
		String Moviename = choiceMovies(m);
		int mid = db.getMovieid(Moviename);
		showlist = db.getShowtime(mid);
		Showtime = choiceShowtime(showlist);
		System.out.println(Showtime);

		int n;
		if (Showtime.equals("8:00 AM")) {
			n = 1;
			isbook = db.getseatinfo(n);
			s1 = new Seat(isbook, Showtime);
			seatNo = new ArrayList<String>();
			seatNo = s1.seatmain();
			System.out.println("enter the name of audience:");
			sc.nextLine();
			String Aname = sc.nextLine();
			Audience a = new Audience(Aname, Moviename, Showtime, seatNo);
			db.addaudience(a);

		} else if (Showtime.equals("12:00 PM")) {
			n = 2;
			isbook = db.getseatinfo(n);
			s2 = new Seat(isbook, Showtime);
			seatNo = new ArrayList<String>();
			seatNo = s2.seatmain();
			System.out.println("enter the name of audience:");
			sc.nextLine();
			String Aname = sc.nextLine();
			Audience a = new Audience(Aname, Moviename, Showtime, seatNo);
			db.addaudience(a);
		} else if (Showtime.equals("4:00 PM")) {
			n = 3;
			isbook = db.getseatinfo(n);
			Seat S3 = new Seat(isbook, Showtime);
			seatNo = new ArrayList<String>();
			seatNo = S3.seatmain();
			System.out.println("enter the name of audience:");
			sc.nextLine();
			String Aname = sc.nextLine();
			Audience a = new Audience(Aname, Moviename, Showtime, seatNo);
			db.addaudience(a);
		} else if (Showtime.equals("8:00 PM")) {
			n = 4;
			isbook = db.getseatinfo(n);
			s4 = new Seat(isbook, Showtime);
			seatNo = new ArrayList<String>();
			seatNo = s4.seatmain();
			System.out.println("enter the name of audience:");
			sc.nextLine();
			String Aname = sc.nextLine();
			Audience a = new Audience(Aname, Moviename, Showtime, seatNo);
			db.addaudience(a);
		} else {
			System.out.println("wrong");
		}
	}

	public static String choiceMovies(ArrayList<String> m) {
		System.out.println(m);
		System.out.println("enter the number to choice movies:");
		int ch = sc.nextInt() - 1;
		String Moviename = m.get(ch);
		return Moviename;
	}

}
