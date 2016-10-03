<%-- 
    Document   : determineProblem
    Created on : 10 2, 16, 10:21:03 PM
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
            <%@include file ="navbar.jsp" %>
            <div class="content-wrapper">
                <section class="content-header">
                    <h1>
                        Determine Problem
                        <small>***Verify Problem***</small>
                    </h1>
                </section>
                <section class="content">
                    <div class="row">
                        <form id="frm-example">

                            <div class="col-md-6">
                                <div class="box box-solid box-success">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">Additional Details</h3>
                                    </div>
                                    <br>
                                    <div class="box-body">
                                        
                                        <div class="form-group">
                                            <label>Title</label>
                                            <p> <input type="text" class="form-control" placeholder="Title of Problem" style="width: 100%"> </p>
                                        </div>

                                        <div class="form-group">
                                            <label>Type:</label>
                                            <select class="form-control">
                                                <option>Pest</option>
                                                <option>Practices</option>
                                                <option>Irrigation</option>
                                            </select>
                                        </div>
                                    
                                        <div  class="form-group">
                                            <label class="control-label" for="datepicker" >Date Start:</label>
                                            <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" class="form-control pull-right datepicker" name="datepicker" id="datepickerstart">
                                            </div>
                                            <!-- /.input group -->
                                        </div>



                                        <div  class="form-group">
                                            <label class="control-label" for="dateend" >Date End:</label>
                                            <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" class="form-control pull-right datepicker" name="dateend" id="datepickerend">
                                            </div>
                                            <!-- /.input group -->
                                        </div>

                                    </div>

                                </div>
                            </div>
                            <div class="col-md-6" > 
                                <div class="box box-info">
                                    <div class="box-header">
                                        <h1 class="box-title">Send To: </h1>

                                    </div>

                                    <div class="box-body ">

                                        <table class="table table-hover table-no-bordered">
                                            <tbody><tr>


                                                </tr>
                                                <tr>
                                                    <td>John Doe</td>

                                                </tr>

                                                <tr>
                                                    <td href="">henry ford</td>

                                                </tr>
                                                <tr>

                                                    <td href="">Michael Johnathan</td>

                                                </tr>
                                                <tr>
                                                    <td href="ff">Danny Frisk</td>

                                                </tr>
                                            </tbody>
                                        </table>


                                    </div>

                                </div>

                            </div>
                            <div class="col-md-6" > 
                                <div class="box box-info">
                                    <div class="box-header">
                                        <h1 class="box-title">Possible Problem: </h1>

                                    </div>

                                    <div class="box-body ">

                                        <table id="example" class="table  display table-hover pull-right" cellspacing="0" width="100%">
                                            <thead>
                                                <tr>
                                                    <th></th>
                                                    <th>Recommendation</th>
                                                    <th>Description</th>
                                                    <th>More Info</th>

                                                </tr>
                                            </thead>

                                        </table>


                                    </div>

                                </div>

                            </div>


                            <div class="col-md-2 text-center pull-right">                   
                                <p><button class="btn btn-primary btn-block" style="width: 100%" value="submit">Submit</button></p>
                            </div>
                        </form>
                    </div>
                </section>

            </div>

        </div>
        <script src="plugins/jQuery/jQuery-2.2.0.min.js"></script>
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
        });
    </script>
    <script>

        $(document).ready(function () {
            var rows_selected = [];

            var table = $('#example').DataTable({
                'ajax': {
                    'url': 'viewProbList'
                },
                'columnDefs': [{
                        'targets': 0,
                        'searchable': false,
                        'orderable': false,
                        'className': 'dt-body-center',
                        'render': function (data, type, full, meta) {
                            return '<input type="checkbox" name="id[]" id="buttonClick" value="'
                                    + $('<div/>').text(data).html() + '">';
                        }
                    }],
                'select': {
                    'style': 'multi'
                },
                'order': [[1, 'asc']]
                        //      ,
                        //       'rowCallback': function(row, data, dataIndex){
                        //         // Get row ID
                        //       var rowId = data[0];
                        //       // alert(rowId);
                        //         // If row ID is in the list of selected row IDs
                        //         if($.inArray(rowId, rows_selected) !== -1){
                        //            $(row).find('input[type="checkbox"]').prop('checked', true);
                        //            $(row).addClass('selected');
                        //         }
                        //      }     

            });

            $('#frm-example').on('submit', function (e) {
                var form = this;

                // Iterate over all checkboxes in the table
                table.$('input[type="checkbox"]').each(function () {
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
        });


    </script>
    </body>
</html>
