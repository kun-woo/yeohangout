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
<link href="../assets/css/search.css" rel="stylesheet">
<link href="../assets/css/dashboard.css" rel="stylesheet">

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

	<div class=”container-fluid”>
		<div class="row">
			<div class="col-xs-12">
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<div class="search-section col-xs-12 bg-primary">
					<form action="" method="post">
						<div class="search-tab col-xs-12">
							<div class="fare-type">
								<label class="radio-inline"><input type="radio"
									name="optradio">Round Trip</label> <label class="radio-inline"><input
									type="radio" name="optradio">One Way</label> <label
									class="radio-inline"><input type="radio"
									name="optradio">Multi-City</label>
							</div>
						</div>
						<div class="search-bar col-xs-12">
							
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<div class="page-header col-xs-12">
					<h1>
						Pick Your Travel <small>A ticket to the happiness</small>
					</h1>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<form action="../add-plane" method="post" novalidate>
					<div class="row cart-row">
						<div class="col-xs-12 col-sm-2">
							<a href="#"> <img src="http://via.placeholder.com/200x200"
								alt="img-100x100" class="img-responsive">
							</a>
						</div>
						<div class="col-xs-12 col-sm-4">
							<h3><% //depttime %>12:15am - 3:50pm<% //arrtime%></h3>
							<small>United Airline<% //airline name %></small>
						</div>
						<div class="col-xs-5 col-sm-2">
							<h3><% //Time Spend%>29h 35m</h3>
							<small><% //Dpet-airport%>ICN - JFK<% //Land-airport%></small>
						</div>
						<div class="col-xs-7 col-sm-2">
							<h3>1 Stop</h3>
							<small>4h 30m in AUH</small>
						</div>
						<div class="col-xs-12 col-sm-2">
							<div class="form-group">
								<h3 class="h3-price">$1000</h3> 
								  <button type="submit" class="btn btn-primary btn-block">Book</button>
							</div>
						</div>
					</div>
					<!-- end .row.cart-row -->
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<form action="../add-plane" method="post" novalidate>
					<div class="row cart-row">
						<div class="col-xs-12 col-sm-2">
							<a href="#"> <img src="http://via.placeholder.com/100x100"
								alt="img-100x100" class="img-responsive">
							</a>
						</div>
						<div class="col-xs-12 col-sm-4">
							<h3>
								<a href="#">Arr - Dept</a>
							</h3>
							Dang-Product-Pasdasdasdas
						</div>
						<div class="col-xs-5 col-sm-2">
							<h3 class="h3-price">$1000</h3>
							<small>each</small>
						</div>
						<div class="col-xs-7 col-sm-2">
							<h3 class="h3-price">Dang</h3>
							<small>item total</small>
						</div>
						<div class="col-xs-12 col-sm-2">
							<div class="form-group">
								<label class="control-label" for="button">Flying From</label> 
								  <button type="submit" class="btn btn-primary btn-block">Submit</button>
							</div>
						</div>
					</div>
					<!-- end .row.cart-row -->
				</form>
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
	<script src="../assets/js/search.js"></script>

</body>
</html>