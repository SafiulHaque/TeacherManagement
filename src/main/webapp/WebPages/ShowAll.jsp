<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>

<%@ page import="java.util.List,com.safi.TeacherManagement.Models.Teacher" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Teacher Details</title>
</head>
<body>
<%-- <c:forEach var="name" items="names">
${ name }
</c:forEach>
<c:forEach var="subject" items="subjects">
${ subject }
</c:forEach> --%>

<%
/* List<String> names=(List)request.getAttribute("names");
List<String> subjects=(List)request.getAttribute("subjects"); */
List<Teacher> teachers=(List)request.getAttribute("teachers");
%>

<%-- ${names }
${subjects } --%>

<table>
<thead>
<tr>
<th>Name</th>
<th>Subject</th>
</tr>
</thead>
<%
for(Teacher teacher:teachers){
%>
<tbody>
<tr>
<td><%=teacher.getName() %></td>
<td><%=teacher.getSubject() %></td>
</tr>
</tbody>
<%
}
%>
</table>

</body>
</html>