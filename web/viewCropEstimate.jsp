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
                        <div class="col-md-10"> 
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
                                    <table id="esttable" class="table display table-hover" cellspacing="0" width="100%">
                                        <thead>
                                            <tr>
                                                <th>Year</th>
                                                <th>Area</th>
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
                            <div class="box box-info collapsed-box">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Estimations</h1>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>

                                <div class="box-body">
                                    <table id="quartestable" class="table display table-hover" cellspacing="0" width="100%">
                                        <thead>
                                            <tr>
                                                <th>Estimation 1</th>
                                                <th>Estimation 2</th>
                                                <th>Estimation 3</th>
                                                <th>Actual</th>
                                                <th>Date/Quarter</th>

                                            </tr>
                                        </thead>
                                       
                                    </table>
                                </div>

                            </div>

                            

                        </div>
                        <div>
                            <div class="col-md-3 form-group">
                                <label>Municipality</label>
                                <select class="form-control select2" style="width: 100%;">
                                    <option selected="selected">All</option>
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
                                    <option selected="selected"></option>
                                    <option>San Fernando</option>
                                    <option>Mexico</option>
                                    <option>California</option>
                                    <option>Delaware</option>
                                    <option>Tennessee</option>
                                    <option>Texas</option>
                                    <option>Washington</option>
                                </select>
                            </div>
                            <div class="col-md-3 form-group">
                                <label>Year</label>
                                <select class="form-control select2" style="width: 100%;">

                                    <option>2012</option>
                                    <option>2013</option>
                                    <option>2014</option>
                                    <option>2015</option>
                                    <option>2016</option>
                                </select>
                            </div>
                        </div>

                        <div class="col-md-10"> 
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h1 class="box-title">District List</h1>
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
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Municipality List</h1>
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
                borderWidth: 0,
                dataLabels: {
                    enabled: true
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
                var table = $('#distable').DataTable({
                    'ajax': {
                        'url': 'viewDistCropEstimate'
                    }
                      });

              
                 var table2 = $('#munitable').DataTable({
                    'ajax': {
                        'url': 'viewMuniCropEst'
                    },
                    'columnDefs': [{
                            'targets': 6,
                            'render': function (data, type, full, meta) {
                                return '<a class="btn btn-primary" href="' + data + '"> more details </a>';
                            }
                        }]
                });
                
                   var table3 = $('#esttable').DataTable({
                    'ajax': {
                        'url': 'viewDiffDistEst'
                    }
                      });
            });
//

        </script>
         
        
        <script>
            //ASYNC VERSION
//            $(function () {
//
//    // Create the chart
//    $('#container2').highcharts({
//        chart: {
//            type: 'column',
//            events: {
//                drilldown: function (e) {
//                    if (!e.seriesOptions) {
//
//                        var chart = this,
//                            drilldowns = {
//                                'Animals': {
//                                    name: 'Animals',
//                                    data: [
//                                        ['Cows', 2],
//                                        ['Sheep', 3]
//                                    ]
//                                },
//                                'Fruits': {
//                                    name: 'Fruits',
//                                    data: [
//                                        ['Apples', 5],
//                                        ['Oranges', 7],
//                                        ['Bananas', 2]
//                                    ]
//                                },
//                                'Cars': {
//                                    name: 'Cars',
//                                    data: [
//                                        ['Toyota', 1],
//                                        ['Volkswagen', 2],
//                                        ['Opel', 5]
//                                    ]
//                                }
//                            },
//                            series = drilldowns[e.point.name];
//
//                        // Show the loading label
//                        chart.showLoading('Simulating Ajax ...');
//
//                        setTimeout(function () {
//                            chart.hideLoading();
//                            chart.addSeriesAsDrilldown(e.point, series);
//                        }, 1000);
//                    }
//
//                }
//            }
//        },
//        title: {
//            text: 'Async drilldown'
//        },
//        xAxis: {
//            type: 'category'
//        },
//
//        legend: {
//            enabled: false
//        },
//
//        plotOptions: {
//            series: {
//                borderWidth: 0,
//                dataLabels: {
//                    enabled: true
//                }
//            }
//        },
//
//        series: [{
//            name: 'Things',
//            colorByPoint: true,
//            data: [{
//                name: 'Animals',
//                y: 5,
//                drilldown: true
//            }, {
//                name: 'Fruits',
//                y: 2,
//                drilldown: true
//            }, {
//                name: 'Cars',
//                y: 4,
//                drilldown: true
//            }]
//        }],
//
//        drilldown: {
//            series: []
//        }
//    });
//});

            </script>
    
