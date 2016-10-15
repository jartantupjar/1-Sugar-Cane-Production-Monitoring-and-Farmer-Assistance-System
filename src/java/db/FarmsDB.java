//reality
package db;

import entity.CropValidation;
import entity.Farm;
import entity.Fertilizer;
import entity.SoilAnalysis;
import entity.Tillers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FarmsDB {

    public boolean createFarm(Farm farm) {
        //DOESNT WORK
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into farms(owner, farm_name, boundary, area) values (?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(3, farm.getBoundaries());
            pstmt.setDouble(4, farm.getArea());
            int i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return i == 1;
        } catch (SQLException ex) {
            Logger.getLogger(FarmsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean editFarm(Farm farm) {
        //DOESNT WORK
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "update farms set district = ?, management_type = ? , address= ?, nitrogen= ?, phosporus= ?, potassium = ?, ph_level= ? "
                    + "where owner = ? and farm_name = ?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, farm.getDistrict());
            pstmt.setString(2, farm.getManagement_type());

            int i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return i == 1;
        } catch (SQLException ex) {
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
            ResultSet rs = pstmt.executeQuery();
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

    public Farm getAllFieldDetails(int fid) {

        Farm farm = null;
        farm = getBasicFieldDetails(fid);
        // farmproductiondetails
        farm.setSoilanalysis(getFieldSoilAnalysis(farm.getId()));
        farm.setFertilizer(getFieldFertilizers(farm.getId(),2015));
        farm.setTillers(getFieldTillers(farm.getId(),2015));
        farm.setCropVal(getFieldCropValidation(farm.getId(),2015));
        return farm;
    }

    public Farm getBasicFieldDetails(int fid) {
        // **** TODO : GET (INTEGER)YEAR TO GIVE TO FERTILIZER, TILLERS,CROP VALIDATION AND MONTHLY
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select id,Farmers_name,barangay,municipality,area from fields where id=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, fid);
            ResultSet rs = pstmt.executeQuery();

            Farm farm = null;
            if (rs.next()) {

                farm = new Farm();
                farm.setId(fid);
                farm.setFarmer("Farmers_name");
                farm.setArea(rs.getDouble("area"));
                farm.setBarangay(rs.getString("barangay"));
                farm.setMunicipality(rs.getString("municipality"));
               
            }
            rs.close();
            pstmt.close();
            conn.close();
            return farm;
        } catch (SQLException ex) {
            Logger.getLogger(FarmsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public SoilAnalysis getFieldSoilAnalysis(int id) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select id,ph_level,organic_matter,phosporus,potassium from soilanalysis s where id=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            SoilAnalysis sa = null;
            if (rs.next()) {
                sa = new SoilAnalysis();
                sa.setField_id(id);
                sa.setPh_lvl(rs.getDouble("ph_level"));
                sa.setOrganic_matter(rs.getDouble("organic_matter"));
                sa.setPhosphorus(rs.getDouble("phosporus"));
                sa.setPh_lvl(rs.getDouble("potassium"));

            }
            rs.close();
            pstmt.close();
            conn.close();
            return sa;
        } catch (SQLException ex) {
            Logger.getLogger(FarmsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Fertilizer getFieldFertilizers(int id,int year) {
        // DB HAS MULTIPLE FOR THE SAME YEAR 
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select year,Fields_id,fertilizer,first_dose,second_dose from fertilizers where  Fields_id=? and year=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
              pstmt.setInt(2, year);
            ResultSet rs = pstmt.executeQuery();
            Fertilizer fz = null;
            if (rs.next()) {
                fz = new Fertilizer();
                fz.setYear(rs.getInt("year"));
                fz.setFields_id(id);
                fz.setFertilizer(rs.getString("fertilizer"));
                fz.setFirst_dose(rs.getDouble("first_dose"));
                fz.setSecond_dose(rs.getDouble("second_dose"));

            }
            rs.close();
            pstmt.close();
            conn.close();
            return fz;
        } catch (SQLException ex) {
            Logger.getLogger(FarmsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Tillers getFieldTillers(int id, int year) {
        //TODO YEAR
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select year,Fields_id,rep,count from tillers where Fields_id=? and year=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.setInt(2, year);
            ResultSet rs = pstmt.executeQuery();
            Tillers til = null;
            if (rs.next()) {
                til = new Tillers();
                til.setYear(rs.getInt("year"));
                til.setFields_id(id);
                til.setRep(rs.getInt("rep"));
                til.setCount(rs.getInt("count"));

            }
            rs.close();
            pstmt.close();
            conn.close();
            return til;
        } catch (SQLException ex) {
            Logger.getLogger(FarmsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public CropValidation getFieldCropValidation(int id,int year) {
        //TODO YEAR
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select cs.year,cs.Fields_id,cs.variety,cs.crop_class,cs.texture,cs.farming_system,cs.topography,cs.furrow_distance,cs.planting_density,cs.harvest_date,cs.date_millable,cs.num_millable,cs.avg_millable_stool,cs.brix,cs.stalk_length,cs.diameter,cs.weight from cropvalidationsurveys cs where Fields_id=? and year=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
               pstmt.setInt(2, year);
            ResultSet rs = pstmt.executeQuery();
            CropValidation cv = null;
            if (rs.next()) {
                cv = new CropValidation();
                cv.setYear(rs.getInt("year"));
                  cv.setField_id(rs.getInt("Fields_id"));
                 cv.setVariety(rs.getString("variety"));
                 cv.setCrop_class(rs.getString("crop_class"));
                 cv.setTexture(rs.getString("texture"));
                 cv.setFarming_system(rs.getString("farming_system"));
                 cv.setTopography(rs.getString("topography"));
                 cv.setFurrow_distance(rs.getDouble("furrow_distance"));
                 cv.setPlanting_density(rs.getDouble("planting_density"));
                 cv.setHarvest_date(rs.getDate("harvest_date"));
                 cv.setDate_millable(rs.getDate("date_millable"));
                 cv.setNum_millable(rs.getInt("num_millable"));
                 cv.setAvg_millable_stool(rs.getDouble("avg_millable_stool"));
                 cv.setBrix(rs.getDouble("brix"));
                 cv.setStalk_length(rs.getDouble("stalk_length"));
                 cv.setDiameter(rs.getDouble("diameter"));
                 cv.setWeight(rs.getDouble("weight"));
            }
            rs.close();
            pstmt.close();
            conn.close();
            return cv;
        } catch (SQLException ex) {
            Logger.getLogger(FarmsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
