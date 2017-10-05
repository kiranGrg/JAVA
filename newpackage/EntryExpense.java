package newpackage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EntryExpense.java
 *
 * Created on Mar 5, 2012, 4:29:53 PM
 */

/**
 *
 * @author kiranroma
 */
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;


public class EntryExpense extends javax.swing.JFrame {

    private JTable table;
    private DefaultTableModel modal;
    private JScrollPane sp;
    private ButtonGroup bg;

    private PreparedStatement pst =  null;
    private Connection con = null;
    private ResultSet rs = null;


    /** Creates new form EntryExpense */
    public EntryExpense() {
        initComponents();

        dbConnect db = new dbConnect();
        con = db.Connect();

        bg = new ButtonGroup();
        bg.add(rbcash);
        bg.add(rbcheque);
        modal = new DefaultTableModel();
        table = new JTable(modal);
        modal.addColumn("S.No.");
        modal.addColumn("  Description  ");
        modal.addColumn("Expense Type");
        modal.addColumn("   Vendor   ");
        modal.addColumn("Vender's Contact:");
        modal.addColumn("   Buyer   ");
        modal.addColumn("Amount");
        modal.addColumn("Date");
        modal.addColumn("Paid By");
        showRecentContent();
       
        int h = JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        int v = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED;
        sp = new JScrollPane(table,v,h);

        pnltable.add(sp);
        sp.setBounds(7, 14, 780, 360);

        //getContentPane().add(sp);
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
        pnlinfo = new javax.swing.JPanel();
        btndate = new javax.swing.JButton();
        txtvender = new javax.swing.JTextField();
        txtdiscription = new javax.swing.JTextField();
        txtbuyer = new javax.swing.JTextField();
        txtdate = new javax.swing.JTextField();
        txtamount = new javax.swing.JTextField();
        rbcash = new javax.swing.JRadioButton();
        rbcheque = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbtype = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        btncancel = new javax.swing.JButton();
        btnentry = new javax.swing.JButton();
        pnltable = new javax.swing.JPanel();

        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Expense Record Keeping");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 790, 50);

        pnlinfo.setLayout(null);

        btndate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndateActionPerformed(evt);
            }
        });
        pnlinfo.add(btndate);
        btndate.setBounds(730, 60, 35, 30);
        pnlinfo.add(txtvender);
        txtvender.setBounds(590, 10, 180, 30);
        pnlinfo.add(txtdiscription);
        txtdiscription.setBounds(80, 10, 150, 30);

        txtbuyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuyerActionPerformed(evt);
            }
        });
        pnlinfo.add(txtbuyer);
        txtbuyer.setBounds(80, 60, 150, 30);
        pnlinfo.add(txtdate);
        txtdate.setBounds(600, 60, 110, 30);
        pnlinfo.add(txtamount);
        txtamount.setBounds(80, 110, 130, 30);

        rbcash.setText("Cash(Rs)");
        pnlinfo.add(rbcash);
        rbcash.setBounds(350, 120, 80, 23);

        rbcheque.setText("Cheque");
        pnlinfo.add(rbcheque);
        rbcheque.setBounds(450, 120, 80, 23);

        jLabel7.setText("Amount:");
        pnlinfo.add(jLabel7);
        jLabel7.setBounds(10, 120, 70, 20);

        jLabel6.setText("Type:");
        pnlinfo.add(jLabel6);
        jLabel6.setBounds(280, 20, 40, 20);

        jLabel5.setText("Bought By:");
        pnlinfo.add(jLabel5);
        jLabel5.setBounds(10, 70, 70, 20);

        jLabel4.setText("Vendor:");
        pnlinfo.add(jLabel4);
        jLabel4.setBounds(530, 20, 50, 20);

        jLabel3.setText("Discription:");
        pnlinfo.add(jLabel3);
        jLabel3.setBounds(10, 20, 70, 20);

        jLabel2.setText("By:");
        pnlinfo.add(jLabel2);
        jLabel2.setBounds(270, 120, 30, 20);

        jLabel8.setText("Date:");
        pnlinfo.add(jLabel8);
        jLabel8.setBounds(560, 70, 40, 20);

        cmbtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Furniture", "Donation" }));
        cmbtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtypeActionPerformed(evt);
            }
        });
        pnlinfo.add(cmbtype);
        cmbtype.setBounds(320, 10, 130, 30);

        jLabel9.setText("Vendor's Contact:");
        pnlinfo.add(jLabel9);
        jLabel9.setBounds(280, 70, 95, 20);
        pnlinfo.add(txtContact);
        txtContact.setBounds(380, 60, 110, 30);

        getContentPane().add(pnlinfo);
        pnlinfo.setBounds(0, 55, 790, 160);

        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        getContentPane().add(btncancel);
        btncancel.setBounds(420, 620, 100, 30);

        btnentry.setText("Entry It");
        btnentry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnentryActionPerformed(evt);
            }
        });
        getContentPane().add(btnentry);
        btnentry.setBounds(280, 620, 100, 30);

        pnltable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Expense Record Display", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N
        pnltable.setLayout(null);
        getContentPane().add(pnltable);
        pnltable.setBounds(0, 220, 790, 380);

        setBounds(250, 10, 807, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void btndateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndateActionPerformed
        // TODO add your handling code here:
        DatePicker dp = new DatePicker();
        txtdate.setText(dp.setPickedDate());
    }//GEN-LAST:event_btndateActionPerformed

    private void btnentryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnentryActionPerformed
        // TODO add your handling code here:
        String discrip = txtdiscription.getText().trim(), vender = txtvender.getText().trim(), date = txtdate.getText().trim();
        String buyer = txtbuyer.getText().trim(), amount = txtamount.getText().trim(), venCont = txtContact.getText().trim();
        String type = (String)cmbtype.getSelectedItem(), paymentType = null;
        if(rbcash.isSelected()){
            paymentType = "c";
        }
        else{
            paymentType = "k";
        }

        if(!discrip.equals("") && !date.equals("") && !amount.equals("") && !type.equalsIgnoreCase("select")){
            if(type.equalsIgnoreCase("donation")){
              String values[] = {discrip,type,"","","",amount,date,paymentType};
              insertExpense(values);
            }
            else{
                if(!buyer.equals("") && !vender.equals("")){
                    String values[] = {discrip,type,vender,venCont,buyer,amount,date,paymentType};
                    insertExpense(values);
                }
                else{
                    JOptionPane.showMessageDialog(this, "Please Provide the Complete Information");
                }
                
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Please Provide the Complete Information");
        }
    }//GEN-LAST:event_btnentryActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btncancelActionPerformed

    private void cmbtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtypeActionPerformed
        // TODO add your handling code here:
        if(((String)cmbtype.getSelectedItem()).equalsIgnoreCase("donation")){
            txtvender.setEnabled(false);
            txtbuyer.setEnabled(false);
            txtContact.setEnabled(false);
        }
    }//GEN-LAST:event_cmbtypeActionPerformed

    private void txtbuyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuyerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuyerActionPerformed

    protected void insertExpense(String[] values){


        String query = "INSERT INTO expense VALUES(null,?,?,?,?,?,?,?,?)";
        try{
            pst = con.prepareStatement(query);
            pst.setString(1, values[0]);
            pst.setString(2, values[1]);
            pst.setString(3, values[2]);
            pst.setString(4, values[3]);
            pst.setString(5, values[4]);
            pst.setFloat(6, Float.parseFloat(values[5]));
            pst.setDate(7, Date.valueOf(values[6]));
            pst.setString(8, values[7]);
            if(pst.executeUpdate()<1){
                    JOptionPane.showMessageDialog(this, "Error during Inserting Values: ");
            }
            else{
                showRecentContent();
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error in Inserting Part: "+e.getMessage());
        }

    }

    public void showRecentContent(){
        String query = "SELECT * FROM expense ORDER BY dateexp DESC";
        Statement stm = null;

        if(modal.getRowCount() != 0){
            for(int i = modal.getRowCount()-1; i>=0; i--){
                modal.removeRow(i);
            }
        }

        try{
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            int j = 1;
            if(rs.next()){
               do{
                modal.addRow(new Object[] {j,rs.getObject(2),rs.getObject(3),rs.getObject(4),rs.getObject(5),rs.getObject(6),rs.getObject(7),rs.getObject(8),rs.getObject(9)});
                j++;
              }while(rs.next());
            }
            else{
                //JOptionPane.showMessageDialog(this, "No data has been entried yet");
            }
            try{
                  query = "SELECT * FROM expenserecord ORDER BY dateexp DESC";
                  stm = con.createStatement();
                  rs = stm.executeQuery(query);
                  j = 1;
                  if(rs.next()){
                       do{
                        modal.addRow(new Object[] {j,rs.getObject(2),rs.getObject(3),rs.getObject(4),rs.getObject(5),rs.getObject(6),rs.getObject(7),rs.getObject(8),rs.getObject(9)});
                        j++;
                      }while(rs.next());
                 }
                 else{
                    //JOptionPane.showMessageDialog(this, "No data has been loaded through xls file");
                 }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error in Sql(Expense) : "+e.getMessage());
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

    /**
    * @param args the command line arguments
    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new EntryExpense().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btndate;
    private javax.swing.JButton btnentry;
    private javax.swing.JComboBox cmbtype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel pnlinfo;
    private javax.swing.JPanel pnltable;
    private javax.swing.JRadioButton rbcash;
    private javax.swing.JRadioButton rbcheque;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtamount;
    private javax.swing.JTextField txtbuyer;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtdiscription;
    private javax.swing.JTextField txtvender;
    // End of variables declaration//GEN-END:variables

}
