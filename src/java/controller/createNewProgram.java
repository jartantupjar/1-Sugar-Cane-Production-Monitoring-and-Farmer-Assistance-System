/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import db.ProgramsDB;
import entity.Programs;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
public class createNewProgram extends BaseServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       
        PrintWriter out = response.getWriter();
            
                
            Programs newProg = new Programs();
            ProgramsDB progdb = new ProgramsDB();
            
              Enumeration<String> parameterNames = request.getParameterNames();
              
              
         
            newProg.setProg_name(request.getParameter("projectname"));
           
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
       try {
           System.out.println(request.getParameter("datepickerstart"));
           System.out.println(request.getParameter("todayDate")+"TODAYS DATE");
       Date dateinitial= (Date) sdf.parse(request.getParameter("datepickerstart"));
       System.out.println(dateinitial);
        newProg.setDate_initial(dateinitial);
       } catch (ParseException ex) {
           Logger.getLogger(createNewProgram.class.getName()).log(Level.SEVERE, null, ex);
       }
            
            java.sql.Date datecreated = Date.valueOf(request.getParameter("todayDate"));
            
            
            Date dateended = Date.valueOf(request.getParameter("datepickerend"));
            newProg.setDate_created(datecreated);
           
            newProg.setDate_end(dateended);
            newProg.setDescription(request.getParameter("Description"));
            newProg.setType("P");
            
            
            String paramName;
          ArrayList<String>farmlist =new ArrayList<String>();
          ArrayList<String>problist =new ArrayList<String>();
          
           while (parameterNames.hasMoreElements()) {
            paramName = parameterNames.nextElement();
            //System.out.println(paramName);
            if (paramName.substring(0, 2).equals("id")) {
                for(int i=0;i<request.getParameterValues(paramName).length;i++){
                     farmlist.add(request.getParameterValues(paramName)[i]);
                 System.out.println(request.getParameterValues(paramName)[i]);
                }
            } 
            else if (paramName.substring(0, 6).equals("probid")) {
                for(int i=0;i<request.getParameterValues(paramName).length;i++){
                     problist.add(request.getParameterValues(paramName)[i]);
                 System.out.println(request.getParameterValues(paramName)[i]);
                }

        }
           }
            boolean test = progdb.createNewProgram(newProg);
            

            if(test){
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/viewProjects.jsp");
                rd.forward(request, response);
            }
            else{
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/Homepage.jsp");
                rd.forward(request, response);
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
