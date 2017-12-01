<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="yeohangout.javabeans.Includes"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="yeohangout.mysql.IncludeUtils"%>
<%@ page import="java.sql.Connection" %>
	

<div class="modal fade" id="viewItinerary-<%= session.getAttribute("iter_count") %>" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4> Itinerary </h4>
				</div>
				<div class="modal-body">
					<div class="container-fluid bg-gray text-center">
						
						
						<h2> Itinerary</h2>
							<table class="table">
								<thead class="table-inverse">
									<tr>
										<td>Airline ID</td>
										<td>Flight No </td>
										<td>LegNo</td>
										<td>Date</td>
									</tr>
								</thead>
								
								<tbody>
								<%
									//System.out.println("!!"+session.getAttribute("iter_resrNo"));
									/*
									//
									//You don't have to care the redline of acess and resrNo. cause it already includes in customer_current_resrv.jsp
									//
									*/
									ArrayList<Includes> itineraryList = IncludeUtils.searchIncludesByResrNo((Connection)session.getAttribute("iter_conn"), (int)session.getAttribute("iter_resrNo"));
									
									for(int j=0; j<itineraryList.size(); j++){
								%>
								
									<tr>
										<td> <%= itineraryList.get(j).getAirlineID() %> </td>
										<td> <%= itineraryList.get(j).getFlightNo() %> </td>
										<td> <%= itineraryList.get(j).getLegNo() %> </td>
										<td> <%= itineraryList.get(j).getDate() %> </td>
									</tr>
									
								 <%
									}
								 %>
							 
							 	</tbody>
							 </table>
					</div>
				<div class="modal-footer">
				</div>
			</div>
		</div>
	</div>
</div>