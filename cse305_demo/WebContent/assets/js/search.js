/**
 * @Author Jude Hokyoon Woo
 */

$(document).ready(function() {
	$('#datetimepicker1').datetimepicker({
		viewMode: 'years',
		format: 'MM/DD/YYYY',
		widgetPositioning: {
			horizontal: 'left',
	        vertical: 'bottom'
		}
	});
	$('#datetimepicker2').datetimepicker({
		viewMode: 'years',
		format: 'MM/DD/YYYY',
		widgetPositioning: {
			horizontal: 'left',
	        vertical: 'bottom'
		}
	});
});

