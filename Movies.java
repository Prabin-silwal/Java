package Model;
import java.util.ArrayList;
public class Movies {
	private String Moviename;
	private String Releasedate;
	private int PriceperSeat;
	private int Id;
	String Imageaddress;

	private String Showtime;
	
	private ArrayList<String> moviesarr=new ArrayList<String>();
	public Movies() {
			Moviename = "";
			Releasedate = "";
			PriceperSeat = 0;
			Imageaddress=null;
			Id = 0;
			Showtime="";
		}
	public Movies(String moviename, String releasedate, int priceperSeat,String photo ) {
		
			Moviename = moviename;
			Releasedate = releasedate;
			PriceperSeat = priceperSeat;
			this.Imageaddress=photo;
			Id++;
		}
	public Movies(String moviename,String image ,String Showtime) {
		
		Moviename = moviename;
		this.Imageaddress=image;
		this.Showtime=Showtime;
	}
		public String getMoviename() {
			return Moviename;
		}
		public void setMoviename(String moviename) {
			Moviename = moviename;
		}
		public String getReleasedate() {
			return Releasedate;
		}
		public void setReleasedate(String releasedate) {
			Releasedate = releasedate;
		}
		public int getPriceperSeat() {
			return PriceperSeat;
		}
		public void setPriceperSeat(int priceperSeat) {
			PriceperSeat = priceperSeat;
		}
		public String getImageaddress() {
			return Imageaddress;
		}
		public void setImageaddress( String imageaddress) {
			this.Imageaddress = imageaddress;
		}
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
public String toString() {
		return "Movies [ Mname=" + Moviename  +", moviesarr=" + moviesarr + "]";
	}
}
