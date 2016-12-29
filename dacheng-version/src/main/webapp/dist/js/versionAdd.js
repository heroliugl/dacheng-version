  $(function () {
	
	
  });

  App.controller('versionsAddCtrl', function($scope, $http,FileUploader,Upload) {
   	  console.log("5555555555555555555555555555555555555555");
   	  $scope.source = source;
   	  
   	  $scope.vtype="2";
   	  $scope.forceUpdate="0";
   	var versionInfo = [];
   	var uploader = $scope.uploader = new FileUploader({
        url: path + "/version/add",
        queueLimit: 1,     //文件个数 
        removeAfterUpload: false   //上传后删除文件
    });
   	
   	
   	$scope.clearItems = function(){    //重新选择文件时，清空队列，达到覆盖文件的效果
   		console.log("clearItems");
   		var ss= $scope.upFiles;
   	 console.log(JSON.stringify("ss "+ss));
      //  uploader.clearQueue();
        $scope.fileName = "";
    }
   	
   	$scope.getFile = function(){    //重新选择文件时，清空队列，达到覆盖文件的效果
   		console.log("getFile");
   	    uploader.clearQueue();
    }
   	
   	
   	
   
   	// 选中文件
    uploader.onAfterAddingFile = function(fileItem) {
    	console.log("onAfterAddingFile");
    	console.log(fileItem._file);
    	
    	$scope.fileName = fileItem._file.name;
    	$scope.getFileInfo();
       // $scope.fileItem = fileItem._file;    //添加文件之后，把文件信息赋给scope
    };
    
    
    uploader.onBeforeUploadItem = function(item) {
        console.info('onBeforeUploadItem', item);
        // 其他参数设置
        var param = {
        		"vname":$scope.vname,
        		"vm":$scope.vm,
        		"ptype":$scope.ptype,
        		"vtype":$scope.vtype,
        		"vflag":$scope.vflag,
        		"vm":$scope.vm,
        		"cnlog":$scope.cnlog,
        		"enlog":$scope.enlog,
        		"forceUpdate":$scope.forceUpdate
        }
        console.log("ptype"+$scope.ptype);
        console.log("forceUpdate"+$scope.forceUpdate);
        console.log("param : "+JSON.stringify(param));
        versionInfo.push(param);
       Array.prototype.push.apply(item.formData, versionInfo);
    };
    
    uploader.onProgressItem = function(fileItem, progress) {
        console.info('onProgressItem', fileItem, progress);
    };
    
    uploader.onProgressAll = function(progress) {
        console.info('onProgressAll', progress);
    };
  
    uploader.onSuccessItem = function(fileItem, response, status, headers) {
       // $scope.uploadStatus = true;   //上传成功则把状态改为true
    	console.info('onSuccessItem', fileItem, response, status, headers);
    };
    
    uploader.onErrorItem = function(fileItem, response, status, headers) {
        console.info('onErrorItem', fileItem, response, status, headers);
    };
    
    uploader.onCompleteItem = function(fileItem, response, status, headers) {
        console.info('onCompleteItem', fileItem, response, status, headers);
    };
    
    uploader.onCompleteAll = function() {
        console.info('onCompleteAll');
        this.clearQueue();
    };
    
    console.info('uploader', uploader);

    $scope.UploadFile = function(){
    	console.log("UploadFile  --- --- --- ");
    	
        uploader.uploadAll();
        console.info('uploader', uploader);
        
        
        /*if(status){
            if(status1){
                alert('上传成功！');
            }else{
                alert('证书成功！私钥失败！');
            }
       }else{
            if(status1){
               alert('私钥成功！证书失败！');
            }else{
               alert('上传失败！');
            }
       }*/
    }
    
   	$scope.getFileInfo = function(){
   		/*alert("123213");
   		var file = $scope.myFile;
   	    console.log("file =  "+file.name);*/
   		var param={
  				 fileName:$scope.fileName
  		 }
  		$.post(path + "/version/getVersionInfo",param).success(
				   function (response) {
					   $scope.vname = response.info.vname;
					   $scope.vflag = response.info.vflag;
					   $scope.vm = response.info.vm;
					   $scope.$apply();
					  console.log(JSON.stringify(response.info));
					  
			 });
   		
   	}
   	  
   	  
      $scope.submit = function () {
          $scope.upload($scope.file);
      };
      
      $scope.checkFile = function () {
        var file = $scope.file;
        $scope.fileInfo = file;
        $scope.fileName=file.name
        $scope.getFileInfo();
        console.log("checkFile "+JSON.stringify(file.name));
      };
      
      
      $scope.upload = function (file) {
          // $scope.fileInfo = file;
          var param = {
          		"vname":$scope.vname,
          		"vm":$scope.vm,
          		"ptype":$scope.ptype,
          		"vtype":$scope.vtype,
          		"vflag":$scope.vflag,
          		"vm":$scope.vm,
          		"cnlog":$scope.cnlog,
          		"enlog":$scope.enlog,
          		"forceUpdate":$scope.forceUpdate
          }
          Upload.upload({
              //服务端接收
              url: path + "/version/add",
              //上传的同时带的参数
              data: param,
              //上传的文件
              file: file
          }).progress(function (evt) {
              //进度条
              var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
              console.log('progess:' + progressPercentage + '%' + evt.config.file.name);
          }).success(function (data, status, headers, config) {
              //上传成功
              console.log('file ' + config.file.name + 'uploaded. Response: ' + data);
              
              console.log("Response "+JSON.stringify(data));
             // $scope.uploadImg = data;
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

   	 
  });  
 
 