package com.sanju.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/fetch")
public class FectchingData extends HttpServlet implements Serializable {
	private static final long serialVersionUID = 1L;

	// JDBC connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/student";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "087407";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	
	
	try {
        // Connect to the database
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        // Create a SQL statement
        Statement stmt = conn.createStatement();

        // Execute the query
        String sql = "SELECT * FROM crud";
        ResultSet rs = stmt.executeQuery(sql);

        // Create the HTML table
        out.println("<html>");
        out.println("<head><title>Table Data</title></head>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Age</th></tr>");

        // Iterate over the result set and display the data in the table
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");

            out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + age + "</td></tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

        // Clean up resources
        rs.close();
        stmt.close();
        conn.close();
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        out.println("An error occurred while retrieving data from the database.");
    }
}


}

