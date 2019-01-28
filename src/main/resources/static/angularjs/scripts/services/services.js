
angular.module('app').factory('services',
		['$http', '$filter', '$rootScope',
		 function services
		 ($http, $filter,$rootScope) {
    return { 
	  genericGet : function(link, params){
	  	  return $http.get(link, {params:params});
	  },
	  genericPost: function(link, entity){
      	return $http.post(link,entity);
      },
      genericPut : function(link, entity){
    	  return $http.put(link,entity);
      },
	  genericPatch : function(generic,link){
    	  return $http.patch(link,generic);
      },
      genericDel : function(id){
    	  return $http.delete(id);
      },
      genericPatchUrl : function(patient,link){
    	  return $http.patch(link,patient, {headers:{'Content-Type': 'text/uri-list'}});
      },
      uploadFile : function(file, txn, user){
    	  var fd = new FormData();
          fd.append('file', file);
          return $http(
        		  {	url: CONTEXT+'/service/uploadImage/'+txn.transactionId+'/'+user,
        			method: 'POST',
        			data: fd,
        			headers: { 'Content-Type': undefined},
        			transformRequest: angular.identity
        		  });
      },
      genericPutUrl : function(object, link){
    	  return $http.put(link,object, {headers:{'Content-Type': 'text/uri-list'}});
      }
    };
  }]);