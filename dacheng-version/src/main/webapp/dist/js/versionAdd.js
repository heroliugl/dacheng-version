$(function() {

});

App.controller('versionsAddCtrl', function($scope, $http, Upload) {
	console.log("5555555555555555555555555555555555555555");
	$scope.source = source;
	$scope.vtype = "2";
	$scope.ptype = "";
	$scope.forceUpdate = "0";
	/*$scope.ptype = "bm2";*/
	var versionInfo = [];

	$scope.getFileInfo = function() {
		$scope.vname = "";
		$scope.vflag = "";
		$scope.vm = "";
		$scope._ptype = "";
		var fileName = $scope.fileName;
		if (fileName && fileName.length > 0) {
			var param = {
				fileName : $scope.fileName
			}
			$.post(path + "/version/getVersionInfo", param).success(
					function(response) {
						if(response && response.info){
							var _ptype = response.info.ptype;
							var ptype= $scope.ptype;
							$scope.pop_fileName = false;
					    	$scope.pop_msg_fileName = "";
							if(ptype && ptype.length > 0){
								if(ptype != _ptype){
									$scope.pop_fileName = true;
							    	$scope.pop_msg_fileName= "文件名称与产品类型不匹配";
								}
							}
							$scope._ptype = _ptype;
							$scope.vname = response.info.vname;
							$scope.vflag = response.info.vflag;
							$scope.vm = response.info.vm;
							$scope.$apply();
						}else{
							$scope.pop_fileName = true;
					    	$scope.pop_msg_fileName = "文件名称校验未通过";
					    	$scope.$apply();
						}
					});
		}
	}

	$scope.submit = function() {
		$scope.upload($scope.file);
	};

	$scope.checkFile = function() {
		console.log("checkFile checkFilecheckFile checkFile");
		var file = $scope.file;
		if(null !=file && '' != file){
			$scope.fileInfo = file;
			$scope.fileName = file.name
			$scope.getFileInfo();
		}
	};

	$scope.upload = function(file) {
		if(null != file && '' != file){
			var vname =  $scope.vname;
			var vm = $scope.vm;
			var ptype = $scope.ptype;
			var _ptype = $scope._ptype;
			var vtype = $scope.vtype;
			var vflag = $scope.vflag;
			var cnlog = $scope.cnlog;
			var enlog = $scope.enlog;
			// 提交前的判断
			var n=0;
			if(!ptype || vname.ptype == 0){
				$scope.pop_ptype = true;
		    	$scope.pop_msg_ptype = "请选择产品类型";
		    	n++;
			}else{
				$scope.pop_ptype = false;
			}
			
			if(!vname || vname.length == 0){
				$scope.pop_vname = true;
		    	$scope.pop_msg_vname = "上传的文件名无法正确识别版本名称";
		    	n++;
			}else{
				$scope.pop_vname = false;
			}
			
			if(!vm || vm.length == 0){
				$scope.pop_vm = true;
		    	$scope.pop_msg_vm = "上传的文件名无法正确识别版本号";
		    	n++;
			}else{
				$scope.pop_vm = false;
			}
			
			if(!vflag || vflag.length == 0){
				$scope.pop_vflag = true;
		    	$scope.pop_msg_vflag = "上传的文件名无法正确识别版本标注";
		    	n++;
			}else{
				$scope.pop_vflag = false;
			}
			
			if(!cnlog || cnlog.length == 0){
				$scope.pop_cnlog = true;
		    	$scope.pop_msg_cnlog = "请输入中文版本说明";
		    	n++;
			}else{
				$scope.pop_cnlog = false;
			}
			
			if(!enlog || enlog.length == 0){
				$scope.pop_enlog = true;
		    	$scope.pop_msg_enlog = "请输入英文版本说明";
		    	n++;
			}else{
				$scope.pop_enlog = false;
			}
			if(n > 0){
				// alert("位置错误");
				return;
			}
			// -----------
			var param = {
					"vname" : vname,
					"ptype" : ptype,
					"vtype" : vtype,
					"vflag" : vflag,
					"vm" : vm,
					"cnlog" : cnlog,
					"enlog" : enlog,
					"forceUpdate" : $scope.forceUpdate
				}
			console.log("param " + JSON.stringify(param));
			Upload.upload({
				// 服务端接收
				url : path + "/version/add",
				// 上传的同时带的参数
				data : param,
				// 上传的文件
				file : file
			}).progress(
					function(evt) {
						// 进度条
						var progressPercentage = parseInt(100.0 * evt.loaded
								/ evt.total);
						console.log('progess:' + progressPercentage + '%'
								+ evt.config.file.name);
					}).success(
					function(data, status, headers, config) {
						// 上传成功
						console.log('file ' + config.file.name
								+ 'uploaded. Response: ' + data);

						// console.log("Response " + JSON.stringify(data));
						$scope.responseData(data);
						// $scope.uploadImg = data;
					}).error(function(data, status, headers, config) {
						// 上传失败
						console.log('error status: ' + status);
			});
		}else{
			$scope.pop_fileName = true;
	    	$scope.pop_msg_fileName = "请选择需要上传的文件";
		}
	};
	// $(".textarea").wysihtml5();
    $scope.responseData = function(data) {
		console.log("Response " + JSON.stringify(data));
		if(data.code == '200'){
			$scope.formReset();
			$scope.showDialog("提示","版本信息保存成功");
		}else{
			$scope.showDialog("警告",data.codemsg);
		}
	};
	
    $scope.formReset = function() {
    	$scope.pop_ptype = false;
    	$scope.pop_msg_ptype = "";
    	$scope.pop_fileName = false;
    	$scope.pop_msg_fileName = "";
    	$scope.pop_vname = false;
    	$scope.pop_msg_vname = "";
    	$scope.pop_vm = false;
    	$scope.pop_msg_vm = "";
    	$scope.pop_vflag = false;
    	$scope.pop_msg_vflag = "";
    	$scope.pop_cnlog = false;
    	$scope.pop_msg_cnlog = "";
    	$scope.pop_enlog = false;
    	$scope.pop_msg_enlog = "";
    	$scope.vname="";
		$scope.vm="";
		$scope.fileName="";
		$scope.fileInfo="";
		$scope.ptype="";
		$scope._ptype="";
		// $scope.vtype="";
		$scope.vflag="";
		$scope.cnlog="";
		$scope.enlog="";
		$scope.file="";
	};

    $scope.showDialog = function(title,content) {
    	$scope.dialogTitle = title;
    	$scope.dialogContent = content;
    	$("#dialogModal").modal();
    };
	
});
