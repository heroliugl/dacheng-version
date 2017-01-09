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
 