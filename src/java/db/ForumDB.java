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
            String query = "SELECT * FROM posts;";
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
                    f.setStatus(rs.getString("Post_Status_status"));
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
    public ArrayList<Forum> getForumDetails(Integer id){
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT p.id,p.Farmers_name,p.message,p.date_started,p.date_posted,c.Farmers_name as 'commentor',c.message as 'comments',c.date as 'date_comment' FROM posts p left join comments c on p.id = c.Posts_id where p.id = ? ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Forum> fT = new ArrayList<Forum>();
            Forum f = null;
                if (rs.next()) {
                    f = new Forum();
                    do {
                        f.setId(rs.getInt("id"));
                        f.setFarmer(rs.getString("Farmers_name"));
                        f.setMessage(rs.getString("message"));
                        f.setDate_started(rs.getDate("date_started"));
                        f.setDate_posted(rs.getDate("date_posted"));
                        String test = rs.getString("commentor");
                        if(test!=null){
                            f.setComment_User(test);
                            f.setComment_message(rs.getString("comments"));
                            f.setComment_Date(rs.getString("date_comment"));
                        }
                        fT.add(f);
                    } while (rs.next());
                }
                rs.close();
                pstmt.close();
                conn.close();            
            return fT;
                 }catch (SQLException ex) {
            Logger.getLogger(ForumDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Forum getForumDetail(Integer id){
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT p.id,p.Farmers_name,p.message,p.date_started,p.date_posted,c.Farmers_name as 'commentor',c.message as 'comments',c.date as 'date_comment' FROM posts p left join comments c on p.id = c.Posts_id where p.id = ? ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Forum> fT = new ArrayList<Forum>();
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

