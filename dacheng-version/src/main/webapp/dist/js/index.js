App.controller('mainHeaderController', function($scope, $http, $timeout) {
	
	
	$scope.currentTime = function(){
		var NowTime=new Date().toLocaleTimeString() ;
		$scope.current = NowTime;
		$timeout(function(){$scope.currentTime();},1000);
	}
	
	$scope.toLogin = function(){
		window.location.href = path + "/login";
	}
	
	$scope.currentTime();
	
});




