<%-- 
    Document   : sendAlert
    Created on : 10 12, 16, 11:49:14 PM
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
                        Send Alert
                        <small>Sends alerts to the specified barangay</small>
                    </h1>
                </section>
                <section class="content">



                    <div class="col-md-4">
                                <div class="box box-solid box-success">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">Problem Details</h3>
                                    </div>
                                    <br>
                                    <div class="box-body">
                                    <ul class="list-group list-group-unbordered">


                                        <li class="list-group-item">
                                            <b>Problem Name : </b> <a class="pull-right"><b>
                                                <c:out value="${problem.prob_name}">${problem.prob_name}</c:out>
                                                </b> </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Type</b> <a class="pull-right">
                                                <c:out value="${problem.type}">${problem.type}</c:out>
                                            </a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Total Farms Affected </b> <a class="pull-right">
                                                <c:out value="${problem.totalFarms}">${problem.totalFarms}</c:out>
                                            </a>
                                        </li>
                                    </ul>
                                    </div>
                                </div>
                            </div>        
               
                    <div class="col-md-4">
                                <div class="box box-solid box-success">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">Message Details</h3>
                                    </div>
                                    <br>
                                    <form id="frm-example" action="sendNotifications#">
                                    <div class="box-body">
                                        <textarea rows="6" cols="80" form="frm-example" name="message" class="pull-left">
                                            Enter your text here......
                                        </textarea>
                                        <button type="submit" class="btn btn-primary pull-right">Send Alerts</button>
                                    </div>
                                        
                                        </form>
                                </div>
                            </div>
                                            <div class="col-md-4">
                                <div class="box box-solid box-success">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">To Who : </h3>
                                    </div>
                                    <div class="box-body">
                                        <table class="table table-hover table-no-bordered">
                                            <tbody>
                                                <tr>
                                    <td>
                                    <a class=><b><c:out value="${problem.prob_name}">${problem.prob_name}</c:out></b></a>
                                    </td>
                                        </tr>
                                    </tbody>
                                    </table>

                                    </div>
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
