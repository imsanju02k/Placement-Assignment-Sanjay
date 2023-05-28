package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mysqlconnection {
	public static void main(String[] args) {
		
		// MYSQL CONNECTION DETAILS
		
		String url="jdbc:mysql://localhost:3306/student";
		String username="root";
		String password="087407";
		
		System.out.println("CONNECTION object created...");
		
		//SQL query to retrieve data
		
		String query="select * from student ";
		
		try {
			//Register the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create a Connection to the database
			Connection connection=DriverManager.getConnection(url,username,password);
			
			//Create a STATMENT object
			Statement statement=connection.createStatement();
			
			//Exceute the query
			ResultSet resultSet=statement.executeQuery(query);
			
			//process the result set
			
			while(resultSet.next()) {
				//Retrieve the data from each column
				int id=resultSet.getInt("sid");
				String address=resultSet.getString("saddress");
				int age=resultSet.getInt("sage");
				String name=resultSet.getString("sname");
				String desg=resultSet.getString("desg");
				int salary=resultSet.getInt("salary");
				Float avg=resultSet.getFloat("avg");
				
				//Display the retrieved data
		         
				System.out.println("Id = "+ id + " Name = " + name + " Salary = " + salary);
				
			}
			// Close the resources
            resultSet.close();
            statement.close();
            connection.close();
			
		} catch (ClassNotFoundException e) {
			 System.out.println("MySQL JDBC driver not found.");
              e.printStackTrace();
		} catch (SQLException e) {
			 System.out.println("Error occurred while connecting to the database.");
			e.printStackTrace();
		}
		
	}

}
