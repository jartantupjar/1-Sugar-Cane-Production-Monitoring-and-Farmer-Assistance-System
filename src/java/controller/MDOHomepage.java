/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.CropAssessmentDB;
import entity.CropAssessment;
import entity.CropNarrative;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
 * @author Bryll Joey Delfin
 */
public class MDOHomepage extends BaseServlet {

   
    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
                        ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/Homepage.jsp");
                HttpSession session = request.getSession();
                //start of the crop assessment report
                String sdate = "2015-02-10"; // date of the login-- change this to the parameter date
                Date todayDate = Date.valueOf(sdate);
                Calendar cal = Calendar.getInstance();
                cal.setTime(todayDate);
                int week_of_year = cal.get(Calendar.WEEK_OF_YEAR);
                System.out.println(week_of_year);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                CropAssessmentDB cadb = new CropAssessmentDB();
                ArrayList<CropAssessment> rain = cadb.getRainFall(week_of_year,year);
                ArrayList<CropAssessment> caT = new ArrayList<CropAssessment>();
                caT  = cadb.getCropAssesmentRajversion(week_of_year, year);
                Date week_ending = caT.get(0).getWeek_ending();
                CropNarrative cn=null;
                if(cadb.checkExistingNarrative(year,week_ending)==true){ 
                cn=new CropNarrative();
                cn=cadb.getAssessmentNarrative(year,week_ending);
}                  
  session.setAttribute("CropAss", caT);
          session.setAttribute("narrative", cn);
         session.setAttribute("rainfall", rain);
        
    }

}
