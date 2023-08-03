/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form.books;

import form.borrow.BorrowList;
import form.dashboard.DashBoard;
import form.librarians.LibrarianList;
import form.returns.ReturnList;
import form.users.UserList;
import java.awt.Color;
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        dashboard = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        booklist = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        borrowlist = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        returnlist = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        librarianlist = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        userlist = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        createBookTitle = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        author = new javax.swing.JTextArea();
        publishername = new javax.swing.JComboBox<>();
        booktitle = new javax.swing.JTextField();
        publishedyear = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        genreList = new javax.swing.JList<>();
        quantity = new javax.swing.JSpinner();
        bookpart = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cancelbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashboard.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        dashboard.setForeground(new java.awt.Color(255, 255, 255));
        dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home-3-32.png"))); // NOI18N
        dashboard.setText("Trang chủ");
        dashboard.setIconTextGap(12);
        dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardMouseClicked(evt);
            }
        });
        jPanel3.add(dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 240, 70));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        booklist.setBackground(new java.awt.Color(255, 255, 255));
        booklist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        booklist.setForeground(new java.awt.Color(255, 255, 255));
        booklist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/book-stack-32.png"))); // NOI18N
        booklist.setText("Quản lý kho sách");
        booklist.setIconTextGap(12);
        booklist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booklistMouseClicked(evt);
            }
        });
        jPanel4.add(booklist, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 240, 70));

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        borrowlist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        borrowlist.setForeground(new java.awt.Color(255, 255, 255));
        borrowlist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/list-2-32.png"))); // NOI18N
        borrowlist.setText("Quản lý mượn sách");
        borrowlist.setIconTextGap(12);
        borrowlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrowlistMouseClicked(evt);
            }
        });
        jPanel5.add(borrowlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 240, 70));

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        returnlist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        returnlist.setForeground(new java.awt.Color(255, 255, 255));
        returnlist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/arrow-96-32.png"))); // NOI18N
        returnlist.setText("Quản lý trả sách");
        returnlist.setIconTextGap(12);
        returnlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnlistMouseClicked(evt);
            }
        });
        jPanel6.add(returnlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 170, 40));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 240, 70));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/administrator-64.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 70, 80));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Quản lý thư viện");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        librarianlist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        librarianlist.setForeground(new java.awt.Color(255, 255, 255));
        librarianlist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/contacts-32.png"))); // NOI18N
        librarianlist.setText("Quản lý nhân viên");
        librarianlist.setIconTextGap(12);
        librarianlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                librarianlistMouseClicked(evt);
            }
        });
        jPanel7.add(librarianlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 180, 40));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 240, 70));

        jPanel8.setBackground(new java.awt.Color(0, 102, 102));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userlist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        userlist.setForeground(new java.awt.Color(255, 255, 255));
        userlist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user-5-32.png"))); // NOI18N
        userlist.setText("Quản lý người mượn");
        userlist.setIconTextGap(12);
        userlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userlistMouseClicked(evt);
            }
        });
        jPanel8.add(userlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, 40));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 240, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 768));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        createBookTitle.setBackground(new java.awt.Color(0, 102, 102));
        createBookTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        createBookTitle.setForeground(new java.awt.Color(255, 255, 255));
        createBookTitle.setText("Thêm");
        createBookTitle.setBorder(null);
        createBookTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createBookTitleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                createBookTitleMouseExited(evt);
            }
        });
        createBookTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBookTitleActionPerformed(evt);
            }
        });
        jPanel2.add(createBookTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 490, 115, 50));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Thêm mới sách");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        author.setColumns(20);
        author.setRows(5);
        jScrollPane1.setViewportView(author);

        jPanel9.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 240, 100));

        jPanel9.add(publishername, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 180, 30));

        booktitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booktitleActionPerformed(evt);
            }
        });
        jPanel9.add(booktitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 240, 30));
        jPanel9.add(publishedyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 180, 30));

        jScrollPane3.setViewportView(genreList);

        jPanel9.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 240, 100));
        jPanel9.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, -1, 30));
        jPanel9.add(bookpart, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, -1, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Thông tin sách  ");
        jPanel9.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("Tiêu đề sách");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 153));
        jLabel12.setText("Số phần");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Nhà xuất bản");
        jPanel9.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Tác giả");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 153));
        jLabel13.setText("Thể loại");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Số lượng thêm");
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, -1, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 153));
        jLabel14.setText("Năm xuất bản");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, -1, 20));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 680, 350));

        cancelbutton.setBackground(new java.awt.Color(0, 102, 102));
        cancelbutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancelbutton.setForeground(new java.awt.Color(255, 255, 255));
        cancelbutton.setText("Hủy");
        cancelbutton.setBorder(null);
        cancelbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelbuttonMouseExited(evt);
            }
        });
        cancelbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(cancelbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 490, 115, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 784, 768));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void fetchPublisher() {
        try {
            Connection c = connectDB();
            ResultSet publisherList = c.createStatement().executeQuery("Select publishername from publisher");
            while (publisherList.next()) {
                String publisher = publisherList.getString("publishername");
                publishername.addItem(publisher);
            }
        } catch (SQLException ex) {
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
                    PreparedStatement bookDetailInsert = conn.prepareStatement("INSERT INTO bookdetail (bookpart_id) VALUES(?)");
                    bookDetailInsert.setInt(1, bookPartID);
                    bookDetailInsert.executeUpdate();
                }
            }
            
            //Refresh form and show successful alert
            JOptionPane.showMessageDialog(this, "Thêm sách thành công!");
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
    private void dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMouseClicked
        close();
        DashBoard db = new DashBoard();
        db.setVisible(true);
    }//GEN-LAST:event_dashboardMouseClicked

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        Color color = new Color(0,153,153);
        jPanel3.setBackground(color);
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        Color color = new Color(0,102,102);
        jPanel3.setBackground(color);
    }//GEN-LAST:event_jPanel3MouseExited

    private void booklistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booklistMouseClicked
        close();
        BookList bkl = new BookList();
        bkl.setVisible(true);
    }//GEN-LAST:event_booklistMouseClicked

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        Color color = new Color(0,153,153);
        jPanel4.setBackground(color);
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        Color color = new Color(0,102,102);
        jPanel4.setBackground(color);
    }//GEN-LAST:event_jPanel4MouseExited

    private void borrowlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowlistMouseClicked
        close();
        BorrowList bl = new BorrowList();
        bl.setVisible(true);
    }//GEN-LAST:event_borrowlistMouseClicked

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        Color color = new Color(0,153,153);
        jPanel5.setBackground(color);
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        Color color = new Color(0,102,102);
        jPanel5.setBackground(color);
    }//GEN-LAST:event_jPanel5MouseExited

    private void returnlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnlistMouseClicked
        close();
        ReturnList rl = new ReturnList();
        rl.setVisible(true);
    }//GEN-LAST:event_returnlistMouseClicked

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        Color color = new Color(0,153,153);
        jPanel6.setBackground(color);
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        Color color = new Color(0,102,102);
        jPanel6.setBackground(color);
    }//GEN-LAST:event_jPanel6MouseExited

    private void librarianlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_librarianlistMouseClicked
        close();
        LibrarianList ll = new LibrarianList();
        ll.setVisible(true);
    }//GEN-LAST:event_librarianlistMouseClicked

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        Color color = new Color(0,153,153);
        jPanel7.setBackground(color);
    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
        Color color = new Color(0,102,102);
        jPanel7.setBackground(color);
    }//GEN-LAST:event_jPanel7MouseExited

    private void userlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userlistMouseClicked
        close();
        UserList ul = new UserList();
        ul.setVisible(true);
    }//GEN-LAST:event_userlistMouseClicked

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
        Color color = new Color(0,153,153);
        jPanel8.setBackground(color);
    }//GEN-LAST:event_jPanel8MouseEntered

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        Color color = new Color(0,102,102);
        jPanel8.setBackground(color);
    }//GEN-LAST:event_jPanel8MouseExited

    private void booktitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booktitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_booktitleActionPerformed

    private void cancelbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelbuttonMouseEntered
        Color color = new Color(0,51,51);
        cancelbutton.setBackground(color);
    }//GEN-LAST:event_cancelbuttonMouseEntered

    private void cancelbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelbuttonMouseExited
        Color color = new Color(0,102,102);
        cancelbutton.setBackground(color);
    }//GEN-LAST:event_cancelbuttonMouseExited

    private void cancelbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbuttonActionPerformed
        // TODO add your handling code here:
        close();
        BookList bkl = new BookList();
        bkl.setVisible(true);

    }//GEN-LAST:event_cancelbuttonActionPerformed

    private void createBookTitleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createBookTitleMouseEntered
        Color color = new Color(0,51,51);
        createBookTitle.setBackground(color);
    }//GEN-LAST:event_createBookTitleMouseEntered

    private void createBookTitleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createBookTitleMouseExited
        Color color = new Color(0,102,102);
        createBookTitle.setBackground(color);
    }//GEN-LAST:event_createBookTitleMouseExited

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
    private javax.swing.JLabel booklist;
    private javax.swing.JSpinner bookpart;
    private javax.swing.JTextField booktitle;
    private javax.swing.JLabel borrowlist;
    private javax.swing.JButton cancelbutton;
    private javax.swing.JButton createBookTitle;
    private javax.swing.JLabel dashboard;
    private javax.swing.JList<String> genreList;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel librarianlist;
    private javax.swing.JTextField publishedyear;
    private javax.swing.JComboBox<String> publishername;
    private javax.swing.JSpinner quantity;
    private javax.swing.JLabel returnlist;
    private javax.swing.JLabel userlist;
    // End of variables declaration//GEN-END:variables
}
