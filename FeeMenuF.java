


import javax.swing.*;
import java.sql.*;
import java.util.regex.Pattern;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FeeMenuF.java
 *
 * Created on Mar 2, 2012, 9:10:51 PM
 */
/**
 *
 * @author kiranroma
 */
public class FeeMenuF extends javax.swing.JFrame {
    private String query = null;
    private ButtonGroup rb = new ButtonGroup();
    private float fee = 0.0f;
    private String studentId = "";
    private String param = "[1-9]";
    private String title = "";

    /** Creates new form FeeMenuF */
    public FeeMenuF() {
        initComponents();
        rb.add(rbgroup);
        rb.add(rbindiv);
        rbindiv.setSelected(true);
        pnl2.setEnabled(false);
        cmbgrade2.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbindiv = new javax.swing.JRadioButton();
        rbgroup = new javax.swing.JRadioButton();
        lblheader = new javax.swing.JLabel();
        pnl1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbgrade1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtroll = new javax.swing.JTextField();
        pnl2 = new javax.swing.JPanel();
        cmbgrade2 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        btncancel = new javax.swing.JButton();
        btnsearch = new javax.swing.JButton();

        getContentPane().setLayout(null);

        rbindiv.setText("Individual Search");
        rbindiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbindivActionPerformed(evt);
            }
        });
        getContentPane().add(rbindiv);
        rbindiv.setBounds(50, 80, 130, 23);

        rbgroup.setText("Group Search");
        rbgroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbgroupActionPerformed(evt);
            }
        });
        getContentPane().add(rbgroup);
        rbgroup.setBounds(340, 80, 110, 23);

        lblheader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblheader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fee2.png"))); // NOI18N
        lblheader.setText("Fee From Menu");
        getContentPane().add(lblheader);
        lblheader.setBounds(0, 0, 520, 65);

        pnl1.setLayout(null);

        jLabel2.setText("Grade:");
        pnl1.add(jLabel2);
        jLabel2.setBounds(10, 15, 50, 20);

        cmbgrade1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "X1", "X2", "X3", "X4", "X5", "X6", "X7", "X8", "X9", "X10" }));
        pnl1.add(cmbgrade1);
        cmbgrade1.setBounds(60, 10, 80, 30);

        jLabel3.setText("Name:");
        pnl1.add(jLabel3);
        jLabel3.setBounds(10, 65, 40, 20);
        pnl1.add(txtname);
        txtname.setBounds(60, 60, 170, 30);

        jLabel4.setText("Roll No:");
        pnl1.add(jLabel4);
        jLabel4.setBounds(10, 115, 50, 20);
        pnl1.add(txtroll);
        txtroll.setBounds(60, 100, 70, 30);

        getContentPane().add(pnl1);
        pnl1.setBounds(20, 110, 240, 170);

        pnl2.setLayout(null);

        cmbgrade2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "X1", "X2", "X3", "X4", "X5", "X6", "X7", "X8", "X9", "X10" }));
        pnl2.add(cmbgrade2);
        cmbgrade2.setBounds(70, 10, 90, 30);

        jLabel5.setText("Grade:");
        pnl2.add(jLabel5);
        jLabel5.setBounds(10, 15, 50, 20);

        getContentPane().add(pnl2);
        pnl2.setBounds(330, 110, 170, 170);

        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        getContentPane().add(btncancel);
        btncancel.setBounds(260, 300, 90, 30);

        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnsearch);
        btnsearch.setBounds(150, 300, 90, 30);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-536)/2, (screenSize.height-376)/2, 536, 376);
    }// </editor-fold>//GEN-END:initComponents

    private void rbindivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbindivActionPerformed
        // TODO add your handling code here:
        pnl1.setEnabled(true);
        cmbgrade1.setEnabled(true);
        txtname.setEnabled(true);
        txtroll.setEnabled(true);
        pnl2.setEnabled(false);
        cmbgrade2.setEnabled(false);

    }//GEN-LAST:event_rbindivActionPerformed

    private void rbgroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbgroupActionPerformed
        // TODO add your handling code here:
        pnl2.setEnabled(true);
        cmbgrade2.setEnabled(true);
        pnl1.setEnabled(false);
        cmbgrade1.setEnabled(false);
        txtname.setEnabled(false);
        txtroll.setEnabled(false);
    }//GEN-LAST:event_rbgroupActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btncancelActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:

        Student s = new Student();
        if (rbgroup.isSelected()) {
            String grade = cmbgrade2.getSelectedItem().toString();
            if (!grade.equalsIgnoreCase("select")) {
                //s.Connect();
                query = "SELECT student_info.studentId,student_info.name,student_info.contact,"
                        + "student_info.grade,fee.record,fee.dpay FROM student_info,fee WHERE student_info.studentId = fee.studentId "
                        + "AND fee.grade = '" + grade + "' AND date_format(fee.dpay,'%y%m') = date_format(now(),'%y%m')";
                boolean report = s.studentGroupSearchToTable(query);
                s.Close();
                if (report) {
                    title = "FEE PAYMENTS INFO OF GRADE "+grade;
                    new TabulateData(title,query).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "No fee payment is done for grade : " + grade + " in this Month yet . Sorry");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Select the Grade");
            }
        } else {
            String name = txtname.getText().trim();
            String roll = txtroll.getText().trim();
            String grade = cmbgrade1.getSelectedItem().toString();
            if (name.equals("") && roll.equals("") && grade.equalsIgnoreCase("select")) {
                JOptionPane.showMessageDialog(this, "Please Provide The Full Info For Search");
            } else if (Pattern.matches(param, roll) == false) {
                JOptionPane.showMessageDialog(this, "Please the roll no should be in number");
            } else {
                String sname = getName(name).trim();
                if (!sname.equals("")) {
                    //s.Connect();
                    studentId = s.getValidation(sname, grade, Integer.parseInt(roll));
                    System.out.println(studentId);
                    //s.Close();
                    if (!studentId.equalsIgnoreCase("")) {

                       // s.Connect();
                        query = "SELECT fee FROM student_info WHERE studentId = '" + studentId + "'";
                        fee = s.getFeeAmount(query);
                        System.out.println(fee);
                        query = "SELECT fee.id,fee.studentId,fee.dpay,fee.pamount,fee.fstatus FROM"
                                + " student_info,fee where student_info.studentId = fee.studentId and"
                                + " student_info.grade = '" + grade + "' and student_info.studentId = '"
                                + studentId + "' and date_format(fee.dpay,'%y%m') = date_format(now(),'%y%m')";
                        System.out.println(query);
                        String data[] = s.validGetDataFeeSearch(query);
                        s.Close();
                        /*
                        data[0] = id->int
                         * data[1] = studentid->string
                         * data[2] = dateofpay->date
                         * data[3] = amount->float
                         * data[4] = paystatus ->string
                         */
                        if (data != null) {
                            if (data[4].equalsIgnoreCase("f")) {
                                JOptionPane.showMessageDialog(this, "Current Month Fee has been already paid of \nName: " + txtname.getText() + "\nGrade: " + cmbgrade1.getSelectedItem() + "\nRoll No: " + txtroll.getText());
                            } else {
                                updatePartialPay(Integer.parseInt(data[0]), data[1], data[2], Float.parseFloat(data[3]));
                            }
                        } else {
                            String[] buttons = {"Full", "Partial", "Cancel"};
                            int result = JOptionPane.showOptionDialog(this, "Current Month Fee is not yet paid./nWant to pay now!!", "Fee Payment Section", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);
                            if (result == 0) {
                                if (JOptionPane.showConfirmDialog(this, "Fee amount for " + name + " is Rs. " + fee, "Full Fee Payment for Student " + name, JOptionPane.INFORMATION_MESSAGE) == 0) {
                                    int check = insertFeeValues(name, roll, grade, "f", 0.0f);
                                    if (check == 1) {
                                        JOptionPane.showMessageDialog(this, "Fee of Student Named by " + name + " of grade " + grade + " is paid");
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Error occured during insertion of values");
                                    }
                                }

                            } else if (result == 1) {
                                getPamount(sname, roll, grade);

                            } else {
                                JOptionPane.showMessageDialog(this, "Will be payed later on");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "NO Record Found of the Given Info");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please Provide the Full Name");
                }
            }


        }


    }//GEN-LAST:event_btnsearchActionPerformed

    protected void updatePartialPay(int id, String sid, String date, float amount) {
        String pamount = JOptionPane.showInputDialog(this, "Current Month Fee of \nName: " + txtname.getText() + "\nGrade: " + cmbgrade1.getSelectedItem() + "\nRoll No: " + txtroll.getText() + " has been paid partially.\nRemaining Amount to pay is Rs. " + amount);
        String result = "";
        if (!pamount.equals("")) {
            float money = Float.parseFloat(pamount);
            Student s = new Student();
            //s.Connect();
            if (money >= amount) {
                query = "UPDATE fee SET "
                        + "fstatus = 'f', "
                        + "pamount = '0.0', "
                        + "ldate = now() "
                        + "WHERE id = '" + id + "'";
                result = "Fee has been paid completely for student : " + txtname.getText() + " of grade " + cmbgrade1.getSelectedItem() + ".\n Return Rs. " + (money - amount);
            } else {
                query = "UPDATE fee SET "
                        + "fstatus = 'p', "
                        + "pamount = '" + (amount - money) + "', "
                        + "ldate = now() "
                        + "WHERE id = '" + id + "'";
                result = "Rs. " + money + " has been paid of remaining amount " + amount + " for student : " + txtname.getText() + " of grade " + cmbgrade1.getSelectedItem() + ".\n"
                        + "Pay the remaing Rs. " + (amount - money) + " soon";
            }
            int report = s.feePayUpload(query);
            s.Close();
            if (report > 0) {
                JOptionPane.showMessageDialog(this, result);
            } else {
                JOptionPane.showMessageDialog(this, "Error in updating fee values.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pay Later!!");
        }

    }

    protected void getPamount(String name, String roll, String grade) {
        float amount = 0.0f;
        String pamount = JOptionPane.showInputDialog(this, "Total Fee of Student " + name + " is Rs. " + fee + ".\n Please the money you want to pay for now!!");
        try {
            amount = Float.parseFloat(pamount);
            if (fee > amount) {
                int check = insertFeeValues(name, roll, grade, "p", fee - amount);
                if (check == 1) {
                    JOptionPane.showMessageDialog(this, "Fee of Student Named by " + name + " of grade " + grade + " is paid.\n Please Return the Remainging Rs. " + String.valueOf(fee - amount) + " soon.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error occured during insertion of values");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please entry again... given amount is bigger than actual fee amount");
                getPamount(name, roll, grade);
            }
        } catch (Exception e) {
            if (e.getMessage().equalsIgnoreCase("empty string")) {
                JOptionPane.showMessageDialog(this, "Message: Please Enter the amount");
                getPamount(name, roll, grade);
            } else if (e.getMessage().equalsIgnoreCase("null")) {
                JOptionPane.showMessageDialog(this, "Message: May Be Next time");
            } else {

                JOptionPane.showMessageDialog(this, "Error Message: " + e.getMessage());
                getPamount(name, roll, grade);
            }

        }
    }

    protected int insertFeeValues(String name, String roll, String grade, String status, float amount) {
        Student s = new Student();
        //s.Connect();
        query = "INSERT INTO fee VALUES (null,'" + grade + "',(SELECT amount FROM feeamount WHERE grade = '" + grade + "'),'" + studentId + "',"
                + "'p',now(),'" + status + "','" + amount + "',now())";
        int report = s.feePayUpload(query);
        s.Close();
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
//                new FeeMenuF().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnsearch;
    private javax.swing.JComboBox cmbgrade1;
    private javax.swing.JComboBox cmbgrade2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblheader;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JRadioButton rbgroup;
    private javax.swing.JRadioButton rbindiv;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtroll;
    // End of variables declaration//GEN-END:variables
}
