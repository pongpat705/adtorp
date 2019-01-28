'use strict';
angular.module('app').controller('AppCtrl', ['$scope', '$http', '$timeout', '$window', '$rootScope',
  function AppCtrl($scope, $http, $timeout, $window, $rootScope) {
    
	$scope.title = "";
	$scope.todos = [];
	
	$scope.$watch("init", function(){
	});
	
	
  }
]);
