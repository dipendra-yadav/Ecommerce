<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/header.jsp"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="<c:url value="/resources/js/controller.js"></c:url>"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>Customer</h1>


				<p class="lead">Customer Details:</p>
			</div>

			<form:form commandName="order" class="form-horizontal">

				<h3>Shipping Address:</h3>

				<div class="form-group">
					<label for="shippingStreet">Street Name</label>
					<form:input path="cart.customer.shippingAddress.streetName"
						id="shippingStreet" class="form-Control" />
				</div>

				<div class="form-group">
					<label for="shippingApartmentNumber">Apartment Number</label>
					<form:input path="cart.customer.shippingAddress.apartmentNumber"
						id="shippingApartmentNumber" class="form-Control" />
				</div>

				<div class="form-group">
					<label for="shippingCity">City</label>
					<form:input path="cart.customer.shippingAddress.city"
						id="shippingCity" class="form-Control" />
				</div>

				<div class="form-group">
					<label for="shippingState">State</label>
					<form:input path="cart.customer.shippingAddress.state"
						id="shippingState" class="form-Control" />
				</div>

				<div class="form-group">
					<label for="shippingCountry">Country</label>
					<form:input path="cart.customer.shippingAddress.country"
						id="shippingCountry" class="form-Control" />
				</div>

				<div class="form-group">
					<label for="shippingZip">ZipCode</label>
					<form:input path="cart.customer.shippingAddress.zipcode"
						id="shippingZip" class="form-Control" />
				</div>

				<input type="hidden" name="_flowExecutionKey" />

				<br />
				<br />

				<button class="btn btn-primary"
					name="_eventId_backToCollectCustomerInfo">Back</button>

				<input type="submit" value="Next" class="btn btn-primary"
					name="_eventId_shippingDetailCollected" />

				<button class="btn btn-default" name="_eventId_cancel">Cancel</button>

			</form:form>
		</div>
	</div>
</body>
</html>
