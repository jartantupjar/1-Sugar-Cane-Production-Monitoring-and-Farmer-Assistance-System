/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Bryll Joey Delfin
 */
public class Problems {
    private Integer prob_id, totalFarms;
    private String prob_name, prob_details, barangay,municipality, status,type,impact;
    private Double prob_loss;

    /**
     * @return the prob_id
     */
    public Integer getProb_id() {
        return prob_id;
    }

    /**
     * @param prob_id the prob_id to set
     */
    public void setProb_id(Integer prob_id) {
        this.prob_id = prob_id;
    }

    /**
     * @return the prob_name
     */
    public String getProb_name() {
        return prob_name;
    }

    /**
     * @param prob_name the prob_name to set
     */
    public void setProb_name(String prob_name) {
        this.prob_name = prob_name;
    }

    /**
     * @return the prob_details
     */
    public String getProb_details() {
        return prob_details;
    }

    /**
     * @param prob_details the prob_details to set
     */
    public void setProb_details(String prob_details) {
        this.prob_details = prob_details;
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
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the prob_loss
     */
    public Double getProb_loss() {
        return prob_loss;
    }

    /**
     * @param prob_loss the prob_loss to set
     */
    public void setProb_loss(Double prob_loss) {
        this.prob_loss = prob_loss;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the impact
     */
    public String getImpact() {
        return impact;
    }

    /**
     * @param impact the impact to set
     */
    public void setImpact(String impact) {
        this.impact = impact;
    }

    /**
     * @return the totalFarms
     */
    public Integer getTotalFarms() {
        return totalFarms;
    }

    /**
     * @param totalFarms the totalFarms to set
     */
    public void setTotalFarms(Integer totalFarms) {
        this.totalFarms = totalFarms;
    }
}
