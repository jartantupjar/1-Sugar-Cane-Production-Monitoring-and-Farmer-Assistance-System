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
                DecimalFormat cf = new DecimalFormat("#.##");
                cf.setGroupingSize(3);
                cf.setGroupingUsed(true);
                currT = cadb.getCropAssessmentReportForTheWeek(week_of_year, year, todayDate.toString());
                prevT = cadb.getPrevCropAssessmentReportForTheWeek(week_of_year, year, todayDate.toString());
                double etc = Double.valueOf(df.format(cadb.getTotalEstimatedTonsCane(year)));
                double eah = Double.valueOf(df.format(cadb.getTotalEstimatedArea(year)));
                Date week_ending = currT.get(0).getWeek_ending();
                    ca.setParticulars("Area");
                    String ea = cf.format(eah);
                    ca.setEstimated(ea);
                    String pa = cf.format(prevT.get(0).getPrevArea());
                    ca.setPrevious(pa);
                    String cura = cf.format(currT.get(0).getThisArea());
                    ca.setThisweek(cura);
                    double todate = prevT.get(0).getPrevArea() +currT.get(0).getThisArea();
                    ca.setTodate(cf.format(todate));
                    Double percenta = 0.00;
                    Double percentb = 0.00;
                    percenta = Double.valueOf(df.format((todate/eah)*100));
                    ca.setPercent(percenta.toString());
                    String sta = cf.format(Double.valueOf(df.format(eah- todate)));
                    ca.setStanding(sta);
                    caT.add(ca);
                    ca2.setParticulars("Tons Cane");
                    String ec = cf.format(etc);
                    ca2.setEstimated(ec);
                    String pc = cf.format(prevT.get(0).getPrevTons_Cane());
                    ca2.setPrevious(pc);
                    String cc = cf.format(currT.get(0).getThisTons_Cane());
                    ca2.setThisweek(cc);
                    double todate2 = prevT.get(0).getPrevTons_Cane() +currT.get(0).getThisTons_Cane();
                    ca2.setTodate(cf.format(todate2));
                    percentb = Double.valueOf(df.format((todate2/etc)*100));
                    ca2.setPercent(percentb.toString());
                    String sc = cf.format(Double.valueOf(df.format(etc-todate2)));
                    ca2.setStanding(sc);
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