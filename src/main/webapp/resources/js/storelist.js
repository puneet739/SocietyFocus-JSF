function loadData(pageno){
	var input = document.getElementById('pageNumber');
	input.value = pageno;
	console.log("Working on page no."+input);
	$("#actionButton").click();
	//scrollToTop(1000);
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