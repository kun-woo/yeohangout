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

	<div class="container-fluid">
		<h1>Search Bar</h1>
	</div>
	<div class="container-fluid">
		<h1>Select Departure</h1>
	</div>
	<div class="container-fluid">
		<div class="col-sm-3 col-xs-12">
			<h1>Search Options</h1>
		</div>
		<div class="col-sm-9 col-xs-12">
			<div class="container-fluid">
				<h1>Search Results</h1>
			</div>
			<div class="container-fluid bg-warning">
				<div class="col-xs-2 col-sm-2 bg-primary text-center">
					<h5>Logo</h5>
					<h6>Logo</h6>
				</div>
				<div class="col-xs-12 col-sm-2 bg-success">
					<h5>Text</h5>
					<h6>Text</h6>
				</div>
				<div class="col-xs-12 col-sm-2 bg-success">
					<h5>Text</h5>
					<h6>Text</h6>
				</div>
				<div class="col-xs-12 col-sm-2 bg-success">
					<h5>Text</h5>
					<h6>Text</h6>
				</div>
				<div class="col-xs-12 col-sm-4 bg-primary">
					<h5>$1000</h5>
					<h6>Fair-Type</h6>
					<a href="#search" class="btn btn-success btn-block" role="button">Select</a>
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
	<script src="../assets/js/search.js"></script>

</body>
</html>