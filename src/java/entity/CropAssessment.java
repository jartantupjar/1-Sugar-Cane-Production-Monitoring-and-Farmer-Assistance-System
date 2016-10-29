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
public class CropAssessment {
    private double prevArea, prevTons_Cane, thisArea, thisTons_Cane, todateArea, todateTonc_Cane;
    private double estiArea, estiTons_Cane, percArea, percTons_Canel;
    private double estimated,previous,thisweek,todate,percent, standing, rainfall;
    private String particulars;
    private Date week_ending;
    /**
     * @return the prevArea
     */
    public double getPrevArea() {
        return prevArea;
    }

    /**
     * @param prevArea the prevArea to set
     */
    public void setPrevArea(double prevArea) {
        this.prevArea = prevArea;
    }

    /**
     * @return the prevTons_Cane
     */
    public double getPrevTons_Cane() {
        return prevTons_Cane;
    }

    /**
     * @param prevTons_Cane the prevTons_Cane to set
     */
    public void setPrevTons_Cane(double prevTons_Cane) {
        this.prevTons_Cane = prevTons_Cane;
    }

    /**
     * @return the thisArea
     */
    public double getThisArea() {
        return thisArea;
    }

    /**
     * @param thisArea the thisArea to set
     */
    public void setThisArea(double thisArea) {
        this.thisArea = thisArea;
    }

    /**
     * @return the thisTons_Cane
     */
    public double getThisTons_Cane() {
        return thisTons_Cane;
    }

    /**
     * @param thisTons_Cane the thisTons_Cane to set
     */
    public void setThisTons_Cane(double thisTons_Cane) {
        this.thisTons_Cane = thisTons_Cane;
    }

    /**
     * @return the todateArea
     */
    public double getTodateArea() {
        return todateArea;
    }

    /**
     * @param todateArea the todateArea to set
     */
    public void setTodateArea(double todateArea) {
        this.todateArea = todateArea;
    }

    /**
     * @return the todateTonc_Cane
     */
    public double getTodateTonc_Cane() {
        return todateTonc_Cane;
    }

    /**
     * @param todateTonc_Cane the todateTonc_Cane to set
     */
    public void setTodateTonc_Cane(double todateTonc_Cane) {
        this.todateTonc_Cane = todateTonc_Cane;
    }

    /**
     * @return the estiArea
     */
    public double getEstiArea() {
        return estiArea;
    }

    /**
     * @param estiArea the estiArea to set
     */
    public void setEstiArea(double estiArea) {
        this.estiArea = estiArea;
    }

    /**
     * @return the estiTons_Cane
     */
    public double getEstiTons_Cane() {
        return estiTons_Cane;
    }

    /**
     * @param estiTons_Cane the estiTons_Cane to set
     */
    public void setEstiTons_Cane(double estiTons_Cane) {
        this.estiTons_Cane = estiTons_Cane;
    }

    /**
     * @return the percArea
     */
    public double getPercArea() {
        return percArea;
    }

    /**
     * @param percArea the percArea to set
     */
    public void setPercArea(double percArea) {
        this.percArea = percArea;
    }

    /**
     * @return the percTons_Canel
     */
    public double getPercTons_Canel() {
        return percTons_Canel;
    }

    /**
     * @param percTons_Canel the percTons_Canel to set
     */
    public void setPercTons_Canel(double percTons_Canel) {
        this.percTons_Canel = percTons_Canel;
    }

    /**
     * @return the particulars
     */
    public String getParticulars() {
        return particulars;
    }

    /**
     * @param particulars the particulars to set
     */
    public void setParticulars(String particulars) {
        this.particulars = particulars;
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
     * @return the estimated
     */
    public double getEstimated() {
        return estimated;
    }

    /**
     * @param estimated the estimated to set
     */
    public void setEstimated(double estimated) {
        this.estimated = estimated;
    }

    /**
     * @return the previous
     */
    public double getPrevious() {
        return previous;
    }

    /**
     * @param previous the previous to set
     */
    public void setPrevious(double previous) {
        this.previous = previous;
    }

    /**
     * @return the thisweek
     */
    public double getThisweek() {
        return thisweek;
    }

    /**
     * @param thisweek the thisweek to set
     */
    public void setThisweek(double thisweek) {
        this.thisweek = thisweek;
    }

    /**
     * @return the todate
     */
    public double getTodate() {
        return todate;
    }

    /**
     * @param todate the todate to set
     */
    public void setTodate(double todate) {
        this.todate = todate;
    }

    /**
     * @return the percent
     */
    public double getPercent() {
        return percent;
    }

    /**
     * @param percent the percent to set
     */
    public void setPercent(double percent) {
        this.percent = percent;
    }

    /**
     * @return the standing
     */
    public double getStanding() {
        return standing;
    }

    /**
     * @param standing the standing to set
     */
    public void setStanding(double standing) {
        this.standing = standing;
    }

    /**
     * @return the rainfall
     */
    public double getRainfall() {
        return rainfall;
    }

    /**
     * @param rainfall the rainfall to set
     */
    public void setRainfall(double rainfall) {
        this.rainfall = rainfall;
    }
    
}
