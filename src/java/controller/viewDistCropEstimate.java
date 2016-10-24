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
public class viewDistCropEstimate extends BaseServlet {
  @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();
        CropEstimateDB estdb = new CropEstimateDB();

        HttpSession session = request.getSession();
       
         int year = Integer.parseInt(request.getParameter("year"));

        ArrayList<cropEstimate> fct = estdb.viewDistrictEstimates(year);
        
        JSONObject data = new JSONObject();
        JSONArray list = new JSONArray();
        if (fct != null) {
            for (int i = 0; i < fct.size(); i++) {
                ArrayList<String> obj = new ArrayList<>();
                obj.add(Integer.toString(fct.get(i).getYear()));
                obj.add(fct.get(i).getWeek_ending().toString());
                obj.add(Double.toString(fct.get(i).getArea()));
                obj.add(Double.toString(fct.get(i).getActual()));
                obj.add(Double.toString(fct.get(i).getForecasted()));
                 obj.add(Double.toString(fct.get(i).getDifference())+"%");
                list.add(obj);
            }
        }
      data.put("data", list);
          response.setContentType("applications/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(data.toString());
    }

}
