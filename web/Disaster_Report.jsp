<%-- 
    Document   : Disaster_Report
    Created on : 11 17, 16, 4:36:50 PM
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
                        Disaster Report 
                        <small>Printed view</small>
                    </h1>
                </section>
                <section class="content">
                    <div class="row">   
                        
                        <div class="col-md-10"> 
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Damage by District</h1>
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
                                                <th>District</th>
                                                <th>Total Farms</th>
                                                <th>Damage (Area)</th>
                                            </tr>
                                            <c:forEach var="report" items="${districtReport}">
                                                <tr>	
                                                    <td>${report.district}</td>
                                                    <td><span class="pull-right">${report.totalFarms}</span></td>
                                                    <td><span class="pull-right">${report.damage} HA</span></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div> 

                        <div class="col-md-10"> 
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Damage by Disaster Type</h1>
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
                                                <th>Type</th>
                                                <th>Total Farms</th>
                                                <th>Damage (Area) </th>
                                            </tr>
                                            <c:forEach var="type" items="${typeReport}">
                                                <tr>	
                                                    <td>${type.type}</td>
                                                    <td><span class="pull-right">${type.totalFarms}</span></td>
                                                    <td><span class="pull-right">${type.damage} HA</span></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div> 
                        <div class="col-md-3 pull-right">
                            <form id="frm-example" action="">
                                <div class="form-group">
                                    <button class="btn btn-warning" style="width: 100%" type="submit">Print Report</button>
                                </div>
                            </form>
                        </div>

                    </div>
                </section>

            </div>

        </div>
        <script src="plugins/jQuery/jQuery-2.2.0.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="dist/js/app.min.js"></script>
    </body>
</html>
