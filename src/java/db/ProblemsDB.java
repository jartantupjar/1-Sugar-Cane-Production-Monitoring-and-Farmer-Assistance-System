/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Problems;
import entity.Recommendation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
public class ProblemsDB {
    public ArrayList<Problems> getProblemsList() {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT p.id, p.name,p.description,pf.status,p.type,count(pf.Fields_id) as counter,(select count(pp.programs_name)from `programs-problems`pp where pp.problems_id=p.id) as pcounter from problems p  left join `problems-fields` pf on p.id = pf.Problems_id left join fields f on pf.Fields_id = f.id group by p.id ;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Problems> pT = null;
            Problems p;
            if (rs.next()) { 
                 pT = new ArrayList<Problems>();
                do {
                    p = new Problems();
                    p.setProb_id(rs.getInt("id"));
                    p.setProb_name(rs.getString("name"));
                    p.setProb_details(rs.getString("description"));
                    p.setStatus(rs.getString("status"));
                    p.setType(rs.getString("type"));
                    p.setTotalFarms(rs.getInt("counter"));
                    p.settSolutions(rs.getInt("pcounter"));
                    pT.add(p);
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            conn.close();
            
            return pT;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Recommendation> getAllSolutions(int prob_id) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT * FROM `recommendations-problems` where Problems_id = ?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, prob_id);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Recommendation> rT = null;
            Recommendation r;
            if (rs.next()) { 
                 rT = new ArrayList<Recommendation>();
                do {
                    r = new Recommendation();
                    r.setId(rs.getInt("Recommendations_id"));
                    rT.add(r);
                   
                    
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();
            
            return rT;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int addRecommendation(Integer recid, Integer probid) {
        try {
            // put functions here : previous week production, this week production
            int i = 0;
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "Insert into `recommendations-problems` values (?,?);";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, recid);
            pstmt.setInt(2, probid);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return i;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(subjectiveRecDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int linktoProblems(Integer field_id, Integer probid, Date date, String status) {
        try {
            // put functions here : previous week production, this week production
            int id = getNextProblemsFieldsID();
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into `problems-fields`(Problems_id,Fields_id,date,status) values(?,?,?,?);";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, probid);
            pstmt.setInt(2, field_id);
            pstmt.setDate(3, date);
            pstmt.setString(4, status);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return id;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(subjectiveRecDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public ArrayList<Problems> getProblemsWithBrgy() {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT p.id, p.name,p.description,p.status,p.type,count(pf.Fields_id) as counter from problems p join `problems-fields` pf on p.id = pf.Problems_id join fields f on pf.Problems_id = f.id where pf.validated = 'Y' group by pf.problems_id ;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Problems> pT = null;
            Problems p;
            if (rs.next()) { 
                 pT = new ArrayList<Problems>();
                do {
                    p = new Problems();
                    p.setProb_id(rs.getInt("id"));
                    p.setProb_name(rs.getString("name"));
                    p.setProb_details(rs.getString("description"));
                    p.setStatus(rs.getString("status"));
                    p.setType(rs.getString("type"));
                    p.setTotalFarms(rs.getInt("counter"));
                    pT.add(p);
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            conn.close();
            
            return pT;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Problems getProblemsDetails(int id) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select p.id, p.name, p.description,p.type, count(pf.Fields_id) as counter from problems p join `problems-fields` pf on p.id = pf.Problems_id where p.id = ?  ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Problems p = null;
            if (rs.next()) {
                do {
                    p = new Problems();
                    p.setProb_id(rs.getInt("id"));
                    p.setProb_name(rs.getString("name"));
                    p.setProb_details(rs.getString("description"));
                    p.setType(rs.getString("type"));
                    p.setTotalFarms(rs.getInt("counter"));
                } while (rs.next());
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
    public ArrayList<Problems> getFarmProblemDetbyFarm(int id) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select p.id,p.name,p.type from `Problems-Fields` pf join problems p on p.id=pf.problems_id where pf.Fields_id=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
         ArrayList<Problems> list=null;
            if (rs.next()) {
                            list= new ArrayList<>();
                do {
                         Problems p = new Problems();
                    p.setProb_id(rs.getInt("id"));
                   p.setProb_name(rs.getString("name"));
//                    p.setProb_details(rs.getString("description"));
//                    p.setStatus(rs.getString("status"));
                    p.setType(rs.getString("type"));
                   // p.setTotalFarms(rs.getInt("counter"));
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
    public Problems getAlertDetails(int id) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select p.id, p.name, p.description, pf.status,p.type, count(pf.Fields_id) as counter from problems p join `problems-fields` pf on p.id = pf.Problems_id where p.id = ?  ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Problems p = null;
            if (rs.next()) {
                do {
                    p = new Problems();
                    p.setProb_id(rs.getInt("id"));
                    p.setProb_name(rs.getString("name"));
                    p.setProb_details(rs.getString("description"));
                    p.setStatus(rs.getString("status"));
                    p.setType(rs.getString("type"));
                    p.setTotalFarms(rs.getInt("counter"));
                } while (rs.next());
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
    public ArrayList<Problems> showProblembyFarm(int id) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select f.Farmers_name,pf.Fields_id,f.barangay, round(pf.damage,2) as 'damage' from problems p join `problems-fields` pf on p.id = pf.Problems_id join `fields` f on pf.Fields_id = f.id where p.id = ?  ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Problems> pT = null;
            Problems p;
            if (rs.next()) { 
                 pT = new ArrayList<Problems>();
                do {
                    p = new Problems();
                    p.setFields_id(rs.getInt("Fields_id"));
                    p.setFarmer(rs.getString("Farmers_name"));
                    p.setBarangay(rs.getString("barangay"));
                    p.setProb_loss(rs.getDouble("damage"));
                   // p.setStatus(rs.getString("status"));
                    //p.setValidation(rs.getString("validated"));
                    pT.add(p);
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();
            
            return pT;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Problems> getDisastersList() {
        try {
            // for the page of disaster alert.... shows all disaster problems (which are not subjective)
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select p.id, p.type, f.municipality, f.barangay, pf.date ,count(pf.Fields_id) as 'recorded_count' \n" +
                            "from problems p join `problems-fields` pf on p.id = pf.problems_id join fields f on pf.Fields_id = f.id\n" +
                            "where p.type != 'Subjective'\n" +
                            "group by p.id, p.type, f.municipality;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Problems> pT = null;
            Problems p;
            if (rs.next()) { 
                 pT = new ArrayList<Problems>();
                do {
                    p = new Problems();
                    p.setType(rs.getString("type"));
                    p.setDate_updated(rs.getDate("date"));
                    p.setMunicipality(rs.getString("municipality"));
                    p.setBarangay(rs.getString("barangay"));
                    p.setTotalFarms(rs.getInt("recorded_count"));
                    p.setProb_id(rs.getInt("id"));
                    pT.add(p);
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            conn.close();
            
            return pT;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Problems> getDisastersListByBarangay(Integer id, String municipality) {
        try {
            // for the page of disaster alert.... shows all disaster problems (which are not subjective)
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select t1.id, t1.type, t1.date, t1.municipality,t1.barangay,t1.recorded_count,t2.total_farms, (t1.recorded_count / t2.total_farms) * 100 as 'Percent'\n" +
                            "from\n" +
                            "(select p.id, p.type, f.municipality, f.barangay, pf.date,count(pf.Fields_id) as 'recorded_count'\n" +
                            "from problems p join `problems-fields` pf on p.id = pf.problems_id  join fields f on pf.Fields_id = f.id\n" +
                            "where p.type != 'Subjective' and f.municipality = ? and p.id = ?\n" +
                            "group by p.id, p.type, f.municipality, f.barangay\n" +
                            ") 	t1\n" +
                            "join\n" +
                            "(SELECT f2.barangay ,count(f2.id) as 'total_farms', f2.barangay as 'brgy' FROM fields f2 group by f2.barangay) \n" +
                            "    t2 \n" +
                            "on t1.barangay = t2.brgy;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(2, id);
            pstmt.setString(1, municipality);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Problems> pT = null;
            Problems p;
            if (rs.next()) { 
                 pT = new ArrayList<Problems>();
                do {
                    p = new Problems();
                    p.setType(rs.getString("type"));
                    p.setDate_updated(rs.getDate("date"));
                    p.setMunicipality(rs.getString("municipality"));
                    p.setBarangay(rs.getString("barangay"));
                    p.setPercent_affected(rs.getDouble("Percent"));
                    p.setTotalFarms(rs.getInt("recorded_count"));
                    p.setTotalFields(rs.getInt("total_farms"));
                    p.setProb_id(rs.getInt("id"));
                    pT.add(p);
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();
            
            return pT;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Problems> getSpecificDisastersListByBarangay(Integer id, String municipality,String barangay) {
        try {
            // for the page of disaster alert.... shows all disaster problems (which are not subjective)
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select t1.id, t1.type, t1.date, t1.municipality,t1.barangay,t1.recorded_count,t2.total_farms, (t1.recorded_count / t2.total_farms) * 100 as 'Percent'\n" +
                            "from\n" +
                            "(select p.id, p.type, f.municipality, f.barangay, pf.date,count(pf.Fields_id) as 'recorded_count'\n" +
                            "from problems p join `problems-fields` pf on p.id = pf.problems_id  join fields f on pf.Fields_id = f.id\n" +
                            "where p.type != 'Subjective' and f.municipality = ? and p.id = ? \n" +
                            "group by p.id, p.type, f.municipality, f.barangay\n" +
                            ") 	t1\n" +
                            "join\n" +
                            "(SELECT f2.barangay ,count(f2.id) as 'total_farms', f2.barangay as 'brgy' FROM fields f2 group by f2.barangay) \n" +
                            "    t2 \n" +
                            "on t1.barangay = t2.brgy where t1.barangay = ? ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(2, id);
            pstmt.setString(1, municipality);
            pstmt.setString(3, barangay);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Problems> pT = null;
            Problems p;
            if (rs.next()) { 
                 pT = new ArrayList<Problems>();
                    p = new Problems();
                    p.setType(rs.getString("type"));
                    p.setDate_updated(rs.getDate("date"));
                    p.setMunicipality(rs.getString("municipality"));
                    p.setBarangay(rs.getString("barangay"));
                    p.setPercent_affected(rs.getDouble("Percent"));
                    p.setTotalFarms(rs.getInt("recorded_count"));
                    p.setTotalFields(rs.getInt("total_farms"));
                    p.setProb_id(rs.getInt("id"));
                    pT.add(p);
            }
            rs.close();
            pstmt.close();
            conn.close();
            
            return pT;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int addProblem(Problems problems) {
        try {
            // put functions here : previous week production, this week production
            int i = 0;
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into Problems(name, description,type,date,phase) values(?,?,?,?,?);";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, problems.getProb_name());
            pstmt.setString(2, problems.getProb_details());
            pstmt.setString(3, "Subjective");
            pstmt.setDate(4, problems.getDate_created());
            pstmt.setString(5, problems.getPhase());
            i = pstmt.executeUpdate();
            if(i==1){
                i= getLastProblemsID();
            }
            pstmt.close();
            conn.close();
            return i;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(subjectiveRecDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int addAlertToFarmers(int prob_id,String message,Date pdate, String barangay, String district, String municipality) {
        try {
            // put functions here : previous week production, this week production
            int i = 0;
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into DisasterAlerts(Problems_id,message,date,barangay,district,municipality) values(?,?,?,?,?,?);";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, prob_id);
            pstmt.setString(2, message);
            pstmt.setDate(3, pdate);
            pstmt.setString(4, barangay);
            pstmt.setString(5, district);
            pstmt.setString(6, municipality);
            i = pstmt.executeUpdate();
            if(i==1){
                i= getLastAlertsID();
                System.out.println(i +" ADDING IS DONE ");
            }
            pstmt.close();
            conn.close();
            return i;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(subjectiveRecDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int getLastProblemsID() {
        try {
            // put functions here : previous week production, this week production
            int i = 0;
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT  max(id)as id FROM Problems ;";
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
    }public int getLastAlertsID() {
        try {
            // put functions here : previous week production, this week production
            int i = 0;
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "SELECT  max(id)as id FROM DisasterAlerts ;";
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
    public int getNextProblemsFieldsID() {
        try {
            // put functions here : previous week production, this week production
            int i = 0;
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select auto_increment from information_schema.tables where table_schema = 'SRA' and table_name = 'Problems-Fields';";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                do{
                i = rs.getInt("auto_increment");
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
    public int checkProblemFieldsId(int prob_id, int fields_id) {
        try {
            // put functions here : previous week production, this week production
            int i = 0;
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select id from `problem-fields` where Problems_id = ? and Fields_id = ? ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, prob_id);
            pstmt.setInt(2, fields_id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                i = rs.getInt("id");
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
    public Integer updateProblemsFields(Integer fields_id, Integer prob_id, String status){
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "update posts set status = ? where Problems_id = ? and Fields_id = ?  ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(2, prob_id);
            pstmt.setInt(3,fields_id);
            pstmt.setString(1, status);
            int check = pstmt.executeUpdate();
                System.out.println(check + " This is the test");
                pstmt.close();
                conn.close();            
            return check;
                 }catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public String getDistrict(String barangay, String municipality) {
        try {
            // put functions here : previous week production, this week production
            String i = null;
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select district from `ref-barangays` where barangay = ? and municipality = ? ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, barangay);
            pstmt.setString(2, municipality);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                i = rs.getString("district");
            }
            rs.close();
            pstmt.close();
            conn.close();
            return i;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(subjectiveRecDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
