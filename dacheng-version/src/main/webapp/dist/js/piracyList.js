  $(function () {
  });
  
  App.controller('piracysCtrl', function($scope, $http) {
	   	 console.log("5555555555555555555555555555555555555555");
	   	 
	   	  $scope.currentPage = 0;
	   	  $scope.pageCount = 0; 
	   	  $scope.source = source;

	    	  $scope.doQuery = function() {
	   	  		
	     		 $.post(path + "/device/piracyList",
	     	  	   {
	     			  currentPage: $scope.paginationConf.currentPage,
	              pageSize : $scope.paginationConf.itemsPerPage
	     	  	    }).success(
	     	  	       function (response) {
	     	  	    	  //  Framework.Admin.detectLoginStatus(response);
	     	  	    	   $scope.piracys = response.page.records;
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
	        
	        // 显示版本测试通过确认框
	     	$scope.showPass = function(id,obj) {
		    	 console.log(JSON.stringify(obj));
		    	 $scope.passVersion=obj;
		   		 $scope.test_version_id = id
		   	     $("#passModal").modal();
	        };
	        
	        // 版本测试通过
	        $scope.doPass = function() {
		   		$.post(path + "/version/testPass/"+$scope.test_version_id).success(
		 				   function (response) {
		 					  if(response.code == '200') {
		 						 $scope.doQuery();
		 						 $("#passModal").modal('hide');
		 					  }else{
		 						  $("#passModal").modal('hide');
		 						  $scope.showDialog("Warning",source[response.codemsg]);
		 					  }
		 			 });
	        };
	        
	        // 显示版本发布确认框
	     	$scope.showIssue = function(id,obj) {
		    	 console.log(JSON.stringify(obj));
		    	 $scope.issueVersion=obj;
		   		 $scope.issue_version_id = id
		   	     $("#issueModal").modal();
	        };
	        
	        // 版本发布
	        $scope.doIssue = function() {
		 		$.post(path + "/version/issue/"+$scope.issue_version_id).success(
		 				   function (response) {
		 					  if(response.code == '200') {
		 						 $scope.doQuery();
		 						 $("#issueModal").modal('hide');
		 					  }else{
		 						  $("#issueModal").modal('hide');
		 						  $scope.showDialog("Warning",source[response.codemsg]);
		 					  }
		 			 });
	        };
	        
	        // 显示删除确认框
	    	$scope.showDel = function(id,obj) {
	    		console.log(JSON.stringify(obj));
		    	 $scope.delVersion=obj;
		   		 $scope.del_version_id = id
		   	     $("#delModal").modal();
	        };
	        
	        // 版本删除
	    	$scope.doDel = function() {
	    		$.post(path + "/version/delete/"+$scope.del_version_id).success(
	 				   function (response) {
	 					  if(response.code == '200') {
	 						 $scope.doQuery();
	 						 $("#delModal").modal('hide');
	 					  }else{
	 						  $("#delModal").modal('hide');
	 						  $scope.showDialog("Warning",source[response.codemsg]);
	 					  }
	 			 });
	        };
	        
	        // 提示框
	        $scope.showDialog = function(title,content) {
	        	$scope.dialogTitle = title;
	        	$scope.dialogContent = content;
	        	$("#dialogModal").modal();
	        };
	        
	        
	        
	   });  
 