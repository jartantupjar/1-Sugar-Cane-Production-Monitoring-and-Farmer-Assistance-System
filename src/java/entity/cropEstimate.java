    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author ndrs
 */
public class cropEstimate {
    private int year;
    private double area,actual,forecasted,difference;
    private String district,municipality, rainfall;
    private Date week_ending;

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * @return the actual
     */
    public double getActual() {
        return actual;
    }

    /**
     * @param actual the actual to set
     */
    public void setActual(double actual) {
        this.actual = actual;
    }

    /**
     * @return the forecasted
     */
    public double getForecasted() {
        return forecasted;
    }

    /**
     * @param forecasted the forecasted to set
     */
    public void setForecasted(double forecasted) {
        this.forecasted = forecasted;
    }

    /**
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return the rainfall
     */
    public String getRainfall() {
        return rainfall;
    }

    /**
     * @param rainfall the rainfall to set
     */
    public void setRainfall(String rainfall) {
        this.rainfall = rainfall;
    }

    /**
     * @return the week_ending
     */
    public Date getWeek_ending() {
        return week_ending;
    }

    /**
     * @param week_ending the week_ending to set
     */
    public void setWeek_ending(Date week_ending) {
        this.week_ending = week_ending;
    }

    /**
     * @return the difference
     */
    public double getDifference() {
        return difference;
    }

    /**
     * @param difference the difference to set
     */
    public void setDifference(double difference) {
        this.difference = difference;
    }

    /**
     * @return the municipality
     */
    public String getMunicipality() {
        return municipality;
    }

    /**
     * @param municipality the municipality to set
     */
    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }
    
}
