   $(function() {
	  
   });
   
   var app = angular.module('myApp', []);
   
   app.controller('loginCtrl', function($scope, $http, $timeout) {
	  /* $timeout(function(){
		   $scope.source = source;
	   },500);*/
	   
	   var _loginName = getCookie("loginName");
	   // alert("userName:"+userName);
	   if(_loginName.length > 0){
		   $scope.remember_me = true;
		   $scope.loginName=_loginName;
	   }else{
		   $scope.remember_me = false;
		   $scope.loginName="";
	   }
	   
	   // Enter Key down event
	   document.onkeydown = function(event_e) {
			if (window.event) {
				event_e = window.event;
			}

			var int_keycode = event_e.charCode || event_e.keyCode;
			if (int_keycode == '13') {
				 $scope.doLogin();
				return false;
			}
		}
	   
	   
	   $scope.doLogin = function(){
		  /* $scope.log_in = true;
		   $scope.loginform.loginName.$dirty = true;
		   $scope.loginform.password.$dirty = true;*/
		   var loginName = $scope.loginName;
		   var password = $scope.password;
		   console.log("loginName "+loginName+"password "+password);
		   
		   if(loginName.length > 0 && password.length > 0){
			   var param = {
        			   loginName: loginName,
        			   password: password,
        	    }
	    	    $.post(path + "/doLogin",param).success(
	    	  	  	       function (response) {
	    	  	  	    	if(response.code == '200') {
		 	   	  	  			if($scope.rememberChecked()){
		 	   	  				    processCookie("loginName",loginName);
		 		   	  			}else{
		 		   	  				delCookie("loginName");
		 		   	  			}
		 	   	  	  			window.location.href = path + "/index";
	    	  	  	    	  }else{
	    	  	  	    		 $scope.showDialog("Warning",response.codemsg);
	    	  	  	    	  }
	    	  	  	          $scope.$apply();
	 		    	 });
			   
		   }
	   }
	   
	   $scope.rememberChecked = function() {
		   if ($scope.remember_me==true) {
				return true;
			}else {
				return false;
			}
      };
	   
	   // show Dialog
	   $scope.showDialog = function(title,content) {
	    	$scope.dialogTitle = title;
	    	$scope.dialogContent = content;
	    	$scope.$apply();
	    	$("#dialogModal").modal();
       };
   });
	
	function processCookie(key,val) {
		var today = new Date();
		var expires_date = 7; // 过期天数
		setCookie(key, val, expires_date);
	}
	
	
	
	// 设置Cookies
	function setCookie(name, value, day) {
		var Days = day;
		var exp = new Date(); // new Date("December 31, 9998");
		exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
		document.cookie = name + "=" + escape(value) + ";path=/;expires="
				+ exp.toGMTString();
	}

	// 读取Cookies
	function getCookie(name) {
		var arr = document.cookie
				.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
		if (arr != null)
			return unescape(arr[2]);
		return "";
	}

	// 清除Cookies
	function delCookie(name) {
		var exp = new Date();
		exp.setTime(exp.getTime() - 1000);
		var cval = getCookie(name);
		if (cval != null)
			document.cookie = name + "=" + null + ";expires=" + exp.toGMTString();
	}