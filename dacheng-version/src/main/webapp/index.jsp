<%@ page language="java" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en"	>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Version | Dashboard</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">-->
  <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
  
  <!-- Ionicons -->
  <!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">-->
<!--   <link rel="stylesheet" href="ionicons/css/ionicons.min.css"> -->
  
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.css">
    <link rel="stylesheet" href="dist/css/page_list.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<!--   <link rel="stylesheet" href="dist/css/skins/_all-skins.css"> -->
  <link rel="stylesheet" href="dist/css/skins/_all-skins.css">
  <!-- iCheck -->
<!--   <link rel="stylesheet" href="plugins/iCheck/flat/blue.css"> -->
  <link rel="stylesheet" href="plugins/iCheck/all.css">
  <!-- Morris chart -->
  <link rel="stylesheet" href="plugins/morris/morris.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <!-- Date Picker -->
  <link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  
  
  <link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css">
  <link rel="stylesheet" href="plugins/angular-datatables/css/angular-datatables.css">
</head>
<body class="hold-transition skin-blue sidebar-mini" ng-app="myApp">
<div class="wrapper" >
  <div ng-controller="mainHeaderController">
  <header class="main-header" >
    <!-- Logo -->
    <a href="" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>DC</b>-V</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Dacheng</b>Version</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <div class="navbar-custom-menu" >
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          <li class="dropdown messages-menu">
            
            <a href="#" >
              <span class="hidden-xs" style="font-size: 14px;"><strong>{{current}}</strong></span>
            </a> 
          </li>
          <li class="dropdown messages-menu">
            <a href="" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-envelope-o"></i>
              <span class="label label-success">0</span>
            </a>
           <!--  <ul class="dropdown-menu">
              <li class="header">You have 4 messages</li>
              <li>
                inner menu: contains the actual data
                <ul class="menu">
                  <li>start message
                    <a href="#">
                      <div class="pull-left">
                        <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Support Team
                        <small><i class="fa fa-clock-o"></i> 5 mins</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                  end message
                  <li>
                    <a href="#">
                      <div class="pull-left">
                        <img src="dist/img/user3-128x128.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        AdminLTE Design Team
                        <small><i class="fa fa-clock-o"></i> 2 hours</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <div class="pull-left">
                        <img src="dist/img/user4-128x128.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Developers
                        <small><i class="fa fa-clock-o"></i> Today</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <div class="pull-left">
                        <img src="dist/img/user3-128x128.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Sales Department
                        <small><i class="fa fa-clock-o"></i> Yesterday</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
  
                  <li>
                    <a href="#">
                      <div class="pull-left">
                        <img src="dist/img/user4-128x128.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Reviewers
                        <small><i class="fa fa-clock-o"></i> 2 days</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                </ul>
              </li>
              <li class="footer"><a href="#">See All Messages</a></li>
            </ul> -->
          </li>
          <!-- Notifications: style can be found in dropdown.less -->
          <li class="dropdown notifications-menu">
            <a href="" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-bell-o"></i>
              <span class="label label-warning">0</span>
            </a>
   <!--          <ul class="dropdown-menu">
              <li class="header">You have 10 notifications</li>
              <li>
                inner menu: contains the actual data
                <ul class="menu">
                  <li>
                    <a href="#">
                      <i class="fa fa-users text-aqua"></i> 5 new members joined today
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-warning text-yellow"></i> Very long description here that may not fit into the
                      page and may cause design problems
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-users text-red"></i> 5 new members joined
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-shopping-cart text-green"></i> 25 sales made
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-user text-red"></i> You changed your username
                    </a>
                  </li>
                </ul>
              </li>
              <li class="footer"><a href="#">View all</a></li>
            </ul> -->
          </li>
          <!-- Tasks: style can be found in dropdown.less -->
          <li class="dropdown tasks-menu">
            <a href="" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-flag-o"></i>
              <span class="label label-danger">0</span>
            </a>
