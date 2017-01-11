    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Dashboard
        <small>Control panel</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#/index"><i class="fa fa-dashboard"></i> 控制台</a></li>
        <li class="active">版本管理</li>
      </ol>
    </section>

<!-- Main content -->
    <section class="content"  >
      <div class="row">
         <div class="col-md-12">
          
          <!-- /. box -->
          <div class="box box-success"><!-- 
            <div class="box-header with-border">
              <h3 class="box-title">Create Event</h3>
            </div> -->
            <div class="box-body">
              <div class="btn-group" style="width: 100%; margin-bottom: 10px;">
                <!--<button type="button" id="color-chooser-btn" class="btn btn-info btn-block dropdown-toggle" data-toggle="dropdown">Color <span class="caret"></span></button>-->
                 <!-- <button type="button" class="btn btn-primary " data-toggle="modal" data-target="#addfloormapModal">添加新版本</button> -->
                 <a href="#/version/add" class="btn btn-primary ">添加新版本</a>
              </div>
              <!-- /btn-group -->
            </div>
          </div>
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
                  <th>产品</th>
                  <th>版本类型</th>
                  <th>版本名</th>
                  <th>版本号</th>
                  <!-- <th>文件名</th> -->
                  <th>版本标注</th>
                  <th>版本状态</th>
                  <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="v in versions track by $index" ng-cloak>
					<td>{{$index+1}}</td>
					<td>{{v.ptype}}</td>
					<td>{{v.vtype == '1' ?'APP版本':'固件版本'}}</td>
					<td>{{v.vname}}</td>
					<td>{{v.vm}}</td>
					<!-- <td >{{v.url}} -->
						<!-- <a ng-style="{true: {'color':'#fff'}, false: {}}[(d.device_fail_num > 0 || d.lamp_fail_num > 0)]" href="javascript:void(0);" ng-if="deviceManager_show" ng-click="doMaintence(d.id,'list')"><i class="fa fa-wrench"></i> {{source.maintenance}}</a>&nbsp;&nbsp;
					    <a ng-style="{true: {'color':'#fff'}, false: {}}[(d.device_fail_num > 0 || d.lamp_fail_num > 0)]" class="hidden-xs" href="javascript:void(0);" ng-if="addressManager_edit_address" ng-click="doEdit(d.id,d.num_of_floor,d.address)"><i class="fa fa-edit"></i> {{source.edit}}</a>&nbsp;&nbsp;  
					    <a ng-style="{true: {'color':'#fff'}, false: {}}[(d.device_fail_num > 0 || d.lamp_fail_num > 0)]" class="hidden-xs" href="javascript:void(0);" ng-if="addressManager_delete_address" ng-click="doConfirmDel(d.id)"><i class="fa fa-trash"></i> {{source.delete}}</a> -->
					</td>
					<td>{{v.vflag}}</td>
					<td>{{v.status == '1' ?'已发布':(v.testStatus == '1'? '测试通过但未发布':'尚未测试或未通过')}}</td>
					<td>
					    <a href="javascript:void(0);" ng-if="v.status == 0 && v.testStatus == 0" ng-click="showPass(v.id,v)"><i class="fa fa-thumbs-o-up"></i> 通过测试</a>
					    <a href="javascript:void(0);" ng-if="v.status == 0 && v.testStatus == 1" ng-click="showIssue(v.id,v)"><i class="fa fa-bullhorn"></i> 发布</a>
					    <a href="javascript:void(0);" ng-click="showDel(v.id,v)"><i class="fa fa-trash"></i> 删除</a>
					</td>
					
				</tr>
				<!-- <tr><table style="padding-left:50px;background-color: #000;color:#fff;width: 100%">
					   <tr><td>12312321</td><td>12312321</td><td>12312321</td><td>12312321</td><td>12312321</td><td>12312321</td></tr>
					   <tr><td>12312321</td><td>12312321</td><td>12312321</td><td>12312321</td><td>12312321</td><td>12312321</td></tr>
					   <tr><td>12312321</td><td>12312321</td><td>12312321</td><td>12312321</td><td>12312321</td><td>12312321</td></tr>
					</table></tr> -->
               <tfoot>
                <tr>
                  <th>序号</th>
                  <th>产品</th>
                  <th>版本类型</th>
                  <th>版本名</th>
                  <th>版本号</th>
                 <!--  <th>文件名</th> -->
                  <th>版本标注</th>
                  <th>版本状态</th>
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

   