(function() {
	var app = angular.module('registerApp', []);

	app.controller("RegisterController", [ '$http', '$window',
			function($http, $window) {
				var self = this;
				this.user = {};
				this.passwordCheck;
				this.sendRegisterRequest = function() {
					console.log("send r");
					// TODO some checks
					if (this.passwordCheck == this.user.password) {
						// TODO encrypt user password
						$http({
							url : "/TMS/register",
							method : "POST",
							data : this.user
						}).then(function successCallback(response) {
							console.log(response);
							$window.location = "/TMS/login";

						}, function errorCallback(response) {
							// TODO display reason
							console.log(response);
						});
					}
				};
			} ]);

})();