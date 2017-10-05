

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kiranroma
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class dbConnect {

    private String database = "System";
    private String user = "root";
    private String pass = "kiran";
    private String driver = "com.mysql.jdbc.Driver";
    private String connector = "jdbc:mysql://localhost:3306/" + database;
    private Connection con = null;

    public dbConnect() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error insed dbConnect : " + e.getMessage());
            System.exit(0);
        }
    }

    public Connection Connect() {

        try {
            con = DriverManager.getConnection(connector, user, pass);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error insed dbConnect : " + e.getMessage());
            return null;
        }
        return con;
    }

    public void Close(Connection con) {
//        boolean report = false;
        if (con != null) {
            try {
                con.close();
//                report = true;
            } catch (SQLException ex) {
                Logger.getLogger(dbConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        return report;
    }
}
