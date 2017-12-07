<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="yeohangout.javabeans.UserAccount" %>
<%@ page import="yeohangout.mysql.MyUtils"%>
	
	<!-- HEADER -->
<%@ include file="../dashboard-customer/customer_header.jsp"%>
		
	
	<%
		UserAccount loginedUser = MyUtils.getLoginedUser(MyUtils.getSession());
		
	%>
	

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
		
				<ul class="nav nav-sidebar">
					<li class="active"><a href="${pageContext.request.contextPath}/dashboard-customer/customer_mypage.jsp" >Overview</a></li>
					<li><a href="${pageContext.request.contextPath}/currentReservationServlet?userID=<%= loginedUser.getAccountNo() %>" >Current Reservation</a></li>
        				<li><a href="${pageContext.request.contextPath}/everyReservationServlet?userID=<%= loginedUser.getAccountNo() %>" >All of Reservations History</a></li>
					<li><a href="${pageContext.request.contextPath}/flightSuggestion?userID=<%= loginedUser.getAccountNo() %>">View Flight Suggestion</a></li>
					<li><a href="${pageContext.request.contextPath}/get-customer-auction?userID=<%= loginedUser.getAccountNo() %>">View Auction</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1> <%=loginedUser.getUserID() %>'s PAGE </h1>
	 		</div>
		</div>
	</div>
	
	
					
	<!-- Footer -->
<%@ include file="../dashboard-customer/customer_footer.jsp"%>