/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form.books;


import form.borrow.BorrowList;
import form.dashboard.DashBoard;
import form.librarians.LibrarianList;
import static form.login.Login.Admin;
import form.returns.ReturnList;
import form.table.TableActionCellEditor;
import form.table.TableActionCellRender;
import form.table.TableActionEvent;
import form.users.UserList;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import static utils.Database.connectDB;

/**
 *
 * @author YOGA6
 */
public class BookList extends javax.swing.JFrame {

    /**
     * Creates new form BookList
     */
    public BookList() {
        initComponents();
        TableActionEvent event;
        event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                String id = booktitlelist.getModel().getValueAt(row, 0).toString();
                close(); 
                EditBook editBook = new EditBook(id);
                editBook.setVisible(true);
                
            }

            @Override
            public void onView(int row) {
                String id = booktitlelist.getModel().getValueAt(row, 0).toString();
                close(); 
                ViewBook viewBook = new ViewBook(id);
                viewBook.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                String id = booktitlelist.getModel().getValueAt(row, 0).toString();
                if (booktitlelist.isEditing()) {
                    booktitlelist.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) booktitlelist.getModel();
                model.removeRow(row);
                deleleBookTitleByID(id);
                
            }
        };
        booktitlelist.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        booktitlelist.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event));
        fetchBookTitle();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        searchfield = new javax.swing.JTextField();
        addBookButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        booktitlelist = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchfield.setBorder(null);
        searchfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchfieldKeyReleased(evt);
            }
        });
        jPanel2.add(searchfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 390, 30));

        addBookButton.setBackground(new java.awt.Color(0, 102, 102));
        addBookButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addBookButton.setForeground(new java.awt.Color(255, 255, 255));
        addBookButton.setText("Thêm sách mới");
        addBookButton.setBorder(null);
        addBookButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addBookButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addBookButtonMouseExited(evt);
            }
        });
        addBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookButtonActionPerformed(evt);
            }
        });
        jPanel2.add(addBookButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 180, 50));

        booktitlelist.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        booktitlelist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tiêu đề sách", "Năm xuất bản", "Hành động"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        booktitlelist.setRowHeight(40);
        booktitlelist.setSelectionBackground(new java.awt.Color(102, 255, 204));
        jScrollPane1.setViewportView(booktitlelist);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 710, 300));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quản lý kho sách");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tìm kiếm");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

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

    private void fetchBookTitle() {
        try {
            try (Connection c = connectDB()) {
                ResultSet rs = c.createStatement().executeQuery("SELECT id, booktitle, publishedyear FROM booktitle");
                DefaultTableModel model = (DefaultTableModel) booktitlelist.getModel();
                String ID;
                String booktitle;
                String publishedyear;
                while (rs.next()) {
                    int id = rs.getInt(1);
                    ID = String.valueOf(id);
                    booktitle = rs.getString(2);
                    publishedyear = rs.getString(3);
                    String[] row = {ID, booktitle, publishedyear};
                    model.addRow(row);
                }
            }
            
                  
        } catch (SQLException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void deleleBookTitleByID(String id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_2", "root", "");
            c.createStatement().executeUpdate("DELETE FROM booktitle WHERE id = " + id);
            JOptionPane.showMessageDialog(this, "Xóa sách thành công!");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    private void addBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookButtonActionPerformed
        // TODO add your handling code here:
        close();
        CreateBook createBook = new CreateBook();
        createBook.setVisible(true);
    }//GEN-LAST:event_addBookButtonActionPerformed
    private void search(String key) {
        DefaultTableModel model = (DefaultTableModel) booktitlelist.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        booktitlelist.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(key));
    }
    private void searchfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchfieldKeyReleased
        // TODO add your handling code here:
        String searchKey = searchfield.getText();
        search(searchKey);
    }//GEN-LAST:event_searchfieldKeyReleased

    private void addBookButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBookButtonMouseEntered
        Color color = new Color(0,51,51);
        addBookButton.setBackground(color);
    }//GEN-LAST:event_addBookButtonMouseEntered

    private void addBookButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBookButtonMouseExited
        Color color = new Color(0,102,102);
        addBookButton.setBackground(color);
    }//GEN-LAST:event_addBookButtonMouseExited

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
//        close();
//        BookList bkl = new BookList();
//        bkl.setVisible(true);
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
            java.util.logging.Logger.getLogger(BookList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BookList().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookButton;
    private javax.swing.JLabel booklist;
    private javax.swing.JTable booktitlelist;
    private javax.swing.JLabel borrowlist;
    private javax.swing.JLabel dashboard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel librarianlist;
    private javax.swing.JLabel returnlist;
    private javax.swing.JTextField searchfield;
    private javax.swing.JLabel userlist;
    // End of variables declaration//GEN-END:variables
}
