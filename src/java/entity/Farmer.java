/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ndrs
 */
public class Farmer {
    private int id,tfarms ;
    private String name,phone,year;
    private Double production,curYield,avgYield,totalHa;    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the production
     */
    public Double getProduction() {
        return production;
    }

    /**
     * @param production the production to set
     */
    public void setProduction(Double production) {
        this.production = production;
    }

    /**
     * @return the tfarms
     */
    public int getTfarms() {
        return tfarms;
    }

    /**
     * @param tfarms the tfarms to set
     */
    public void setTfarms(int tfarms) {
        this.tfarms = tfarms;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the curYield
     */
    public Double getCurYield() {
        return curYield;
    }

    /**
     * @param curYield the curYield to set
     */
    public void setCurYield(Double curYield) {
        this.curYield = curYield;
    }

    /**
     * @return the avgYield
     */
    public Double getAvgYield() {
        return avgYield;
    }

    /**
     * @param avgYield the avgYield to set
     */
    public void setAvgYield(Double avgYield) {
        this.avgYield = avgYield;
    }

    /**
     * @return the totalHa
     */
    public Double getTotalHa() {
        return totalHa;
    }

    /**
     * @param totalHa the totalHa to set
     */
    public void setTotalHa(Double totalHa) {
        this.totalHa = totalHa;
    }
}
