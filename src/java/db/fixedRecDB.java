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
            String query = "select id,farmers_name,barangay,municipality,date,status,duration_days from `recommendations-fields` rf join fields f on rf.fields_id=f.id where rf.recommendations_id=?;";
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
                    r.setDuration_days(rs.getInt("duration_days"));

                    

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
            String query = "select r.id,r.recommendation,r.type,r.description from `recommendations-fields` rf  join recommendations r on rf.Recommendations_id=r.id where rf.Fields_id=?;";
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
                    r.setDescription(rs.getString("description"));
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
            String query = "select * from recommendations sr where sr.id=?;";
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
    public void sendRecommendations(ArrayList<String>farm,ArrayList<String>rec){
        for(int i=0; i<farm.size();i++){
            for(int b=0;b<rec.size();b++){
            if(checkExistingRec(farm.get(i),rec.get(b))==false){
                System.out.println("entered send rec if");
               inputRecommendation(farm.get(i),rec.get(b));
               inputRecNotif(farm.get(i),rec.get(b));
               
            }
        }
            }
        System.out.println("finshed sending recommendation");
    }
    public boolean inputRecommendation(String farm,String rec){
         try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into `recommendations-fields` (Recommendations_id,Fields_id,status,date) values (?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, rec);
            pstmt.setString(2, farm);
            pstmt.setString(3, "Verifying");
            pstmt.setString(4, "2015-06-11");
            
            
           int chek = pstmt.executeUpdate();
        
            System.out.println("ran aims to prev");
            boolean chkr=false;
            if (chek>0) {
              chkr=true;
               
            }
           
            pstmt.close();
            conn.close();

            return chkr;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    
    }
    public boolean inputRecNotif(String farm,String rec){
         try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
             String query1 = "update `recommendations-fields` set status = 'Verifying' where Fields_id = ? and recommendations_id=?;";
            PreparedStatement pstmt1 = conn.prepareStatement(query1);
            pstmt1.setString(1, farm);
            pstmt1.setString(2,rec);
           
            pstmt1.executeUpdate();
            
            String query = "insert into notifications(disaster, received, Fields_id, message ,date, Recommendations_id, Recommendations_Fields_id) values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "N");
            pstmt.setString(2, "N");
            pstmt.setString(3, farm);
            pstmt.setString(4, "message");
            pstmt.setString(5, "2015-06-11");
            pstmt.setString(6,rec);
            pstmt.setString(7, farm);
            int chck= pstmt.executeUpdate();
   
            boolean chkr=false;
            if (chck>0) {
              chkr=true;
               
            }
          
            pstmt.close();
            conn.close();

            return chkr;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    
    }
     public boolean checkExistingRec(String farm,String rec) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select * from `recommendations-fields` where recommendations_id=? and Fields_id=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, rec);
            pstmt.setString(2, farm);
            ResultSet rs = pstmt.executeQuery();
        
            System.out.println("ran aims to prev");
            boolean chkr=false;
            if (rs.next()) {
              chkr=true;
               
            }
            rs.close();
            pstmt.close();
            conn.close();

            return chkr;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