<!--             <ul class="dropdown-menu">
              <li class="header">You have 9 tasks</li>
              <li>
                inner menu: contains the actual data
                <ul class="menu">
                  <li>Task item
                    <a href="#">
                      <h3>
                        Design some buttons
                        <small class="pull-right">20%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">20% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  end task item
                  <li>Task item
                    <a href="#">
                      <h3>
                        Create a nice theme
                        <small class="pull-right">40%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-green" style="width: 40%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">40% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  end task item
                  <li>Task item
                    <a href="#">
                      <h3>
                        Some task I need to do
                        <small class="pull-right">60%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-red" style="width: 60%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">60% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  end task item
                  <li>Task item
                    <a href="#">
                      <h3>
                        Make beautiful transitions
                        <small class="pull-right">80%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-yellow" style="width: 80%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">80% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  end task item
                </ul>
              </li>
              <li class="footer">
                <a href="#">View all tasks</a>
              </li>
            </ul> -->
          </li>
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="" class="dropdown-toggle" data-toggle="dropdown">
              <img src="dist/img/user1-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs">Admin</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="dist/img/user1-160x160.jpg" class="img-circle" alt="User Image">

                <p>
                  Admin - Web Administrator
                  <small>Member since Nov. 2012</small>
                </p>
              </li>
              <!-- Menu Body -->
              <li class="user-body">
                <!-- <div class="row">
                  <div class="col-xs-4 text-center">
                    <a href="#">Followers</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Sales</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Friends</a>
                  </div>
                </div> -->
                <!-- /.row -->
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">设置</a>
                </div>
                <div class="pull-right">
                  <a href="#" class="btn btn-default btn-flat" ng-click="toLogin()">退出</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar  ng-controller="mainSidebarController"-->
  <aside class="main-sidebar" >
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="dist/img/user1-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Administrator</p>
          <!-- <a href="#">--><i class="fa fa-circle text-success"></i> <!-- Online</a> -->
        </div>
      </div>
      <!-- search form -->
     <!--  <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form> -->
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header"><strong>导航面板</strong></li>
        <li class="active">
          <a href="#/index"><!-- /pages/calendar.html -->
            <i class="fa fa-dashboard"></i> <span>控制台</span>
            <span class="pull-right-container">
              <!-- <i class="fa fa-angle-left pull-right"></i> -->
            </span>
          </a>
          <!-- <ul class="treeview-menu">
            <li class="active"><a href="index.html"><i class="fa fa-circle-o"></i> Dashboard v1</a></li>
            <li><a href="index2.html"><i class="fa fa-circle-o"></i> Dashboard v2</a></li>
          </ul> -->
        </li>
        <li>
          <a href="#/version/list">
            <i class="fa fa-files-o"></i> <span>版本管理</span>
            <span class="pull-right-container">
              <small class="label pull-right bg-green"></small>
            </span>
          </a>
        </li>
        <!-- <li class="treeview">
          <a href="javascript:void(0)">
            <i class="fa fa-files-o"></i>
            <span>版本管理</span>
            <span class="pull-right-container">
              <span class="label label-primary pull-right">4</span>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#/version/list"><i class="fa fa-circle-o"></i> BM2</a></li>
            <li><a href="/pages/layout/boxed.html"><i class="fa fa-circle-o"></i> OBD</a></li>
            <li><a href="/pages/layout/fixed.html"><i class="fa fa-circle-o"></i> 床垫</a></li>
            <li><a href="/pages/layout/collapsed-sidebar.html"><i class="fa fa-circle-o"></i> 其他</a></li>
          </ul>
        </li> -->
<!--         <li class="treeview">
	          <a href="#">
	            <i class="fa fa-pie-chart"></i>
	            <span>统计</span>
	            <span class="pull-right-container">
	              <i class="fa fa-angle-left pull-right"></i>
	            </span>
	          </a>
	          <ul class="treeview-menu">
	            <li><a href="javascript:void(0);"><i class="fa fa-circle-o"></i> ChartJS</a></li>
	            <li><a href="javascript:void(0);"><i class="fa fa-circle-o"></i> Morris</a></li>
	            <li><a href="javascript:void(0);"><i class="fa fa-circle-o"></i> Flot</a></li>
	            <li><a href="javascript:void(0);"><i class="fa fa-circle-o"></i> Inline charts</a></li>
	          </ul>
	    </li> -->
        <li>
          <a href="#/help">
            <i class="fa fa-th"></i> <span>帮助</span>
            <span class="pull-right-container">
              <small class="label pull-right bg-green">new</small>
            </span>
          </a>
        </li>
        <!--  -->
<!--         <li class="treeview">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>Charts</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/charts/chartjs.html"><i class="fa fa-circle-o"></i> ChartJS</a></li>
            <li><a href="pages/charts/morris.html"><i class="fa fa-circle-o"></i> Morris</a></li>
            <li><a href="pages/charts/flot.html"><i class="fa fa-circle-o"></i> Flot</a></li>
            <li><a href="pages/charts/inline.html"><i class="fa fa-circle-o"></i> Inline charts</a></li>
          </ul>
        </li> -->
        
