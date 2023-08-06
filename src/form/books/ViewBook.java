/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form.books;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import form.borrow.BorrowList;
import form.dashboard.DashBoard;
import form.librarians.LibrarianList;
import static form.login.Login.Admin;
import form.returns.ReturnList;
import form.users.UserList;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
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
           Connection conn = connectDB();
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
        } catch (SQLException ex) {
            Logger.getLogger(ViewBook.class.getName()).log(Level.SEVERE, null, ex);
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
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        part = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        genreList = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        authorList = new javax.swing.JList<>();
        publishername = new javax.swing.JTextField();
        publishedyear = new javax.swing.JTextField();
        booktitle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        totalquantity = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        bookdetaillist = new form.table.Table();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        dashboard = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        booklist = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        borrowlist = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        returnlist = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        librarianlist = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        userlist = new javax.swing.JLabel();

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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        part.setEditable(false);
        part.setBackground(new java.awt.Color(255, 255, 255));
        part.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        part.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        jPanel9.add(part, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 200, 30));

        genreList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(genreList);

        jPanel9.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 200, 70));

        authorList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane4.setViewportView(authorList);

        jPanel9.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 200, 70));

        publishername.setEditable(false);
        publishername.setBackground(new java.awt.Color(255, 255, 255));
        publishername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        publishername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        jPanel9.add(publishername, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 200, 30));

        publishedyear.setEditable(false);
        publishedyear.setBackground(new java.awt.Color(255, 255, 255));
        publishedyear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        publishedyear.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        publishedyear.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel9.add(publishedyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 200, 30));

        booktitle.setEditable(false);
        booktitle.setBackground(new java.awt.Color(255, 255, 255));
        booktitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        booktitle.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        booktitle.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        booktitle.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel9.add(booktitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 200, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Thông tin sách  ");
        jPanel9.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Nhà xuất bản");
        jPanel9.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Tác giả");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Năm xuất bản");
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("Tiêu đề sách");
        jPanel9.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Thể loại");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("Số phần");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 680, 260));

        totalquantity.setEditable(false);
        totalquantity.setBackground(new java.awt.Color(0, 153, 153));
        totalquantity.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalquantity.setForeground(new java.awt.Color(255, 255, 255));
        totalquantity.setBorder(null);
        totalquantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalquantityActionPerformed(evt);
            }
        });
        jPanel2.add(totalquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 410, 40, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Thông tin chi tiết");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

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

        bookdetaillist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Serial sách", "Tiêu đề sách", "Phần", "Tình trạng sách"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookdetaillist.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane5.setViewportView(bookdetaillist);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 680, 190));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tổng SL: ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Danh sách trong thư viện");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 784, 768));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/administrator-64.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 70, 80));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quản lý thư viện");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
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
         if (Admin.getLevel() == 1) {
            close();
            LibrarianList ll = new LibrarianList();
            ll.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập vào phần này!");
        }
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

    private void returnButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnButtonMouseClicked
        close();
        BookList bl = new BookList();
        bl.setVisible(true);
    }//GEN-LAST:event_returnButtonMouseClicked

    private void returnButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnButtonMouseEntered
        Color color = new Color(0,51,51);
        returnButton.setBackground(color);
    }//GEN-LAST:event_returnButtonMouseEntered

    private void returnButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnButtonMouseExited
        Color color = new Color(0,102,102);
        returnButton.setBackground(color);
    }//GEN-LAST:event_returnButtonMouseExited

    private void totalquantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalquantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalquantityActionPerformed
   
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
    private form.table.Table bookdetaillist;
    private javax.swing.JLabel booklist;
    private javax.swing.JTextField booktitle;
    private javax.swing.JLabel borrowlist;
    private javax.swing.JLabel dashboard;
    private javax.swing.JList<String> genreList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel librarianlist;
    private javax.swing.JTextField part;
    private javax.swing.JTextField publishedyear;
    private javax.swing.JTextField publishername;
    private javax.swing.JButton returnButton;
    private javax.swing.JLabel returnlist;
    private javax.swing.JTextField totalquantity;
    private javax.swing.JLabel userlist;
    // End of variables declaration//GEN-END:variables
}
