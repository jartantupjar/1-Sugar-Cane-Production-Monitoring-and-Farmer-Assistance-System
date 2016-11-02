/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.FarmRecTable;
import entity.Problems;
import entity.Recommendation;
import static java.lang.Math.random;
import java.sql.Connection;
import java.sql.Date;
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
            String query = "select * from recommendations;";
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
                    r.setStatus(rs.getString("improvement"));
//                    r.setDate_create(rs.getDate("date_created"));
//                    r.setDate_start(rs.getDate("date_start"));
//                    r.setDate_end(rs.getDate("date_end"));
                    r.setPhase(rs.getString("phase"));
//                    r.setTrigger_date(rs.getDate("trigger_date"));
//                    r.setTrigger_num(rs.getDouble("trigger_num"));
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
    public int linktoRecommendation(Integer field_id, Integer recomid, Date date, String status) {
        try {
            // put functions here : previous week production, this week production
            int i = 0;
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into `recommendations-fields`(Recommendations_id,Fields_id,status,date) values(?,?,?,?);";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, recomid);
            pstmt.setInt(2, field_id);
            pstmt.setDate(4, date);
            pstmt.setString(3, status);
            i = pstmt.executeUpdate();
            System.out.println(i + "LINKING DONE");
            pstmt.close();
            conn.close();
            return i;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(subjectiveRecDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public ArrayList<Recommendation> viewWeatherRecList() {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select * from recommendations where type = 'Weather' ;";
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
                    r.setStatus(rs.getString("improvement"));
//                    r.setDate_create(rs.getDate("date_created"));
//                    r.setDate_start(rs.getDate("date_start"));
//                    r.setDate_end(rs.getDate("date_end"));
                    r.setPhase(rs.getString("phase"));
//                    r.setTrigger_date(rs.getDate("trigger_date"));
//                    r.setTrigger_num(rs.getDouble("trigger_num"));
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
    
    public ArrayList<Recommendation> viewProblemTableList() {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT r.id, r.recommendation,count(rf.Recommendations_id) as counter, r.description from recommendations r join `recommendations-fields` rf on r.id = rf.Recommendations_id group by r.id;;";
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
                    r.setCounter(rs.getInt("counter"));
                    r.setDescription(rs.getString("description"));
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
            String query = "select id,farmers_name,barangay,municipality,date,status from `recommendations-fields` rf join fields f on rf.fields_id=f.id where rf.recommendations_id=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<FarmRecTable> list = null;
            FarmRecTable r;
            if (rs.next()) {
                list = new ArrayList<FarmRecTable>();
                do {

                    r = new FarmRecTable();
                    r.setId(rs.getInt("id"));
                    r.setName(rs.getString("Farmers_name"));
                    r.setBrgy(rs.getString("barangay"));
                    r.setMunicipality(rs.getString("municipality"));
                    r.setDate_updated(rs.getDate("date"));
                    r.setStatus(rs.getString("status"));

                    

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
    public ArrayList<Recommendation> viewFarmRecTablebyFarm(int id) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select r.id,r.recommendation,r.type from `recommendations-fields` rf  join recommendations r on rf.Recommendations_id=r.id where rf.Fields_id=?;";
              PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Recommendation> list = null;
            Recommendation r;
            if (rs.next()) {
                list = new ArrayList<Recommendation>();
                do {

                    r = new Recommendation();
                    r.setId(rs.getInt("id"));
                    r.setRecommendation_name(rs.getString("recommendation"));
                    r.setType(rs.getString("type"));
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
            String query = "select * from recommendations  where id = ? ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            Recommendation r = new Recommendation();
            if (rs.next()) {
                r.setId(rs.getInt("id"));
                r.setRecommendation_name(rs.getString("recommendation"));
                r.setType(rs.getString("type"));
                r.setDescription(rs.getString("description"));
                r.setStatus(rs.getString("improvement"));
//                r.setDate_create(rs.getDate("date_created"));
//                r.setDate_start(rs.getDate("date_start"));
//                r.setDate_end(rs.getDate("date_end"));
                r.setPhase(rs.getString("phase"));
//                r.setDuration(rs.getInt("duration_days"));
//                r.setTrigger_date(rs.getDate("trigger_date"));
//                r.setTrigger_num(rs.getDouble("trigger_num"));
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

    public ArrayList<Problems> viewProbRecTable(int id) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select p.id,p.name,p.description from `recommendations-problems`rp join Problems p on rp.Problems_id=p.id where Recommendations_id=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Problems> list = null;
            Problems p;
            System.out.println("ran aims to prev");
            if (rs.next()) {
                list = new ArrayList<Problems>();
                do {

                    p = new Problems();
                    p.setProb_id(rs.getInt("id"));
                    p.setProb_name(rs.getString("name"));
                    p.setProb_details(rs.getString("description"));
                    list.add(p);
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
}
