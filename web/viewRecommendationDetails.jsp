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
                        Page Header
                        <small>Optional description</small>
                    </h1>
                </section>
                <section class="content">

                    
                    <div class="col-md-12" > 
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h1 class="box-title">Recommendation</h1>
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
