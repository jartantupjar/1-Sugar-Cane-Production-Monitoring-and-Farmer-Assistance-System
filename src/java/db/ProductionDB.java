/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


import entity.CropAssessment;
import entity.Production;
import java.sql.Connection;
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
}
