(function() {
	var app = angular.module('loginApp', []);
	
	app.controller("LoginController", ['$http', '$scope',function($http, $scope){
		
	    this.user = {};

	    this.sendLoginRequest = function(){
	    	$http({
	    	    url: "/TMS/login", 
	    	    method: "GET",
	    	    params: this.user
	    	}).then(function successCallback(response) {
	    	    // this callback will be called asynchronously
	    	    // when the response is available
	    		console.log("s");
	    		
	    	  }, function errorCallback(response) {
	    	    // called asynchronously if an error occurs
	    	    // or server returns response with an error status.
	    		console.log("e");
	    	});
	    	
	    	this.user = {};
	    };
  }]);
  
})();