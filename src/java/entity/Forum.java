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
public class Forum {
    private String farmer,message,status;
    private Integer id , prob_id, counter;
    private Date date_posted, date_started,date_ended;

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
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
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
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

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
     * @return the counter
     */
    public Integer getCounter() {
        return counter;
    }

    /**
     * @param counter the counter to set
     */
    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    /**
     * @return the date_posted
     */
    public Date getDate_posted() {
        return date_posted;
    }

    /**
     * @param date_posted the date_posted to set
     */
    public void setDate_posted(Date date_posted) {
        this.date_posted = date_posted;
    }

    /**
     * @return the date_started
     */
    public Date getDate_started() {
        return date_started;
    }

    /**
     * @param date_started the date_started to set
     */
    public void setDate_started(Date date_started) {
        this.date_started = date_started;
    }

    /**
     * @return the date_ended
     */
    public Date getDate_ended() {
        return date_ended;
    }

    /**
     * @param date_ended the date_ended to set
     */
    public void setDate_ended(Date date_ended) {
        this.date_ended = date_ended;
    }

  }
