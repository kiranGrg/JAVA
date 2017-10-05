package newpackage;

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

public class Teacher {

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

    Teacher() {
        db = new dbConnect();
        con = db.Connect();
    }

    public void Close() {
        db.Close(con);
    }

    private String getNewId(String people, String query) {
        NumberFormat nf = null;
        if (people.equalsIgnoreCase("teacher")) {
            nf = new DecimalFormat("TEA0000");
        }

        String newId = "";
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            if (rs.next()) {
                newId = nf.format(rs.getInt(1) + 1);
            } else {
                newId = nf.format(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Calculating new Id.");
            return newId;
        }

        return newId;

    }

    public boolean addNewTeacher(String query, String[] values) {
        boolean report = false;
        String query1 = "SELECT max(id) FROM teacher_info";
        String tid = getNewId("teacher", query1);
        if (tid.equalsIgnoreCase("") == true) {
            return report;
        }

        try {
            pst = con.prepareStatement(query);
            pst.setString(1, tid);
            pst.setString(2, values[0]);
            pst.setDate(3, Date.valueOf(values[1]));
            pst.setString(4, values[2]);
            pst.setString(5, values[3]);
            pst.setString(6, values[4]);
            pst.setString(7, values[5]);

            pst.setDate(8, Date.valueOf(values[6]));
            pst.setString(9, values[7]);
            if (pst.executeUpdate() > 0) {
                report = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
        return report;
    }

    public ResultSet getTeacherInfo(String query){
        try{
            stm = con.createStatement();
            ResultSet rs1 = stm.executeQuery(query);
            if(rs1.next()){
                rs = rs1;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error inside Teacher : "+e.getMessage());
            return rs;
        }
        return rs;
    }

    public ResultSet teacherSalary(String query){
     try{
        stm = con.createStatement();
        ResultSet rs1 = stm.executeQuery(query);
        if(rs1.next()){
            rs = rs1;
        }
     }
     catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error inside Teacher : "+e.getMessage());
            return rs;
     }
     return rs;
    }

    public String getQualification(String query){
        String qua = "";
        try{
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            if(rs.next()){
                qua = rs.getString(1);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error inside Teacher : "+e.getMessage());
            return qua;
        }
        return qua;
    }

    public int updateTeacher(String[] values, String query, String teacherId){
        int report = 0;
        try{
            pst = con.prepareStatement(query);
            pst.setString(1, values[0]);
            pst.setString(2, values[1]);
            pst.setString(3, values[2]);
            pst.setString(4, values[3]);
            pst.setString(5, values[4]);
            pst.setString(6, values[5]);
            pst.setString(7, values[6]);
            pst.setString(8, values[7]);
            pst.setString(9, teacherId);
            report = pst.executeUpdate();

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error inside Teacher : "+e.getMessage());
        }
        return report;
    }

}
