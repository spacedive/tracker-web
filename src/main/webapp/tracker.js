angular.module('tracker-app', [])
.controller('tracker-controller', function($scope, $http) {
	
	var path = 'rest/domains';

    getTopThreeDomains($scope);

    $scope.saveDomain = function() {
        $http.get(path + '/' + $scope.domainReferral).
    		then(function(response) {});
        getTopThreeDomains($scope);
    };
        
    function getTopThreeDomains(scope) {
        $http.get(path + '?limit=3').
    		then(function(response) {
    			scope.topThree = response.data;
    	});
      }
});
