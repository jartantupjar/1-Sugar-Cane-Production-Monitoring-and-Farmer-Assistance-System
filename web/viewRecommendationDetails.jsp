
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
                    <div class="row">
                        <div class="col-md-4">
                            <div class="box box-primary">
                                <div class="box-body box-profile">

                                      <h3 class="profile-username text-center">Recommendation Details:</h3> 
                                    <ul class="list-group list-group-unbordered">


                                        <li class="list-group-item">
                                            <b>Recommendation </b>  <p class="pull-right"><b>
                                                    <c:out value="${recdet.recommendation_name}"></c:out>
                                                    </b></p>
                                            </li>
                                            <li class="list-group-item">
                                                <b>Type</b><p class="pull-right"><b>
                                                    <c:out value="${recdet.type}"></c:out>
                                                    </b> </p>
                                            </li>
                                            <li class="list-group-item">
                                                <b>Description </b><p class="text-right text-bold">
                                                <c:out value="${recdet.description}"></c:out>
                                                </p>
                                            </li>
                                            <li class="list-group-item">
                                                <b>Phase</b> <p class="pull-right"><b>
                                                    <c:out value="${recdet.phase}"></c:out>

                                                    </b> </p>
                                            </li>
                                            <li class="list-group-item">
                                                <b>Status</b> <p class="pull-right"><b>
                                                    <c:out value="${recdet.status}"></c:out>

                                                    </b> </p>
                                            </li>
                                            <li class="list-group-item">
                                                <b> Date Created</b> <p class="pull-right"><b>
                                                    <c:out value="${recdet.date_create}"></c:out>
                                                    </b> </p>
                                            </li>

                                            <li class="list-group-item">
                                                <b>Period</b> <p class="pull-right"><b>
                                                    <c:out value="${recdet.date_start}"></c:out> - <c:out value="${recdet.date_end}"></c:out>  

                                                    </b> </p>
                                            </li>

                                            <li class="list-group-item">
                                                <b class="text-green">Configuration</b>  <p class="pull-right text-green"> <b>
                                                    <c:choose>
                                                        <c:when test='${recdet.trigger_date !=null}'>
                                                            <c:out value="${recdet.trigger_date}"></c:out> 
                                                        </c:when>
                                                        <c:otherwise>
                                                            <c:out value="${recdet.trigger_num}"></c:out> 
                                                        </c:otherwise>
                                                    </c:choose>
                                                </b> </p>
                                        </li>
                                      
                                        <li class="list-group-item text-maroon">
                                            <b> Helpfulness Counter</b> <p class="pull-right"><b>
                                                    79
                                                </b> </p>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Recorded Effects?</b> <p class="pull-right"><b>
                                                    None
                                                </b> </p>
                                        </li>

                                    </ul>

                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="box box-solid box-success">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Recommendation Details(do aims to prevent func)(TO farm not farmer DB DB DB)(ask bj resend validation)(date updated for each farm??)(char(1) approved?)</h3>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="box box-solid box-success">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Aims To Prevent The Following:</h3>
                                </div>
                                <div class="box-body">
                                    <table class="table table-bordered" >
                                        <thead>
                                            <tr>
                                                <th>Problem</th>
                                                <th>Description</th>
                                                <th>Details</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                             <c:if test="${not empty problist}">
                                        <c:forEach var="plist" items="${problist}">
                                            
                                            <tr>	
                                                <td>${plist.prob_name}</td>
                                                <td>${plist.prob_details}</td>
                                                <td><a class="btn btn-primary" href="viewProbDetails?id=${plist.prob_id}" >details</a></td>
                                            </tr>
                                            </c:forEach>
                                            </c:if>
                                            
                                        </tbody>
                                    </table>
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
                        <div class="col-md-8" > 
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Recommendation Details</h1>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <!-- In box-tools add this button if you intend to use the contacts pane -->
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>

                                <div class="box-body">
                                    <table id="recList1" class="table table-bordered" >
                                        <thead>
                                            <tr>
                                                <th>Farm</th>
                                                <th>Farmer</th>
                                                <th>Barangay</th>
                                                <th>Date</th>
                                                <th>Validation</th>
                                            </tr>
                                        </thead>
                                    </table>
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
        <script src="plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
        <script>

            $(document).ready(function () {
                var table = $('#recList1').DataTable({
                    'ajax': {
                        'url': 'viewFRTable?id=${id}'
                    }
                });
            });


        </script>
    </body>
</html>
