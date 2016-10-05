/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author ndrs
 */
public class Programs {
    private String prog_name,type,description;
    private Date date_created, date_initial,date_end;

    /**
     * @return the prog_name
     */
    public String getProg_name() {
        return prog_name;
    }

    /**
     * @param prog_name the prog_name to set
     */
    public void setProg_name(String prog_name) {
        this.prog_name = prog_name;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the date_created
     */
    public Date getDate_created() {
        return date_created;
    }

    /**
     * @param date_created the date_created to set
     */
    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    /**
     * @return the date_initial
     */
    public Date getDate_initial() {
        return date_initial;
    }

    /**
     * @param date_initial the date_initial to set
     */
    public void setDate_initial(Date date_initial) {
        this.date_initial = date_initial;
    }

    /**
     * @return the date_end
     */
    public Date getDate_end() {
        return date_end;
    }

    /**
     * @param date_end the date_end to set
     */
    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }
           
}
