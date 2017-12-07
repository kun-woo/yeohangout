<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="search" class="container-fluid text-center">
		<h2>Find a Tour</h2>
		<h4>Travel with Yeo Hang Out</h4>
		<br>
		<div class="row text-center slideanim">
			<div class="col-sm-12 search-form">
				<br>
				<form class="form" action="searchOneway" method="POST">	
					
					<div class="col-sm-6 col-xs-12 text-left">
									
						<input type="radio" name="type_btn"  value = "one-way" class="btn btn-default btn-md" id="one_way_rb" checked/>
							<label for="one_way_rb">One-Way</label>
						<input type="radio" name="type_btn" value = "round-trip" class="btn btn-default btn-md active" id="round_trip_rb"/>
							<label for="round_trip_rb"> Round-Trip  </label>
						<input type="radio" name="type_btn" value = "multi-city"class="btn btn-default btn-md" id="multi_city_rb"/>
							<label for="multi_city_rb">Multi-City </label>
					</div>
					
					
					<div class="col-sm-6 col-md-offset-2 col-md-4 col-xs-12 text-right">
						<div class="dropdown">
							<button class="btn btn-default btn-block dropdown-toggle"
								type="button" data-toggle="dropdown">
								Cabin Class <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li class=><a>Economy</a></li>
								<li><a>Business</a></li>
								<li><a>First Class</a></li>
							</ul>
						</div>
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
					
					
					<div class="form-group">
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
					
					
					<div class="form-group">
						<div class="col-sm-6 col-md-2 text-left">
							<br>
							<label class="control-label" for="text">Passengers</label>
							<div class="dropdown">
								<button class="btn btn-default dropdown-toggle dropdown-btn"
									type="button" name = "num_of_passenger" data-toggle="dropdown">
									0 <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a>1</a></li>
									<li><a>2</a></li>
									<li><a>3</a></li>
									<li><a>4</a></li>
									<li><a>5</a></li>
									<li><a>6</a></li>
								</ul>
							</div>
						</div>
					</div>
					
					
					<div class="form-group">
						<div class="col-sm-6 col-md-2 text-left">
							<br>
							<label class="control-label" for="checkbox">Feeling Lucky? (Auction)</label><!-- 
							<input type="checkbox" name="my-checkbox" data-on-color="danger" data-on-text="YES!"
								data-off-text="NAH" data-handle-width="10" data-size="normal" id="checkbox"> -->
							<div class="dropdown">
								<button class="btn btn-default dropdown-toggle dropdown-btn"
									type="button" data-toggle="dropdown">
									Nah <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a>Yeah!</a></li>
									<li><a>Well..nah..</a></li>
								</ul>
							</div>
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