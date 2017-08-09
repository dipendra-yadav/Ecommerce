<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp"%>
<style type="text/css">
body {
	background-image: url('http://cdn.dcodes.net/2/bg_images/wood/w15.jpg');
}
</style>
</head>
<body>
	
	<c:if test="${isUserClickedCategories==true}">
		<jsp:include page="category.jsp" />
	</c:if>
	<c:if test="${isUserClickedProducts==true}">
		<jsp:include page="product.jsp" />
	</c:if>
	<c:if test="${isUserClickedSuppliers==true}">
		<jsp:include page="supplier.jsp" />
	</c:if>


	<%@ include file="footer.jsp"%>
</body>
</html>