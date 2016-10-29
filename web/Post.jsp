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
                                <h1 class="box-title"><c:out value="${post.message}">${post.message}</c:out></h1>
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
              </div>
              <!-- /.user-block -->
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <img class="img-responsive pad" src="dist/img/photo2.png" alt="Photo">

              <p>${post.message}</p>
              <button type="button" class="btn btn-default btn-xs"><i class="fa fa-share"></i> Share</button>
              <button type="button" class="btn btn-default btn-xs"><i class="fa fa-thumbs-o-up"></i> Approve </button>
             
            </div>
            <!-- /.box-body -->
            <div class="box-footer box-comments">
                <c:forEach var="comments" items="${comments}">
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
              </c:forEach>
            </div>
          </div>
          <!-- /.box -->
        

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
