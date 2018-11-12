<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:dashboard>

	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/rideposting.css">

	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/webjars/font-awesome/4.4.0/css/font-awesome.min.css">
	<div>
		<div class="panel panel-default panel-table">
			<div class="panel-heading">
			<div class="col-lg-12">
				<c:choose>
					<c:when test="${message == 'success'}">
						<div class="alert alert-success">
							<a href="#" class="close" data-dismiss="alert" aria-label="close"
								title="close">×</a><strong>Success!</strong> New ride posted
							successfully !!
						</div>
					</c:when>
					<c:when test="${message == 'fail'}">
						<div class="alert alert-danger">
							<a href="#" class="close" data-dismiss="alert" aria-label="close"
								title="close">×</a><strong>Error!</strong> New ride posted
							failed !!
						</div>
					</c:when>
					<c:otherwise>
						<div class="alert alert-success">
							<a href="#" class="close" data-dismiss="alert" aria-label="close"
								title="close">×</a><strong>Welcome to GoMules!!!</strong>
						</div>
					</c:otherwise>
				</c:choose>
				</div>
				<div class="row">
					<div class="col col-xs-8">
						<h3 class="panel-title">Available Rides</h3>
					</div>
					<c:url var="ride_url" value="/ride/availableRides" />
					<form:form id="Posting-form" method="GET" action="${ride_url}"
						role="form" style="display: block;">
						<div class="col col-xs-3 text-right">
							<input id="searchRide" name="searchRide"
								placeholder="Search a ride" class="form-control" type="text"
								value="">
						</div>
						<div class="col col-xs-1 text-right">
							<button class="btn btn-sm btn-primary btn-create">Search</button>

						</div>
					</form:form>
				</div>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered table-list">

					<thead>
						<tr>
							<th style="display: none"><em class="fa fa-cog"></em></th>
							<th class="hidden-xs">Email Address</th>
							<th class="hidden-xs">About Ride</th>
							<th>From</th>
							<th>To</th>
							<th>Date of Ride</th>
							<th>Phone Number</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="rides" items="${allRides}">

							<tr>
								<td align="center" style="display: none"><a
									class="btn btn-danger" data-title="Edit" data-toggle="modal"
									data-target="#edit" onclick="callAjax('${rides[1]}')"> <em
										class="fa fa-car"></em>
								</a></td>
								<td class="hidden-xs">${rides[0] }</td>
								<td class="hidden-xs">${rides[2] }</td>
								<td>${rides[3] }</td>
								<td>${rides[4] }</td>
								<td>${rides[5] }</td>
								<td>${rides[6] }</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>

			</div>
			<div class="panel-footer">
				<div class="row"></div>
			</div>
		</div>
	</div>

	<!-- 	Modal starts from here. -->

	<div class="modal fade" id="edit" tabindex="-1" role="dialog"
		aria-labelledby="edit" aria-hidden="true" style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</button>
					<h4 class="modal-title custom_align" id="Heading">Edit Your
						Detail</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<input type="text" name="rideTitle" id="rideTitle" tabindex="1"
							class="form-control" placeholder="Ride Title" value=""
							maxlength="50" required autofocus />
					</div>
					<div class="form-group">

						<textarea type="text" name="rideDescription" id="rideDescription"
							maxlength="500" tabindex="2" class="form-control"
							placeholder="Ride Description" required autofocus></textarea>
					</div>
					<div class="form-group">
						<input type="text" name="source" id="source" tabindex="3"
							class="form-control" placeholder="Source Location" maxlength="20"
							required autofocus />
					</div>
					<div class="form-group">
						<input type="text" name="destination" id="destination"
							tabindex="4" class="form-control"
							placeholder="Destination Location" maxlength="20" required
							autofocus />
					</div>
				</div>
				<div class="modal-footer ">
					<span class="glyphicon glyphicon-ok-sign"></span>&nbsp;<input
						type="submit" name="Post-submit" id="Post-submit" tabindex="7"
						class="btn btn-warning btn-lg" value="Update">
					<!-- <button type="button" class="btn btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span>&nbsp;Update</button> -->
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!--     Modal ends here -->
</t:dashboard>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">
<script src="http://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<script type="text/javascript">


 
 function callAjax(rideID){
	 debugger
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url: '<%=request.getContextPath()%>/riderest/getRide?rideID='
					+ rideID,
			success : function(result) {
				console.log('det', result);
				$.each(result.data, function(i, ride) {
					$("#rideTitle").val(ride.rideTitle);
					$("#rideDescription").val(ride.rideDescription);
					$("#source").val(ride.source);
					$("#destination").val(ride.destination);
				});
				$("#rideTitle").val()
				console.log("Success: ", result);
			},
			error : function(e) {
				debugger
				console.log("ERROR: ", e);
			}
		});
	}
</script>


