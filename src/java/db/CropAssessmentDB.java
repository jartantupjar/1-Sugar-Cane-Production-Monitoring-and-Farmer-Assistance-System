/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.CropAssessment;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author Bryll Joey Delfin
 */
public class CropAssessmentDB {
    public ArrayList<CropAssessment> getCropAssessmentReportForTheWeek(int weekofyear, int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT * FROM weeklyestimate where weekofyear(week_ending) = ? and year = ?  ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, weekofyear);
            pstmt.setInt(2, year);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<CropAssessment> cT = null;
            CropAssessment c;
            if (rs.next()) { 
                 cT = new ArrayList<>();
                do {
                    c = new CropAssessment();
                    c.setThisTons_Cane(rs.getDouble("actual"));
                    c.setEstiTons_Cane(rs.getDouble("forecasted"));
                    c.setThisArea(rs.getDouble("area"));
                    cT.add(c);
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();
            
            return cT;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CropAssessmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<CropAssessment> getPrevCropAssessmentReportForTheWeek(int weekofyear, int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT sum(area) as 'previous_area',sum(actual) as 'previous_tc' FROM weeklyestimate where weekofyear(week_ending) < ? and year = ? ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            weekofyear -- ; 
            pstmt.setInt(1, weekofyear);
            pstmt.setInt(2, year);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<CropAssessment> cT = null;
            CropAssessment c;
            if (rs.next()) { 
                 cT = new ArrayList<>();
                do {
                    c = new CropAssessment();
                    c.setPrevTons_Cane(rs.getDouble("previous_tc"));
                    c.setPrevArea(rs.getDouble("previous_area"));
                    cT.add(c);
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();
            
            return cT;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CropAssessmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
