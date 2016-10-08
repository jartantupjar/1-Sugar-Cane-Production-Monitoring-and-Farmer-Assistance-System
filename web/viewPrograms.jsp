<%@include file="security.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="navbar.jsp" %>
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
                        Plans & Programs List
                        <small>Optional description</small>
                    </h1>
                </section>
                <section class="content">
                    <div class="row">

                        <div class="col-md-10"> 
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <!--   <h1 class="box-title">Brgy List</h1> -->
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>

                                <div class="box-body">
                                    <table id="example" class="table display table-hover" cellspacing="0" width="100%">
                                        <thead>
                                            <tr>
                                                <th>Program</th>
                                                <th>Date</th>
                                                <th>Total Farms</th>
                                                <th>Progress</th>
                                                <th>Details</th>

                                            </tr>
                                        </thead>

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

        <script src="plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>

        <script>

            $(document).ready(function () {
                var table = $('#example').DataTable({
                    'ajax': {
                        'url': 'viewProgramsTable'
                    },
                    'columnDefs': [
                        {
                            'targets': 3,
                            'render': function (data, type, full, meta) {
                                return '<span class="badge bg-yellow" style="width: 30%">' + data + '%</span>';
                            }
                        },
                        {
                            'targets': 4,
                            'render': function (data, type, full, meta) {
                                return '<a href="viewProgramDetails?name=' + data + '" class="btn btn-primary text-center">' + 'more details' + '</a>';
                            }
                        }

                    ]
                });
            });


        </script>
    </body>

</html>