

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SalaryMenuF.java
 *
 * Created on Mar 7, 2012, 12:45:14 PM
 */
/**
 *
 * @author kiranroma
 */
import javax.swing.*;

public class SalaryMenuF extends javax.swing.JFrame {

    private String query = "";
    private ButtonGroup rb = new ButtonGroup();
    private String title = "";

    /** Creates new form SalaryMenuF */
    public SalaryMenuF() {
        initComponents();
        rb.add(rbgroup);
        rb.add(rbindiv);
        rbindiv.setSelected(true);
        pnl2.setEnabled(false);
        cmbcat2.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblheader = new javax.swing.JLabel();
        pnl1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbcat1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        rbindiv = new javax.swing.JRadioButton();
        rbgroup = new javax.swing.JRadioButton();
        pnl2 = new javax.swing.JPanel();
        cmbcat2 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        btncancel = new javax.swing.JButton();
        btnsearch = new javax.swing.JButton();

        getContentPane().setLayout(null);

        lblheader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblheader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staffsalary_1.png"))); // NOI18N
        lblheader.setText("Salary From Menu");
        getContentPane().add(lblheader);
        lblheader.setBounds(0, 0, 520, 65);

        pnl1.setLayout(null);

        jLabel2.setText("Category");
        pnl1.add(jLabel2);
        jLabel2.setBounds(10, 15, 50, 20);

        cmbcat1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Staff", "Teacher" }));
        pnl1.add(cmbcat1);
        cmbcat1.setBounds(70, 10, 90, 30);

        jLabel3.setText("Name:");
        pnl1.add(jLabel3);
        jLabel3.setBounds(10, 65, 40, 20);
        pnl1.add(txtname);
        txtname.setBounds(70, 60, 160, 30);

        jLabel4.setText("ID:");
        pnl1.add(jLabel4);
        jLabel4.setBounds(10, 115, 40, 20);
        pnl1.add(txtid);
        txtid.setBounds(70, 110, 90, 30);

        getContentPane().add(pnl1);
        pnl1.setBounds(20, 110, 240, 170);

        rbindiv.setText("Individual Search");
        rbindiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbindivActionPerformed(evt);
            }
        });
        getContentPane().add(rbindiv);
        rbindiv.setBounds(40, 80, 130, 23);

        rbgroup.setText("Group Search");
        rbgroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbgroupActionPerformed(evt);
            }
        });
        getContentPane().add(rbgroup);
        rbgroup.setBounds(340, 80, 110, 23);

        pnl2.setLayout(null);

        cmbcat2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Staff", "Teacher" }));
        pnl2.add(cmbcat2);
        cmbcat2.setBounds(90, 10, 90, 30);

        jLabel5.setText("Category:");
        pnl2.add(jLabel5);
        jLabel5.setBounds(10, 15, 60, 20);

        getContentPane().add(pnl2);
        pnl2.setBounds(310, 110, 190, 170);

        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        getContentPane().add(btncancel);
        btncancel.setBounds(265, 300, 90, 30);

        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnsearch);
        btnsearch.setBounds(155, 300, 90, 30);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-536)/2, (screenSize.height-376)/2, 536, 376);
    }// </editor-fold>//GEN-END:initComponents

    private void rbindivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbindivActionPerformed
        // TODO add your handling code here:
        pnl1.setEnabled(true);
        cmbcat1.setEnabled(true);
        txtname.setEnabled(true);
        txtid.setEnabled(true);
        pnl2.setEnabled(false);
        cmbcat2.setEnabled(false);
    }//GEN-LAST:event_rbindivActionPerformed

    private void rbgroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbgroupActionPerformed
        // TODO add your handling code here:
        pnl2.setEnabled(true);
        cmbcat2.setEnabled(true);
        pnl1.setEnabled(false);
        cmbcat1.setEnabled(false);
        txtname.setEnabled(false);
        txtid.setEnabled(false);
}//GEN-LAST:event_rbgroupActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_btncancelActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
        boolean report = false;
        CommonTabulateData td = new CommonTabulateData();
        if (rbgroup.isSelected()) {
            String category = (String) cmbcat2.getSelectedItem();
            if (!category.equalsIgnoreCase("select")) {
                if (category.equalsIgnoreCase("staff")) {
                    query = "SELECT staff_info.staffId,staff_info.name,staff_info.contact,staff_info.post FROM staff_info,staffsalary"
                            + " WHERE staff_info.staffId = staffsalary.staffId AND staffsalary.report = 'p' AND date_format(staffsalary.dop,'%y%m') = date_format(now(),'%y%m')";
                    title = "STAFF'S SALARY PAYMENT RECORD OF CURRENT MONTH";
                } else {
                    query = "SELECT teacher_info.teacherId,teacher_info.name,teacher_info.contact,teacher_info.empd FROM teacher_info,teachersalary"
                            + " WHERE teacher_info.teacherId = teachersalary.teacherId AND teachersalary.report = 'p' AND date_format(teachersalary.dop,'%y%m') = date_format(now(),'%y%m')";
                    title = "TEACHER'S SALARY PAYMENT RECORD OF CURRENT MONTH";
                }

                report = td.dataValidCheck(query);
                td.Close();

                if (report) {
                    new TabulateData(title,query).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "No Data Found\nNo salary has been paid. Thank you");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Select the Grade");
            }
        } else {
            String name = txtname.getText().trim();
            String id = txtid.getText().trim();
            String category = (String) cmbcat1.getSelectedItem();
            if (!name.equals("") && !id.equals("") && !category.equalsIgnoreCase("select")) {
                String sname = getName(name).trim();
                if (!sname.equals("")) {
                    if (category.equalsIgnoreCase("staff")) {
                        query = "SELECT * FROM staff_info WHERE staffId = '" + id + "' AND name = '" + sname + "'";
                    } else {
                        query = "SELECT * FROM teacher_info WHERE teacherId = '" + id + "' AND name = '" + sname + "'";
                    }
                    System.out.println(query);
                    TSsalary ts = new TSsalary();
                    //ts.Connect();
                    report = ts.tsSalaryValidationId(query);
                    if (report) {
                        if (category.equalsIgnoreCase("staff")) {
                            query = "SELECT * FROM staff_info,staffsalary WHERE staff_info.staffId = staffsalary.staffId AND name = '" + sname + "'"
                                    + " AND staff_info.staffId = '" + id + "' AND date_format(staffsalary.dop,'%y%m') = date_format(now(),'%y%m')";
                        } else {
                            query = "SELECT * FROM teacher_info,teachersalary WHERE teacher_info.teacherId = teachersalary.teacherId AND "
                                    + "name = '" + name + "' AND teacher_info.teacherId = '" + id + "' AND date_format(teachersalary.dop,'%y%m') = date_format(now(),'%y%m')";
                        }
                        System.out.println(query);
                        report = ts.tsSalaryValidationId(query);
                        ts.Close();
                        System.out.println(report);
                        if (report) {
                            JOptionPane.showMessageDialog(this, "Current Month Salary has been already paid of \nName: " + txtname.getText() + "\n" + category.toUpperCase() + "ID: " + txtid.getText());
                        } else {
                            if (JOptionPane.showConfirmDialog(this, "Current month Salary is not yet paid./nWant to make payment.", "Salary Payment", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
                                int check = insertFeeValues(name, id, category);
                                if (check == 1) {
                                    JOptionPane.showMessageDialog(this, "Salary of " + category + " Named by " + name + " with" + category.toUpperCase() + "ID" + id + "is paid");
                                } else {
                                    JOptionPane.showMessageDialog(this, "Error occured during insertion of values");
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Will be payed later on");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No Record is Found. Sorry");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please Enter the full name");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Provide the full Info a Student");
            }
        }

}//GEN-LAST:event_btnsearchActionPerformed

    protected int insertFeeValues(String name, String id, String category) {
        int report = 0;
        TSsalary ts = new TSsalary();
        //ts.Connect();
            if (category.equalsIgnoreCase("staff")) {
                query = "INSERT INTO staffsalary VALUES (null,'" + id + "',(SELECT salary FROM salaryamount WHERE post = (SELECT post FROM staff_info WHERE staffId = '" + id + "')),now(),'p')";
            } else {
                query = "INSERT INTO teachersalary VALUES (null,'" + id + "',now(),(SELECT salary FROM tsalaryamount WHERE qfc = (SELECT qfc FROM teacher_info WHERE teacherId = '" + id + "')),'p')";
            }
        report = ts.paySalaryCurrent(query);
        ts.Close();
        return report;
    }

    private String getName(String name) {
        int len1 = 0, len2 = 0, i = 0, j = 0;
        String sname = "", s1 = "", s2 = "", s3 = "", s4 = "";


        i = name.indexOf(" ");
        if (i > 0) {
            len1 = name.length();
            s1 = name.substring(0, i);
            sname += s1 + " ";
            s2 = (name.substring(i, len1)).trim();

            j = s2.indexOf(" ");
            if (j > 0) {
                len2 = s2.length();
                s3 = s2.substring(0, j);
                sname += s3 + " ";
                s4 = (s2.substring(j, len2)).trim();
                sname += s4 + " ";
            } else {
                sname += s2;
            }
        }

        return (sname);
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                new SalaryMenuF().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnsearch;
    private javax.swing.JComboBox cmbcat1;
    private javax.swing.JComboBox cmbcat2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblheader;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JRadioButton rbgroup;
    private javax.swing.JRadioButton rbindiv;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
