/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Calendar;
import entity.CropAssessment;
import entity.Farmer;
import entity.ProdBarangay;
import entity.Production;
import entity.Programs;
import entity.brgySummary;
import entity.municipalSummary;
import entity.prodMunicipality;
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
public class ProductionDB {

     public String getDistrictProductionAvg(int curyr,String district) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select ROUND(avg(actual),2) as avg from weeklyestimate where year=? and district=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, curyr);
            pstmt.setString(2, district);
            ResultSet rs = pstmt.executeQuery();
          String production=null;

            if (rs.next()) {
             production=rs.getString("avg");
            }
            rs.close();
            pstmt.close();
            conn.close();

            return production;
        } catch (SQLException ex) {
            Logger.getLogger(CropEstimateDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
     public String getDistrictAreaAvgTest1(int curyr,String muni,String district) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select IFNULL(avg(t1.tarea),0) as avg from(select sum(area) as tarea from fields f where f.district=? group by f.barangay)t1;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, district);
            ResultSet rs = pstmt.executeQuery();
          String production=null;

            if (rs.next()) {
             production=rs.getString("avg");
            }
            rs.close();
            pstmt.close();
            conn.close();

            return production;
        } catch (SQLException ex) {
            Logger.getLogger(CropEstimateDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
     public String getFarmersAreaAvgTest1(int curyr,String muni,String district) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select IFNULL(avg(f.area),0) as avg from fields f where f.district=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, district);
            ResultSet rs = pstmt.executeQuery();
          String production=null;

            if (rs.next()) {
             production=rs.getString("avg");
            }
            rs.close();
            pstmt.close();
            conn.close();

            return production;
        } catch (SQLException ex) {
            Logger.getLogger(CropEstimateDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
     public String getDistrictProductionAvgTest3(int curyr,String muni,String district) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select round(avg(t1.tc),2) as avg\n" +
"from (\n" +
"select fd.barangay, f.name , sum(hp.tons_cane) as'tc'\n" +
"from historicalproduction hp join farmers f on hp.farmers_name = f.name right join fields fd on f.name = fd.farmers_name\n" +
"where year = ? and fd.district= ?\n" +
"group by fd.barangay, f.name) t1";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, curyr);
            pstmt.setString(2, district);
            ResultSet rs = pstmt.executeQuery();
          String production=null;

            if (rs.next()) {
             production=rs.getString("avg");
            }
            rs.close();
            pstmt.close();
            conn.close();

            return production;
        } catch (SQLException ex) {
            Logger.getLogger(CropEstimateDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
     public String getDistrictProductionAvgTest4(int curyr,String muni,String district) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select round(avg(hp.tons_cane),2) as avg\n" +
"from historicalproduction hp join farmers f on hp.farmers_name = f.name right join fields fd on f.name = fd.farmers_name\n" +
"where year = ? and fd.district= ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, curyr);
            pstmt.setString(2, district);
            ResultSet rs = pstmt.executeQuery();
          String production=null;

            if (rs.next()) {
             production=rs.getString("avg");
            }
            rs.close();
            pstmt.close();
            conn.close();

            return production;
        } catch (SQLException ex) {
            Logger.getLogger(CropEstimateDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
     public String getDistrictProductionAvgTest2(int curyr,String district) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select ROUND(avg(actual),2) as avg from weeklyestimate where year<2016 and district=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
//            pstmt.setInt(1, curyr);
            pstmt.setString(1, district);
            ResultSet rs = pstmt.executeQuery();
          String production=null;

            if (rs.next()) {
             production=rs.getString("avg");
            }
            rs.close();
            pstmt.close();
            conn.close();

            return production;
        } catch (SQLException ex) {
            Logger.getLogger(CropEstimateDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    public ArrayList<Integer> getDistinctProdYrs(int curyr) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select Distinct(year) from production where year<=? order by year DESC;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, curyr);
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
    public ArrayList<Integer> getDistinctHistProdYrs(int curyr) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select Distinct(year) from historicalproduction where year<=? order by year DESC;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, curyr);
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
    public ArrayList<Integer> getDistinctHistProdYrsASC(int curyr) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select Distinct(year) from historicalproduction where year<=? order by year ASC;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, curyr);
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
    public ArrayList<String> getDistinctBrgyForMunic(String muni) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select Distinct barangay from fields f where f.municipality=? ;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, muni);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<String> list = null;

            if (rs.next()) {
                list = new ArrayList<>();
                do {
                    list.add(rs.getString("barangay"));
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
    public ArrayList<String> getDistinctFarmerForBrgy(String brgy) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select Distinct farmers_name from fields f where f.barangay=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, brgy);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<String> list = null;

            if (rs.next()) {
                list = new ArrayList<>();
                do {
                    list.add(rs.getString("farmers_name"));
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

    public ArrayList<prodMunicipality> getProdMunicipalforYear(int year) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select DISTINCT f.municipality from historicalproduction p  join fields f on p.Farmers_name=f.Farmers_name where p.year=? group by f.municipality;";

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<prodMunicipality> list = new ArrayList<>();
            if (rs.next()) {

                do {
                    prodMunicipality municipal = new prodMunicipality();
                    municipal.setYear(year);
                    municipal.setMunicipal(rs.getString("municipality"));
//                    System.out.println(municipal.getMunicipal());
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
    public ArrayList<prodMunicipality> getCurrProdMunicipalforYear(int year) {
        try {
            CalendarDB caldb= new CalendarDB();
   ArrayList<Calendar> calist= caldb.getCurrentYearDetails();
   Date todayDate =calist.get(0).getTodayDate();
   
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select distinct f.municipality from production p join fields f on p.fields_id=f.id where year=? and date<=?;";

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            pstmt.setDate(2, todayDate);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<prodMunicipality> list = new ArrayList<>();
            if (rs.next()) {

                do {
                    prodMunicipality municipal = new prodMunicipality();
                    municipal.setYear(year);
                    municipal.setMunicipal(rs.getString("municipality"));
                    System.out.println(municipal.getMunicipal()+"THE MUNI");
//                    System.out.println(municipal.getMunicipal());
                    municipal.setBrgy(getCurrProdBarangayforYear(municipal,todayDate));
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

    public ArrayList<ProdBarangay> getProdBarangayforYear(prodMunicipality pm) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select DISTINCT f.barangay from historicalproduction p left join fields f on p.Farmers_name=f.Farmers_name where p.year=? and f.municipality=? group by f.barangay;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, pm.getYear());
            pstmt.setString(2, pm.getMunicipal());
            ResultSet rs = pstmt.executeQuery();
            ArrayList<ProdBarangay> list = new ArrayList<>();
            if (rs.next()) {
                do {
                    ProdBarangay brgy = new ProdBarangay();
                    brgy.setBarangay(rs.getString("barangay"));
//                    System.out.println(brgy.getBarangay());
                    brgy.setFarmer(getProdFarmerforYear(pm, brgy));
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
    public ArrayList<ProdBarangay> getCurrProdBarangayforYear(prodMunicipality pm,Date todayDate) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select distinct f.barangay from production p join fields f on p.fields_id=f.id where f.municipality=? and year=? and date<=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
           
            pstmt.setString(1, pm.getMunicipal());
             pstmt.setInt(2, pm.getYear());
            pstmt.setDate(3, todayDate);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<ProdBarangay> list = new ArrayList<>();
            if (rs.next()) {
                do {
                    ProdBarangay brgy = new ProdBarangay();
                    brgy.setBarangay(rs.getString("barangay"));
                    System.out.println(brgy.getBarangay()+"THE BRGY");
//                    System.out.println(brgy.getBarangay());
                    brgy.setFarmer(getCurrProdFarmerforYear(pm, brgy,todayDate));
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

    public ArrayList<Farmer> getProdFarmerforYear(prodMunicipality pm, ProdBarangay pb) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            //   String query= "select sum(p.tons_cane) as tTons_cane ,p.farmers_name from historicalproduction p join fields f on p.Farmers_name=f.Farmers_name where p.year=? and f.municipality=? and f.barangay=? group by f.Farmers_name;";
            String query = "select p.tons_cane as tTons_cane ,p.farmers_name from historicalproduction p left join fields f on p.Farmers_name=f.Farmers_name where p.year=? and f.municipality=? and f.barangay=? group by f.Farmers_name;";

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, pm.getYear());
            pstmt.setString(2, pm.getMunicipal());
            pstmt.setString(3, pb.getBarangay());
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Farmer> list = new ArrayList<>();
            if (rs.next()) {
                do {
                    Farmer farmer = new Farmer();
                    farmer.setName(rs.getString("farmers_name"));
                    //  System.out.println(farmer.getName());
                    farmer.setProduction(rs.getDouble("tTons_cane") + 1);
                    farmer.setTotalArea(getFarmerTotalArea(pm,pb,farmer.getName()));
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
    public ArrayList<Farmer> getCurrProdFarmerforYear(prodMunicipality pm, ProdBarangay pb,Date todayDate) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            //   String query= "select sum(p.tons_cane) as tTons_cane ,p.farmers_name from historicalproduction p join fields f on p.Farmers_name=f.Farmers_name where p.year=? and f.municipality=? and f.barangay=? group by f.Farmers_name;";
            String query = "select sum(p.tons_cane) as tTons_cane ,f.farmers_name from production p join fields f on p.fields_id=f.id where f.municipality=? and f.barangay=? and year=? and date<=? group by f.farmers_name;";

            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, pm.getMunicipal());
            pstmt.setString(2, pb.getBarangay());
            pstmt.setInt(3, pm.getYear());
            pstmt.setDate(4, todayDate);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Farmer> list = new ArrayList<>();
            if (rs.next()) {
                do {
                    Farmer farmer = new Farmer();
                    farmer.setName(rs.getString("farmers_name"));
                    System.out.println(farmer.getName()+"THE FNAME");
                    //  System.out.println(farmer.getName());
                    farmer.setProduction(rs.getDouble("tTons_cane") + .01);
                    farmer.setTotalArea(getCurrFarmerHarvestArea(pm,pb,farmer.getName(),todayDate));
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
    public Double getFarmerTotalArea(prodMunicipality pm, ProdBarangay pb,String farmer) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            //   String query= "select sum(p.tons_cane) as tTons_cane ,p.farmers_name from historicalproduction p join fields f on p.Farmers_name=f.Farmers_name where p.year=? and f.municipality=? and f.barangay=? group by f.Farmers_name;";
            String query = "select IFNULL(sum(area),0) as tarea from fields f where f.municipality=? and f.barangay=? and f.farmers_name=?;";

            PreparedStatement pstmt = conn.prepareStatement(query);
          
            pstmt.setString(1, pm.getMunicipal());
            pstmt.setString(2, pb.getBarangay());
             pstmt.setString(3, farmer);
            ResultSet rs = pstmt.executeQuery();
           Double tarea=null;
            if (rs.next()) {
               tarea=rs.getDouble("tarea");
            }
            rs.close();
            pstmt.close();
            conn.close();
            return tarea;

        } catch (SQLException ex) {
            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    public Double getCurrFarmerHarvestArea(prodMunicipality pm, ProdBarangay pb,String farmer,Date todayDate) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            //   String query= "select sum(p.tons_cane) as tTons_cane ,p.farmers_name from historicalproduction p join fields f on p.Farmers_name=f.Farmers_name where p.year=? and f.municipality=? and f.barangay=? group by f.Farmers_name;";
            String query = "select ifnull(sum(p.area_harvested),0) as tHA ,f.farmers_name from production p join fields f on p.fields_id=f.id where f.municipality=? and f.barangay=? and f.farmers_name=? and year=? and date<=? group by f.farmers_name;";

            PreparedStatement pstmt = conn.prepareStatement(query);
          
            pstmt.setString(1, pm.getMunicipal());
            pstmt.setString(2, pb.getBarangay());
             pstmt.setString(3, farmer);
             pstmt.setInt(4, pm.getYear());
             pstmt.setDate(5, todayDate);
            ResultSet rs = pstmt.executeQuery();
           Double tarea=null;
            if (rs.next()) {
               tarea=rs.getDouble("tHA");
            }
            rs.close();
            pstmt.close();
            conn.close();
            return tarea;

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

    public ArrayList<municipalSummary> viewMunicipalSummaryDet(String muni) {
        ArrayList<municipalSummary> mslist = new ArrayList<>();
        ArrayList<Integer> categ = getDistinctHistProdYrsASC(2015);
        
        for (int i = 0; i < categ.size(); i++) {
            mslist.add(viewMunicipalSummarybyYear(muni,categ.get(i)));
            String district="TARLAC";
//        String average = getDistrictProductionAvg(categ.get(i),district);
//        String average = getDistrictProductionAvg(categ.get(i),district);
        }
        return mslist;

    }
    public ArrayList<String> viewDistrictAvgProdSummary() {
           ArrayList<String> mslist = new ArrayList<>();
        ArrayList<Integer> categ = getDistinctHistProdYrsASC(2015);
        
        for (int i = 0; i < categ.size(); i++) {
        String district="TARLAC";
        String average = getDistrictProductionAvgTest2(categ.get(i),district);
       if(average==null){
             mslist.add("0"); 
       }else{
            mslist.add(average); 
       }
     
        }
        return mslist;
    }
    public ArrayList<brgySummary> viewBrgySummaryDet(String brgy) {
        ArrayList<brgySummary> mslist = new ArrayList<>();
        ArrayList<Integer> categ = getDistinctHistProdYrsASC(2015);
        for (int i = 0; i < categ.size(); i++) {
            mslist.add(viewBrgySummarybyYear(brgy,brgy,categ.get(i)));
        }
        return mslist;

    }
 public ArrayList<brgySummary> viewBarangayMuniSummary(int year,String muni) {
        ArrayList<brgySummary> mslist = new ArrayList<>();
        ArrayList<String> brgys = getDistinctBrgyForMunic(muni);
        for (int i = 0; i < brgys.size(); i++) {
            mslist.add(viewBrgySummarybyYear(brgys.get(i),muni,year));
        }
        return mslist;

    }
 public ArrayList<Farmer> viewFarmerBrgySummary(int year,String brgy) {
        ArrayList<Farmer> mslist = new ArrayList<>();
        ArrayList<String> farmers = getDistinctFarmerForBrgy(brgy);
        for (int i = 0; i < farmers.size(); i++) {
//            System.out.println(farmers.get(i)+"hoopa");
            Farmer farm=new Farmer();
           farm=viewFarmerSummarybyYear(brgy,farmers.get(i),year);
            mslist.add(farm);
        }
        return mslist;

    }
   public ArrayList<Farmer> viewFarmerBrgyTable(String brgy,int curyear){
        ArrayList<Farmer> mslist = new ArrayList<>();
      ArrayList<String> farmers = getDistinctFarmerForBrgy(brgy);
      for(int i=0; i<farmers.size();i++){
          Farmer nbs=viewOtherFarmerBasicDet(farmers.get(i));
          Farmer pbs= viewFarmerSummarybyYear(brgy,farmers.get(i),curyear);
           nbs.setProduction(pbs.getProduction());
           nbs.setYear(pbs.getYear());
           Double yield=pbs.getProduction()/nbs.getTotalArea();
           nbs.setCurYield(yield);
          mslist.add(nbs);
       }
     return mslist;
        
        
    }
  public ArrayList<brgySummary> viewBrgyMuniTable(String muni,int curyear){
        ArrayList<brgySummary> mslist = new ArrayList<>();
      ArrayList<String> brgys = getDistinctBrgyForMunic(muni);
      for(int i=0; i<brgys.size();i++){
          brgySummary nbs=viewBrgyBasicDet(brgys.get(i));
          brgySummary pbs= viewBrgySummarybyYear(brgys.get(i),muni,curyear);
           nbs.setActual(pbs.getActual());
           nbs.setYear(pbs.getYear());
           Double yield=pbs.getActual()/nbs.getArea();
           nbs.setYield(yield);
          mslist.add(nbs);
       }
     return mslist;
        
        
    }

 
    public Farmer viewFarmerSummarybyYear(String brgy,String farmer,int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select sum(hp.tons_cane) as production,hp.year from historicalproduction hp where hp.farmers_name=? and year=?;";
               PreparedStatement pstmt = conn.prepareStatement(query);
//          pstmt.setString(1, muni);
          pstmt.setString(1, farmer);
          pstmt.setInt(2, year);
               ResultSet rs = pstmt.executeQuery();
            Farmer ms = new Farmer();
             ms.setName(farmer);
            if (rs.next()) {
//                ms = new Farmer();
               
//                System.out.println(farmer+"fahmr");
                ms.setProduction(rs.getDouble("production"));
                ms.setYear(rs.getString("year"));
                ms.setTotalArea(viewAreaFarmerSummarybyYear(brgy,farmer,year));
            }
            rs.close();
            pstmt.close();
            conn.close();
            return ms;
        } catch (SQLException ex) {
            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
             }
//    public brgySummary viewBrgySummarybyYear(String brgy,String muni,int year) {
//        try {
//            // put functions here : previous week production, this week production
//            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
//            Connection conn = myFactory.getConnection();
//            String query = "select sum(hp.tons_cane)as production, hp.year\n" +
//"from historicalproduction hp \n" +
//"where hp.Farmers_name in (\n" +
//"						select Farmers_name\n" +
//"                        from fields f\n" +
//"                        where f.barangay=?\n" +
//"						) and year=? \n" +
//"group by year;";
//               PreparedStatement pstmt = conn.prepareStatement(query);
////          pstmt.setString(1, muni);
//          pstmt.setString(1, brgy);
//          pstmt.setInt(2, year);
//               ResultSet rs = pstmt.executeQuery();
//            brgySummary ms = new brgySummary();
//            ms.setBarangay(brgy);
//            if (rs.next()) {
////                ms = 
////                ms.setBarangay(brgy);
//                ms.setActual(rs.getDouble("production"));
//                ms.setYear(rs.getInt("year"));
//            }
//            rs.close();
//            pstmt.close();
//            conn.close();
//            return ms;
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//             }
    public brgySummary viewBrgySummarybyYear(String brgy,String muni,int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select sum(hp.tons_cane)as production, hp.year\n" +
"from historicalproduction hp \n" +
"where hp.Farmers_name in (\n" +
"						select Farmers_name\n" +
"                        from fields f\n" +
"                        where f.barangay=?\n" +
"						) and year=? \n" +
"group by year;";
               PreparedStatement pstmt = conn.prepareStatement(query);
//          pstmt.setString(2, muni);
          pstmt.setString(1, brgy);
          pstmt.setInt(2, year);
               ResultSet rs = pstmt.executeQuery();
            brgySummary ms = new brgySummary();
            ms.setBarangay(brgy);
            if (rs.next()) {
//                ms = 
//                ms.setBarangay(brgy);
                ms.setActual(rs.getDouble("production"));
                ms.setYear(rs.getInt("year"));
               ms.setArea(viewAreaBrgySummarybyYear(brgy,muni,year));
            }
            rs.close();
            pstmt.close();
            conn.close();
            return ms;
        } catch (SQLException ex) {
            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
             }
    public Double viewAreaBrgySummarybyYear(String brgy,String muni,int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select IFNULL(sum(area), 0) as tarea from fields f where f.municipality=? and f.barangay=?;";
               PreparedStatement pstmt = conn.prepareStatement(query);
//          pstmt.setString(2, muni);
          pstmt.setString(1, muni);
          pstmt.setString(2, brgy);
//          pstmt.setInt(2, year);
      
               ResultSet rs = pstmt.executeQuery();
          Double area=null;
         
            if (rs.next()) {
//                ms = 
//                ms.setBarangay(brgy);
                area=rs.getDouble("tarea");
               
            }
            rs.close();
            pstmt.close();
            conn.close();
            return area;
        } catch (SQLException ex) {
            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
             }
    public Double viewAreaFarmerSummarybyYear(String brgy,String farmer,int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select IFNULL(sum(area), 0) as tarea from fields f where f.barangay=? and f.farmers_name=?;";
               PreparedStatement pstmt = conn.prepareStatement(query);
//          pstmt.setString(2, muni);
         
          pstmt.setString(1, brgy);
          pstmt.setString(2, farmer);
//          pstmt.setInt(2, year);
      
               ResultSet rs = pstmt.executeQuery();
          Double area=null;
         
            if (rs.next()) {
//                ms = 
//                ms.setBarangay(brgy);
                area=rs.getDouble("tarea");
               
            }
            rs.close();
            pstmt.close();
            conn.close();
            return area;
        } catch (SQLException ex) {
            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
             }
    public municipalSummary viewMunicipalSummarybyYear(String muni,int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select sum(hp.tons_cane)as production, hp.year\n"
                    + "from historicalproduction hp \n"
                    + "where hp.Farmers_name in (\n"
                    + "						select Farmers_name\n"
                    + "                        from fields f\n"
                    + "                        where f.municipality=? \n"
                    + "						) and year=? \n"
                    + "group by year;";
               PreparedStatement pstmt = conn.prepareStatement(query);
          pstmt.setString(1, muni);
          pstmt.setInt(2, year);
               ResultSet rs = pstmt.executeQuery();
            municipalSummary ms = new municipalSummary();
            ms.setMunicipality(muni);
            if (rs.next()) {
//                ms = new municipalSummary();
                ms.setActual(rs.getDouble("production"));
                ms.setYear(rs.getInt("year"));
            }
            rs.close();
            pstmt.close();
            conn.close();
            return ms;
        } catch (SQLException ex) {
            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
             }
    public municipalSummary viewMunicipalSummarybyYearTest2(String muni,int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select tons_cane as production, year from cropestimatemunicipality where year=? and municipality=?;";
               PreparedStatement pstmt = conn.prepareStatement(query);
               pstmt.setInt(1, year);
               pstmt.setString(2, muni);
         
               ResultSet rs = pstmt.executeQuery();
            municipalSummary ms = new municipalSummary();
            ms.setMunicipality(muni);
            if (rs.next()) {
//                ms = new municipalSummary();
                ms.setActual(rs.getDouble("production"));
                ms.setYear(rs.getInt("year"));
            }
            rs.close();
            pstmt.close();
            conn.close();
            return ms;
        } catch (SQLException ex) {
            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
             }
   
    public municipalSummary viewMunicipalBasicDet(String muni) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select f.municipality,sum(f.area) as tarea,count(distinct(farmers_name)) as tfarmers,(select count(f.id) from fields f where f.municipality=?) as tfields from fields f where municipality=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
          pstmt.setString(1, muni);
          pstmt.setString(2, muni);
         
               ResultSet rs = pstmt.executeQuery();
            municipalSummary ms = null;
            if (rs.next()) {
                ms = new municipalSummary();
                ms.setMunicipality(muni);
                ms.setTfarmers(rs.getInt("tfarmers"));
                ms.setTfields(rs.getInt("tfields"));
                ms.setArea(rs.getDouble("tarea"));
            }
            rs.close();
            pstmt.close();
            conn.close();
            return ms;
        } catch (SQLException ex) {
            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    
    public brgySummary viewBrgyBasicDet(String brgy) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select barangay,sum(f.area) as tarea,count(distinct(farmers_name)) as tfarmers,(select count(f.id) from fields f where f.barangay=?) as tfields from fields f where barangay=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
          pstmt.setString(1, brgy);
          pstmt.setString(2, brgy);
         
               ResultSet rs = pstmt.executeQuery();
            brgySummary ms = null;
            if (rs.next()) {
                ms = new brgySummary();
                ms.setBarangay(brgy);
                ms.setTfarmers(rs.getInt("tfarmers"));
                ms.setTfields(rs.getInt("tfields"));
                ms.setArea(rs.getDouble("tarea"));
            }
            rs.close();
            pstmt.close();
            conn.close();
            return ms;
        } catch (SQLException ex) {
            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
     public Farmer viewOtherFarmerBasicDet(String farmer) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select barangay,sum(f.area) as tarea,(select count(f.id) from fields f where f.farmers_name=?) as tfields from fields f where farmers_name=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
          pstmt.setString(1, farmer);
          pstmt.setString(2, farmer);
         
               ResultSet rs = pstmt.executeQuery();
            Farmer ms = null;
            if (rs.next()) {
                ms = new Farmer();
                ms.setName(farmer);
                ms.setTfarms(rs.getInt("tfields"));
                ms.setTotalArea(rs.getDouble("tarea"));
            }
            rs.close();
            pstmt.close();
            conn.close();
            return ms;
        } catch (SQLException ex) {
            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
