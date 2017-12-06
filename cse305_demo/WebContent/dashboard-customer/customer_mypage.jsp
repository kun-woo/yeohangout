<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="yeohangout.javabeans.UserAccount" %>
	<!-- HEADER -->
	<%@ include file="../home/header.jsp"%>
	
	<%
		UserAccount loginedUser = MyUtils.getLoginedUser(MyUtils.getSession());
		
	%>
<div class="container-fluid bg-gray text-center">
		<ul>
			<li><a data-toggle="modal" href="currentReservationServlet?userID=<%= loginedUser.getAccountNo() %>" ><span class="glyphicon glyphicon-user"></span>Current Reservation</a></li>
        		<li><a data-toggle="modal" href="everyReservationServlet?userID=<%= loginedUser.getAccountNo() %>" ><span class="glyphicon glyphicon-user"></span>All of Reservations History</a></li>
        		<li><a data-toggle="modal" href="flightSuggestion?userID=<%= loginedUser.getAccountNo() %>"><span class="glyphicon glyphicon-user"></span>View Flight Suggestion</a></li>
        	</ul>
</div>


	<!-- Footer -->
	<%@ include file="../home/footer.jsp"%>