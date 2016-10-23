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
        <link rel="stylesheet" href="plugins/select2/select2.min.css">
        <!--<link rel="stylesheet" href="plugins/formWiz/custom.css">-->
        <link rel="stylesheet" href="plugins/formWiz/plugins.min.css">
        <!--<link rel="stylesheet" href="plugins/formWiz/prettify.css">-->

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
                        <div class="col-md-12">
                            <div class="box box-info">
                                <div class="box-body">
                                    <div class="form" id="rootwizard">
                                        <form class="form-horizontal" action="#" id="submit_form" method="POST" novalidate="novalidate">
                                            <div class="form-wizard">
                                                <div class="form-body">
                                                    <ul class="nav nav-pills nav-justified steps">
                                                        <li class="active">
                                                            <a href="#tab1" data-toggle="tab" class="step" aria-expanded="true">
                                                                <span class="number"> 1 </span>
                                                                <span class="desc">
                                                                    <i class="fa fa-check"></i> Account Setup </span>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <a href="#tab2" data-toggle="tab" class="step">
                                                                <span class="number"> 2 </span>
                                                                <span class="desc">
                                                                    <i class="fa fa-check"></i> Profile Setup </span>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <a href="#tab3" data-toggle="tab" class="step active">
                                                                <span class="number"> 3 </span>
                                                                <span class="desc">
                                                                    <i class="fa fa-check"></i> Billing Setup </span>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <a href="#tab4" data-toggle="tab" class="step">
                                                                <span class="number"> 4 </span>
                                                                <span class="desc">
                                                                    <i class="fa fa-check"></i> Confirm </span>
                                                            </a>
                                                        </li>
                                                    </ul>
                                                    <div id="bar" class="progress progress-striped active">
                                                 <div class="bar"></div>
                                                        </div>                     
                                                    <div class="tab-content">
                                                        <div class="tab-pane active" id="tab1">
                                                            <h3 class="block">Provide your account details</h3>
                                                            <div class="form-group has-error">
                                                                <label class="control-label col-md-3">Username
                                                                    <span class="required" aria-required="true"> * </span>
                                                                </label>
                                                                <div class="col-md-4">
                                                                    <input type="text" class="form-control" name="username" aria-required="true" aria-describedby="username-error"><span id="username-error" class="help-block help-block-error">This field is required.</span>
                                                                    <span class="help-block"> Provide your username </span>
                                                                </div>
                                                            </div>
                                                            <div class="form-group has-error">
                                                                <label class="control-label col-md-3">Password
                                                                    <span class="required" aria-required="true"> * </span>
                                                                </label>
                                                                <div class="col-md-4">
                                                                    <input type="password" class="form-control" name="password" id="submit_form_password" aria-required="true" aria-describedby="submit_form_password-error"><span id="submit_form_password-error" class="help-block help-block-error">This field is required.</span>
                                                                    <span class="help-block"> Provide your password. </span>
                                                                </div>
                                                            </div>
                                                            <div class="form-group has-error">
                                                                <label class="control-label col-md-3">Confirm Password
                                                                    <span class="required" aria-required="true"> * </span>
                                                                </label>
                                                                <div class="col-md-4">
                                                                    <input type="password" class="form-control" name="rpassword" aria-required="true" aria-describedby="rpassword-error"><span id="rpassword-error" class="help-block help-block-error">This field is required.</span>
                                                                    <span class="help-block"> Confirm your password </span>
                                                                </div>
                                                            </div>
                                                            <div class="form-group has-error">
                                                                <label class="control-label col-md-3">Email
                                                                    <span class="required" aria-required="true"> * </span>
                                                                </label>
                                                                <div class="col-md-4">
                                                                    <input type="text" class="form-control" name="email" aria-required="true" aria-describedby="email-error"><span id="email-error" class="help-block help-block-error">This field is required.</span>
                                                                    <span class="help-block"> Provide your email address </span>
                                                                </div>
                                                            </div>
                                                            <div style="float:right">
                                                                <input type='button' class='btn button-next' name='next' value='Next' />
                                                            </div>
                                                            <div style="float:left">
                                                                <input type='button' class='btn button-previous' name='previous' value='Previous' />
                                                            </div>
                                                        </div>
                                                        <div class="tab-pane" id="tab2">
                                                            <div style="float:right">
                                                                <input type='button' class='btn button-next' name='next' value='Next' />
                                                            </div>
                                                            <div style="float:left">
                                                                <input type='button' class='btn button-previous' name='previous' value='Previous' />
                                                            </div>

                                                        </div>
                                                        <div class="tab-pane" id="tab3">
                                                            <h3 class="block">Provide your billing and credit card details</h3>
                                                            <div class="form-group">
                                                                <div style="float:right">
                                                                    <input type='button' class='btn button-next' name='next' value='Next' />
                                                                </div>
                                                                <div style="float:left">
                                                                    <input type='button' class='btn button-previous' name='previous' value='Previous' />
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="tab-pane" id="tab4">
                                                            <div style="float:right">
                                                                <input type='button' class='btn button-next' name='next' value='Next' />
                                                            </div>
                                                            <div style="float:left">
                                                                <input type='button' class='btn button-previous' name='previous' value='Previous' />
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                        </form>
                                    </div>



                                </div>
                            </div>
                        </div>

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

                                        <button  class="btn btn-danger  pull-right"  type="button" id ="addcolumn"><span class = "glyphicon glyphicon-plus"></span>columnz</button>

                                    </div>
                                </div>
                            </div>

                            <div class="col-md-6" > 
                                <div class="box box-info collapsed-box">
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
                                                    <th></th>
                                                    <th>Problem</th>
                                                    <th>Description</th>
                                                    <th>Status</th>
                                                    <th>Type</th>
                                                    <th># Aff. Farms</th>
                                                    <th># Solutions</th>
                                                </tr>
                                            </thead>

                                        </table>
                                    </div>

                                </div>
                            </div> 


                            <!--                            <div class="col-md-12" > 
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
                                                        </div>-->


                            <div class="col-md-12" > 
                                <input id="kpi_year" name="kpi_year" class="form-control hidden" />
                                <input id="tYears" name="tYears" class="form-control hidden" />
                                <div class="box box-info">
                                    <div class="box-header with-border">
                                        <h1 class="box-title">Key Performance Indicators</h1>
                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        </div>
                                    </div>
                                    <div class="box-body">
                                        <table class = "table table-bordered bull" id = "listOfTargets">
                                            <thead>
                                                <tr>
                                                    <th style="width: 30%">Performance Indicator</th>



                                                </tr>
                                            </thead>
                                            <tbody>                      
                                            </tbody>
                                        </table>

                                        <br/>
                                        <button  class="btn btn-danger  pull-right" style="width: 8%"  id ="adddRow"><span class = "glyphicon glyphicon-plus"></span> Row</button>

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
        <script src="plugins/formWiz/jquery.bootstrap.wizard.js"></script>
        <script src="plugins/select2/select2.full.min.js"></script>
        <!--<script src="plugins/formWiz/prettify.js"></script>-->
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

            $(document).ready(function () {
                $('#rootwizard').bootstrapWizard({
                    onTabShow: function (tab, navigation, index) {
                        var $total = navigation.find('li').length;
                        var $current = index + 1;
                        var $percent = ($current / $total) * 100;
                        $('#rootwizard').find('.bar').css({width: $percent + '%'});
                    },
                    'nextSelector': '.button-next', 'previousSelector': '.button-previous'
                });
            });

        </script>
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
        <!--        <script>
        
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
                                            <td><input class='form-control' name = 'y" + rowNum + "[]' value='700' required/></td>\n\
                                            <td><input class='form-control'  name = 'y" + rowNum + "[]' value='20000' required/></td>\n\
                                            <td><input class='form-control' name = 'y" + rowNum + "[]' value='20000' /></td>\n\
                                            <td id='deleterow'><div class='glyphicon glyphicon-remove'></div></td> \n\
                </tr>");
        
                        rowNum++;
        
                        $("#addRow").on("click", function () {
        
                            $('#listOfItems tbody:last').append("<tr>\n\
                                          <td><input class='form-control' style='width: 100%' name = 'kpi" + rowNum + "'  required/></td>\n\
                                            <td><input class='form-control' name = 'y" + rowNum + "[]'  required/></td>\n\
                                            <td><input class='form-control'  name = 'y" + rowNum + "[]' required/></td>\n\
                                            <td><input class='form-control' name = 'y" + rowNum + "[]'  /></td>\n\
                                            <td id='deleterow'><div class='glyphicon glyphicon-remove'></div></td> \n\
                                             </tr>");
                            rowNum++;
        
                        });
        
                    });
        
        
        
                </script>-->
        <script>

            var rowNum = 1;


            $('#listOfTargets').ready(function () {
                $("#listOfTargets").on('click', '#deletedrow', function () {
                    var $killrow = $(this).parent('tr');
                    $killrow.addClass("danger");
                    $killrow.fadeOut(1000, function () {
                        $(this).remove();
                    });
                });
            });
            var ival = 0;
            var fval = 0;
            var count = 0;
            $("#addcolumn").on("click", function () {
                var x = document.getElementById('reservation').value.split('-');
                var ini = x[0].split('/');
                var end = x[1].split('/');

                ival = ini[2];
                fval = end[2];

                count += fval - ival;

                for (var b = 0; b <= count; b++) {

                    $('#listOfTargets tr:last').append("<th>" + (ival * 1 + b) + "</th>");
                }
                $('#listOfTargets tr:last').append("<th></th>");


//add counter and initial val to form
                document.getElementById("kpi_year").value = ival;
                document.getElementById("tYears").value = count;


            });
            $("#adddRow").on("click", function () {
                var rowz = "";
                for (var b = 0; b <= count; b++) {

                    rowz += "<td><input class='form-control' name = 'y" + rowNum + "[]'  required/></td>";
                }

                $('#listOfTargets tbody:last').append("<tr>\n\
                                  <td><input class='form-control' style='width: 100%' name = 'kpis" + rowNum + "'  required/></td>\n\\n\
                                        " + rowz + " \n\
                    //<td id='deletedrow'><div class='glyphicon glyphicon-remove'></div></td> \n\
        </tr>");

                rowNum++;

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
//              
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


//                $('#probTable-select-all').on('click', function () {
//                    // Check/uncheck all checkboxes in the table
//                    var rows = table1.rows({'search': 'applied'}).nodes();
//                    $('input[type="checkbox"]', rows).prop('checked', this.checked);
//
//                });


            });


        </script>



    </body>

</html>