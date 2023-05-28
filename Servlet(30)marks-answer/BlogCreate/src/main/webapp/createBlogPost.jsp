<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Blog Post</title>
</head>
<body>
    <h1>Create Blog Post</h1>
    <form action="create" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required>
        <br>
        <label for="description">Description:</label>
        <input type="text" id="description" name="description" required>
        <br>
        <label for="content">Content:</label>
        <textarea id="content" name="content" required></textarea>
        <br>
        <input type="submit" value="Create">
    </form>
</body>
</html>