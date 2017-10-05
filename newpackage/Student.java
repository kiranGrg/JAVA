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

public class Student {

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
    private dbConnect db = new dbConnect();

    Student() {
        db = new dbConnect();
        con = db.Connect();
    }
//
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
        db.Close(con);
    }

    public String getValidation(String name, String grade, int roll) {
        String result = "";
        System.out.println(name+grade+roll);
        try {
            query = "SELECT studentId FROM student_info WHERE name = '"+name+"' AND roll = '"+roll+"' AND grade = '"+grade+"'";
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            if (rs.next()) {
                result = rs.getString(1);
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inside Student : " + e.getMessage());
        }
        return result;
    }

    public String getReportExam(String query){
        String report = "";
        try{
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            if (rs.next()) {
                report = rs.getString(1);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error inside Student getReport : "+e.getMessage());
        }
        return report;
    }

    public String getNewId(String people, String query) {
        NumberFormat nf = null;
        if (people.equalsIgnoreCase("student")) {
            nf = new DecimalFormat("XYZ0000");
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
            JOptionPane.showMessageDialog(null, "Error Calculating new Id."+e.getMessage());
            return newId;
        }

        return newId;
    }

    public boolean addNewStudent(String query, String[] values) {
        boolean report = false;
        String sid = null;
        int roll = 0;
        try {
            sid = getNewId("student", "SELECT max(id) FROM student_info");//calling function to get new id for student


            if (!sid.equalsIgnoreCase("")) {
                String query1 = "SELECT max(roll) FROM student_info WHERE grade = '"+values[7]+"' AND year = YEAR(now())";
                roll = getNewRoll(query1);
                if(roll == 0){
                    JOptionPane.showMessageDialog(null, "Error");
                    return report;
                }
            } else {
                return report;
            }
            pst = con.prepareStatement(query);
            pst.setString(1, sid);
            pst.setString(2, values[0]);
            pst.setDate(3, Date.valueOf(values[1]));
            pst.setString(4, values[2]);
            pst.setString(5, values[3]);
            pst.setString(6, values[4]);
            pst.setString(7, values[5]);
            pst.setDate(8, Date.valueOf(values[6]));
            pst.setString(9, values[7]);
            pst.setInt(10, roll);
            pst.setString(11, values[8]);
            pst.executeUpdate();
            report = true;


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Inside Student : " + e.getMessage(), "Notice!!!", JOptionPane.PLAIN_MESSAGE);
            return report;
        }

        return report;
    }

    public ResultSet getInfo(String query) {
        try {
            stm = con.createStatement();
            ResultSet rs1 = stm.executeQuery(query);
            if (rs1.next()) {
                rs = rs1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Inside Student : " + e.getMessage(), "Notice!!!", JOptionPane.PLAIN_MESSAGE);
        } finally {
            //Close();
        }

        return rs;
    }

    public boolean examFeeIndAllReport(String result, DefaultTableModel model, String query) {
        boolean reportr = false;
        try {
            int i = 1;
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            if (rs.next()) {
                reportr = true;
                do {
                    if (result.equalsIgnoreCase("exam")) {
                        String report = rs.getString(4).equalsIgnoreCase("f") ? "failed" : "passed";
                        model.addRow(new Object[]{i, rs.getString(1), rs.getInt(2), rs.getString(3), report, rs.getDate(5)});
                    } else {
                        String report = rs.getString(5).equalsIgnoreCase("f") ? "full" : "partial";
                        model.addRow(new Object[]{i, rs.getString(1), rs.getFloat(2), rs.getDate(3), rs.getString(4), report, rs.getString(6), rs.getString(7)});
                    }
                    i++;
                } while (rs.next());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Inside Student : " + e.getMessage());
        } finally {
            //Close();
        }

        return reportr;
    }

    public boolean studentGroupSearchToTable(String query){//also used to check the upgrade students records from ResultInd
        boolean report = false;
        try{
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            if(rs.next()){
                report = true;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error insdie Student: "+ e.getMessage());
        }
        return report;
    }

    public int getNewRoll(String query){//also used to get the roll from resultInd//also used from UpgradeClass.java
        
        int roll = 0;
        try{
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            if(rs.next()){
                roll = rs.getInt(1) + 1;
            }
            else{
                roll = 1;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error inside roll : "+e.getMessage());
            return roll;
        }
        return roll;
    }

    public boolean updateInfo(String query, String[] values, String studentId){
        boolean report = false;
        try{
//                String query1 = "SELECT max(roll) FROM student_info WHERE grade = '"+values[7]+"' AND year = YEAR(now())";
//                int roll = getNewRoll(query1);
//                if(roll == 0){
//                    JOptionPane.showMessageDialog(null, "Error");
//                    return report;
//                }
                pst = con.prepareStatement(query);
                pst.setString(1, values[0]);
                pst.setDate(2, Date.valueOf(values[1]));
                pst.setString(3, values[2]);
                pst.setString(4, values[3]);
                pst.setString(5, values[4]);
                pst.setString(6, values[5]);
                pst.setDate(7, Date.valueOf(values[6]));
                pst.setString(8, values[7]);
                pst.setString(9, values[8]);
                pst.setString(10, studentId);
                pst.executeUpdate();
                report = true;
                
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error inside Student : "+e.getMessage());
            return report;
        }

        return report;
    }

    public String[] validGetDataFeeSearch(String query){
        String data[] = null;
        try{
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            if(rs.next()){

            rsmd = rs.getMetaData();
            data = new String[rsmd.getColumnCount()];
                for(int i = 0; i<rsmd.getColumnCount(); i++){
                    data[i] = rs.getObject(i+1).toString();
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error inside Student: "+e.getMessage());
        }
        return data;
    }

    public float getFeeAmount(String query){
        float fee = 0.0f;
        try{
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            if(rs.next()){
                fee = rs.getFloat(1);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error inside Student: "+e.getMessage());
        }
        return fee;
    }

    public int feePayUpload(String query){/*full and partial fee payment upload from feeofallInd file,
                                            and also from ResultInd to Upgrade students and from UpgradeClass too*/
        int report = 0;
        try{
            stm = con.createStatement();
            report = stm.executeUpdate(query);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error inside Student : "+e.getMessage());
        }
        return report;
    }

}
//    public Object[][] examReport(int status, int option, String s_id) {
//        Object[][] rowdata = null;
//        switch (status) {
//            case 1:
//                query = "SELECT examterm.grade, exam.roll, examterm.term, exam.report, examterm.date FROM exam,examterm WHERE exam.id = examterm.id AND exam.studentId = '" + s_id + "'"
//                        + " AND date_format(examterm.date,'%y') = date_format(now(),'%y')";
//                break;
//            case 2:
//                query = "SELECT examterm.grade, exam.roll, examterm.term, exam.report, examterm.date FROM exam,examterm WHERE exam.id = examterm.id AND exam.studentId = '" + s_id + "'";
//                break;
//        }
//
//        try {
//            int i = 0;
//            stm = con.createStatement();
//            rs = stm.executeQuery(query);
//            rsmd = rs.getMetaData();
//            rs.last();
//            rowdata = new Object[rs.getRow()][rsmd.getColumnCount() + 1];
//            rs.beforeFirst();
//            if (rs.next()) {
//                do {
//                    rowdata[i][0] = i + 1;
//                    for (int k = 1; k < rsmd.getColumnCount() + 1; k++) {
//                        if (k == 4) {
//                            String report = rs.getString(4).equalsIgnoreCase("f") ? "failed" : "passed";
//                            rowdata[i][k] = report;
//                        } else {
//                            rowdata[i][k] = rs.getString(k);
//
//                        }
//                    }
//                    i++;
//                } while (rs.next());
////                do {
////                    String report = rs.getString(4).equalsIgnoreCase("f") ? "failed" : "passed";
////                    rowdata[]
////                    model.addRow(new Object[]{i, rs.getString(1), rs.getInt(2), rs.getString(3), report, rs.getDate(5)});
////                    i++;
////                } while (rs.next())
//            } else {
//                if (option != 0) {
//                    JOptionPane.showMessageDialog(null, "No data found. \nThank you!!");
//                }
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error in Sql : " + e.getMessage());
//        } finally {
//            //db.Close();
//        }
//
//        return rowdata;
//    }

