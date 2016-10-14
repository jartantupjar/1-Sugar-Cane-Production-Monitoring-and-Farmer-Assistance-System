package controller;

import db.FarmerDB;
import db.FarmsDB;
import db.fixedRecDB;
import entity.Farm;
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

public class viewFarmersFieldTable extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();
        FarmsDB farmdb = new FarmsDB();

        HttpSession session = request.getSession();
        // Recommendation rec = new Recommendation();
        String name = request.getParameter("name");

        ArrayList<Farm> farms = farmdb.getFarmerFieldsTable(name);

        JSONObject data = new JSONObject();
        JSONArray list = new JSONArray();
        if (farms != null) {
            for (int i = 0; i < farms.size(); i++) {
                ArrayList<String> obj = new ArrayList<>();
                obj.add(Integer.toString(farms.get(i).getId()));
                obj.add(farms.get(i).getBarangay());
                obj.add(farms.get(i).getMunicipality());
                 obj.add("2015-11-12");
                obj.add(Double.toString(farms.get(i).getArea()));
                obj.add(Double.toString(42.79));
                obj.add(Double.toString(12));
                obj.add("TPEH43");
                obj.add(Integer.toString(farms.get(i).getId()));
                list.add(obj);
            }
        }
        data.put("data", list);
        response.setContentType("applications/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(data.toString());
    }

}
