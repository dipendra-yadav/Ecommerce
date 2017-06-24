<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<style type="text/css">
body {
	background-image: url('http://cdn.dcodes.net/2/bg_images/wood/w15.jpg');
}
</style>

<script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@ include file="header.jsp"%>

</head>

<div class="bg-img">
	<div class="container-fluid ">


		<div
			class="productdetails col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-10 col-xs-offset-1">

			<div data-ng-app="myapp">

				<div class="productimage">
					<c:url var="url" value="/resources/images/${product.id}.png"></c:url>
					<img class="img-responsive col-md-8 col-md-offset-2" id="myImg"
						src="${url }" align="right" width: 10%" />
				</div>

				<!--<c:url value="/cart/add/${product.id}" var="carturl"></c:url>-->
				
				<div data-ng-controller="productController">
					<div class="addcarticon">


						<security:authorize access="hasRole('ROLE_USER')">
							<a href="" data-ng-click="addToCart(${product.id})"
								class=" btn btn-info btn-lg"> <span
								class="glyphicon glyphicon-shopping-cart"></span>Add to Cart
							</a>
						</security:authorize>

					</div>
				</div>
			</div>

			<div class="details">
				<h4>Product</h4>

				${product.name }<br /> <br /> by <b> ${product.supplier.name }</b>



				<h4>Price</h4>
				${product.price} <br /> <br />
				<h4>Description</h4>
				${product.description} <br /> <br />
				<h4>Category</h4>
				${product.category.name } <br /> <br />
				<h4>Product ID</h4>
				${product.id }<br /> <br /> <br />

			</div>
			<div>
			<a href="<c:url value="/getAllProducts"></c:url>"
				class="btn btn-info btn-lg">Back</a>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>