/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.CropAssessmentDB;
import entity.CropAssessment;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ndrs
 */
public class viewCropAssessment extends BaseServlet {

   @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();
        HttpSession session = request.getSession();
   
        ////////////////****** TODO CHECK IF NAME IS A FARMR
//        String name = request.getParameter("name");
        System.err.println("TODAYS DATE " + session.getAttribute("todayDate"));
     
        String sdate= session.getAttribute("todayDate").toString();
        System.out.println(sdate);
        Date todayDate = Date.valueOf(sdate);
        
          CropAssessment ca = new CropAssessment(); //for area
          CropAssessment ca2 = new CropAssessment(); // for tons cane
          CropAssessmentDB cadb = new CropAssessmentDB();
          ArrayList<CropAssessment> caT = new ArrayList<CropAssessment>(); //the whole report itself
          ArrayList<CropAssessment> prevT = new ArrayList<CropAssessment>(); // gets the previous of area and tc
          ArrayList<CropAssessment> currT = new ArrayList<CropAssessment>(); // gets the current of area and tc
                Calendar cal = Calendar.getInstance();
                cal.setTime(todayDate);
                int week_of_year = cal.get(Calendar.WEEK_OF_YEAR);
                System.out.println(week_of_year);
                int year = cal.get(Calendar.YEAR);
                ArrayList<CropAssessment> rain = cadb.getRainFall(week_of_year,year);
                DecimalFormat df = new DecimalFormat("#.##");   
                currT = cadb.getCropAssessmentReportForTheWeek(week_of_year, year);
                prevT = cadb.getPrevCropAssessmentReportForTheWeek(week_of_year, year);
                double etc = Double.valueOf(df.format(cadb.getTotalEstimatedTonsCane(year)));
                double eah = Double.valueOf(df.format(cadb.getTotalEstimatedArea(year)));
                Date week_ending = currT.get(0).getWeek_ending();
                    ca.setParticulars("Area");
                    ca.setEstimated(eah);
                    ca.setPrevious(prevT.get(0).getPrevArea());
                    ca.setThisweek(currT.get(0).getThisArea());
                    double todate = ca.getPrevious() + ca.getThisweek();
                    ca.setTodate(todate);
                    double percenta = 0;
                    double percentb = 0;
                    percenta = Double.valueOf(df.format((ca.getTodate()/eah)*100));
                    ca.setPercent(percenta);
                    ca.setStanding(Double.valueOf(df.format(ca.getEstimated()- ca.getTodate())));
                    caT.add(ca);
                    ca2.setParticulars("Tons Cane");
                    ca2.setEstimated(etc);
                    ca2.setPrevious(prevT.get(0).getPrevTons_Cane());
                    ca2.setThisweek(currT.get(0).getThisTons_Cane());
                    double todate2 = ca2.getPrevious() +ca2.getThisweek();
                    ca2.setTodate(todate2);
                    percentb = Double.valueOf(df.format((ca2.getTodate()/etc)*100));
                    ca2.setPercent(percentb);
                    ca2.setStanding(Double.valueOf(df.format(ca2.getEstimated()- ca2.getTodate())));
                    caT.add(ca2);
                
                 RequestDispatcher rd=null;
        if (caT!=null) {
             session.setAttribute("Week_ending", week_ending);
              session.setAttribute("CropAss", caT);
               session.setAttribute("todayYear", year);
            rd = context.getRequestDispatcher("/createCropAssessment.jsp");
        }
        rd.forward(request, response);
        response.setCharacterEncoding("utf-8");

    }

}