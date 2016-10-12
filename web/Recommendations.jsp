<%-- 
    Document   : Recommendations
    Created on : 09 27, 16, 12:03:24 AM
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
        <link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css">
           <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
       <link href="plugins/pace2/pace-theme-center-simple.css" rel="stylesheet" />
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
            <%@include file ="navbar.jsp" %>
            <div class="content-wrapper">
                <section class="content-header">
                    <h1>
                        Recommendations
                        <small>Shows a list of recommendation</small>
                    </h1>
                </section>
                <section class="content">
                    <div class="row">


                    <div class="col-md-12" > 
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h1 class="box-title">Fixed Recommendations</h1>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <!-- In box-tools add this button if you intend to use the contacts pane -->
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div>

                            <div class="box-body">
                                <table id="recList" class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th>Recommendation</th>
                                            <th>Type</th>
                                            <th>Description</th>
                                            <th>Phase</th>
                                            <th>Period</th>
                                            <th>Config</th>
                                            <th></th>
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

        </div>
        <script src="plugins/jQuery/jQuery-2.2.0.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="dist/js/app.min.js"></script>
        <script src="plugins/pace2/pace.min.js"></script>
        <script src="plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
        <script>

            $(document).ready(function () {
                var table = $('#recList').DataTable({
                    'ajax': {
                        'url': 'viewRecList'
                    },
                    'columnDefs': [{
                            'targets': 6,
                            'render': function (data, type, full, meta) {
                                return '<a href="viewRecDetails?id=' + data + '" class="btn btn-primary text-center">' + 'more details' + '</a>';
                            }

                        }]
                });
            });


        </script>
    </body>
</html>
