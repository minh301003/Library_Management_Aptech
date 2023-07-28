/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form.returns;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.BookDamageRule;
import static model.BookDamageRule.getBookDamageRule;
import model.ReturnBookRule;
import static model.ReturnBookRule.getReturnBookRule;
import utils.Database;
import static utils.Database.connectDB;

/**
 *
 * @author YOGA6
 */
public class CreateReturn extends javax.swing.JFrame {

    /**
     * Creates new form CreateReturn
     */
    public CreateReturn() {
        initComponents();
        fetchReturn();
    }
    private String BookDetailID;
    private String UserID;
    private int BookStatusBeforeBorrow;
    private int BookStatusAfterBorrow;
    private String Action;
    private int FineReturnLate;
    private int FineBookDamage;
    
    
   
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bookDetailID = new form.suggestion_combo.ComboBoxSuggestion();
        userID = new form.suggestion_combo.ComboBoxSuggestion();
        bookStatus = new form.suggestion_combo.ComboBoxSuggestion();
        findBorrowButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        note1 = new javax.swing.JTextField();
        fineBookDamage = new javax.swing.JTextField();
        note2 = new javax.swing.JTextField();
        fineReturnLate = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        librarianName = new javax.swing.JTextField();
        bookTitle = new javax.swing.JTextField();
        userName = new javax.swing.JTextField();
        dueDate = new com.toedter.calendar.JDateChooser();
        borrowDate = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        bookPart = new javax.swing.JTextField();
        confirmReturnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 768));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ghi nhận trả sách");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        returnButton.setBackground(new java.awt.Color(0, 102, 102));
        returnButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        returnButton.setForeground(new java.awt.Color(255, 255, 255));
        returnButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back1.png"))); // NOI18N
        returnButton.setBorder(null);
        returnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                returnButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                returnButtonMouseExited(evt);
            }
        });
        jPanel2.add(returnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 80, 40));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Thông tin trả sách ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Mã serial sách");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Mã người mượn");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Tình trạng sách");

        bookStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookStatusActionPerformed(evt);
            }
        });

        findBorrowButton.setBackground(new java.awt.Color(0, 102, 102));
        findBorrowButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        findBorrowButton.setForeground(new java.awt.Color(255, 255, 255));
        findBorrowButton.setText("Tìm kiếm");
        findBorrowButton.setBorder(null);
        findBorrowButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                findBorrowButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                findBorrowButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                findBorrowButtonMouseExited(evt);
            }
        });
        findBorrowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findBorrowButtonActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 153));
        jLabel12.setText("Phạt (nếu có)");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 153));
        jLabel13.setText("%");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 153));
        jLabel15.setText("Ghi chú");

        note1.setEditable(false);
        note1.setBackground(new java.awt.Color(255, 255, 255));
        note1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        fineBookDamage.setEditable(false);
        fineBookDamage.setBackground(new java.awt.Color(255, 255, 255));
        fineBookDamage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        note2.setEditable(false);
        note2.setBackground(new java.awt.Color(255, 255, 255));
        note2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        fineReturnLate.setEditable(false);
        fineReturnLate.setBackground(new java.awt.Color(255, 255, 255));
        fineReturnLate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        fineReturnLate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fineReturnLateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel12))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bookDetailID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(bookStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(fineBookDamage, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(fineReturnLate))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(note2)
                                    .addComponent(note1)))
                            .addComponent(findBorrowButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 23, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(61, 61, 61)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(bookDetailID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(userID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fineReturnLate, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(note2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fineBookDamage, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(note1))
                .addGap(18, 18, 18)
                .addComponent(findBorrowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 480));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Thông tin mượn sách ");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Phần");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("Tên người dùng");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Ngày mượn");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("Ngày hẹn trả");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("Thủ thư xác nhận");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        librarianName.setEditable(false);
        librarianName.setBackground(new java.awt.Color(255, 255, 255));
        librarianName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        librarianName.setBorder(null);
        jPanel5.add(librarianName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 151, 30));

        bookTitle.setEditable(false);
        bookTitle.setBackground(new java.awt.Color(255, 255, 255));
        bookTitle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bookTitle.setBorder(null);
        jPanel5.add(bookTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 151, 30));

        userName.setEditable(false);
        userName.setBackground(new java.awt.Color(255, 255, 255));
        userName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        userName.setBorder(null);
        jPanel5.add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 151, 30));

        dueDate.setBackground(new java.awt.Color(255, 255, 255));
        dueDate.setDateFormatString("yyyy-MM-dd");
        dueDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel5.add(dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 151, 30));

        borrowDate.setBackground(new java.awt.Color(255, 255, 255));
        borrowDate.setDateFormatString("yyyy-MM-dd");
        borrowDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel5.add(borrowDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 151, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 153));
        jLabel14.setText("Tiêu đề sách");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        bookPart.setEditable(false);
        bookPart.setBackground(new java.awt.Color(255, 255, 255));
        bookPart.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bookPart.setBorder(null);
        jPanel5.add(bookPart, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 150, 30));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 340, 480));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 680, 480));

        confirmReturnButton.setBackground(new java.awt.Color(0, 102, 102));
        confirmReturnButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        confirmReturnButton.setForeground(new java.awt.Color(255, 255, 255));
        confirmReturnButton.setText("Trả sách");
        confirmReturnButton.setBorder(null);
        confirmReturnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmReturnButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmReturnButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmReturnButtonMouseExited(evt);
            }
        });
        confirmReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmReturnButtonActionPerformed(evt);
            }
        });
        jPanel2.add(confirmReturnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 620, 180, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 784, 768));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void returnButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnButtonMouseClicked
        close();
        ReturnList returnList = new ReturnList();
        returnList.setVisible(true);
    }//GEN-LAST:event_returnButtonMouseClicked

    private void returnButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnButtonMouseEntered
        Color color = new Color(0,51,51);
        returnButton.setBackground(color);
    }//GEN-LAST:event_returnButtonMouseEntered

    private void returnButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnButtonMouseExited
        Color color = new Color(0,102,102);
        returnButton.setBackground(color);
    }//GEN-LAST:event_returnButtonMouseExited

    private void findBorrowButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_findBorrowButtonMouseClicked
        
    }//GEN-LAST:event_findBorrowButtonMouseClicked

    private void findBorrowButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_findBorrowButtonMouseEntered
        Color color = new Color(0,51,51);
        findBorrowButton.setBackground(color);
    }//GEN-LAST:event_findBorrowButtonMouseEntered
    
    private void findBorrowButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_findBorrowButtonMouseExited
        Color color = new Color(0,102,102);
        findBorrowButton.setBackground(color);
    }//GEN-LAST:event_findBorrowButtonMouseExited

    private void confirmReturnButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmReturnButtonMouseClicked
        
    }//GEN-LAST:event_confirmReturnButtonMouseClicked

    private void confirmReturnButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmReturnButtonMouseEntered
        Color color = new Color(0,51,51);
        confirmReturnButton.setBackground(color);
    }//GEN-LAST:event_confirmReturnButtonMouseEntered

    private void confirmReturnButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmReturnButtonMouseExited
        Color color = new Color(0,51,51);
        confirmReturnButton.setBackground(color);
    }//GEN-LAST:event_confirmReturnButtonMouseExited
    // Return book action
    private void confirmReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmReturnButtonActionPerformed
