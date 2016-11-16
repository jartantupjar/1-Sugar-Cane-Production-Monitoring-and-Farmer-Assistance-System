package controller;

import db.CalendarDB;
import db.FarmsDB;
import db.ProgramsDB;
import db.fixedRecDB;
import entity.Calendar;
import entity.Farm;
import entity.FarmRecTable;
import entity.Problems;
import entity.Programs;
import entity.Recommendation;
import entity.programsKPI;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class viewFieldDetails extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();

        ProgramsDB progdb = new ProgramsDB();
        HttpSession session = request.getSession();
        FarmsDB farmsdb=new FarmsDB();
        Farm farm;
        
         System.err.println("TODAYS user " + session.getAttribute("user"));
     
     
        int id = Integer.parseInt(request.getParameter("id"));
//            CalendarDB caldb= new CalendarDB();
//   ArrayList<Calendar> calist= caldb.getCurrentYearDetails();
//   int cropyr=calist.get(0).getYear();
        
        //added date
          farm=farmsdb.getAllFieldDetails(id);
    
      
        session.setAttribute("farm", farm);
          session.setAttribute("id", id);

        RequestDispatcher rd = context.getRequestDispatcher("/farmerComparison.jsp");

        rd.forward(request, response);

        response.setCharacterEncoding("utf-8");

    }

}
