<%@include file="security.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="navbar.jsp" %>
<%--
comparison page add current vs historical details(past 2yrs)
^can tell improvement or not


--%>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>SRA | Home</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css">

        <link rel="stylesheet" href="plugins/select2/select2.min.css">



    </head>
    <body class="hold-transition skin-blue sidebar-mini">

        <div class="wrapper">

            <div class="content-wrapper">
                <section class="content-header">

                    <h1>
                        Farm Observation
                        <small>Optional description</small>
                    </h1>
                </section>
                <section class="content">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="box box-primary">
                                <div class="box-body box-profile">

                                    <h3 class="profile-username text-center">Farm Details:</h3>
                                    <ul class="list-group list-group-unbordered">


                                        <li class="list-group-item">
                                            <b>Crop Variety</b> <a class="pull-right">
                                                FTYEM-21
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>PC</b> <a class="pull-right">
                                                80%
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>RC</b> <a class="pull-right">
                                                20%
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Civil Status</b> <a class="pull-right">
                                                Married</a>
                                        </li>

                                        <li class="list-group-item">
                                            <b>TC/HA</b> <a class="pull-right">
                                                2.5
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Total Farm HA</b> <a class="pull-right">
                                                13
                                            </a>
                                        </li>



                                    </ul>
                                    <div class="btn btn-primary pull-right">
                                        More Details
                                    </div>                              
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-4">
                            <div class="box box-success">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Farm Site Pic</h1>

                                </div>
                                <div class="box-body">


                                    <img src="dist/img/user2-160x160.jpg" alt="crop" width="370" height="400" >
                                </div>
                            </div>

                        </div>
                        <div class="col-md-4">
                            <div class="box box-primary">
                                <div class="box-body box-profile">

                                    <h3 class="profile-username text-center">Farmer:</h3>

                                    <p class="text-muted text-center">John Mike</p>

                                    <ul class="list-group list-group-unbordered">

                                        <li class="list-group-item">
                                            <b>Phone Number</b> <a class="pull-right">0949395893</a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Gender</b> <a class="pull-right">
                                                Male
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Education</b> <a class="pull-right">
                                                Highschool
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Civil Status</b> <a class="pull-right">
                                                Married</a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Address</b> <a class="">#3 sugarcane st. brgy regulations</a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>No of Farms</b> <a class="pull-right">5</a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>TC/HA</b> <a class="pull-right">
                                                2.3
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Total HA</b> <a class="pull-right">
                                                153
                                            </a>
                                        </li>


                                    </ul>
                                    <div class="btn btn-primary pull-right">
                                        View Profile
                                    </div>   
                                </div>
                                <!-- /.box-body -->
                            </div>

                        </div>
                        <div class="col-md-12">
                            <!--<label class="pull-left">Multiple</label> !-->
                            <div class="col-md-7">

                                <select class="select2" multiple="multiple" data-placeholder="Select a Tag" style="width: 100%;">
                                    <option>Yield</option>
                                    <option>Total Size</option>
                                    <option>Variety</option>
                                    <option>Brix</option>
                                    <option>Farming System</option>
                                    <option>Texas</option>
                                    <option>Washington</option>
                                </select>

                            </div>

                            <div class="col-sm-1">

                                <div class="btn btn-primary" style="width: 100%">Search</div>
                            </div>

                        </div>

                        <div class="col-sm-12">
                            <br>
                            <div class="box box-success">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Results: (ADD MORE ROWS?)</h1>

                                </div>
                                <div class="box-body">

                                    <table id="example" class="table  display table-hover " cellspacing="0" width="100%">
                                        <thead>
                                            <tr>
                                                <th><input name="select_all" value="1" id="example-select-all" type="checkbox" /></th>
                                                <th>Farmer</th>
                                                <th>Barangay</th>
                                                <th>Municipality</th>
                                                <th>Actual</th>
                                                <th>Difference</th>
                                                <th>More Details</th>

                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th></th>
                                                <th>Farmer</th>
                                                <th>Barangay</th>
                                                <th>Municipality</th>
                                                <th>Actual</th>
                                                <th>Difference</th>
                                                <th>More Details</th>
                                            </tr>
                                        </tfoot>
                                    </table>

                                </div>
                            </div>
                        </div>
                        <div class="col-md-2 pull-right">
                          
                               
                                <div class="box-body">
                                    <a class="btn btn-app btn-linkedin" style="width: 100%">
                                        <i class="fa fa-edit" ></i> Create Comparison
                                    </a>
                                


                                </div>
                                <!-- /.box-body -->
                   

                        </div>


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
        <script src="plugins/select2/select2.full.min.js"></script>

        <script src="dist/js/app.min.js"></script>

        <script type="text/javascript">
            $(function () {
                $(".select2").select2();
            });
        </script>

        <script src="plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>

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
                });

                $('#example-select-all').on('click', function () {
                    // Check/uncheck all checkboxes in the table
                    var rows = table.rows({'search': 'applied'}).nodes();
                    $('input[type="checkbox"]', rows).prop('checked', this.checked);

                });



            });


        </script>
    </body>

</html>