angular.module('myApp', ["ngRoute"])
.config(function($routeProvider) {
    $routeProvider
.when("/", {
        templateUrl : "../pages/login.js",
        controller : "firstCtrl"
    })
.when("/second",{
		templateUrl : "../html/second.html",
		controller : "secondCtrl"
	})
.when("/link", {
        templateUrl : "../html/link.html",
        controller : "thirdCtrl"
    })
.otherwise({redirectTo:"/"})
	});