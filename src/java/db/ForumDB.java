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
                    f.setTitle(rs.getString("title"));
                    f.setId(rs.getInt("id"));
                    f.setFarmer(rs.getString("Farmers_name"));
                    f.setMessage(rs.getString("message"));
                    f.setDate_started(rs.getDate("date_started"));
                    f.setDate_posted(rs.getDate("date_posted"));
                    f.setStatus(rs.getString("status"));
                    f.setRecom_id(rs.getInt("Recommendations_id"));
                    f.setProb_id(rs.getInt("Problems_id"));
                    String line = f.getId()+","+f.getStatus();
                    f.setId_and_status(line);
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
    public ArrayList<Forum> getCommentDetails(Integer id){
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
                    do {
                        f = new Forum();
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
                        
                        System.out.println(f.getComment_User()+ " USERS DATABASE");
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
            String query = "SELECT p.id,p.Farmers_name,p.message,p.date_started,p.date_posted,p.title ,p.status, p.Recommendations_id, p.Problems_id ,c.Farmers_name as 'commentor',c.message as 'comments',c.date as 'date_comment' FROM posts p left join comments c on p.id = c.Posts_id where p.id = ? ; ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Forum> fT = new ArrayList<Forum>();
            Forum f = null;
                if (rs.next()) {
                    
                    do {
                        f = new Forum();
                        f.setId(rs.getInt("id"));
                        f.setTitle(rs.getString("title"));
                        f.setFarmer(rs.getString("Farmers_name"));
                        f.setMessage(rs.getString("message"));
                        f.setDate_started(rs.getDate("date_started"));
                        f.setDate_posted(rs.getDate("date_posted"));
                        f.setStatus(rs.getString("status"));
                        f.setProb_id(rs.getInt("Problems_id"));
                        f.setRecom_id(rs.getInt("Recommendations_id"));
                        String test = rs.getString("commentor");
                        if(test!=null){
                            f.setComment_User(test);
                            f.setComment_message(rs.getString("comments"));
                            f.setComment_Date(rs.getString("date_comment"));
                        }
                        String line = f.getId()+","+f.getStatus();
                        f.setId_and_status(line);
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
    public Integer approvePost(Integer id){
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "update posts set status = 'Accepted' where id = ?  ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,id);
            int check = pstmt.executeUpdate();
                System.out.println(check + " This is the test");
                pstmt.close();
                conn.close();            
            return check;
                 }catch (SQLException ex) {
            Logger.getLogger(ForumDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Integer rejectPost(Integer id){
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "update posts set status = 'Rejected' where id = ?  ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,id);
            int check = pstmt.executeUpdate();
                System.out.println(check + " This is the test");
                pstmt.close();
                conn.close();            
            return check;
                 }catch (SQLException ex) {
            Logger.getLogger(ForumDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int getProblemCounter(Integer problem_id){
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT count(pf.Fields_id) as `counter` from posts p join problems pr on p.Problems_id = pr.id join `problems-fields` pf on pr.id = pf.Problems_id where pf.Problems_id = ? ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,problem_id);
            ResultSet rs = pstmt.executeQuery();
            Integer count = 0;
                if (rs.next()) {
                        count += rs.getInt("counter");
                }
                rs.close();
                pstmt.close();
                conn.close();            
            return count;
                 }catch (SQLException ex) {
            Logger.getLogger(ForumDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int getRecommendationCounter(Integer recom_id){
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "Select count(rf.Fields_id) as `counter` from posts p join recommendations r on p.Recommendations_id = r.id join `recommendations-fields` rf on r.id = rf.Recommendations_id where rf.id = ? ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,recom_id);
            ResultSet rs = pstmt.executeQuery();
            Integer count = 0;
                if (rs.next()){ 
                        count += rs.getInt("counter");    
                }
                rs.close();
                pstmt.close();
                conn.close();            
            return count;
                 }catch (SQLException ex) {
            Logger.getLogger(ForumDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}

