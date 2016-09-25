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
            <%@include file ="navbar.jsp" %>
            <div class="content-wrapper">
                <section class="content-header">
                    <h1>
                        View Crop Estimate
                        <small>Optional description</small>
                    </h1>
                </section>
                <section class="content">
                    <div class="row">
                        <div>
                            <div class="col-md-3 form-group">
                                <label>Municipality</label>
                                <select class="form-control select2" style="width: 100%;">
                                    <option selected="selected">Alabama</option>
                                    <option>Alaska</option>
                                    <option>California</option>
                                    <option>Delaware</option>
                                    <option>Tennessee</option>
                                    <option>Texas</option>
                                    <option>Washington</option>
                                </select>
                            </div> 
                            <div class="col-md-3 form-group">
                                <label>Barangay</label>
                                <select class="form-control select2" style="width: 100%;">
                                    <option selected="selected">Alabama</option>
                                    <option>Alaska</option>
                                    <option>California</option>
                                    <option>Delaware</option>
                                    <option>Tennessee</option>
                                    <option>Texas</option>
                                    <option>Washington</option>
                                </select>
                            </div>
                        </div>

                        <div class="col-md-10"> 
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Brgy List</h1>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>

                                <div class="box-body">
                                    <table id="example" class="table  display table-hover" cellspacing="0" width="100%">
                                        <thead>
                                            <tr>
                                                <th>Brgy</th>
                                                <th>Estimated</th>
                                                <th>Actual</th>
                                                <th>Variance</th>

                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>Brgy</th>
                                                <th>Estimated</th>
                                                <th>Actual</th>
                                                <th>Variance</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>

                            </div>

                        </div>
                       
                        <div class="col-md-6" > 
                            <div>   
                        <h3>
                        DISTRICT/BARANGAY :
                       
                    </h3></div>
                            <div class="box box-info collapsed-box">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Option 1</h1>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>   
                               <div class="box-body" id="container1"> </div>
                            </div>

                        </div>
                        
                        <div class="col-md-6" > 
                             <div>   
                        <h3>
                       SAN FERNANDO/ROXAS
                    </h3></div>
                            <div class="box box-info collapsed-box">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Option 2</h1>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>   
                                <div class="box-body" id="container2"></div>
                               </div>

                        </div>
                        <div class="col-md-10"> 
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Estimations</h1>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>

                                <div class="box-body">
                                    <table id="example1" class="table display table-hover" cellspacing="0" width="100%">
                                        <thead>
                                            <tr>
                                                <th>Estimation 1</th>
                                                <th>Estimation 2</th>
                                                <th>Estimation 3</th>
                                                <th>Actual</th>
                                                       <th>Date/Quarter</th>

                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                               <th>Estimation 1</th>
                                                <th>Estimation 2</th>
                                                <th>Estimation 3</th>
                                                <th>Actual</th>
                                                  <th>Date/Quarter</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>

                            </div>

                        </div>
                        <br>
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
                 var table = $('#example1').DataTable({
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
        <script>
            $(function () {

                // Create the chart
                $('#container1').highcharts({
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: 'Basic drilldown'
                    },
                    xAxis: {
                        type: 'category',
                        categories: [
                            "2011-12",
                            "2012-13",
                            "2013-14",
                            "2014-15",
                            "2015-16"
                        ]

                    },
                    legend: {
                        enabled: false
                    },
                    plotOptions: {
                        series: {
                            borderWidth: 0,
                            dataLabels: {
                                enabled: true
                            }
                        }
                    },
                    drilldown: {
                        series: [{
                                name: 'Test Drilldown',
                                id: 'test',
                                data: [
                                    ['data A', 24.13],
                                    ['data B', 17.2],
                                    ['data C', 8.11],
                                    ['data D', 5.33],
                                    ['data E', 6.34]
                                ]
                        }]
                    },
                    series: [
                        {
                            "name": "First",
                            "data": [
                                {y: 40351.62, drilldown: 'test'},
                                51506.83,
                                68566.23,
                                80596.9228,
                                94329.31
                            ]
                        },
                        {
                            "name": "Second",
                            "data": [
                                40750.4963,
                                56205.181,
                                63776.2866,
                                74912.5923,
                                83801.83617
                            ]
                        }
                    ]
                });
            });
        </script>
        <script>
            $(function () {
    // Create the chart
    $('#container2').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'Browser market shares. January, 2015 to May, 2015'
        },
        subtitle: {
            text: 'Click the columns to view versions. Source: <a href="http://netmarketshare.com">netmarketshare.com</a>.'
        },
        xAxis: {
            type: 'category'
        },
        yAxis: {
            title: {
                text: 'Total percent market share'
            }

        },
        legend: {
            enabled: false
        },
        plotOptions: {
            series: {
                borderWidth: 0,
                dataLabels: {
                    enabled: true,
                    format: '{point.y:.1f}%'
                }
            }
        },

        tooltip: {
            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
        },

        series: [{
            name: 'Brands',
            colorByPoint: true,
            data: [{
                name: 'Microsoft Internet Explorer',
                y: 56.33,
                drilldown: 'Microsoft Internet Explorer'
            }, {
                name: 'Chrome',
                y: 24.03,
                drilldown: 'Chrome'
            }, {
                name: 'Firefox',
                y: 10.38,
                drilldown: 'Firefox'
            }, {
                name: 'Safari',
                y: 4.77,
                drilldown: 'Safari'
            }, {
                name: 'Opera',
                y: 0.91,
                drilldown: 'Opera'
            }, {
                name: 'Proprietary or Undetectable',
                y: 0.2,
                drilldown: null
            }]
        }],
        drilldown: {
            series: [{
                name: 'Microsoft Internet Explorer',
                id: 'Microsoft Internet Explorer',
                data: [
                    [
                        'v11.0',
                        24.13
                    ],
                    [
                        'v8.0',
                        17.2
                    ],
                    [
                        'v9.0',
                        8.11
                    ],
                    [
                        'v10.0',
                        5.33
                    ],
                    [
                        'v6.0',
                        1.06
                    ],
                    [
                        'v7.0',
                        0.5
                    ]
                ]
            }, {
                name: 'Chrome',
                id: 'Chrome',
                data: [
                    [
                        'v40.0',
                        5
                    ],
                    [
                        'v41.0',
                        4.32
                    ],
                    [
                        'v42.0',
                        3.68
                    ],
                    [
                        'v39.0',
                        2.96
                    ],
                    [
                        'v36.0',
                        2.53
                    ],
                    [
                        'v43.0',
                        1.45
                    ],
                    [
                        'v31.0',
                        1.24
                    ],
                    [
                        'v35.0',
                        0.85
                    ],
                    [
                        'v38.0',
                        0.6
                    ],
                    [
                        'v32.0',
                        0.55
                    ],
                    [
                        'v37.0',
                        0.38
                    ],
                    [
                        'v33.0',
                        0.19
                    ],
                    [
                        'v34.0',
                        0.14
                    ],
                    [
                        'v30.0',
                        0.14
                    ]
                ]
            }, {
                name: 'Firefox',
                id: 'Firefox',
                data: [
                    [
                        'v35',
                        2.76
                    ],
                    [
                        'v36',
                        2.32
                    ],
                    [
                        'v37',
                        2.31
                    ],
                    [
                        'v34',
                        1.27
                    ],
                    [
                        'v38',
                        1.02
                    ],
                    [
                        'v31',
                        0.33
                    ],
                    [
                        'v33',
                        0.22
                    ],
                    [
                        'v32',
                        0.15
                    ]
                ]
            }, {
                name: 'Safari',
                id: 'Safari',
                data: [
                    [
                        'v8.0',
                        2.56
                    ],
                    [
                        'v7.1',
                        0.77
                    ],
                    [
                        'v5.1',
                        0.42
                    ],
                    [
                        'v5.0',
                        0.3
                    ],
                    [
                        'v6.1',
                        0.29
                    ],
                    [
                        'v7.0',
                        0.26
                    ],
                    [
                        'v6.2',
                        0.17
                    ]
                ]
            }, {
                name: 'Opera',
                id: 'Opera',
                data: [
                    [
                        'v12.x',
                        0.34
                    ],
                    [
                        'v28',
                        0.24
                    ],
                    [
                        'v27',
                        0.17
                    ],
                    [
                        'v29',
                        0.16
                    ]
                ]
            }]
        }
    });
});
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
