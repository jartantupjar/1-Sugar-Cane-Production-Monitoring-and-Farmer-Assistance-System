
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
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          
          <!-- User Account Menu -->
          <li class="dropdown user user-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <!-- The user image in the navbar-->
              <img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs"><%= user.getFirst_name() +" "+ user.getLast_name() %></span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                <p>
                  <%= user.getFirst_name() +" "+ user.getLast_name() %>
                  <small><%= user.getGroup() %></small>
                </p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-right">
                  <a href="Logout" class="btn btn-default btn-flat">Sign out</a>
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
          <p><%= user.getFirst_name() +" "+ user.getLast_name() %>
          </p>
              <small><%= user.getGroup() %></small>
        </div>
      </div>
        
        
      <!-- /.search form -->

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu">
      <li class="header">Navigation</li>
        <li class="active"><a href="Homepage.jsp"><i class="fa fa-link"></i><span>Home</span></a></li>
        <li><a href="GetFarmersList"><i class="fa fa-link"></i><span>Farmer Assistance</span> </a></li>
        <li><a href="WeatherTrends.jsp"><i class="fa fa-link"></i><span>Weather Trends</span> </a></li>
        <li><a href="Calendar.jsp"><i class="fa fa-link"></i><span>Calendar</span> </a></li>

        <li><a href="createProject.jsp"><i class="fa fa-link"></i><span>Create Project</span></a></li>
        <li><a href="viewProjects.jsp"><i class="fa fa-link"></i><span>View Projects</span></a></li>
       
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>
