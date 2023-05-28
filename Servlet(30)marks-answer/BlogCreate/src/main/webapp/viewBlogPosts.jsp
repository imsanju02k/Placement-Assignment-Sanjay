<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Blog Posts</title>
</head>
<body>
    <h1>View Blog Posts</h1>
    <table>
        <thead>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Content</th>
            </tr>
        </thead>
       <tbody>
    <c:forEach var="blogPost" items="${blogPosts}">
        <tr>
            <td>${blogPost.title}</td>
            <td>${blogPost.description}</td>
            <td>${blogPost.content}</td>
        </tr>
    </c:forEach>
</tbody>
    </table>
</body>
</html>