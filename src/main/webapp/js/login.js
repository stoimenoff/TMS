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
	    	    
	    		
	    		if($window.location.pathname.indexOf("login") > -1) {
	    			$window.location = "/TMS/dashboard.html";
	    		} else {
	    			$window.location.reload();
	    		}
	    		
	    	  }, function errorCallback(response) {
	    		self.unsuccessful = true;
	    	});
	    };
  }]);
  
})();