<!--         <li><a href="documentation/index.html"><i class="fa fa-book"></i> <span>Documentation</span></a></li>
        <li class="header">LABELS</li>
        <li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Important</span></a></li>
        <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Warning</span></a></li>
        <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li> -->
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
</div>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Main content -->
 
       <!--  <iframe frameborder="0" class="content-iframe" width="100%" style="min-height: 850px;" marginheight="0" marginwidth="0" scrolling="yes" 
	       src="pages/tables/data.html">
	   </iframe>  -->
	   <!-- src="http://www.sina.com.cn"> -->
	   <div id="contentDiv" ui-view></div>
   
    <!-- /.content -->
  </div>
  
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 1.0.0
    </div>
    <strong>Copyright &copy; 2014-2016 <a href="http://www.dosapi.cn" target="_blank">Dacheng</a>.</strong> All rights
    reserved.
  </footer>

   <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
      <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
      <!-- <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li> -->
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
      <!-- Home tab content -->
      <div class="tab-pane" id="control-sidebar-home-tab">
        <h3 class="control-sidebar-heading">最新动态</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-birthday-cake bg-red"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">2017年国庆中秋一起过</h4>

                <p>2017年的国庆中秋重合了，大家有没有发现！</p>
              </div>
            </a>
          </li>
<!--           <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-user bg-yellow"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Frodo Updated His Profile</h4>

                <p>New phone +1(800)555-1234</p>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-envelope-o bg-light-blue"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Nora Joined Mailing List</h4>

                <p>nora@example.com</p>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-file-code-o bg-green"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Cron Job 254 Executed</h4>

                <p>Execution time 5 seconds</p>
              </div>
            </a>
          </li> -->
        </ul>
        <!-- /.control-sidebar-menu -->

       <!--  <h3 class="control-sidebar-heading">Tasks Progress</h3> -->
  <!--       <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Custom Template Design
                <span class="label label-danger pull-right">70%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Update Resume
                <span class="label label-success pull-right">95%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-success" style="width: 95%"></div>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Laravel Integration
                <span class="label label-warning pull-right">50%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-warning" style="width: 50%"></div>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Back End Framework
                <span class="label label-primary pull-right">68%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
              </div>
            </a>
          </li>
        </ul> -->
        <!-- /.control-sidebar-menu -->

      </div>
      <!-- /.tab-pane -->
      <!-- Stats tab content -->
      <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
      <!-- /.tab-pane -->
      <!-- Settings tab content -->
      <!-- div class="tab-pane" id="control-sidebar-settings-tab">
        <form method="post">
          <h3 class="control-sidebar-heading">General Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Report panel usage
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Some information about this general settings option
            </p>
          </div>
          /.form-group

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Allow mail redirect
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Other sets of options are available
            </p>
          </div>
          /.form-group

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Expose author name in posts
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Allow the user to show his name in blog posts
            </p>
          </div>
          /.form-group

          <h3 class="control-sidebar-heading">Chat Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Show me as online
              <input type="checkbox" class="pull-right" checked>
            </label>
          </div>
          /.form-group

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Turn off notifications
              <input type="checkbox" class="pull-right">
            </label>
          </div>
          /.form-group

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Delete chat history
              <a href="javascript:void(0)" class="text-red pull-right"><i class="fa fa-trash-o"></i></a>
            </label>
          </div>
          /.form-group
        </form>
      </div> -->
      <!-- /.tab-pane -->
    </div>
  </aside>
  <!-- /.control-sidebar -->
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
 <script src="dist/lang/en_US.js?v=v1"></script>
<script src="dist/lang/zh_CN.js?v=v1"></script>
<!-- jQuery 2.2.3 -->
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="plugins/jQueryUI/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->

<!-- Bootstrap 3.3.6 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts Raphael 是一个用于在网页中绘制矢量图形的 Javascript 库-->
<script src="plugins//raphael/raphael-min.js"></script>

<!-- Morris.js 是一个轻量级的 JS 库，使用 jQuery 和 Rapha&euml;l 来生成各种时序图 -->
<!-- <script src="plugins/morris/morris.js"></script> -->

<!-- Sparkline jQuery线状图插件Sparkline-->
<script src="plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap jQuery地图插件 -->
<script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart 旋钮插件jQuery knob-->
<script src="plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<!-- moment.js JavaScript 日期处理类库 -->
<script src="plugins/moment/moment.min.js"></script>

