/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Calendar;
import java.sql.Connection;
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
public class CalendarDB {
    public ArrayList<Calendar> getCaledarInputs() {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT * FROM crop_calendar;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Calendar> fT = null;
            Calendar f;
            if (rs.next()) { 
                 fT = new ArrayList<Calendar>();
                do {
                    f = new Calendar();
                    f.setDistrict(rs.getString("district"));
                    f.setYear(rs.getInt("year"));
                    f.setPhase(rs.getString("phase"));
                    f.setStarting(rs.getDate("date_starting"));
                    f.setEnding(rs.getDate("date_ending"));
                    fT.add(f);
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            conn.close();
            
            return fT;
        } catch (SQLException ex) {
            Logger.getLogger(CalendarDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
