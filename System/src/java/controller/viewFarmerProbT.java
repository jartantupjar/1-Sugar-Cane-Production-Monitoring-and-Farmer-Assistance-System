package controller;

import db.FarmerDB;
import db.fixedRecDB;
import entity.FarmRecTable;
import entity.Problems;
import entity.Recommendation;
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

public class viewFarmerProbT extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();
        FarmerDB farmerDB = new FarmerDB();

        HttpSession session = request.getSession();
       // Recommendation rec = new Recommendation();
      String name=request.getParameter("name");
System.out.println(name+"farmers name");
        ArrayList<Problems> rec = farmerDB.viewFarmerProb(name);
//        System.out.println(rec.get(0).getProb_name()+"PROB 0 name");
        JSONObject data = new JSONObject();
        JSONArray list = new JSONArray();
        if (rec != null) {
            for (int i = 0; i < rec.size(); i++) {
                ArrayList<String> obj = new ArrayList<>();
                obj.add(rec.get(i).getProb_name());
                obj.add(rec.get(i).getProb_details());
                obj.add(Integer.toString(rec.get(i).getProb_id()));
              
                list.add(obj);
            }
        }
      data.put("data", list);
          response.setContentType("applications/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(data.toString());
    }

}
