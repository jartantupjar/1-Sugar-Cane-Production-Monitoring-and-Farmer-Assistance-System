/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Farmer;
import entity.Problems;
import entity.Recommendation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ndrs
 */
public class FarmerDB {
     public Farmer viewFarmerDetails(String name) {
        
         try {
             // put functions here : previous week production, this week production
             DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
             Connection conn = myFactory.getConnection();
             String query = "select name,cell_num from farmers where name=?;";
             PreparedStatement pstmt = conn.prepareStatement(query);
             pstmt.setString(1, name);
             ResultSet rs = pstmt.executeQuery();
             
             Farmer p = null;
             if (rs.next()) {
                 
                 p = new Farmer();
                 p.setName(name);
                 p.setPhone(rs.getString("cell_num"));
                   p=viewHistProdDetails(p);
             }
             
             rs.close();
             pstmt.close();
             conn.close();
             
             return p;
         } catch (SQLException ex) {
             Logger.getLogger(FarmerDB.class.getName()).log(Level.SEVERE, null, ex);
         }
      return null;
     }
       public Farmer viewHistProdDetails(Farmer f) {
        
         try {
             // put functions here : previous week production, this week production
             DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
             Connection conn = myFactory.getConnection();
             String query = "select sum(tons_cane) as totProd,avg(tons_cane) as avgProd,sum(area) as tarea,avg(area) as avgarea,avg(tons_cane)/avg(area) as avgyield,avg(tons_cane/area) as tavgyield,count(DISTINCT year) as tyears from historicalproduction where Farmers_name=? ;";
             PreparedStatement pstmt = conn.prepareStatement(query);
             pstmt.setString(1, f.getName());
             ResultSet rs = pstmt.executeQuery();
             
             if (rs.next()) {
   
            f.setTotalProd(rs.getDouble("totProd"));
          f.setAvgProd(rs.getDouble("avgProd"));
          f.setTotalArea(rs.getDouble("tarea"));
          f.setAvgArea(rs.getDouble("avgarea"));
          f.setAvgYield(rs.getDouble("avgyield"));
          f.setTavgYield(rs.getDouble("tavgyield"));
          f.settYears(rs.getInt("tyears"));
             }
             rs.close();
             pstmt.close();
             conn.close();
             
             return f;
         } catch (SQLException ex) {
             Logger.getLogger(FarmerDB.class.getName()).log(Level.SEVERE, null, ex);
         }
      return null;
     }
 public ArrayList<Problems> viewFarmerProb(String fname) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select p.id,p.name,p.description from fields f join `Problems-Fields` pf on f.id=pf.Problems_id join problems p on p.id=pf.problems_id where f.Farmers_name=?  group by p.id;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,fname);
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
 public ArrayList<Recommendation> viewFarmerRec(String fname) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select r.id,r.recommendation,r.description  from fields f join `Recommendations-Fields` rf on f.id=rf.Fields_id join recommendations r on r.id=rf.recommendations_id where f.farmers_name=? group by r.id;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,fname);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Recommendation> list = null;
            Recommendation p;
            System.out.println("ran aims to prev");
            if (rs.next()) {
                list = new ArrayList<Recommendation>();
                do {

                    p = new Recommendation();
                    p.setId(rs.getInt("id"));
                    p.setRecommendation_name(rs.getString("recommendation"));
                    p.setDescription(rs.getString("description"));
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
