<%@include file="security.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="navbar.jsp" %>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>SRA | Home</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css"> 
        <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker-bs3.css">
        <link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
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
                        <form id="frm-example" action="createNewProgram">
                            <div class="col-md-6">
                                <div class="box box-solid box-success">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">Program Details(STATUS-TYPE QUESTION,STEPS,)</h3>
                                    </div>
                                    <br>
                                    <div class="box-body">

                                        <div class="form-group">
                                            <label for="projectname" class="control-label">Program Name:</label>
                                            <input type="text" class="form-control" name="projectname" id="projectname" placeholder="Name...">
                                        </div>
                                        <div class="form-group">
                                            <label>Type</label>
                                            <select class="form-control">
                                                <option>Technology</option>
                                                <option>Training</option>
                                                <option>Practices</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Date range:</label>

                                            <div class="input-group">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" class="form-control reservation pull-right" name="reservation" id="reservation">
                                            </div>
                                            <!-- /.input group -->
                                        </div>
                                      


                                        <div class="form-group">
                                            <label>Description</label>
                                            <textarea class="form-control" name="Description" rows="2"  placeholder="Enter ..."></textarea>
                                        </div>


                                    </div>
                                </div>
                            </div>

                            <div class="col-md-6" > 
                                <div class="box box-info">
                                    <div class="box-header with-border">
                                        <h1 class="box-title">Problems List(change COUNTER to brgy)</h1>
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
                                                    <th>Status</th>
                                                    <th>Type</th>
                                                    <th># brgy</th>
                                                </tr>
                                            </thead>

                                        </table>
                                    </div>

                                </div>
                            </div> 


                            <div class="col-md-12" > 
                                <div class="box box-info">
                                    <div class="box-header with-border">
                                        <h1 class="box-title">Key Performance Indicators</h1>
                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        </div>
                                    </div>
                                    <div class="box-body">
                                        <table class = "table table-bordered bull" id = "listOfItems">
                                            <thead>
                                                <tr>
                                                    <th style="width: 30%">Performance Indicator</th>
                                                    <th>2016</th>
                                                    <th>2017</th>
                                                    <th>2018</th>
                                                    <th></th>

                                                </tr>
                                            </thead>
                                            <tbody>                      
                                            </tbody>
                                        </table>

                                        <br/>
                                        <button  class="btn btn-danger  pull-right" style="width: 8%"  id ="addRow"><span class = "glyphicon glyphicon-plus"></span> Row</button>

                                    </div>

                                </div>
                            </div>
                            <div class="col-md-8 pun">                   
                                <p><button class="btn btn-success btn-block pull-right " style="width: 50%; height: 6%" value="submit">Submit</button></p>
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

        <script src="plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript" src="plugins/datatable/dataTables.checkboxes.min.js"></script>
        <script src="plugins/input-mask/jquery.inputmask.js"></script>
        <script src="plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
        <script src="plugins/input-mask/jquery.inputmask.extensions.js"></script>
        <script src="plugins/daterangepicker/moment.min.js"></script>
        <script src="plugins/daterangepicker/daterangepicker.js"></script>
        <script src="plugins/datepicker/bootstrap-datepicker.js"></script>
        <script src="dist/js/app.min.js"></script>
        <script>
            $(function () {

                //Datemask dd/mm/yyyy
                $("#datemask").inputmask("yyyy-mm-dd", {"placeholder": "yyyy-mm-dd"});
                //Datemask2 mm/dd/yyyy
                $("#datemask2").inputmask("yyyy-mm-dd", {"placeholder": "yyyy-mm-dd"});
                $('.datepicker').datepicker({
                    autoclose: true
                });

                $('#reservation').daterangepicker();
                $('#datepicker').datepicker({
                    autoclose: true
                });



            });
        </script>
        <script>

            var rowNum = 1;


            $('#listOfItems').ready(function () {
                $("#listOfItems").on('click', '#deleterow', function () {
                    var $killrow = $(this).parent('tr');
                    $killrow.addClass("danger");
                    $killrow.fadeOut(1000, function () {
                        $(this).remove();
                    });
                });
            });


            $(document).ready(function () {
                $('#listOfItems tbody:last').append("<tr>\n\
                                      <td><input class='form-control' style='width: 100%' name = 'kpi" + rowNum + "' value='Hectares rehabilitated' required/></td>\n\
                                    <td><input class='form-control' name = 'y" + rowNum + "' value='700' required/></td>\n\
                                    <td><input class='form-control'  name = 'yy" + rowNum + "' value='20000' required/></td>\n\
                                    <td><input class='form-control' name = 'yyy" + rowNum + "' value='20000' /></td>\n\
                                    <td id='deleterow'><div class='glyphicon glyphicon-remove'></div></td> \n\
        </tr>");
        alert(rowNum);
                rowNum++;

                $("#addRow").on("click", function () {

                    $('#listOfItems tbody:last').append("<tr>\n\
                                  <td><input class='form-control' style='width: 100%' name = 'kpi" + rowNum + "'  required/></td>\n\
                                    <td><input class='form-control' name = 'y" + rowNum + "'  required/></td>\n\
                                    <td><input class='form-control'  name = 'yy" + rowNum + "' required/></td>\n\
                                    <td><input class='form-control' name = 'yyy" + rowNum + "'  /></td>\n\
                                    <td id='deleterow'><div class='glyphicon glyphicon-remove'></div></td> \n\
        </tr>");alert(rowNum);
                    rowNum++;

                });

            });



        </script>
        <script>

            $(document).ready(function () {
                var rows_selected = [];


                var table1 = $('#probTable').DataTable({
                    'ajax': {
                        'url': 'viewPlansProblemTable'
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


                $('#probTable-select-all').on('click', function () {
                    // Check/uncheck all checkboxes in the table
                    var rows = table1.rows({'search': 'applied'}).nodes();
                    $('input[type="checkbox"]', rows).prop('checked', this.checked);

                });


            });


        </script>



    </body>

</html>