<%-- 
    Document   : WeatherReport
    Created on : 09 20, 16, 2:46:07 PM
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
        <style>
/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    -webkit-animation-name: fadeIn; /* Fade in the background */
    -webkit-animation-duration: 0.4s;
    animation-name: fadeIn;
    animation-duration: 0.4s
}

/* Modal Content */
.modal-content {
    position: fixed;
    bottom: 0;
    background-color: #fefefe;
    width: 100%;
    -webkit-animation-name: slideIn;
    -webkit-animation-duration: 0.4s;
    animation-name: slideIn;
    animation-duration: 0.4s
}

/* The Close Button */
.close {
    color: white;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}

.modal-header {
    padding: 2px 16px;
    background-color: #5cb85c;
    color: white;
}

.modal-body {padding: 16px 16px;}

.modal-footer {
    padding: 2px 16px;
    background-color: #5cb85c;
    color: white;
}

/* Add Animation */
@-webkit-keyframes slideIn {
    from {bottom: -300px; opacity: 0}
    to {bottom: 0; opacity: 1}
}

@keyframes slideIn {
    from {bottom: -300px; opacity: 0}
    to {bottom: 0; opacity: 1}
}

@-webkit-keyframes fadeIn {
    from {opacity: 0}
    to {opacity: 1}
}

@keyframes fadeIn {
    from {opacity: 0}
    to {opacity: 1}
}
</style>
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



                    <div class="col-md-6" > 
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h1 class="box-title">Weather Report</h1>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <!-- In box-tools add this button if you intend to use the contacts pane -->
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div>
                            <div class="box-body no-padding">
                                <img height="500" width="800"  src="http://121.58.193.148/repo/himawari/24hour/irbig/latestHIM_irbig.gif">
                            </div>
                        </div>
                    </div>
                        <div class="col-md-2">
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h1 class="box-title">Typhoon Level by Region</h1>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <!-- In box-tools add this button if you intend to use the contacts pane -->
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                </div>
                            </div>
                            <div class="box-body no-padding">
                               
                            </div>
                        </div>
                    </div>        
                    <!-- End of the column -->
                    <div class="col-md-12" > 
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
                                            <th></th>
                                        </tr>
                                        <tr>
                                            <td>Pest</td>
                                            <td>2016-09-28</td>
                                            <td>Pio</td>
                                            <td>12</td>
                                            <td></td>
                                            <td><button class="btn-success btn-lg" id="myBtn" style="width: 100%">Alert</button> </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                     <!-- The Modal -->
                    <div id="myModal" class="modal">
                        <!-- Modal content -->
                        <div class="modal-content">
                            <div class="modal-header">
                            <span class="close">x</span>
                            <h2 >Alert</h2>
                            </div>
                            <div class="modal-body">
                                 <div class="col-md-6">
                            <div class="box box-primary">
                                   <div class="box-body box-profile">

                                    <h3 class="profile-username text-center">Alert Message</h3>
                                        
                                    <ul class="list-group list-group-unbordered">
                                        <li class="list-group-item">
                                           <p>
                                               <input type="text" value="Please be warned that there is pest infection near your location" disabled="true" style="width: 100%"</p>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Your Message:</b> <p>
                                                <input type="text"style="width: 100%"</p>
                                        </li>
                                        <button class="btn-lg btn-primary pull-right" >Send Alert</button>
                                    </ul>

                                </div>
                                <!-- /.box-body -->
                            </div>    
                                </div>
                                <div class="col-md-6">
                            <div class="box box-primary">
                                   <div class="box-body box-profile">

                                    <h3 class="profile-username text-center">Farmers</h3>
                                        
                                    <ul class="list-group list-group-unbordered">
                                        <li class="list-group-item">
                                           <p>Farmer ABC</p>
                                        </li>
                                        <li class="list-group-item">
                                           <p>Farmer CDE</p>
                                        </li>
                                    </ul>

                                </div>
                                <!-- /.box-body -->
                            </div>    
                                </div>
                                <p>1</p>
                                <p>2</p>
                                <p>3</p>
                                
                            </div>
                        </div>
                         
                    </div>
                   </div>

                </section>
            </div>
            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    <b>Version</b> 2.3.3
                </div>
                <strong>Copyright &copy; 2014-2015 <a href="http://sra.com">Sugar Regulatory Association</a>.</strong>
            </footer>
        </div>
        <script src="plugins/jQuery/jQuery-2.2.0.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="dist/js/app.min.js"></script>
        <script>
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
    </body>
</html>
