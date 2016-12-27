    
    
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
    display: inline;
    /* *display: inline;
    *zoom: 1 */
}
.a-upload  input{
    position: absolute;
    left: 0;
    top: 0;
    opacity: 0;
}
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
                  <label>产品名称</label>
                  <select class="form-control" style="width: 500px;">
                    <option value="Battery_Monitor">Battery_Monitor</option>
                  </select>
                </div>
              <div class="form-group">
                  <label for="exampleInputFile">File input</label>
                  <br>
                  <input class="filename" type="text" readonly="readonly" value="{{em_floormap}}" />
                   <a href="javascript:;" class="a-upload">
                          <input type="file" file-model="myFile" ngf-select="getFileInfo()" ng-model="em_floormap" name="floormap" 
                                  max-file-size="16777215" valid-file> 选择文件
					</a>
                </div>
                
                <div class="form-group">
                  <label>版本类型</label>
                  <select class="form-control" style="width: 500px;">
                    <option value="BM2">BM2</option>
                    <option value="OBD">OBD</option>
                    <option>option 3</option>
                    <option>option 4</option>
                    <option>option 5</option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail1">版本名称</label>
                  <input type="email" class="form-control" style="width: 500px;" autocomplete="off" placeholder="Enter Text">
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">版本类型</label>
                   <input type="email" class="form-control" style="width: 500px;" autocomplete="off" placeholder="Enter Text">
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">版本号</label>
                   <input type="email" class="form-control" style="width: 500px;" autocomplete="off" placeholder="Enter Text">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">版本说明</label>
	                <textarea class="textarea" placeholder="Place some text here" ng-model="textarea" style="width: 100%; height: 150px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
            </div>
                <div class="checkbox">
                  <label>
                    <input type="checkbox"> Check me out
                  </label>
                </div>
              </div>
              <!-- /.box-body -->
              

              <div class="box-footer">
                <button type="button" class="btn btn-default" ng-click="getTextArea();">获取</button>
              
                <button type="submit" class="btn btn-primary">Submit</button>
              </div>
            </form>
          </div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->
</section>