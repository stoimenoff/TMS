(function() {
	var app = angular.module('loginApp', []);
	
	app.controller("LoginController", ['$http', '$window', function($http, $window) {
		this.unsuccessful = false;
		var self = this;
	    this.user = {};
	    this.sendLoginRequest = function(){
	    	$http({
	    	    url: "/TMS/login",
	    	    method: "POST",
	    	    data: this.user
	    	}).then(function successCallback(response) {
	    	    // this callback will be called asynchronously
	    	    // when the response is available
	    		console.log(self.user);
	    		
	    		$window.location.reload();
	    		
	    		console.log("s");
	    		//console.log(response);
	    		
	    	  }, function errorCallback(response) {
	    		self.unsuccessful = true;
	    	});
	    };
  }]);
  
})();