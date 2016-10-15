<%@include file="security.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="navbar.jsp" %>
<%--
comparison page add current vs historical details(past 2yrs)
^can tell improvement or not


on barangay selection 
        farms list and their productivity
                select to go to profile
                        select comparison to run comparison




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

                                    <h3 class="profile-username text-center">Farm Details for ${farm.year}</h3>
                                    <ul class="list-group list-group-unbordered">
                                        <li class="list-group-item">
                                            <b>Field ID</b> <a class="pull-right">
                                                <c:out value="${farm.id}"/>
                                            </a>
                                        </li>

                                        <li class="list-group-item">
                                            <b>Farmer</b> <a class="pull-right">
                                                <c:out value="${farm.farmer}"/>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Barangay</b> <a class="pull-right">
                                                <c:out value="${farm.barangay}"/>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Municipality</b> <a class="pull-right">
                                                <c:out value="${farm.municipality}"/>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Total Area</b> <a class="pull-right">
                                                <c:out value="${farm.totalA}"/></a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Production(TC)</b> <a class="pull-right">
                                                <c:out value="${farm.production}"/>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Harvested Area</b> <a class="pull-right">
                                                <c:out value="${farm.totalHa}"/>
                                            </a>
                                        </li>

                                        <li class="list-group-item">
                                            <b>Current Yield(tc/ha)</b> <a class="pull-right">
                                                <c:out value="${farm.yield}"/>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Average Yield(avg(tc)/avg(ha))</b> <a class="pull-right">
                                                <c:out value="${farm.yield}"/>
                                            </a>
                                        </li>
                                    </ul>
                                    <a href="viewFarmerProfile?name=${farm.farmer}" class="btn btn-primary pull-right">
                                        View Farmer Profile
                                    </a>                              
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="box box-primary">
                                <div class="box-header">
                                    <h1 class="box-title">Crop Validation for ${farm.cropVal.year}</h1>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div id="cropVal-content-div" class="box-body box-profile">


                                    <ul class="list-group list-group-unbordered">


                                        <li class="list-group-item">
                                            <b>Crop Variety</b> <a class="pull-right">
                                                <c:out value="${farm.cropVal.variety}"/>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Crop Class</b> <a class="pull-right">
                                                <c:out value="${farm.cropVal.crop_class}"/>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Texture</b> <a class="pull-right">
                                                <c:out value="${farm.cropVal.texture}"/>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Farming System</b> <a class="pull-right">
                                                <c:out value="${farm.cropVal.farming_system}"/> </a>
                                        </li>

                                        <li class="list-group-item">
                                            <b>Topography</b> <a class="pull-right">
                                                <c:out value="${farm.cropVal.topography}"/>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Furrow Distance</b> <a class="pull-right">
                                                <c:out value="${farm.cropVal.furrow_distance}"/>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Planting Density</b> <a class="pull-right">
                                                <c:out value="${farm.cropVal.planting_density}"/>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Planting Date???</b> <a class="pull-right">
                                                <c:out value="${farm.cropVal.planting_date}"/>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Harvest Date</b> <a class="pull-right">
                                                <c:out value="${farm.cropVal.harvest_date}"/>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Date Millable</b> <a class="pull-right">
                                                <c:out value="${farm.cropVal.date_millable}"/>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Number Millable</b> <a class="pull-right">
                                                <c:out value="${farm.cropVal.num_millable}"/>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Average Millable Stool</b> <a class="pull-right">
                                                <c:out value="${farm.cropVal.avg_millable_stool}"/>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Brix</b> <a class="pull-right">
                                                <c:out value="${farm.cropVal.brix}"/>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Stalk Length</b> <a class="pull-right">
                                                <c:out value="${farm.cropVal.stalk_length}"/>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Diameter</b> <a class="pull-right">
                                                <c:out value="${farm.cropVal.diameter}"/>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Weight</b> <a class="pull-right">
                                                <c:out value="${farm.cropVal.weight}"/>
                                            </a>
                                        </li>
                                    </ul>


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
                        <div class="col-md-12">
                            <div class="col-md-4">
                                <div class="box box-primary">
                                    <div class="box-header">
                                        <h1 class="box-title">Tiller Info</h1>
                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                            <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                        </div>
                                    </div>
                                    <div class="box-body box-profile">
                                        <ul class="list-group list-group-unbordered">

                                            <li class="list-group-item">
                                                <b>Rep</b> <a class="pull-right">
                                                    <c:out value="${farm.tillers.rep}"/>
                                                </a>
                                            </li>
                                            <li class="list-group-item">
                                                <b>Count</b> <a class="pull-right">
                                                    <c:out value="${farm.tillers.count}"/>
                                                </a>
                                            </li>
                                        </ul>

                                    </div>
                                    <!-- /.box-body -->
                                </div>

                            </div>


                            <div class="col-md-4">
                                <div class="box box-primary">
                                    <div class="box-header">
                                        <h1 class="box-title">Crop Monitoring for January 2015</h1>
                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                            <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                        </div>
                                    </div>
                                    <div class="box-body box-profile">
                                        <ul class="list-group list-group-unbordered">

                                            <li class="list-group-item">
                                                <b>Phone Number</b> <a class="pull-right">0949395893</a>
                                            </li>
                                            <li class="list-group-item">
                                                <b>Gender</b> <a class="pull-right">
                                                    Male
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
                            <div class="col-md-4">
                                <div class="box box-primary">
                                    <div class="box-header">
                                        <h1 class="box-title">Soil Analysis</h1>
                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        </div>
                                    </div>
                                    <div class="box-body box-profile">
                                        <ul class="list-group list-group-unbordered">

                                            <li class="list-group-item">
                                                <b>PH Level</b> <a class="pull-right">
                                                    <c:out value="${farm.soilanalysis.ph_lvl}"/></a>
                                            </li>

                                            <li class="list-group-item">
                                                <b>Organic Matter</b> <a class="pull-right">
                                                    <c:out value="${farm.soilanalysis.organic_matter}"/>
                                                </a>
                                            </li>
                                            <li class="list-group-item">
                                                <b>Phosphorus</b> <a class="pull-right">
                                                     <c:out value="${farm.soilanalysis.phosphorus}"/>
                                                </a>
                                            </li>

                                            <li class="list-group-item">
                                                <b>Potassium</b> <a class="pull-right">
                                                 <c:out value="${farm.soilanalysis.potassium}"/>
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
                            <div class="col-md-4">
                                <div class="box box-primary ">
                                    <div class="box-body box-profile">

                                        <h3 class="profile-username text-center">Fertilizer Info for ${farm.fertilizer.year}:</h3>
                                        <ul class="list-group list-group-unbordered">


                                            <li class="list-group-item">
                                                <b>Fertilizer</b> <a class="pull-right">
                                                    <c:out value="${farm.fertilizer.fertilizer}"/>
                                                </a>
                                            </li>
                                            <li class="list-group-item">
                                                <b>First Dose</b> <a class="pull-right">
                                                    <c:out value="${farm.fertilizer.first_dose}"/>
                                                </a>
                                            </li>
                                            <li class="list-group-item">
                                                <b>Second Dose</b> <a class="pull-right">
                                                    <c:out value="${farm.fertilizer.second_dose}"/>
                                                </a>
                                            </li>

                                        </ul>
                                        <div class="btn btn-primary pull-right">
                                            More Details
                                        </div>                              
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <!--<label class="pull-left">Multiple</label> !-->
                            <div class="col-md-7">

                                <select id="select2" class="select2" multiple="multiple" data-placeholder="Select a Tag" style="width: 100%;">
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

                                <button id="sButton" class="btn btn-primary" type="submit" style="width: 100%">Search</button>
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
        <script src="plugins/select2/select2.min.js"></script>
        <script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>

        <script src="dist/js/app.min.js"></script>
        <script type="text/javascript">
            $(function () {
                $('#cropVal-content-div').slimScroll({
                    height: '420px',
                    alwaysVisible: true
                });
            });
        </script>
        <script type="text/javascript">
            $(function () {
                var data = [{id: 0, text: 'enhancement'}, {id: 1, text: 'bug'}, {id: 2, text: 'duplicate'}, {id: 3, text: 'invalid'}, {id: 4, text: 'wontfix'}];
                $("#select2").select2({
                    data: data


                });
                $("#sButton").on("click", function () {
                    var test = $("#select2").val();

                    $.ajax({
                        url: 'searchSimilarFarms?tag=' + test + '"',
                        type: 'POST',
//                    dataType: "JSON",
                        success: function (data) {

                            alert("it worked!!!!!");


                        }
                    });
                });
            });</script>

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