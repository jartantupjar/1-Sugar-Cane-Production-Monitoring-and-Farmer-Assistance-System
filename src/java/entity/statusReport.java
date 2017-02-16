/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author nrajputsaldana
 */
public class statusReport {
private Date weekStarting,weekEnding;
    private int recsImplemented;
    private int recsSuggested;
    private int probsReported;
    private int probsSolved;

    /**
     * @return the recsImplemented
     */
    public int getRecsImplemented() {
        return recsImplemented;
    }

    /**
     * @param recsImplemented the recsImplemented to set
     */
    public void setRecsImplemented(int recsImplemented) {
        this.recsImplemented = recsImplemented;
    }

    /**
     * @return the recsSuggested
     */
    public int getRecsSuggested() {
        return recsSuggested;
    }

    /**
     * @param recsSuggested the recsSuggested to set
     */
    public void setRecsSuggested(int recsSuggested) {
        this.recsSuggested = recsSuggested;
    }

    /**
     * @return the ProbsReported
     */

    /**
     * @return the probsSolved
     */
    public int getProbsSolved() {
        return probsSolved;
    }

    /**
     * @param probsSolved the probsSolved to set
     */
    public void setProbsSolved(int probsSolved) {
        this.probsSolved = probsSolved;
    }

    /**
     * @return the weekEnding
     */
    public Date getWeekEnding() {
        return weekEnding;
    }

    /**
     * @param weekEnding the weekEnding to set
     */
    public void setWeekEnding(Date weekEnding) {
        this.weekEnding = weekEnding;
    }

    /**
     * @return the weekStarting
     */
    public Date getWeekStarting() {
        return weekStarting;
    }

    /**
     * @param weekStarting the weekStarting to set
     */
    public void setWeekStarting(Date weekStarting) {
        this.weekStarting = weekStarting;
    }

    /**
     * @return the probsReported
     */
    public int getProbsReported() {
        return probsReported;
    }

    /**
     * @param probsReported the probsReported to set
     */
    public void setProbsReported(int probsReported) {
        this.probsReported = probsReported;
    }

    

}
