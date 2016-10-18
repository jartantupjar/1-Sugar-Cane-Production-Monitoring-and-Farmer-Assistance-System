/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Problems;
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
 * @author Bryll Joey Delfin
 */
public class ProblemsDB {
    public ArrayList<Problems> getProblemsList() {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT p.id, p.name,p.description,p.status,p.type,count(pf.Fields_id) as counter from problems p join `problems-fields` pf on p.id = pf.Problems_id join fields f on pf.Fields_id = f.id \n" +
                            "group by p.id, p.type;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Problems> pT = null;
            Problems p;
            if (rs.next()) { 
                 pT = new ArrayList<Problems>();
                do {
                    p = new Problems();
                    p.setProb_id(rs.getInt("id"));
                    p.setProb_name(rs.getString("name"));
                    p.setProb_details(rs.getString("description"));
                    p.setStatus(rs.getString("status"));
                    p.setType(rs.getString("type"));
                    p.setTotalFarms(rs.getInt("counter"));
                    pT.add(p);
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            conn.close();
            
            return pT;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Problems> getAllProblems() {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT p.id, p.name,p.description,p.status,p.type from problems p;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Problems> pT = null;
            Problems p;
            if (rs.next()) { 
                 pT = new ArrayList<Problems>();
                do {
                    p = new Problems();
                    p.setProb_id(rs.getInt("id"));
                    p.setProb_name(rs.getString("name"));
                    p.setProb_details(rs.getString("description"));
                    p.setStatus(rs.getString("status"));
                    p.setType(rs.getString("type"));
                    p.setTotalFarms(14);
                    pT.add(p);
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            conn.close();
            
            return pT;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int addRecommendation(Integer recid, Integer probid) {
        try {
            // put functions here : previous week production, this week production
            int i = 0;
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "Insert into sra.`recommendations-problems` values (?,?);";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, recid);
            pstmt.setInt(2, probid);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return i;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(subjectiveRecDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public ArrayList<Problems> getProblemsWithBrgy() {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT p.id, p.name,p.description,p.status,p.type,count(pf.Fields_id) as counter from problems p join `problems-fields` pf on p.id = pf.Problems_id join fields f on pf.Problems_id = f.id where pf.validated = 'Y' group by pf.problems_id ;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Problems> pT = null;
            Problems p;
            if (rs.next()) { 
                 pT = new ArrayList<Problems>();
                do {
                    p = new Problems();
                    p.setProb_id(rs.getInt("id"));
                    p.setProb_name(rs.getString("name"));
                    p.setProb_details(rs.getString("description"));
                    p.setStatus(rs.getString("status"));
                    p.setType(rs.getString("type"));
                    p.setTotalFarms(rs.getInt("counter"));
                    pT.add(p);
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            conn.close();
            
            return pT;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Problems getProblemsDetails(int id) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select p.id, p.name, p.description, p.status,p.type, count(pf.Fields_id) as counter from problems p join `problems-fields` pf on p.id = pf.Problems_id where p.id = ?  ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Problems p = null;
            if (rs.next()) {
                do {
                    p = new Problems();
                    p.setProb_id(rs.getInt("id"));
                    p.setProb_name(rs.getString("name"));
                    p.setProb_details(rs.getString("description"));
                    p.setStatus(rs.getString("status"));
                    p.setType(rs.getString("type"));
                    p.setTotalFarms(rs.getInt("counter"));
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();
            
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      public ArrayList<Problems> getFarmProblemDetbyFarm(int id) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select p.id,p.name,p.type from `Problems-Fields` pf join problems p on p.id=pf.problems_id where pf.Fields_id=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
         ArrayList<Problems> list=null;
            if (rs.next()) {
                            list= new ArrayList<>();
                do {
                         Problems p = new Problems();
                    p.setProb_id(rs.getInt("id"));
                   p.setProb_name(rs.getString("name"));
//                    p.setProb_details(rs.getString("description"));
//                    p.setStatus(rs.getString("status"));
                    p.setType(rs.getString("type"));
                   // p.setTotalFarms(rs.getInt("counter"));
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
    public Problems getAlertDetails(int id) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select p.id, p.name, p.description, p.status,p.type, count(pf.Fields_id) as counter from problems p join `problems-fields` pf on p.id = pf.Problems_id where p.id = ?  ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Problems p = null;
            if (rs.next()) {
                do {
                    p = new Problems();
                    p.setProb_id(rs.getInt("id"));
                    p.setProb_name(rs.getString("name"));
                    p.setProb_details(rs.getString("description"));
                    p.setStatus(rs.getString("status"));
                    p.setType(rs.getString("type"));
                    p.setTotalFarms(rs.getInt("counter"));
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();
            
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Problems> showProblembyFarm(int id) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select f.Farmers_name,pf.Fields_id, p.status from problems p join `problems-fields` pf on p.id = pf.Problems_id join `fields` f on pf.Fields_id = f.id where p.id = ?  ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Problems> pT = null;
            Problems p;
            if (rs.next()) { 
                 pT = new ArrayList<Problems>();
                do {
                    p = new Problems();
                    p.setFields_id(rs.getInt("Fields_id"));
                    p.setFarmer(rs.getString("Farmers_name"));
                    p.setStatus(rs.getString("status"));
                    //p.setValidation(rs.getString("validated"));
                    pT.add(p);
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();
            
            return pT;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Problems> getDisastersList() {
        try {
            // for the page of disaster alert.... shows all disaster problems (which are not subjective)
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select p.id, p.type, f.municipality, f.barangay, pf.date ,count(pf.Fields_id) as 'recorded count'\n" +
"from problems p join `problems-fields` pf on p.id = pf.problems_id join fields f on pf.Fields_id = f.id\n" +
"where p.type != 'Subjective'\n" +
"group by p.id, p.type, f.municipality, f.barangay order by pf.date;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Problems> pT = null;
            Problems p;
            if (rs.next()) { 
                 pT = new ArrayList<Problems>();
                do {
                    p = new Problems();
                    p.setType(rs.getString("type"));
                    p.setDate_updated(rs.getDate("date"));
                    p.setBarangay(rs.getString("barangay"));
                    p.setTotalFarms(rs.getInt("recorded count"));
                    p.setProb_id(rs.getInt("id"));
                    pT.add(p);
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            conn.close();
            
            return pT;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
