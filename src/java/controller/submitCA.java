/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.CropAssessmentDB;
import entity.CropNarrative;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
public class submitCA extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
      response.setContentType("text/html;charset=UTF-8");
      
       HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            CropAssessmentDB cadb=new CropAssessmentDB();
            CropNarrative cn= new CropNarrative();
             String sdate= session.getAttribute("todayDate").toString();
             String cropyear= request.getParameter("cropyear");
           String weekending= request.getParameter("weekending");
          
           String dweather = request.getParameter("dweather");
           String dprice = request.getParameter("dprice");
           String dmill = request.getParameter("dmill");
           String dinput = request.getParameter("dinput");
           String dother = request.getParameter("dother");
           String danalysis = request.getParameter("danalysis");
             Date weeke = Date.valueOf(weekending);
           cn.setWeekending(weeke);
           cn.setYear(Integer.parseInt(cropyear));
           cn.setDweather(dweather);
           cn.setDprice(dprice);
           cn.setDmill(dmill);
           cn.setDinput(dinput);
           cn.setDother(dother);
           cn.setDanalysis(danalysis);
    
           
         
         boolean check=cadb.submitNarrative(cn);
          
          
            if(check){
             
               
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/Homepage.jsp");
               
                rd.forward(request, response);
            }
            else{
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/viewCropEstimate.jsp");
                rd.forward(request, response);
            }
        }
    
    }

}
