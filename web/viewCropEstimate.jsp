<%-- 
    Document   : WeatherTrends
    Created on : 09 19, 16, 1:34:00 PM
    Author     : Bryll Joey Delfin
--%>

<%@include file="security.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>SRA | Home</title>
        <meta content="width=device-width, i/nitial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="plugins/select2/select2.min.css">
        <link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css">
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">

            <div class="content-wrapper">
                <section class="content-header">
                    <h1>
                        View Crop Estimate
                        <small>Optional description</small>
                    </h1>
                </section>
                <section class="content">
                    <div class="row">
                        <div class="col-md-12"> 
                            <div>   
                                <h3>
                                    District: Tarlac
                                </h3></div>

                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Estimations</h1>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>

                                <div class="box-body">
                                    <div class="box-body" id="container4"></div>
                                    <table id="esttable" class="table display table-hover" cellspacing="0" width="100%">
                                        <thead>
                                            <tr>
                                                <th>Year</th>
                                                <th>Area</th>
                                                <th>Rainfall</th>
                                                <th>Tiller Count</th>
                                                <th>Avg Temp</th>
                                                <th>Actual</th>
                                                <th>Estimation 1</th>
                                                <th>Estimation 2</th>
                                                <th>Estimation 3</th>

                                            </tr>
                                        </thead>

                                    </table>
                                    <button type="button" class="btn btn-info pull-right" id="showform" >Gen Forecast</button>
                                </div>

                            </div>
                            


                            <div class="box box-info hidden" id="genform">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Generate Forecast</h1>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>

                                <div class="box-body">
                                    <form action="generateForecast" id="submit_form" method="POST" >
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label class="control-label">Area Harvested
                                                    <span class="required" aria-required="true"> * </span>
                                                </label>
                                                <div class="">
                                                    <input type="text" class="form-control" name="area" id="projectname" placeholder="Name...">

                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="control-label">Year Rainfall
                                                    <span class="required" aria-required="true"> * </span>
                                                </label>
                                                <div class="">
                                                    <input type="text" class="form-control" name="rain" id="projectname" placeholder="Name...">

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label">Yearly Temperature

                                                </label>
                                                <div class="">
                                                    <input type="text" class="form-control" name="temp" id="projectname" placeholder="Name...">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label">Total Tiller Amount
                                                </label>
                                                <div class="">
                                                    <input type="text" class="form-control" name="tiller" id="projectname" placeholder="Name...">

                                                </div>
                                            </div>


                                        </div>
                                        <button type="submit" class="btn btn-primary cGen pull-right" form="submit_form" value="submit">Generate</button>
                                        <button type="button" class="btn btn-default cGen pull-right" id="cGen">Close</button>
                                    </form>

                                </div>

                            </div>
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Forecast Simulations</h1>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>

                                <div class="box-body">

                                    <table id="testTable" class="table display table-hover" cellspacing="0" width="100%">
                                        <thead>
                                            <tr>
                                                <th>Area</th>
                                                <th>Rainfall</th>
                                                <th>Tiller Count</th>
                                                <th>Avg Temp</th>
                                                <th>Actual</th>
                                                <th>Estimation 1</th>
                                                <th>Estimation 2</th>
                                                <th>Estimation 3</th>
                                            </tr>
                                        </thead>

                                    </table>

                                </div>

                            </div>
                            <div class="box box-info">
                                <div class="box-header with-border">

                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>   
                                <div class="box-body" id="container2"></div>
                            </div>

                        </div>
                        <div>
                            <div class="col-md-3 form-group">
                                <label>Select</label>
                                <select class="form-control select2" id="select2" style="width: 100%;">
                                    <option value="0" selected="selected">District</option>
                                    <option value="1">Municipality</option>

                                </select>
                            </div> 
                            <div class="col-md-3 form-group">
                                <label>Year</label>
                                <select class="form-control" id="select3" style="width: 100%;">

                                </select>
                            </div>
                            <div class="col-md-3 form-group">
                                <label>Barangay</label>
                                <select class="form-control" style="width: 100%;">
                                    <option selected="selected"></option>
                                    <!--                                    <option>San Fernando</option>
                                                                        <option>Mexico</option>
                                                                        <option>California</option>
                                                                        <option>Delaware</option>
                                                                        <option>Tennessee</option>
                                                                        <option>Texas</option>
                                                                        <option>Washington</option>-->
                                </select>
                            </div>

                        </div>

                        <div class="col-md-10"> 
                            <div class="box box-info" id="distbox">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Weekly District Estimates</h1>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>

                                <div class="box-body">
                                    <table id="distable" class="table  display table-hover" cellspacing="0" width="100%">
                                        <thead>
                                            <tr>
                                                <th>Year</th>
                                                <th>Week Ending</th>
                                                <th>Harvest Area</th>
                                                <th>Actual Production</th>
                                                <th>Estimated Production</th>
                                                <th>% Difference</th>
                                            </tr>
                                        </thead>
                                    </table>

                                </div>

                            </div>

                        </div>
                        <div class="col-md-10"> 
                            <div class="box box-info" id="munibox">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Yearly Municipality Estimates</h1>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>

                                <div class="box-body">
                                    <table id="munitable" class="table  display table-hover" cellspacing="0" width="100%">
                                        <thead>
                                            <tr>
                                                <th>Year</th>
                                                <th>Municipality</th>
                                                <th>Area</th>
                                                <th>Actual</th>
                                                <th>Estimated</th>
                                                <th>% Difference</th>
                                                <th>More Details</th>

                                            </tr>
                                        </thead>

                                    </table>

                                </div>

                            </div>

                        </div>




                        <br>
                    </div>

                </section>
            </div>
            <footer class="main-footer">
                -
                <div class="pull-right hidden-xs">
                    <b>Version</b> 2.3.3
                </div>
                <strong>Copyright &copy; 2014-2015 <a href="http://sra.com">Sugar Regulatory Association</a>.</strong>
            </footer>
        </div>

        <script type="text/javascript" src="plugins/jQuery/jQuery-2.2.0.min.js"></script>


        <script>
            $(function () {
                var categ;
                var bard;
                var estd;
                var est2d;
                var est3d;
                $.ajax({
                    url: 'loadEstimatesLineData',
                    type: 'POST',
                    dataType: "JSON",
                    success: function (data) {
                        categ = data.categ;
                        bard = data.bard;
                        estd = data.estd;
                        est2d = data.est2d;
                        est3d = data.est3d;
                        $('#container4').highcharts({
                            chart: {
                                zoomType: 'xy'
                            },
                            title: {
                                text: 'Yearly Estimate Data'
                            },
                            xAxis: [{
                                    categories: categ,
                                    crosshair: true
                                }],
                            yAxis: [{// Secondary yAxis
                                    title: {
                                        text: 'Production',
                                        style: {
                                            color: Highcharts.getOptions().colors[0]
                                        }
                                    },
                                    labels: {
                                        format: '{value}',
                                        style: {
                                            color: Highcharts.getOptions().colors[0]
                                        }
                                    },
                                    opposite: true
                                }],
                            tooltip: {
                                shared: true
                            },
                            legend: {
                                layout: 'vertical',
                                align: 'left',
                                x: 120,
                                verticalAlign: 'top',
                                y: 0,
                                floating: true,
                                backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
                            },
                            series: [{
                                    name: 'Estimate 1'+ '<input type="checkbox" name="E1">',
                                    type: 'column',
                                    data: estd,
                                    tooltip: {
                                        valueSuffix: '°'
                                    }
                                }, {
                                    name: 'Estimate 2',
                                    type: 'column',
                                    data: est2d,
                                    tooltip: {
                                        valueSuffix: '°'
                                    }
                                }, {
                                    name: 'Estimate 3',
                                    type: 'column',
                                    data: est3d,
                                    tooltip: {
                                        valueSuffix: '°'
                                    }
                                }, {
                                    name: 'Actual',
                                    type: 'spline',
                                    data: bard,
                                    tooltip: {
                                        valueSuffix: ' mm'
                                    }

                                }]
                        });
                    }
                });
            });

        </script>
        <script>
            $(function () {
                var list;
                var dlist;
                $.ajax({
                    url: 'loadCompChartData',
                    type: 'POST',
                    dataType: "JSON",
                    success: function (data) {
                        list = data.list;
                        dlist = data.dlist;

                        // Create the chart
                        $('#container2').highcharts({
                            chart: {
                                type: 'column'
                            },
                            title: {
                                text: 'District Estimate Drilldown'
                            },
                            subtitle: {
                                text: 'Click columns to drill down to single series. Click categories to drill down both.'
                            },
                            xAxis: {
                                type: 'category'
                            },
                            plotOptions: {
                                series: {
                                    borderRadius: 5,
                                    pointWidth: 60,
                                    pointPadding: 1,
                                    groupPadding: 0.1,
                                    dataLabels: {
                                        enabled: true,
                                        y: 5
                                    }
                                }
                            },
                            series: list,
                            drilldown: {
                                series: dlist
                            }
                        });
                    }
                });
            });

        </script>
        <script>

            $(document).ready(function () {


                $('#select3').on('change', function (evt) {
                    var dist = $("#select2").val();
                    var yr = $("#select3").val();
                    $('#munibox').addClass('hidden');
                    $('#distbox').addClass('hidden');
                    if (dist === '0') {
                        $('#distbox').removeClass('hidden');
                        var table = $('#distable').DataTable({
                            destroy: true,
                            'ajax': {
                                'url': 'viewDistCropEstimate?year=' + yr + ''
                            }
                        });
                    } else {
                        $('#munibox').removeClass('hidden');
                        var table2 = $('#munitable').DataTable({
                            destroy: true,
                            'ajax': {
                                'url': 'viewMuniCropEst?year=' + yr + ''
                            },
                            'columnDefs': [{
                                    'targets': 6,
                                    'render': function (data, type, full, meta) {
                                        return '<a class="btn btn-primary" href="' + data + '"> more details </a>';
                                    }
                                }]
                        });
                    }





                });
                $('#select2').on('change', function (evt) {
                    var test = $("#select2").val();

                    $.ajax({
                        url: 'loadCropEstYearList?tag=' + test + '',
                        type: 'POST',
                        dataType: "JSON",
                        success: function (data) {
                            $("#select3").empty();
                            $("#select3").select2({
                                data: data
                            }).trigger('change');
                            var yr = $("#select3").val();

                        }});
                });
                $("#showform").on("click", function () {
                    $('#genform').removeClass('hidden');
                    $('#showform').addClass('hidden');
                });
                $(".cGen").on("click", function () {
                    $('#showform').removeClass('hidden');
                    $('#genform').addClass('hidden');
                });


                var $dist = $("#select2").select2({minimumResultsForSearch: Infinity});
                var test = $("#select2").val();
                console.log(test);
                $dist.trigger("change");


                //ESTIMATE TABLE        
                var table3 = $('#esttable').DataTable({
                    'ajax': {
                        'url': 'viewDiffDistEst'
                    },
                    "paging": false,
//                    "ordering": false,
                    "info": false,
                    "searching": false
                });
                var table4 = $('#testTable').DataTable({
                    'ajax': {
                        'url': 'viewTestEstimates'
                    },
                    "paging": false,
//                    "ordering": false,
                    "info": false,
                    "searching": false
                });
            });
//

        </script>





        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="dist/js/app.min.js"></script>
        <script src="plugins/select2/select2.full.min.js"></script>
        <script src="plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
        <script src="Highcharts/highcharts.js"></script>
        <script src="Highcharts/modules/drilldown.js"></script>
        <script src="Highcharts/modules/exporting.js"></script>
    </body>
</html>
