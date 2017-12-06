<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="yeohangout.javabeans.UserAccount" %>
<%@ include file="../dashboard-customer/customer_header.jsp"%>

<%
		UserAccount loginedUser = MyUtils.getLoginedUser(MyUtils.getSession());
		
%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#">Overview <span
							class="sr-only">(current)</span></a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="../view-employee">Manage Employee</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a data-toggle="modal" href="${pageContext.request.contextPath}/currentReservationServlet?userID=<%= loginedUser.getAccountNo() %>" ><span class="glyphicon glyphicon-user"></span>Current Reservation</a></li>
        				<li><a data-toggle="modal" href="${pageContext.request.contextPath}/everyReservationServlet?userID=<%= loginedUser.getAccountNo() %>" ><span class="glyphicon glyphicon-user"></span>All of Reservations History</a></li>
        				<li><a data-toggle="modal" href="${pageContext.request.contextPath}/flightSuggestion?userID=<%= loginedUser.getAccountNo() %>"><span class="glyphicon glyphicon-user"></span>View Flight Suggestion</a></li>
				</ul>
			</div>
				

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="../assets/js/jquery-3.2.1.min.js"></script> <!-- Jquery JS-->
	<script src="../assets/js/bootstrap.js"></script> <!-- Bootstrap JS -->
	<script src="../assets/js/jquery.circliful.min.js"></script> <!-- Circliful JS -->
	<script src="../assets/js/Chart.bundle.min.js"></script> <!-- Chart JS -->
	<script src="../assets/js/dashboard.js"></script> <!-- Dashboard JS -->
