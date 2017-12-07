<%@page import="yeohangout.javabeans.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="dashboard for managers" />
<meta name="author" content="jude hokyoon woo - yeo hang out" />
<title>Yeo Hang Out</title>
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/assets/css/dashboard.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/datatables.min.css" />
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="../index.jsp">Yeo Hang Out</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath}/index.jsp">HOME</a></li>
					<li><a href="#">SETTINGS</a></li>
					<li><a href="${pageContext.request.contextPath}/logout">LOG OUT</a></li>
					<li><a href="#">HELP</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<% ArrayList<Customer> custArr = (ArrayList<Customer>) session.getAttribute("custArr");
	%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="dashboard-manager-overview.jsp">Overview </a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="${pageContext.request.contextPath}/view-employee">Manage Employee</a></li>
					<li><a href="${pageContext.request.contextPath}/view-customer">Manage
							Customer</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="${pageContext.request.contextPath}/view-sales-report">View Sales Report</a></li>
					<li><a href="${pageContext.request.contextPath}/view-reservation">View Reservation</a></li>
					<li><a href="${pageContext.request.contextPath}/view-total-revenue">View Total Revenue</a></li>					
					<li><a href="${pageContext.request.contextPath}/view-flight">View Flight</a></li>
					<li class="active"><a href="#">View Customer <span class="sr-only">(current)</span></a></li>
				</ul>
				<ul>
					<li><a data-toggle="modal" data-target="#addAirline"><span
							class="glyphicon glyphicon-user"></span>Add Airline</a></li>
					<li><a data-toggle="modal" data-target="#addFlight"><span
							class="glyphicon glyphicon-user"></span>Add Flight</a></li>
					<li><a data-toggle="modal" data-target="#addAirport"><span
							class="glyphicon glyphicon-user"></span>Add Airport</a></li>
					<li><a data-toggle="modal" data-target="#addLeg"><span
							class="glyphicon glyphicon-user"></span>Add Leg</a></li>
				</ul>
			</div>
			<div
				class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">View Seated Customer</h1>
				<div class="table-responsive">
					<table id="table-1" class="table table-striped">
						<thead>
							<tr>
								<th>Account Number</th>
								<th>Name</th>
								<th>Seat Number</th>
								<th>Flight Number</th>
								<th>Airline</th>
								<th>Leg Number</th>
							</tr>
						</thead>
						<tbody>
						<% for (int i=0; i<custArr.size(); i++) { %>
							<tr>
								<td><%= custArr.get(i).getAccountNo() %></td>
								<td><%= custArr.get(i).getName() %></td>
								<td><%= custArr.get(i).getSeatNo() %></td>
								<td><%= custArr.get(i).getFlightNo() %></td>
								<td><%= custArr.get(i).getAirlineID() %></td>
								<td><%= custArr.get(i).getLegNo() %></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="../dashboard-manager/employee_add.jsp" %>
	<%@include file="../dashboard-manager/employee_add_flight.jsp"%>	
	<%@include file="../dashboard-manager/employee_add_airport.jsp" %>		
	<%@include file="../dashboard-manager/employee_add_leg.jsp" %>		
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery-3.2.1.min.js"></script>
	<!-- Jquery JS-->
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>
	<!-- Bootstrap JS -->
	<script src="${pageContext.request.contextPath}/assets/js/dashboard.js"></script>
	<!-- Dashboard JS -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/datatables.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.com/libraries/1000hz-bootstrap-validator"></script>

</body>
</html>