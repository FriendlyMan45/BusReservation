package demoWorks;

import java.util.*;

public class Demo {
	public static void main(String[] args){
		
	try {
		BusDAO busdao=new BusDAO();
		busdao.diplayBusInfo();
		
		int useroupt=1;
		Scanner scanner=new Scanner(System.in);
		
		BookingDAO bookingdao=new BookingDAO();
		
		while(useroupt==1) {
			System.out.println("Enter 1 to book , 2 to cancel ticket and 3 to delete : ");
			useroupt=scanner.nextInt();
			if(useroupt==1) {
				Booking booking=new Booking();
				if(booking.isAvailable()) {
					int ticket=bookingdao.insert(booking);
				System.out.println("Your booking is confirmed and the ticket No: "+ticket);
			}
			}
				else if(useroupt==2) {
					System.out.println("Enter the Ticket number");
					int ticket_No=scanner.nextInt();
					System.out.println(bookingdao.delete(ticket_No)?"deleted":"there is no ticket to delete");
						
						
				}
			else System.out.println("Sorry. Bus is full.try");
		}
		scanner.close();
	
	}catch(Exception e){
		System.out.println(e);
	}
}
}
	



		
	  
	

	

		
	
	
	



