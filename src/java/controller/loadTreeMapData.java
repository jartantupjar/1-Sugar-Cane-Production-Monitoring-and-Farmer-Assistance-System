package controller;

import db.ProductionDB;
import db.fixedRecDB;
import entity.FarmRecTable;
import entity.Recommendation;
import entity.prodMunicipality;
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

        ProductionDB proddb = new ProductionDB();
        ArrayList<prodMunicipality> list = proddb.getProdMunicipalforYear(2016);
        JSONObject data = new JSONObject();

        
for(int x=0; x<list.size(); x++){
      
       JSONObject trial = new JSONObject();
      
      for (int i = 0; i < list.get(x).getBrgy().size(); i++) {
               
                  JSONObject farm = new JSONObject();
                  
                for(int y=0; y<list.get(x).getBrgy().get(i).getFarmer().size();y++){
                   
                 farm.put(list.get(x).getBrgy().get(i).getFarmer().get(y).getName(), list.get(x).getBrgy().get(i).getFarmer().get(y).getProduction());
                }
                trial.put(list.get(x).getBrgy().get(i).getBarangay(),farm);
               
            }
      
   data.put(list.get(x).getMunicipal(),trial);
}
//        for (int x = 0; x < 3; x++) {
//            JSONObject mdata = new JSONObject();
//
//            for (int i = 0; i < 3; i++) {
//                JSONObject trial = new JSONObject();
//                for (int y = 0; y < 3; y++) {
//                    trial.put("farm" + y, y + 1);
//                }
//                mdata.put("barangay" + i, trial);
//            }
//            data.put("municipal" + x, mdata);
//
//        }

//             for (int x = 0; x < 3; x++) {
//                  JSONObject mdata = new JSONObject();
//                 
//            for (int i = 0; i < 3; i++) {
//                JSONObject trial = new JSONObject();
//                trial.put("farm1", 1);
//                trial.put("farm2", 2);
//                trial.put("farm3", 3);
//                mdata.put("barangay"+i,trial);
//            }
//             data.put("municipal"+x, mdata);
//            
//             }
  
        response.setContentType("applications/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(data.toString());
    }

}
