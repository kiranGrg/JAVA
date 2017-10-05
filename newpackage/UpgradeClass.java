package newpackage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UpgradeClass.java
 *
 * Created on Mar 21, 2012, 1:14:19 PM
 */
/**
 *
 * @author kiranroma
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.*;
import java.text.*;
import java.util.Calendar;

public final class UpgradeClass extends javax.swing.JFrame {

    private Connection con = null;
    private String query = null;
    private ResultSet rs = null;
    private Statement stm = null;
    private PreparedStatement pstm = null;
    private DefaultTableModel modal = new DefaultTableModel();
    private JTable table;
    private JScrollPane sp;
    private int id[] = null;
    private String[][] data;
    private Date[] date = null;
    private int cols, rows;
    private DateFormat d = new SimpleDateFormat("yyyy-mm-dd");
    private Calendar c = Calendar.getInstance();
    private String dateQ = null;
    int selectedid = 0;

    /** Creates new form UpgradeClass */
    public UpgradeClass() {
        initComponents();
        table = new JTable(modal);
        modal.addColumn("S.No.");
        modal.addColumn("ID");
        modal.addColumn("Name");
        //modal.addColumn("Grade");
        modal.addColumn("Roll");
        modal.addColumn("Report");
        modal.addColumn("Contact");
        int v = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        sp = new JScrollPane(table, v, h);
        getContentPane().add(sp);
        sp.setBounds(5, 110, 733, 485);
        table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                getDataToUpdate(e);
            }
        });


    }

    private void getDataToUpdate(MouseEvent e) {

        int r = table.getSelectedRow();
        String studentId = table.getModel().getValueAt(r, 1).toString();
        String name = table.getModel().getValueAt(r, 2).toString();
        String report = table.getModel().getValueAt(r, 4).toString();
        String reports = report.equalsIgnoreCase("p") ? "passed" : "failed";
        String grade = "";
        Object[] options = {"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(this, name.toUpperCase() + " has been " + reports + " " + grade + ".\n"
                + "Would you like to update the data of a student?", "Result", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (option == 0) {
            if (report.equalsIgnoreCase("p")) {
                grade = cmbgrade.getItemAt(cmbgrade.getSelectedIndex() + 1).toString();
            } else {
                grade = cmbgrade.getItemAt(cmbgrade.getSelectedIndex()).toString();
            }
            Student s = new Student();
            query = "SELECT max(roll) FROM student_info WHERE grade = '" + grade + "' AND year = YEAR('" + dateQ + "')";
            int roll = s.getNewRoll(query);
            query = "UPDATE student_info SET grade = '" + grade + "', fee = (SELECT amount FROM feeamount WHERE grade = '" + grade + "'), "
                        + "roll = '" + roll + "', year = YEAR ('" + dateQ + "') WHERE studentId = '"+studentId+"'";
            if(s.feePayUpload(query) > 0){
                JOptionPane.showMessageDialog(this, "The Students Data is Updated to Grade : " + grade);
                display();
            }
            else{
                JOptionPane.showMessageDialog(this, "Sorry Updated Process Failed");
            }
            s.Close();

        } else {
            JOptionPane.showMessageDialog(this, "Thank You. I will Come Later to this");
        }
    }

    protected void loadcmbdateValue() {

        dbConnect db = new dbConnect();
        con = db.Connect();
        if (con != null) {
            try {
                query = "SELECT id,YEAR(date), date FROM examterm WHERE term = '3' AND grade = '" + cmbgrade.getSelectedItem().toString() + "'";
                stm = con.createStatement();
                rs = stm.executeQuery(query);
                rs.last();
                date = new Date[rs.getRow()];
                id = new int[rs.getRow()];
                rs.beforeFirst();
                int i = 0;
                if (rs.next()) {
                    id[i] = rs.getInt(1);
                    cmbdate.addItem(rs.getString(2));
                    date[i] = rs.getDate(3);
                } else {
                    JOptionPane.showMessageDialog(this, "Final exam report has not been loaded yet..");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error in Sql part1 : " + e.getMessage());
            } finally {
                db.Close(con);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error in Connection!!");
        }
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbgrade = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbdate = new javax.swing.JComboBox();
        btngetdata = new javax.swing.JButton();
        btnup = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();

        getContentPane().setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Upgrading Section");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 740, 50);

        jLabel2.setText("Grade:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 60, 60, 20);

        cmbgrade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "X1", "X2", "X3", "X4", "X5", "X6", "X7", "X8", "X9", "X10" }));
        cmbgrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbgradeActionPerformed(evt);
            }
        });
        getContentPane().add(cmbgrade);
        cmbgrade.setBounds(140, 50, 100, 30);

        jLabel3.setText("Final Exam Date:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(390, 60, 110, 20);

        cmbdate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        cmbdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdateActionPerformed(evt);
            }
        });
        getContentPane().add(cmbdate);
        cmbdate.setBounds(510, 50, 100, 30);

        btngetdata.setText("Get Data");
        btngetdata.setEnabled(false);
        btngetdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngetdataActionPerformed(evt);
            }
        });
        getContentPane().add(btngetdata);
        btngetdata.setBounds(470, 605, 100, 30);

        btnup.setText("Upgrade");
        btnup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupActionPerformed(evt);
            }
        });
        getContentPane().add(btnup);
        btnup.setBounds(330, 605, 100, 30);

        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        getContentPane().add(btncancel);
        btncancel.setBounds(600, 605, 100, 30);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-758)/2, (screenSize.height-680)/2, 758, 680);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdateActionPerformed
        // TODO add your handling code here:


        selectedid = id[cmbdate.getSelectedIndex() - 1];
        if (cmbdate.getSelectedIndex() != 0) {
            int i = 1;

//            if (modal.getRowCount() > 0) {
//                for (int j = modal.getRowCount() - 1; j >= 0; j--) {
//                    modal.removeRow(j);
//                }
//            }
            Calendar c2 = Calendar.getInstance();
            c2.setTime(date[cmbdate.getSelectedIndex() - 1]);
            if (String.valueOf(c.get(Calendar.YEAR)).equalsIgnoreCase(String.valueOf(c2.get(Calendar.YEAR)))) {
                c2.add(Calendar.YEAR, 1);
                dateQ = d.format(c2.getTime());
            } else {
                c.add(Calendar.YEAR, 1);
                c.add(Calendar.YEAR, -1);
                dateQ = d.format(c.getTime());
                System.out.println(dateQ);
            }
            display();

//            dbConnect db = new dbConnect();
//            con = db.Connect();
//            if (con != null) {
//                try {
//                    query = "SELECT student_info.studentId,student_info.name,student_info.roll,exam.report,student_info.contact FROM exam,student_info "
//                            + "WHERE student_info.studentId = exam.studentId AND student_info.year != YEAR(?) AND exam.id = ?";
//                    pstm = con.prepareStatement(query);
//                    pstm.setString(1, dateQ);
//                    pstm.setInt(2, selectedid);
//                    rs = pstm.executeQuery();
//                    ResultSetMetaData rsmd = rs.getMetaData();
//
//                    rs.last();
//                    rows = rs.getRow();
//                    cols = rsmd.getColumnCount();
//                    System.out.println(rows + "      " + cols);
//                    data = new String[rows][cols];
//                    String[] data1 = new String[cols + 1];
//                    rs.beforeFirst();
//                    int j = 0, k = 1;
//                    while (rs.next()) {
//                        data1[0] = String.valueOf(j + 1);
//                        for (k = 0; k < cols; k++) {
//                            data[j][k] = rs.getObject(k + 1).toString();
//                            data1[k + 1] = rs.getObject(k + 1).toString();
//                        }
//                        modal.addRow(data1);
//                        j++;
//                    }
//                    for (int l = 0; l < rows; l++) {
//                        for (int m = 0; m < cols; m++) {
//                            System.out.println(data[l][m] + "  ");
//                        }
//                        System.out.println();
//                    }
//                } catch (Exception e) {
//                    db.Close(con);
//                    JOptionPane.showMessageDialog(this, "Error in Sql part : " + e.getMessage());
//                }
//            } else {
//                JOptionPane.showMessageDialog(this, "Error in Connection");
//            }
        } else {
            JOptionPane.showMessageDialog(this, "Plese Sepcify the date");
        }
    }//GEN-LAST:event_cmbdateActionPerformed

    public void display(){
        if (modal.getRowCount() > 0) {
                for (int j = modal.getRowCount() - 1; j >= 0; j--) {
                    modal.removeRow(j);
                }
            }
        dbConnect db = new dbConnect();
            con = db.Connect();
            if (con != null) {
                try {
                    query = "SELECT student_info.studentId,student_info.name,student_info.roll,exam.report,student_info.contact FROM exam,student_info "
                            + "WHERE student_info.studentId = exam.studentId AND student_info.year != YEAR(?) AND exam.id = ?";
                    pstm = con.prepareStatement(query);
                    pstm.setString(1, dateQ);
                    pstm.setInt(2, selectedid);
                    rs = pstm.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();

                    rs.last();
                    rows = rs.getRow();
                    cols = rsmd.getColumnCount();
                    System.out.println(rows + "      " + cols);
                    data = new String[rows][cols];
                    String[] data1 = new String[cols + 1];
                    rs.beforeFirst();
                    int j = 0, k = 1;
                    while (rs.next()) {
                        data1[0] = String.valueOf(j + 1);
                        for (k = 0; k < cols; k++) {
                            data[j][k] = rs.getObject(k + 1).toString();
                            data1[k + 1] = rs.getObject(k + 1).toString();
                        }
                        modal.addRow(data1);
                        j++;
                    }
                    for (int l = 0; l < rows; l++) {
                        for (int m = 0; m < cols; m++) {
                            System.out.println(data[l][m] + "  ");
                        }
                        System.out.println();
                    }
                } catch (Exception e) {
                    db.Close(con);
                    JOptionPane.showMessageDialog(this, "Error in Sql part : " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error in Connection");
            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Plese Sepcify the date");
//        }
    }
    private void cmbgradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbgradeActionPerformed
        int count = cmbdate.getItemCount();

        if (count > 1) {
            for (int k = count - 1; k > 0; k--) {
                cmbdate.removeItemAt(k);
            }
        }
        loadcmbdateValue();
    }//GEN-LAST:event_cmbgradeActionPerformed

    private void btngetdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngetdataActionPerformed
        // TODO add your handling code here:
//        //if(cmbdate.getSelectedIndex() != 0 && cmbgrade.getSelectedIndex() != 0)
//        int selectedid = id[cmbgrade.getSelectedIndex()];
//        if (selectedid != 0 && cmbdate.getSelectedIndex() != 0) {
//            int i = 1;
//
//            if (modal.getRowCount() > 0) {
//                for (int j = modal.getRowCount() - 1; j >= 0; j--) {
//                    modal.removeRow(j);
//                }
//            }
//
//            dbConnect db = new dbConnect();
//            con = db.Connect();
//            if (con != null) {
//                try {
//                    query = "SELECT studentId,name,roll,report,contact FROM exam WHERE id = ?";
//                    pstm = con.prepareStatement(query);
//                    pstm.setInt(1, selectedid);
//                    rs = pstm.executeQuery();
//                    ResultSetMetaData rsmd = rs.getMetaData();
//
//                    rs.last();
//                    rows = rs.getRow();
//                    cols = rsmd.getColumnCount();
//                    data = new String[rows][cols];
//                    String[] data1 = new String[cols + 1];
//                    rs.beforeFirst();
//                    int j = 0, k = 1;
//                    while (rs.next()) {
//                        data1[0] = String.valueOf(k);
//                        //System.out.println(data1[0]);
//                        for (k = 0; k < cols; k++) {
//                            //int k = 0;
//                            data[j][k] = rs.getObject(k + 1).toString();
//                            //System.out.println(data[j][k]);
//                            data1[k + 1] = rs.getObject(k + 1).toString();
//                            //System.out.println(data1[k+1]);
//                            //modal.addRow(new Object[] {i,rs.getObject(1),rs.getObject(2),rs.getObject(3),rs.getObject(4),rs.getObject(5)});
//                        }
//                        modal.addRow(data1);
//                        k++;
//                    }
////                    while(rs.next()){
////                        data[j][k] = rs.getObject(1).toString();
////                        k++;
////                        data[j][k] = rs.getObject(2).toString();
////                        k++;
////                        data[j][k] = rs.getObject(3).toString();
////                        k++;
////                        data[j][k] = rs.getObject(4).toString();
////                        k++;
////                        data[j][k] = rs.getObject(5).toString();
////                        k++;
////                        modal.addRow(new Object[] {i,rs.getObject(1),rs.getObject(2),rs.getObject(3),rs.getObject(4),rs.getObject(5)});
////                        i++;
////                        j++;
////                    }
////                    for(String[] d: data){
////                        System.out.println(d);
////                    }
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(this, "Error in Sql part : " + e.getMessage());
//                }
//            } else {
//                JOptionPane.showMessageDialog(this, "Error in Connection");
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Plese Sepcify the garde");
//        }
    }//GEN-LAST:event_btngetdataActionPerformed

    private void btnupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupActionPerformed
        // TODO add your handling code here:
        int report = 0;
        int roll = 0;
        String grade = "";
        Student s = new Student();
        for (int i = 0; i < rows; i++) {
            if (data[i][3].equalsIgnoreCase("p")) {
                grade = cmbgrade.getItemAt(cmbgrade.getSelectedIndex() + 1).toString();
            } else {
                grade = cmbgrade.getSelectedItem().toString();
            }
            query = "SELECT max(roll) FROM student_info WHERE grade = '" + grade + "' AND year = YEAR('" + dateQ + "')";
            roll = s.getNewRoll(query);
            query = "UPDATE student_info SET grade = '" + grade + "', fee = (SELECT amount FROM feeamount WHERE "
                    + "grade = '" + grade + "'), roll = '" + roll + "', year = YEAR ('" + dateQ + "') "
                    + "WHERE studentId = '" + data[i][0] + "'";
            report = s.feePayUpload(query);
        }
        s.Close();
        if (report > 0) {
            JOptionPane.showMessageDialog(this, "Data Has Been Updated Successfully");
        }


    }//GEN-LAST:event_btnupActionPerformed


    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btncancelActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                new UpgradeClass().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btngetdata;
    private javax.swing.JButton btnup;
    private javax.swing.JComboBox cmbdate;
    private javax.swing.JComboBox cmbgrade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
