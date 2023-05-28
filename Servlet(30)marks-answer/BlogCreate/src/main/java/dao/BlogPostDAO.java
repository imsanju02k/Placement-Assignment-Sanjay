package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BlogPost;

public class BlogPostDAO {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/student";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "087407";

    public void insertBlogPost(BlogPost blogPost) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "INSERT INTO blog_posts (title, description, content) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, blogPost.getTitle());
            statement.setString(2, blogPost.getDescription());
            statement.setString(3, blogPost.getContent());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<BlogPost> getAllBlogPosts() {
        List<BlogPost> blogPosts = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT * FROM blog_posts";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String content = resultSet.getString("content");
                BlogPost blogPost = new BlogPost();
                blogPost.setId(id);
                blogPost.setTitle(title);
                blogPost.setDescription(description);
                blogPost.setContent(content);
                blogPosts.add(blogPost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return blogPosts;
    }

}
