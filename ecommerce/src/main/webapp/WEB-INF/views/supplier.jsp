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
</head>
<body>
<style type="text/css">
body { background-image:url('http://cdn.dcodes.net/2/bg_images/wood/w15.jpg'); }
</style>

	<center>
	<h2>
		Manage Supplier
	</h2>
	<security:authorize access="hasRole('ROLE_ADMIN')">
		<a href="manage_supplier_create" class="btn btn-primary" role="button">Add
			Supplier</a>

	</security:authorize>
	<center>

<center>
<!-- DC Table Styles I:3 Start -->
  <table class="dc_table_s3" summary="Sample Table" style="width:80%;">
    
    <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Address</th>
        <th scope="col">Action</th>
      </tr>
    </thead>
   
		
		<c:forEach var="supplier" items="${supplierList}">
			<tr>
				<td align="center">${supplier.id}</td>
				<td align="center">${supplier.name}</td>
				<td align="center">${supplier.address}</td>

				<td align="center"><security:authorize access="hasRole('ROLE_ADMIN')">

						<a href="<c:url value="manage_supplier_edit/${supplier.id}"/>">Edit
							<span class="glyphicon glyphicon-edit"></span>
						</a>| <a href="<c:url value="manage_supplier_delete/${supplier.id}"/>">
							<span class="glyphicon glyphicon-trash"></span>delete
						</a>
					</security:authorize>
				</td>

			</tr>
		</c:forEach>

	</table></center>
<!-- DC Table Styles I:3 End -->
















	<hr>

	<!--  <table border="2">

		<thead>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Address</td>
				<td>Action</td>

			</tr>
		</thead>
		<c:forEach var="supplier" items="${supplierList}">
			<tr>
				<td>${supplier.id}</td>
				<td>${supplier.name}</td>
				<td>${supplier.address}</td>

				<td><security:authorize access="hasRole('ROLE_ADMIN')">

						<a href="<c:url value="manage_supplier_edit/${supplier.id}"/>">Edit
							<span class="glyphicon glyphicon-edit"></span>
						</a>| <a href="<c:url value="manage_supplier_delete/${supplier.id}"/>">
							<span class="glyphicon glyphicon-trash"></span>delete
						</a>
					</security:authorize></td>

			</tr>
		</c:forEach>

	</table>-->

	<br>
	<br>
	<%-- ${category.id} &nbsp;&nbsp; ${category.name}&nbsp;&nbsp;
	${category.description}&nbsp;&nbsp; --%>


</body>
</html>