package controller;

import db.ProductionDB;
import db.fixedRecDB;
import entity.FarmRecTable;
import entity.Recommendation;
import entity.brgySummary;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class viewBrgyMuniTable extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();
       

        HttpSession session = request.getSession();
    ProductionDB prodb= new ProductionDB();
      String muni= request.getParameter("name");

        ArrayList<brgySummary> fct = prodb.viewBrgyMuniTable(muni,2015);
        
        JSONObject data = new JSONObject();
        JSONArray list = new JSONArray();
        if (fct != null) {
            for (int i = 0; i < fct.size(); i++) {
                ArrayList<String> obj = new ArrayList<>();
                obj.add(fct.get(i).getBarangay());
                obj.add(Integer.toString(fct.get(i).getTfarmers()));
                obj.add(Integer.toString(fct.get(i).getYear()));
                obj.add(Double.toString(fct.get(i).getArea()));
                obj.add(Double.toString(fct.get(i).getActual()));
//                obj.add(Double.toString(fct.get(i).getYield()));
                obj.add(fct.get(i).getBarangay());
                 list.add(obj);
            }
        }
      data.put("data", list);
          response.setContentType("applications/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(data.toString());
    }

}
