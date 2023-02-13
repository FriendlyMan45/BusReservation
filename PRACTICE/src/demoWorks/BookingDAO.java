package demoWorks;

import java.sql.*;
import java.util.Date;

public class BookingDAO {
         public int getBookedCount(int busNO,Date date) throws SQLException {
        	 Connection con=DBconnection.getConnection();
        	 String query="select count(passenger_Name) from booking where busNo=? and Dateofpassenger=?";
        	 PreparedStatement pst=con.prepareStatement(query);
        	 pst.setInt(1, busNO);
        	 java.sql.Date sqldate=new java.sql.Date(date.getTime());
        	 pst.setDate(2, sqldate);
        	 ResultSet rs=pst.executeQuery();
        	 
        	rs.next();
        	 
    return rs.getInt(1);
         } 
         
         public int insert(Booking booking) throws SQLException {
        	 Connection con=DBconnection.getConnection();
        	 
        	 String query1="insert into booking(busNo,passenger_Name,Dateofpassenger,email_id) values(?,?,?,?)";
        	
        	 PreparedStatement pst=con.prepareStatement(query1);
        	 
        	 pst.setInt(1, booking.busNo);
        	 pst.setString(2, booking.passengerName);
        	 java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());
        	 pst.setDate(3, sqldate);
        	 pst.setString(4, booking.mail);
        	 pst.executeUpdate();
        	
        	 String query2="select Ticket_No from booking where email_id="+"'"+booking.mail+"'";
        	 String a=booking.mail;
        	 Statement st=con.createStatement();
        	 ResultSet ticket_No=st.executeQuery(query2);
        	 ticket_No.next();
        	 
        	 return ticket_No.getInt(1);
         }
         
         public boolean delete(int ticket) throws SQLException {
        	 Connection con=DBconnection.getConnection();
        	 String query="delete from booking where Ticket_No ="+ticket;
        	 Statement st=con.createStatement();
        	 int rs=st.executeUpdate(query);
        	 
        	 return rs==1?true:false;
         }
}
