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
public class BookDamageRule {
    private int id;
    private int bookDamageMin;
    private int bookDamageMax;
    private String action;
    private int fine;

    public BookDamageRule(int id, int bookDamageMin, int bookDamageMax, String action, int fine) {
        this.id = id;
        this.bookDamageMin = bookDamageMin;
        this.bookDamageMax = bookDamageMax;
        this.action = action;
        this.fine = fine;
    }
    
    public static List<BookDamageRule> getBookDamageRule(){
        List<BookDamageRule> BookDamageRules = new ArrayList<>();
        try{
            Connection c = connectDB();
            PreparedStatement stmt = c.prepareStatement("SELECT * FROM bookdamagerule");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
               int ID = rs.getInt(1);
               int Min = rs.getInt(2);
               int Max = rs.getInt(3);
               String Action = rs.getString(4);
               int Fine = rs.getInt(5);
               BookDamageRule bdr = new BookDamageRule(ID, Min, Max, Action, Fine);
               BookDamageRules.add(bdr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
           
        } 
        return BookDamageRules;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookDamageMin() {
        return bookDamageMin;
    }

    public void setBookDamageMin(int bookDamageMin) {
        this.bookDamageMin = bookDamageMin;
    }

    public int getBookDamageMax() {
        return bookDamageMax;
    }

    public void setBookDamageMax(int bookDamageMax) {
        this.bookDamageMax = bookDamageMax;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
    
    
    
}
