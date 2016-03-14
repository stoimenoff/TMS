(function() {
	var app = angular.module('registerApp', []);

	app.controller("RegisterController", [
			'$http',
			'$window',
			function($http, $window) {
				this.user = {};
				this.passwordCheck;
				this.sendRegisterRequest = function() {
					// TODO some checks
					if (this.passwordCheck == this.user.password) {
						var hash_bits = sjcl.hash.sha256.hash(this.user.password);
						var passhash = sjcl.codec.hex.fromBits(hash_bits);

						var requestData = (JSON.parse(JSON.stringify(this.user)));
						requestData.password = passhash;
						console.log(requestData);
						$http({
							url : "/TMS/register",
							method : "POST",
							data : requestData
						}).then(function successCallback(response) {
							console.log(response);
							$window.location = "/TMS/login";

						}, function errorCallback(response) {
							// TODO display reason
							console.log(response);
						});
					} else {
						// TODO display password mismatch message
					}
				};
			} ]);

})();