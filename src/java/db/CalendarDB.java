/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import controller.createNewProgram;
import entity.Calendar;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public Date convertStringtoSQLDate(String lined){
        Date pdate = null ;
            try{
            java.util.Date date = new SimpleDateFormat("MM/dd/yyyy").parse(lined);
            pdate = new java.sql.Date(date.getTime());
            } catch (ParseException ex) {
            Logger.getLogger(CalendarDB.class.getName()).log(Level.SEVERE, null, ex);
            } 
     return pdate;   
    }
    public int addPhasesDates(Calendar cal, int year, String district) {
        try {
            // put functions here : previous week production, this week production
            int i = 0;
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "Insert into crop_calendar(year,district,phase,date_starting,date_ending) values (?,?,?,?,?);";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,year);
            pstmt.setString(2,district);
            pstmt.setString(3, cal.getPhase());
            pstmt.setDate(4, cal.getStarting());
            pstmt.setDate(5,cal.getEnding());
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return i;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(subjectiveRecDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
