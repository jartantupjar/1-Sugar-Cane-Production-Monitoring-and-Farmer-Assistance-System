/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


import entity.CropAssessment;
import entity.Farmer;
import entity.ProdBarangay;
import entity.Production;
import entity.Programs;
import entity.prodMunicipality;
import java.sql.Connection;
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
public class ProductionDB {
    
    public  ArrayList<prodMunicipality> getProdMunicipalforYear(int year){
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query= "select DISTINCT f.municipality from historicalproduction p  join fields f on p.Farmers_name=f.Farmers_name where p.year=? group by f.municipality;";
           
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            ResultSet rs= pstmt.executeQuery();
           ArrayList<prodMunicipality>  list = new ArrayList<>();
            if (rs.next()) {
               
                do {
                   prodMunicipality municipal= new prodMunicipality();
                   municipal.setYear(year);
                   municipal.setMunicipal(rs.getString("municipality"));
                   System.out.println(municipal.getMunicipal());
                   municipal.setBrgy(getProdBarangayforYear(municipal));
                  list.add(municipal);
                } while (rs.next());
            }
             rs.close();
            pstmt.close();
            conn.close();
            return list;
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
     public  ArrayList<ProdBarangay> getProdBarangayforYear(prodMunicipality pm){
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query= "select DISTINCT f.barangay from historicalproduction p left join fields f on p.Farmers_name=f.Farmers_name where p.year=? and f.municipality=? group by f.barangay;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, pm.getYear());
             pstmt.setString(2,pm.getMunicipal());
            ResultSet rs= pstmt.executeQuery();
           ArrayList<ProdBarangay>  list = new ArrayList<>();
            if (rs.next()) {
                do {
                   ProdBarangay brgy= new ProdBarangay();
                   brgy.setBarangay(rs.getString("barangay"));
                   //   System.out.println(brgy.getBarangay());
                   brgy.setFarmer(getProdFarmerforYear(pm,brgy));
                   list.add(brgy);
                } while (rs.next());
            }
             rs.close();
            pstmt.close();
            conn.close();
            return list;
              
        } catch (SQLException ex) {
            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
     public  ArrayList<Farmer> getProdFarmerforYear(prodMunicipality pm,ProdBarangay pb){
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
         //   String query= "select sum(p.tons_cane) as tTons_cane ,p.farmers_name from historicalproduction p join fields f on p.Farmers_name=f.Farmers_name where p.year=? and f.municipality=? and f.barangay=? group by f.Farmers_name;";
            String query= "select p.tons_cane as tTons_cane ,p.farmers_name from historicalproduction p left join fields f on p.Farmers_name=f.Farmers_name where p.year=? and f.municipality=? and f.barangay=? group by f.Farmers_name;";
           
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, pm.getYear());
            pstmt.setString(2,pm.getMunicipal());
            pstmt.setString(3,pb.getBarangay());
            ResultSet rs= pstmt.executeQuery();
           ArrayList<Farmer>  list = new ArrayList<>();
            if (rs.next()) {
                do {
                   Farmer farmer= new Farmer();
                   farmer.setName(rs.getString("farmers_name"));
                    //  System.out.println(farmer.getName());
                   farmer.setProduction(rs.getDouble("tTons_cane"));
                   list.add(farmer);
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();
            return list;
              
        } catch (SQLException ex) {
            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
     
    public ArrayList<CropAssessment> getCropAssessment() {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select * from production;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<CropAssessment> ca = null;
            Production p;
            if (rs.next()) {
                ca = new ArrayList<CropAssessment>();
                do {
                    p = new Production();
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            conn.close();
            return ca;
        } catch (SQLException ex) {
            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
