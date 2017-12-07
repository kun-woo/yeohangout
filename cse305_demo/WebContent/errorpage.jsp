<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Yeo Hang Out</title>
<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="assets/css/dashboard.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="assets/css/datatables.min.css" />
<link href="assets/css/search.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.min.css" /> <!-- Bootstrap DTP CSS -->
<link rel="stylesheet" href="assets/css/font-awesome.min.css">

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
				<a class="navbar-brand" href="index.jsp">Yeo Hang Out</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="./index.jsp">HOME</a></li>
					<li><a href="#">SETTINGS</a></li>
					<li><a href="./logout">LOG OUT</a></li>
					<li><a href="help.jsp">HELP</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="container-fluid text-center">
		<br>
		<br>
		<br>
		<br>
		<h1>Sorry.. Something just went<b class="bg-red no-wrap"><%//Airline Name %> WRONG</b>..</h1>
		<br>
		<h2>Wanna <b>go</b> back?</h2>
		<br>
		<a href="index.jsp#search" class="btn btn-success btn-md">Do again..</a>
	</div>
</body>
</html>