 package Model;
 import java.util.Scanner;

public class Hall {
	private int hallNo;
    private String Mname;
    private Seat seatlist;
    Scanner sc=new Scanner(System.in);
   
    
    public Hall(int hallNo,String Mname,Seat seatlist) {
		this.hallNo = hallNo;
	     this.Mname = Mname;
	     this.seatlist=seatlist;
	}
    public Hall() {
		this.hallNo = 0;
		seatlist=null;
		Mname=null;
    }
    public void hallinput(int n, String Mname)
    {
    	setHallNo(n);
    	setHallMname(Mname);
    }
    
	public int getHallNo() {
		return hallNo;
	}
	public void setHallNo(int hallNo) {
		this.hallNo = hallNo;
	}
	public void setHallMname(String Mname) {
		this.Mname=Mname;
	}
	
	public Seat getSeatlist() {
		return seatlist;
	}
	public void setSeatlist(Seat seatlist) {
		this.seatlist = seatlist;
	}
		@Override
	public String toString() {
		return "Hall [hallNo=" + hallNo + ", Mname=" +Mname +"]";
	}
		public static int choosehall() {
		Scanner sc= new Scanner(System.in);
		int hallNo,i=0;
		do {
		System.out.println("HallNO : 1\nHallNo : 2");
		System.out.println("Enter the hallNo : ");
		hallNo=sc.nextInt();
		if(hallNo>=1&&hallNo<=2)
		{
			if(hallNo==1)
				i= 1;
			
			else
				i= 2;
			break;
		}
		else
			System.out.println("invalid hall no try [1-2]");
			
	}while(hallNo>0||hallNo<3);
		return i;
		}
	}
    
   

