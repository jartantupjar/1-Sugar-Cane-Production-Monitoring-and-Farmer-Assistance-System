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
                            <select class="form-control" id="particulars">
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
                    <div class="col-md-12" > 
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
                                                <th>Project Name</th>
                                                <th style="width: 15%">Date Started</th>
                                                <th style="width: 15%">Date Ended</th>
                                                <th>Description</th>
                                                <th>Details</th>
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
        <script src="plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
        <script src="Highcharts/highcharts.js"></script>
        <script src="Highcharts/modules/exporting.js"></script>
        
        <script>
            $(function(){
            var sel = document.getElementById("particulars");
            var sv = sel.options[sel.selectedIndex].value;
            alert(sv);
            $.ajax({
                url: "viewWeeklyProducedReport?id="+sv,
                tye: "POST",
                dateType: "JSON",
                success: function(data){ 
                  console.log(data);  
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
                         location.href = 'viewWeeklyProducedReportByWeek?id='+this.x+'&type='+sv;
                        }
                    }
                }
            }
        },

    series: [{
        data: data.prod,
        pointStart: Date.UTC(${todayYear},${todayMonth},${todayDay}),
        pointInterval: 168 * 36e5
    }]
               ,
                title: {
               text: 'Weekly Produced Report'
                 }

}); 
                }
            });
            
            
            sel.onchange = function(){
                var sl = sel.options[sel.selectedIndex].value;
                alert(sl);
                $.ajax({
                url: "viewWeeklyProducedReport?id="+sl,
                tye: "POST",
                dateType: "JSON",
                success: function(data){ 
                  console.log(data);  
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
                         location.href = 'viewWeeklyProducedReportByWeek?id='+this.x+'&type='+sv;
                        }
                    }
                }
            }
        },

    series: [{
        data: data.prod,
        pointStart: Date.UTC(${todayYear},${todayMonth},${todayDay}),
        pointInterval: 168 * 36e5
    }]
               ,
                title: {
               text: 'Weekly Produced Report'
                 }

}); 
                }
            });
           };
                     
//// end of the ajax 
//                }
//            });
//            };    
});
        </script>
        <script>

            $(document).ready(function () {
                var table = $('#example').DataTable({
                    'ajax': {
                        'url': 'viewOnGoingProjects'
                    },
                    'columnDefs': [{
                            'targets': 4,
                        
                            'render': function (data, type, full, meta) {
                                return '<a href="viewProbDetails?id=' + data + '" class="btn btn-primary">More Details</a>';
                            }
                            
                        }]
                });
            });


        </script>
        
    </body>
</html>