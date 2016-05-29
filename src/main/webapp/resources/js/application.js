//This file will have all the js required in application.
$(document).ready(function() {

	$('.contact__agent__button').click(function() {
		$('.modal__content').bPopup({
			positionStyle: 'fixed'
		});
	});

	$('#login-link').click(function() {
		showLoginPopup();
	});

	$(".dropdown").hover(function() {
		$('.dropdown-menu', this).stop(true, true).fadeIn("fast");
		$('b', this).toggleClass("caret caret-up");
	}, function() {
		$('.dropdown-menu', this).stop(true, true).fadeOut("fast");
		$('b', this).toggleClass("caret caret-up");
	});
	
});

function classifiedRegisterSuccessfully() {
	alert('Thank you for registering, Classified is registered Successfully');
}

function outOfQuotaPopup() {
	alert('Your Quota is expired, Kindly get it recharged if you want to post classified');
}

function showLoginPopup() {
	$('#loginPopUp').click();
	//$('.login_block').bPopup();
}

function showProjectPage(currentPageNumber) {
	var page = "#page-" + currentPageNumber;
	console.log("The Page number is " + currentPageNumber)
	var input = document.getElementById('pageNumber');
	input.value = currentPageNumber;
	$("#actionButton").click();
	scrollToTop(1000);
}

function clearcontactUsForm() {
	alert('Thank you for contacting Us, We will get back to you shortly.');
	$('#reset').click();
	console.log('Test');
}

function scrollToTop(scrollDuration) {
	var scrollStep = -window.scrollY / (scrollDuration / 15), scrollInterval = setInterval(
			function() {
				if (window.scrollY != 0) {
					window.scrollBy(0, scrollStep);
				} else
					clearInterval(scrollInterval);
			}, 15);
}

function scrollToDiv(divId) {
	$('html, body').animate({
		scrollTop : $(divId).offset().top
	}, 'slow');
}

$(function() {

    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
		$("#register-form").removeClass('modal__content')
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

});
