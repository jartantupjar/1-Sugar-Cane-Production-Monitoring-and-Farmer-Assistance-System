/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.CropAssessment;
import entity.CropNarrative;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryll Joey Delfin
 */
public class CropAssessmentDB {
      public boolean checkExistingNarrative(int cyear,Date weekending) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select * from cropassessment where year=? and district=? AND week_ending=? order by year,district,week_ending";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, cyear);
            pstmt.setString(2, "TARLAC");
            pstmt.setDate(3,weekending);
            ResultSet rs = pstmt.executeQuery();
           
            if (rs.next()) { 
             return true;    
            }
            rs.close();
            pstmt.close();
            conn.close();
            
          
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CropAssessmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean submitNarrative(CropNarrative cn){
         try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into cropassessment(year,district,week_ending,weather,prices_of_sugar,mill_operation,prices_of_inputs,others,overall_analysis) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, cn.getYear());
            pstmt.setString(2,"TARLAC");
            pstmt.setDate(3, cn.getWeekending());
            pstmt.setString(4,cn.getDweather());
            pstmt.setString(5,cn.getDprice());
            pstmt.setString(6,cn.getDmill());
            pstmt.setString(7,cn.getDinput());
            pstmt.setString(8,cn.getDother());
            pstmt.setString(9,cn.getDanalysis());
            int i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return i == 1;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CropAssessmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
       public CropNarrative getAssessmentNarrative(int year,Date weekending) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select * from cropassessment where year=? and district=? AND week_ending=? order by year,district,week_ending;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            pstmt.setString(2, "TARLAC");
            pstmt.setDate(3, weekending);
            ResultSet rs = pstmt.executeQuery();
          CropNarrative cn=null;
            if (rs.next()) { 
               cn = new CropNarrative();
                        cn.setYear(year);
                        cn.setWeekending(weekending);
                        cn.setDweather(rs.getString("weather"));
                        cn.setDprice(rs.getString("prices_of_sugar"));
                        cn.setDmill(rs.getString("mill_operation"));
                        cn.setDinput(rs.getString("prices_of_inputs"));
                        cn.setDother(rs.getString("others"));
                        cn.setDanalysis(rs.getString("overall_analysis"));
                   
            }
            rs.close();
            pstmt.close();
            conn.close();
            
            return cn;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CropAssessmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<CropAssessment> getCropAssessmentReportForTheWeek(int weekofyear, int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT * FROM weeklyestimate where id = ? and year = ?  ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            int id = getWeeklyEstimateID(weekofyear, year);
            pstmt.setInt(1, id);
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
                    c.setWeek_ending(rs.getDate("week_ending"));
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
    public Double getTotalEstimatedTonsCane(int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT sum(forecasted) as 'total' FROM weeklyestimate where year = ? ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            ResultSet rs = pstmt.executeQuery();
            Double tc = 0.00;
            if (rs.next()) { 
                    tc = rs.getDouble("total");
            }
            rs.close();
            pstmt.close();
            conn.close();
            
            return tc;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CropAssessmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0.00;
    }
    public Double getTotalEstimatedArea(int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT sum(area) as 'total' FROM cropestimatedistrict where year = ? ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            ResultSet rs = pstmt.executeQuery();
            Double area = 0.00;
            if (rs.next()) { 
                    area = rs.getDouble("total");
            }
            rs.close();
            pstmt.close();
            conn.close();
            
            return area;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CropAssessmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0.00;
    }
    public ArrayList<CropAssessment> getRainFall(int weekofyear, int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT *  FROM weeklyestimate where year = ? and id between ? and ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            int id = getWeeklyEstimateID(weekofyear, year);
            pstmt.setInt(1, year);
            pstmt.setInt(2, id);
            int consid = id+3;
            pstmt.setInt(3, consid);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<CropAssessment> rainfall = null;
            CropAssessment rain;
            if (rs.next()) { 
                 rainfall = new ArrayList<>();
                do {
                    rain = new CropAssessment();
                    rain.setRainfall(rs.getDouble("rainfal"));
                    rain.setWeek_ending(rs.getDate("week_ending"));
                    rainfall.add(rain);
                    
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();
            
            return rainfall;
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
            String query = "SELECT sum(area) as 'previous_area',sum(actual) as 'previous_tc' FROM weeklyestimate where id < ? and year = ? ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            int id = getWeeklyEstimateID(weekofyear, year);
            pstmt.setInt(1, id);
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
    public Integer getWeeklyEstimateID(int weekofyear, int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT * FROM weeklyestimate where weekofyear(week_ending) = ? and year = ?  ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, weekofyear);
            pstmt.setInt(2, year);
            ResultSet rs = pstmt.executeQuery();
            int id = 0;
            CropAssessment c;
            if (rs.next()) { 
                do {
                    id = rs.getInt("id");
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();
            
            return id;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CropAssessmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<CropAssessment> getEstimatedProduction(int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "Select * from weeklyestimate where year = ?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<CropAssessment> cT = null;
            CropAssessment c;
            if (rs.next()) { 
                 cT = new ArrayList<>();
                do {
                    c = new CropAssessment();
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
