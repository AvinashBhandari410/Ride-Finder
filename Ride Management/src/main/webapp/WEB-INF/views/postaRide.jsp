<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<t:dashboard>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<c:choose>
									<c:when test="${message == 'success'}">
										<div class="alert alert-success">
											<a href="#" class="close" data-dismiss="alert"
												aria-label="close" title="close">×</a><strong>Success!</strong>
											New ride posted successfully !!
										</div>
									</c:when>
									<c:when test="${message == 'fail'}">
										<div class="alert alert-danger">
											<a href="#" class="close" data-dismiss="alert"
												aria-label="close" title="close">×</a><strong>Error!</strong>
											New ride posted failed !!
										</div>
									</c:when>
									<c:otherwise>
										<div class="alert alert-success">
											<a href="#" class="close" data-dismiss="alert"
												aria-label="close" title="close">×</a><strong>Welcome to GoMules!!!</strong>
										</div>
									</c:otherwise>
								</c:choose>
								<c:url var="ride_url" value="/ride/newpost" />
								<form:form id="Posting-form" method="POST" action="${ride_url}"
									role="form" style="display: block;" modelAttribute="RideModel">
									<input type="hidden" value="0" id="rideID" name="rideID" />
									<div class="form-group">
										<input type="text" name="rideTitle" id="rideTitle"
											tabindex="1" class="form-control" placeholder="Ride Title"
											value="" maxlength="50" required autofocus />
									</div>
									<div class="form-group">
										<textarea type="text" name="rideDescription"
											id="rideDescription" maxlength="500" tabindex="2"
											class="form-control" placeholder="Ride Description" required
											autofocus></textarea>
									</div>
									<div class="form-group">
										<input type="text" name="source" id="source" tabindex="3"
											class="form-control" placeholder="Source Location"
											maxlength="20" required autofocus />
										<%-- <select class="form-control">
				<option>SELECT SOURCE LOCATION</option>
				<c:forEach var="states" items="${rideStates}">
					<option value="${states.getStateID()}">${states.getState()}
						${ states.getStateCode()}</option>
				</c:forEach>
			</select> --%>
									</div>
									<div class="form-group">
										<input type="text" name="destination" id="destination"
											tabindex="4" class="form-control"
											placeholder="Destination Location" maxlength="20" required
											autofocus />
										<%-- <select  class="form-control">
		<option>SELECT DESTINATION LOCATION</option>
		    <c:forEach var="states" items="${rideStates}">
              <option   value="${states.getStateID()}"  >${states.getState()} ${ states.getStateCode()}</option>
		 	</c:forEach>
		 	</select> --%>
									</div>
									<div class="form-group">
										<input type="text" name="vehicleName" id="vehicleName"
											tabindex="5" class="form-control"
											placeholder="Vehicle Name. Ex. Honda Civic" maxlength="10"
											required autofocus />
									</div>
									<div class="form-group">
										<input type="text" name="phoneNumber" id="phoneNumber"
											tabindex="6" type="number" class="form-control"
											placeholder="Phone Number" maxlength="16" required autofocus
											onkeypress="formatPhone(this)" onblur="formatPhone(this)"
											onkeyup="formatPhone(this)" />
									</div>
									<div class='form-group'>
										<div class='input-group date' id='datetimepicker'>
											<input type="text" name="rideDate" id="rideDate" tabindex="7"
												class="form-control" placeholder="Ride Date" maxlength="10"
												required autofocus /> <span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="Post-submit" id="Post-submit"
													tabindex="8" class="form-control btn btn-login"
													value="Post Ride">
											</div>
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</t:dashboard>
<link rel="stylesheet" type="text/css" media="screen"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link
	href="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/build/css/bootstrap-datetimepicker.css"
	rel="stylesheet">
	
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">
<script type="text/javascript"
	src="//code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript"
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>

<script
	src="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/src/js/bootstrap-datetimepicker.js"></script>
<script>
	$(function() {
		// Bootstrap DateTimePicker v4
		var dateToday = new Date();
		$('#datetimepicker').datetimepicker({
			format : 'MM/DD/YYYY',
			minDate : dateToday,
		});
	});
	
	function formatPhone(obj) {
	     var numbers = obj.value.replace(/\D/g, ''),
	 char = { 0: '(', 3: ') ', 6: ' - ' };
	     obj.value = '';
	     for (var i = 0; i < numbers.length; i++) {
	         obj.value += (char[i] || '') + numbers[i];
	     }
	 }
</script>