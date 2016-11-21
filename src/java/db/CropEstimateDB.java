/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Calendar;
import entity.MonthlyCropEstimate;
import entity.cropEstimate;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.openforecast.DataPoint;
import net.sourceforge.openforecast.DataSet;
import net.sourceforge.openforecast.Forecaster;
import net.sourceforge.openforecast.ForecastingModel;
import net.sourceforge.openforecast.Observation;

/**
 *
 * @author ndrs
 */
public class CropEstimateDB {

    public boolean selectEstimates(Double area, Double rain, Double tiller, Double temp) {
        cropEstimate fce = new cropEstimate();
        cropEstimate ce = new cropEstimate();
        ce.setArea(area);
        ce.setRainfall(rain);
        fce.setArea(area);
        fce.setRainfall(rain);
        ArrayList<cropEstimate> ces = viewAllDiffEstimates();

        fce.setForecasted(genForecast1(ce, ces));
        if (tiller != null) {
            ce.setTiller(tiller);
            fce.setTiller(tiller);
            fce.setForecast2(genForecast2(ce, ces));
        }
        if (temp != null) {
            ce.setTemp(temp);
            fce.setTemp(temp);
            fce.setForecast3(genForecast3(ce, ces));
        }

        inputTestEstimates(fce);

        //method to input forecasts to db
        return true;
    }

    public boolean selectEstimates(Double area, Double production, Double rain, Double tiller, Double temp) {
        cropEstimate fce = new cropEstimate();
        cropEstimate ce = new cropEstimate();
        ce.setArea(area);
        ce.setActual(production);
        ce.setRainfall(rain);
        fce.setArea(area);
        fce.setActual(production);
        fce.setRainfall(rain);
        ArrayList<cropEstimate> ces = viewAllDiffEstimates();
        ArrayList<cropEstimate> tests = viewTestEstimates();
        if (tests != null) {
            ces.addAll(tests);
        }
        for (int i = 0; i < ces.size(); i++) {
            System.out.println(ces.get(i).getActual());
        }
        fce.setForecasted(genForecast1(ce, ces));
        if (tiller != null) {
            ce.setTiller(tiller);
            fce.setTiller(tiller);
            fce.setForecast2(genForecast2(ce, ces));
        }
        if (temp != null) {
            ce.setTemp(temp);
            fce.setTemp(temp);
            fce.setForecast3(genForecast3(ce, ces));
        }

        inputTestEstimates(fce);

        //method to input forecasts to db
        return true;
    }

    public boolean updateDistrictEstimate(cropEstimate ce) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "UPDATE cropestimatedistrict set area=?,rainfall=?,avg_temperature=?,tiller_count=?,actual_tons_cane=?,forecasted1=?, forecasted2=?, forecasted3=? where year=? and district=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);

            
            
            pstmt.setDouble(1, ce.getArea());
            pstmt.setDouble(2, ce.getRainfall());
            pstmt.setDouble(3, ce.getTemp());
            pstmt.setDouble(4, ce.getTiller());
            pstmt.setDouble(5,ce.getActual());
            pstmt.setDouble(6, ce.getForecasted());
            pstmt.setDouble(7, ce.getForecast2());
            pstmt.setDouble(8, ce.getForecast3());
            pstmt.setInt(9, ce.getYear());
            pstmt.setString(10, "TARLAC");
            int isSuccess = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

