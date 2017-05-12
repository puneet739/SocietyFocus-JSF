
function scroll_to_class(element_class, removed_height) {
	var scroll_to = $(element_class).offset().top - removed_height;
	if($(window).scrollTop() != scroll_to) {
		$('html, body').stop().animate({scrollTop: scroll_to}, 0);
	}
}

function bar_progress(progress_line_object, direction) {
	var number_of_steps = progress_line_object.data('number-of-steps');
	var now_value = progress_line_object.data('now-value');
	var new_value = 0;
	if(direction == 'right') {
		new_value = now_value + ( 100 / number_of_steps );
	}
	else if(direction == 'left') {
		new_value = now_value - ( 100 / number_of_steps );
	}
	progress_line_object.attr('style', 'width: ' + new_value + '%;').data('now-value', new_value);
}

var requestId;
jQuery(document).ready(function() {



    /*
        Form
    */
    $('.f1 fieldset:first').fadeIn('slow');

    $('.f1 input[type="text"], .f1 input[type="password"], .f1 textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });

    var moveForward=false;
    // next step
    $('.f1 .btn-next').on('click', function(event) {
    	console.log('This is called to get next page');
    	var currentTarget = event.currentTarget;
    	var parent_fieldset = $(currentTarget).parents('fieldset');
    	var next_step = true;
    	// navigation steps / progress steps
    	var current_active_step = $(this).parents('.f1').find('.f1-step.active');
    	var progress_line = $(this).parents('.f1').find('.f1-progress-line');
    	
    	var currentID=current_active_step.attr('id');
    	
    	if(currentID=='description'){
    		doMoveFurther(currentTarget);
    	}
    	if (currentID=='registration'){
    		registerRequest(currentTarget);
    	}
    	
    	if (currentID=='verification'){
    		verification(currentTarget);
    	}
    	
    	
    	if( next_step ) {
    		//doSoimething()
    	}

    });
    
    
    function doMoveFurther(target){

    	var parent_fieldset = $(target).parents('fieldset');
    	var next_step = true;
    	// navigation steps / progress steps
    	var current_active_step = $(target).parents('.f1').find('.f1-step.active');
    	var progress_line = $(target).parents('.f1').find('.f1-progress-line');
    	
		parent_fieldset.fadeOut('400', function(){
			// change icons
			current_active_step.removeClass('active').addClass('activated').next().addClass('active');
			// progress bar
			bar_progress(progress_line, 'right');
			// show next step
			$(parent_fieldset).next().fadeIn();
			// scroll window to beginning of the form
			scroll_to_class( $('.f1'), 20 );
		});
	
		
    }
    
    function registerRequest(currentTarget){
    	// fields validation
    	var request = [];
    	request.phoneNo=document.getElementById("f1-phoneno").value;
    	request.name=document.getElementById("f1-name").value;
    	request.pincode=document.getElementById("f1-pincode").value;;;
    	request.requestType=requestType;
    	
    	var myObj = { "name":request.name, "phoneNo":request.phoneNo, "requestType":request.requestType, "pincode":request.pincode }; 
    		$.ajax({
    			type: 'POST',
    			url: serverURL+"zircon/services/v1/openrequest",
    			data: JSON.stringify(myObj),
    			contentType: "application/json",
    		    dataType: "json",
    		    success: function(response) {
    		    	console.log("Data added! response received is: ", response);
    		    	requestId=response.id;
    		    	doMoveFurther(currentTarget);
    		    }
    		})
    };
    
    function verification(currentTarget){
    	// fields validation
    	// http://localhost:8080/zircon/services/v1/openrequest/validateotp?requestID=123123123&otp=12312
    	var otp=1212;
    		$.ajax({
    			type: 'POST',
    			url: serverURL+"zircon/services/v1/openrequest/validateotp?requestID="+requestId+"&otp="+otp,
    			contentType: "application/json",
    		    dataType: "json",
    		    success: function(response) {
    		    	console.log("Data added! response received is: ", response);
    		    	doMoveFurther(currentTarget);
    		    },
    		    failure : function(response){
    		    	moveForward=false;
    		    }
    		})
    }
    
    // previous step
    $('.f1 .btn-previous').on('click', function() {
    	console.log('This is called to get previous page');
    	// navigation steps / progress steps
    	var current_active_step = $(this).parents('.f1').find('.f1-step.active');
    	var progress_line = $(this).parents('.f1').find('.f1-progress-line');

    	$(this).parents('fieldset').fadeOut(400, function() {
    		// change icons
    		current_active_step.removeClass('active').prev().removeClass('activated').addClass('active');
    		// progress bar
    		bar_progress(progress_line, 'left');
    		// show previous step
    		$(this).prev().fadeIn();
    		// scroll window to beginning of the form
			scroll_to_class( $('.f1'), 20 );
    	});
    });

    // submit
    $('.verified').on('submit', function(e) {
    	debugger;
    	// fields validation
    	$('#myModal1').modal('hide')
    	console.debug('Clicking of verified button here');
    	// fields validation

    });


});



$(function() {

  var $window           = $(window),
      win_height_padded = $window.height() * 1.1,
      isTouch           = Modernizr.touch;

  if (isTouch) { $('.revealOnScroll').addClass('animated'); }

  $window.on('scroll', revealOnScroll);

  function revealOnScroll() {
    var scrolled = $window.scrollTop(),
        win_height_padded = $window.height() * 1.1;

    // Showed...
    $(".revealOnScroll:not(.animated)").each(function () {
      var $this     = $(this),
          offsetTop = $this.offset().top;

      if (scrolled + win_height_padded > offsetTop) {
        if ($this.data('timeout')) {
          window.setTimeout(function(){
            $this.addClass('animated ' + $this.data('animation'));
          }, parseInt($this.data('timeout'),10));
        } else {
          $this.addClass('animated ' + $this.data('animation'));
        }
      }
    });
    // Hidden...
   $(".revealOnScroll.animated").each(function (index) {
      var $this     = $(this),
          offsetTop = $this.offset().top;
      if (scrolled + win_height_padded < offsetTop) {
        $(this).removeClass('animated fadeInUp flipInX lightSpeedIn')
      }
    });
  }

  revealOnScroll();
});

$('.book-now').click(function(){

	$('.myModal1').modal({
	    backdrop: 'static',
	    keyboard: false,
	    show: true
	});

});



$('.f1-buttons .verified').click(function() {

	$('.myModal1').modal('hide');
	$('.myModal2').modal('show');

});
