/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Database;
import static utils.Database.connectDB;

/**
 *
 * @author YOGA6
 */
public class ReturnBookRule {
    private int id;
    private int returnBookLateMin;
    private int returnBookLateMax;
    private int fine;

    public ReturnBookRule(int id, int returnBookLateMin, int returnBookLateMax, int fine) {
        this.id = id;
        this.returnBookLateMin = returnBookLateMin;
        this.returnBookLateMax = returnBookLateMax;
        this.fine = fine;
    }
    public static List<ReturnBookRule> getReturnBookRule(){
        List<ReturnBookRule> returnBookRules = new ArrayList<>();
        try{
            Connection c = connectDB();
            PreparedStatement stmt = c.prepareStatement("SELECT * FROM returnbookrule");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
               int ID = rs.getInt(1);
               String dayRange = rs.getString(2);
               int Min = Integer.parseInt(dayRange.substring(1, 2));
               int Max = 0;
               String key = dayRange.substring(0, 1);
               if (key.equals(">")) {
                   Max = Integer.MAX_VALUE;
               } else {
                   Max = Integer.parseInt(dayRange.substring(4, 5));
               }
               int Fine = rs.getInt(3);
               ReturnBookRule rbl = new ReturnBookRule(ID, Min, Max, Fine);
               returnBookRules.add(rbl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
           
        } 
        return returnBookRules;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReturnBookLateMin() {
        return returnBookLateMin;
    }

    public void setReturnBookLateMin(int returnBookLateMin) {
        this.returnBookLateMin = returnBookLateMin;
    }

    public int getReturnBookLateMax() {
        return returnBookLateMax;
    }

    public void setReturnBookLateMax(int returnBookLateMax) {
        this.returnBookLateMax = returnBookLateMax;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
    
    
}
