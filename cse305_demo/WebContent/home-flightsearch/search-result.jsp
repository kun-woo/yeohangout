<%@page import="yeohangout.javabeans.EmployeeJude"%>
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
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../assets/css/dashboard.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="../assets/css/datatables.min.css" />
<link href="../assets/css/search.css" rel="stylesheet">
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
					<li><a href="../index.jsp">HOME</a></li>
					<li><a href="#">SETTINGS</a></li>
					<li><a href="#">LOG OUT</a></li>
					<li><a href="#">HELP</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<%
		ArrayList<EmployeeJude> emplArr = (ArrayList<EmployeeJude>) session.getAttribute("emplArr");
	%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="dashboard-manager-overview.jsp">Overview </a></li>
				</ul>
			</div>
			<div class="col-sm-offset-2 col-sm-10 col-md-offset-2 col-md-10 main slideanim">
				<div class="row">
					<h1 class="page-header col-xs-12">Search Result</h1>
				</div>
				<div class="row">
					<form action="../add-plane" method="post" novalidate>
					<div class="row cart-row">
						<div class="col-xs-12 col-sm-2 col-md-2">
							<a href="#"> <img src="../images/airline/1.png" class="img-responsive">
							</a>
						</div>
						<div class="col-xs-12 col-sm-4 col-md-4">
							<h3><%//depttime%>12:15am - 3:50pm<%//arrtime%>
							</h3>
							<small>United Airline<%//airline name%></small>
						</div>
						<div class="col-xs-6 col-sm-2 col-md-2">
							<h3 class="no-wrap">
								<%//Time Spend%>29h 35m
							</h3>
							<small><%//Dpet-airport%>ICN - JFK<%//Land-airport%></small>
						</div>
						<div class="col-xs-6 col-sm-2 col-md-2">
							<h3>1 Stop</h3>
							<small class="no-wrap">4h 30m in AUH</small>
						</div>
						<div class="col-xs-12 col-sm-2 col-md-2">
							<div class="form-group">
								<h3>$1000</h3>
								<button type="submit" class="btn btn-primary btn-block">Book</button>
							</div>
						</div>
					</div>
					<!-- end .row.cart-row -->
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="../assets/js/jquery-3.2.1.min.js"></script>
	<!-- Jquery JS-->
	<script src="../assets/js/bootstrap.js"></script>
	<!-- Bootstrap JS -->
	<script src="../assets/js/dashboard.js"></script>
	<!-- Dashboard JS -->
	<script type="text/javascript" src="../assets/js/datatables.min.js"></script>
</body>
</html>