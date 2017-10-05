

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kiranroma
 */
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.text.*;
import java.util.Calendar;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class TSsalary {

    private String database = "System";
    private String user = "root";
    private String pass = "kiran";
    private String driver = "com.mysql.jdbc.Driver";
    private String connector = "jdbc:mysql://localhost:3306/" + database;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private ResultSetMetaData rsmd = null;
    private Connection con = null;
    private Statement stm = null;
    private String query = null;
    dbConnect db = null;

    TSsalary(){
        db = new dbConnect();
        con = db.Connect();
    }

//    public void Connect() {
//        try {
//            Class.forName(driver);
//        } catch (ClassNotFoundException e) {
//            JOptionPane.showMessageDialog(null, "Error insed dbConnect : " + e.getMessage());
//            System.exit(0);
//        }
//        try {
//            con = DriverManager.getConnection(connector, user, pass);
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error insed dbConnect : " + e.getMessage());
//            System.exit(0);
//        }
//    }

    public void Close() {
        if (con != null) {
//            try {
                db.Close(con);
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "Error insed dbConnect : " + ex.getMessage());
//                System.exit(0);
//            }
        }
    }

    public boolean tsSalary(DefaultTableModel model, String query, String post){
        boolean report = false;
        int i = 1;
        try{
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            while(rs.next()){
                model.addRow(new Object[]{i, post, rs.getFloat(2), rs.getDate(3), rs.getString(4)});
                    i++;
            }
            report = true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error Inside tsSalary -> salary ofptionf: "+e.getMessage());
        }
        return report;
    }

    public boolean currentSalaryStatus(String query){
        boolean report = false;
        try{
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            if(rs.next()){
                report = true;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error inside Teacher : "+e.getMessage());
        }
        return report;
    }

    public int paySalaryCurrent(String query){//also used from SalaryMenuF
        int report = 0;
        try{
            stm = con.createStatement();
            report = stm.executeUpdate(query);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error inside TSsalary : "+e.getMessage());
        }
        return report;
    }

    public boolean tsSalaryValidationId(String query){//used for both validation and to check the current payment salary from salarymenuF
        boolean report = false;
        try{
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            if(rs.next()){
                report = true;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error inside TSsalary : "+e.getMessage());
        }
        return report;
    }
}
