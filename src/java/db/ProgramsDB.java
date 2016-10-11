/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Problems;
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

    public boolean updateKPIs(ArrayList<programsKPI> kpis) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "UPDATE kpis SET actual=? WHERE year=? and Programs_name=? and name=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            for (int i = 0; i < kpis.size(); i++) {

                int sYear = kpis.get(i).getKpi_year();
                for (int a = 0; a < kpis.get(i).getaValues().size(); a++) {
                    pstmt.setDouble(1, kpis.get(i).getaValues().get(a));
                    pstmt.setInt(2, sYear + a);
                    pstmt.setString(3, kpis.get(0).getProgram_name());
                    pstmt.setString(4, kpis.get(i).getKpi());
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

                pstmt.setString(1, prog_name);
                pstmt.setInt(2, Integer.parseInt(probids.get(i)));
                pstmt.setString(3, "Validated");
                pstmt.addBatch();
            }
            System.out.println("ADDED PROBLEMS TO PROGRAMS");
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

    public Programs viewProgDetails(String prog_name) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select * from programs where name=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, prog_name);
            ResultSet rs = pstmt.executeQuery();

            Programs p = null;
            if (rs.next()) {

                p = new Programs();
                p.setProg_name(rs.getString("name"));
                p.setDate_created(rs.getDate("date_created"));
                p.setDate_initial(rs.getDate("date_initial"));
                p.setDate_end(rs.getDate("date_end"));
                p.setDescription(rs.getString("description"));
                p.setType(rs.getString("status"));
                //p.setProgress(rs.getInt("progress"));
                // p.settFarms(rs.getInt("count"));

            }
            rs.close();
            pstmt.close();
            conn.close();

            return p;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Problems> viewProgProb(String prog_name) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select p.id,p.name,p.description from problems p join `programs-problems` pp on p.id=pp.Problems_id where pp.Programs_name=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, prog_name);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Problems> list = null;
            Problems p = null;
            if (rs.next()) {
                list = new ArrayList<>();
                do {
                    p = new Problems();
                    p.setProb_id(rs.getInt("id"));
                    p.setProb_name(rs.getString("name"));
                    p.setProb_details(rs.getString("description"));
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
//works only for 1 row
//    public ArrayList<programsKPI> viewProgTargets(String prog_name) {
//        try {
//            // put functions here : previous week production, this week production
//            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
//            Connection conn = myFactory.getConnection();
//            String query = "select year,Programs_name,name,value,actual,(select count(DISTINCT year) from kpis where Programs_name=?) as count from kpis where programs_name=? order by name;";
//            PreparedStatement pstmt = conn.prepareStatement(query);
//            pstmt.setString(1, prog_name);
//            pstmt.setString(2, prog_name);
//            ResultSet rs = pstmt.executeQuery();
//            ArrayList<programsKPI> list = null;
//            programsKPI p = null;
//            if (rs.next()) {
//                list = new ArrayList<>();
//
//                do {
//                    p = new programsKPI();
//                    p.setKpi(rs.getString("name"));
//                    p.setKpi_year(rs.getInt("year"));
//                    p.settYears(rs.getInt("count"));
//
//                    ArrayList<Double> values = new ArrayList();
//                    ArrayList<Double> avalues = new ArrayList();
//                    int counter = p.gettYears();
//                    do {
//                        String namechkr = rs.getString("name");
//                        System.out.println(rs.getRow() + "row no");
//                        System.out.println(counter);
//                        System.out.println(rs.getDouble("value") + "value");
//                        System.out.println(rs.getDouble("actual") + "actual");
//                        values.add(rs.getDouble("value"));
//                        avalues.add(rs.getDouble("actual"));
//                        if (counter > 0) {
//                            rs.next();
//                            System.out.println(rs.getRow() + "row no");
//                        }
//
//                        
//                        counter--;
//
//                    } while (counter > 0);
//
//                    p.setValues(values);
//                    p.setaValues(avalues);
//                    list.add(p);
//                } while (rs.next());
//            }
//
//            rs.close();
//            pstmt.close();
//            conn.close();
//
//            return list;
//        } catch (SQLException ex) {
//            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }

    public ArrayList<programsKPI> viewProg1Targets(String prog_name) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select year,Programs_name,name,value,actual,(select count(DISTINCT year) from kpis where Programs_name=?) as count from kpis where programs_name=? order by name;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, prog_name);
            pstmt.setString(2, prog_name);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<programsKPI> list = null;
            programsKPI p = null;
            if (rs.next()) {
                list = new ArrayList<>();

                do {
                    p = new programsKPI();
                    p.setKpi(rs.getString("name"));
                    p.setKpi_year(rs.getInt("year"));
                    p.settYears(rs.getInt("count"));

                    ArrayList<Double> values = new ArrayList();
                    ArrayList<Double> avalues = new ArrayList();
                    int counter = p.gettYears();

                    for (int c = p.gettYears(); c > 0; c--) {
                        String namechkr = rs.getString("name");
                        System.out.println(rs.getRow() + "row no");
                        System.out.println(counter);
                        System.out.println(rs.getDouble("value") + "value");
                        System.out.println(rs.getDouble("actual") + "actual");
                        values.add(rs.getDouble("value"));
                        avalues.add(rs.getDouble("actual"));
                        if (counter > 0) {
                            rs.next();
                            System.out.println(rs.getRow() + "row no");
                        }

                        if (c == 1) {
                            rs.previous();
                        }

                    }

                    p.setValues(values);
                    p.setaValues(avalues);
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