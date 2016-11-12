/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.CropBoard;
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
public class CropBoardDB {
    public ArrayList<CropBoard> getWeeklyProducedReport(String type, Integer year, String date) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT *, week_ending,year, weekofyear(week_ending), round(sum(area),2) as total_area, round(sum(actual),2) as total_actual, round(sum(lkg),2)as total_lkg FROM dashboarddata where year = ? and week_ending < ? \n" +
"group by weekofyear(week_ending) order by week_ending;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            pstmt.setString(2, date);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<CropBoard> cT = null;
            CropBoard c;
            if (rs.next()) { 
                 cT = new ArrayList<CropBoard>();
                do {
                    c = new CropBoard();
                    c.setArea(rs.getDouble("total_area"));
                    c.setTc(rs.getDouble("total_actual"));
                    c.setLkg(rs.getDouble("total_lkg"));
                    c.setId(rs.getInt("id"));
                    c.setDistrict("district");
                    c.setWeek_ending(rs.getDate("week_ending"));
                    if(type.equalsIgnoreCase("TC")){
                    c.setProduction(c.getTc());
                    }
                    else if(type.equalsIgnoreCase("HA")){
                    c.setProduction(c.getArea());
                    }
                    else if(type.equalsIgnoreCase("LKG")){
                    c.setProduction(c.getLkg());
                    }
                    else{
                        System.out.println("TYPE : " + type);    
                    }
                    System.out.println("CROPDB IS DONE");
                    cT.add(c);
                    } while (rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();
            
            return cT;
        } catch (SQLException ex) {
            Logger.getLogger(CropBoardDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<CropBoard> getWeeklyAverageProducedReport(String type, Integer year, String date) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT *, week_ending,year, weekofyear(week_ending), round(avg(area),2) as total_area, round(avg(actual),2) as total_actual, round(avg(lkg),2)as total_lkg FROM dashboarddata where year = ? and week_ending < ? \n" +
"group by weekofyear(week_ending) order by week_ending;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            pstmt.setString(2, date);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<CropBoard> cT = null;
            CropBoard c;
            if (rs.next()) { 
                 cT = new ArrayList<CropBoard>();
                do {
                    c = new CropBoard();
                    c.setArea(rs.getDouble("total_area"));
                    c.setTc(rs.getDouble("total_actual"));
                    c.setLkg(rs.getDouble("total_lkg"));
                    c.setId(rs.getInt("id"));
                    c.setDistrict("district");
                    c.setWeek_ending(rs.getDate("week_ending"));
                    if(type.equalsIgnoreCase("TC")){
                    c.setProduction(c.getTc());
                    }
                    else if(type.equalsIgnoreCase("HA")){
                    c.setProduction(c.getArea());
                    }
                    else if(type.equalsIgnoreCase("LKG")){
                    c.setProduction(c.getLkg());
                    }
                    else{
                        System.out.println("TYPE : " + type);    
                    }
                    System.out.println("CROPDB IS DONE");
                    cT.add(c);
                    } while (rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();
            
            return cT;
        } catch (SQLException ex) {
            Logger.getLogger(CropBoardDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<CropBoard> getWeeklyProducedReportByRegion(String type, Integer year, Integer weekofyear) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT d.id,d.week_ending, weekofyear(week_ending), sum(area) as total_area, sum(actual) as total_actual, sum(lkg)as total_lkg, rd.region as place FROM dashboarddata d join `ref-districts` rd on d.district = rd.district where year = ? and year(week_ending) = ? and weekofyear(week_ending) = ? \n" +
"group by weekofyear(week_ending), rd.region order by week_ending; ";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            pstmt.setInt(2, year);
            pstmt.setInt(3, weekofyear);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<CropBoard> cT = null;
            CropBoard c;
            if (rs.next()) { 
                 cT = new ArrayList<CropBoard>();
                do {
                    c = new CropBoard();
                    c.setArea(rs.getDouble("total_area"));
                    c.setTc(rs.getDouble("total_actual"));
                    c.setLkg(rs.getDouble("total_lkg"));
                    c.setId(rs.getInt("id"));
                    c.setDistrict(rs.getString("place"));
                    c.setWeek_ending(rs.getDate("week_ending"));
                    if(type.equalsIgnoreCase("TC")){
                    c.setProduction(c.getTc());
                    }
                    else if(type.equalsIgnoreCase("HA")){
                    c.setProduction(c.getArea());
                    }
                    else if(type.equalsIgnoreCase("LKG")){
                    c.setProduction(c.getLkg());
                    }
                    else{
                        System.out.println("TYPE : " + type);    
                    }
                    System.out.println("CROPDB IS DONE");
                    cT.add(c);
                    } while (rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();
            
            return cT;
        } catch (SQLException ex) {
            Logger.getLogger(CropBoardDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<CropBoard> getWeeklyProducedReportByRegionT(Integer year,Integer yearpicked, Integer weekofyear) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT d.id,d.week_ending, weekofyear(week_ending), sum(area) as total_area, sum(actual) as total_actual, sum(lkg)as total_lkg, rd.region as place FROM dashboarddata d join `ref-districts` rd on d.district = rd.district where year = ? and year(week_ending) = ? and weekofyear(week_ending) = ? \n" +
"group by weekofyear(week_ending), rd.region order by week_ending; ";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            pstmt.setInt(2, yearpicked);
            pstmt.setInt(3, weekofyear);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<CropBoard> cT = null;
            CropBoard c;
            if (rs.next()) { 
                 cT = new ArrayList<CropBoard>();
                do {
                    c = new CropBoard();
                    c.setArea(rs.getDouble("total_area"));
                    c.setTc(rs.getDouble("total_actual"));
                    c.setLkg(rs.getDouble("total_lkg"));
                    c.setId(rs.getInt("id"));
                    c.setDistrict(rs.getString("place"));
                    c.setWeek_ending(rs.getDate("week_ending"));
                    System.out.println("FINAL TESTING");
                    System.out.println(c.getDistrict()+ " WHAT IS NOT WORKING");
                    cT.add(c);
                    } while (rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();
            
            return cT;
        } catch (SQLException ex) {
            Logger.getLogger(CropBoardDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<CropBoard> getWeeklyProducedReportByRegionDetails(String region, Date week_ending) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT d.district, d.id, d.week_ending, weekofyear(week_ending), sum(area) as total_area, sum(actual) as total_actual, sum(lkg)as total_lkg, sum(forecasted) as total_forecasted ,rd.region as place FROM dashboarddata d join `ref-districts` rd on d.district = rd.district where  week_ending = ? and region = ?\n" +
"group by d.district order by week_ending;";
            PreparedStatement pstmt = conn.prepareStatement(query);    
            pstmt.setDate(1, week_ending);
            pstmt.setString(2, region);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<CropBoard> cT = null;
            CropBoard c;
            if (rs.next()) { 
                 cT = new ArrayList<CropBoard>();
                do {
                    c = new CropBoard();
                    c.setArea(rs.getDouble("total_area"));
                    c.setTc(rs.getDouble("total_actual"));
                    c.setLkg(rs.getDouble("total_lkg"));
                    c.setId(rs.getInt("id"));
                    c.setDistrict(rs.getString("district"));
                    c.setWeek_ending(rs.getDate("week_ending"));
                    Double d = rs.getDouble("total_forecasted");
                    if(d != null){
                    c.setEstimated(rs.getDouble("total_forecasted"));
                    }
                    else{
                    c.setEstimated(0.00);
                    }
                    System.out.println("DETAILS TESTING");
                    System.out.println(c.getDistrict()+ " It should work");
                    cT.add(c);
                    } while (rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();
            
            return cT;
        } catch (SQLException ex) {
            Logger.getLogger(CropBoardDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