            return isSuccess == 1;
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean inputEstimates(cropEstimate ce) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "INSERT INTO cropestimatedistrict (year,district,forecasted1, forecasted2, forecasted3,forecast) VALUES (?,?,?,?,?,0);";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, ce.getYear());
            pstmt.setString(2, "TARLAC");
            pstmt.setDouble(3, ce.getForecasted());
            pstmt.setDouble(4, ce.getForecast2());
            pstmt.setDouble(5, ce.getForecast3());
            int isSuccess = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

            return isSuccess == 1;
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean updateForecastSelection(cropEstimate ce) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "UPDATE cropestimatedistrict SET forecast=? where year=? and district=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, ce.getSelection());
            pstmt.setInt(2, ce.getYear());
            pstmt.setString(3, "TARLAC");

            int isSuccess = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

            return isSuccess == 1;
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean deleteSelectedTest(int id) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "DELETE FROM cropestimatetests where id=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            int isSuccess = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

            return isSuccess == 1;
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean deleteSelectedDistrictYear(int id) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "DELETE FROM cropestimatedistrict where year=? and district=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.setString(2, "TARLAC");
            int isSuccess = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

            return isSuccess == 1;
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean inputTestEstimates(cropEstimate ce) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "INSERT INTO cropestimatetests (district,area,actual_tons_cane,rainfall,avg_temperature,tiller_count,forecast1, forecast2, forecast3) VALUES (?,?,?,?,?,?,ROUND(?,3),ROUND(?,3),ROUND(?,3));";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, "TARLAC");
            pstmt.setDouble(2, ce.getArea());
            pstmt.setDouble(3, ce.getActual());
            pstmt.setDouble(4, ce.getRainfall());
            pstmt.setDouble(5, ce.getTemp());
            pstmt.setDouble(6, ce.getTiller());
            DecimalFormat df = new DecimalFormat("#.###");
            System.out.println(ce.getForecasted());
            System.out.println(ce.getForecast2());
            System.out.println(ce.getForecast3());

            pstmt.setDouble(7, ce.getForecasted());
            pstmt.setDouble(8, ce.getForecast2());
            pstmt.setDouble(9, ce.getForecast3());
            int isSuccess = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

            return isSuccess == 1;
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public cropEstimate getTotalCurrDisProduction(int curyr, Date todayDate) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select IFNULL(sum(tons_cane),0) as tc,IFNULL(sum(area_harvested),0) as ha from production where year=? and date <=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, curyr);
            pstmt.setDate(2, todayDate);
            ResultSet rs = pstmt.executeQuery();
            cropEstimate ce = null;

            if (rs.next()) {
                ce = new cropEstimate();
                ce.setActual(rs.getDouble("tc"));
                ce.setArea(rs.getDouble("ha"));
            }
            rs.close();
            pstmt.close();
            conn.close();

            return ce;
        } catch (SQLException ex) {
            Logger.getLogger(CropEstimateDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public double genForecast1(cropEstimate ce, ArrayList<cropEstimate> ces) {
        DataSet observedData = new DataSet();
        Observation dp;
//        ArrayList<cropEstimate> ces = new ArrayList();
//          ArrayList<Integer> yrlist= getDistinctYearEstYears();
//        ces = viewAllDiffEstimates();
  System.out.println(ces.size() + "size data");
        for (int i = 0; i < ces.size(); i++) {
            System.out.println(ces.size() + "size data`");
             System.out.println(ces.get(i).getArea() + "area data");
            dp = new Observation(ces.get(i).getActual());
            dp.setIndependentValue("area", ces.get(i).getArea());
            dp.setIndependentValue("rainfall", ces.get(i).getRainfall());
            observedData.add(dp);
        }
        System.out.println(observedData + "obsr data");

        ForecastingModel forecaster = Forecaster.getBestForecast(observedData);

        System.out.println("Forecast model type selected: " + forecaster.getForecastType());
        System.out.println(forecaster.toString());

        Observation forecastvalue = new Observation(0.0);
        forecastvalue.setIndependentValue("area", ce.getArea());
        forecastvalue.setIndependentValue("rainfall", ce.getRainfall());

        DataSet fcDataSet = new DataSet();
        fcDataSet.add(forecastvalue);
        Iterator itt = fcDataSet.iterator();

        while (itt.hasNext()) {
            DataPoint d = (DataPoint) itt.next();
            forecaster.forecast(forecastvalue);
        }
        System.out.println("TC:" + forecastvalue.getDependentValue());

        System.out.println("Output data, forecast values");

        return forecastvalue.getDependentValue();
    }
    public double genLKGForecast1(cropEstimate ce, ArrayList<cropEstimate> ces) {
        DataSet observedData = new DataSet();
        Observation dp;
//        ArrayList<cropEstimate> ces = new ArrayList();
//          ArrayList<Integer> yrlist= getDistinctYearEstYears();
//        ces = viewAllDiffEstimates();
  System.out.println(ces.size() + "size data");
        for (int i = 0; i < ces.size(); i++) {
            System.out.println(ces.size() + "size data`");
             System.out.println(ces.get(i).getArea() + "area data");
            dp = new Observation(ces.get(i).getLkg());
            dp.setIndependentValue("area", ces.get(i).getArea());
            dp.setIndependentValue("rainfall", ces.get(i).getRainfall());
            observedData.add(dp);
        }
        System.out.println(observedData + "obsr data");

        ForecastingModel forecaster = Forecaster.getBestForecast(observedData);

        System.out.println("Forecast model type selected: " + forecaster.getForecastType());
        System.out.println(forecaster.toString());

        Observation forecastvalue = new Observation(0.0);
        forecastvalue.setIndependentValue("area", ce.getArea());
        forecastvalue.setIndependentValue("rainfall", ce.getRainfall());

        DataSet fcDataSet = new DataSet();
        fcDataSet.add(forecastvalue);
        Iterator itt = fcDataSet.iterator();

        while (itt.hasNext()) {
            DataPoint d = (DataPoint) itt.next();
            forecaster.forecast(forecastvalue);
        }
        System.out.println("TC:" + forecastvalue.getDependentValue());

        System.out.println("Output data, forecast values");

        return forecastvalue.getDependentValue();
    }

    public cropEstimate getEstimatePreviousYear(int currYear) {
        cropEstimate ce = null;
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select avg(area), avg(rainfal), avg(actual_lkg)\n"
                    + "from weeklyestimate\n"
                    + "where year = ? -1;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, currYear);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                ce = new cropEstimate();
                ce.setArea(rs.getDouble("avg(area)"));
                ce.setRainfall(rs.getDouble("avg(rainfal)"));
                ce.setLkg(rs.getDouble("avg(actual_lkg)"));
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ce;
    }

    public ArrayList<cropEstimate> getWeeklyEstimatePreviousYear(int currYear) {
        ArrayList<cropEstimate> ces = new ArrayList<cropEstimate>();
        cropEstimate ce = null;
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select area, rainfal,actual, actual_lkg \n"
                    + "from weeklyestimate \n"
                    + "where year = ?-1;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, currYear);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ce = new cropEstimate();
                ce.setArea(rs.getDouble("area"));
                ce.setRainfall(rs.getDouble("rainfal"));
                ce.setActual(rs.getDouble("actual"));
                ce.setLkg(rs.getDouble("actual_lkg"));
                ces.add(ce);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ces;
    }

    public double genForecast2(cropEstimate ce, ArrayList<cropEstimate> ces) {
        DataSet observedData = new DataSet();
        Observation dp;
//        ArrayList<cropEstimate> ces = new ArrayList();
//          ArrayList<Integer> yrlist= getDistinctYearEstYears();
//        ces = viewAllDiffEstimates();
        for (int i = 0; i < ces.size(); i++) {
            dp = new Observation(ces.get(i).getActual());
            dp.setIndependentValue("area", ces.get(i).getArea());
            dp.setIndependentValue("rainfall", ces.get(i).getRainfall());
            dp.setIndependentValue("tiller", ces.get(i).getTiller());
            observedData.add(dp);
        }
        System.out.println(observedData + "obsr data");

        ForecastingModel forecaster = Forecaster.getBestForecast(observedData);

        System.out.println("Forecast model type selected: " + forecaster.getForecastType());
        System.out.println(forecaster.toString());

        Observation forecastvalue = new Observation(0.0);
        forecastvalue.setIndependentValue("area", ce.getArea());
        forecastvalue.setIndependentValue("rainfall", ce.getRainfall());
        forecastvalue.setIndependentValue("tiller", ce.getTiller());

        DataSet fcDataSet = new DataSet();
        fcDataSet.add(forecastvalue);
        Iterator itt = fcDataSet.iterator();

        while (itt.hasNext()) {
            DataPoint d = (DataPoint) itt.next();
            forecaster.forecast(forecastvalue);
        }
        System.out.println("TC:" + forecastvalue.getDependentValue());

        System.out.println("Output data, forecast values");

        return forecastvalue.getDependentValue();
    }

    public double genForecast3(cropEstimate ce, ArrayList<cropEstimate> ces) {
        DataSet observedData = new DataSet();
        Observation dp;
//        ArrayList<cropEstimate> ces = new ArrayList();
//          ArrayList<Integer> yrlist= getDistinctYearEstYears();
//        ces = viewAllDiffEstimates();
        for (int i = 0; i < ces.size(); i++) {
            dp = new Observation(ces.get(i).getActual());
            dp.setIndependentValue("area", ces.get(i).getArea());
            dp.setIndependentValue("rainfall", ces.get(i).getRainfall());
            dp.setIndependentValue("tiller", ces.get(i).getTiller());
            dp.setIndependentValue("temp", ces.get(i).getTemp());
            observedData.add(dp);
        }
        System.out.println(observedData + "obsr data");

        ForecastingModel forecaster = Forecaster.getBestForecast(observedData);

        System.out.println("Forecast model type selected: " + forecaster.getForecastType());
        System.out.println(forecaster.toString());

        Observation forecastvalue = new Observation(0.0);
        forecastvalue.setIndependentValue("area", ce.getArea());
        forecastvalue.setIndependentValue("rainfall", ce.getRainfall());
        forecastvalue.setIndependentValue("tiller", ce.getTiller());
        forecastvalue.setIndependentValue("temp", ce.getTemp());

        DataSet fcDataSet = new DataSet();
        fcDataSet.add(forecastvalue);
        Iterator itt = fcDataSet.iterator();

        while (itt.hasNext()) {
            DataPoint d = (DataPoint) itt.next();
            forecaster.forecast(forecastvalue);
        }
        System.out.println("TC:" + forecastvalue.getDependentValue());

        System.out.println("Output data, forecast values");

        return forecastvalue.getDependentValue();
    }

    public cropEstimate viewDistEstbyYear(int year) {
        try {

            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select year,district,area,rainfall,tiller_count,avg_temperature,actual_tons_cane,forecasted1,forecasted2,forecasted3,forecast from cropestimatedistrict where year=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            ResultSet rs = pstmt.executeQuery();
                     
            cropEstimate ce=null;
            if (rs.next()) {
                   ce = new cropEstimate();
                    ce.setYear(rs.getInt("year"));
                    ce.setDistrict(rs.getString("district"));
                    ce.setArea(rs.getDouble("area"));
                    ce.setRainfall(rs.getDouble("rainfall"));
                    ce.setTiller(rs.getDouble("tiller_count"));
                    ce.setTemp(rs.getDouble("avg_temperature"));
                    double actual = rs.getDouble("actual_tons_cane");
                    double estim = rs.getDouble("forecasted1");
                    double estim2 = rs.getDouble("forecasted2");
                    double estim3 = rs.getDouble("forecasted3");
                    int selection = rs.getInt("forecast");
                    ce.setActual(actual);
                    ce.setForecasted(estim);
                    ce.setForecast2(estim2);
                    ce.setForecast3(estim3);
                    ce.setSelection(selection);
                    //    ce.setDifference(getYieldDif(actual,estim));

            }
            rs.close();
            pstmt.close();
            conn.close();
            return ce;

        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<cropEstimate> viewAllDiffEstimates() {
        try {
            ProductionDB prodb = new ProductionDB();
            CalendarDB caldb = new CalendarDB();
            ArrayList<Calendar> calist = caldb.getCurrentYearDetails();
            int cropyr = calist.get(0).getYear();
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select year,district,area,rainfall,tiller_count,avg_temperature,actual_tons_cane,forecasted1,forecasted2,forecasted3,forecast from cropestimatedistrict where year<=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, cropyr);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<cropEstimate> list = null;
            cropEstimate ce;
            if (rs.next()) {
                list = new ArrayList<>();
                do {

                    ce = new cropEstimate();
                    ce.setYear(rs.getInt("year"));
                    ce.setDistrict(rs.getString("district"));

                    ce.setArea(rs.getDouble("area"));
                    ce.setRainfall(rs.getDouble("rainfall"));
                    ce.setTiller(rs.getDouble("tiller_count"));
                    ce.setTemp(rs.getDouble("avg_temperature"));

                    double actual = rs.getDouble("actual_tons_cane");
                    double estim = rs.getDouble("forecasted1");
                    double estim2 = rs.getDouble("forecasted2");
                    double estim3 = rs.getDouble("forecasted3");
                    int selection = rs.getInt("forecast");
                    ce.setActual(actual);
                    ce.setForecasted(estim);
                    ce.setForecast2(estim2);
                    ce.setForecast3(estim3);
                    ce.setSelection(selection);
                    //    ce.setDifference(getYieldDif(actual,estim));
                    list.add(ce);
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

    public ArrayList<cropEstimate> viewTestEstimates() {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select id,area,rainfall,tiller_count,avg_temperature,actual_tons_cane,forecast1,forecast2,forecast3 from cropestimatetests;";
            PreparedStatement pstmt = conn.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();
            ArrayList<cropEstimate> list = null;
            cropEstimate ce;
            if (rs.next()) {
                list = new ArrayList<>();
                do {

                    ce = new cropEstimate();
                    ce.setId(rs.getInt("id"));
                    ce.setArea(rs.getDouble("area"));
                    ce.setRainfall(rs.getDouble("rainfall"));
                    ce.setTiller(rs.getDouble("tiller_count"));
                    ce.setTemp(rs.getDouble("avg_temperature"));
                    double actual = rs.getDouble("actual_tons_cane");
                    double estim = rs.getDouble("forecast1");
                    double estim2 = rs.getDouble("forecast2");
                    double estim3 = rs.getDouble("forecast3");
                    ce.setActual(actual);
                    ce.setForecasted(estim);
                    ce.setForecast2(estim2);
                    ce.setForecast3(estim3);
                    //    ce.setDifference(getYieldDif(actual,estim));
                    list.add(ce);
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

    public ArrayList<cropEstimate> viewDistrictEstimates(int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select year,district,week_ending,area,actual,forecasted from weeklyestimate where year=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<cropEstimate> list = null;
            cropEstimate ce;
            if (rs.next()) {
                list = new ArrayList<>();
                do {

                    ce = new cropEstimate();
                    ce.setYear(rs.getInt("year"));
                    ce.setDistrict(rs.getString("district"));
                    ce.setWeek_ending(rs.getDate("week_ending"));
                    ce.setArea(rs.getDouble("area"));
                    double actual = rs.getDouble("actual");
                    double estim = rs.getDouble("forecasted");
                    ce.setActual(actual);
                    ce.setForecasted(estim);
                    ce.setDifference(getYieldDif(actual, estim));
                    list.add(ce);
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

    public boolean generateYearlyEstimate() {
        CalendarDB caldb = new CalendarDB();

        ArrayList<Calendar> calist = caldb.getCurrentYearDetails();//gets the phases/today/crop yr
        int cropyr = calist.get(0).getYear();
        Date todayDate = calist.get(0).getTodayDate();
        cropEstimate cet = new cropEstimate();

        cropEstimate ce = new cropEstimate();
        cropEstimate fce = new cropEstimate();
        ce = getAverageEstimate();
        fce.setYear(ce.getYear());
        fce.setArea(ce.getArea());
        fce.setRainfall(ce.getRainfall());
        fce.setTiller(ce.getTiller());
        fce.setTemp(ce.getTemp());
        System.out.println(ce.getTemp());
        ArrayList<cropEstimate> ces = viewAllDiffEstimates();
        fce.setForecasted(genForecast1(ce, ces));
        fce.setForecast2(genForecast2(ce, ces));
        fce.setForecast3(genForecast3(ce, ces));
        inputEstimates(fce);

        //method to input forecasts to db
        return true;
    }

    public boolean updateYearlyEstimate() {
        CalendarDB caldb = new CalendarDB();

        ArrayList<Calendar> calist = caldb.getCurrentYearDetails();//gets the phases/today/crop yr
        int cropyr = calist.get(0).getYear();
        Date todayDate = calist.get(0).getTodayDate();
        cropEstimate cet = new cropEstimate();
        cropEstimate fce = new cropEstimate();
        cropEstimate cur = new cropEstimate();
        cur=viewDistEstbyYear(cropyr);
        cet = getTotalCurrDisProduction(cropyr, todayDate);
        fce.setYear(cropyr);
        fce.setActual(cet.getActual());
        fce.setArea(cet.getArea());
        fce.setRainfall(0);
        fce.setTemp(0);
        fce.setTiller(0);
        //get disaster update here 
        //reduce value to forecasted
        
        fce.setForecasted(cur.getForecasted());
        fce.setForecast2(cur.getForecast2());
        fce.setForecast3(cur.getForecast3());
        updateDistrictEstimate(fce);

        //method to input forecasts to db
        return true;
    }

    public boolean generateUpdatedYearlyEstimate() {

        cropEstimate ce = new cropEstimate();
        cropEstimate fce = new cropEstimate();
        ce = getAverageEstimate();
        fce.setYear(ce.getYear());
        fce.setArea(ce.getArea());
        fce.setRainfall(ce.getRainfall());
        fce.setTiller(ce.getTiller());
        fce.setTemp(ce.getTemp());
        ArrayList<cropEstimate> ces = viewAllDiffEstimates();
        fce.setForecasted(genForecast1(ce, ces));
        fce.setForecast2(genForecast2(ce, ces));
        fce.setForecast3(genForecast3(ce, ces));

        inputEstimates(fce);

        //method to input forecasts to db
        return true;
    }

    public cropEstimate getAverageEstimate() {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select max(year)+1 as year,Round(avg(area),0) as area,avg(rainfall) as rainfall,Round(avg(tiller_count),0) as tiller,avg(avg_temperature) as temp from cropestimatedistrict where district=\"tarlac\";";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            cropEstimate ce = null;
            if (rs.next()) {
                ce = new cropEstimate();
                ce.setYear(rs.getInt("year"));
                ce.setArea(rs.getDouble("area"));
                ce.setRainfall(rs.getDouble("rainfall"));
                ce.setTiller(rs.getDouble("tiller"));
                ce.setTemp(rs.getDouble("temp"));
            }
            rs.close();
            pstmt.close();
            conn.close();

            return ce;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean checkExistingCropEstYear(int cropyr) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select * from cropestimatedistrict where year=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, cropyr);
            ResultSet rs = pstmt.executeQuery();

            boolean chrk = false;
            if (rs.next()) {
                chrk = true;
            }
            rs.close();
            pstmt.close();
            conn.close();

            return chrk;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<cropEstimate> viewMunicipalityEstimates(int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select year,district,municipality,area,tons_cane,forecasted from cropestimatemunicipality where year=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<cropEstimate> list = null;
            cropEstimate ce;
            if (rs.next()) {
                list = new ArrayList<>();
                do {

                    ce = new cropEstimate();
                    ce.setYear(rs.getInt("year"));
                    ce.setDistrict(rs.getString("district"));
                    ce.setMunicipality(rs.getString("municipality"));
                    ce.setArea(rs.getDouble("area"));
                    double actual = rs.getDouble("tons_cane");
                    double estim = rs.getDouble("forecasted");
                    ce.setActual(actual);
                    ce.setForecasted(estim);
                    ce.setDifference(getYieldDif(actual, estim));
                    list.add(ce);
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

    public ArrayList<cropEstimate> viewCropEstBarChart() {
        ArrayList<Integer> yrs = getAllDistinctYrsCropEst();
        ArrayList<cropEstimate> list = new ArrayList<>();

        for (Integer yr : yrs) {
            list.add(viewYearlyEstim(yr));
        }
        return list;

    }

    ArrayList<Integer> getAllDistinctYrsCropEst() {
        CalendarDB caldb = new CalendarDB();
        ArrayList<Calendar> calist = caldb.getCurrentYearDetails();
        int cropyr = calist.get(0).getYear();
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            String query = "select Distinct(year) from weeklyestimate where year<=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, cropyr);
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

    public cropEstimate viewYearlyEstim(int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select year ,district,sum(actual) as actual,sum(forecasted) as forecasted from weeklyestimate where year=?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            ResultSet rs = pstmt.executeQuery();

            cropEstimate ce = null;
            if (rs.next()) {

                ce = new cropEstimate();
                ce.setYear(rs.getInt("year"));
                ce.setDistrict(rs.getString("district"));
                double actual = rs.getDouble("actual");
                double estim = rs.getDouble("forecasted");
                ce.setActual(actual);
                ce.setForecasted(estim);
                ce.setMonthcropest(viewMonthDrillEstimate(year));

            }
            rs.close();
            pstmt.close();
            conn.close();

            return ce;
        } catch (SQLException ex) {
            Logger.getLogger(ProblemsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<MonthlyCropEstimate> viewMonthDrillEstimate(int year) {
        try {
            // put functions here : previous week production, this week production
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select year ,district,sum(actual) as sact,sum(forecasted) as sfor,monthname(week_ending) as mos from weeklyestimate where year=? group by MONTH(week_ending) order by week_ending;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, year);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<MonthlyCropEstimate> list = null;
            MonthlyCropEstimate ce;
            if (rs.next()) {
                list = new ArrayList<>();
                do {

                    ce = new MonthlyCropEstimate();
                    ce.setYear(rs.getInt("year"));
                    ce.setDistrict(rs.getString("district"));
                    ce.setMonth(rs.getString("mos"));
                    double actual = rs.getDouble("sact");
                    double estim = rs.getDouble("sfor");
                    ce.settActual(actual);
                    ce.settForc(estim);

                    list.add(ce);
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

    public Double getYieldDif(Double act, Double est) {
        // CHECK IF FORMULA IS RIGHT !~~~ ITS STILL QUESTIONABLE

        double percDiff = (Math.abs(act - est) / (Math.abs((act + est) / 2))) * 100;
        DecimalFormat df = new DecimalFormat(".##");

        double fperc = Double.parseDouble(df.format(percDiff));
        //  double fperc=(percDiff*100.0)/100.0;
        // double roundOff= Math.round(((((f-sf)/sf))*100)*100.0)/100.0;

        return fperc;

    }

    public ArrayList<Integer> getDistinctYears(Integer selection) {
        ArrayList<Integer> taglist = null;
        if (selection == 0) {
            CalendarDB caldb = new CalendarDB();
        ArrayList<Calendar> calist = caldb.getCurrentYearDetails();
        int cropyr = calist.get(0).getYear();
            if(cropyr>2016){
                ProductionDB prodb= new ProductionDB();
                  taglist = getAllDistinctYrsCropEst();
                  taglist.addAll(prodb.getDistinctProdYrsASC(cropyr));
                
            }else{
                taglist = getAllDistinctYrsCropEst();
            }

        } else {
            taglist = getDistinctMunicipalYears();
        }
        return taglist;
    }

    public ArrayList<Integer> getDistinctMunicipalYears() {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select Distinct(year) from cropestimatemunicipality;";
            PreparedStatement pstmt = conn.prepareStatement(query);
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

    public ArrayList<Integer> getDistinctYearEstYears() {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select Distinct(year) from cropestimatedistrict;";
            PreparedStatement pstmt = conn.prepareStatement(query);
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

    public Integer getLastDistinctYear() {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "select MAX(Distinct(year)) as year from cropestimatedistrict;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            Integer x = 0;

            if (rs.next()) {
                x = rs.getInt("year");
            }
            rs.close();
            pstmt.close();
            conn.close();

            return x;
        } catch (SQLException ex) {
            Logger.getLogger(CropEstimateDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void generateForecast() {
        DataSet observedData = new DataSet();
        Observation dp;
        dp = new Observation(751056);

        dp.setIndependentValue("area", 16787.8);
        dp.setIndependentValue("rainfall", 394);

        observedData.add(dp);

        dp = new Observation(579327.67);

        dp.setIndependentValue("area", 14148.47);

        dp.setIndependentValue("rainfall", 326.6);

        observedData.add(dp);

        dp = new Observation(581040.25);
        dp.setIndependentValue("area", 15469.99);

        dp.setIndependentValue("rainfall", 214.2);

        observedData.add(dp);

        dp = new Observation(453216.40);
        dp.setIndependentValue("area", 10300);

        dp.setIndependentValue("rainfall", 580.6);
        observedData.add(dp);

        // idk y dis works even tho i only used one variable for observedData for all the inputs       
        // just to check ur inputs
        System.out.println("Input data, observed values");
        System.out.println(observedData);

        // Obtain a good forecasting model given this data set
        ForecastingModel forecaster = Forecaster.getBestForecast(observedData);

        //For checking what model was used..
        System.out.println("Forecast model type selected: " + forecaster.getForecastType());
        System.out.println(forecaster.toString());

        // Create additional data points for which forecast values are required
        DataSet requiredDataPoints = new DataSet();

        //loop is if we want to generate as many forecasts as we want given we have parameter inputs
        for (int count = 1; count < 2; count++) {
            // tons cane is 0 because we are assumming we don't know the value
            // observation object is for putting all data needed
            Observation dp1 = new Observation(0.0);

            dp1.setIndependentValue("area", 10300);

            dp1.setIndependentValue("rainfall", 580.6);

            Observation dp2 = new Observation(0.0);

            dp2.setIndependentValue("area", 14666);

            dp2.setIndependentValue("rainfall", 575.6);

            // this dataset object will store all of the observation objects
            requiredDataPoints.add(dp1);
            requiredDataPoints.add(dp2);
        }
        // Dump data set before forecast

        // the forecasted value/s
        forecaster.forecast(requiredDataPoints);
        System.out.println("Output data, forecast values");
    }

}
