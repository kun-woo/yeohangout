/**
 * This is for the dashboard
 */

$(document).ready(function() {
	/* For the Overview */
	$("#test-circle1").circliful({
		animationStep : 5,
		foregroundBorderWidth : 5,
		backgroundBorderWidth : 15,
		percent : 75
	});
	$("#test-circle2").circliful({
		animationStep : 5,
		foregroundBorderWidth : 5,
		backgroundBorderWidth : 15,
		percent : 75
	});
	$("#test-circle3").circliful({
		animationStep : 5,
		foregroundBorderWidth : 5,
		backgroundBorderWidth : 15,
		percent : 75
	});
	$("#test-circle4").circliful({
		animationStep: 5,
		foregroundBorderWidth: 5,
		backgroundBorderWidth: 15,
		percent: 75
	});
	new Chart(document.getElementById("myChart"), {
		"type" : "radar",
		"data" : {
			"labels" : [ "Eating", "Drinking", "Sleeping", "Designing",
				"Coding", "Cycling", "Running" ],
				"datasets" : [ {
					"label" : "My First Dataset",
					"data" : [ 65, 59, 90, 81, 56, 55, 40 ],
					"fill" : true,
					"backgroundColor" : "rgba(255, 99, 132, 0.2)",
					"borderColor" : "rgb(255, 99, 132)",
					"pointBackgroundColor" : "rgb(255, 99, 132)",
					"pointBorderColor" : "#fff",
					"pointHoverBackgroundColor" : "#fff",
					"pointHoverBorderColor" : "rgb(255, 99, 132)"
				}, {
					"label" : "My Second Dataset",
					"data" : [ 28, 48, 40, 19, 96, 27, 100 ],
					"fill" : true,
					"backgroundColor" : "rgba(54, 162, 235, 0.2)",
					"borderColor" : "rgb(54, 162, 235)",
					"pointBackgroundColor" : "rgb(54, 162, 235)",
					"pointBorderColor" : "#fff",
					"pointHoverBackgroundColor" : "#fff",
					"pointHoverBorderColor" : "rgb(54, 162, 235)"
				} ]
		},
		"options" : {
			"elements" : {
				"line" : {
					"tension" : 0,
					"borderWidth" : 3
				}
			}
		}
	});
	new Chart(document.getElementById("mySChart"), {
		"type" : "polarArea",
		"data" : {
			"labels" : [ "Red", "Green", "Yellow", "Grey", "Blue" ],
			"datasets" : [ {
				"label" : "My First Dataset",
				"data" : [ 11, 16, 7, 3, 14 ],
				"backgroundColor" : [ "rgb(255, 99, 132)",
					"rgb(75, 192, 192)", "rgb(255, 205, 86)",
					"rgb(201, 203, 207)", "rgb(54, 162, 235)" ]
			} ]
		}
	});

});

$(document).ready(function() {
	/*For Manage Employee */
	$(".slideanim").each(function(){
		$(this).addClass("slide-up");
	});
	$("#test-table1").DataTable({
		"order" : [[0, 'asc']]
	});
	$("#table-1").DataTable({
		"order" : [[0, 'asc']]
	});
	$("#table-2").DataTable({
		"order" : [[0, 'asc']]
	});
	$("#table-3").DataTable({
		"order" : [[0, 'asc']]
	});
	$("#table-4").DataTable({
		"order" : [[0, 'asc']]
	});
//	$('#test-table1 > tbody > tr').click(function() {
//		$(this).addClass("bg-primary");
//	    // row was clicked
//	});
});



