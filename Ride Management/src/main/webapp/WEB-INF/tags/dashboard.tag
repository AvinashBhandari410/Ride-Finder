<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GoMule Rides dashboard</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/navbar.css">
<head>
<!-- https://bootsnipp.com/snippets/featured/login-and-register-tabbed-form -->


<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">
</head>
<body>

	<div class="container">
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<img style="width: 200px;"
					src="${pageContext.request.contextPath}/resources/image/ucm.png"
					class="img-rounded" alt="Cinque Terre">
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav" id="ui1">

					<li class="active" id="li1"><a
						href="<c:url value='/ride/availableRides?searchRide=none'/>"
						class="active" id="AvailableRides-form-link">Available Rides</a></li>

					<li id="li2"><a
						href="<c:url value='/ride/myRidePostings?searchRide=none'/>"
						id="AvailableRides-form-link">My Ride Posting</a></li>

					<li id="li3"><a href="<c:url value='/ride/newpost'/>"
						id="ridePost-form-link">Post A Ride</a></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">
				
					<li><a href="<c:url value='/registration/logout'/>" > Log Out</a></li>
				</ul>
			</div>
		</div>
		</nav>
		<jsp:doBody />
	</div>
	<script
		src="${pageContext.request.contextPath}/webjars/jquery/2.1.4/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script>
		$(function() {

			$('#ui1 li').removeClass('active');
			if ($(location).attr('href').toLowerCase()
					.indexOf('availablerides') > -1) {
				$("#li1").addClass('active');
			} else if ($(location).attr('href').toLowerCase().indexOf(
					'myridepostings') > -1) {

				$("#li2").addClass('active');

			} else {
				$("#li3").addClass('active');
			}
		});
	</script>
</body>
</html>