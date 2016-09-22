<%@include file="security.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="navbar.jsp" %>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>SRA | Home</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css"> 
    </head>
    <body class="hold-transition skin-blue sidebar-mini">

        <div class="wrapper">

            <div class="content-wrapper">
                <section class="content-header">

                    <h1>
                      Create Plan & Program
                        <small>Optional description</small>
                    </h1>
                </section>
                <section class="content">
                    <div class="row">
                        <form id="frm-example" action="CreateNewProject">
                            <div class="col-md-6">
                                <div class="box box-solid box-success">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">Project Details</h3>
                                    </div>
                                    <br>
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label for="projectname" class="control-label">Project Name:</label>
                                            <input type="text" class="form-control" name="projectname" id="projectname" placeholder="Name...">
                                        </div>
                                        <div  class="form-group">
                                            <label class="control-label" for="datepicker" >Date Start:</label>
                                            <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" class="form-control pull-right datepicker" name="datepicker" id="datepickerstart">
                                            </div>
                                            <!-- /.input group -->
                                        </div>
                                        <div  class="form-group">
                                            <label class="control-label" for="dateend" >Date End:</label>
                                            <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" class="form-control pull-right datepicker" name="dateend" id="datepickerend">
                                            </div>
                                            <!-- /.input group -->
                                        </div>
                                        <div class="form-group">
                                            <label for="projectname" class="control-label">Required Budget</label>
                                            <input type="number" class="form-control" id="budget" placeholder="P430000">
                                        </div>
                                        <div class="form-group">
                                            <label for="projectname" class="control-label">Resource Allocation</label>
                                            <input type="number" class="form-control" id="pplall" placeholder="9">
                                        </div>
                                        <div class="form-group">
                                            <label for="projectname" class="control-label">Expected Improvement</label>
                                            <input type="number" class="form-control" id="possyield" placeholder="to see in future if it is how much they expected to improve">
                                        </div>
                                        <div class="form-group">
                                            <label>Description</label>
                                            <textarea class="form-control" name="Description" rows="2"  placeholder="Enter ..."></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Type</label>
                                            <select class="form-control">
                                                <option>Technology</option>
                                                <option>Training</option>
                                                <option>Practices</option>
                                            </select>
                                        </div>

                                    </div>
                                </div>
                            </div>

                            <div class="col-md-6" > 
                                <div class="box box-info">
                                    <div class="box-header with-border">
                                        <h1 class="box-title">Problems List</h1>
                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                            <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                        </div>
                                    </div>

                                    <div class="box-body">
                                        <table id="probTable" class="table  dispTable table-hover" cellspacing="0" width="100%">
                                            <thead>
                                                <tr>
                                                    <th><input name="select_all" value="1" id="probTable-select-all" type="checkbox" /></th>
                                                    <th>Problem</th>
                                                    <th>Description</th>
                                                </tr>
                                            </thead>
                                            <tfoot>
                                                <tr>
                                                    <th></th>
                                                    <th>Problem</th>
                                                    <th>Description</th>

                                                </tr>
                                            </tfoot>
                                        </table>
                                    </div>

                                </div>
                            </div> 
                            <div class="col-md-6" > 
                                <div class="box box-info">
                                    <div class="box-header with-border">
                                        <h1 class="box-title">Brgy List</h1>
                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                            <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                        </div>
                                    </div>

                                    <div class="box-body">
                                        <table id="example" class="table  display table-hover" cellspacing="0" width="100%">
                                            <thead>
                                                <tr>
                                                    <th><input name="select_all" value="1" id="example-select-all" type="checkbox" /></th>
                                                    <th>Farm Name</th>
                                                    <th>Owner</th>
                                                    <th>Barangay</th>

                                                </tr>
                                            </thead>
                                            <tfoot>
                                                <tr>
                                                    <th></th>
                                                    <th>Farm Name</th>
                                                    <th>Owner</th>
                                                    <th>Barangay</th>

                                                </tr>
                                            </tfoot>
                                        </table>
                                    </div>

                                </div>

                            </div>
                            <div class="col-md-5">                   
                                <p><button class="btn btn-success" value="submit">Submit</button></p>
                            </div>
                        </form>
                    </div>
                </section>

            </div>

            <footer class="main-footer">

                <div class="pull-right hidden-xs">
                    <b>Version</b> 2.3.3
                </div>
                <strong>Copyright &copy; 2014-2015 <a href="http://sra.com">Sugar Regulatory Association</a>.</strong>
            </footer>
        </div>


        <script type="text/javascript" src="plugins/jQuery/jQuery-2.2.0.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="dist/js/app.min.js"></script>
        <script src="Highcharts/highcharts.js"></script>
        <script src="plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript" src="plugins/datatable/dataTables.checkboxes.min.js"></script>
        <script src="plugins/datepicker/bootstrap-datepicker.js"></script>
        <script>
            $(function () {
                $('.datepicker').datepicker({
                    autoclose: true
                });


            });
        </script>
        <script>

            $(document).ready(function () {
                var rows_selected = [];

                var table = $('#example').DataTable({
                    'ajax': {
                        'url': 'viewBrgyList'
                    },
                    'columnDefs': [{
                            'targets': 0,
                            'searchable': false,
                            'orderable': false,
                            'className': 'dt-body-center',
                            'render': function (data, type, full, meta) {
                                return '<input type="checkbox" name="id[]" id="buttonClick" value="'
                                        + $('<div/>').text(data).html() + '">';
                            }
                        }],
                    'select': {
                        'style': 'multi'
                    },
                    'order': [[1, 'asc']]
                            //      ,
                            //       'rowCallback': function(row, data, dataIndex){
                            //         // Get row ID
                            //       var rowId = data[0];
                            //       // alert(rowId);
                            //         // If row ID is in the list of selected row IDs
                            //         if($.inArray(rowId, rows_selected) !== -1){
                            //            $(row).find('input[type="checkbox"]').prop('checked', true);
                            //            $(row).addClass('selected');
                            //         }
                            //      }     

                });
                var table1 = $('#probTable').DataTable({
                    'ajax': {
                        'url': 'viewProblemList'
                    },
                    'columnDefs': [{
                            'targets': 0,
                            'searchable': false,
                            'orderable': false,
                            'className': 'dt-body-center',
                            'render': function (data, type, full, meta) {
                                return '<input type="checkbox" name="probid[]"  value="'
                                        + $('<div/>').text(data).html() + '">';
                            }
                        }],
                    'select': {
                        'style': 'multi'
                    },
                    'order': [[1, 'asc']]

                });
                $('#frm-example').on('submit', function (e) {
                    var form = this;

                    // Iterate over all checkboxes in the table
                    table.$('input[type="checkbox"]').each(function () {
                        // If checkbox doesn't exist in DOM
                        if (!$.contains(document, this)) {
                            // If checkbox is checked
                            if (this.checked) {
                                // Create a hidden element 
                                $(form).append(
                                        $('<input>')
                                        .attr('type', 'hidden')
                                        .attr('name', this.name)
                                        .val(this.value)
                                        );
                            }
                        }
                    });
                    table1.$('input[type="checkbox"]').each(function () {
                        // If checkbox doesn't exist in DOM
                        if (!$.contains(document, this)) {
                            // If checkbox is checked
                            if (this.checked) {
                                // Create a hidden element 
                                $(form).append(
                                        $('<input>')
                                        .attr('type', 'hidden')
                                        .attr('name', this.name)
                                        .val(this.value)
                                        );
                            }
                        }
                    });

                });

                $('#example-select-all').on('click', function () {
                    // Check/uncheck all checkboxes in the table
                    var rows = table.rows({'search': 'applied'}).nodes();
                    $('input[type="checkbox"]', rows).prop('checked', this.checked);

                });
                $('#probTable-select-all').on('click', function () {
                    // Check/uncheck all checkboxes in the table
                    var rows = table1.rows({'search': 'applied'}).nodes();
                    $('input[type="checkbox"]', rows).prop('checked', this.checked);

                });


            });


        </script>
    </body>

</html>