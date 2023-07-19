/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form.books;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import form.table.TableActionCellEditor;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import static utils.Database.connectDB;

/**
 *
 * @author YOGA6
 */
public class ViewBook extends javax.swing.JFrame {

    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
   
    /**
     * Creates new form ViewBook
     * @param id
     */
    
    public ViewBook(String id) {
        this.ID = id;
        initComponents();
        connectDB();
        fetchBookTitleByID();
    }   
    
    public ViewBook() {
        
    }
    
    private void fetchBookTitleByID() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_2", "root", "");
            PreparedStatement bookTitleByID = conn.prepareStatement("SELECT * FROM booktitle WHERE id = ?");
            bookTitleByID.setString(1, this.ID);
            ResultSet bookTitleInfo = bookTitleByID.executeQuery();
            
            while (bookTitleInfo.next()) {
                //booktitle && publishedyear
                booktitle.setText(bookTitleInfo.getString("booktitle"));
                publishedyear.setText(bookTitleInfo.getString("publishedyear"));
                //publisher name
                PreparedStatement publisherByID = conn.prepareStatement("SELECT publishername FROM publisher WHERE id = ?");
                publisherByID.setString(1, bookTitleInfo.getString("publisher_id"));
                ResultSet publisherNameInfo = publisherByID.executeQuery();
                while (publisherNameInfo.next()) {
                   publishername.setText(publisherNameInfo.getString("publishername"));
                }
                //genre
                DefaultListModel genreModel = new DefaultListModel();
                PreparedStatement genreByID = conn.prepareStatement("SELECT genre FROM genre JOIN bookgenre ON genre.id = bookgenre.genre_id WHERE booktitle_id = ?");
                genreByID.setString(1, this.ID);
                ResultSet genreInfo = genreByID.executeQuery();
                while(genreInfo.next()) {
                    genreModel.addElement(genreInfo.getString("genre"));
                }
                genreList.setModel(genreModel);
                //author
                DefaultListModel authorModel = new DefaultListModel();
                PreparedStatement authorByID = conn.prepareStatement("SELECT authorname FROM author JOIN bookauthor ON author.id = bookauthor.author_id WHERE booktitle_id = ?");
                authorByID.setString(1, this.ID);
                ResultSet authorInfo = authorByID.executeQuery();
                while(authorInfo.next()) {
                    authorModel.addElement(authorInfo.getString("authorname"));
                }
                authorList.setModel(authorModel);
                //number of parts
                PreparedStatement partByID = conn.prepareStatement("SELECT COUNT(booktitle_id) AS part FROM bookpart WHERE booktitle_id = ?");
                partByID.setString(1, this.ID);
                ResultSet partInfo = partByID.executeQuery();
                while (partInfo.next()) {
                   part.setText(partInfo.getString("part"));
                }
                //total quantity
                PreparedStatement totalQuantityByID = conn.prepareStatement("""
                                                                            SELECT COUNT(*) AS totalquantity FROM bookdetail
                                                                            INNER JOIN 
                                                                            \t\t  (SELECT bookpart.id FROM bookpart
                                                                                       INNER JOIN booktitle
                                                                                       ON bookpart.booktitle_id = booktitle.id
                                                                                       WHERE booktitle.id = ?) bookPartID
                                                                            ON bookdetail.bookpart_id = bookpartID.id;""");
                totalQuantityByID.setString(1, this.ID);
                ResultSet totalQuantityInfo = totalQuantityByID.executeQuery();
                while (totalQuantityInfo.next()) {
                   totalquantity.setText(totalQuantityInfo.getString("totalquantity"));
                }
                String query = """
                               SELECT bookdetail.id AS serialNumber, 
                                       bookPartID.booktitle, 
                                       bookPartID.partNumber,
                                       bookdetail.bookstatus
                                       FROM bookdetail
                                            INNER JOIN 
                                                     (SELECT bookpart.id, booktitle.booktitle, bookpart.partnumber FROM bookpart
                                                      INNER JOIN booktitle
                                                      ON bookpart.booktitle_id = booktitle.id
                                                      WHERE booktitle.id = ?) bookPartID
                                            ON bookdetail.bookpart_id = bookPartID.id""";
                PreparedStatement bookDetailByID = conn.prepareStatement(query);
                bookDetailByID.setString(1, this.ID);
                ResultSet bookDetailInfo = bookDetailByID.executeQuery();
                ResultSetMetaData rsmd = (ResultSetMetaData)bookDetailInfo.getMetaData();
                DefaultTableModel model = (DefaultTableModel) bookdetaillist.getModel();
                String serialNumber;
                String booktitle;
                String partnumber;
                String bookstatus;
                while (bookDetailInfo.next()) {
                    int id = bookDetailInfo.getInt(1);
                    serialNumber = String.valueOf(id);
                    booktitle = bookDetailInfo.getString(2);
                    partnumber = bookDetailInfo.getString(3);
                    bookstatus = bookDetailInfo.getString(4);
                    String[] row = {serialNumber, booktitle, partnumber, bookstatus};
                    model.addRow(row);
                }
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CreateBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bookdetaillist = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        booktitle = new javax.swing.JTextField();
        publishername = new javax.swing.JTextField();
        publishedyear = new javax.swing.JTextField();
        part = new javax.swing.JTextField();
        totalquantity = new javax.swing.JTextField();
        backbutton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        genreList = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        authorList = new javax.swing.JList<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextField3.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Tiêu đề sách");

        jLabel2.setText("Tác giả");

        jLabel3.setText("Năm xuất bản");

        jLabel4.setText("Nhà xuất bản");

        jLabel5.setText("Thể loại");

        jLabel6.setText("Số phần");

        jLabel7.setText("Tổng số lượng sách");

        bookdetaillist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã số Serial", "Tiêu đề sách", "Phần", "Tình trạng sách"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookdetaillist.setRowHeight(40);
        bookdetaillist.setSelectionBackground(new java.awt.Color(102, 255, 204));
        jScrollPane2.setViewportView(bookdetaillist);

        jLabel8.setText("Danh sách cụ thể");

        booktitle.setEditable(false);
        booktitle.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        publishername.setEditable(false);

        publishedyear.setEditable(false);

        part.setEditable(false);

        totalquantity.setEditable(false);

        backbutton.setText("Quay lại");
        backbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbuttonActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(genreList);

        jScrollPane4.setViewportView(authorList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(publishedyear, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane4)
                                    .addComponent(booktitle, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(publishername, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(347, 347, 347))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(part, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(224, 224, 224)
                                .addComponent(backbutton)))
                        .addContainerGap(49, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(booktitle, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backbutton)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(publishedyear, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(publishername, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel7)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(part, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(totalquantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    private void backbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbuttonActionPerformed
        
        BookList bookList = new BookList();
        bookList.setVisible(true);
        close();
    }//GEN-LAST:event_backbuttonActionPerformed
   
    /**
     * @param args the command line arguments2`
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
            java.util.logging.Logger.getLogger(ViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ViewBook().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> authorList;
    private javax.swing.JButton backbutton;
    private javax.swing.JTable bookdetaillist;
    private javax.swing.JTextField booktitle;
    private javax.swing.JList<String> genreList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField part;
    private javax.swing.JTextField publishedyear;
    private javax.swing.JTextField publishername;
    private javax.swing.JTextField totalquantity;
    // End of variables declaration//GEN-END:variables
}
