package Mainmethod;
import java.util.Scanner;

import Model.Audience;
import Model.Database;
import Model.Hall;
import Model.Movies;
import Model.Seat;

import java.sql.SQLException;
import java.util.*;

public class main {

	public static void main(String [] args) throws SQLException
	{	Scanner sc= new Scanner(System.in);
	    Database db = null;
		Movies movie=new Movies();
		Hall h1=new Hall();
		Hall h2=new Hall();
		Seat s1=new Seat();
		Seat s2=new Seat();
		ArrayList<String> seatNo=new ArrayList<String>();
		int ch;
		
	do {
		System.out.println("1.book movies ticket");
		System.out.println("2.add/remove movies name");
		System.out.println("3.exit");
		System.out.println("enter the choice ");
		ch=sc.nextInt(); 
		switch(ch)
		{
			case 1:
			{
				ArrayList<String> m=new ArrayList<String>();
				try {
					db = new Database();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				db.getMovie();
				m=db.getMovie();
				String Moviename=movie.bookmovies(m);
				int n=Hall.choosehall();
				if(n==1)
				{
					h1.hallinput(n,Moviename);
					seatNo=s1.seatmain(n);
					System.out.println("enter the name of audience:");
					sc.nextLine();
					String Aname=sc.nextLine();
					Audience a=new Audience(Aname,Moviename,n,seatNo);
					try {
						db = new Database();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					db.addaudience(a);					
				
				}
				else { 
					h2.hallinput(n,Moviename);
					seatNo=s2.seatmain(n);
					System.out.println("enter the name of audience:");
					sc.nextLine();
					String Aname=sc.nextLine();
					Audience a=new Audience(Aname,Moviename,n,seatNo);
					try {
						db = new Database();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					db.addaudience(a);
				}
				break;
			}
			case 2:
			{
				
				Movies m=movie.addmovies();
				try {
					db = new Database();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				db.addmovies(m);
				break;
			}
			case 3:
			{
				System.out.println("thank you");
				System.exit(0);
			}
			default:
			{
				System.out.println("please enter valid number [1-3]");
				break;
			}
		}
      }while(ch!=3);
	}

}