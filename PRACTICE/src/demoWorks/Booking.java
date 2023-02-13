package demoWorks;

import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Booking {
         
	String passengerName;
	int busNo;
	Date date;
	String mail;
	
	
	Booking(){
		Scanner scanner=new Scanner(System.in); 
		System.out.println("Enter a name of the passenger: ");
		passengerName=scanner.next();
		System.out.println("Enter a bus no: ");
		busNo=scanner.nextInt();
		System.out.println("Enter a mail Id:");
		mail=scanner.next();
		System.out.println("Enter a date (dd-MM-yyyy): ");
	    String dateinput=scanner.next();
	    SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy");
	    
	    try {
			date=dateformat.parse(dateinput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	
	}
	
	
	public boolean isAvailable() throws SQLException  {
		
		BusDAO busdao=new BusDAO();
		BookingDAO bookingdao=new BookingDAO();
		int capacity=busdao.getCapacity(busNo);
		
		int booked=bookingdao.getBookedCount(busNo,date);
		
		
		return booked<capacity;
	}
}
