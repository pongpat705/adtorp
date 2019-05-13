
'use strict';
angular
    .module('app')
        .controller('inquiryCtrl', [  '$scope', '$http', 'services',
  function page1Ctrl($scope, $http, services) {
    
        	
        	$scope.searchForm = {};
        	
        	
        	$scope.seachButton = function(){
        		
        		console.log($scope.searchForm);
        	}
        	
        	
     
        	$scope.filmList = [];
		     $scope.$watch("init", function(){
		        
		        console.log('page1');
		        $scope.getAllFilm(0, 20, 'G');
		        
		    });
		
		     $scope.getAllFilm = function(page, size, rating){
		    	 
		    	 
		    	 $http.get('/api/allFilmsByRatingViaReposNamedMethod?page='+page+'&rating='+rating+'&size='+size).then(function(response){
		    		 console.log(response);
		    		 $scope.filmList = response.data;
		    	 }).catch(function(response){
		    		 console.error(response);
		    	 });
		    	 
		     };
	 
  }
]);