<!-- fullCalendar 2.2.5 -->
<script src="plugins/fullcalendar/fullcalendar.min.js"></script>
<!-- jQuery Date Range Picker是一款允许用户选择一个日期时间范围的jQuery日期选择器插件 -->
<script src="plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker 日期选择插件-->
<script src="plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 富文本编辑器 -->
<script src="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<!-- Slimscroll 可自定义程度很高的虚拟滚动条插件 -->
<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<!-- FastClick 是一个简单，易于使用的JS库用于消除在移动浏览器上触发click事件与一个物理Tap(敲击)之间的300延迟 -->
<script src="plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->

<!-- angularJs -->
<script src="plugins/angularjs/angular.min.js"></script>
<script src="plugins/angularjs/angular-ui-router.js"></script>
<!-- <script src="plugins/angular-file-upload/angular-file-upload.js"></script> -->
<!-- <script src="plugins/angular-file-upload/es5-shim.min.js"></script>
<script src="plugins/angular-file-upload/es5-sham.min.js"></script> -->
<script src="plugins/ng-file-upload/ng-file-upload.min.js"></script>
<script src="plugins/ng-file-upload/ng-file-upload-shim.min.js"></script>
<script src="dist/js/tm.pagination.js"></script>
<!-- <script src="plugins/angularjs/angular-route.js"></script> -->
<script src="plugins/angular-datatables/angular-datatables.js"></script>
<!-- DataTables -->
<script src="dist/js/app.js"></script>
<script src="dist/js/index.js"></script>
<script src="plugins/iCheck/icheck.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<!-- <script src="dist/js/pages/dashboard.js"></script> -->
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
<script src="plugins/datatables/jquery.dataTables.min.js"></script>
<script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
  
<script src="dist/js/versionList.js"></script>
<script src="dist/js/versionAdd.js"></script>
 <script type="text/javascript">
  var path = "<%=path%>";
  var source = en_source;
 </script>
<script>
 /*  $.widget.bridge('uibutton', $.ui.button); */
/*   var url="pages/tables/data.html";
   $.get(url,function(data){
　　　　　$("#iframe").html(data); 
　 }); */
 /* var App = angular.module('myApp', ['ngRoute','tm.pagination']); */
/*  var App = angular.module('myApp', ['ui.router','tm.pagination']); */
 
 
 /* 注入$stateProvider，$urlRouterProvider */
 /*  App.config(['$stateProvider', '$urlRouterProvider', function ( $stateProvider, $urlRouterProvider ) {
  
     // 使用when来对一些不合法的路由进行重定向 
     $urlRouterProvider.when('', '/index');
  
     // 通过$stateProvider的state()函数来进行路由定义 
     $stateProvider.state('index', {
         url: '/index',
         templateUrl: path+ '/pages/calendar.html' 
        //  controller: 'MainCtrl'
     }).state('version/list', {
         url: '/version/list',
         templateUrl: path+ '/version/list', 
         controller: 'versionsCtrl'
     })
  
     $stateProvider.state('404', {
         url: '/404',
         templateUrl: '404.html'
     })
 }]); */
 
 /* App.directive('validFile',function(){
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
}); */
 
  //3 配置路由模块，使其正常工作  
/*  App.config(['$routeProvider', function ($routeProvider) {  
	 console.log(JSON.stringify($routeProvider));
     $routeProvider.when('/index', {  
         // template: '<h1>index Pages!</h1>',  
         templateUrl: path+ '/pages/calendar.html'  
     }) 
     .when('/version/list', {  
         // template: '<h1>contact US Pages!</h1>',  
         templateUrl: path+ '/version/list',  
         controller: 'versionsCtrl' // 定义控制器  
     })
     .otherwise({templateUrl:  path+ '/pages/calendar.html'});
     // .otherwise({redirectTo:'/pages/calendar.html'}); 

 }]);  */
 
 
	// 列表控制器  
/*  App.controller('versionsCtrl', ['$scope', '$http', function ($scope, $http) {  
     // 模型数据  
     // $scope.items = ['html', 'css', 'js'];  

	  console.log("11111111111111111111111111111111111111");

 }]);  */
	
/*  App.controller('versionsCtrl', function($scope, $http) {
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
  */
	
 // console.log(JSON.stringify(App));
 
 /* listIgoal("/pages/calendar.html"); */

 
/*   function listIgoal(url){
		$.get(path+url, function(data){
		    // alert(data);
			$('#contentDiv').html(data);
		});
	} */
	

	
	
	
/* 	 apps.controller('versionsCtrl', function($scope) {
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

	});  */
	
	
</script>
</body>
</html>