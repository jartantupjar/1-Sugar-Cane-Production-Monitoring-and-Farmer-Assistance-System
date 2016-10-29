<%-- 
    Document   : Homepage_Board
    Created on : 10 28, 16, 12:02:14 AM
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
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
          
            <div class="content-wrapper">
                <section class="content-header">
                    <h1>
                        Dashboard
                        <small>Optional description</small>
                    </h1>
                </section>
                <section class="content">

                    <div class="col-md-3">
                        <div class="form-group">
                            <label>Type</label>
                            <select class="form-control" id="year1">
                                <option>TC</option>
                                <option>HA</option>
                                <option>LKG</option>
                            </select>
                        </div>
                        
                    </div>
                    <div class="col-md-3 pull-right">
                        <div class="form-group">
                        <button class="btn btn-warning" style="width: 100%">Print Report</button>
                        </div>
                    </div>
                    
                    <div class="col-md-12" > 
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h1 class="box-title">Line Graph</h1>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <!-- In box-tools add this button if you intend to use the contacts pane -->
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div>

                            <div class="box-body no-padding">
                                <div id="container" style="height: 500px"></div>
                            </div>
                        </div>
                    </div>        
                    <br>
                    <div class="col-md-10" > 
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h1 class="box-title">Ongoing Programs List</h1>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <!-- In box-tools add this button if you intend to use the contacts pane -->
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div>

                            <div class="box-body">
                                <table id="example" class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Project ID</th>
                                                <th>Project Title</th>
                                                <th>District</th>
                                                <th>Date</th>
                                                <th>Description</th>
                                            </tr>
                                        </thead>
                                    </table>
                            </div>
                        </div>
                    </div> 
                </section>

            </div>

        </div>
        <script src="plugins/jQuery/jQuery-2.2.0.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="dist/js/app.min.js"></script>
        <script src="Highcharts/highcharts.js"></script>
        <script>
            $('#container').highcharts({
    
    tooltip: {
        pointFormat: "Value: {point.y:,.1f} TC"
    },
    
    xAxis: {
        type: 'datetime',
        labels: {
            format: '{value:%Y-%m-%d}',
            rotation: 45,
            align: 'left'   
        }
    },

        plotOptions: {
            series: {
                cursor: 'pointer',
                point: {
                    events: {
                        click: function () {
                            alert('Date : '+ this.x);
                         location.href = 'RegionWeekView.jsp';
                        }
                    }
                }
            }
        },

    series: [{
        data: [1029.9, 1071.5, 1106.4, 1129.2, 1144.0, 1176.0, 1135.6, 1148.5, 1216.4, 1194.1, 1095.6, 1054.4],
        pointStart: Date.UTC(2015,1,10),
        pointInterval: 168 * 36e5
    }]
               ,
                title: {
               text: 'Weekly Produced Report'
                 }

});
        </script>
        <script src="plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
        <script>

            $(document).ready(function () {
                var table = $('#example').DataTable({
                    'ajax': {
                        'url': '#'
                    },
                    'columnDefs': [{
                            'targets': 6,
                        
                            'render': function (data, type, full, meta) {
                                return '<a href="viewProbDetails?id=' + data + '" class="btn btn-primary">More Details</a>';
                            }
                            
                        }]
                });
            });


        </script>
    </body>
</html>
