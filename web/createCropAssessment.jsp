<%@include file="security.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>SRA | Home</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link href="plugins/pace2/pace-theme-barber-shop.css" rel="stylesheet" />
        <link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css"> 
        <link rel="stylesheet" href="plugins/select2/select2.min.css">
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
            <div class="content-wrapper">
                <section class="content-header">

                </section>
                <section class="content">
                    <div class="row">
                        <h3 class="text-center text-bold">CROP ASSESSMENT REPORT</h3>
                        <h3 class="text-center text-bold">Crop Year: ${todayYear}</h3>

                        <h3 >&nbsp  Week Ending: ${Week_ending}</h3>
                        <h3 class="text-bold">&nbsp PART 1:PRODUCTION DATA</h3>
                        <div class="col-md-12" > 
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h1 class="box-title ">A. Area Harvested</h1>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>

                                <div class="box-body no-padding">
                                    <table class="table table-bordered"  >
                                        <thead>

                                            <tr >
                                                <th class="text-center" rowspan="2">Particulars</th>
                                                <th class="text-center" colspan="3">Estimated Production</th>
                                                <th style="width:15%" class="text-center"  rowspan="2">Percent Completed</th>	
                                            </tr>
                                            <tr>
                                                <th class="text-center">Previous</th>
                                                <th class="text-center">This Week</th>
                                                <th class="text-center">To Date</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="ca" items="${CropAss}">
                                                <tr>	
                                                    <td >${ca.particulars}</td>
                                                    <td>${ca.estimated}</td>
                                                    <td>${ca.previous}</td>
                                                    <td>${ca.thisweek}</td>
                                                    <td>${ca.todate}</td>
                                                    <td>
                                                        <div class="progress-group" >
                                                            <span class="progress-number">
                                                                <b>
                                                                    ${ca.percent}%
                                                                </b>
                                                            </span>
                                                            <span>
                                                                <div class="progress progress-sm progress-striped-active">
                                                                    <div class="progress-bar progress-bar-primary" style="width : ${ca.percent}%"></div>
                                                                </div>
                                                        </div>

                                                        </span>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>
                        <div class="col-md-5">
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h1 class="box-title">B. Standing Crop</h1>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>

                                <div class="box-body no-padding">
                                    <table class="table table-bordered"  >
                                        <thead>
                                            <tr>
                                                <th>Particulars</th>
                                                <th>Estimated Production</th>	
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="ca" items="${CropAss}">
                                                <tr>	
                                                    <td>${ca.particulars}</td>
                                                    <td>${ca.standing}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>

                        <div class="col-md-12">
                            <h3 class="text-bold">PART 2:NARRATIVE REPORT  <small>Optional description</small></h3>
                            <form action="submitCA">
                                
                                <input name="weekending" value="${Week_ending}" type="hidden">
                                <input name="cropyear" value="${todayYear}" type="hidden">
                                <div class="box box-info">                        
                                    <div class="box-body">


                                        <table class="table table-bordered">
                                            <tbody>

                                                <tr>
                                                    <th style="width:20%">WEATHER</th>
                                                    <td> <textarea style="resize:none" class="form-control" name="dweather" rows="2"  placeholder="Enter ..."></textarea></td>
                                                </tr>
                                                <tr>
                                                    <th>PRICE OF SUGAR</th>
                                                    <td> <textarea style="resize:none" class="form-control" name="dprice" rows="2"  placeholder="Enter ..."></textarea></td>
                                                </tr>
                                                <tr>
                                                    <th>MILL OPERATION</th>
                                                    <td> <textarea style="resize:none" class="form-control" name="dmill" rows="2"  placeholder="Enter ..."></textarea></td>
                                                </tr>
                                                <tr>
                                                    <th>PRICES OF INPUTS</th>
                                                    <td> <textarea style="resize:none" class="form-control" name="dinput" rows="2"  placeholder="Enter ..."></textarea></td>
                                                </tr>
                                                <tr>
                                                    <th>OTHERS</th>
                                                    <td> <textarea style="resize:none" class="form-control" name="dother" rows="2"  placeholder="Enter ..."></textarea></td>
                                                </tr>
                                                <tr>
                                                    <th>OVERALL ANALYSIS</th>
                                                    <td> <textarea style="resize:none" class="form-control" name="danalysis" rows="2"  placeholder="Enter ..."></textarea></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-md-4 col-md-offset-4">
                                          <input class="btn btn-success pull-right" type="button" value="Back" 
        onClick="history.go(-1);return true;"> 
                                        <button class="btn btn-info btn-block" type="submit" >Submit</button>
                                        <br>
                                    </div>
                            
                                    </div>
                                </form>
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
        <script src="plugins/pace2/pace.min.js"></script>
        <script src="plugins/select2/select2.full.min.js"></script>
        <script src="plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
        <script>

            $(document).ready(function () {
                var table = $('#munitable').DataTable({
                    'ajax': {
                        'url': 'viewDistCropEstimate?year=${todayYear}'
                    },
                    "paging": false,
                    "ordering": false,
                    "info": false,
                    "searching": true
                });
                $('#munitable').DataTable().search('${Week_ending}').draw();
                $('#munitable_filter').addClass('hidden');
            });


        </script>
        <script src="Highcharts/highcharts.js"></script>
        <script src="Highcharts/modules/treemap.js"></script>
        <script src="Highcharts/highcharts-more.js"></script>
        <script src="Highcharts/modules/solid-gauge.js"></script>
    </body>

</html>
