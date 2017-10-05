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


public class CommonTabulateData {

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

    CommonTabulateData() {
        db = new dbConnect();
        con = db.Connect();
    }

    public void Close() {
        db.Close(con);
    }

    public Object[][] getTabulatedData(String query, DefaultTableModel modal, JComboBox cmbCat) {
        Object data[][] = null;
        int no_cols = 0;
        int no_rows = 0;
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(query);

            if (rs.next()) {
                ResultSetMetaData metaData = rs.getMetaData();
                no_cols = metaData.getColumnCount();
                rs.last();
                no_rows = rs.getRow();
                rs.beforeFirst();
                data = new Object[no_rows][no_cols];
                int i = 0;
                Object obj[] = new Object[no_cols];
                for (int k = 0; k < no_cols; k++) {
                    modal.addColumn(metaData.getColumnName(k + 1));
                    if (!metaData.getColumnName(k + 1).equalsIgnoreCase("teacherId") && !metaData.getColumnName(k + 1).equalsIgnoreCase("staffId") && !metaData.getColumnName(k + 1).equalsIgnoreCase("studentId")) {
                        cmbCat.addItem(metaData.getColumnName(k + 1));
                    }

                }
                while(rs.next()){
                    for (int j = 0; j < no_cols; j++) {

                        data[i][j] = rs.getObject(j + 1);
                        obj[j] = rs.getObject(j + 1);
                    }
                    i++;
                    modal.addRow(obj);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error :" + e.getMessage());
        }
        return data;
    }

    public String[] getColumnName(String query) {
        String[] columnNames = null;
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            if (rs.next()) {
                ResultSetMetaData metaData = rs.getMetaData();
                columnNames = new String[metaData.getColumnCount()];
                for (int k = 0; k < metaData.getColumnCount(); k++) {
                    columnNames[k] = metaData.getColumnName(k + 1);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inside CommonTabulateData c: " + e.getMessage());
        }
        return columnNames;
    }

    public boolean dataValidCheck(String query) {
        boolean report = false;
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            if (rs.next()) {
                report = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inside CommonTabulateData: " + e.getMessage());
        }
        return report;
    }
}
