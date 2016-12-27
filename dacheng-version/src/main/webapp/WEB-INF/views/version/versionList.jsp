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
            <div class="box-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>序号</th>
                  <th>版本名</th>
                  <th>版本号</th>
                  <th>文件名</th>
                  <th>版本标注</th>
                  <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="v in versions track by $index" ng-cloak>
					<td>{{$index+1}}</td>
					<td>{{v.vname}}</td>
					<td>{{v.vm}}</td>
					<td >{{v.url}}
						<!-- <a ng-style="{true: {'color':'#fff'}, false: {}}[(d.device_fail_num > 0 || d.lamp_fail_num > 0)]" href="javascript:void(0);" ng-if="deviceManager_show" ng-click="doMaintence(d.id,'list')"><i class="fa fa-wrench"></i> {{source.maintenance}}</a>&nbsp;&nbsp;
					    <a ng-style="{true: {'color':'#fff'}, false: {}}[(d.device_fail_num > 0 || d.lamp_fail_num > 0)]" class="hidden-xs" href="javascript:void(0);" ng-if="addressManager_edit_address" ng-click="doEdit(d.id,d.num_of_floor,d.address)"><i class="fa fa-edit"></i> {{source.edit}}</a>&nbsp;&nbsp;  
					    <a ng-style="{true: {'color':'#fff'}, false: {}}[(d.device_fail_num > 0 || d.lamp_fail_num > 0)]" class="hidden-xs" href="javascript:void(0);" ng-if="addressManager_delete_address" ng-click="doConfirmDel(d.id)"><i class="fa fa-trash"></i> {{source.delete}}</a> -->
					</td>
					<td>{{v.vflag}}</td>
					<td>---</td>
				</tr>
                <tfoot>
                <tr>
                  <th>序号</th>
                  <th>版本名</th>
                  <th>版本号</th>
                  <th>文件名</th>
                  <th>版本标注</th>
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
    
    <!-- add floor map -->
    <div class="modal" id="addfloormapModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <form name="amform" class="form-horizontal" role="form">
    	        <div class="modal-dialog" role="document">
    	            <div class="modal-content">
    	                <div class="modal-header is-redheader">
    	                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    	                    <h4 class="modal-title" id="myModalLabel">{{source.add_floor_map}}</h4>
    	                </div>
    	                <div class="modal-body">
                            <div class="form-group">
                                <label for="monitorFloor" class="col-sm-4 control-label">{{source.monitor_floor}}</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" ng-model="fm_floor" name="monitorFloor"  ng-maxlength=8 required>
    		                        <p class="alert alert-danger" ng-show="amform.monitorFloor.$dirty && !amform.monitorFloor.$valid">monitor floor is required,and length should be less than 8</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="uploadImg" class="col-sm-4 control-label">{{source.upload_floor_image}}</label>
                                <div class="col-sm-8">
	                                <a href="javascript:;" class="a-upload">
									    <input type="file" file-model="myFile" ng-model="fm_floormap" accept="image/jpeg" name="floormap" class="form-control"  
									        max-file-size="16777215" required valid-file>{{source.upload_image}}
									</a>
                                    <p class="alert alert-danger" ng-show="amform.floormap.$dirty && !amform.floormap.$valid">floor map image is required</p>
                                    <p class="alert alert-danger" ng-show="amform.floormap.$dirty && amform.floormap.$error.maxFileSize">file size must less than 16M</p>
                                </div>
                            </div>
                             {{fm_floormap}}
                             
    	                </div>
    	                
    	                <div class="modal-footer">
    	                    <button type="button" class="btn btn-comm btn-default btn-md" data-dismiss="modal">{{source.cancel}}</button>
    	                    <button type="button" class="btn btn-comm btn-success btn-md" ng-click="doAddCheckFloorMap()" ng-disabled="amform.$invalid">{{source.save}}</button>
    	                </div>
    	            </div>
    	        </div>
    	     </form>
        </div>
    
    
    
        <!-- Modal Start -->
    <div class="modal" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
<!-- 	    <form name="aform" class="form-horizontal" role="form">
	        <div class="modal-dialog" role="document">
	            <div class="modal-content">
	                <div class="modal-header is-redheader">
	                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	                    <h4 class="modal-title" id="myModalLabel">{{source.add_device}}</h4>
	                </div>
	                <div class="modal-body">
	                    <div class="form-group">
	                        <label for="mac" class="col-sm-4 control-label">{{source.mac}}</label>
	                        <div class="col-sm-8">
	                            <input type="text" class="form-control" ng-model="add_mac" name="mac"  ng-model-options="{allowInvalid: true,updateOn: 'default'}" required ng-pattern=/^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$/>
		                        <p class="alert alert-danger" ng-show="aform.mac.$dirty && !aform.mac.$valid">mac is required,and valid mac address egs:3D:F2:C9:A6:B3:4F</p>
	                        </div>
	                    </div>
	                     <div class="form-group">
                            <label for="add_device_name" class="col-sm-4 control-label">{{source.device_name}}</label>
                            <div class="col-sm-8">
                                 <input type="text" class="form-control" ng-model="add_device_name" name="add_device_name" required>
		                        <p class="alert alert-danger" ng-show="cform.add_device_name.$dirty && !cform.add_device_name.$valid">device name is required</p>
                            </div>
                        </div>
	                    <div class="form-group">
	                        <label for="monitorFloor" class="col-sm-4 control-label">{{source.monitor_floor}}</label>
	                        <div class="col-sm-8">
	                            <select class="form-control" id="monitorFloor">
	                                <option ng-repeat="foor in foors" value="{{ foor }}">{{foor}}</option>
	                            </select>
	                            <input type="text" class="form-control" ng-model="add_floor" name="monitorFloor"  ng-maxlength=8 required>
		                        <p class="alert alert-danger" ng-show="aform.monitorFloor.$dirty && !aform.monitorFloor.$valid">monitor floor is required,and length should be less than 8</p>
	                        </div>
	                    </div>
	                </div>
	                <div class="modal-footer">
	                    <button type="button" class="btn btn-comm btn-default btn-md" data-dismiss="modal">{{source.cancel}}</button>
	                    <button type="button" class="btn btn-comm btn-success btn-md" ng-disabled='!aform.$dirty || !aform.$valid' ng-click="doAdd()">{{source.save}}</button>
	                </div>
	            </div>
	        </div>
	    </form> -->
	  <!--   <div class="modal modal-primary"> -->
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Primary Modal</h4>
              </div>
              <div class="modal-body">
                <p>One fine body&hellip;</p>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-default">Save changes</button>
              </div>
            </div>
            <!-- /.modal-content -->
          </div>
          <!-- /.modal-dialog -->
        <!-- </div> -->
    </div>

   