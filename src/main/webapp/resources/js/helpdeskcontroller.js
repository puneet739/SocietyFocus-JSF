var app = angular.module("helpdesk", ['ngRoute']);


app.run(function($rootScope) {
    $rootScope.constant={
//            SERVICE_URL:"http://zircon.com/zservice",
            APP_PREFIX:"http://societyfocus.com/helpdesk",
             SERVICE_URL:"http://societyfocus.com/service",
            name: 'Society Focus Helpdesk, Forum for all society related issues, maintaince, Legal Advice, Resource handling, Parking issues.',
            description: 'Society Focus Helpdesk, Forum for all society related issues, maintaince, Legal Advice, Resource handling, Parking issues.',
        }
})
app.controller("questionController", function($scope,$http,$rootScope,$routeParams,$anchorScroll,$location) {
    $scope.addComment = function(){
        console.log($scope.comment);
        var reqComment = {
            method: 'POST',
            url:  $rootScope.constant.SERVICE_URL + '/helpdesk/addcomment/'+$routeParams.id,
            data: $scope.comment
        }
        $http(reqComment).then(function successCallback(response) {
            console.log(response);
            $scope.commentSuccess =true;

        });
    }
 });
app.controller('askquestionController', function($scope,$http,$rootScope){
    $scope.askQuestion = function(){
        $rootScope.constant.basetitle='Society Focus Helpdesk Forum, Home for all society maintaince related issues';
    }

    $scope.addQuestion = function(){
        var req = {
            method: 'POST',
            url:  $rootScope.constant.SERVICE_URL + '/helpdesk/addquery',
            data: $scope.askQ
        }
        $http(req).then(function successCallback(response) {
            console.log(response);
            $scope.addSuccess =true;
        });
    }
})