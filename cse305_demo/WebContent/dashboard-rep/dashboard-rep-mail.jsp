<%@page import="yeohangout.javabeans.MailList"%>
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
	<%ArrayList<MailList> mailArr = (ArrayList<MailList>) session.getAttribute("mailArr"); %>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="${pageContext.request.contextPath}/dashboard-rep/dashboard-rep-overview.jsp">Overview </a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="${pageContext.request.contextPath}/view-rep-reservation">Record Reservation </a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="${pageContext.request.contextPath}/view-customer-rep">Manage
							Customer</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#">View Customer Mailing List <span class="sr-only">(current)</span></a></li>
					<li><a href="${pageContext.request.contextPath}/view-employee-rep">View Employee</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="${pageContext.request.contextPath}/get-flight-suggest">Flight Suggest To Customer</a></li>
				</ul>
			</div>
			<div
				class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">View MailList</h1>
				<div>
					<!-- For Padding -->
					<br>
				</div>
				<div class="table-responsive">
					<table id="test-table1" class="table table-striped">
						<thead>
							<tr>
								<th>Name</th>
								<th>Account Number</th>
								<th>Address</th>
								<th>Telephone</th>
								<th>Email</th>
							</tr>
						</thead>
						<tbody>
						<% 
						ArrayList<Integer> ssnArray = new ArrayList<Integer>();
						
						for (int i=0; i<mailArr.size(); i++) { 
							
 						%>
							<tr>
								<td><%= mailArr.get(i).getName() %></td>
								<td><%= mailArr.get(i).getAccountNo() %></td>
								<td><%= mailArr.get(i).getAddress() %></td>
								<td><%= mailArr.get(i).getTelephone() %></td>
								<td><%= mailArr.get(i).getEmail() %></td>
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

</body>
</html>