//reality

package db;

import entity.Farm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FarmsDB {
    
    public boolean createFarm(Farm farm){
        //DOESNT WORK
        try{
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into farms(owner, farm_name, boundary, area) values (?,?,?,?)";
            PreparedStatement pstmt= conn.prepareStatement(query);
         
            pstmt.setString(3, farm.getBoundaries());
            pstmt.setDouble(4, farm.getArea());
            int i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return i==1;
        } catch(SQLException ex){
             Logger.getLogger(FarmsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean editFarm(Farm farm){
        //DOESNT WORK
        try{
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "update farms set district = ?, management_type = ? , address= ?, nitrogen= ?, phosporus= ?, potassium = ?, ph_level= ? "
                    + "where owner = ? and farm_name = ?;";
            PreparedStatement pstmt= conn.prepareStatement(query);
            pstmt.setString(1, farm.getDistrict());
            pstmt.setString(2, farm.getManagement_type());
   
            pstmt.setDouble(4, farm.getNitrogen());
            pstmt.setDouble(5, farm.getPhosporus());
            pstmt.setDouble(6, farm.getPotassium());
            pstmt.setDouble(7, farm.getPhosporus());
       
            int i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return i==1;
        } catch(SQLException ex){
             Logger.getLogger(FarmsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public ArrayList<Farm> getFarTable() {
   return null;
    }
      public ArrayList<Farm> getFarmerFieldsTable(String fname) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select id,Farmers_name,barangay,municipality,area from fields where farmers_name=?;";
           PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, fname);
            ResultSet rs= pstmt.executeQuery();
            ArrayList<Farm> farms = null;
            Farm farm;
            if (rs.next()) {
                farms = new ArrayList<Farm>();
                do {
                    farm = new Farm();
                    farm.setId(rs.getInt("id"));
                    farm.setFarmer(fname);
                    farm.setArea(rs.getDouble("area"));
                    farm.setBarangay(rs.getString("barangay"));
                    farm.setMunicipality(rs.getString("municipality"));
                    farms.add(farm);
                    
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            conn.close();
            return farms;
        } catch (SQLException ex) {
            Logger.getLogger(FarmsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
