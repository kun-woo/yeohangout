<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
    
    function checkFunction(val){
    		
    		if(val=="one-way"){
    			//hide Return
    			$('#returnDateField').css("display", "none")
    			

			$('#multi2').css("display", "none");
			$('#multi3').css("display", "none");
    		}else if(val =="round-trip"){
    			
    			$('#returnDateField').css("display", "block");
    			
    			$('#multi2').css("display", "none");
    			$('#multi3').css("display", "none");
    		}else{
    			
    			$('#returnDateField').css("display", "none");

    			$('#multi2').css("display", "block");
    			$('#multi3').css("display", "block");
    		}
    		
    }
    
    function add_arr_airport(){
    	
    }

    </script>
<div id="search" class="container-fluid text-center">
		<h2>Find a Tour</h2>
		<h4>Travel with Yeo Hang Out</h4>
		<br>
		<div class="row text-center slideanim">
			<div class="col-sm-12 search-form">
				<br>
				<form class="form" action="searchOneway" method="POST">	
					
					<div class="col-sm-6 col-xs-12 text-left">
									
						<input type="radio" name="type_btn"  value = "one-way"  onclick="if(this.checked){checkFunction(this.value)}" class="btn btn-default btn-md" id="one_way_rb" checked />
							<label for="one_way_rb">One-Way</label>
						<input type="radio" name="type_btn" value = "round-trip" onclick="if(this.checked){checkFunction(this.value)}" class="btn btn-default btn-md active" id="round_trip_rb"/>
							<label for="round_trip_rb"> Round-Trip  </label>
						<input type="radio" name="type_btn" value = "multi-city" onclick="if(this.checked){checkFunction(this.value)}" class="btn btn-default btn-md" id="multi_city_rb"/>
							<label for="multi_city_rb">Multi-City </label>
					</div>
					
					
					<div class="col-sm-6 col-md-offset-2 col-md-4 col-xs-12 text-right">
						<input type="text" class="form-control" name="cabinClass" placeholder="Cabin Class">
					</div>
					
					
					<div class="form-group">
						<div class="row">
							<div class="col-sm-6 text-left">
								<br>
								<label class="control-label" for="text">Flying From</label> 
							</div>
							<div class="col-sm-6 text-left">
								<br>
								<label class="control-label" for="text">Flying To</label> 
							</div>
							<div class="col-sm-4 text-left">
								<input type="text" class="form-control" name="depCity" placeholder="City">
							</div>
							<div class="col-sm-2 text-left">
								<input type="text" class="form-control" name="depCountry" placeholder="Country">
							</div>
							<div class="col-sm-4 text-left">
								<input type="text" class="form-control" name="arrCity" placeholder="City">
							</div>
							<div class="col-sm-2 text-left">
								<input type="text" class="form-control" name="arrCountry" placeholder="Country">
							</div>
						</div>
					</div>	
					
								
					<div class="form-group">
						<div class="col-sm-6 col-md-4 text-left">
							<br>
							<label class="control-label" for="text">Departing</label>
							<div class='input-group date' id='datetimepicker1'>
								<input type="text" class="form-control" name="depTime" placeholder="mm/dd/yyyy">
								<span class="input-group-addon"> 
									<span class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
					</div>
					
					
					<div class="form-group " id ="returnDateField" style="display:none;">
						<div class="col-sm-6 col-md-4 text-left">
							<br>
							<label class="control-label" for="text">Returning</label>
							<div class='input-group date' id='datetimepicker2'>
								<input type="text" class="form-control" name="returnTime" placeholder="mm/dd/yyyy">
								<span class="input-group-addon"> 
									<span class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
					</div>
					
					<div id="multi2" class="row col-sm-12 text-left" style="display:none;">
						
						<div class="form-group">
						
								<div class="col-sm-6 text-left">
									<br>
									<label class="control-label" for="text">Flying To</label> 
								</div>
								
								<div class="col-sm-6 text-left">
									<br>
									<label class="control-label" for="text">Arrival</label> 
								</div>
								
								<div class="col-sm-4 text-left">
									<input type="text" class="form-control" name="arrCity2" placeholder="Second City">
								</div>
								<div class="col-sm-2 text-left">
									<input type="text" class="form-control" name="arrCountry2" placeholder="Second Country">
								</div>
								
								<div class='input-group date col-sm-6 text-left' id='datetimepicker5'>
									<input type="text" class="form-control" name="depTime2" placeholder="mm/dd/yyyy">
								<span class="input-group-addon"> 
									<span class="glyphicon glyphicon-calendar"></span>
								</span>
								</div>
						</div>
					</div>
					
					<div id="multi3" class="row col-sm-12 text-left" style="display:none;">
						<div class="form-group">
							<div class="row">
								<div class="col-sm-6 text-left">
									<br>
									<label class="control-label" for="text">Flying To</label> 
								</div>
								
								<div class="col-sm-6 text-left">
									<br>
									<label class="control-label" for="text">Arrival</label> 
								</div>
								
								<div class="col-sm-4 text-left">
									<input type="text" class="form-control" name="arrCity3" placeholder="Third City">
								</div>
								<div class="col-sm-2 text-left">
									<input type="text" class="form-control" name="arrCountry3" placeholder="Third Country">
								</div>
					
								<div class='input-group date col-sm-6 text-left' id='datetimepicker6'>
									<input type="text" class="form-control" name="depTime3" placeholder="mm/dd/yyyy">
									<span class="input-group-addon"> 
										<span class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-6 col-md-2 text-left">
							<br>
							<label class="control-label" for="text">Passengers</label>
							<input type="number" class="form-control" name="passenger" placeholder="# Passengers">
						</div>
					</div>
					
					
					<div class="form-group">
						<div class="col-sm-6 col-md-2 text-left">
							<br>
							<input type="radio"  name="auc_btn"  value = "normal" class="btn btn-default btn-md" id="nor_rb" checked />
							<label for="nor_rb">Normal</label>
							<input type="radio"  name="auc_btn"  value = "auction" class="btn btn-default btn-md active" id="auc_rb"/>
							<label for="auc_rb">Auction</label>
						</div>
					</div>
					
					
					<div class="form-group">
						<div class="col-sm-12 text-left">
							<br>
							<button type="submit" class="btn btn-success btn-md btn-search">Search</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	