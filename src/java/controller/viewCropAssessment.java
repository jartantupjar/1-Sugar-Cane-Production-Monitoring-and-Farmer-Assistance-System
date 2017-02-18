/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.CalendarDB;
import db.CropAssessmentDB;
import entity.CropAssessment;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import entity.Calendar;
import entity.statusReport;
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
        CalendarDB caldb = new CalendarDB();
        CropAssessmentDB cadb = new CropAssessmentDB();
        
        //INITIALIZATION OF VALUES;
       RequestDispatcher rd = null;
        
// *** FROM THE SELECTED PARAMETER
        String theweek = request.getParameter("theweek");
        String toprint = request.getParameter("toprint");
        Boolean print=false;
        if(toprint!=null){
           session.setAttribute("printca", true );
        }else{
             session.setAttribute("printca", null);
        }
            
        if (theweek != null) {
            Date thisweek = Date.valueOf(theweek);
            entity.Calendar weekcal = caldb.getInitialCurrentYearDetails(thisweek);//gets the phases/today/crop yr
            Calendar cal = caldb.getCalendarTypes(thisweek);
            System.out.println(cal.getEweek());
            System.out.println(weekcal.getYear());
            System.out.println(cal.getEweek());
            System.out.println(weekcal.getTodayDate());
            ArrayList<CropAssessment> caT = cadb.getCropAssesmentRajversion(cal.getEweek(), weekcal.getYear(), thisweek.toString());
          Calendar daweek= caldb.getDateWeekDetails(thisweek);
            ArrayList<CropAssessment> rain = cadb.getRainfallByDate(daweek.getMondayofWeek(), daweek.getSundayofWeek());
          ArrayList<statusReport> srlist = cadb.getAllStatusReports(thisweek);
          
            if (caT != null) {
            session.setAttribute("CropAss", caT);
            session.setAttribute("cayear", weekcal.getYear());
            session.setAttribute("carain", rain);

            session.setAttribute("statusRep", srlist);

//            session.setAttribute("Week_ending",calist.get(0).getSundayofWeek());
            session.setAttribute("SundayofWeek", daweek.getSundayofWeek());
            session.setAttribute("MondayofWeek", daweek.getMondayofWeek());

            rd = context.getRequestDispatcher("/createCropAssessment.jsp");
        }
          
          
        } else {
// *** FROM THIS WEEK
        ArrayList<entity.Calendar> calist = caldb.getCurrentYearDetails();//gets the phases/today/crop yr

        Integer cropyear = calist.get(0).getYear();
        Date todayDate = calist.get(0).getTodayDate();

        Calendar cal = caldb.getCalendarTypes(todayDate);
        ArrayList<CropAssessment> caT = cadb.getCropAssesmentRajversion(cal.getEweek(), cropyear, calist.get(0).getTodayDate().toString());
        ArrayList<CropAssessment> rain = cadb.getRainfallByDate(calist.get(0).getMondayofWeek(), calist.get(0).getSundayofWeek());
        ArrayList<statusReport> srlist;
        srlist = cadb.getAllStatusReports(todayDate);
        
          if (caT != null) {
            session.setAttribute("CropAss", caT);
            session.setAttribute("cayear", cropyear);
            session.setAttribute("carain", rain);

            session.setAttribute("statusRep", srlist);

//            session.setAttribute("Week_ending",calist.get(0).getSundayofWeek());
            session.setAttribute("SundayofWeek", calist.get(0).getSundayofWeek());
            session.setAttribute("MondayofWeek", calist.get(0).getMondayofWeek());

            rd = context.getRequestDispatcher("/createCropAssessment.jsp");
        }
}
//        statusReport sr=new statusReport();
//        sr=cadb.getStatusReportByWeek(todayDate);
     
      
        rd.forward(request, response);
        response.setCharacterEncoding("utf-8");

    }

}
