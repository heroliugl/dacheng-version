
    <!-- Main content -->
    <section class="content">
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
                  <th>Rendering engine</th>
                  <th>Browser</th>
                  <th>Platform(s)</th>
                  <th>Engine version</th>
                  <th>CSS grade</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                  <td>Trident</td>
                  <td>Internet
                    Explorer 4.0
                  </td>
                  <td>Win 95+</td>
                  <td> 4</td>
                  <td>X</td>
                </tr>
                <tfoot>
                <tr>
                  <th>Rendering engine</th>
                  <th>Browser</th>
                  <th>Platform(s)</th>
                  <th>Engine version</th>
                  <th>CSS grade</th>
                </tr>
                </tfoot>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    
    <script>
  $(function () {
    $("#example1").DataTable({
    		"oLanguage":{
    			"sLengthMenu":"每页显示 _MENU_ 条记录",
    			"sZeroRecords":"抱歉， 没有找到",
    			"sInfo":"从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
    			"sInfoEmpty": "没有数据",
    			"sInfoFiltered": "(从 _MAX_ 条数据中检索)",
    			"oPaginate": {
	    			"sFirst":"首页",
	    			"sPrevious":"前一页",
	    			"sNext":"后一页",
	    			"sLast":"尾页"
    			},
                "bPaginate":true
    		}
    	});

  });
</script>