

<!-- Main content -->
    <section class="content"  >
      <div class="row">
        <div class="col-xs-12">
          <!-- /.box -->

          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Data Table With Full Features</h3>
            </div>
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

   