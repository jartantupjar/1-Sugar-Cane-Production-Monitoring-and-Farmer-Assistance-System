/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.ForumDB;
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
            ForumDB fdb = new ForumDB();
            int fields_id = Integer.parseInt(request.getParameter("fields"));
            String title = request.getParameter("title");
            String lined = request.getParameter("date");
            int duration = Integer.parseInt(request.getParameter("duration"));
            
            HttpSession session = request.getSession();
            java.sql.Date dateparam = (Date) session.getAttribute("todayDate");
            
            Date rdate = Date.valueOf(lined);
            System.out.println(rdate + " BEFORE !!!!");
            try{
            java.util.Date date = new SimpleDateFormat("MM/dd/yyyy").parse(lined);
            rdate = new java.sql.Date(date.getTime());
            } catch (ParseException ex) {
            Logger.getLogger(createNewProgram.class.getName()).log(Level.SEVERE, null, ex);
            } 
            r.setRecommendation_name(request.getParameter("rec_id"));
            r.setPhase(request.getParameter("period"));
            r.setType(request.getParameter("type"));
//            String dates = request.getParameter("datepicker");
//            String datee = request.getParameter("dateend");
            r.setDescription(request.getParameter("description"));
            //  r.setConfig(Integer.parseInt(request.getParameter("config")));
            int check = recDB.addRecommendation(r);
            int check2 = 0;
            int check3 = 0;
            Enumeration<String> parameterNames = request.getParameterNames();
            String paramName;
            ArrayList<String> pT = new ArrayList<String>();
            while (parameterNames.hasMoreElements()) {
                 paramName = parameterNames.nextElement();
                 System.out.println(paramName + "parameter");
            if (paramName.startsWith("probTable1")) {
                for(int i=0;i<request.getParameterValues(paramName).length;i++){
                     pT.add(request.getParameterValues(paramName)[i]);
                 System.out.println(request.getParameterValues(paramName)[i]);
                 //connects recommendation to problem table
                 int probid = Integer.parseInt(request.getParameterValues(paramName)[i]);
                 if(probid == 0){
                 r.setImprovement("Y");
                 check3 = recDB.linkToRecoms(fields_id, check, dateparam, "Active", duration);
                }
                 else{
                  r.setImprovement("N");
                  check2 = recDB.connectRecommendationtoProblem(check,probid);
                  check3 = recDB.linkToRecoms(fields_id, check, dateparam, "Active", duration);
                 }
                    }
                }
            }
            
            System.out.println(check +"add is done");
            System.out.println(check2 +"recom to problem is done");
            System.out.println(check3 +"link to recom is done");
            if (check > 0 && check3 >0){
                fdb.updatePostRecommendations(title, fields_id, check);
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/Forum.jsp");
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
