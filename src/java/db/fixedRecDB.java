/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Recommendation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ndrs
 */
public class fixedRecDB {

    public ArrayList<Recommendation> viewRecList() {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select * from sra.recommendations;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Recommendation> list = null;
            Recommendation r;
            if (rs.next()) {
                list = new ArrayList<Recommendation>();
                do {

                    r = new Recommendation();
                    r.setId(rs.getInt("id"));
                    r.setRecommendation_name(rs.getString("recommendation"));
                    r.setType(rs.getString("type"));
                    r.setDescription(rs.getString("description"));
                    r.setStatus(rs.getString("status"));
                    r.setDate_create(rs.getDate("date_created"));
                    r.setDate_start(rs.getDate("date_start"));
                    r.setDate_end(rs.getDate("date_end"));
                    r.setPhase(rs.getString("phase"));
                    r.setTrigger_date(rs.getDate("trigger_date"));
                    r.setTrigger_num(rs.getDouble("trigger_num"));
                    list.add(r);
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            conn.close();

            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
