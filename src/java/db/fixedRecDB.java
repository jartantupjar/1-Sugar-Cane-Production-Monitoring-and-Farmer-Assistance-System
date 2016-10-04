/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.FarmRecTable;
import entity.Recommendation;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public ArrayList<FarmRecTable> viewFarmRecTable(int id) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select * from `recommendations-farmers` sf join fields f on sf.farmers_name=f.farmers_name where sf.recommendations_id= ?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<FarmRecTable> list = null;
            FarmRecTable r;
            if (rs.next()) {
                list = new ArrayList<FarmRecTable>();
                do {

                    r = new FarmRecTable();
                    r.setId(rs.getInt("Recommendations_id"));
                    r.setName(rs.getString("Farmers_name"));
                    r.setBrgy(rs.getString("barangay"));
                    r.setMunicipality(rs.getString("municipality"));
                   // r.setDate_updated(2014-2-2);
                    r.setApproved(rs.getString("Y"));
                   
                    list.add(r);
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();

            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Recommendation viewRecDetails(int id) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select * from sra.recommendations sr where sr.id=? ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            Recommendation r = new Recommendation();
            if (rs.next()) {
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

            }
            rs.close();
            pstmt.close();
            conn.close();

            return r;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