<!--        <script>
// BASIC CHART
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
                                            format: '{point.y:.1f}'
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
                            name: 'Microsoft Internet Explorer',
                                    id: 'Microsoft Internet Explorer',
                                    data: [
                                            [
                                                    'v11.0',
                                                    54.13
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
                            },{
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
                            </script>-->
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
                                    "2013-14"
                                   
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
                    }, {
                    name: 'Test2 Drilldown',
                            id: 'test2',
                            data: [
                                    ['data D', 5.33],
                                    ['data C', 8.11],
                                    ['data E', 6.34]
                                    ['data A', 24.13],
                                    ['data B', 17.2]
                            ]
                    },
                    {
                          name: 'Microsoft Internet Explorer',
                                    id: 'Microsoft Internet Explorer',
                                    data: [
                                            [
                                                    'January', 24.13
                                            ],
                                            [
                                                    'February', 17.2
                                            ],
                                            [
                                                    'March', 8.11
                                            ],
                                            [
                                                    'April', 5.33
                                            ],
                                            [
                                                    'May', 1.06
                                            ],
                                            [
                                                    'June', 0.5
                                            ],
                                            [
                                                    'July', 1.06
                                            ],
                                            [
                                                    'August', 0.5
                                            ],
                                            [
                                                    'September', 1.06
                                            ],
                                            [
                                                    'October', 0.5
                                            ],
                                            [
                                                    'November', 1.06
                                            ],
                                            [
                                                    'December', 0.5
                                            ]
                                    ]
                    }
                
                ]
                    },
                    series: [
                    {
                    "name": "First",
                            "data": [
                            {y: 40351.62, drilldown: 'test'},
                            {y:51506.83, drilldown:'test2'},
                            {y:68566.23,drilldown:'Microsoft Internet Explorer'},
                                    80596.9228,
                                    94329.31
                            ]
                    },
                    {
                    "name": "Second",
                            "data": [
                            {y: 40750.4963, drilldown: 'test'},
                                    56205.181,
                                    63776.2866,
                                    74912.5923,
                                    83801.83617
                            ]
                    }
                    ]
            });
            });        </script>
                                <script>
