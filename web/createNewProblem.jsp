<%-- 
    Document   : createNewProblem
    Created on : 10 27, 16, 6:56:29 PM
    Author     : Bryll Joey Delfin
--%>
<%@include file="security.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file ="navbar.jsp" %>
<!DOCTYPE html>
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
                        Create New Recommendation
                        <small>***Subjective***</small>
                    </h1>
                </section>
                <section class="content">
                    <div class="row">
                        <form id="frm-example" action="createNewProblem">

                            <div class="col-md-6">
                                <div class="box box-solid box-success">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">Recommendation Details</h3>
                                    </div>
                                    <br>
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label for="projectname" class="control-label">Title</label>
                                            <input type="text" class="form-control" name="problem_name" id="problem_name" placeholder="Name...">
                                        </div>
                                        <div class="form-group">
                                            <label>Period:</label>
                                            <select class="form-control" name="period">
                                                <option>Germination</option>
                                                <option>Tillering</option>
                                                <option>Stalk Elongation</option>
                                                <option>Yield Formation</option>
                                                <option>Ripening</option>
                                                <option>Milling</option>
                                                <option>Planting</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Type of Problem</label>
                                            <select class="form-control" name="type">
                                                <option>Pest</option>
                                                <option>Disease</option>
                                                <option>La Nina</option>
                                                <option>Fire</option>
                                                <option>El Nino</option>
                                                <option>Fixed</option>
                                                <option>Subjective</option>
                                                <option>Land</option>
                                                <option>Weather</option>
                                            </select>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Description</label>
                                            <textarea class="form-control" name="description" rows="2" id="description"  placeholder="Enter ..."></textarea>
                                        </div>
                                    </div>

                                </div>
                            </div>

                            <div class="col-md-6" > 
                                <div class="box box-info">
                                    <div class="box-header with-border">
                                        <h1 class="box-title">Recommendation List <small>Optional</small></h1>
                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                            <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                        </div>
                                    </div>

                                    <div class="box-body">
                                        <table id="probTable" class="table  dispTable table-hover" cellspacing="0" width="100%">
                                            <thead>
                                                <tr>
                                                    <th></th>
                                                    <th>Recommendation</th>
                                                    <th>Description</th>
                                                    <th>Total Farms </th>
                                                </tr>
                                            </thead>
                                        </table>
                                    </div>

                                </div>
                            </div> 

                            <div class="col-md-3">                   
                                <p><button class="btn btn-primary" style="width: 100%" type="submit"  value="submit">Create</button></p>
                            </div>
                        </form>
                    </div>
                </section>
            </div>


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
    <script src="Highcharts/highcharts.js"></script>
    <script src="plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
    <script type="text/javascript" src="plugins/datatable/dataTables.checkboxes.min.js"></script>
    <script src="plugins/datepicker/bootstrap-datepicker.js"></script>
    <script>
        $(function () {
            $('.datepicker').datepicker({
                autoclose: true
            });
        });</script>
    <script>

        $(document).ready(function () {
            var rows_selected = [];
            var table1 = $('#probTable').DataTable({
                'ajax': {
                    'url': 'viewRecTableList'
                },
                'columnDefs': [{
                        'targets': 0,
                        'searchable': false,
                        'orderable': false,
                        'className': 'dt-body-center',
                        'render': function (data, type, full, meta) {
                            return '<input type="checkbox" name="probid[]"  value="'
                                    + $('<div/>').text(data).html() + '">';
                        }
                    }],
                'select': {
                    'style': 'multi'
                },
                'order': [[1, 'asc']]

            });
            $('#frm-example').on('submit', function (e) {
                var form = this;

                table1.$('input[type="checkbox"]').each(function () {
                    // If checkbox doesn't exist in DOM
                    if (!$.contains(document, this)) {
                        // If checkbox is checked
                        if (this.checked) {
                            // Create a hidden element 
                            $(form).append(
                                    $('<input>')
                                    .attr('type', 'hidden')
                                    .attr('name', this.name)
                                    .val(this.value)
                                    );
                        }
                    }
                });

            });
            

            $('#probTable-select-all').on('click', function () {
                // Check/uncheck all checkboxes in the table
                var rows = table1.rows({'search': 'applied'}).nodes();
                $('input[type="checkbox"]', rows).prop('checked', this.checked);
            });
        });
    </script>
</body>

</html>
