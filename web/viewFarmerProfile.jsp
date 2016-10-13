<%@include file="security.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="navbar.jsp" %>
<%--


--%>
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
                        Farmer Profile
                        <small>Optional description</small>
                    </h1>
                </section>
                <section class="content">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="box box-primary">
                                <div class="box-body box-profile">

                                    <h3 class="profile-username text-center"><c:out value="${farmDet.name}"/> </h3>

                                    <!-- <p class="text-muted text-center">Jose</p> -->

                                    <ul class="list-group list-group-unbordered">

                                        <li class="list-group-item">
                                            <b>Phone Number</b> <a class="pull-right"><c:out value="${farmDet.phone}"/> </a>
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
                                            <b>Current Production</b> <a class="pull-right">5</a>
                                        </li>
                                         <li class="list-group-item">
                                            <b>Total Harvest </b> <a class="pull-right">5</a>
                                        </li>
                                         <li class="list-group-item">
                                            <b>Current Production</b> <a class="pull-right">5</a>
                                        </li>
                                         <li class="list-group-item">
                                            <b>Current TC/HA</b> <a class="pull-right">
                                                2.3
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>AVG TC/HA</b> <a class="pull-right">
                                                2.3
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Total HA</b> <a class="pull-right">
                                                153
                                            </a>
                                        </li>
                                    </ul>

                                </div>
                                <!-- /.box-body -->
                            </div>    
                        </div>
                        <div class="col-sm-4">
                            <div class="box box-success">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Farm Site Pic</h1>

                                </div>
                                <div class="box-body">


                                    <img src="dist/img/user2-160x160.jpg" alt="crop" width="370" height="400">



                                </div>
                            </div>

                        </div>
                        
                        <div class="col-md-10">
                            <!-- LINE CHART -->
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h3 class="box-title">#Farms Details</h3>

                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                        </button>
                                        <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>
                                <div class="box-body table-responsive">

                                    <table class="table table-hover">
                                        <tbody><tr>
                                                <th>Farmer Name</th>
                                                <th>Yield</th>
                                                <th>Farm Size</th>
                                                <th>% completed</th>
                                                <th>Cane Variety</th>
                                                <th>%PC</th>
                                                <th>%RC</th>
                                                <th>detailsbtn</th>
                                            </tr>
                                            <tr>
                                                <td>John Doe</td>
                                                <td>1.23</td>
                                                <td>35%</td>
                                                <td> 
                                                    <span class="badge bg-light-blue block">30%</span><!-- closer of progress bars -->  
                                                </td>
                                                <td>tpeh31</td>
                                                <td>3%</td>
                                                <td>77%</td>
                                                <td>detailsbtn</td>
                                            </tr>

                                            <tr>
                                                <td href="">henry ford</td>
                                                <td>1.23</td>
                                                <td>80%</td>
                                                <td>
                                                    <div class="progress-group">


                                                        <span class="progress-number"><b>6 %</b></span>  <div class="progress progress-sm progress-striped active">
                                                            <div class="progress-bar progress-bar-primary" style="width: 30%"></div>
                                                        </div>
                                                    </div> <!-- closer of progress bars -->  
                                                </td>
                                                <td>TPEH43</td>
                                                <td>3%</td>
                                                <td>77%</td>
                                                <td>detailsbtn</td>
                                            </tr>
                                            <tr>

                                                <td href="">Michael Johnathan</td>
                                                <td>1.23</td>
                                                <td>80%</td>
                                                <td><div class="progress-group">
                                                        <span class="progress-number"><b>40 %</b></span>

                                                        <div class="progress sm">
                                                            <div class="progress-bar progress-bar-warning" style="width: 40%"></div>
                                                        </div>
                                                    </div> <!-- closer of progress bars -->  </td>
                                                <td>TPEH43</td>
                                                <td>3%</td>
                                                <td>77%</td>
                                                <td>detailsbtn</td>
                                            </tr>
                                            <tr>
                                                <td href="">Danny Frisk</td>
                                                <td>1.23</td>
                                                <td>80%</td>
                                                <td>
                                                    <div class="progress-group">
                                                        <span class="progress-number"><b>80 %</b></span>

                                                        <div class="progress sm">
                                                            <div class="progress-bar progress-bar-green" style="width: 80%"></div>
                                                        </div>
                                                    </div> <!-- closer of progress bars -->  
                                                </td>
                                                <td>TPEH43</td>
                                                <td>3%</td>
                                                <td>77%</td>
                                                <td>detailsbtn</td>
                                            </tr>
                                        </tbody>
                                    </table>


                                </div>
                                <!-- /.box-body -->
                            </div>
                        </div>
                        <div class="col-md-6" > 
                            <div class="box box-info collapsed-box">
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
                                                 <th></th>
                                            </tr>
                                        </thead>
                                        
                                    </table>
                                </div>

                            </div>
                        </div> 
                        <div class="col-md-6"> 
                            <div class="box box-info collapsed-box" >
                                <div class="box-header with-border">
                                    <h1 class="box-title">Rec & Proj List(add list of programs)</h1>
                                    <div class="box-tools pull-right " >
                                        <button class="btn btn-box-tool"  data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>

                                <div class="box-body">
                                    <table id="recTable" class="table  display table-hover" cellspacing="0" width="100%">
                                        <thead>
                                            <tr>
                                                <th>Rec/Program</th>
                                                <th>Description</th>
                                                <th></th>

                                            </tr>
                                        </thead>
                                       
                                    </table>
                                </div>

                            </div>

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
        <script src="dist/js/app.min.js"></script>

        <script src="plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>

        <script>

            $(document).ready(function () {
                var table = $('#recTable').DataTable({
                    'ajax': {
                        'url': 'viewFarmerRecT?name=${farm}'
                    },
                    'columnDefs': [{
                            'targets': 2,
                            'render': function (data, type, full, meta) {
                                return '<a href="' + data + '">details</a>';
                            }
                        }]
                });

                var table1 = $('#probTable').DataTable({
                    'ajax': {
                        'url': 'viewFarmerProbT?name=${farm}'
                    },
                    'columnDefs': [{
                            'targets': 2,
                            'render': function (data, type, full, meta) {
                                return '<a href="' + data + '">details</a>';
                            }
                        }]
                });
            });


        </script>
    </body>

</html>