<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="search" class="container-fluid text-center">
		<h2>Find a Tour</h2>
		<h4>Travel with Yeo Hang Out</h4>
		<br>
		<div class="row text-center slideanim">
			<div class="col-sm-12 search-form">
				<form class="form">
					<br>
					<div class="form-group">
						<div class="col-sm-12 text-left">
							<div class="btn-group">
								<button type="button" class="btn btn-default btn-md">One-Way</button>
								<button type="button" class="btn btn-default btn-md active">Round Trip</button>
								<button type="button" class="btn btn-default btn-md">Multi-City</button>
							</div>
						</div>
					</div>				
					<div class="form-group">
						<div class="col-sm-6 text-left">
							<br>
							<!-- .control-label for all horizontal form's labels -->
							<label class="control-label" for="text">Flying From</label> 
							<input type="text" class="form-control" placeholder="City or Airport">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-6 text-left">
							<br>
							<label class="control-label" for="text">Flying To</label>
							<input type="text" class="form-control" placeholder="City or Airport">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-6 col-md-4 text-left">
							<br>
							<label class="control-label" for="text">Departing</label>
							<div class='input-group date' id='datetimepicker1'>
								<input type="text" class="form-control" placeholder="mm/dd/yyyy">
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
								<input type="text" class="form-control" placeholder="mm/dd/yyyy">
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
									type="button" data-toggle="dropdown">
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
							<button type="button" class="btn btn-success btn-md btn-search">Search</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>