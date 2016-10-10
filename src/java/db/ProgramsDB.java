/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Programs;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ndrs
 */
public class ProgramsDB {
      public boolean createNewProgram(Programs prog){
          try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into programs values (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
           
            pstmt.setString(1, prog.getProg_name());
            pstmt.setDate(2, (Date) prog.getDate_created());
            pstmt.setDate(3, (Date) prog.getDate_initial());
            pstmt.setDate(4,(Date)prog.getDate_end());
            pstmt.setString(5, prog.getDescription());
            pstmt.setString(6, prog.getType());
           pstmt.setString(7, "Tarlac");
            int isSuccess = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return isSuccess==1;
        }
         catch (SQLException ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
       
    }
}
