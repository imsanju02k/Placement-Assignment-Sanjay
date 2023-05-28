package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlogPostDAO;
import model.BlogPost;


@WebServlet("/create")
public class CreateBlogPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogPostDAO blogPostDAO;
	
	
	public void init(ServletConfig config) throws ServletException {
		 blogPostDAO = new BlogPostDAO();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String title = request.getParameter("title");
	        String description = request.getParameter("description");
	        String content = request.getParameter("content");

	        BlogPost blogPost = new BlogPost();
	        blogPost.setTitle(title);
	        blogPost.setDescription(description);
	        blogPost.setContent(content);

	        blogPostDAO.insertBlogPost(blogPost);

	        response.sendRedirect("view");
	}

}
