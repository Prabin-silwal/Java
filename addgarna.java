package Gui;

import java.sql.SQLException;

import Model.Database;

public class addgarna {

	public static void main(String[] args) throws SQLException {
		Database db1 = new Database();
		String[] time = { "8:00 Am", "12:00 PM", "4:00 PM", "8:00 PM","" };
		String [] chare= {"A","B","C","D","E"};

		for (int i = 1; i < 5; i++) {
			String seat= chare[i];
			for (int j = 1; j < 5; j++) {
				seat +=time[j];
				db1.add(seat,"");
				
			}

		}
System.out.println("Done");
	}

}
