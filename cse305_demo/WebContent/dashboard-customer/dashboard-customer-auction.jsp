<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="yeohangout.javabeans.Auction"%>
<%@ page import="java.util.ArrayList" %>
	
	<!-- HEADER -->
	<%@ include file="../dashboard-customer/customer_header.jsp"%>
	
	
	<%ArrayList<Auction> aucArr = (ArrayList<Auction>) session.getAttribute("aucArr"); 
		int accountNo = (int) session.getAttribute("accountNO");	
	%>
	
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
		
				<ul class="nav nav-sidebar">
					<li><a data-toggle="modal" href="${pageContext.request.contextPath}/dashboard-customer/customer_mypage.jsp" >Overview</a></li>
					<li><a data-toggle="modal" href="${pageContext.request.contextPath}/currentReservationServlet?userID=<%= accountNo %>" >Current Reservation</a></li>
        				<li><a data-toggle="modal" href="${pageContext.request.contextPath}/everyReservationServlet?userID=<%= accountNo %>" >All of Reservations History</a></li>
					<li><a data-toggle="modal" href="${pageContext.request.contextPath}/flightSuggestion?userID=<%= accountNo %>">View Flight Suggestion</a></li>
					<li class="active"><a>View Auction</a></li>
					
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2> View Auction</h2>
				<div class="table-responsive">
					<table id="test-table1" class="table table-striped">
						<thead class="table-inverse">
							<tr>
								<td>Airline</td>
								<td>Flight Number</td>
								<td>Class</td>
								<td>Date</td>
								<td>Your Price</td>
								<td>Accepted?</td>
							</tr>
						</thead>
						
						<tbody>
							<%							
								
								for (int i=0; i<aucArr.size(); i++){
									String a = "No";
									if (aucArr.get(i).isAccepted()) {
										a = "Yes";
									}
										
							%>
							<tr>
								<td> <%= aucArr.get(i).getAirline() %> </td>
								<td> <%= aucArr.get(i).getFlightNo() %> </td>
								<td> <%= aucArr.get(i).getCabinClass() %> </td>
								<td> <%= aucArr.get(i).getDate() %> </td>
								<td> <%= aucArr.get(i).getNyop() %> </td>
								<td> <%= a %> </td>
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
	
	
					
	<!-- Footer -->
<%@ include file="../dashboard-customer/customer_footer.jsp"%>