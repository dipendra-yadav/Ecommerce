<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- DC Table Styles I CSS -->
<link type="text/css" rel="stylesheet" href="http://cdn.dcodes.net/2/tables1/css/dc_tables1.css" />

<style type="text/css">
body { background-image:url('http://cdn.dcodes.net/2/bg_images/wood/w15.jpg'); }
</style>

<%@include file="header.jsp"%>
</head>
<body>

<center>
	<h2>
		Manage Category
	</h2>
	<!-- <form action="manage_category_create" method="post">
		<input type="text" name="id"> <input type="text" name="name">
		<input type="text" name="description"> <input type="submit"
			value="Create">
	</form>
	-->


	<security:authorize access="hasRole('ROLE_ADMIN')">

		<a href="manage_category_create" class="btn btn-primary" role="button">Add
			Category</a>
	</security:authorize>
	</center>

  
  <!-- DC Table Styles I:3 Start -->
  <table class="dc_table_s3" summary="Sample Table" style="width:80%;">
    
    <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Description</th>
        <th scope="col">Action</th>
      </tr>
    </thead>
    </tr>
		</thead>
		<c:forEach var="category" items="${categoryList}">
			<tr>
				<td align="center">${category.id}</td>
				<td align="center">${category.name}</td>
				<td align="center">${category.description}</td>

				<td align="center" ><security:authorize access="hasRole('ROLE_ADMIN')">
						<a href="<c:url value="manage_category_edit/${category.id}"/>">Edit
							<span class="glyphicon glyphicon-edit"></span>
						</a>| <a
							href="<c:url value="manage_category_delete/${category.id}"/>">
							<span class="glyphicon glyphicon-trash"></span>delete
						</a>
					</security:authorize></td>

			</tr>
		</c:forEach>

	</table>
<!-- DC Table Styles I:3 End -->
  
  
  
  
  
  
  
  
  
	<%-- <hr>

	<table border="2">

		<thead>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Description</td>
				<td>Action</td>
			</tr>
		</thead>
		<c:forEach var="category" items="${categoryList}">
			<tr>
				<td>${category.id}</td>
				<td>${category.name}</td>
				<td>${category.description}</td>

				<td><security:authorize access="hasRole('ROLE_ADMIN')">
						<a href="<c:url value="manage_category_edit/${category.id}"/>">Edit
							<span class="glyphicon glyphicon-edit"></span>
						</a>| <a
							href="<c:url value="manage_category_delete/${category.id}"/>">
							<span class="glyphicon glyphicon-trash"></span>delete
						</a>
					</security:authorize></td>

			</tr>
		</c:forEach>

	</table> --%>

	<br>
	<br>
	<%-- ${category.id} &nbsp;&nbsp; ${category.name}&nbsp;&nbsp;
	${category.description}&nbsp;&nbsp; --%>
<%@ include file="footer.jsp"%>

</body>
</html>