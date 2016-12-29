    
    
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
            <form role="form">
              <div class="box-body">
              
              <div class="form-group">
                  <label for="ptype">产品类型</label>
                  <select class="form-control" style="width: 500px;" ng-model="ptype" name="ptype">
                     <option value="BM2">BM2</option>
                  </select>
              </div>
              
              <div class="form-group">
                <label for="vtype">程序类型</label><br>
                <label>
                <!--  disabled="disabled" -->
                  <input type="radio" name="vtype" ng-model="vtype" value="1" class="flat-red iradio_flat-green" disabled="disabled">Android程序&nbsp;&nbsp;
                </label>
                <label>
                  <input type="radio" name="vtype" ng-model="vtype" value="2" class="flat-red iradio_flat-green" >固件升级包
                </label>
              </div>
     
              <div class="form-group" >
                  <label for="inputFile">版本程序包</label>
                  <input type="text"  class="filename form-control" readonly="readonly" value="{{fileName}}" />
                   <!-- <a href="javascript:;" class="a-upload"> --><!-- ng-click="clearItems()" -->
                        <input type="file" nv-file-select uploader="uploader"/>浏览
				  <!--  </a> -->
				   <button type="button" class="btn btn-primary" ng-click="getFile()">getFile</button>
                </div>
                
                
               <div class="form-group" >
                  <label for="inputFile">版本程序包</label>
                  <input type="text"  class="filename form-control" readonly="readonly" ng-model="fileName" value="{{file.name}}" />
                  <!-- ngf-pattern="'image/*" accept="image/*" -->
                   <div class="btn btn-primar" ngf-select ng-model="file" name="file" ng-change="checkFile()" ngf-max-size="20MB" ngf-min-height="100">Select</div>
				   <button type="button" class="btn btn-primary" ng-click="checkFile()">checkFile</button>{{fileInfo.name}}<br/>
        {{fileInfo.size}}
                </div>
       
                <div class="form-group">
                  <label for="vname">版本名称</label>
                  <input type="text" class="form-control" ng-model="vname" style="width: 500px;" 
                         readonly="readonly" autocomplete="off" placeholder="此信息从文件中获取">
                </div>
                <div class="form-group">
                  <label for="vflag">版本标注</label>
                  <input type="text" class="form-control" ng-model="vflag" style="width: 500px;" 
                         readonly="readonly" autocomplete="off" placeholder="此信息从文件中获取">
                </div>
                <div class="form-group">
                  <label for="vm">版本号</label>
                   <input type="text" class="form-control" ng-model="vm" style="width: 500px;" 
                          readonly="readonly" autocomplete="off" placeholder="此信息从文件中获取">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1" >版本说明</label>
                    <br>(中文)<br>
	                <textarea class="textarea" placeholder="在这里输入版本说明" ng-model="cnlog" style="width: 100%; height: 150px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
	                <br>(English)<br>
	                <textarea class="textarea" placeholder="Place some text here" ng-model="enlog" style="width: 100%; height: 150px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
               </div>
               <div class="form-group">
                <label for="forceUpdate">是否强制升级</label><br>
                <label>
                  <input type="radio" name="forceUpdate" ng-model="forceUpdate" value="1" class="flat-red iradio_flat-green" >是&nbsp;&nbsp;
                </label>
                <label>
                  <input type="radio" name="forceUpdate" ng-model="forceUpdate" value="0" class="flat-red iradio_flat-green" >否
                </label>
              </div>
             <!--    <div class="checkbox">
                  <label>
                    <input type="checkbox"> Check me out
                  </label>
                </div> -->
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <button type="button" class="btn btn-primary" ng-click="UploadFile()">UploadFile</button>
                <button type="button" class="btn btn-primary" ng-click="submit()">submit</button>
              </div>
            </form>
          </div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->
</section>
<script>
/* $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
    checkboxClass: 'icheckbox_flat-green',
    radioClass: 'iradio_flat-green'
  }); */

</script>