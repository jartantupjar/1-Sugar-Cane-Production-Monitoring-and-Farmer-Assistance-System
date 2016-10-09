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
                        Plan & Program Details
                        <small>Optional description</small>
                    </h1>
                </section>
                <section class="content">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="box box-primary">
                                <div class="box-body box-profile">

                                    <h3 class="profile-username text-center"><b><c:out value="${progdet.prog_name}"></c:out></b></h3>

                                        <ul class="list-group list-group-unbordered">
                                            <li class="list-group-item">
                                                <b>Type of Program</b> <a class="pull-right"><c:out value="${progdet.type}"></c:out></a>
                                            </li>
                                            <li class="list-group-item">
                                                <b>Expected Start Date:</b> <p class="pull-right"><c:out value="${progdet.date_initial}"></c:out></p>
                                            </li>
                                            <li class="list-group-item">
                                                <b>Expected End Date:</b> <p class="pull-right"><c:out value="${progdet.date_end}"></c:out></p>
                                            </li>
                                            <li class="list-group-item">
                                                <b>Description</b> 
                                                <p class="text-center pull-right">
                                                <c:out value="${progdet.description}"></c:out></p>
                                            </li>
                                            <li class="list-group-item">
                                                <b>Total Farms Affected</b> <a  class="pull-right">
                                                <c:out value="${progdet.tFarms}"></c:out>
                                                </a>
                                            </li>

                                        </ul>

                                    </div>
                                    <!-- /.box-body -->
                                </div>    
                            </div>

                            <div class="col-md-6">
                                <!-- LINE CHART -->
                                <div class="box box-info">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">Progress</h3>

                                        <div class="box-tools pull-right">
                                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                            </button>
                                            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                        </div>
                                    </div>
                                    <div class="box-body">

                                        <table class="table table-hover">
                                            <tbody><tr>

                                                </tr>
                                                <tr>

                                                    <td> 
                                                        <div class="progress-group">

                                                            <div class="progress ">
                                                                <div class="progress-bar progress-bar-green" style="width: ${progdet.progress}%">  <c:out value="${progdet.progress}"></c:out></div>
                                                            </div>
                                                        </div> <!-- closer of progress bars -->  
                                                    </td>

                                                </tr>




                                            </tbody>
                                        </table>


                                    </div>
                                    <!-- /.box-body -->
                                </div>
                            </div>
                            <div class="col-md-7" > 
                                <div>   
                                    <h3>
                                        DISTRICT/BARANGAY :

                                    </h3></div>
                                <div class="box box-info collapsed-box">
                                    <div class="box-header with-border">
                                        <h1 class="box-title">Observational Improvement (include color code for bar graph)</h1>
                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                            <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                        </div>
                                    </div>   
                                    <div class="box-body" id="container1"> </div>
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
                                            <c:forEach items="${prob}" var="plist">
                                                <tr>
                                                    <td><c:out value="${plist.prob_name}"></c:out></td>
                                                    <td><c:out value="${plist.prob_details}"></c:out></td>
                                                    </tr>
                                            </c:forEach>
                                            <!--> <tr>
                                                        <td>Overfertilization</td>
                                                        <td>Requires training farmers about the effects and good practices </td>
                                                    </tr>  <-->




                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div> 
                        <div class="col-md-9"> 
                            <div class="box box-info collapsed-box" >
                                <div class="box-header with-border">
                                    <h1 class="box-title">Barangay Progress</h1>
                                    <div class="box-tools pull-right " >
                                        <button class="btn btn-box-tool"  data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>

                                <div class="box-body">
                                    <table id="example" class="table  display table-hover" cellspacing="0" width="100%">
                                        <thead>
                                            <tr>
                                                <th>Barangay</th>
                                                <th>Problem 1</th>
                                                <th>Problem 2</th>


                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>Barangay</th>
                                                <th>Problem 1</th>
                                                <th>Problem 2</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                    <button class="btn btn-success pull-right" style="width: 10%" value="submit">Update</button>
                                </div>

                            </div>

                        </div>
                        <div class="col-md-12" > 
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Soil Rehabilitation Program</h1>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>

                                <div class="box-body">

                                    <table class="table table-hover">
                                        <thead><tr>
                                                <th style="width: 30%">Performance Indicator</th>
                                            <c:forEach  var="yrlist" begin="${kpis[0].kpi_year}" end="${kpis[0].kpi_year-1+kpis[0].tYears}">
                                            <th><c:out value="${yrlist}"/></th>
                                                <th>Actual</th>
                                            </c:forEach>
                                              

                                            </tr>
                                        </thead>
                                        <tbody>
                                         
                                            <c:forEach items="${kpis}" var="kpilist" varStatus="loopCount">
                                                <tr>
                                                    <td><c:out value="${kpilist.kpi}"/></td>
                                                    <c:forEach items="${kpilist.values}" var="yearloop" varStatus="aCountr">
                                                        
                                                        <td><c:out value="${yearloop}" /></td>
                                                        <td><input class='form-control' name = "y${loopCount.count}[]" value='${kpilist.aValues[aCountr.index]}' /></td>
                                                        </c:forEach>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <button class="btn btn-success pull-right" style="width: 10%" value="submit">Update</button>
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
        <script src="Highcharts/highcharts.js"></script>
        <script src="Highcharts/modules/drilldown.js"></script>
        <script src="Highcharts/modules/exporting.js"></script>

        
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
                            "name": "Actual Yield",
                            "data": [
                                {y: 40351.62, drilldown: 'test'},
                                51506.83,
                                68566.23,
                                80596.9228,
                                94329.31
                            ]
                        },
                        {
                            "name": "Estimated Yield",
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
    </body>

</html>