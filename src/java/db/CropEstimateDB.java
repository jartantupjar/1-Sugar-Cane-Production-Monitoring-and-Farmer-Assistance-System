/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.MonthlyCropEstimate;
import entity.cropEstimate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ndrs
 */
public class CropEstimateDB {
    
    public ArrayList<cropEstimate> viewDistrictEstimates(int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select year,district,week_ending,area,actual,forecasted from weeklyestimate where year=?;";
              PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<cropEstimate> list = null;
            cropEstimate ce;
            if (rs.next()) {
                list = new ArrayList<>();
                do {

                    ce = new cropEstimate();
                    ce.setYear(rs.getInt("year"));
                    ce.setDistrict(rs.getString("district"));
                    ce.setWeek_ending(rs.getDate("week_ending"));
                    ce.setArea(rs.getDouble("area"));
                    double actual=rs.getDouble("actual");
                    double estim=rs.getDouble("forecasted");
                    ce.setActual(actual);
                    ce.setForecasted(estim);
                    ce.setDifference(getYieldDif(actual,estim));
                   list.add(ce);
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
    public ArrayList<cropEstimate> viewMunicipalityEstimates(int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select year,district,municipality,area,tons_cane,forecasted from cropestimatemunicipality where year=?;";
              PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<cropEstimate> list = null;
            cropEstimate ce;
            if (rs.next()) {
                list = new ArrayList<>();
                do {

                    ce = new cropEstimate();
                    ce.setYear(rs.getInt("year"));
                    ce.setDistrict(rs.getString("district"));
                    ce.setMunicipality(rs.getString("municipality"));
                    ce.setArea(rs.getDouble("area"));
                    double actual=rs.getDouble("tons_cane");
                    double estim=rs.getDouble("forecasted");
                    ce.setActual(actual);
                    ce.setForecasted(estim);
                    ce.setDifference(getYieldDif(actual,estim));
                   list.add(ce);
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
     public ArrayList<cropEstimate> viewAllDiffEstimates() {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select year,district,area,actual_tons_cane,forecasted1,forecasted2,forecasted3 from cropestimatedistrict;";
              PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<cropEstimate> list = null;
            cropEstimate ce;
            if (rs.next()) {
                list = new ArrayList<>();
                do {

                    ce = new cropEstimate();
                    ce.setYear(rs.getInt("year"));
                    ce.setDistrict(rs.getString("district"));
                  
                    ce.setArea(rs.getDouble("area"));
                    double actual=rs.getDouble("actual_tons_cane");
                    double estim=rs.getDouble("forecasted1");
                    double estim2=rs.getDouble("forecasted2");
                     double estim3=rs.getDouble("forecasted3");
                    ce.setActual(actual);
                    ce.setForecasted(estim);
                    ce.setForecast2(estim2);
                    ce.setForecast3(estim3);
                //    ce.setDifference(getYieldDif(actual,estim));
                   list.add(ce);
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
            public ArrayList<cropEstimate> viewCropEstBarChart(){
           ArrayList<Integer> yrs= getAllDistinctYrsCropEst();
             ArrayList<cropEstimate> list=new ArrayList<>();
           
        for (Integer yr : yrs) {
            list.add(viewYearlyEstim(yr));
        }
              return list;
         
     }
    ArrayList<Integer> getAllDistinctYrsCropEst(){
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select Distinct(year) from weeklyestimate;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Integer> list = null;
         
            if (rs.next()) {
                list = new ArrayList<>();
                do {
                   list.add(rs.getInt("year"));
                   } while (rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();

            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CropEstimateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
  }
  
        public cropEstimate viewYearlyEstim(int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select year ,district,sum(actual) as actual,sum(forecasted) as forecasted from weeklyestimate where year=?;";
              PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            ResultSet rs = pstmt.executeQuery();
          
            cropEstimate ce=null;
            if (rs.next()) {
               
                    ce = new cropEstimate();
                    ce.setYear(rs.getInt("year"));
                    ce.setDistrict(rs.getString("district"));
                    double actual=rs.getDouble("actual");
                    double estim=rs.getDouble("forecasted");
                    ce.setActual(actual);
                    ce.setForecasted(estim);
                ce.setMonthcropest(viewMonthDrillEstimate(year));
                  
           
            }
            rs.close();
            pstmt.close();
            conn.close();

            return ce;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      public ArrayList<MonthlyCropEstimate> viewMonthDrillEstimate(int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select year ,district,sum(actual) as sact,sum(forecasted) as sfor,monthname(week_ending) as mos from weeklyestimate where year=? group by MONTH(week_ending) order by week_ending;";
              PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<MonthlyCropEstimate> list = null;
            MonthlyCropEstimate ce;
            if (rs.next()) {
                list = new ArrayList<>();
                do {

                    ce = new MonthlyCropEstimate();
                    ce.setYear(rs.getInt("year"));
                    ce.setDistrict(rs.getString("district"));
                    ce.setMonth(rs.getString("mos"));
                    double actual=rs.getDouble("sact");
                    double estim=rs.getDouble("sfor");
                    ce.settActual(actual);
                    ce.settForc(estim);
                    
           
                   list.add(ce);
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
       public Double getYieldDif(Double act,Double est){
          // CHECK IF FORMULA IS RIGHT !~~~ ITS STILL QUESTIONABLE
           
           double percDiff= (Math.abs(act-est)/(Math.abs((act+est)/2)))*100;
           DecimalFormat df = new DecimalFormat(".##"); 
         
                  double fperc= Double.parseDouble(df.format(percDiff));
                //  double fperc=(percDiff*100.0)/100.0;
   // double roundOff= Math.round(((((f-sf)/sf))*100)*100.0)/100.0;
       
    
    
         return fperc;
         
     }
    
}
