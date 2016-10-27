/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.CropEstimateDB;
import db.ProductionDB;
import db.fixedRecDB;
import entity.FarmRecTable;
import entity.Recommendation;
import entity.cropEstimate;
import entity.municipalSummary;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author ndrs
 */
public class loadMunicSumYrsChart extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();
        ProductionDB pdb= new ProductionDB();

        HttpSession session = request.getSession();
           String mname= request.getParameter("name");
        ArrayList<municipalSummary> fct = pdb.viewMunicipalSummaryDet(mname);
        JSONObject data = new JSONObject();
     
      
        JSONArray category = new JSONArray();
        JSONArray bar = new JSONArray();
    
        if (fct != null) {
              
            for(int i = 0; i < fct.size(); i++){
                category.add(Integer.toString(fct.get(i).getYear()));
                bar.add(fct.get(i).getActual());
                
             }
            
            
        }


       data.put("categ", category);
       data.put("bar", bar);
     
        System.out.println(data);
        
        
        response.setContentType("applications/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(data.toString());
       // response.getWriter().write(data.toString());
       
    }

}
