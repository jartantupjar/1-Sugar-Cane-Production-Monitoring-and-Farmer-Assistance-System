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
        ArrayList<prodMunicipality> list = proddb.getProdMunicipalforYear(2015);
        JSONObject data = new JSONObject();

        
        for (prodMunicipality list1 : list) {
            JSONObject trial = new JSONObject();
            for (int i = 0; i < list1.getBrgy().size(); i++) {
                JSONObject farm = new JSONObject();
                for (int y = 0; y < list1.getBrgy().get(i).getFarmer().size(); y++) {
                    farm.put(list1.getBrgy().get(i).getFarmer().get(y).getName(), list1.getBrgy().get(i).getFarmer().get(y).getProduction());
                }
                trial.put(list1.getBrgy().get(i).getBarangay(), farm);
            }
            data.put(list1.getMunicipal(), trial);
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
