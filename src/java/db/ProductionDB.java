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
import entity.brgySummary;
import entity.municipalSummary;
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
                    System.out.println(brgy.getBarangay());
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

    public ArrayList<municipalSummary> viewMunicipalSummaryDet(String muni) {
        ArrayList<municipalSummary> mslist = new ArrayList<>();
        ArrayList<Integer> categ = getDistinctHistProdYrsASC(2015);
        for (int i = 0; i < categ.size(); i++) {
            mslist.add(viewMunicipalSummarybyYear(muni,categ.get(i)));
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
           farm=viewFarmerSummarybyYear(farmers.get(i),year);
            mslist.add(farm);
        }
        return mslist;

    }
   public ArrayList<Farmer> viewFarmerBrgyTable(String brgy,int curyear){
        ArrayList<Farmer> mslist = new ArrayList<>();
      ArrayList<String> farmers = getDistinctFarmerForBrgy(brgy);
      for(int i=0; i<farmers.size();i++){
          Farmer nbs=viewOtherFarmerBasicDet(farmers.get(i));
          Farmer pbs= viewFarmerSummarybyYear(farmers.get(i),curyear);
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

 
    public Farmer viewFarmerSummarybyYear(String farmer,int year) {
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
//          pstmt.setString(1, muni);
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
