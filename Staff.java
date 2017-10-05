

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

public class Staff {

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
    private dbConnect db = null;

    Staff() {
        db = new dbConnect();
        con = db.Connect();
    }

    public void Close() {
        db.Close(con);
    }

    public String getNewId(String query) {
        NumberFormat nf = new DecimalFormat("SS0000");
        String id = "";
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            if (rs.next()) {
                id = nf.format(rs.getInt(1) + 1);
            } else {
                id = nf.format(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inside Staff : " + e.getMessage());
        }
        return id;
    }

    public int addNewStaff(String[] values, String query) {
        int report = 0;
        String staffId = getNewId("SELECT MAX(id) FROM staff_info");
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, staffId);
            pst.setString(2, values[0]);
            pst.setString(3, values[1]);
            pst.setString(4, values[2]);
            pst.setString(5, values[3]);
            pst.setString(6, values[4]);
            pst.setDate(7, Date.valueOf(values[5]));
            report = pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inside Staff : " + e.getMessage());
        }
        return report;
    }

    public ResultSet getStaffInfo(String query) {
        try {
            stm = con.createStatement();
            ResultSet rs1 = stm.executeQuery(query);
            if (rs1.next()) {
                rs = rs1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inside Staff : " + e.getMessage());
            return rs;
        }
        return rs;
    }

    public String getQualificationPost(String query) {
        String qua = "";
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            if (rs.next()) {
                qua = rs.getString(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inside Staff : " + e.getMessage());
            return qua;
        }
        return qua;
    }

    public int updateStaffInfo(String[] values, String query, String staffId) {
        int report = 0;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, values[0]);
            pst.setString(2, values[1]);
            pst.setString(3, values[2]);
            pst.setString(4, values[3]);
            pst.setString(5, values[4]);
            pst.setDate(6, Date.valueOf(values[5]));
            pst.setString(7, staffId);
            report = pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inside Staff : " + e.getMessage());
        }
        return report;
    }
}
