/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.subjectiveRecDB;
import entity.Problems;
import entity.Recommendation;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class createNewRecommendation extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            Recommendation r = new Recommendation();
            subjectiveRecDB recDB = new subjectiveRecDB();
            r.setRecommendation_name(request.getParameter("recommendation_name"));
            r.setPhase(request.getParameter("period"));
            r.setType(request.getParameter("type"));
            String dates = request.getParameter("datepicker");
            String datee = request.getParameter("dateend");
            try {
                DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                java.util.Date date = new java.util.Date();
                date = formatter.parse(dates);
                java.sql.Date Sdate = new java.sql.Date(date.getTime());
                r.setDate_start(Sdate);
               // r.setDate_create(Sdate);
            } catch (ParseException ex) {
                Logger.getLogger(createNewRecommendation.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                java.util.Date datend = new java.util.Date();
                DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                datend = formatter.parse(datee);
                Date Edate = new java.sql.Date(datend.getTime());
                r.setDate_end(Edate);
                r.setTrigger_date(Edate);
            } catch (ParseException ex) {
                Logger.getLogger(createNewRecommendation.class.getName()).log(Level.SEVERE, null, ex);
            }
            r.setDescription(request.getParameter("description"));
            r.setStatus("Ongoing");
            r.setTrigger_num(10);
            int check = recDB.addRecommendation(r);
             Enumeration<String> parameterNames = request.getParameterNames();
            String paramName;
            ArrayList<String> pT = new ArrayList<String>();
            while (parameterNames.hasMoreElements()) {
                 paramName = parameterNames.nextElement();
                 System.out.println(paramName);
            if (paramName.startsWith("probid")) {
                for(int i=0;i<request.getParameterValues(paramName).length;i++){
                     pT.add(request.getParameterValues(paramName)[i]);
                 System.out.println(request.getParameterValues(paramName)[i]);
                }

        }
            }
            System.out.println(check);
            if (check == 1){
                
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/Recommendation.jsp");
                HttpSession session = request.getSession();
                rd.forward(request, response);
            }
            else {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
            }     
        }finally {
            out.close();
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
