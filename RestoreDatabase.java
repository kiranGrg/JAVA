

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RestoreDatabase.java
 *
 * Created on Mar 24, 2012, 7:21:08 PM
 */

/**
 *
 * @author kiranroma
 */
import javax.swing.*;
import java.sql.*;

public class RestoreDatabase extends javax.swing.JFrame {
    private String file = "", directory = "";
    private String database ="System";
    private String username ="root";
    private String password ="kiran";

    private Connection con = null;
    private String query = null;
    private Statement stm = null;
    
    /** Creates new form RestoreDatabase */
    public RestoreDatabase() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnBrowse = new javax.swing.JButton();
        txtDirectory = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Please Specify The Sql File To Restore ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 470, 50);

        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });
        getContentPane().add(btnBrowse);
        btnBrowse.setBounds(380, 60, 88, 30);

        txtDirectory.setText("browse the file");
        getContentPane().add(txtDirectory);
        txtDirectory.setBounds(4, 60, 370, 30);

        btnCreate.setText("Cancel");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreate);
        btnCreate.setBounds(240, 105, 90, 30);

        btnCancel.setText("Create");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(130, 105, 90, 30);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-487)/2, (screenSize.height-179)/2, 487, 179);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        // TODO add your handling code here:
        JFileChooser jc = new JFileChooser();
        jc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = jc.showOpenDialog(this);
        if(i == JFileChooser.APPROVE_OPTION){
            directory = jc.getSelectedFile().getAbsolutePath();
            txtDirectory.setText(directory);
            file = jc.getSelectedFile().getName();
            //JOptionPane.showConfirmDialog(this, "Approve button is selected...");
        } else if(i == JFileChooser.CANCEL_OPTION){
            //JOptionPane.showConfirmDialog(this, "Cancel button is selected...");
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        
            try{
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/mysql","root",password);
                //Statement stm = con.createStatement();
                query = "CREATE DATABASE "+database;
                stm = con.createStatement();
                int i = stm.executeUpdate(query);
                if(i > 0){
                    try {

                        int processComplete;// this variable for verify the process

                        String[] executeCmd = new String[]{"C:\\xampp\\mysql\\bin\\mysql", database, "-u" + username, "-p" + password, "-e", " source "+directory};
            //sava the command in a array
                        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);// execute the command

                        processComplete = runtimeProcess.waitFor();// get the result to variable

                        if (processComplete == 1) {// if return value equal to 1 then failed the process

                            JOptionPane.showMessageDialog(null, "Restore Failed");
                        } else if (processComplete == 0) {
                            {// if return value equal to 0 then failed the process

                                JOptionPane.showMessageDialog(null, "Restore Completed");
                                this.dispose();

                            }
                        }
                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(null, "Error Occured: "+e.getMessage());//exeception handling

                    }
                }
            }
            catch(Exception e){
                JOptionPane.showConfirmDialog(this, "Error in Create Database "+e.getMessage());
            }
           
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCreateActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestoreDatabase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtDirectory;
    // End of variables declaration//GEN-END:variables

}