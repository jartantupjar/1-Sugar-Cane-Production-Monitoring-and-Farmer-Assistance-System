<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<header class="main-header">

    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="font-awesome-4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="ionicons-2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
    <link rel="stylesheet" href="plugins/poptest/popover-min.css">

    <!-- Logo -->
    <a href="index2.html" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><img src="res/sra-logo.png" width="50"></span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg">SRA	</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>
        <a  class="btn-btn-success pull-left" onClick="history.go(-1);return true;" role="button" style="color: #3c8dbc; background-color: white; padding-bottom:10px; padding-top:12px; padding-right:7px;  padding-left:7px;">
            <span class="fa fa-chevron-left fa-2x"></span>
        </a>

        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">

            <!-- timeline time label -->


            <ul class="nav navbar-nav">

                <!-- timeline time label -->

                <li class="time-label text-center">
                    <a class="user-menu text-center">
                        Today is 
                        <c:out value="${todayDate}"></c:out> 
                        </a>
                    </li>

                <c:if test="${not empty todayPhases}">
                    <c:forEach items="${todayPhases}" var="phase" varStatus="loop" >

                        <li class="time-label text-center">

                            <a class="user-menu text-center">
                                <c:if test="${loop.index>0}">and </c:if>
                                <c:out value="${phase.phase}"></c:out> 
                                Period of Crop Year <c:out value="${phase.year}"></c:out> 
                                </a>   
                            </li>
                    </c:forEach>
                </c:if> 




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
                                    <form action="Login" method="Post">
                                        <input class="btn btn-default btn-flat" type="submit" value="Logout">
                                    </form>
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
                    <p><c:out value="${user.name}"></c:out></p>
                <a href="#"><i class="fa fa-circle text-success"></i>${user.group}</a>

            </div>
        </div>


        <!-- /.search form -->

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu">
            <li class="header">Navigation</li>

            <li class="active"><a href="MDOHomepage"><i class="fa fa-dashboard"></i><span>Home</span></a></li>
            <li class=""><a href="Disaster Report.jsp"><i class="fa fa-bell"></i><span>Alerts</span></a></li>
            <li><a href="WeatherReport.jsp"><i class="fa fa-cloud"></i><span>Weather Report</span> </a></li>
            <li><a href="WeatherTrends.jsp"><i class="fa fa-bar-chart"></i><span>Weather Trends</span> </a></li>
            <li><a href="Forum.jsp"><i class="fa fa-comments"></i><span>Forum</span></a></li>
            <li><a href="Recommendations.jsp"><i class="fa fa-check"></i><span>Recommendations</span></a></li>
            <li><a href="Problems.jsp"><i class="fa fa-exclamation-triangle"></i><span>Problems</span></a></li>
            <li><a href="createNewRecommendation.jsp"><i class="fa fa-plus"></i><span>Create Recommendations</span></a></li>
            <li><a href="viewPhasesDates"><i class="fa fa-calendar"></i><span>Calendar</span> </a></li>
            <li><a href="viewCropEstimate"><i class="fa fa-bar-chart"></i><span>Crop Estimate (Options)</span></a></li>
            <li><a href="viewPrograms.jsp"><i class="fa fa-eye"></i><span>View Programs</span></a></li>
            <li><a href="searchFarmer.jsp"><i class="fa fa-search"></i><span>Search Farmer</span></a></li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-file"></i> <span>Reports</span> <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu" style="display: none;">
                    <li><a href="cropAssessmentList.jsp"><i class="fa fa-file"></i><span>Crop Assessment Reports</span></a></li>
                    <li><a href="thereports.jsp"><i class="fa fa-file-o"></i><span>Year Report</span></a></li>
                </ul>
            </li>

        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>
