'use strict';
angular.module('app').run(['$rootScope', '$state', '$stateParams',
  function($rootScope, $state, $stateParams) {
    $rootScope.$state = $state;
    $rootScope.$stateParams = $stateParams;
    $rootScope.$on('$stateChangeSuccess', function() {
      window.scrollTo(0, 0);
    });
    FastClick.attach(document.body);
  },
]).config(['$stateProvider', '$urlRouterProvider', '$injector',
  function($stateProvider, $urlRouterProvider, $injector) {
	
	$urlRouterProvider.otherwise( function($injector) {
    	var $state = $injector.get("$state");
    	$state.go('app.page1');
    });
    
    // Application routes
    $stateProvider.state('app', {
        abstract: true,
        templateUrl: './angularjs/views/common/layout.html'
      }).state('app.page1',{
    	  url: '/page1',
            templateUrl: './angularjs/views/app/page1.html',
            controller: 'page1Ctrl',
        	resolve: {
                deps: ['$ocLazyLoad', function($ocLazyLoad) {
                  return $ocLazyLoad.load([{
                      files: [
                              	'./angularjs/scripts/controllers/page1Ctrl.js',
                              	'./angularjs/scripts/services/services.js'
                              ]
                    }]);
                }]
              }
//      ,
//	          data: {
//	              permissions: {
//	                only: ['DEPO_SC101'],
//	                redirectTo: 'user.signout'
//	              }
//	            }
      }).state('app.page2',{
          url: '/page2',
          templateUrl: './angularjs/views/app/page2.html',
          controller: 'page2Ctrl',
          resolve: {
              deps: ['$ocLazyLoad', function($ocLazyLoad) {
                return $ocLazyLoad.load([{
                    files: [
                              './angularjs/scripts/controllers/page2Ctrl.js',
                              './angularjs/scripts/services/services.js'
                            ]
                  }]);
              }]
            }
//    ,
//          data: {
//              permissions: {
//                only: ['DEPO_SC101'],
//                redirectTo: 'user.signout'
//              }
//            }
    })
      
     ;
  }
]).config(['$ocLazyLoadProvider', function($ocLazyLoadProvider) {
  $ocLazyLoadProvider.config({
    debug: false,
    events: false
  });
}]);
