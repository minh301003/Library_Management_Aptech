/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form.books;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static utils.Database.connectDB;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;


/**
 *
 * @author YOGA6
 */
public class CreateBook extends javax.swing.JFrame {

    /**
     * Creates new form CreateBook
     */
    public CreateBook() {
        initComponents();
        connectDB();
        this.fetchPublisher();
        this.fetchGenre();
        this.setMinValueSpinner();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        createBookTitle = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        booktitle = new javax.swing.JTextField();
        publishername = new javax.swing.JComboBox<>();
        publishedyear = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        author = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        bookpart = new javax.swing.JSpinner();
        quantity = new javax.swing.JSpinner();
        jScrollPane3 = new javax.swing.JScrollPane();
        genreList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Tên sách");

        jLabel2.setText("Nhà xuất bản");

        jLabel3.setText("Năm xuất bản");

        jLabel4.setText("Tác giả");

        jLabel5.setText("Thể loại");

        jLabel6.setText("Số phần");

        createBookTitle.setText("Thêm mới");
        createBookTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBookTitleActionPerformed(evt);
            }
        });

        cancel.setText("Hủy");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        author.setColumns(20);
        author.setRows(5);
        jScrollPane1.setViewportView(author);

        jLabel7.setText("Số lượng mỗi phần");

        jScrollPane3.setViewportView(genreList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(3, 3, 3))
                    .addComponent(jLabel5))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(booktitle)
                    .addComponent(jScrollPane1)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookpart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(publishedyear)
                    .addComponent(publishername, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
                .addContainerGap(436, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createBookTitle)
                .addGap(37, 37, 37)
                .addComponent(cancel)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(booktitle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(publishername, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(publishedyear, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(bookpart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createBookTitle)
                    .addComponent(cancel))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void fetchPublisher() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_2", "root", "");
            ResultSet publisherList = c.createStatement().executeQuery("Select publishername from publisher");
            while (publisherList.next()) {
                String publisher = publisherList.getString("publishername");
                publishername.addItem(publisher);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CreateBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
   private DefaultListModel genreModel;
    private void fetchGenre() {
        genreModel = new DefaultListModel();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_2", "root", "");
            ResultSet rs = c.createStatement().executeQuery("Select genre from genre");
            while (rs.next()) {
                String data = rs.getString("genre");
                genreModel.addElement(data);  
            }
            genreList.setModel(genreModel);     
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CreateBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setMinValueSpinner() {
        SpinnerNumberModel partModel = new SpinnerNumberModel(1, 1, 100, 1);
        bookpart.setModel(partModel);
        SpinnerNumberModel quantityModel = new SpinnerNumberModel(1, 1, 100, 1);
        quantity.setModel(quantityModel);
    }
    private void createBookTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBookTitleActionPerformed
        // TODO add your handling code here:
        try {
            //Get value of book title
            String bookTitle = booktitle.getText();
            //Get value of publisher name
            String publisher = (String) publishername.getSelectedItem();
            //Get value of published year
            String publishedYear = publishedyear.getText();
            //Get value of authors
            String authorValue = author.getText();
            String[] authors = authorValue.split(", ");
            //Get value of genre List
            int [] selectedIndices = genreList.getSelectedIndices();
            ListModel<String> model = genreList.getModel();
            //Get number of part
            int parts = (Integer) bookpart.getValue();
            //Get quantity
            int Quantity = (Integer) quantity.getValue();
            //Connect to db
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_2", "root", "");
            //Insert into booktitle table
            String query = "INSERT INTO booktitle (booktitle, publishedyear, publisher_id) VALUES(? , ?, ?)";
            PreparedStatement bookTitleInsert = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            bookTitleInsert.setString(1, bookTitle);
            bookTitleInsert.setString(2, publishedYear);
            PreparedStatement publisherCheck = conn.prepareStatement("SELECT id FROM publisher WHERE publishername = ?");
            publisherCheck.setString(1, publisher);
            ResultSet publisherIDKey = publisherCheck.executeQuery();
            int publisherID = 0;
            while (publisherIDKey.next()) {
                publisherID = publisherIDKey.getInt("id");
            }
            bookTitleInsert.setInt(3, publisherID);
             
            //Get booktitle_id inorder to insert later
            bookTitleInsert.executeUpdate();
            ResultSet key = bookTitleInsert .getGeneratedKeys();
            int bookTitleID = 0;
            while (key.next()) {
                bookTitleID = key.getInt(1);
            }
            
           
            //Insert into bookgenre table
            PreparedStatement bookGenreInsert = conn.prepareStatement("INSERT INTO bookgenre (booktitle_id, genre_id) VALUES(?, ?)");
            for (int index : selectedIndices) {
                bookGenreInsert.setInt(1, bookTitleID);
                String genreValue = model.getElementAt(index);
                PreparedStatement genreCheck = conn.prepareStatement("SELECT id FROM genre WHERE genre = ?");
                genreCheck.setString(1, genreValue);
                ResultSet genreKey = genreCheck.executeQuery();
                int genreID = 0;
                while (genreKey.next()) {
                    genreID = genreKey.getInt("id");
                }
                bookGenreInsert.setInt(2, genreID);
                bookGenreInsert.executeUpdate();
               
            }
            //Check and insert new author into db
            for (String author : authors) {
                //Check if the input author has already been inserted yet
                ResultSet authorInserted = conn.createStatement().executeQuery("SELECT authorname FROM author");
                ArrayList<String> authorInsertedList = new ArrayList<String>();
                while (authorInserted.next()) {
                    authorInsertedList.add(authorInserted.getString("authorname"));
                }
                boolean check = false;
                for (String a : authorInsertedList) {
                    if (author.equals(a)){
                        check = true;
                    }
                }
                //If the input author does not exist in db, insert it into db
                if (!check) {
                   PreparedStatement authorInsert = conn.prepareStatement("INSERT INTO author (authorname) VALUES(?)");
                   authorInsert.setString(1, author);
                   authorInsert.executeUpdate();
                }
                PreparedStatement authorCheck = conn.prepareStatement("SELECT id FROM author WHERE authorname = ?");
                authorCheck.setString(1, author);
                ResultSet authorKey = authorCheck.executeQuery();
                int authorID;
                while (authorKey.next()) {
                   authorID = authorKey.getInt("id");
                   //Insert into bookauthor table
                   PreparedStatement bookAuthorInsert = conn.prepareStatement("INSERT INTO bookauthor (booktitle_id, author_id) VALUES(?, ?)");
                   bookAuthorInsert.setInt(1, bookTitleID);
                   bookAuthorInsert.setInt(2, authorID);
                   bookAuthorInsert.executeUpdate();             
                }
            }
            //Insert into book part table
            ArrayList<Integer> bookPartIDList = new ArrayList<Integer>();
            for (int i = 1; i <= parts; i++){
                PreparedStatement bookPartInsert = conn.prepareStatement("INSERT INTO bookpart (booktitle_id, partnumber) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);
                bookPartInsert.setInt(1, bookTitleID);
                bookPartInsert.setInt(2, i);
                bookPartInsert.executeUpdate();
                //Get booktitle_id inorder to insert later 
                ResultSet bookPartKey = bookPartInsert .getGeneratedKeys();
                while (bookPartKey .next()) {
                    bookPartIDList.add(bookPartKey.getInt(1));
                }  
            }
    
            
            //Insert into book detail table
            
            for (int bookPartID : bookPartIDList) {
                for (int i = 0; i < Quantity; i++) {
                    PreparedStatement bookDetailInsert = conn.prepareStatement("INSERT INTO bookdetail (bookpart_id, bookstatus) VALUES(?, ?)");
                    bookDetailInsert.setInt(1, bookPartID);
                    bookDetailInsert.setString(2, "100%");
                    bookDetailInsert.executeUpdate();
                }
            }
            
            //Refresh form and show successful alert
            JOptionPane.showMessageDialog(this, "Add book title successfully!");
            booktitle.setText("");
            publishedyear.setText("");
            author.setText("");
            genreList.clearSelection();
            bookpart.setValue(1);
            quantity.setValue(1);
        
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CreateBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_createBookTitleActionPerformed
    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        close();
        BookList bookList = new BookList();
        bookList.setVisible(true);
    }//GEN-LAST:event_cancelActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CreateBook().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea author;
    private javax.swing.JSpinner bookpart;
    private javax.swing.JTextField booktitle;
    private javax.swing.JButton cancel;
    private javax.swing.JButton createBookTitle;
    private javax.swing.JList<String> genreList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField publishedyear;
    private javax.swing.JComboBox<String> publishername;
    private javax.swing.JSpinner quantity;
    // End of variables declaration//GEN-END:variables
}
