<%@include file="security.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--
CREATE MUNICPAL SUMMARY
CREATE BRGY SUMMARY
ADD MUNICIPAL/BRGY/FARMER DISTINCTION(CODE) FOR THE TREEMAP LINK SELECTION


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
                        Municipal Summary : <c:out value="${munidet.municipality}"/> 
                        <small>Optional description</small>
                    </h1>
                </section>
                <section class="content">
                    <div class="row">


                        <div class="col-md-4">
                            <div class="box box-primary">
                                <div class="box-body box-profile">

                                    <h3 class="profile-username text-center">Municipality: <c:out value="${munidet.municipality}"/> </h3>
                                    
                                    <ul class="list-group list-group-unbordered">
                                        <li class="list-group-item">
                                            <b>Total Farmers</b> <a class="pull-right"><c:out value="${munidet.tfarmers}"/> </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Total Fields</b> <a class="pull-right"><c:out value="${munidet.tfields}"/> </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Total Area</b> <a class="pull-right"><c:out value="${munidet.area}"/> </a>
                                        </li>
                                        
                                    </ul>

                                </div>
                                <!-- /.box-body -->
                            </div>    
                        </div>


                        <div class="col-md-8"> 
                            <div class="box box-info" >
                                <div class="box-header with-border">
                                    <h1 class="box-title">Municipal Yearly Production</h1>
                                    <div class="box-tools pull-right " >
                                        <button class="btn btn-box-tool"  data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>

                                <div class="box-body" id="container2"></div>




                            </div>

                        </div>
                        <div class="col-md-12"> 
                            <div class="box box-info" >
                                <div class="box-header with-border">
                                    <h1 class="box-title">Brgys Production for Current Year</h1>
                                    <div class="box-tools pull-right " >
                                        <button class="btn btn-box-tool"  data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>

                                <div class="box-body" id="container3"></div>




                            </div>

                        </div>

                        <div class="col-md-12">
                            <!-- LINE CHART -->
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h3 class="box-title">#Brgy Details</h3>

                                    <div class="box-tools pull-right">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                        </button>
                                        <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>
                                <div class="box-body table-responsive">

                                    <table id="fieldtable" class="table table-hover">
                                        <thead><tr>
                                                <th>Barangay</th>
                                                <th># of Farms</th>
                                                <th>Year</th>
                                                <th>Total Area</th>
                                                <th>Production</th>
<!--                                                <th>Yield</th>-->
                                                <th>Details</th>
                                        </tr>
                                        </thead>
                                    </table>


                                </div>
                                <!-- /.box-body -->
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

        <script>

            $(document).ready(function () {
var categ;
 var bar,line;
                $.ajax({
                    url: 'loadMunicSumYrsChart?name=${munidet.municipality}',
                    type: 'POST',
                    dataType: "JSON",
                    success: function (data) {
                        categ=data.categ;
                       bar=data.bar;
                       line=data.line;
                    // Create the chart
                    
                    
                    console.log(bar);
                    console.log(categ);
                  $(function () {
    $('#container2').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'Yearly Production'
        },
       
        xAxis: {
            categories: categ,
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Tons Cane (tc)'
            }
        },
           legend: {
              enabled: true
               },
        
        tooltip: {
       
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }, line: {
               marker: {
            enabled: false
        }
            }
                       
        },
        series: [{
            name: 'Year',
            data: bar

        },{
            name: 'District Avg',
            data: line,
            type:'line'

        }]
    });
});
                }
            });
var categ2;
 var bar2,prodline;
 var curyr;
    $.ajax({
                    url: 'loadAllBrgysChart?name=${munidet.municipality}',
                    type: 'POST',
                    dataType: "JSON",
                    success: function (data) {
                        categ2=data.categ;
                       bar2=data.bar;
                       curyr=data.curyr;
                       prodline=data.avgprod;
                    // Create the chart
                    
                    
                    console.log(bar);
                    console.log(categ);
                  $(function () {
    $('#container3').highcharts({
        chart: {
            type: 'column',
            zoomType: 'x'
        },
        title: {
            text: 'Distributed Production for '+curyr+ '' 
        },
       
        xAxis: {
            categories: categ2,
            crosshair: true
        },
        
        yAxis: {
            min: 0,
            title: {
                text: 'Tons Cane (tc)'
            }
        },
           legend: {
              enabled: true
               },
        
        tooltip: {
       
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            },
            line: {
        marker: {
            enabled: false
        }
    }
        },
        series: [{
            name: 'Brgys',
            type: 'column',
            data: bar2

        },{
            name: 'Dist Yearly Avg',
            type: 'line',
            data: prodline

        }]
    });
});
                }
            });
            
               var table = $('#fieldtable').DataTable({
                    'ajax': {
                        'url': 'viewBrgyMuniTable?name=${munidet.municipality}'
                    },
                    'columnDefs': [
                        {
                            'targets': 5,
                            'render': function (data, type, full, meta) {
                                return '<a href="viewBrgySummary?name=' + data + '" class="btn btn-primary text-center">' + 'more details' + '</a>';
                            }
                        }

                    ]
                });
            
            
            
            });


        </script>
    </body>

</html>