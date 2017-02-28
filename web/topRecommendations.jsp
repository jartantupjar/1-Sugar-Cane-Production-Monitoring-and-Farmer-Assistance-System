<%-- 
    Document   : topTenRecommendations
    Created on : 02 27, 17, 11:04:05 PM
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
        <style type="text/css" media="print">
            img
            {
                display:none;
            }  
            .hidethis
            {
                display:none;
            }
        </style>
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



                    <div class="col-md-10" > 
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h1 class="box-title">Top Problems</h1>
                                <div class="box-tools pull-right hidethis">
                                    <a tabindex="0" class="text-overflow" id="popTP" role="button"><i class="fa fa-question text-orange"></i></a>
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <!-- In box-tools add this button if you intend to use the contacts pane -->
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div>

                            <div class="box-body no-padding">
                                <table class="table table-bordered" >
                                    <tbody>
                                        <tr>
                                            <th>Problem</th>
                                            <th>Type</th>
                                            <th>Phase</th>
                                            <th>Count</th>
                                        </tr>

                                        <c:forEach var="prob" items="${pro}">
                                            <tr>	
                                                <td>${prob.prob_name}</td>
                                                <td>${prob.type}</td>
                                                <td>${prob.phase}</td>
                                                <td>${prob.count}</td>
                                            </tr>
                                        </c:forEach>

                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>        
                    <br>
                    <div class="col-md-10" > 
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h1 class="box-title">Top Recommendations</h1>
                                <div class="box-tools pull-right hidethis">
                                    <a tabindex="0" class="text-overflow" id="popTR" role="button"><i class="fa fa-question text-orange"></i></a>
                                   
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <!-- In box-tools add this button if you intend to use the contacts pane -->
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div>

                            <div class="box-body no-padding">
                                <table class="table table-bordered" >
                                    <tbody>
                                        <tr>
                                            <th>Recommendation Name</th>
                                            <th>Type</th>
                                            <th>Phase</th>
                                            <th>Count</th>
                                        </tr>
                                        <c:forEach var="rec" items="${rec}">
                                            <tr>	
                                                <td>${rec.recommendation_name}</td>
                                                <td>${rec.type}</td>
                                                <td>${rec.phase}</td>
                                                <td>${rec.counter}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4 col-md-offset-4 hidethis">
                            <a  class="btn btn-primary btn-block" role="button" onClick="window.print();" ><i class="fa fa-print"></i> Print Report</a>
                            <!--                                <button id="cmd" type="button">print PDF</button>-->
                            <br>
                        </div>

                    </div>
                </section>

            </div>

        </div>
        <script src="plugins/jQuery/jQuery-2.2.0.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="dist/js/app.min.js"></script>
        <script src="plugins/poptest/popoverText.js"></script>
        <script>
            $(document).ready(function () {
                $('#popTP').popover(popTopProb);
                $('#popTR').popover(popTopRec);
            });
        </script>
    </body>
</html>
