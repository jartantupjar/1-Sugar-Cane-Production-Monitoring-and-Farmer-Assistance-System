/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Programs;
import entity.programsKPI;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ndrs
 */
public class ProgramsDB {
    
    public boolean createNewProgram(Programs prog, ArrayList<programsKPI> kpis) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into programs values (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, prog.getProg_name());
            pstmt.setDate(2, (Date) prog.getDate_created());
            pstmt.setDate(3, (Date) prog.getDate_initial());
            pstmt.setDate(4, (Date) prog.getDate_end());
            pstmt.setString(5, prog.getDescription());
            pstmt.setString(6, prog.getType());
            pstmt.setString(7, "Tarlac");
            int isSuccess = pstmt.executeUpdate();
            
            kpis.get(0).setProgram_name(prog.getProg_name());
            
            pstmt.close();
            
            boolean kpisSuccess = addKPIs(kpis);
            
            conn.close();
            
            return isSuccess == 1 && kpisSuccess;
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    public boolean addKPIs(ArrayList<programsKPI> kpis) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into kpis (year,Programs_name,name,value) values (?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            for (int i = 0; i < kpis.size(); i++) {
                
                int sYear = kpis.get(i).getKpi_year();
                for (int a = 0; a < kpis.get(i).getValues().size(); a++) {
                    pstmt.setInt(1, sYear + a);
                    pstmt.setString(2, kpis.get(0).getProgram_name());
                    pstmt.setString(3, kpis.get(i).getKpi());
                    pstmt.setDouble(4, kpis.get(i).getValues().get(a));
                    pstmt.addBatch();
                }
                
            }
            pstmt.executeBatch();
            pstmt.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    public boolean addProgProb(ArrayList<String> probids, String prog_name) {
        try {
            
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into `Programs-Problems` (Programs_name,Problems_id,status) values (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            for (int i = 0; i < probids.size(); i++) {
                pstmt.setInt(1, Integer.parseInt(probids.get(i)));
                pstmt.setString(2, prog_name);
                pstmt.setString(3, "Validated");
            }
            pstmt.executeBatch();
            pstmt.close();
            conn.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    public ArrayList<Programs> viewProgramsTable() {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select pg.name,pg.date_created, count(pf.fields_id) as count from programs pg join `programs-problems` pp on pg.name=pp.programs_name join `problems-fields` pf on pp.problems_id=pf.problems_id group by pg.name;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Programs> list = null;
            Programs p;
            if (rs.next()) {
                list = new ArrayList<>();
                do {
                    p = new Programs();
                    p.setProg_name(rs.getString("name"));
                    p.setDate_created(rs.getDate("date_created"));
                    p.settFarms(rs.getInt("count"));
                    list.add(p);
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
    
}
