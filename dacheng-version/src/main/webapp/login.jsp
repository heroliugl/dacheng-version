<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<html lang="en"	>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
<meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1">
<link href="faa.ico" type="image/x-icon" rel=icon>
<link href="faa.ico" type="image/x-icon" rel="shortcut icon">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登陆 - 大诚版本管理系统</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<!-- <link rel="stylesheet" href="ionicons/css/ionicons.min.css"> -->
<!-- Theme style -->
<link rel="stylesheet" href="dist/css/AdminLTE.css">
<!-- iCheck -->
<link rel="stylesheet" href="plugins/iCheck/square/blue.css">
</head>
<body class="hold-transition login-page" ng-app="myApp" ng-controller="loginCtrl" ng-cloak>
<div class="login-box">
  <div class="login-logo">
    <a href="index.jsp"><b>Dacheng</b>Version</a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">
       <img alt="" src="">
    </p>

    <form action="index.jsp" method="post">
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="Login Name" ng-model="loginName">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="Password" ng-model="password" >
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox" ng-model="remember_me" ng-checked="remember_me"> 记住我
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4" >
            <div class="checkbox icheck" style="float: right;">
            <label>
              <a href="#" >忘记密码</a>
           </label>
           </div>
        </div>
        <div class="col-xs-12">
          <button type="button" class="btn btn-primary btn-block btn-flat" ng-click="doLogin()"><!-- Sign In -->登 录</button>
        </div>
        <!-- /.col -->
      </div>
    </form>

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->
<!-- dialogModal -->
<div class="modal" id="dialogModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header is-redheader">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel"><i class="fa fa-bell"></i>&nbsp;{{dialogTitle}}</h4>
            </div>
            <div class="modal-body">
                <p class="delete-address">{{dialogContent}}</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn bs-btn is-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<!-- jQuery 2.2.3 -->
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="plugins/angularjs/angular.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="bootstrap/js/bootstrap.min.js"></script>

<script src="dist/js/login.js"></script>
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
<script>

var path = "<%=path%>";
  $(function () {
	
	  console.log("path === "+path);
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>
</body>
</html>