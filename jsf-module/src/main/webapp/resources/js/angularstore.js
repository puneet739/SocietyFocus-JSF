var app = angular.module("stores", []);

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
            // SERVICE_URL:"http://zircon.com/zservice",
            APP_PREFIX:"http://societyfocus.com/helpdesk",
            SERVICE_URL:"http://societyfocus.com/service",
            name: 'Society Focus Helpdesk, Forum for all society related issues, maintaince, Legal Advice, Resource handling, Parking issues.',
            description: 'Society Focus Helpdesk, Forum for all society related issues, maintaince, Legal Advice, Resource handling, Parking issues.',
        }
})

app.controller("addQuestionController", function($scope,$http,$rootScope) {

	$scope.addRestaurant = function(){
    	console.log("Scope restaurant here."+$scope.restaurant);
    }
    
 });

