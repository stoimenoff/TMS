(function() {
	var app = angular.module('profile', []);

	app.controller("ProfileController", [ '$http', '$scope', '$window',
			function($http, $scope, $window) {
				$http({
					url : "/TMS/profile",
					method : "POST"
				}).then(function successCallback(response) {
					$scope.user = response.data;
				}, function errorCallback(response) {
					// TODO
					console.log(response);
				});
				
				this.logOut = function() {
					$http({
						url : "/TMS/logout",
						method : "POST"
					}).then(function successCallback(response) {
						$window.location = "/TMS";
					}, function errorCallback(response) {
						// TODO
						console.log(response);
					});
				};

			} ]);

})();