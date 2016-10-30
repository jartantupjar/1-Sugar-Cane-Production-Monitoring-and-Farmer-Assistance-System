<%-- 
    Document   : Post
    Created on : 09 21, 16, 2:05:05 PM
    Author     : Bryll Joey Delfin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="security.jsp" %>
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
                        Page Header
                        <small>Optional description</small>
                    </h1>
                </section>
                <section class="content">



                    <div class="col-md-12" > 
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h1 class="box-title"><c:out value="${post.title}">${post.title}</c:out></h1> 
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <!-- In box-tools add this button if you intend to use the contacts pane -->
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div>

          <!-- Box Comment -->
          <div class="box box-widget">
            <div class="box-header with-border">
              <div class="user-block">
                <img class="img-circle" src="dist/img/user1-128x128.jpg" alt="User Image">
                <span class="username"><a href="#">${post.farmer}</a></span>
                <span class="description">${post.date_posted}</span>
                <br>
                <c:if test="${post.prob_id != null }">
                <span class="username">Problem: ${post.name}</span>
                </c:if>
              </div>
              <!-- /.user-block -->
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <img class="img-responsive pad" src="dist/img/weeds.jpg" alt="Photo">

              <p><b>${post.message}</b></p>
              <div>
                  
              <c:if test="${post.status == 'Pending'}">
                  <div class="col-md-0 pull-left">
                      <form name="approve"  action="ApprovePost">
                         <input type="text" value="${post.id_and_status}" name="postd" hidden="true">
                          <button type="submit" class="btn btn-success pull-right" style="width: 100%" id="b_approve" name="b_approve" value="submit"><i class="fa fa-check"></i> Approve</button>
                      </form>
                  </div>
                          <div class="col-md-1 pull-left">
                          <form name="reject" action="RejectPost">
                          <input type="text" value="${post.id_and_status}" name="postd" hidden="true">
                          <button type="submit" class="btn btn-danger pull-right" style="width: 100%" id="b_approve"  name="b_approve" value="submit"><i class="fa fa-times"></i> Reject</button>
                      </form>
                          </div>
              </c:if>
                  </div>
                  <div class="col-md-10 form-group">
              <c:if test="${post.prob_id == 0 && post.recom_id == 0}">
                  <a class="btn btn-success" id="lr"><i class="fa fa-chain"></i> Link to a recommendation</a>
                  <a class="btn btn-warning" id="lp"><i class="fa fa-times-circle"></i> Link to a problem</a>
                  <a href="createNewProblem.jsp" class="btn btn-danger"><i class="fa fa-warning "></i> Create New Problem </a>
                  <a href="createNewRecommendation.jsp" class="btn btn-primary"><i class="fa fa-gear "></i> Create New Recommendation </a>
              </c:if>
                  </div>
              
            </div>
            <!-- /.box-body -->
            <div class="box-footer box-comments">
                <c:set var="com" value="${comments}"></c:set>
                <c:forEach var="comments" items="${comments}">
                    <c:if test="${comments.comment_message != null}">
              <div class="box-comment">
                <!-- User image -->
                <img class="img-circle img-sm" src="dist/img/user3-128x128.jpg" alt="User Image">

                <div class="comment-text">
                      <span class="username">
                        ${comments.comment_User}
                        <span class="text-muted pull-right">8:03 PM Today</span>
                      </span><!-- /.username -->
                      ${comments.comment_message}
                </div>
                <button type="button" class="btn btn-default btn-xs pull-right"><i class="fa fa-share"></i><a href="createNewRecommendation.jsp">Create Recommendation</a></button>
                <!-- /.comment-text -->
              </div>
                </c:if>
              </c:forEach>
                
            </div>
          </div>
          <!-- /.box -->
        

                        </div>
                
                    </div>        
                    <br>
                    
                    <form id="frm-example" action="linkProblem">
                    <div class="col-md-10"  > 
                                <div class="box box-info hidden" id="linkp">
                                    <div class="box-header with-border">
                                        <h1 class="box-title">Problems List <small>Optional</small></h1>
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
                                                    <th>Problem</th>
                                                    <th>Description</th>
                                                    <th>Total Farms Affected</th>
                                                </tr>
                                            </thead>
                                        </table>
                                    </div>

                                </div>
                            </div>
                        <div class="col-md-3">                   
                                <p><button class="btn btn-primary hidden" id="savep" style="width: 100%" type="submit"  value="submit">Save</button></p>
                            </div>
                    </form>
                    <form id="frm-example2" action="linkRecommendation">
                    <div class="col-md-10"> 
                        <div class="box box-info hidden" id="linkr">
                            <div class="box-header with-border">
                                <h1 class="box-title">Link to a recommendation</h1>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <!-- In box-tools add this button if you intend to use the contacts pane -->
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div>

                            <div class="box-body">
                                <table id="recomTable" class="table  dispTable table-hover" cellspacing="0" width="100%">
                                            <thead>
                                                <tr>
                                                    <th></th>
                                                    <th>Problem</th>
                                                    <th>Description</th>
                                                    <th>Total Farms Affected</th>
                                                </tr>
                                            </thead>
                                        </table>
                            </div>

                        </div>
                    </div>
                        <div class="col-md-3">                   
                                <p><button class="btn btn-primary hidden" style="width: 100%" type="submit"  value="submit">Save</button></p>
                            </div>
                    </form>

                </section>

            </div>

        </div>
        <script src="plugins/jQuery/jQuery-2.2.0.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="dist/js/app.min.js"></script>
        <script src="plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript" src="plugins/datatable/dataTables.checkboxes.min.js"></script>
        <script>
            $(function(){
             $("#lp").on("click",function(){
                $('#linkp').removeClass('hidden');
                $('#savep').removeClass('hidden');
             });
             $("#lr").on("click",function(){
                $('#linkr').removeClass('hidden'); 
             });
            });
        </script>
        <script>

        $(document).ready(function () {
            var rows_selected = [];
            
            var table1 = $('#probTable').DataTable({
                'ajax': {
                    'url': 'viewProbList'
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
                ,
                'rowCallback': function (row, data, dataIndex) {
                            // Get row ID
                            var rowId = data[0];
                            var limit = 1;
                            // alert(rowId);
                            // If row ID is in the list of selected row IDs
                            //  alert("notclicked");
//                                         if($.inArray(rowId, rows_selected) !== -1){
//                                              
//                                            $(row).find('input[type="checkbox"]').prop('checked', true);
//                                            $(row).addClass('selected');
//                                          
//                                         }
                            table1.$('input[type="checkbox"]', row).on('change', function (evt) {
                                console.log("outentered");
                                var tcounter = 0;

                                table1.$('input[type="checkbox"]').each(function () {
                                    if (this.checked) {

                                        tcounter += 1;

                                    }

                                });

                                if (tcounter > limit) {
                                    console.log(tcounter);
                                    this.checked = false;
                                }
                            });
                        }

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
