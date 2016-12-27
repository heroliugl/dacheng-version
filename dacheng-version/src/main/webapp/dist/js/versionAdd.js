  $(function () {
	
  });
  
  App.directive('validFile',function(){
      return {
        require:'ngModel',
        link:function(scope,el,attrs,ngModel){
          //change event is fired when file is selected
          el.bind('change',function(){
            scope.$apply(function(){
              ngModel.$setViewValue(el.val());
              ngModel.$render();
            });
          });
        }
      }
});

App.directive('fileModel', ['$parse', function ($parse) {
return {
    restrict: 'A',
    link: function(scope, element, attrs) {
        var model = $parse(attrs.fileModel);
        var modelSetter = model.assign;

        element.bind('change', function(){
            scope.$apply(function(){
                modelSetter(scope, element[0].files[0]);
            });
        });
    }
};
}]);

App.directive('maxFileSize', function() {
return {
require: 'ngModel',
link: function(scope, elem, attr, ctrl) {
  function bindEvent(element, type,attr,ctrl,scope, handler) {
    if (element.addEventListener) {
      element.addEventListener(type, handler, false);
    } else {
      element.attachEvent('on' + type, handler);
    }
  }

  bindEvent(elem[0], 'change',attr,ctrl,scope ,function() {
    if(this.files[0].size > attr.maxFileSize ){
        ctrl.$setValidity('maxFileSize', false);
    }else{
        ctrl.$setValidity('maxFileSize', true);
    }
    scope.$apply()
  });
}
}
});
  
  App.controller('versionsAddCtrl', function($scope, $http,Upload) {
   	  console.log("5555555555555555555555555555555555555555");
   	  $scope.source = source;
   	  $scope.textarea = "112233\n12312321";
   	  
   	  
   	  
   	//提交
   	 /*$scope.getFile = function () {
   		 // alert("12312312");
   		 var file = $scope.myFile;
         console.log("file.name"+file.name);
     };*/
   	  
   	  
      $scope.submit = function () {
          $scope.upload($scope.file);
      };
      $scope.upload = function (file) {
          $scope.fileInfo = file;
          Upload.upload({
              //服务端接收
              url: 'Ashx/UploadFile.ashx',
              //上传的同时带的参数
              data: {'username': $scope.username},
              //上传的文件
              file: file
          }).progress(function (evt) {
              //进度条
              var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
              console.log('progess:' + progressPercentage + '%' + evt.config.file.name);
          }).success(function (data, status, headers, config) {
              //上传成功
              console.log('file ' + config.file.name + 'uploaded. Response: ' + data);
              $scope.uploadImg = data;
          }).error(function (data, status, headers, config) {
              //上传失败
              console.log('error status: ' + status);
          });
      };
   	  
   	 //  $(".textarea").wysihtml5();
   	  
   	 $scope.getTextArea = function(){
   		 var text = $scope.textarea;
   		 console.log("text =  "+text);
   		 var param={
   				 log:text
   		 }
   		$.post(path + "/version/add",param).success(
				   function (response) {
					  console.log(response);
			 });
   	 }
	   	$scope.getFileInfo = function(){
	   		/*alert("123213");
	   		var file = $scope.myFile;
	   	    console.log("file =  "+file.name);*/
	   	}
   	 
  });  
 
 