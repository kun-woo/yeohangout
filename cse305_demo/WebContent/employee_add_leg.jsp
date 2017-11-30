<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="addLeg" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4> ADD LEG </h4>
				</div>
				<div class="modal-body">
					<div class="container-fluid bg-gray text-center">
						<form role="form" action="addLeg" method="POST">
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" id="airline_id" name = "airlineID"
										placeholder="Airline ID"> <span class="input-group-addon">
										<span class="glyphicon glyphicon-user"></span>
									</span>
								</div>
							</div>
							
							<!-- Flight No -->
							<div class="form-group">
								<div class="input-group">
									<input type="number" class="form-control" id="flight_no" name = "flightNo"
										placeholder="Flight Number"> <span class="input-group-addon">
										<span class="glyphicon glyphicon-lock"></span>
									</span>
								</div>
							</div>
							
							<!-- Leg No. -->
							<div class="form-group">
								<div class="input-group">
									<input type="number" class="form-control" id="leg_no" name = "legNo"
										placeholder="Leg Number"> <span class="input-group-addon">
										<span class="glyphicon glyphicon-lock"></span>
									</span>
								</div>
							</div>
							
							<!-- DEP AP -->
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" id="dep_airport" name = "depAirport"
										placeholder="Departure Airport"> <span class="input-group-addon">
										<span class="glyphicon glyphicon-lock"></span>
									</span>
								</div>
							</div>
							
							<!-- ARV AP -->
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" id="arv_airport" name = "arrAirport"
										placeholder="Arrival Airport"> <span class="input-group-addon">
										<span class="glyphicon glyphicon-lock"></span>
									</span>
								</div>
							</div>
							
							<!-- DEP Day -->
				            <div class="form-group">
				                <div class='input-group date' id='datetimepicker3'>
				                    <input type='text' class="form-control" placeholder="Departure Date" name = "depDate"/>
				                    <span class="input-group-addon"> 
				                        <span class="glyphicon glyphicon-calendar"></span>
				                    </span>
				                </div>
				            </div>
							
							<!-- ARV Day -->
				            <div class="form-group">
				                <div class='input-group date' id='datetimepicker4'>
				                    <input type='text' class="form-control" name = "arrDate" placeholder="Arrival Date"/>
				                    <span class="input-group-addon">
				                        <span class="glyphicon glyphicon-calendar"></span>
				                    </span>
				                </div>
				            </div>
				        
					        <script type="text/javascript">
					            $(function () {
					            		$('#datetimepicker3').datetimepicker();
						        
					            		$('#datetimepicker4').datetimepicker();
					            });
					        </script>
					   
							
							<button type="submit" class="btn btn-block">
								ADD Leg<span class="glyphicon glyphicon-log-in"></span>
							</button>
							
						</form>
					</div>
				<div class="modal-footer">
				<button type="submit" class="btn btn-default pull-left">
					<span class="glyphicon glyphicon-remove"></span> Cancel
				</button>

				</div>
			</div>
		</div>
	</div>
</div>