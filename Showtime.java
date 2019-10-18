package Model;

import java.util.List;
import Model.Database;
public class Showtime {
	private	int id;
	private int movieid;
	private String stime;
	
	public Showtime() {
		id=0;
		movieid=0;
		stime=null;
	}
	public Showtime(int movie,String stime)
	{
		this.movieid=movieid;
		this.stime=stime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	
}
