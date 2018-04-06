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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
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
public class viewLkgTestEstimates extends BaseServlet {
  @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();
        CropEstimateDB estdb = new CropEstimateDB();

        HttpSession session = request.getSession();
       
      

        ArrayList<cropEstimate> fct = estdb.viewLkgTestEstimates();
        if (fct != null) {
            for (int i = 0; i < fct.size(); i++) {
                List<Double> doublist = new ArrayList<>();
                doublist.add(fct.get(i).getForecastlkg());
                doublist.add(fct.get(i).getForecastlkg2());
                doublist.add(fct.get(i).getForecastlkg3());
                fct.get(i).setClosest(estdb.closest(fct.get(i).getLkg(), doublist));
            }
        }
        
        JSONObject data = new JSONObject();
        JSONArray list = new JSONArray();
        DecimalFormat commaformat = new DecimalFormat("#.00");
                commaformat.setGroupingUsed(true);
                commaformat.setGroupingSize(3);
        if (fct != null) {
            for (int i = 0; i < fct.size(); i++) {
                ArrayList<String> obj = new ArrayList<>();
                obj.add(commaformat.format(fct.get(i).getArea()));
                obj.add(Double.toString(fct.get(i).getRainfall()));
                obj.add(commaformat.format(fct.get(i).getActual()));
                obj.add(commaformat.format(fct.get(i).getLkg()));
                obj.add(commaformat.format(fct.get(i).getForecastlkg()));
                obj.add(commaformat.format(fct.get(i).getForecastlkg2()));
                obj.add(commaformat.format(fct.get(i).getForecastlkg3()));
                obj.add(Integer.toString(fct.get(i).getId()));
                obj.add(commaformat.format(fct.get(i).getClosest()));
                list.add(obj);
            }
        }
      data.put("data", list);
          response.setContentType("applications/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(data.toString());
    }

}
