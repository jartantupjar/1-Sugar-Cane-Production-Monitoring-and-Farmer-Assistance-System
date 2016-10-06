<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="main-header">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
           <link rel="stylesheet" href="font-awesome-4.6.3/css/font-awesome.min.css">
 <link rel="stylesheet" href="ionicons-2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
        <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
 
    <!-- Logo -->
    <a href="index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><img src="res/sra-logo.png" width="50px"></img></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg">SRA	</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
          
            <!-- timeline time label -->
           
          
        <ul class="nav navbar-nav">
         
            <!-- timeline time label -->
        
          
              <li class="time-label text-center">
                  <a class="bg-purple text-center">
                  <c:set var="todayDate" scope="session" value="10 Feb. 2014"/>
                  <c:out value="${todayDate}">${todayDate}</c:out> 
                  </a>
            </li>
         
            <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
              <img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs">  <c:out value="${user.name}"></c:out></span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                 <p>
              <c:out value="${user.name}"></c:out>
                  <small>  <c:out value="${user.group}"></c:out></small>
                </p>
              </li>
              <!-- Menu Body -->
              
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                  <a href="#" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
          
        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- Sidebar user panel (optional) -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
        <p><c:out value="${user.name}"></c:out>
          </p>
              <small><c:out value="${user.group}"></c:out></small>
        </div>
      </div>
        
        
      <!-- /.search form -->

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu">
      <li class="header">Navigation</li>
      <li class="treeview">
          <a href="#">
            <i class="fa fa-share"></i> <span>MDO</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu" style="display: none;">
           <li class="active"><a href="Homepage.jsp"><i class="fa fa-link"></i><span>Home</span></a></li>
           <li class="active"><a href="Disaster Report.jsp"><i class="fa fa-link"></i><span>Alerts</span></a></li>
           <li><a href="WeatherReport.jsp"><i class="fa fa-link"></i><span>Weather Report</span> </a></li>
           <li><a href="WeatherTrends.jsp"><i class="fa fa-link"></i><span>Weather Trends</span> </a></li>
           <li><a href="Forum.jsp"><i class="fa fa-link"></i><span>Forum</span></a></li>
           <li><a href="Recommendations.jsp"><i class="fa fa-link"></i><span>Recommendations</span></a></li>
           <li><a href="Problems.jsp"><i class="fa fa-link"></i><span>Problems</span></a></li>
           <li><a href="createNewRecommendation.jsp"><i class="fa fa-link"></i><span>Create Recommendations</span></a></li>
           <li><a href="Calendar.jsp"><i class="fa fa-link"></i><span>Calendar</span> </a></li>
           <li><a href="farmerComparison.jsp"><i class="fa fa-link"></i><span>Farm Observation</span></a></li>
           <li><a href="viewCropEstimate.jsp"><i class="fa fa-link"></i><span>Crop Estimate (Options)</span></a></li>
           <li><a href="viewProjects.jsp"><i class="fa fa-link"></i><span>View Programs List</span></a></li>
           <li><a href="viewProjectDetails.jsp"><i class="fa fa-link"></i><span>Program Details</span></a></li>
           <li><a href="viewFarmerProfile.jsp"><i class="fa fa-link"></i><span>Farmer Profile</span></a></li>
          </ul>
        </li>   
        <li class="treeview">
          <a href="#">
            <i class="fa fa-share"></i> <span>Board</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu" style="display: none;">
           <li class="active"><a href="#"><i class="fa fa-link"></i><span>Weekly Statistics</span></a></li>
           <li><a href="#"><i class="fa fa-link"></i><span>Pampanga Performance (Summary)</span> </a></li>
           <li><a href="#"><i class="fa fa-link"></i><span>Weather Trends</span> </a></li>
           <li><a href="Problems.jsp"><i class="fa fa-link"></i><span>Problems (Reoccuring)</span></a></li>
           <li><a href="Calendar.jsp"><i class="fa fa-link"></i><span>Calendar</span> </a></li>
           <li><a href="farmerComparison.jsp"><i class="fa fa-link"></i><span>Farm Observation</span></a></li>
           <li><a href="viewCropEstimate.jsp"><i class="fa fa-link"></i><span>Crop Estimate</span></a></li>
           <li><a href="viewProjects.jsp"><i class="fa fa-link"></i><span>View Projects List</span></a></li>
           <li><a href="viewProjectDetails.jsp"><i class="fa fa-link"></i><span>Program Details</span></a></li>
           <li><a href="createProject.jsp"><i class="fa fa-link"></i><span>Create Plans and Programs</span></a></li>
          </ul>
        </li> 
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>
