<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>fasfafdasdf
<a href="logout">Logout</a>
	<div align="center">
		<h1>Users List</h1>
		
		<table border="1">

			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Action</th>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.email}</td>
					<td><a href="editUser?id=${user.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteUser?id=${user.id}">Delete</a></td>

				</tr>
			</c:forEach>
			</table>
		<h4>
			New User Register <a href="registeration">here</a>
		</h4>
	</div>
</body>
</html>