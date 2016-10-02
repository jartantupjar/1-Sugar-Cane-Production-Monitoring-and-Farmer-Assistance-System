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
                        Farmer Comparison
                        <small>Optional description</small>
                    </h1>
                </section>
                <section class="content">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="col-md-4">
                                <h3 class="text-center text-green">High</h3>
                            </div>
                            <div class="col-md-4">
                                <h3 class="text-center text-blue">Current</h3>
                            </div>
                            <div class="col-md-4">
                                <h3 class="text-center text-red">Low</h3>
                            </div>
                        </div>


                        <div class="col-md-4">
                            <div class="box box-success">
                                <div class="box-header">
                                    <input type="checkbox" style="width: 16; height: 16" class="pull-left">
                                    <h4 class="text-center"><b>Farm B</b></h4>

                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                        </button>
                                    </div>

                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <ul class="nav nav-tabs">
                                        <li>  </li>
                                        <li class="active"><a href="#tab_7" data-toggle="tab"><b>Details</b></a></li>
                                        <li><a href="#tab_8" data-toggle="tab"><b>Recommendations</b></a></li>
                                        <li><a href="#tab_9" data-toggle="tab"><b>Problems </b></a></li>

                                    </ul>

                                    <div class="tab-content">
                                        <div class="tab-pane active" id="tab_7">
                                            <div class="box-body box-profile">
                                                <ul class="list-group list-group-unbordered">

                                                    <li class="list-group-item">
                                                        <b>Total Area</b> <b class="pull-right text-green">
                                                            2.3
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Crop Variety</b> <b class="pull-right text-green">
                                                            FTYEM-21
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>PC</b> <b class="pull-right text-green">
                                                            80%
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>RC</b> <b class="pull-right text-green">
                                                            20%
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Brix</b> <b class="pull-right text-red">
                                                            18</b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Stalk Length</b> <b class="pull-right text-red">
                                                            12</b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Date Planted</b> <b class="pull-right text-green">
                                                            04/24/13
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>PH</b> <b class="pull-right text-red">
                                                            5.4
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Farming System</b> <b class="pull-right text-green">
                                                            Fully Mechanized
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Number of Tillers</b> <b class="pull-right text-red">
                                                            3
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>TC/HA</b> <b class="pull-right text-red">
                                                            2.8
                                                        </b>
                                                    </li>
                                                </ul>
                                                <div class="btn btn-primary pull-right">
                                                    More Details
                                                </div>
                                            </div>
                                        </div>
                                        <!-- /.tab-pane -->
                                        <div class="tab-pane" id="tab_8">
                                            <h3 class="profile-username text-center"></h3>
                                            <table class="table table-hover">
                                                <tbody><tr>
                                                        <th>Recommendation</th>

                                                        <th>more info</th>
                                                    </tr>
                                                    <tr>
                                                        <td>John Doe</td>

                                                        <td>detailsbtn</td>
                                                    </tr>

                                                    <tr>

                                                        <td>1.23</td>


                                                        <td>detailsbtn</td>
                                                    </tr>
                                                    <tr>
                                                        <td>John Doe</td>

                                                        <td>detailsbtn</td>
                                                    </tr>

                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.tab-pane -->
                                        <div class="tab-pane" id="tab_9">
                                            <table class="table table-hover">
                                                <tbody><tr>
                                                        <th>Problem</th>
                                                        <th>More Info</th>
                                                    </tr>
                                                    <tr>
                                                        <td>John Doe</td>

                                                        <td>detailsbtn</td>
                                                    </tr>

                                                    <tr>

                                                        <td>1.23</td>


                                                        <td>detailsbtn</td>
                                                    </tr>
                                                    <tr>
                                                        <td>John Doe</td>

                                                        <td>detailsbtn</td>
                                                    </tr>

                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.tab-pane -->
                                    </div>
                                    <!-- /.tab-content -->


                                </div>

                            </div>
                            <div class="box box-success collapsed-box">
                                <div class="box-header">
                                    <input type="checkbox" style="width: 16; height: 16" class="pull-left">
                                    <h4 class="text-center"><b>Farm D</b></h4>

                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                        </button>
                                    </div>

                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <ul class="nav nav-tabs">
                                        <li>  </li>
                                        <li class="active"><a href="#tab_7" data-toggle="tab"><b>Details</b></a></li>
                                        <li><a href="#tab_8" data-toggle="tab"><b>Recommendations</b></a></li>
                                        <li><a href="#tab_9" data-toggle="tab"><b>Problems </b></a></li>

                                    </ul>

                                    <div class="tab-content">
                                        <div class="tab-pane active" id="tab_7">
                                            <div class="box-body box-profile">
                                                <ul class="list-group list-group-unbordered">

                                                    <li class="list-group-item">
                                                        <b>Total Area</b> <b class="pull-right text-green">
                                                            2.3
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Crop Variety</b> <b class="pull-right text-green">
                                                            FTYEM-21
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>PC</b> <b class="pull-right text-green">
                                                            80%
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>RC</b> <b class="pull-right text-green">
                                                            20%
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Brix</b> <b class="pull-right text-red">
                                                            18</b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Stalk Length</b> <b class="pull-right text-red">
                                                            12</b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Date Planted</b> <b class="pull-right text-green">
                                                            04/24/13
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>PH</b> <b class="pull-right text-red">
                                                            5.4
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Farming System</b> <b class="pull-right text-green">
                                                            Fully Mechanized
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Number of Tillers</b> <b class="pull-right text-red">
                                                            3
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>TC/HA</b> <b class="pull-right text-red">
                                                            2.8
                                                        </b>
                                                    </li>
                                                </ul>
                                                <div class="btn btn-primary pull-right">
                                                    More Details
                                                </div>
                                            </div>
                                        </div>
                                        <!-- /.tab-pane -->
                                        <div class="tab-pane" id="tab_8">
                                            <h3 class="profile-username text-center"></h3>
                                            <table class="table table-hover">
                                                <tbody><tr>
                                                        <th>Recommendation</th>

                                                        <th>more info</th>
                                                    </tr>
                                                    <tr>
                                                        <td>John Doe</td>

                                                        <td>detailsbtn</td>
                                                    </tr>

                                                    <tr>

                                                        <td>1.23</td>


                                                        <td>detailsbtn</td>
                                                    </tr>
                                                    <tr>
                                                        <td>John Doe</td>

                                                        <td>detailsbtn</td>
                                                    </tr>

                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.tab-pane -->
                                        <div class="tab-pane" id="tab_9">
                                            <table class="table table-hover">
                                                <tbody><tr>
                                                        <th>Problem</th>
                                                        <th>More Info</th>
                                                    </tr>
                                                    <tr>
                                                        <td>John Doe</td>

                                                        <td>detailsbtn</td>
                                                    </tr>

                                                    <tr>

                                                        <td>1.23</td>


                                                        <td>detailsbtn</td>
                                                    </tr>
                                                    <tr>
                                                        <td>John Doe</td>

                                                        <td>detailsbtn</td>
                                                    </tr>

                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.tab-pane -->
                                    </div>
                                    <!-- /.tab-content -->


                                </div>

                            </div>
                            <!-- nav-tabs-custom -->
                        </div>
                        <div class="col-md-4">
                            <div class="box box-primary">
                                <div class="box-header">
                                    <input type="checkbox" style="width: 16; height: 16" class="pull-left">
                                    <h4 class="text-center"><b>Farm A</b></h4>

                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                        </button>
                                    </div>

                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <ul class="nav nav-tabs">
                                        <li>  </li>
                                        <li class="active"><a href="#tab_1" data-toggle="tab"><b>Details</b></a></li>
                                        <li><a href="#tab_2" data-toggle="tab"><b>Recommendations</b></a></li>
                                        <li><a href="#tab_3" data-toggle="tab"><b>Problems </b></a></li>

                                    </ul>

                                    <div class="tab-content">
                                        <div class="tab-pane active" id="tab_1">
                                            <div class="box-body box-profile">
                                                <ul class="list-group list-group-unbordered">

                                                    <li class="list-group-item">
                                                        <b>Total Area</b> <b class="pull-right text-blue">
                                                            2.3
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Crop Variety</b> <b class="pull-right text-blue">
                                                            FTYEM-21
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>PC</b> <b class="pull-right text-blue">
                                                            80%
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>RC</b> <b class="pull-right text-blue">
                                                            20%
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Brix</b> <b class="pull-right text-yellow">
                                                            12</b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Stalk Length</b> <b class="pull-right text-yellow">
                                                            8</b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Date Planted</b> <b class="pull-right text-yellow">
                                                            04/24/13
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>PH</b> <b class="pull-right text-yellow">
                                                            4.7
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Farming System</b> <b class="pull-right text-yellow">
                                                            Fully Mechanized
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Number of Tillers</b> <b class="pull-right text-yellow">
                                                            2
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>TC/HA</b> <b class="pull-right text-yellow">
                                                            2.5
                                                        </b>
                                                    </li>
                                                </ul>
                                                <div class="btn btn-primary pull-right">
                                                    More Details
                                                </div>
                                            </div>
                                        </div>
                                        <!-- /.tab-pane -->
                                        <div class="tab-pane" id="tab_2">
                                            <h3 class="profile-username text-center"></h3>
                                            <table class="table table-hover">
                                                <tbody><tr>
                                                        <th>Recommendation</th>

                                                        <th>more info</th>
                                                    </tr>
                                                    <tr>
                                                        <td>John Doe</td>

                                                        <td>detailsbtn</td>
                                                    </tr>

                                                    <tr>

                                                        <td>1.23</td>


                                                        <td>detailsbtn</td>
                                                    </tr>
                                                    <tr>
                                                        <td>John Doe</td>

                                                        <td>detailsbtn</td>
                                                    </tr>

                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.tab-pane -->
                                        <div class="tab-pane" id="tab_3">
                                            <table class="table table-hover">
                                                <tbody><tr>
                                                        <th>Problem</th>
                                                        <th>More Info</th>
                                                    </tr>
                                                    <tr>
                                                        <td>John Doe</td>

                                                        <td>detailsbtn</td>
                                                    </tr>

                                                    <tr>

                                                        <td>1.23</td>


                                                        <td>detailsbtn</td>
                                                    </tr>
                                                    <tr>
                                                        <td>John Doe</td>

                                                        <td>detailsbtn</td>
                                                    </tr>

                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.tab-pane -->
                                    </div>
                                    <!-- /.tab-content -->


                                </div>

                            </div>

                            <!-- nav-tabs-custom -->
                        </div>
                        <div class="col-md-4">
                            <div class="box box-danger">
                                <div class="box-header">
                                    <input type="checkbox" style="width: 16; height: 16" class="pull-left">
                                    <h4 class="text-center"><b>Farm C</b></h4>

                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                        </button>
                                    </div>

                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <ul class="nav nav-tabs">
                                        <li>  </li>
                                        <li class="active"><a href="#tab_4" data-toggle="tab"><b>Details</b></a></li>
                                        <li><a href="#tab_5" data-toggle="tab"><b>Recommendations</b></a></li>
                                        <li><a href="#tab_6" data-toggle="tab"><b>Problems </b></a></li>

                                    </ul>

                                    <div class="tab-content">
                                        <div class="tab-pane active" id="tab_4">
                                            <div class="box-body box-profile">
                                                <ul class="list-group list-group-unbordered">

                                                    <li class="list-group-item">
                                                        <b>Total Area</b> <b class="pull-right text-green">
                                                            2.3
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Crop Variety</b> <b class="pull-right text-green">
                                                            FTYEM-21
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>PC</b> <b class="pull-right text-green">
                                                            80%
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>RC</b> <b class="pull-right text-green">
                                                            20%
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Brix</b> <b class="pull-right text-red">
                                                            11</b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Stalk Length</b> <b class="pull-right text-red">
                                                            6</b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Date Planted</b> <b class="pull-right text-red">
                                                            04/11/13
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>PH</b> <b class="pull-right text-green">
                                                            4.7
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Farming System</b> <b class="pull-right text-green">
                                                            Fully Mechanized
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>Number of Tillers</b> <b class="pull-right text-red">
                                                            1
                                                        </b>
                                                    </li>
                                                    <li class="list-group-item">
                                                        <b>TC/HA</b> <b class="pull-right text-red">
                                                            2.4
                                                        </b>
                                                    </li>
                                                </ul>
                                                <div class="btn btn-primary pull-right">
                                                    More Details
                                                </div>
                                            </div>
                                        </div>
                                        <!-- /.tab-pane -->
                                        <div class="tab-pane" id="tab_5">
                                            <h3 class="profile-username text-center"></h3>
                                            <table class="table table-hover">
                                                <tbody><tr>
                                                        <th>Recommendation</th>

                                                        <th>more info</th>
                                                    </tr>
                                                    <tr>
                                                        <td>John Doe</td>

                                                        <td>detailsbtn</td>
                                                    </tr>

                                                    <tr>

                                                        <td>1.23</td>


                                                        <td>detailsbtn</td>
                                                    </tr>
                                                    <tr>
                                                        <td>John Doe</td>

                                                        <td>detailsbtn</td>
                                                    </tr>

                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.tab-pane -->
                                        <div class="tab-pane" id="tab_6">
                                            <table class="table table-hover">
                                                <tbody><tr>
                                                        <th>Problem</th>
                                                        <th>More Info</th>
                                                    </tr>
                                                    <tr>
                                                        <td>John Doe</td>

                                                        <td>detailsbtn</td>
                                                    </tr>

                                                    <tr>

                                                        <td>1.23</td>


                                                        <td>detailsbtn</td>
                                                    </tr>
                                                    <tr>
                                                        <td>John Doe</td>

                                                        <td>detailsbtn</td>
                                                    </tr>

                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.tab-pane -->
                                    </div>
                                    <!-- /.tab-content -->


                                </div>

                            </div>

                            <!-- nav-tabs-custom -->
                        </div>





                        <div class="col-md-7 text-center">
                            <div class="box box-danger">
                                <div class="box-header">
                                    <h3 class="box-title">Action Tools</h3>
                                </div>
                                <div class="box-body">
                                    <a class="btn btn-app btn-linkedin">
                                        <i class="fa fa-edit"></i> Create Survey
                                    </a>
                                    <a class="btn btn-app btn-adn">
                                        <i class="fa fa-bank"></i> Create Recommendation
                                    </a>
                                    <a class="btn btn-app bg-green" data-toggle="modal" data-target="#myModal">

                                        <i class="fa fa-bullhorn"></i> Send Recommendation(modal)
                                    </a>
                                    <a class="btn btn-app bg-green" href="sendRecommendations.jsp">

                                        <i class="fa fa-bullhorn"></i> Send Recommendation(redirect)
                                    </a>

                                    <a class="btn btn-app btn-soundcloud">

                                        <i class="fa fa-inbox"></i> Determine Problem
                                    </a>


                                </div>
                                <!-- /.box-body -->
                            </div>    


                        </div>



                    </div>
                </section>
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">Send Recommendations</h4>
                            </div>
                            <div class="modal-body">

                                <div class="row">
                                    <div class="col-md-4">



                                    </div>

                                </div>
                                <table id="example" class="table  display table-hover pull-right" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <th></th>
                                            <th>Recommendation</th>
                                            <th>Description</th>
                                            <th>More Info</th>

                                        </tr>
                                    </thead>

                                </table>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                <button type="button" class="btn btn-primary">Send</button>
                            </div>
                        </div>
                    </div>
                </div>
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
            });


        </script>
    </body>

</html>