//                    $(function () {
//                    // Create the chart
//                    $('#container2').highcharts({
//                    chart: {
//                    type: 'column'
//                    },
//                            title: {
//                            text: 'Browser market shares. January, 2015 to May, 2015'
//                            },
//                            subtitle: {
//                            text: 'Click the columns to view versions. Source: <a href="http://netmarketshare.com">netmarketshare.com</a>.'
//                            },
//                            xAxis: {
//                            type: 'category'
//                            },
//                            yAxis: {
//                            title: {
//                            text: 'Total percent market share'
//                            }
//
//                            },
//                            legend: {
//                            enabled: false
//                            },
//                            plotOptions: {
//                            series: {
//                            borderWidth: 0,
//                                    dataLabels: {
//                                    enabled: true,
//                                            format: '{point.y:.1f}%'
//                                    }
//                            }
//                            },
//                            tooltip: {
//                            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
//                                    pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
//                            },
//                            series: [{
//                            name: 'Brands',
//                                    colorByPoint: true,
//                                    data: [{
//                                    name: 'Microsoft Internet Explorer',
//                                            y: 56.33,
//                                            drilldown: 'Microsoft Internet Explorer'
//                                    }, {
//                                    name: 'Chrome',
//                                            y: 24.03,
//                                            drilldown: 'Chrome'
//                                    }, {
//                                    name: 'Firefox',
//                                            y: 10.38,
//                                            drilldown: 'Firefox'
//                                    }, {
//                                    name: 'Safari',
//                                            y: 4.77,
//                                            drilldown: 'Safari'
//                                    }, {
//                                    name: 'Opera',
//                                            y: 0.91,
//                                            drilldown: 'Opera'
//                                    }, {
//                                    name: 'Proprietary or Undetectable',
//                                            y: 0.2,
//                                            drilldown: null
//                                    }]
//                            },{
//                            name: 'Hands',
//                                    colorByPoint: true,
//                                    data: [{
//                                    name: 'Microsoft Internet Explorer',
//                                            y: 56.33,
//                                            drilldown: 'Microsoft Internet Explorer'
//                                    }, {
//                                    name: 'Chrome',
//                                            y: 24.03,
//                                            drilldown: 'Chrome'
//                                    }, {
//                                    name: 'Firefox',
//                                            y: 10.38,
//                                            drilldown: 'Firefox'
//                                    }, {
//                                    name: 'Safari',
//                                            y: 4.77,
//                                            drilldown: 'Safari'
//                                    }, {
//                                    name: 'Opera',
//                                            y: 0.91,
//                                            drilldown: 'Opera'
//                                    }, {
//                                    name: 'Proprietary or Undetectable',
//                                            y: 0.2,
//                                            drilldown: null
//                                    }]
//                            }],
//                            drilldown: {
//                            series: [{
//                            name: 'Microsoft Internet Explorer',
//                                    id: 'Microsoft Internet Explorer',
//                                    data: [
//                                            [
//                                                    'v11.0',
//                                                    24.13
//                                            ],
//                                            [
//                                                    'v8.0',
//                                                    17.2
//                                            ],
//                                            [
//                                                    'v9.0',
//                                                    8.11
//                                            ],
//                                            [
//                                                    'v10.0',
//                                                    5.33
//                                            ],
//                                            [
//                                                    'v6.0',
//                                                    1.06
//                                            ],
//                                            [
//                                                    'v7.0',
//                                                    0.5
//                                            ]
//                                    ]
//                            }, {
//                            name: 'Microsoft Internet Explorer',
//                                    id: 'Microsoft Internet Explorer',
//                                    data: [
//                                            [
//                                                    'v11.0',
//                                                    54.13
//                                            ],
//                                            [
//                                                    'v8.0',
//                                                    17.2
//                                            ],
//                                            [
//                                                    'v9.0',
//                                                    8.11
//                                            ],
//                                            [
//                                                    'v10.0',
//                                                    5.33
//                                            ],
//                                            [
//                                                    'v6.0',
//                                                    1.06
//                                            ],
//                                            [
//                                                    'v7.0',
//                                                    0.5
//                                            ]
//                                    ]
//                            },{
//                            name: 'Chrome',
//                                    id: 'Chrome',
//                                    data: [
//                                            [
//                                                    'v40.0',
//                                                    5
//                                            ],
//                                            [
//                                                    'v41.0',
//                                                    4.32
//                                            ],
//                                            [
//                                                    'v42.0',
//                                                    3.68
//                                            ],
//                                            [
//                                                    'v39.0',
//                                                    2.96
//                                            ],
//                                            [
//                                                    'v36.0',
//                                                    2.53
//                                            ],
//                                            [
//                                                    'v43.0',
//                                                    1.45
//                                            ],
//                                            [
//                                                    'v31.0',
//                                                    1.24
//                                            ],
//                                            [
//                                                    'v35.0',
//                                                    0.85
//                                            ],
//                                            [
//                                                    'v38.0',
//                                                    0.6
//                                            ],
//                                            [
//                                                    'v32.0',
//                                                    0.55
//                                            ],
//                                            [
//                                                    'v37.0',
//                                                    0.38
//                                            ],
//                                            [
//                                                    'v33.0',
//                                                    0.19
//                                            ],
//                                            [
//                                                    'v34.0',
//                                                    0.14
//                                            ],
//                                            [
//                                                    'v30.0',
//                                                    0.14
//                                            ]
//                                    ]
//                            }, {
//                            name: 'Firefox',
//                                    id: 'Firefox',
//                                    data: [
//                                            [
//                                                    'v35',
//                                                    2.76
//                                            ],
//                                            [
//                                                    'v36',
//                                                    2.32
//                                            ],
//                                            [
//                                                    'v37',
//                                                    2.31
//                                            ],
//                                            [
//                                                    'v34',
//                                                    1.27
//                                            ],
//                                            [
//                                                    'v38',
//                                                    1.02
//                                            ],
//                                            [
//                                                    'v31',
//                                                    0.33
//                                            ],
//                                            [
//                                                    'v33',
//                                                    0.22
//                                            ],
//                                            [
//                                                    'v32',
//                                                    0.15
//                                            ]
//                                    ]
//                            }, {
//                            name: 'Safari',
//                                    id: 'Safari',
//                                    data: [
//                                            [
//                                                    'v8.0',
//                                                    2.56
//                                            ],
//                                            [
//                                                    'v7.1',
//                                                    0.77
//                                            ],
//                                            [
//                                                    'v5.1',
//                                                    0.42
//                                            ],
//                                            [
//                                                    'v5.0',
//                                                    0.3
//                                            ],
//                                            [
//                                                    'v6.1',
//                                                    0.29
//                                            ],
//                                            [
//                                                    'v7.0',
//                                                    0.26
//                                            ],
//                                            [
//                                                    'v6.2',
//                                                    0.17
//                                            ]
//                                    ]
//                            }, {
//                            name: 'Opera',
//                                    id: 'Opera',
//                                    data: [
//                                            [
//                                                    'v12.x',
//                                                    0.34
//                                            ],
//                                            [
//                                                    'v28',
//                                                    0.24
//                                            ],
//                                            [
//                                                    'v27',
//                                                    0.17
//                                            ],
//                                            [
//                                                    'v29',
//                                                    0.16
//                                            ]
//                                    ]
//                            }]
//                            }
//                    });
//                            });       
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
