
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

var constraints = {
		"name": {
			 presence: {
				 message:'can not be blank',
			 }
        },
        "phoneno":{
        	presence:{
				 message:'can not be blank',
			 },
        	length : {
        		maximum : 10,
        		minimum : 10,
        	}
        },
        "pincode":{
        	presence:{
				 message:'can not be blank',
			 },
        	length:{
        		minimum : 6,
        		maximum : 6,
        	}
        }
}
        
var requestId;
jQuery(document).ready(function() {

	$('.phoneno').on('keydown', function(e){-1!==$.inArray(e.keyCode,[46,8,9,27,13,110,190])||/65|67|86|88/.test(e.keyCode)&&(!0===e.ctrlKey||!0===e.metaKey)||35<=e.keyCode&&40>=e.keyCode||(e.shiftKey||48>e.keyCode||57<e.keyCode)&&(96>e.keyCode||105<e.keyCode)&&e.preventDefault()});
	$('#f1-otp').on('keydown', function(e){ $("#otp-err").text("") });

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
    		var form =  document.getElementById("des-i");
            var errors = validate(form, constraints);
            showErrors(form, errors || {});
            if (!errors) {
            	registerRequest(currentTarget);
            }else{
            }
    	}
    	
    	if (currentID=='verification'){
    		verification(currentTarget);
    	}
    	
    	
    	if( next_step ) {
    		//doSoimething()
    	}

    });
    
    function addError(messages, error) {
        var block = document.createElement("p");
        block.classList.add("help-block");
        block.classList.add("error");
        block.innerText = error;
        messages.appendChild(block);
      }
    
    // Shows the errors for a specific input
    function showErrorsForInput(input, errors) {
      // This is the root of the input
      var formGroup = closestParent(input.parentNode, "form-group")
        // Find where the error messages will be insert into
        , messages = formGroup.querySelector(".messages");
      // First we remove any old messages and resets the classes
      resetFormGroup(formGroup);
      // If we have errors
      if (errors) {
        // we first mark the group has having errors
        formGroup.classList.add("has-error");
        // then we append all the errors
        _.each(errors, function(error) {
          addError(messages, error);
        });
      } else {
        // otherwise we simply mark it as success
        formGroup.classList.add("has-success");
      }
    };
    
    function resetFormGroup(formGroup) {
        // Remove the success and error classes
        formGroup.classList.remove("has-error");
        formGroup.classList.remove("has-success");
        // and remove any old messages
        _.each(formGroup.querySelectorAll(".help-block.error"), function(el) {
          el.parentNode.removeChild(el);
        });
      }
    
    // Recusively finds the closest parent that has the specified class
    function closestParent(child, className) {
      if (!child || child == document) {
        return null;
      }
      if (child.classList.contains(className)) {
        return child;
      } else {
        return closestParent(child.parentNode, className);
      }
    }

    
    function showErrors(form, errors) {
        // We loop through all the inputs and show the errors for that input
    	_.each(form.querySelectorAll("input[name], select[name]"), function(input) {
          // Since the errors can be null if no errors were found we need to handle
          // that
          showErrorsForInput(input, errors && errors[input.name]);
        });
    };
    
    
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
	
		
    };
    
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
    			url: serverURL+"v1/openrequest",
    			data: JSON.stringify(myObj),
    			contentType: "application/json",
    		    dataType: "json",
    		    success: function(response) {
    		    	console.log("Data added! response received is: ", response);
    		    	requestId=response.body.id;
    		    	doMoveFurther(currentTarget);
    		    }
    		})
    };
    
    function verification(currentTarget){
    	// fields validation
    	// http://localhost:8080/zircon/services/v1/openrequest/validateotp?requestID=123123123&otp=12312
    	var otp=document.getElementById("f1-otp").value;
    		$.ajax({
    			type: 'POST',
    			url: serverURL+"v1/openrequest/validateotp?requestID="+requestId+"&otp="+otp,
    			contentType: "application/json",
    		    dataType: "json",
    		    success: function(response) {
    		    	console.log("Data added! response received is: ", response);
    		    	doMoveFurther(currentTarget);
    		    	$('.myModal1').modal('hide');
    		    	$('.myModal2').modal('show');
    		    },
    		    error  : function(response){
    		    	console.log("Error caused while validating the pin: ");
    		    	$("#otp-err").text("Pin Entered is incorrect")
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

	

});
