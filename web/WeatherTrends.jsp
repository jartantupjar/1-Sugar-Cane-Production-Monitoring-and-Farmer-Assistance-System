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
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
            <%@include file ="navbar.jsp" %>
            <div class="content-wrapper">
                <section class="content-header">
                    <h1>
                        Page Header
                        <small>Optional description</small>
                    </h1>
                </section>
                <section class="content">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="form-group">
                                            <label>Year</label>
                                            <select class="form-control">
                                                <option>2014</option>
                                                <option>2015</option>
                                                <option>2016</option>
                                            </select>
                                        </div>
                        </div>
                        <div class="col-md-11" > 
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Weather Trends</h1>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>
                                <div class="box-body no-padding" id="container1"></div>
                            </div>
                        </div>
                        <br>
                        <div class="col-md-3">
                            <div class="form-group">
                                            <label>Year</label>
                                            <select class="form-control">
                                                <option>2014</option>
                                                <option>2015</option>
                                                <option>2016</option>
                                            </select>
                                        </div>
                        </div>
                        <br>
                        <div class="col-md-11" > 
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Weather Trends</h1>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>
                                <div class="box-body no-padding" id="container2"></div>
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
        <script type="text/javascript">
            $(function () {
                $('#container1').highcharts({
                    chart: {
                        zoomType: 'xy'
                    },
                    title: {
                        text: 'Annual Rainfall and Growth Trends (2015-2016)'
                    },
                    subtitle: {
                        text: 'Source: WorldClimate.com'
                    },
                    xAxis: [{
                            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
                            crosshair: true
                        }],
                    yAxis: [{// Primary yAxis
                            labels: {
                                format: '{value} tc/ha',
                                style: {
                                    color: Highcharts.getOptions().colors[1]
                                }
                            },
                            title: {
                                text: 'Growth',
                                style: {
                                    color: Highcharts.getOptions().colors[1]
                                }
                            }
                        }, {// Secondary yAxis
                            title: {
                                text: 'Rainfall',
                                style: {
                                    color: Highcharts.getOptions().colors[0]
                                }
                            },
                            labels: {
                                format: '{value} mm',
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
                        y: 100,
                        floating: true,
                        backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
                    },
                    series: [{
                            name: 'Growth',
                            type: 'column',
                            yAxis: 1,
                            data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4],
                            tooltip: {
                                valueSuffix: 'tc/ha'
                            }

                        }, {
                            name: 'Rainfall',
                            type: 'spline',
                            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6],
                            tooltip: {
                                valueSuffix: 'mm'
                            }
                        }]
                });
            });
        </script>
        <script type="text/javascript">
            $(function () {
                $('#container2').highcharts({
                    chart: {
                        zoomType: 'xy'
                    },
                    title: {
                        text: 'Annual Rainfall and Production Trends (2015-2016)'
                    },
                    subtitle: {
                        text: 'Source: WorldClimate.com'
                    },
                    xAxis: [{
                            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
                            crosshair: true
                        }],
                    yAxis: [{// Primary yAxis
                            labels: {
                                format: '{value} tc',
                                style: {
                                    color: Highcharts.getOptions().colors[1]
                                }
                            },
                            title: {
                                text: 'Production',
                                style: {
                                    color: Highcharts.getOptions().colors[1]
                                }
                            }
                        }, {// Secondary yAxis
                            title: {
                                text: 'Rainfall',
                                style: {
                                    color: Highcharts.getOptions().colors[0]
                                }
                            },
                            labels: {
                                format: '{value} mm',
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
                        y: 100,
                        floating: true,
                        backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
                    },
                    series: [{
                            name: 'Production',
                            type: 'column',
                            yAxis: 1,
                            data: [10.9, 11.5, 22.4, 33.2, 44.0, 54.0, 100.6, 110.5, 120.4, 130.1, 95.6, 20.4],
                            tooltip: {
                                valueSuffix: 'tc'
                            }

                        }, {
                            name: 'Rainfall',
                            type: 'spline',
                            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6],
                            tooltip: {
                                valueSuffix: 'mm'
                            }
                        }]
                });
            });
        </script>

        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="dist/js/app.min.js"></script>
        <script src="plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
        <script src="Highcharts/highcharts.js"></script>
        <script src="Highcharts/modules/exporting.js"></script>
        
    </body>
</html>
