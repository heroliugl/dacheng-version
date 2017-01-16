    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Dashboard
        <small>Control panel</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#/index"><i class="fa fa-dashboard"></i> 控制台</a></li>
        <li class="active">客户管理</li>
      </ol>
    </section>

<!-- Main content -->
    <section class="content"  >
      <div class="row">
         <div class="col-md-12">
          <div class="box box-success"><!-- 
            <div class="box-header with-border">
              <h3 class="box-title">Create Event</h3>
            </div> -->
            <div class="box-body" style="margin-top: 10px;">
              <div class="form-group col-xs-12 col-sm-2 col-md-2" >
                <!--<button type="button" id="color-chooser-btn" class="btn btn-info btn-block dropdown-toggle" data-toggle="dropdown">Color <span class="caret"></span></button>-->
                 <!-- <button type="button" class="btn btn-primary " data-toggle="modal" data-target="#addfloormapModal">添加新版本</button> -->
                 <div class="btn-group" style="width: 100%; margin-bottom: 10px;">
                <!--<button type="button" id="color-chooser-btn" class="btn btn-info btn-block dropdown-toggle" data-toggle="dropdown">Color <span class="caret"></span></button>-->
                 <!-- <button type="button" class="btn btn-primary " data-toggle="modal" data-target="#addfloormapModal">添加新版本</button> -->
                 <a href="#/product/add" class="btn btn-primary col-xs-12">添加新客户</a>
                 </div>
              </div>
              <div class="form-group col-xs-12 col-sm-6 col-md-6">
                     <label for="status" class="col-xs-12 col-sm-6 col-md-3 control-label" style="margin-top: 7px;">关键字搜索</label>
                     <div class="col-xs-12 col-sm-6 col-md-9">
	                     <input class="form-control" name="email" ng-model="email" placeholder="客户名 / 客户识别码 / 联系人 / 联系电话 / 电子邮箱">
                     </div>
              </div>
              <div class="form-group col-xs-12 col-sm-4 col-md-4">
                     <label for="status" class="col-xs-12 col-sm-6 col-md-3 control-label" style="margin-top: 7px;">状态</label>
                     <div class="col-xs-12 col-sm-6 col-md-9">
	                      <select ng-change="doQuery()" ng-init="status=''" ng-model="status" class="form-control" name="status">
	                             <option value="" selected="selected">ALL</option>
								   <option value="1">Enabled</option>
								   <option value="0" >Disabled</option>
							</select>
                     </div>
                 </div>
              <!-- /btn-group -->
            </div>
          </div>
          <!-- /. box -->
        </div>
        <div class="col-xs-12">
          <!-- /.box -->

          <div class="box">
          <!--   <div class="box-header">
              <h3 class="box-title">Data Table With Full Features</h3>
            </div> -->
            <!-- /.box-header -->
            <div class="box-body table-responsive">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>序号</th>
                  <th>客户名</th>
                  <th>客户识别码</th>
                  <th>联系人</th>
                  <th>联系电话</th>
                  <th>电子邮箱</th>
                  <th>状态</th>
                  <th>创建时间</th>
                  <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="n in agencys track by $index" ng-cloak>
					<td>{{$index+1}}</td>
					<td>{{n.agencyName}}</td>
					<td>{{n.agencyCode}}</td>
					<td>{{n.contacts}}</td>
					<td>{{n.telePhone != null?n.telePhone:n.mobilePhone}}</td>
					<td>{{n.email}}</td>
					<td>{{n.status == '1' ?'生效':'已失效'}}</td>
					<td>{{n.createTime | date:'yyyy-MM-dd HH:mm:ss'}}</td>
					<td>
					    <a href="javascript:void(0);" ng-click="showEdit(n.agencyId,n)"><i class="fa fa-edit"></i> 编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;
					    <a href="javascript:void(0);" ng-click="showDel(n.agencyId,n)"><i class="fa fa-trash"></i> 删除</a>
					</td>
				</tr>
                <tfoot>
	                 <tr>
		                  <th>序号</th>
		                  <th>客户名</th>
		                  <th>客户识别码</th>
		                  <th>联系人</th>
		                  <th>联系电话</th>
		                  <th>电子邮箱</th>
		                  <th>状态</th>
		                  <th>创建时间</th>
		                  <th>操作</th>
	                </tr>
                </tfoot>
              </table>
            </div>
           <tm-pagination conf="paginationConf"></tm-pagination>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- Modal Start -->
       
    <!-- test -->
	<div class="modal" id="passModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	    <div class="modal-dialog" role="document">
	        <div class="modal-content">
	            <div class="modal-header is-redheader">
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	                <h4 class="modal-title" id="myModalLabel">版本测试通过确认</h4>
	            </div>
	            <div class="modal-body">
	                <input type="hidden" ng-model="test_version_id">
	                <p class="delete-address">请再次确认该版本{{testVersion.vname}}已经通过测试 ?!</p>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-comm btn-default btn-md" data-dismiss="modal">取消</button>
	                <button type="button" class="btn btn-comm btn-success btn-md" ng-click="doPass()">确认</button>
	            </div>
	        </div>
	    </div>
	</div>
	<!-- delete -->
	<div class="modal" id="issueModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	    <div class="modal-dialog" role="document">
	        <div class="modal-content">
	            <div class="modal-header is-redheader">
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	                <h4 class="modal-title" id="myModalLabel">版本发布确认</h4>
	            </div>
	            <div class="modal-body">
	                <input type="hidden" ng-model="issue_version_id">
	                <p class="delete-address">请再次确认是否发布版本{{issueVersion.vname}} ?!</p>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-comm btn-default btn-md" data-dismiss="modal">取消</button>
	                <button type="button" class="btn btn-comm btn-success btn-md" ng-click="doIssue()">确认</button>
	            </div>
	        </div>
	    </div>
	</div>
	<!-- delete -->
	<div class="modal" id="delModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	    <div class="modal-dialog" role="document">
	        <div class="modal-content">
	            <div class="modal-header is-redheader">
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	                <h4 class="modal-title" id="myModalLabel">版本删除确认</h4>
	            </div>
	            <div class="modal-body">
	                <input type="hidden" ng-model="del_version_id">
	                <p class="delete-address">请再次确认是否删除该版本 {{delVersion.vname}}?!</p>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-comm btn-default btn-md" data-dismiss="modal">取消</button>
	                <button type="button" class="btn btn-comm btn-success btn-md" ng-click="doDel()">确认</button>
	            </div>
	        </div>
	    </div>
	</div>
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
	                <button type="button" class="btn btn-comm btn-default btn-md" data-dismiss="modal">{{source.close}}</button>
	            </div>
	        </div>
	    </div>
	</div>

   