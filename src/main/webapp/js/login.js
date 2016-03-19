(function() {
	var app = angular.module('loginApp', []);

	app.controller("LoginController", [ '$http', '$window', '$scope',
			function($http, $window, $scope) {
				this.user = {};
				$scope.loginError = false;
				this.sendLoginRequest = function() {
					var hash_bits = sjcl.hash.sha256.hash(this.user.password);
					var passhash = sjcl.codec.hex.fromBits(hash_bits);

					var requestData = (JSON.parse(JSON.stringify(this.user)));
					requestData.password = passhash;
					$http({
						url : "/TMS/login",
						method : "POST",
						data : requestData
					}).then(function successCallback(response) {

						if ($window.location.pathname.indexOf("login") > -1) {
							$window.location = "/TMS/dashboard.html";
						} else {
							$window.location.reload();
						}

					}, function errorCallback(response) {
						// TODO
						$scope.loginError = true;
					});
				};
			} ]);

})();