<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>
<%@ page isELIgnored="false"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Customer</title>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	background-image: url('http://cdn.dcodes.net/2/bg_images/wood/w15.jpg');
}
</style>
</head>
<body>
	<div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>Register Customer</h1>

				<p class="lead">Please fill in your information below:</p>
			</div>
			<c:url value="/customer/registration" var="url"></c:url>
			<form:form action="${url}" method="post" commandName="customer">

				<h3>Basic Info:</h3>


				<div class="form-group">
					<label for="name">Name</label>


					<form:errors path="customerName" cssStyle="color: #ff0000" />
					<form:input path="customerName" class="form-Control" />
				</div>

				<div class="form-group">
					<label for="email">Email</label>

					<form:errors path="customerEmail" cssStyle="color: #ff0000" />
					<form:input path="customerEmail" class="form-Control" />
					<c:if test="${duplicateEmail!=null }">
        ${duplicateEmail }
        </c:if>

				</div>


				<div class="form-group">
					<label for="phone">Phone</label>
					<form:input path="customerPhone" class="form-Control" />
				</div>

				<div class="form-group">
					<label for="username">Username</label>
					<form:errors path="user.name" cssStyle="color: #ff0000" />
					<form:input path="user.name" class="form-Control" />
					<c:if test="${duplicateUname!=null }">
       			 ${duplicateUname }
            </c:if>
				</div>

				<div class="form-group">
					<label for="password">Password</label>
					<form:errors path="user.password" cssStyle="color: #ff0000" />
					<form:password path="user.password" class="form-Control" />
				</div>


				<br />

				<h3>Billing Address:</h3>

				<div class="form-group">
					<label for="billingStreet">Street Name</label>
					<form:input path="billingAddress.streetName" class="form-Control" />
				</div>

				<div class="form-group">
					<label for="billingApartmentNumber">Apartment Number</label>
					<form:input path="billingAddress.apartmentNumber"
						class="form-Control" />
				</div>

				<div class="form-group">
					<label for="billingCity">City</label>
					<form:input path="billingAddress.city" class="form-Control" />
				</div>

				<div class="form-group">
					<label for="billingState">State</label>
					<form:input path="billingAddress.state" class="form-Control" />
				</div>

				<div class="form-group">
					<label for="billingCountry">Country</label>
					<form:input path="billingAddress.country" class="form-Control" />
				</div>

				<div class="form-group">
					<label for="billingZip">Zipcode</label>
					<form:input path="billingAddress.zipcode" class="form-Control" />
				</div>

				<br />

				<h3>Shipping Address:</h3>

				<div class="form-group">
					<label for="shippingStreet">Street Name</label>
					<form:input path="shippingAddress.streetName" class="form-Control" />
				</div>

				<div class="form-group">
					<label for="shippingApartmentNumber">Apartment Number</label>
					<form:input path="shippingAddress.apartmentNumber"
						class="form-Control" />
				</div>

				<div class="form-group">
					<label for="shippingCity">City</label>
					<form:input path="shippingAddress.city" class="form-Control" />
				</div>

				<div class="form-group">
					<label for="shippingState">State</label>
					<form:input path="shippingAddress.state" class="form-Control" />
				</div>

				<div class="form-group">
					<label for="shippingCountry">Country</label>
					<form:input path="shippingAddress.country" class="form-Control" />
				</div>

				<div class="form-group">
					<label for="shippingZip">Zipcode</label>
					<form:input path="shippingAddress.zipcode" class="form-Control" />
				</div>

				<br />
				<br />

				<input type="submit" value="submit" class="btn btn-default">
				<a href="<c:url value="/" />" class="btn btn-default">Cancel</a>

			</form:form>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
