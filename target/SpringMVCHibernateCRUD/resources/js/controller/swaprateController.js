var myApp  =  angular.module('app', ["ngRoute"])
.config(function($routeProvider) {
    $routeProvider
.when("", {
        templateUrl : "./pages/login.jsp",
    })
.when("/register",{
		templateUrl : "./pages/register.jsp",
	})
.when("/link", {
        templateUrl : "../html/link.html",
    })
.otherwise({redirectTo:"/login"})
	});