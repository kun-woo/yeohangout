<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="yeohangout.mysql.MyUtils"%>
    
    <div class="modal fade" id="help-info" role="dialog" tabindex=-1>
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4> Help Menu </h4>
				</div>
				<div class="modal-body">
				<%
					if(MyUtils.getSession()==null || MyUtils.getUserType() == 0){
				%>
				
				<div class="col-4-sm"></div>
					<p>Welcome! Thank you for choosing Yeo Hang Out. With your account you have access to the following abilities: </p>
					<p>- Search and booking one-way, round-trip, and multi-city flight reservations. </p>
					<p>- The ability to cancel any existing reservations or partake in reverse auctions.</p>
					<p>- Viewing your current existing reservations.</p>
					<p>- View the travel itinerary for a given reservation. </p>
					<p>- View your current bid as well as the bid history on a given reverse auction.</p>
					<p>- View the history of all current and past reservations made.</p>
					<p>- View the list of current best-seller flights.</p>
					<p>- View a personalized flight suggestion list.</p>
				</div>
				<%
        			} else if(MyUtils.getUserType()==1){
        		%>
				
				<div class="col-4-sm">
					<p>Welcome back, as a customer representative/reservation agent, your account has access to the following abilities:</p>
					<p>- Record a reservation.</p>
					<p>- Add, Edit, and Delete information for a customer.</p>
					<p>- Produce customer mailing lists.</p>
					<p>- Produce a list of flight suggestions for a given customer based on that customer's past reservations.</p>
				</div>	
        		<%
					} else if(MyUtils.getUserType()==2){
				%>
				
				<div class="col-4-sm">
					<p>Welcome back, as a manager, your account has access to the following abilities:</p>
					<p>- Add, Edit, and Delete information for a given employee.</p>
					<p>- Obtain a sales report for a particular month.</p>
					<p>- Produce a comprehensive listing of all flights.</p>
					<p>- Produce a list of reservations by flight number or by customer name.</p>
					<p>- Produce a summary listing of revenue generated by a particular flight, destination city, or customer.</p>
					<p>- Determine which customer representative generated most total revenue.</p>
					<p>- Determine which customer generated most total revenue.</p>
					<p>- Produce a list of most active flights.</p>
					<p>- Produce a list of all customers who have seats reserved on a given flight.</p>
					<p>- Produce a list of all flights for a given airport.</p>
					<p>- Produce a list of all flights whose arrival and departure times are on-time/delayed.</p>
				</div>
				<%
					}
				%>
				
				<div class="modal-footer">
					<button type="submit" class="btn btn-default pull-left" data-dismiss="modal">
						<span class="glyphicon glyphicon-remove"></span> Cancel
					</button>
				</div>
			</div>
		</div>
	</div>