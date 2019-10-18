package Model;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Gui.Adminpage;
import Model.Audience;
import Model.Movies;

public class Database {
	String url = "jdbc:mysql://localhost:3306/database";
	String username = "root";
	String password = "";
	String sql = "";
	Statement stmt;
	ResultSet rs;
	Connection con;
	public int istaken=0;
	
	

	public Database() throws SQLException {
		con = (Connection) DriverManager.getConnection(url, username, password);
	}

	public int login(String value1, String value2) throws SQLException {
		String user1 = "", pass1 = "";
		sql = "SELECT * FROM login where username='" + value1 + "' && password='" + value2 + "'";
		stmt = (Statement) con.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			user1 = rs.getString(2);
			pass1 = rs.getString(3);
		}
		if (user1.equals(value1) && pass1.equals(value2)) {
			return 1;
		} else
			return 0;

	}

	public void addaudience(Audience v) throws SQLException {
		sql = "Insert into audience (Aname,Mname,Showtime,SeatNoData) " + "values('" + v.getAname() + "', '"
				+ v.getMname() + "',' " + v.getShowtime() + "','" + v.getSeatNo() + "')";
		stmt = (Statement) con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}

	public void addmovies(Movies v) throws SQLException {
		sql = "Insert into movies (Moviename,Releasedate,PriceperSeat,imageaddress) " + "values('" + v.getMoviename()
				+ "', '" + v.getReleasedate() + "', " + v.getPriceperSeat() + ",'" + v.getImageaddress() + "')";
		System.out.println(sql);
		stmt = (Statement) con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}

	public void updateshowtime(int mid, String stime) throws SQLException {
		sql = "UPDATE showtime SET movieid=" + mid + " WHERE Showtime LIKE '" + stime + "%'";
		// System.out.println(sql);
		stmt = (Statement) con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}

	public void addseatinfo(String x, String Showtime) throws SQLException {
		sql = "UPDATE seat SET Istaken = 1 WHERE SeatNo LIKE '" + x + "%'AND Showtime LIKE '" + Showtime + "%';";
		// System.out.println(sql);
		stmt = (Statement) con.createStatement();
		stmt.executeUpdate(sql);
		int taken=stmt.executeUpdate(sql);
		stmt.close();
	}

	public int resetseatinfo() throws SQLException {
		int i = 0;
		sql = "UPDATE seat SET Istaken = 0";
		stmt = (Statement) con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		return i = 1;

	}

	public int add(String SeatNo, String Showtime) throws SQLException {
		sql = "Insert into seat (SeatNo,Showtime, Istaken) " + "values('" + SeatNo + "', '" + Showtime + "'," + 0
				+ ");";
		stmt = (Statement) con.createStatement();
		istaken=stmt.executeUpdate(sql);
		stmt.close();
		return istaken;
	}

	public List<String> getShowtime(int movieid) throws SQLException {
		List<String> list = new ArrayList<String>();
		sql = "SELECT Showtime from showtime where movieid=" + movieid + ";";
		stmt = (Statement) con.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			String stime = rs.getString(1);
			list.add(stime);
		}
		rs.close();
		stmt.close();
		return list;
	}

	public ArrayList<Movies> nowshowing() throws SQLException {
		ArrayList<Movies> nowshowing = new ArrayList<Movies>();
		Movies now = new Movies();
		sql = "SELECT Moviename,imageaddress,Showtime FROM movies RIGHT OUTER JOIN showtime ON movies.Id = showtime.movieid";
		stmt = (Statement) con.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			String mname = rs.getString(1);
			String image = rs.getString(2);
			String stime = rs.getString(3);
			now = new Movies(mname, image, stime);
			nowshowing.add(now);
		}
		stmt.close();
		return nowshowing;

	}

	public int[][] getseatinfo(int n) throws SQLException {
		int i = 0, j = 0;
		int[][] seat = new int[5][5];
		if (n == 1)
			sql = "SELECT * FROM seat WHERE Showtime LIKE '8:00 AM%'";
		else if (n == 2)
			sql = "SELECT * FROM seat WHERE Showtime LIKE '12:00 PM%'";
		else if (n == 3)
			sql = "SELECT * FROM seat WHERE Showtime LIKE '4:00 PM%'";
		else if (n == 4)
			sql = "SELECT * FROM seat WHERE Showtime LIKE '8:00 PM%'";
		stmt = (Statement) con.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int x = rs.getInt(4);
			seat[i][j] = x;
			j++;
			if (j == 5) {
				i++;
				j = 0;
			}
		}
		rs.close();
		stmt.close();
		return seat;
	}

	public void deleteMovies(String Moviename) throws SQLException {
		sql = "DELETE FROM movies WHERE Moviename LIKE '" + Moviename + "%'";
		// System.out.println(sql);
		stmt = (Statement) con.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}

	public ArrayList<String> getMovie() throws SQLException {
		ArrayList<String> v = new ArrayList<String>();
		sql = "SELECT Moviename from movies";
		stmt = (Statement) con.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			String Name = rs.getString(1);
			v.add(Name);
		}
		rs.close();
		stmt.close();
		return v;
	}

	public int getMovieid(String moviename) throws SQLException {
		int mid = 0;
		sql = "SELECT Id FROM movies WHERE Moviename LIKE '" + moviename + "%'";
		// System.out.println(sql);
		stmt = (Statement) con.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			mid = rs.getInt(1);
			;
		}
		rs.close();
		stmt.close();
		return mid;
	}

	public Audience getAudience(int audId) throws SQLException {
		Audience v = null;
		sql = "SELECT * FROM audience where Id=" + audId;
		stmt = (Statement) con.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int Id = rs.getInt(1);
			String Name = rs.getString(2);
			String Movies = rs.getString(3);
			String Showtime = rs.getString(4);
			String SeatNoData = rs.getString(5);
			v = new Audience(Id, Name, Movies, Showtime, SeatNoData);
		}
		rs.close();
		stmt.close();
		return v;
	}

	public Audience getaudienceByName(String input) throws SQLException {
		Audience v = null;
		sql = "SELECT * FROM audience where Aname like '%" + input + "%'";
		stmt = (Statement) con.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int Id = rs.getInt(1);
			String Name = rs.getString(2);
			String Movies = rs.getString(3);
			String Showtime = rs.getString(4);
			String SeatNoData = rs.getString(5);
			v = new Audience(Id, Name, Movies, Showtime, SeatNoData);
		}
		rs.close();
		stmt.close();
		return v;
	}

	public List<Audience> getAllAudience() throws SQLException {
		Audience v;
		List<Audience> vList = new ArrayList<Audience>();
		sql = "SELECT * FROM audience";
		stmt = (Statement) con.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int Id = rs.getInt(1);
			String Name = rs.getString(2);
			String Movies = rs.getString(3);
			String Showtime = rs.getString(4);
			String SeatNo = rs.getString(5);
			v = new Audience(Id, Name, Movies, Showtime, SeatNo);
			vList.add(v);
		}
		rs.close();
		stmt.close();
		return vList;
	}

	public Audience getAudienceSQLInjection(String auId) throws SQLException {
		Audience v = null;
		sql = "SELECT * FROM audience where Id='" + auId + "'";
		stmt = (Statement) con.createStatement();
		rs = stmt.executeQuery(sql);
		rs.next();
		int Id = rs.getInt(1);
		String Name = rs.getString(2);
		String Movies = rs.getString(3);
		String Showtime = rs.getString(4);
		String SeatNo = rs.getString(5);
		v = new Audience(Id, Name, Movies, Showtime, SeatNo);
		rs.close();
		stmt.close();
		return v;
	}

	public Audience getAudienceSQLInjectionPrev(String auId) throws SQLException {
		Audience v = null;
		sql = "SELECT * FROM audience where Id = ?";
		PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);
		p.setString(1, auId);
		rs = p.executeQuery();
		rs.next();
		int Id = rs.getInt(1);
		String Name = rs.getString(2);
		String Movies = rs.getString(3);
		String Showtime = rs.getString(4);
		String SeatNo = rs.getString(5);
		v = new Audience(Id, Name, Movies, Showtime, SeatNo);
		rs.close();
		stmt.close();
		return v;
	}
}
