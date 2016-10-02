<%-- 
    Document   : Disaster Report
    Created on : 10 2, 16, 11:03:40 AM
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
                        Disaster Report
                        <small>Today's date : </small>
                    </h1>
                </section>
                <section class="content">


                            <div class="box-body no-padding">
                                <div class="col-md-10" > 
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h1 class="box-title">Disaster Report</h1>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <!-- In box-tools add this button if you intend to use the contacts pane -->
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div>
                            <div class="box-body no-padding">
                                <table class="table table-bordered">
                                    <tbody>
                                        <tr>
                                            <th>Type</th>
                                            <th>Date</th>
                                            <th>Location</th>
                                            <th>Recorded Count</th>
                                            <th>Damage</th>
                                            <th>Alert</th>
                                        </tr>
                                        <tr>
                                            <td>Pest</td>
                                            <td>2016-09-28</td>
                                            <td>Pio</td>
                                            <td>12</td>
                                            <td>100</td>
                                            <td><button type="button" class="btn btn-primary btn-lg pull-right" data-toggle="modal" data-target="#myModal" style="width: 100%">Send Alert</button></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                    
                            </div>
                    <!-- Modal -->
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                        <div class="modal-dialog modal-lg" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="myModalLabel">Send Alert</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="row with-border">
                                        <div class="col-md-4"><b>Fixed Message</b></div>
                                        <div class="col-md-4 col-md-offset-4"><b> Farmers </b></div>
                                    </div>
                                    <div class="row with-border">
                                        <div class="col-md-4"><input type="text" value="This is a warning to all farmers" disabled="true" id="warningalert"></div>
                                        <div class="col-md-4 col-md-offset-4"><input type="checkbox" placeholder="Farmer ABC">Farmer ABC</div>
                                    </div>
                                    
                                    
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary">Send</button>
                                </div>
                            </div>
                        </div>
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
    </body>
</html>
