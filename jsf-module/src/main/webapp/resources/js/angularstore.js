var app = angular.module("stores", ["checklist-model"]);

app.filter('timeago',function(){
  return function(input) {
    if (input==null) return null;
    var date=input.replace("T"," ");
    var timeAgo = moment(new Date(date)).fromNow()
    return timeAgo;
  };
});

app.run(function($rootScope) {
    $rootScope.constant={
            //SERVICE_URL:"http://localhost:8080/zircon/services",
            SERVICE_URL:"http://societyfocus.com/service",
        }
})

app.controller("addQuestionController", function($scope,$http,$rootScope) {
	 $scope.restaurant = {
			 feature: []
			  };
	$scope.features = [
	                {value: 'CASH', text: 'Cash'},
	                {value: 'BREAKFAST', text: 'Breakfast'},
	                {value: 'LUNCH', text: 'Lunch'},
	                {value: 'DINNER', text: 'Dinner'},
	                {value: 'INDOOR', text: 'Indoor'},
	                {value: 'TAKE_AWAY', text: 'Take-Away'},
	                {value: 'LUXURY_DINNING', text: 'Luxury Dinning'},
	                {value: 'CAFE', text: 'Cafe'},
	                {value: 'NIGHTLIFE', text: 'Nightlife'},
	                {value: 'CREDIT_CARD', text: 'Credit Card'},
	                {value: 'MEAL_VOUCHER', text: 'Meal Voucher'}
	              ];
	$scope.cusines = [
		                {value: 'NORTH_INDIAN', text: 'North Indian'},
		                {value: 'MUGHLAI', text: 'Mughlai'},
		                {value: 'SOUTH_INDIAN', text: 'South Indian'},
		                {value: 'FAST_FOOD', text: 'Fast food'},
		                {value: 'STREET_FOOD', text: 'Street Food'},
		                {value: 'SWEETS', text: 'Sweets'},
		                {value: 'DESERTS', text: 'Deserts'},
		                {value: 'MITHAI', text: 'Mithai'},
		                {value: 'CONTINENTAL', text: 'Continental'},
		                {value: 'ITALIAN', text: 'Italian'},
		                {value: 'HEALTHY_FOOD', text: 'Healthy Food'},
		              ];
	
	$scope.addRestaurant = function(){
    	console.log("Scope restaurant here."+$scope.restaurant);
    	if (marker!=null){
    		var location ={
    				point : {
    					x: marker.getPosition().lat(),
    					y: marker.getPosition().lng()
    				}
    		}
    		$scope.restaurant.location=location;
    	}
    	
    	if ($scope.restaurant.phonenonew!=null){
    			$scope.restaurant.phoneNo=[];
    			$scope.restaurant.phoneNo.push($scope.restaurant.phonenonew); 				
    	}
    	var jsonRestaurant = JSON.stringify($scope.restaurant, null, "\t")
    	console.log("Passing the Data: "+$scope.restaurant);
    	
    	var req = {
                method: 'POST',
                url: $rootScope.constant.SERVICE_URL + '/v1/store',
                data: jsonRestaurant
            }
            $http(req).then(function successCallback(response) {
               console.log(response.data.body);
            });
    	
    }
 });


var marker;
var map;

function initialize() {
	
	var mapProp = {
		center : new google.maps.LatLng(28.628974, 77.219567),
		zoom : 17,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	map = new google.maps.Map(document
			.getElementById("googleMap"), mapProp);
	
	var input = document.getElementById("location");
	var autocomplete = new google.maps.places.Autocomplete(input);
    autocomplete.bindTo('bounds', map);

    google.maps.event.addListener(map, 'click', function(event) {
        placeMarker(event.latLng);
    });
    
    autocomplete.addListener('place_changed', function() {
        var place = autocomplete.getPlace();
        if (!place.geometry) {
          window.alert("Autocomplete's returned place contains no geometry");
          return;
        }
        if (place.geometry.viewport) {
            map.fitBounds(place.geometry.viewport);
          } else {
            map.setCenter(place.geometry.location);
            map.setZoom(17);  // Why 17? Because it looks good.
          }
        
        marker = new google.maps.Marker({
            position: place.geometry.location,
            map: map,
          });
          marker.setPosition(place.geometry.location);
          marker.setVisible(true);
        });
}


google.maps.event.addDomListener(window, 'load', initialize);
function placeMarker(location) {
    if (marker == undefined){
        marker = new google.maps.Marker({
            position: location,
            map: map, 
            animation: google.maps.Animation.DROP,
        });
    }
    else{
        marker.setPosition(location);
    }
}

function handlePointClick(event) {
	if (currentMarker === null) {
		document.getElementById('post-classified-form:lat').value = event.latLng.lat();
		document.getElementById('post-classified-form:lng').value = event.latLng.lng();

		currentMarker = new google.maps.Marker({
			position : new google.maps.LatLng(event.latLng.lat(),
					event.latLng.lng()),
			draggable : true
		});

		google.maps.event
				.addListener(
						currentMarker,
						'drag',
						function(event) {
							document.getElementById('post-classified-form:lat').value = event.latLng
									.lat();
							document.getElementById('post-classified-form:lng').value = event.latLng
									.lng();
						});
	}
	placemarker()
}
