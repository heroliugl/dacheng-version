    
    
<style>

.filename{
    width: 500px;
    height: 30px;
    line-height: 30px;
}
.a-upload {
    padding-left: 5px;
    padding-right: 5px;
    height: 30px;
    width:150px;
    text-align:center;
    line-height: 30px;
    position: relative;
    cursor: pointer;
    color: #888;
    background: #fafafa;
    border: 1px solid #2c6533;
    border-radius: 4px;
    overflow: hidden;
    display: inline-block;
    margin-top:3px;
    *display: inline;
    *zoom: 1 
}
.a-upload  input{
    position: absolute;
    width:100%;
    cursor: pointer;
    left: 0;
    top: 0;
    opacity: 0;
}

.my-drop-zone { border: dotted 3px lightgray; width: 300px;height: 180px;line-height:150px;text-align: center;text-v}
.nv-file-over { border: dotted 3px red; } /* Default class applied to drop zones on over */
.another-file-over-class { border: dotted 3px green; }


.contact_form{border:1px solid #DDDDDD;padding:10px;width:760px;margin:40px auto 0 auto;}

</style>
    
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Dashboard
        <small>Control panel</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#/index"><i class="fa fa-dashboard"></i> 控制台</a></li>
         <li><a href="#/version/list"><i class="fa fa-files-o"></i> 版本管理</a></li>
        <li class="active">版本添加</li>
      </ol>
    </section>
<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<!-- /.box -->
		  <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">版本添加</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
				<form role="form" name="versionAddForm">
					<div class="box-body">
						<div class="col-md-12">
							<div class="col-md-6">
								<div class="form-group">
									<label for="ptype">产品类型</label> 
									<select class="form-control" ng-model="ptype" name="ptype" 
									    popover popover-show="pop_ptype" data-content="{{pop_msg_ptype}}">
										<option value="">请选择产品类型</option>
										<option value="bm2">BM2</option>
									</select>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="vtype">版本类型</label><br> 
									<label>
										<input type="radio" name="vtype" ng-model="vtype" value="1"
										class="flat-red iradio_flat-green" disabled="disabled">APP版本&nbsp;&nbsp;
									</label> 
									<label> 
									    <input type="radio" name="vtype" ng-model="vtype" value="2" 
									    class="flat-red iradio_flat-green">固件版本
									</label>
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="col-md-6">
								<div class="form-group">
									<label for="inputFile">版本程序包 </label> 
									    <input type="text" class="form-control" readonly="readonly" ng-model="fileName" value="{{file.name}}" required 
									    popover popover-show="pop_fileName" data-content="{{pop_msg_fileName}}"/>
										<div class="a-upload" ngf-select ng-model="file" name="file" ng-change="checkFile()" 
										     ngf-pattern="application/*" accept="application/*" ngf-max-size="20MB"
											 ngf-min-height="100">Select</div>
											 <br><span style="color: #ffc0cb;"> 程序包格式要求： 产品名_日期_V版本号_版本标注.文件后缀 eg:  BM2_20170101_V0001_A.bin</span>
									<span ng-show="fileInfo"><br>
										文件名称：{{fileInfo.name}} &nbsp; 文件大小：{{fileInfo.size / 1024}} KB
										<input type="hidden" ng-model="_ptype">
									</span>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="vname">版本名称</label> 
									    <input type="text" class="form-control" ng-model="vname" readonly="readonly" required 
									    popover popover-show="pop_vname" data-content="{{pop_msg_vname}}"
										autocomplete="off" placeholder="此信息从文件中获取">
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="col-md-6">
								<div class="form-group">
									<label for="vflag">版本标注</label> 
									    <input type="text" class="form-control" ng-model="vflag" readonly="readonly" required
									    popover popover-show="pop_vflag" data-content="{{pop_msg_vflag}}"
										autocomplete="off" placeholder="此信息从文件中获取">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="vm">版本号</label> 
									    <input type="text" class="form-control" ng-model="vm" readonly="readonly" required
									    popover popover-show="pop_vm" data-content="{{pop_msg_vm}}"
										autocomplete="off" placeholder="此信息从文件中获取">
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="col-md-12">
								<div class="form-group">
									<label for="exampleInputPassword1">版本说明</label> <br>
									<div class=row>
										<div class="col-md-6">
											(中文)<br>
											<textarea class="textarea" placeholder="在这里输入版本说明"
												ng-model="cnlog" popover popover-show="pop_cnlog" data-content="{{pop_msg_cnlog}}"
												style="width: 100%; height: 150px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
										</div>
										<div class="col-md-6">
											(English)<br>
											<textarea class="textarea" placeholder="Place some text here"
												ng-model="enlog" popover popover-show="pop_enlog" data-content="{{pop_msg_enlog}}"
												style="width: 100%; height: 150px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="col-md-6">
								<div class="form-group">
									<label for="forceUpdate">是否强制升级</label><br> 
									<label>
										<input type="radio" name="forceUpdate" ng-model="forceUpdate"
										    value="1" class="flat-red iradio_flat-green">是&nbsp;&nbsp;
									</label> 
									<label> 
									    <input type="radio" name="forceUpdate" ng-model="forceUpdate" 
									        value="0" class="flat-red iradio_flat-green">否
									</label>
								</div>
							</div>
						</div>
					</div>
					<!-- /.box-body -->
					<div class="box-footer" align="center">
						<button type="button" class="btn btn-primary btn-lg"
							ng-click="submit()">提 交</button>
							&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-default btn-lg"
							ng-click="formReset()">重置</button>
					</div>
				</form>
			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->
</section>
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

<script>
/* $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
    checkboxClass: 'icheckbox_flat-green',
    radioClass: 'iradio_flat-green'
  }); */

</script>