<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
body { background-image:url('http://cdn.dcodes.net/2/bg_images/wood/w15.jpg'); }
</style>
	<center>This is Registration page</center>


	<form:form action="register" method="post" commandName="">

		<table>
			<tr>
				<td><form:label path="id">User Id</form:label></td>
				<td><form:input path="id" disabled="true" /></td>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="name">User Name</form:label></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" /></td>

			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" /></td>

			</tr>
			<tr>
				<td><form:label path="mail">Email</form:label></td>
				<td><form:input path="mail" /></td>
				<td><form:errors path="mail" /></td>

			</tr>
			<tr>
				<td><form:label path="contact">Phone</form:label></td>
				<td><form:input path="contact" /></td>
				<td><form:errors path="contact" /></td>

			</tr>
			<!--  <tr>
				<td><form:label path="role">Role</form:label></td>
				<td><form:input path="role" /></td>
				<td><form:errors path="role" /></td>

			</tr>
			
			-->
			<tr>
				<td colspan="2"><input type="submit" value="Register"
					class="btn btn-default"></td>
			</tr>


		</table>




	</form:form>
</body>
</html>