//        try {
//            Connection c = connectDB();
//            BookStatus = (String)bookStatus.getSelectedItem().toString();
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//           
//        } 
    }//GEN-LAST:event_confirmReturnButtonActionPerformed
    
    //Find the borrow information
    private void findBorrowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findBorrowButtonActionPerformed
         try { 
            Connection c = connectDB();
            BookDetailID = (String)bookDetailID.getSelectedItem().toString();
            UserID = (String)userID.getSelectedItem().toString();
            PreparedStatement bookStatusById = c.prepareStatement("SELECT bookstatus FROM bookdetail WHERE id = ?");
            bookStatusById.setString(1, BookDetailID);
            ResultSet bookStatusBeforeBorrow = bookStatusById.executeQuery();
            while (bookStatusBeforeBorrow.next()) {
                BookStatusBeforeBorrow = bookStatusBeforeBorrow.getInt("bookstatus");
                for (int i = BookStatusBeforeBorrow; i >= 10; i-=5) {
                    bookStatus.addItem(i);
                }  
            }
            //find borrow info
            PreparedStatement borrowInfo = c.prepareStatement("SELECT * FROM borrow WHERE bookdetail_id = ? AND user_id = ? AND returnstatus = 0");
            borrowInfo.setString(1, BookDetailID);
            borrowInfo.setString(2, UserID);
            ResultSet BorrowInfo = borrowInfo.executeQuery();
            if (!BorrowInfo.isBeforeFirst() ) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy lịch sử mượn sách!");
            } else {
                while (BorrowInfo.next()) {
                    //Get book title
                    String query = """
                                    SELECT bookInfo.booktitle, bookInfo.partNumber, bookdetail.bookstatus
                                    FROM bookdetail
                                         INNER JOIN 
                                                    (SELECT booktitle.id AS bookTitleID, bookpart.id, booktitle.booktitle, bookpart.partnumber FROM bookpart
                                                            INNER JOIN booktitle
                                                            ON bookpart.booktitle_id = booktitle.id) bookInfo
                                         ON bookdetail.bookpart_id = bookInfo.id
                                         WHERE bookdetail.id = ?""";
                    PreparedStatement bookDetailByID = c.prepareStatement(query);
                    bookDetailByID.setString(1, BookDetailID);
                    ResultSet bookDetailInfo = bookDetailByID.executeQuery();
                    while (bookDetailInfo.next()) {
                       bookTitle.setText(bookDetailInfo.getString("booktitle"));
                       bookPart.setText(bookDetailInfo.getString("partnumber"));
                    }
                    //Get username
                    PreparedStatement userNameByID = c.prepareStatement("SELECT name FROM user WHERE id = ?");
                    userNameByID.setString(1, BorrowInfo.getString("user_id"));
                    ResultSet userNameByInfo = userNameByID.executeQuery();
                    while(userNameByInfo.next()) {
                        userName.setText(userNameByInfo.getString("name"));
                    }
                  
                    //Get librarian name
                    PreparedStatement librarianNameByID = c.prepareStatement("SELECT firstname, lastname FROM librarian WHERE id = ?");
                    librarianNameByID.setString(1, BorrowInfo.getString("librarian_id"));
                    ResultSet librarianNameByInfo = librarianNameByID.executeQuery();
                    while(librarianNameByInfo.next()) {
                        String fullName = librarianNameByInfo.getString("firstname") + librarianNameByInfo.getString("lastname");
                        librarianName.setText(fullName);
                    }
                    //Get borrow date and due date
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date bDate = sdf.parse(BorrowInfo.getString("borrowdate"));
                    Date dDate = sdf.parse(BorrowInfo.getString("duedate"));
                    borrowDate.setDate(bDate);
                    dueDate.setDate(dDate);
                    //if the return date > due date, get the fine
                    Date currentDate = new Date();
                    long differenceInTime = currentDate.getTime()- dDate.getTime();
                    if (differenceInTime > 0) {
                        long lateDays
                                = (differenceInTime
                                / (1000 * 60 * 60 * 24))
                                % 365;
                        //get the return book rule
                        List<ReturnBookRule> rbls = getReturnBookRule();
                        for (ReturnBookRule rbl : rbls) {
                            if (lateDays >= rbl.getReturnBookLateMin() &&
                                lateDays < rbl.getReturnBookLateMax()) {
                                //get the fine
                                FineReturnLate = rbl.getFine(); 
                                fineReturnLate.setText(Integer.toString(FineReturnLate) + " VND");
                                //get the note
                                String returnBookLateNote = "Bị phạt vì trả sách muộn " + Long.toString(lateDays) + " ngày";
                                note2.setText(returnBookLateNote);
                            }
                        }
                    }
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
           
        } catch (ParseException ex) {
            Logger.getLogger(CreateReturn.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_findBorrowButtonActionPerformed

    //Check book damage after borrow
    private void bookStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookStatusActionPerformed
        BookStatusAfterBorrow = (int) bookStatus.getSelectedItem();
        int bookDamage = BookStatusBeforeBorrow - BookStatusAfterBorrow;
        List<BookDamageRule> bdrs = getBookDamageRule();
        if (bookDamage > 0) {
            for (BookDamageRule bdr : bdrs) {
            if (bookDamage >= bdr.getBookDamageMin()
                && bookDamage < bdr.getBookDamageMax()) {
                //get the fine
                FineBookDamage = bdr.getFine();
                fineBookDamage.setText(Integer.toString(FineBookDamage) + " VND");
                //get the note
                String bookDamageNote = "Bị phạt vì làm hư hại sách " + Integer.toString(bookDamage) + " %";
                note1.setText(bookDamageNote);
                //get the action
                Action = bdr.getAction();
                
                }
            }
        }   
    }//GEN-LAST:event_bookStatusActionPerformed

    private void fineReturnLateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fineReturnLateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fineReturnLateActionPerformed
    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
   
    private void fetchReturn() {
        try { 
            Connection c = connectDB();
            //Get book detail ID
            ResultSet serialNumberList = c.createStatement().executeQuery("SELECT DISTINCT bookdetail_id FROM borrow WHERE returnstatus = 0;");
            while (serialNumberList.next()) {
                bookDetailID.addItem(serialNumberList.getString("bookdetail_id"));
            }
            
            //Get user ID
            ResultSet userIDList = c.createStatement().executeQuery("SELECT DISTINCT user_id FROM borrow WHERE returnstatus = 0;");
            while (userIDList.next()) {
                userID.addItem(userIDList.getString("user_id"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
           
        } 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateReturn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateReturn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateReturn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateReturn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateReturn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private form.suggestion_combo.ComboBoxSuggestion bookDetailID;
    private javax.swing.JTextField bookPart;
    private form.suggestion_combo.ComboBoxSuggestion bookStatus;
    private javax.swing.JTextField bookTitle;
    private com.toedter.calendar.JDateChooser borrowDate;
    private javax.swing.JButton confirmReturnButton;
    private com.toedter.calendar.JDateChooser dueDate;
    private javax.swing.JButton findBorrowButton;
    private javax.swing.JTextField fineBookDamage;
    private javax.swing.JTextField fineReturnLate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField librarianName;
    private javax.swing.JTextField note1;
    private javax.swing.JTextField note2;
    private javax.swing.JButton returnButton;
    private form.suggestion_combo.ComboBoxSuggestion userID;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables

    
}
