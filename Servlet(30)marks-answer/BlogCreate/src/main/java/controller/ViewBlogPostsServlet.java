package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlogPostDAO;
import model.BlogPost;

/**
 * Servlet implementation class ViewBlogPostsServlet
 */
@WebServlet("/view")
public class ViewBlogPostsServlet extends HttpServlet implements Serializable {
	private static final long serialVersionUID = 1L;
	 private BlogPostDAO blogPostDAO;

	public void init(ServletConfig config) throws ServletException {
		 blogPostDAO = new BlogPostDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<BlogPost> blogPosts = blogPostDAO.getAllBlogPosts();
	        request.setAttribute("blogPosts", blogPosts);
	        request.getRequestDispatcher("viewBlogPosts.jsp").forward(request, response);
	}

}
