<%@include file="security.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="navbar.jsp" %>
<%-- 
brgy profile

details budget etc.
    update*
progress completion
location affected
problems tackling

improvement since implementation


current vs then diagram

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
                        Project Details
                        <small>Optional description</small>
                    </h1>
                </section>
                <section class="content">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="box box-primary">
                                <div class="box-body box-profile">

                                    <h3 class="profile-username text-center">Project Name</h3>

                                    <ul class="list-group list-group-unbordered">
                                        <li class="list-group-item">
                                            <b>Type of Project</b> <a class="pull-right">Technology</a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Expected Improvement</b> <p>
                                                i expect there to be 10% increase in productivity</p>

                                        </li>
                                        <li class="list-group-item">
                                            <b>Description</b> 
                                            <p>
                                                i expect there to be 10% increase in productivity</p>

                                        </li>
                                        <li class="list-group-item">
                                            <b>Total Farms Affected</b> <a class="pull-right">
                                                39
                                            </a>
                                        </li>

                                    </ul>

                                </div>
                                <!-- /.box-body -->
                            </div>    
                        </div>

                        <div class="col-md-9">
                            <!-- LINE CHART -->
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Info</h3>

                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                        </button>
                                        <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>
                                <div class="box-body table-responsive">

                                    <table class="table table-hover">
                                        <tbody><tr>

                                                <th>Start Date</th>
                                                <th>End Date</th>
                                                <th>Progress</th>

                                                <th>Resource</th>
                                                <th>Budget</th>

                                            </tr>
                                            <tr>

                                                <td>10/1/15</td>
                                                <td>12/2/25</td>
                                                <td> 
                                                    <div class="progress-group">

                                                        <div class="progress ">
                                                            <div class="progress-bar progress-bar-green" style="width: 67%">90%</div>
                                                        </div>
                                                    </div> <!-- closer of progress bars -->  
                                                </td>

                                                <td>15</td>
                                                <td>232000</td>

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
                                    <table class="table table-hover">
                                        <tbody><tr>

                                                <th>Problem</th>
                                                <th>Description</th>
                                            </tr>
                                            <tr>

                                                <td>Overfertilization</td>
                                                <td>Requires training farmers about the effects and good practices </td>


                                            </tr>
                                            <tr>

                                                <td>Overfertilization</td>
                                                <td>Requires training farmers about the effects and good practices </td>


                                            </tr>



                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div> 
                        <div class="col-md-5"> 
                            <div class="box box-info collapsed-box" >
                                <div class="box-header with-border">
                                    <h1 class="box-title">Rec & Proj List</h1>
                                    <div class="box-tools pull-right " >
                                        <button class="btn btn-box-tool"  data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>

                                <div class="box-body">
                                    <table id="example" class="table  display table-hover" cellspacing="0" width="100%">
                                        <thead>
                                            <tr>
                                                <th>Farm Name</th>
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
                var table = $('#example').DataTable({
                    'ajax': {
                        'url': 'viewBrgyList'
                    },
                    'columnDefs': [{
                            'targets': 0,
                            'render': function (data, type, full, meta) {
                                return '<a href="' + data + '">' + data + '</a>';
                            }
                        }]
                });

                var table1 = $('#probTable').DataTable({
                    'ajax': {
                        'url': 'viewBrgyList'
                    },
                    'columnDefs': [{
                            'targets': 0,
                            'render': function (data, type, full, meta) {
                                return '<a href="' + data + '">' + data + '</a>';
                            }
                        }]
                });
            });


        </script>
    </body>

</html>