/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.FarmerDB;
import db.ProgramsDB;
import entity.Farmer;
import entity.Problems;
import entity.Programs;
import entity.programsKPI;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
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
public class viewFarmerProfile extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();

        FarmerDB farmerdb = new FarmerDB();
        HttpSession session = request.getSession();
        Farmer farmer;
        ////////////////****** TODO CHECK IF NAME IS A FARMR
        String name = request.getParameter("name");

        System.err.println("TODAYS user " + session.getAttribute("user"));
        System.err.println("TODAYS DATE " + session.getAttribute("todayDate"));
        RequestDispatcher rd;
        if (farmerdb.searchNameInMunicipal(name)) {
            rd = context.getRequestDispatcher("/viewCropEstimate.jsp");
        } else if (farmerdb.searchNameInBarangay(name)) {
            rd = context.getRequestDispatcher("/viewCropEstimate.jsp");
        } else {
            farmer = farmerdb.viewFarmerDetails(name);
            session.setAttribute("farmDet", farmer);
            session.setAttribute("farm", name);
            rd = context.getRequestDispatcher("/viewFarmerProfile.jsp");
        }
        rd.forward(request, response);
        response.setCharacterEncoding("utf-8");

    }

}
