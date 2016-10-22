/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Weather;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author Bryll Joey Delfin
 */
public class WeatherDB {
    public ArrayList<Weather> getWeatherTrends( int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT month(week_ending) as 'months', week_ending, year, sum(rainfal) as 'rain', sum(actual) as 'actual' FROM sra.weeklyestimate where year = ? group by month(week_ending) order by week_ending;;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Weather> wT = null;
            Weather w;
            if (rs.next()) { 
                 wT = new ArrayList<>();
                do {
                    w = new Weather();
                    w.setMonths(rs.getString("months"));
                    w.setYear(rs.getString("year"));
                    w.setProduction(rs.getDouble("actual"));
                    w.setRainfall(rs.getDouble("rain"));
                    wT.add(w);
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();
            
            return wT;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CropAssessmentDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
