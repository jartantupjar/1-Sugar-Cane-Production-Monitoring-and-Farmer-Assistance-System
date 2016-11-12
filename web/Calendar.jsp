<%-- 
    Document   : Calendar
    Created on : 09 19, 16, 11:24:54 PM
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
          <!-- fullCalendar 2.2.5-->
  
  <link rel="stylesheet" href="plugins/fullcalendar/fullcalendar.min.css">
  <link rel="stylesheet" href="plugins/fullcalendar/fullcalendar.print.css" media="print">
  <link rel="stylesheet" href="bootstrap/css/bootstrap-year-calendar.min.css">
  <link rel="stylesheet" href="bootstrap/css/bootstrap-year-calendar.css">
  <!-- Theme style -->


  <!-- Theme style -->

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
                    <form name="editdates" action="editDates">
                    <div class="col-md-3">
<!--          <div class="box box-solid">
            <div class="box-header with-border">
              <h4 class="box-title">Legends</h4>
            </div>
            <div class="box-body">
               the events 
              <div id="external-events">
                <div class="external-event bg-green">Milling</div>
                <div class="external-event bg-yellow">Harvesting</div>
                <div class="external-event bg-aqua">Rainfall</div>
                <div class="external-event bg-light-blue">Watering</div>
                <div class="external-event bg-red">Typhoon</div>
              </div>
            </div>
             /.box-body 
          </div>-->
          <!-- /. box -->
          <div class="box box-danger">
                            <div class="box-header with-border">
                                <h1 class="box-title">Dates</h1>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <!-- In box-tools add this button if you intend to use the contacts pane -->
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i>  </button>
                                </div>
                            </div>

                            <div class="box-body no-padding">
                                <label> Planting Phase:</label> <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" class="form-control pull-right datepicker" name="pstart" id="datepickerstart">
                                            </div> <br>
                                            <label> Planting Phase End:</label> 
                                            <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" class="form-control pull-right datepicker" name="pend" id="datepickerstart1">
                                            </div> <br>
                                <label> Germination Phase:</label> <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" class="form-control pull-right datepicker" name="gstart" id="datepickerstart">
                                            </div> <br>
                                            <label> Germination Phase End:</label> <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" class="form-control pull-right datepicker" name="gend" id="datepickerstart">
                                            </div> <br>
                                <label> Milling Phase:</label> <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" class="form-control pull-right datepicker" name="mstart" id="datepickerstart">
                                            </div>  <br>
                                            <label> Milling Phase End:</label> <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" class="form-control pull-right datepicker" name="mend" id="datepickerstart">
                                            </div> <br>
                                <label> Tillering Phase:</label> <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" class="form-control pull-right datepicker" name="tstart" id="datepickerstart">
                                            </div>  <br>
                                            <label> Tillering Phase End:</label> <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" class="form-control pull-right datepicker" name="tend" id="datepickerstart">
                                            </div> <br>
                                <label>Stalk Elongation Phase:</label> <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" class="form-control pull-right datepicker" name="sstart" id="datepickerstart">
                                            </div>  <br>
                                            <label> Stalk Elongation Phase End:</label> <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" class="form-control pull-right datepicker" name="send" id="datepickerstart">
                                            </div> <br>
                                <label> Yield Formation Phase:</label> <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" class="form-control pull-right datepicker" name="ystart" id="datepickerstart">
                                            </div>  <br>
                                            <label> Yield Formation Phase End:</label> <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" class="form-control pull-right datepicker" name="yend" id="datepickerstart">
                                            </div> <br>
                                </div>
                            </div>
          <button class="btn btn-app btn-linkedin btn-lg pull-right" type="submit">
                                            <i class="fa fa-edit"></i> Edit dates
                                        </button>
            </div>
                    </form>
                        <div class="col-md-9" > 
                            <div class="box box-info">
                                <div class="box-header with-border">
                                    <h1 class="box-title">Calendar</h1>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        <!-- In box-tools add this button if you intend to use the contacts pane -->
                                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>

                            <div class="box-body no-padding">
                                <div id="calendar"></div>
                            </div>
                        </div>
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h1 class="box-title">Recommendations</h1>
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
                                            <th>Recommendation</th>
                                            <th>Description</th>
                                            <th>Config</th>
                                            <th>Period/Phase</th>
                                        </tr>
                                        <tr>	
                                            <td>Recommended furrow distance</td>
                                            <td>Farmers are recommended to have 1.5 meters of furrow distance</td>
                                            <td> <input type="text" value="1.5 meters"</td>
                                            <td>Planting Phase</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>        
                    <br>
                </section>

            </div>
            <footer class="main-footer">

                <div class="pull-right hidden-xs">
                    <b>Version</b> 2.3.3
                </div>
                <strong>Copyright &copy; 2014-2015 <a href="http://sra.com">Sugar Regulatory Association</a>.</strong>
            </footer>
        </div>
        <!-- jQuery 2.2.0 -->
<script src="plugins/jQuery/jQuery-2.2.0.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- Bootstrap Calendar -->
<script src="bootstrap/js/bootstrap-year-calendar.js"></script>


<!-- Bootstrap Calendar -->
<script src="bootstrap/js/bootstrap-year-calendar.min.js"></script>

<!-- jQuery UI 1.11.4 -->
<script src="plugins/jQueryUI/jquery-ui.min.js"></script>
<!-- Slimscroll -->
<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
<!-- fullCalendar 2.2.5 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="plugins/fullcalendar/fullcalendar.min.js"></script>
<script src="plugins/datepicker/bootstrap-datepicker.js"></script>
        <script>
            $(function () {
                $('.datepicker').datepicker({
                    autoclose: true
                });


            });
        </script>
<!-- Page specific script -->
 
<script>
         $(function() {
    var currentYear = new Date().getFullYear();
    $.ajax({
        url:"viewCalendar",
        type:"POST",
        dataType:"JSON",
        success: function(data){
            $('#calendar').calendar({ 
                
        enableContextMenu: true,
        enableRangeSelection: true,
        mouseOnDay: function(e) {
            if(e.events.length > 0) {
                var content = '';
                
                for(var i in e.events) {
                    content += '<div class="event-tooltip-content">'
                                    + '<div class="event-name" style="color:' + e.events[i].color + '">' + e.events[i].name + '</div>'
                                + '</div>';
                }
            
                $(e.element).popover({ 
                    trigger: 'manual',
                    container: 'body',
                    html:true,
                    content: content
                });
                
                $(e.element).popover('show');
            }
        },
        mouseOutDay: function(e) {
            if(e.events.length > 0) {
                $(e.element).popover('hide');
            }
        },
        dayContextMenu: function(e) {
            $(e.element).popover('hide');
        },
        dataSource: data
    });
        }
    });
    
});
</script>

        <script>
  $(function () {
   
    /* initialize the external events
     -----------------------------------------------------------------*/
    function ini_events(ele) {
      ele.each(function () {

        // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
        // it doesn't need to have a start or end
        var eventObject = {
          title: $.trim($(this).text()) // use the element's text as the event title
        };

        // store the Event Object in the DOM element so we can get to it later
        $(this).data('eventObject', eventObject);

        

      });
    }

    ini_events($('#external-events div.external-event'));

  });
</script>
    </body>
</html>
