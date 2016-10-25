/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.CropEstimateDB;
import db.fixedRecDB;
import entity.FarmRecTable;
import entity.Recommendation;
import entity.cropEstimate;
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
public class loadEstimatesLineData extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();
        CropEstimateDB estdb = new CropEstimateDB();

        HttpSession session = request.getSession();

        ArrayList<cropEstimate> fct = estdb.viewAllDiffEstimates();
        JSONObject data = new JSONObject();
     
      
        JSONArray category = new JSONArray();
        JSONArray bar = new JSONArray();
        JSONArray est1 = new JSONArray();
        JSONArray est2 = new JSONArray();
        JSONArray est3 = new JSONArray();

        if (fct != null) {
            for(int i = 0; i < fct.size(); i++){
                category.add(fct.get(i).getYear());
                bar.add(fct.get(i).getActual());
                est1.add(fct.get(i).getForecasted());
                est2.add(fct.get(i).getForecast2());
                est3.add(fct.get(i).getForecast3());
            }
            
            
        }


        data.put("categ", category);
        data.put("bard", bar);
        data.put("estd", est1);
        data.put("est2d", est2);
        data.put("est3d", est3);
        
        
        
        response.setContentType("applications/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(data.toString());
       // response.getWriter().write(data.toString());
       
    }

}
