package controller;

import db.fixedRecDB;
import entity.FarmRecTable;
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

public class loadTreeMapData extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();
        fixedRecDB recdb = new fixedRecDB();

        HttpSession session = request.getSession();
        Recommendation rec = new Recommendation();
      

        ArrayList<FarmRecTable> fct=new ArrayList() ;
      //ArrayList<FarmRecTable>   fct= recdb.viewFarmRecTable(Integer.parseInt(request.getParameter("1")));
             JSONObject fdata = new JSONObject();
        JSONObject data = new JSONObject();
        JSONArray list = new JSONArray();

      
             for (int x = 0; x < 3; x++) {
                  JSONObject mdata = new JSONObject();
                 
            for (int i = 0; i < 3; i++) {
                JSONObject trial = new JSONObject();
                trial.put("farm1", 1);
                trial.put("farm2", 2);
                trial.put("farm3", 3);
                mdata.put("barangay"+i,trial);
            }
             data.put("municipal"+x, mdata);
            
             }
        System.out.println(data.toString());
      //data.put("data", list);
          response.setContentType("applications/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(data.toString());
    }

}
