<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<!-- DC Table Styles I CSS -->
<link type="text/css" rel="stylesheet" href="http://cdn.dcodes.net/2/tables1/css/dc_tables1.css" />
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
body { background-image:url('http://cdn.dcodes.net/2/bg_images/wood/w15.jpg'); }
</style>

	<c:url value="manage_product_create" var="url"></c:url>

	<form:form method="post" action="${url}" commandName="createProductObj"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td><form:label path="id">Product Id</form:label></td>
				<td><form:input path="id" disabled="true" class="form-control"></form:input></td>
				<%-- <td><form:hidden path="id" /></td> --%>
			</tr>
			<tr>
				<td><form:label path="name">Product Name</form:label></td>
				<td><form:input path="name" class="form-control"></form:input></td>
				<td><form:errors path="name" /></td>
			</tr>
			
			<tr>
				<td><form:label path="price">Product Price</form:label></td>
				<td><form:input path="price" class="form-control"></form:input></td>
				<td><form:errors path="price" /></td>
			</tr>

			<tr>
				<td><form:label path="description">Product Description</form:label></td>
				<td><form:input path="description" class="form-control"></form:input></td>
				<td><form:errors path="description" /></td>
			</tr>
			<tr>
				<td><form:label path="supplier">
						<spring:message text="Supplier" />
					</form:label></td>
				<td><form:select path="supplier.name" items="${supplierList}"
						itemValue="name" itemLabel="name" class="form-control" /></td>
			</tr>
			<tr>
				<td><form:label path="category">
						<spring:message text="Category" />
					</form:label></td>
				<td><form:select path="category.name" items="${categoryList}"
						itemValue="name" itemLabel="name" class="form-control" /></td>
			</tr>

			<tr>
				<td><form:label path="image">
						<spring:message text="image" />
					</form:label></td>
				<td><form:input path="image" type="file" /></td>

			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Add Product"
					class="btn btn-default"></td>
			</tr>
		</table>
	</form:form>

	<%@include file="footer.jsp"%>

</body>
</html>