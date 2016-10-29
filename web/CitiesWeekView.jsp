<%-- 
    Document   : CitiesWeekView
    Created on : 10 28, 16, 7:49:03 AM
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
                        Page Header
                        <small>Optional description</small>
                    </h1>
                </section>
                <section class="content">



                    <div class="col-md-12" > 
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h1 class="box-title"><b>Weekly Production Statistics Report</b></h1>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <!-- In box-tools add this button if you intend to use the contacts pane -->
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div>

                            <div class="box-body no-padding">
                                <table id="example" class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>District</th>
                                                <th>Estimated Production</th>
                                                <th>This Week (Area)</th>
                                                <th>To Date (Area)</th>
                                                <th>This Week (Tons Cane)</th>
                                                <th>To Date (Tons Cane)</th>
                                                <th>This Week (LKG)</th>
                                                <th>To Date (LKG)</th>
                                            </tr>
                                        </thead>
                                    </table>
                            </div>

                        </div>
                    </div>        
                    <br>

                </section>

            </div>

        </div>
        <script src="plugins/jQuery/jQuery-2.2.0.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="dist/js/app.min.js"></script>
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
