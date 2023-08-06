/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package library_management_aptech;
import form.dashboard.DashBoard;
import form.login.Login;
import static utils.Database.*;


/**
 *
 * @author YOGA6
 */
public class Library_Management_Aptech {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        connectDB();
        Login login = new Login();
        login.setVisible(true);
    }
    
    
}
