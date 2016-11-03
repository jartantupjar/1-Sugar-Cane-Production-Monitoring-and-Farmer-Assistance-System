/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.CalendarDB;
import entity.Calendar;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Bryll Joey Delfin
 */
public class viewCalendar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Calendar c = new Calendar();
            CalendarDB cdb = new CalendarDB();
            ArrayList<Calendar> cT = new ArrayList<Calendar>();
            cT = cdb.getCaledarInputs();
            JSONArray calendar = new JSONArray();
            JSONObject cal = new JSONObject();
            JSONObject phase = new JSONObject();
            JSONObject days = new JSONObject();
            JSONArray clist = new JSONArray();
            JSONArray plist = new JSONArray();
            if(cT != null){
                for(int i=0;i<cT.size();i++){
                    days = new JSONObject();
                    days.put("id", i);
                    days.put("name", cT.get(i).getPhase());
                    days.put("startDate", cT.get(i).getStarting().getTime());
                    days.put("endDate", cT.get(i).getEnding().getTime());
                    calendar.add(days);
                }
            }
            System.out.println(calendar);
            //cal.put("calendar", calendar);
            response.setContentType("applications/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(calendar.toString());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
