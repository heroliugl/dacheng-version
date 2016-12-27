  $(function () {
/*	  var language = {
  			"sLengthMenu":"每页显示 _MENU_ 条记录",
			"sZeroRecords":"抱歉， 没有找到",
			"sInfo":"从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
			"sInfoEmpty": "没有数据",
			"sInfoFiltered": "(从 _MAX_ 条数据中检索)",
			"oPaginate": {
    			"sFirst":"首页",
    			"sPrevious":"前一页",
    			"sNext":"后一页",
    			"sLast":"尾页"
			},
            "bPaginate":true
	  }
     $("#example1").DataTable({
    		"oLanguage":language
    	});*/
  });
  
  App.controller('versionsCtrl', function($scope, $http) {
	   	 console.log("5555555555555555555555555555555555555555");
	   	 
	   	  $scope.currentPage = 0;
	   	  $scope.pageCount = 0; 
	   	  $scope.source = source;
	   	  // $timeout(function(){},500);

	    	  $scope.doQuery = function() {
	   	  		
	     		 $.post(path + "/version/list",
	     	  	   {
	     			  currentPage: $scope.paginationConf.currentPage,
	              pageSize : $scope.paginationConf.itemsPerPage
	     	  	    }).success(
	     	  	       function (response) {
	     	  	    	  //  Framework.Admin.detectLoginStatus(response);
	     	  	    	   $scope.versions = response.page.records;
	     	               $scope.paginationConf.totalItems = response.page.rowCount;
	     	  	    	   $scope.$apply();
	     	  	    	   // $timeout(function(){$scope.doUserPermissionQuery();},1);
	     	  	    }).error(function(data, status, headers, config) {
	     	  	          //  Framework.Admin.detectLoginStatus(JSON.parse(data.responseText).errorCode);
	     	      	});
	     	   };

	        // 配置分页基本参数
	        $scope.paginationConf = {
	            currentPage: 1,
	            itemsPerPage: 10
	        };
	        
	        $scope.$watch('paginationConf.currentPage + paginationConf.itemsPerPage', $scope.doQuery);
	      // $scope.doQuery();
	   });  
  

 /* console.log("12321321");*/
  /*var app = angular.module('myApp', []);
  console.log(JSON.stringify(App));
 
	  'tm.pagination'
	  console.log("5555555555555555555555555555555555");
	  
	  app.controller('versionsCtrl', function($scope) {
			  alert("123456");
		      console.log("11111111111111111111111111111111111111");
		
			  $scope.currentPage = 0;
			  $scope.pageCount = 0;
			  $scope.source = source;
			  // $timeout(function(){},500);

		  	  $scope.doQuery = function() {
			  		
		  		 $.post(path + "/version/list",
		  	  	   {
		  			  currentPage: $scope.paginationConf.currentPage,
	                 pageSize : $scope.paginationConf.itemsPerPage
		  	  	    }).success(
		  	  	       function (response) {
		  	  	    	  //  Framework.Admin.detectLoginStatus(response);
		  	  	    	   $scope.versions = response.page.records;
	 	  	               $scope.paginationConf.totalItems = response.page.rowCount;
		  	  	    	   $scope.$apply();
		  	  	    	   // $timeout(function(){$scope.doUserPermissionQuery();},1);
		  	  	    }).error(function(data, status, headers, config) {
		  	  	          //  Framework.Admin.detectLoginStatus(JSON.parse(data.responseText).errorCode);
		  	      	});
		  	   };

		     // 配置分页基本参数
		     $scope.paginationConf = {
		         currentPage: 1,
		         itemsPerPage: 50
		     };
		     
	       $scope.$watch('paginationConf.currentPage + paginationConf.itemsPerPage', $scope.doQuery);
		   // $scope.doQuery();
	 
		}); 
	  */
	 //  console.log(JSON.stringify(App));

 