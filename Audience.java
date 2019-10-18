package Model;
import java.util.*;
public class Audience {
	private static int count=0;
	private String Aname;
	private int audId;
	private String Mname;
	private String Showtime;
	private ArrayList seatNo;
	private String SeatNoData;
	Scanner sc=new Scanner(System.in);
	
	public Audience()
	{
		Aname="";
		audId=0;
		Mname="";
		Showtime="";
		seatNo=null;
		SeatNoData="";
	}
	public Audience(String Aname, String Mname, String n,ArrayList seatNo) {
		this.seatNo=new ArrayList <String>();
		count++;
		this.audId=count;
		this.Aname = Aname;
		this.Mname=Mname;
		this.Showtime=n;
		this.seatNo=seatNo;
	}
	public Audience(int Id,String Aname, String Mname, String n,String SeatNoData)
	{
		this.seatNo=new ArrayList <String>();
		this.audId=Id;
		this.Aname = Aname;
		this.Mname=Mname;
		this.Showtime=n;
		this.SeatNoData=SeatNoData;
	}
	
	 	public String getAname() {
		return Aname;
	}
	public void setAname(String aname) {
		Aname = aname;
	}
	public int getAudId() {
		return audId;
	}
	public void setAudId(int audId) {
		this.audId = audId;
	}
	public String getMname() {
		return Mname;
	}
	public void setMname(String mname) {
		Mname = mname;
	}
	public String getShowtime() {
		return Showtime;
	}
	public void setShowtime(String Showtime) {
		this.Showtime = Showtime;
	}
	public ArrayList getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(ArrayList seatNo) {
		this.seatNo = seatNo;
	}
		@Override
	public String toString() {
		return "Audience [Aname=" + Aname + ", audId=" + audId + ", Mname=" + Mname + ", Showtime=" + Showtime+ ", seatNo="
				+ seatNo + "]";
	}
}
	