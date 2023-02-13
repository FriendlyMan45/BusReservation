package demoWorks;


import java.sql.*;

public class BusDAO {
           
	
	public  void diplayBusInfo() throws SQLException {
		Connection con =DBconnection.getConnection();
		String query="select*from bus";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		while(rs.next()) {
			  System.out.println("Bus NO is : "+rs.getInt(1));
              if(rs.getBoolean(2))
            	  System.out.println("Bus comes with AC avalability");
              else { System.out.println("Bus not comes with AC avalability");  }
              System.out.println("Bus capacity : "+rs.getInt(3));
              System.out.println();
		}
		  System.out.println("-------------------------------------------");
		  con.close();
	}
	
	
	public int getCapacity(int id) throws SQLException {
		String query="select capacity from bus where busNo="+id;
		Connection con=DBconnection.getConnection();
		Statement st=con.createStatement();
	    ResultSet rs=st.executeQuery(query);
	    rs.next();
	    
	    return rs.getInt(1);
	}
	
	
	
}
