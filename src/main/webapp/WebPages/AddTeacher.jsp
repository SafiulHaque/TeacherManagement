<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Teacher</title>
</head>
<body>
<form style="margin:0 auto; width:250px;" action="addNew">
<table>
<thead><tr><th colspan="2">Add New Teacher</th></tr></thead>
<tbody>
<tr>
<td><label for="tid">Teacher ID : </label></td>
<td><input type="number" name="tid" value=${ id } readonly></td>
</tr>
<tr>
<td><label for="name">Name : </label></td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td><label for="age">Age : </label></td>
<td><input type="number" name="age"></td>
</tr>
<tr>
<td><label for="subject">Subject : </label></td>
<!-- <select name="subject">
<option value="Math">Math</option>
<option value="Physics">Physics</option>
<option value="Chemistry">Chemistry</option>
<option value="Java">Java</option>
<option value="Python">Python</option>
</select> -->
<td><input type="text" name="subject"></td>
</tr>
</tbody>
<tfoot><tr>
<td colspan="2"><input type="submit" value="Add" style="width:100%;"></td>
</tr></tfoot>

</table>


</form>
</body>
</html>