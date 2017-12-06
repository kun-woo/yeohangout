<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="java.util.ArrayList" %>
<%@ page import="yeohangout.javabeans.Leg" %>
<%@ page import = "yeohangout.javabeans.UserAccount" %>
<%@ page import = "yeohangout.mysql.MyUtils" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="results page for flight searches" />
<meta name="author" content="yeo hang out" />
<title>Yeo Hang Out</title>
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/assets/css/dashboard.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	  href="${pageContext.request.contextPath}/assets/css/datatables.min.css" />
<link href="${pageContext.request.contextPath}/assets/css/search.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-datetimepicker.min.css" /> <!-- Bootstrap DTP CSS -->

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
				<a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Yeo Hang Out</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath}/index.jsp">HOME</a></li>
					<li><a href="#">SETTINGS</a></li>
					<li><a href="#">LOG OUT</a></li>
					<li><a href="#">HELP</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-3 sidebar" style="overflow:visible;">
				<br>
				<h3>Find a Tour</h3>
  				<ul class="nav nav-pills">
    				<li><a data-toggle="pill" href="#one-way">One Way</a></li>
    				<li class="active"><a data-toggle="pill" href="#round-trip">Round Trip</a></li>
    				<li><a data-toggle="pill" href="#multi-city">Multi-City</a></li>
  				</ul>
  				
				<div class="tab-content">
    					<div id="one-way" class="tab-pane fade">
      					<!-- One-Way -->
						<%@ include file="../home-search/one-way-search.jsp"%>
					</div>
    					<div id="round-trip" class="tab-pane fade in active">
      					<!-- Round-Trip -->
						<%@ include file="../home-search/round-trip-search.jsp"%>
					</div>
    					<div id="multi-city" class="tab-pane fade">
      					<!-- Multi-City -->
						<%@ include file="../home-search/multi-city-search.jsp"%>
       				</div>
  				</div>			
			</div>
			
			<div class="col-sm-offset-3 col-sm-9 col-md-offset-3 col-md-9 main slideanim">
				<div class="row">
					<h1 class="page-header col-xs-12">Search Result</h1>
				</div>
				<div class="row">
					<h2>Select your <%//Change %>departure to <%//Change %>New York <small class="no-wrap"> Wed, Dec 13</small></h2>
				</div>
				
				<%
					ArrayList<Leg> searchedLegs = (ArrayList<Leg>)request.getAttribute("searchLegs");
	
					for(Leg leg : searchedLegs){
				%>
				<div class="row search-row">
					<form action="../add-plane" method="post" novalidate>
					<div class="row cart-row">
						<div class="col-xs-12 col-sm-2 col-md-2">
							<a href="#"> <img src="${pageContext.request.contextPath}/images/airline/${result.airlineID}.png" class="img-responsive">
							</a>
						</div>
						<div class="col-xs-12 col-sm-4 col-md-4">
							<h3><%= leg.getDepDate()  %> - <%= leg.getArrDate()  %>
							</h3>
							<div class="no-wrap"><%= leg.getAirlineID() %></div>
						</div>
						<div class="col-xs-6 col-sm-2 col-md-2">
							<h3 class="no-wrap">
								<%//Time Spend%>Not yet
							</h3>
							<div class="no-wrap"><%= leg.getDepAirportID() %> - <%= leg.getArrAirportID() %></div>
						</div>
						<div class="col-xs-6 col-sm-2 col-md-2">
							<h3>1 Stop</h3>
							<div class="no-wrap">4h 30m in AUH</div>
						</div>
						<div class="col-xs-12 col-sm-2 col-md-2">
							<div class="form-group">
								<h3>$1000</h3>
								<div class="no-wrap"<%//Type %>>One Way</div>
								<br>
								<button type="submit" class="btn btn-primary btn-block">Book</button>
							</div>
						</div>
					</div>
					</form>
				</div>
				<%
					} 
				%>

			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/dashboard.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/moment.js"></script> <!-- Moment JS -->
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap-datetimepicker.js"></script> <!-- Boostrap DTP JS -->
	<script src="${pageContext.request.contextPath}/assets/js/search.js"></script>
	<script>
		function openCity(evt, cityName) {
		    var i, tabcontent, tablinks;
		    tabcontent = document.getElementsByClassName("tabcontent");
		    for (i = 0; i < tabcontent.length; i++) {
		        tabcontent[i].style.display = "none";
		    }
		    tablinks = document.getElementsByClassName("tablinks");
		    for (i = 0; i < tablinks.length; i++) {
		        tablinks[i].className = tablinks[i].className.replace(" active", "");
		    }
		    document.getElementById(cityName).style.display = "block";
		    evt.currentTarget.className += " active";
		}
	</script>
	
</body>
</html>