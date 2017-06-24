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

				<h3>Basic Info:</h3>

				<div class="form-group">
					<label for="name">Name</label>
					<form:input path="cart.customer.customerName" id="name"
						class="form-Control" />
				</div>

				<div class="form-group">
					<label for="email">Email</label>
					<form:input path="cart.customer.customerEmail" id="email"
						class="form-Control" />
				</div>

				<div class="form-group">
					<label for="phone">Phone</label>
					<form:input path="cart.customer.customerPhone" id="phone"
						class="form-Control" />
				</div>

				<br />

				<h3>Billing Address:</h3>

				<div class="form-group">
					<label for="billingStreet">Street Name</label>
					<form:input path="cart.customer.billingAddress.streetName"
						id="billingStreet" class="form-Control" />
				</div>

				<div class="form-group">
					<label for="billingApartmentNumber">Apartment Number</label>
					<form:input path="cart.customer.billingAddress.apartmentNumber"
						id="billingApartmentNumber" class="form-Control" />
				</div>

				<div class="form-group">
					<label for="billingCity">City</label>
					<form:input path="cart.customer.billingAddress.city"
						id="billingCity" class="form-Control" />
				</div>

				<div class="form-group">
					<label for="billingState">State</label>
					<form:input path="cart.customer.billingAddress.state"
						id="billingState" class="form-Control" />
				</div>

				<div class="form-group">
					<label for="billingCountry">Country</label>
					<form:input path="cart.customer.billingAddress.country"
						id="billingCountry" class="form-Control" />
				</div>

				<div class="form-group">
					<label for="billingZip">ZipCode</label>
					<form:input path="cart.customer.billingAddress.zipcode"
						id="billingZip" class="form-Control" />
				</div>

				<input type="hidden" name="_flowExecutionKey" />

				<br />
				<br />
				<!--  on attribute - assign event id -->
				<!--  to attribute id value in state -->

				<input type="submit" value="Next" class="btn btn-primary"
					name="_eventId_customerInfoCollected" />

				<button class="btn btn-default" name="_eventId_cancel">Cancel</button>

			</form:form>
		</div>
	</div>
</body>
</html>