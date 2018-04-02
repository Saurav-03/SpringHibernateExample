<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
<a href="login">Login</a>
	
    
    <div align="center">
        <h1>New/Edit User</h1>
        <form:form action="registeration" method="post" modelAttribute="user">
        <table>
             <form:hidden path="id"/>
            <tr>
                <td>First Name:</td>
                <td>
                <form:input path="firstName" />
                <form:errors path="firstName" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td>
                <form:input path="lastName" />
                 <form:errors path="lastName" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>
                <form:input path="email" />
                 <form:errors path="email" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>Password:</td>
                <td>
                <form:password path="password" />
                 <form:errors path="password" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>