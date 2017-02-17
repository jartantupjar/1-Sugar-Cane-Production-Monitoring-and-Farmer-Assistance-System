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

        ////////////////****** TODO CHECK IF NAME IS A FARMR
//        String name = request.getParameter("name");
        CalendarDB caldb = new CalendarDB();
        CropAssessmentDB cadb = new CropAssessmentDB();
        ArrayList<entity.Calendar> calist = caldb.getCurrentYearDetails();//gets the phases/today/crop yr
        Integer cropyear = calist.get(0).getYear();
        Date todayDate = calist.get(0).getTodayDate();
        Calendar cal = caldb.getCalendarTypes(todayDate);
        ArrayList<CropAssessment> caT = cadb.getCropAssesmentRajversion(cal.getEweek(), cropyear, calist.get(0).getTodayDate().toString());
       ArrayList<CropAssessment> rain= cadb.getRainfallByDate(calist.get(0).getMondayofWeek(),calist.get(0).getSundayofWeek());
ArrayList<statusReport> srlist;
srlist=cadb.getAllStatusReports(todayDate);
        
//        statusReport sr=new statusReport();
//        sr=cadb.getStatusReportByWeek(todayDate);
        
        
        
        RequestDispatcher rd = null;
        if (caT != null) {
            session.setAttribute("CropAss", caT);
            session.setAttribute("todayYear", cropyear);
            session.setAttribute("carain", rain);
            
            session.setAttribute("statusRep",srlist);
            
//            session.setAttribute("Week_ending",calist.get(0).getSundayofWeek());

            session.setAttribute("SundayofWeek",calist.get(0).getSundayofWeek());
            session.setAttribute("MondayofWeek",calist.get(0).getMondayofWeek());
            
            rd = context.getRequestDispatcher("/createCropAssessment.jsp");
        }
        rd.forward(request, response);
        response.setCharacterEncoding("utf-8");

    }

}
