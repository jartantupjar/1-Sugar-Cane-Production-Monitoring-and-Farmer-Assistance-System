/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Recommendation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author Bryll Joey Delfin
 */
public class subjectiveRecDB {
    public int addRecommendation(Recommendation recommend) {
        try {
            // put functions here : previous week production, this week production
            int i = 0;
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into recommendations (recommendation , type , description, status ,phase,trigger_num) values (?,?,?,?,?,?);";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, recommend.getRecommendation_name());
            pstmt.setString(2, recommend.getType());
            pstmt.setString(3, recommend.getDescription());
            pstmt.setString(4, recommend.getStatus());
           // pstmt.setDate(5, recommend.getDate_create());
           // pstmt.setDate(5, recommend.getDate_start());
           // pstmt.setDate(6, recommend.getDate_end());
            pstmt.setString(5, recommend.getPhase());
           // pstmt.setDate(6, recommend.getTrigger_date());
            double test = recommend.getConfig();
            pstmt.setDouble(6,test);
            i = pstmt.executeUpdate();
            if(i==1){
                i=getLastRecommendationId();
            }
            pstmt.close();
            conn.close();
            return i;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(subjectiveRecDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int connectRecommendationtoProblem(int recom_id, int prob_id) {
        try {
            // put functions here : previous week production, this week production
            int i = 0;
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into `recommendations-problems` (Recommendations_id,Problems_id) values (?,?);";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,recom_id);
            pstmt.setInt(2, prob_id);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return i;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(subjectiveRecDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int getLastRecommendationId() {
        try {
            // put functions here : previous week production, this week production
            int i = 0;
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT  max(id)as id FROM sra.recommendations ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                do{
                i = rs.getInt("id");
                }while(rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();
            return i;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(subjectiveRecDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
