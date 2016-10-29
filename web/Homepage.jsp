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
                    <h1>
                        Today's Date: ${todayDate}
                    </h1>
                </section>
                <section class="content">
<div class="row">
    <div class="col-md-12"> 
        <div class="box box-info">
            <div class="box-header with-border">
                <h1 class="box-title">Crop Estimate :</h1>
                <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                </div>
            </div>   
            <div class="box-body">
                <table id="munitable" class="table table-bordered">
                    <thead>
                        <tr>
                            <th style="width: 5%">Year</th>
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

                    <div class="col-md-12" > 
                        <div class="box box-info" style="height:120%">
                            <div class="box-header with-border">
                                <h1 class="box-title">Yield Tree Map (Annual) </h1>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div>   
                              <div class="box-body">
                            
                                           <div class="col-md-2 pull-right">
                                <select class="form-control" style="width:50%" id="select3">
                                 
                                </select>
                                        </div>
                       
                                <div id="container1" style="height:90%"></div>
                                
                                
                            </div>
                        </div>

                    </div>
                    <br>
                    <div class="col-md-6" > 
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h1 class="box-title">Area Harvested : <c:out value="${todayDate}"></c:out> </h1>
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
                                            <th>Previous</th>
                                            <th>This Week</th>
                                            <th>To Date</th>
                                            <th>Percent Completed</th>	
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="ca" items="${CropAss}">
                                        <tr>	
                                            <td>${ca.particulars}</td>
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
                                                            <div class="progress progress-sm progress-striped-active">
                                                                <div class="progress-bar progress-bar-primary" style="width : ${ca.percent}%"></div>
                                                                </div>
                                                            </div>
                                                        </b>
                                                    </span>
                                                </div>
                                            </td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h1 class="box-title">Standing Crop (Yesterday's Week)</h1>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div>

                            <div class="box-body no-padding">
                                <table class="table table-bordered" >
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
                    <br>
                    <div class="col-md-6" > 
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h1 class="box-title">Weather Forecast (Today)</h1>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div>   
                            <div class="box-body no-padding" id="container1">
                                <table class="table table-bordered" >
                                    <thead>
                                    <c:forEach var="rain" items="${rainfall}">
                                       
                                            <th> mm of rain of week ending : ${rain.week_ending}</th>
                                       
                                    </c:forEach>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="r" items="${rainfall}">
                                        
                                            <td>${r.rainfall} mm</td>
                                        
                                        </c:forEach>
                                    </tbody>
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
        <script src="plugins/pace2/pace.min.js"></script>
        <script src="plugins/select2/select2.full.min.js"></script>
        <script src="plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
        <script></script>
  
        <script type="text/javascript">
       $(document).ready(function () {
           
           $('#select3').on('change', function (evt) {
                   var test = $("#select3").val();
                    Pace.track(function(){
    $.ajax({
                url: 'loadTreeMapData?tag=' + test + '',
                type: 'POST',
                dataType: "JSON",
                success: function (data) {
                    var points = [],
                            municipalP,
                            municipalI = 0,
                            municipalVal,
                            barangayP,
                            barangayI,
                            farmerP,
                            farmerI,
                            municipal,
                            barangay,
                            farmer;
                 
                    for (municipal in data) {
                        if (data.hasOwnProperty(municipal)) {
                            municipalVal = 0;
                            municipalP = {
                                id: 'id_' + municipalI,
                                name: municipal,
                                color: Highcharts.getOptions().colors[municipalI]
                            };
                            barangayI = 0;
                            for (barangay in data[municipal]) {
                                if (data[municipal].hasOwnProperty(barangay)) {
                                    barangayP = {
                                        id: municipalP.id + '_' + barangayI,
                                        name: barangay,
                                        parent: municipalP.id

                                    };
                                    points.push(barangayP);

                                    farmerI = 0;
                                    for (farmer in data[municipal][barangay]) {
                                        if (data[municipal][barangay].hasOwnProperty(farmer)) {
                                            farmerP = {
                                                id: barangayP.id + '_' + farmerI,
                                                name: farmer,
                                                parent: barangayP.id,
                                                value: Math.round(+data[municipal][barangay][farmer])
                                            };
                                            municipalVal += farmerP.value;
                                            points.push(farmerP);
                                            farmerI = farmerI + 1;
                                        }
                                    }
                                    barangayI = barangayI + 1;
                                }
                            }
                            municipalP.value = Math.round(municipalVal);
                            points.push(municipalP);
                            municipalI = municipalI + 1;
                        }
                    }
                    $('#container1').highcharts({
                        series: [{
                                type: 'treemap',
                                layoutAlgorithm: 'squarified',
                                allowDrillToNode: true,
                                animationLimit: 1000,
                                turboThreshold:  10000,
                                dataLabels: {
                                    enabled: false
                                },
                                levelIsConstant: false,
                                levels: [{
                                        level: 1,
                                        dataLabels: {useHTML: true,
                                            enabled: true,
                                            formatter: function () {


                                                if (this.point.isLeaf) {
                                                    return this.key;
                                                } else {

                                                    return '<a style="color:white" href="viewFarmerProfile?name=' + this.key + '"   target="_blank">' + this.key + '</div>';

                                                }
                                            }
                                        },
                                        borderWidth: 3
                                    }],
                                data: points
                            }],
                        subtitle: {
                            text: 'Click points to drill down'
                        },
                        title: {
                            text: 'Production of last year'
                        }
                    });


                }});
        });
        });
             $.ajax({
                        url: 'loadTreeMapYearList',
                        type: 'POST',
                        dataType: "JSON",
                        success: function (data) {
                           $("#select3").select2({
                               minimumResultsForSearch: Infinity,
                                data: data
                            }).trigger('change');
                            var yr = $("#select3").val();

                        }});


  });
        </script>

        <script type="text/javascript">
            $(function () {  //gauge code

                var gaugeOptions = {
                    chart: {
                        type: 'solidgauge'
                    },
                    title: null,
                    pane: {
                        center: ['50%', '85%'],
                        size: '140%',
                        startAngle: -90,
                        endAngle: 90,
                        background: {
                            backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || '#EEE',
                            innerRadius: '60%',
                            outerRadius: '100%',
                            shape: 'arc'
                        }
                    },
                    tooltip: {
                        enabled: false
                    },
                    // the value axis
                    yAxis: {
                        stops: [
                            [0.1, '#DF5353'], // red
                            [0.5, '#DDDF0D'], // yellow
                            [0.9, '#55BF3B'] // green 
                        ],
                        lineWidth: 0,
                        minorTickInterval: null,
                        tickAmount: 2,
                        title: {
                            y: -70
                        },
                        labels: {
                            y: 16
                        }
                    },
                    plotOptions: {
                        solidgauge: {
                            dataLabels: {
                                y: 5,
                                borderWidth: 0,
                                useHTML: true
                            }
                        }
                    }
                };



                // The RPM gauge
                $('#container-rpm').highcharts(Highcharts.merge(gaugeOptions, {
                    yAxis: {
                        min: 0,
                        max: 100,
                        title: {
                            text: 'TC/HA'
                        }
                    },
                    series: [{
                            name: 'TC/HA',
                            data: [10],
                            dataLabels: {
                                format: '<div style="text-align:center"><span style="font-size:25px;color:' +
                                        ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black') + '">{y:.1f}  </span><br/>' +
                                        '<span style="font-size:12px;color:silver">*Production</span></div>'
                            },
                            tooltip: {
                                valueSuffix: ' TonsCane/AreaHarvested'
                            }
                        }]

                }));

            });
        </script>
        <script>

            $(document).ready(function () {
                var table = $('#munitable').DataTable({
                    'ajax': {
                        'url': 'viewDistCropEstimate?year=${todayYear}' 
                    }
                });
                $('#munitable').DataTable().search('${Week_ending}').draw();
            });


        </script>


        <script src="Highcharts/highcharts.js"></script>
        <script src="Highcharts/modules/treemap.js"></script>
        <script src="Highcharts/highcharts-more.js"></script>
        <script src="Highcharts/modules/solid-gauge.js"></script>
     

    </body>

</html>
