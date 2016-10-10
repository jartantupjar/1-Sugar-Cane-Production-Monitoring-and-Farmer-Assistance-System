/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Forum;
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
public class ForumDB {
    public ArrayList<Forum> getForumsList() {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT * FROM sra.posts;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Forum> fT = null;
            Forum f;
            if (rs.next()) { 
                 fT = new ArrayList<Forum>();
                do {
                    f = new Forum();
                    f.setId(rs.getInt("id"));
                    f.setFarmer(rs.getString("Farmers_name"));
                    f.setMessage(rs.getString("message"));
                    f.setDate_started(rs.getDate("date_started"));
                    f.setDate_posted(rs.getDate("date_posted"));
                    fT.add(f);
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            conn.close();
            
            return fT;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Forum getForumDetails(Forum forum){
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT * FROM sra.posts where id = ? ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(0, forum.getId());
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Forum> fT = null;
            Forum f = null;
                if (rs.next()) {
                    f = new Forum();
                    do {
                        
                        f.setId(rs.getInt("id"));
                        f.setFarmer(rs.getString("Farmers_name"));
                        f.setMessage(rs.getString("message"));
                        f.setDate_started(rs.getDate("date_started"));
                        f.setDate_posted(rs.getDate("date_posted"));
                        fT.add(f);
                    } while (rs.next());
                }
                rs.close();
                pstmt.close();
                conn.close();            
            return f;
                 }catch (SQLException ex) {
            Logger.getLogger(ForumDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

