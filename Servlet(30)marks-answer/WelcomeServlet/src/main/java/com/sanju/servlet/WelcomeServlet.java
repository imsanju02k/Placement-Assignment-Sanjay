package com.sanju.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet implements Serializable {
	private static final long serialVersionUID = 1L;

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        // Get the current session or create a new session if it doesn't exist
	        HttpSession session = request.getSession(true);

	        // Get the user's name from the request parameter
	        String name = request.getParameter("name");

	        if (name != null && !name.isEmpty()) {
	            // Store the user's name in the session
	            session.setAttribute("name", name);
	        }

	        // Retrieve the user's name from the session
	        String sessionName = (String) session.getAttribute("name");

	        // Create the HTML response
	        out.println("<html>");
	        out.println("<head><title>Welcome</title></head>");
	        out.println("<body>");
	        out.println("<h1>Welcome, " + sessionName + "!</h1>");
	        out.println("<form action='WelcomeServlet' method='GET'>");
	        out.println("<label for='name'>Enter your name:</label>");
	        out.println("<input type='text' id='name' name='name'>");
	        out.println("<input type='submit' value='Submit'>");
	        out.println("</form>");
	        out.println("</body>");
	        out.println("</html>");
	    }

}
