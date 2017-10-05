package newpackage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PartialPay.java
 *
 * Created on Mar 18, 2012, 11:06:03 PM
 */

/**
 *
 * @author kiranroma
 */

import java.sql.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class PartialPay extends javax.swing.JFrame {

    private int status, index;
    private String[] values;
    private String query = "", pdate, pamount;
    private Connection con = null;
    private Statement stm = null;
    private int id;
    private String title = "";
    //private float f = 0.00f;

    /** Creates new form PartialPay */
    public PartialPay(String[] values, String pdate, String amount, int index, int status, int id, String title) {
        this.title = title;
        this.status = status;
        this.values = values;
        this.index = index;
        this.pdate = pdate;
        pamount = amount;
        this.id = id;
        initComponents();

        txtname.setText(values[0]);
        txtid.setText(values[1]);
        txtdate.setText(values[2]);
        txtgrade.setText(values[3]);
        txtamount.setText(values[4]);
        txtreturn.setText("0.000");
        txtpartial.setText(amount);
        txtpdate.setText(pdate);
        txtgiven.getDocument().addDocumentListener(new MyDocumentListener());
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
        lbldate = new javax.swing.JLabel();
        lblgrade = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();
        txtgrade = new javax.swing.JTextField();
        lblid = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        lblname = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        lblamount = new javax.swing.JLabel();
        txtamount = new javax.swing.JTextField();
        txtgiven = new javax.swing.JTextField();
        lblgiven = new javax.swing.JLabel();
        txtreturn = new javax.swing.JTextField();
        lblreturn = new javax.swing.JLabel();
        btncancel = new javax.swing.JButton();
        btnpay = new javax.swing.JButton();
        lblamount1 = new javax.swing.JLabel();
        txtpartial = new javax.swing.JTextField();
        lbldate1 = new javax.swing.JLabel();
        txtpdate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblheader.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblheader.setForeground(new java.awt.Color(51, 153, 255));
        lblheader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblheader.setText("Payment:");
        getContentPane().add(lblheader);
        lblheader.setBounds(0, 0, 580, 50);

        lbldate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbldate.setText("Date:");
        getContentPane().add(lbldate);
        lbldate.setBounds(415, 60, 45, 20);

        lblgrade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblgrade.setText("Grade:");
        getContentPane().add(lblgrade);
        lblgrade.setBounds(10, 110, 50, 20);

        txtdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtdate.setEnabled(false);
        getContentPane().add(txtdate);
        txtdate.setBounds(470, 55, 100, 25);

        txtgrade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtgrade.setEnabled(false);
        getContentPane().add(txtgrade);
        txtgrade.setBounds(65, 105, 60, 25);

        lblid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblid.setText("ID:");
        getContentPane().add(lblid);
        lblid.setBounds(220, 60, 35, 20);

        txtid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtid.setEnabled(false);
        getContentPane().add(txtid);
        txtid.setBounds(260, 55, 140, 25);

        lblname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblname.setText("Name:");
        getContentPane().add(lblname);
        lblname.setBounds(10, 60, 50, 20);

        txtname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtname.setEnabled(false);
        getContentPane().add(txtname);
        txtname.setBounds(65, 55, 140, 25);

        lblamount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblamount.setText("Fee Amount:");
        getContentPane().add(lblamount);
        lblamount.setBounds(180, 110, 90, 20);

        txtamount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtamount.setEnabled(false);
        getContentPane().add(txtamount);
        txtamount.setBounds(280, 105, 80, 25);

        txtgiven.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtgiven);
        txtgiven.setBounds(260, 155, 80, 25);

        lblgiven.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblgiven.setText("Given:");
        getContentPane().add(lblgiven);
        lblgiven.setBounds(200, 160, 60, 20);

        txtreturn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtreturn);
        txtreturn.setBounds(440, 155, 80, 25);

        lblreturn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblreturn.setText("Return:");
        getContentPane().add(lblreturn);
        lblreturn.setBounds(370, 160, 60, 20);

        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        getContentPane().add(btncancel);
        btncancel.setBounds(320, 210, 100, 30);

        btnpay.setText("Pay");
        btnpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpayActionPerformed(evt);
            }
        });
        getContentPane().add(btnpay);
        btnpay.setBounds(160, 210, 100, 30);

        lblamount1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblamount1.setText("Partial Paid:");
        getContentPane().add(lblamount1);
        lblamount1.setBounds(10, 160, 90, 20);

        txtpartial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpartial.setEnabled(false);
        getContentPane().add(txtpartial);
        txtpartial.setBounds(100, 155, 80, 25);

        lbldate1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbldate1.setText("P. Date:");
        getContentPane().add(lbldate1);
        lbldate1.setBounds(395, 110, 60, 20);

        txtpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpdate.setEnabled(false);
        getContentPane().add(txtpdate);
        txtpdate.setBounds(470, 105, 100, 25);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-598)/2, (screenSize.height-285)/2, 598, 285);
    }// </editor-fold>//GEN-END:initComponents

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new FeeNotPaidGroup(title, status,index).setVisible(true);
}//GEN-LAST:event_btncancelActionPerformed

    private void btnpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpayActionPerformed
        // TODO add your handling code here:
        //String query = "";
        //if(txtgiven.getText().trim().e
        String money = txtgiven.getText().trim();
        //System.out.println(money);
        if(money.equals("")){
            JOptionPane.showMessageDialog(this, "Please Entered the money Provided");
        } else{
//            try{
                float amount = Float.parseFloat(money);
                //if(amount >= Float.parseFloat(values[4])){
                if(amount >0){
                    dbConnect db = new dbConnect();
                    con = db.Connect();
                    if(con != null){
                       // if(status == 1){
                            if(amount < Float.parseFloat(pamount)){
                                float d = Float.parseFloat(pamount) - amount;
                                query = "UPDATE fee SET "
                                        + "grade = '"+values[3]+"', "
                                        + "amount = '"+values[4]+"', "
                                        + "studentId = '"+values[1]+"', "
                                        + "record = 'p', "
                                        + "dpay = '"+values[2]+"', "
                                        + "fstatus = 'p', "
                                        + "pamount = '"+d+"' "
                                        + "WHERE id = '"+id+"'";
                                //query = "INSERT INTO fee VALUES (null,'"+values[3]+"','"+values[4]+"','"+values[1]+"','p','"+values[2]+"','p','"+d+"')";
                            } else if(amount >= Float.parseFloat(pamount)){
                                //query = "INSERT INTO fee VALUES (null,'"+values[3]+"','"+values[4]+"','"+values[1]+"','p','"+values[2]+"','f','0')";
                                query = "UPDATE fee SET "
                                        + "grade = '"+values[3]+"', "
                                        + "amount = '"+values[4]+"', "
                                        + "studentId = '"+values[1]+"', "
                                        + "record = 'p', "
                                        + "dpay = '"+values[2]+"', "
                                        + "fstatus = 'f', "
                                        + "pamount = '0', "
                                        + "ldate = now() "
                                        + "WHERE id = '"+id+"'";
                            }

//                        } else if(status == 2){
//                            query = "INSERT INTO teachersalary VALUES ('"+values[1]+"','"+values[2]+"','"+values[4]+"','p')";
//                        } else{
//                            query = "INSERT INTO staffsalary VALUES ('"+values[1]+"','"+values[4]+"','"+values[2]+"','p')";
//                        }
                        try{
                            //query = "INSERT INTO fee VALUES (null,'"+grade+"','"+fee+"','"+id+"','p','"+date+"')";
                            stm = con.createStatement();
                            int check = stm.executeUpdate(query);
                            if(check > 0){
                                String result = "";
                                if(Float.parseFloat(pamount) == amount){
                                    result = "Payment is done Successfully.\nThank You!!";
                                }
                                else if(Float.parseFloat(pamount) > amount){
                                    float remoney = Float.parseFloat(pamount) - amount;
                                    result = "Payment is done Successfully. Remaining Rs. "+remoney+".\nPay soon .. Thank You!!";
                               }
                               else if(Float.parseFloat(pamount) < amount){
                                    float remoney = amount - Float.parseFloat(pamount);
                                    result = "Payment is done Successfully. Please return Rs. "+remoney+".\nThank You!!";
                               }
                                JOptionPane.showMessageDialog(this, result);
                                this.dispose();
                                new FeeNotPaidGroup(title, status,index).setVisible(true);
                            } else{
                                JOptionPane.showMessageDialog(this, "Error in sql");
                            }
                        } catch(Exception e){
                            JOptionPane.showMessageDialog(this, "error : "+e.getMessage());
                        } finally{
                            db.Close(con);}
                    } else{
                        JOptionPane.showMessageDialog(this, "Error in Connection");
                    }
                } else{
                    JOptionPane.showMessageDialog(this, "Amount is not sufficient");
//                }
//            } catch(NumberFormatException e){
//                //JOptionPane.showMessageDialog(this, "The given input is not a number : "+e.getMessage());
//            }
        }

        }
    }//GEN-LAST:event_btnpayActionPerformed

    /**
    * @param args the command line arguments
    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                //new PartialPay().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnpay;
    private javax.swing.JLabel lblamount;
    private javax.swing.JLabel lblamount1;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbldate1;
    private javax.swing.JLabel lblgiven;
    private javax.swing.JLabel lblgrade;
    private javax.swing.JLabel lblheader;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblreturn;
    private javax.swing.JTextField txtamount;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtgiven;
    private javax.swing.JTextField txtgrade;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpartial;
    private javax.swing.JTextField txtpdate;
    private javax.swing.JTextField txtreturn;
    // End of variables declaration//GEN-END:variables

    public class MyDocumentListener implements DocumentListener{
        public void update(DocumentEvent e){
            Document doc = e.getDocument();
            int length = doc.getLength();
            String str = null;
            //if(cmbCat.getSelectedIndex() == 0){
            if(length !=0){
                    try {
                    str = doc.getText(0, length);
                    try{
                        float i = Float.parseFloat(str);
                        if(i > Float.parseFloat(pamount)){
                            txtreturn.setText(String.valueOf(i - Float.parseFloat(pamount)));
                        }
                        //txtreturn.setText(String.valueOf(Float.parseFloat(pamount)-i));
                    }
                    catch(NumberFormatException ed){
                            JOptionPane.showMessageDialog(null, "Error: "+ed.getMessage());
                        }

                    } catch (BadLocationException ex) {
                    }
            }
            else{
                txtreturn.setText("0.000");
            }

         }
        public void changedUpdate(DocumentEvent de) {
            // text was changed
           update(de);

        }

        public void removeUpdate(DocumentEvent de) {
            update(de);
        }

        public void insertUpdate(DocumentEvent de) {
             update(de);
        }



    }
}