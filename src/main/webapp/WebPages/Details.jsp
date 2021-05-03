<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.safi.TeacherManagement.Models.Teacher" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
<%-- ${teacher.getName()} --%>
<% Teacher t=(Teacher)request.getAttribute("teacher"); %>
<p>Id : <%= t.gettId() %></p>
<p>Name : <%= t.getName() %></p>
<p>Age : <%= t.getAge() %></p>
<p>Subject : <%= t.getSubject() %></p>
</body>
</html>