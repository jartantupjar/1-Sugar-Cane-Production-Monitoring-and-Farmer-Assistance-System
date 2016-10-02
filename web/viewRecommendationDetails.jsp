<%-- 
    Document   : viewRecommendationDetails
    Created on : 09 29, 16, 7:29:30 AM
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
                        
                        Recommendations Details 
                        <small>Optional description</small>
                    </h1>
                </section>
                <section class="content">

                    <div class="col-md-6">
                                <div class="box box-solid box-success">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">Recommendation Details</h3>
                                    </div>
                                    <br>
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label>Recommendation Name : </label>
                                        </div>
                                        <div class="form-group">
                                            <label>Description : </label>
                                        </div>
                                        <div class="form-group">
                                            <label>Details : </label>
                                        </div>
                                        <div class="form-group">
                                            <label>Aims to prevent : <li><a href="#myModal" data-toggle="modal" data-target="#myModal">3</a> </li> </label>
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
                                    <h4 class="modal-title" id="myModalLabel">Problems List</h4>
                                </div>
                                <div class="modal-body">
                                    <table class="table table-bordered" >
                                    <tbody>
                                        <tr>
                                            <th>Problem</th>
                                            <th>Description</th>
	
                                        </tr>
                                        <tr>	
                                            <td>Pest</td>
                                            <td><button><a href="Problems.jsp"><b> View Details</b></a></button></td>
                                        </tr>
                                    </tbody>
                                </table>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary">Send</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12" > 
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h1 class="box-title">Recommendation Details</h1>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <!-- In box-tools add this button if you intend to use the contacts pane -->
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div>

                            <div class="box-body no-padding">
                                <table class="table table-bordered" >
                                    <tbody>
                                        <tr>
                                            <th>Farm</th>
                                            <th>Farmer</th>
                                            <th>Barangay</th>
                                            <th>Date</th>
                                            <th>Helpfullness Counter</th>
                                        </tr>
                                        <tr>	
                                            <td>Farm A</td>
                                            <td>Farmer ABC</td>
                                            <td>Pio</td>
                                            <td>October 01</td>
                                            <td>100</td>
                                        </tr>
                                    </tbody>
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
    </body>
</html>
