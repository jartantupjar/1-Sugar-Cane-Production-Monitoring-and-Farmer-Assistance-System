/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Bryll Joey Delfin
 */
public class Farm {

    private int id;
    private String farmer,district,barangay,municipality,variety;
    private Date date_updated;
    private double area,yield,totalA,totalHa;
    private String management_type;
    private double nitrogen, phosporus, potassium, ph_level;
    private String boundaries;
    private double latCenter;
    private double lngCenter;
    private boolean selected;

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
     * @return the farmer
     */
    public String getFarmer() {
        return farmer;
    }

    /**
     * @param farmer the farmer to set
     */
    public void setFarmer(String farmer) {
        this.farmer = farmer;
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
     * @return the barangay
     */
    public String getBarangay() {
        return barangay;
    }

    /**
     * @param barangay the barangay to set
     */
    public void setBarangay(String barangay) {
        this.barangay = barangay;
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
     * @return the management_type
     */
    public String getManagement_type() {
        return management_type;
    }

    /**
     * @param management_type the management_type to set
     */
    public void setManagement_type(String management_type) {
        this.management_type = management_type;
    }

    /**
     * @return the nitrogen
     */
    public double getNitrogen() {
        return nitrogen;
    }

    /**
     * @param nitrogen the nitrogen to set
     */
    public void setNitrogen(double nitrogen) {
        this.nitrogen = nitrogen;
    }

    /**
     * @return the phosporus
     */
    public double getPhosporus() {
        return phosporus;
    }

    /**
     * @param phosporus the phosporus to set
     */
    public void setPhosporus(double phosporus) {
        this.phosporus = phosporus;
    }

    /**
     * @return the potassium
     */
    public double getPotassium() {
        return potassium;
    }

    /**
     * @param potassium the potassium to set
     */
    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    /**
     * @return the ph_level
     */
    public double getPh_level() {
        return ph_level;
    }

    /**
     * @param ph_level the ph_level to set
     */
    public void setPh_level(double ph_level) {
        this.ph_level = ph_level;
    }

    /**
     * @return the boundaries
     */
    public String getBoundaries() {
        return boundaries;
    }

    /**
     * @param boundaries the boundaries to set
     */
    public void setBoundaries(String boundaries) {
        this.boundaries = boundaries;
    }

    /**
     * @return the latCenter
     */
    public double getLatCenter() {
        return latCenter;
    }

    /**
     * @param latCenter the latCenter to set
     */
    public void setLatCenter(double latCenter) {
        this.latCenter = latCenter;
    }

    /**
     * @return the lngCenter
     */
    public double getLngCenter() {
        return lngCenter;
    }

    /**
     * @param lngCenter the lngCenter to set
     */
    public void setLngCenter(double lngCenter) {
        this.lngCenter = lngCenter;
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
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

    /**
     * @return the variety
     */
    public String getVariety() {
        return variety;
    }

    /**
     * @param variety the variety to set
     */
    public void setVariety(String variety) {
        this.variety = variety;
    }

    /**
     * @return the yield
     */
    public double getYield() {
        return yield;
    }

    /**
     * @param yield the yield to set
     */
    public void setYield(double yield) {
        this.yield = yield;
    }

    /**
     * @return the totalA
     */
    public double getTotalA() {
        return totalA;
    }

    /**
     * @param totalA the totalA to set
     */
    public void setTotalA(double totalA) {
        this.totalA = totalA;
    }

    /**
     * @return the totalHa
     */
    public double getTotalHa() {
        return totalHa;
    }

    /**
     * @param totalHa the totalHa to set
     */
    public void setTotalHa(double totalHa) {
        this.totalHa = totalHa;
    }

    /**
     * @return the date_updated
     */
    public Date getDate_updated() {
        return date_updated;
    }

    /**
     * @param date_updated the date_updated to set
     */
    public void setDate_updated(Date date_updated) {
        this.date_updated = date_updated;
    }




}
