/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Farmer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
//              p.setProduction(rs.getDouble("currProduction"));
//             p.setCurYield(rs.getDouble("curYield"));
//               p.setTfarms(rs.getDouble("avgYield"));
//             p.setTfarms(rs.getDouble("totalHa"));
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

    
}
