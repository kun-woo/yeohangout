/**
 * @Author Jude Hokyoon Woo
 */

$(window).scroll(function() {
  $(".slideanim").each(function(){
    var pos = $(this).offset().top;

    var winTop = $(window).scrollTop();
    if (pos < winTop + 600) {
      $(this).addClass("slide-up");
    }
  });
});

//For DateTimePicker
$(function () {
	$('#datetimepicker1').datetimepicker({
		format: 'MM/DD/YYYY'
	});
	$('#datetimepicker2').datetimepicker({
		format: 'MM/DD/YYYY'
	});
});

//For Toggle Switch
$(function () {
	$("[name='my-checkbox']").bootstrapSwitch();
});


//For Carousel
$(function () {

	var $item = $('.carousel .item'); 
	var $wHeight = $(window).height();
	//Setting height as window height
	$item.height($wHeight); 
	$item.addClass('full-screen');
	
	//Setting Images as div's Background
	$('.carousel img').each(function() {
		var $src = $(this).attr('src');
		var $color = $(this).attr('data-color');
		$(this).parent().css({
			'background-image' : 'url(' + $src + ')',
			'background-color' : $color
		});
		$(this).remove();
	});
	//Resize 	
	$(window).on('resize', function (){
		$wHeight = $(window).height();
		$item.height($wHeight);
	});
	//Duration
	$('.carousel').carousel({
		  interval: 6000,
		  pause: "false"
	});
});

//For Dropdown
$(function(){
    $(".dropdown-menu li a").click(function(){
    	$(this).parents(".dropdown").find('.btn').html($(this).text() + ' <span class="caret"></span>');
    	$(this).parents(".dropdown").find('.btn').val($(this).data('value'));
   });
});

//For Smooth Scrolling
$(function(){
	  // Add smooth scrolling to all links in main button
	  $("a[href='#search']").on('click', function(event) {

	   // Make sure this.hash has a value before overriding default behavior
	  if (this.hash !== "") {

	    // Prevent default anchor click behavior
	    event.preventDefault();

	    // Store hash
	    var hash = this.hash;

	    // Using jQuery's animate() method to add smooth page scroll
	    // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
	    $('html, body').animate({
	      scrollTop: $(hash).offset().top
	    }, 900, function(){

	      // Add hash (#) to URL when done scrolling (default click behavior)
	      window.location.hash = hash;
	      });
	    } // End if
	  });
	  
	  // Add smooth scrolling to all links in navbar + footer link
	  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

		   // Make sure this.hash has a value before overriding default behavior
		  if (this.hash !== "") {

		    // Prevent default anchor click behavior
		    event.preventDefault();

		    // Store hash
		    var hash = this.hash;

		    // Using jQuery's animate() method to add smooth page scroll
		    // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
		    $('html, body').animate({
		      scrollTop: $(hash).offset().top
		    }, 900, function(){

		      // Add hash (#) to URL when done scrolling (default click behavior)
		      window.location.hash = hash;
		      });
		    } // End if
		  });
});

