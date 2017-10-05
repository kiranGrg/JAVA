

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CreateBackUpDatabase.java
 *
 * Created on Mar 8, 2012, 12:02:53 PM
 */
/**
 *
 * @author kiranroma
 */
import javax.swing.*;

public class CreateBackUpDatabase extends javax.swing.JFrame {

    /**
     * Creates new form CreateBackUpDatabase
     */
    private String directory = "";
    private String database = "System";
    private String username = "root";
    private String password = "kiran";

    public CreateBackUpDatabase() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
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
        jLabel2.setText("Please Specify The Directory To Store Your BackUp File");
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

        txtDirectory.setText("Select Directory");
        getContentPane().add(txtDirectory);
        txtDirectory.setBounds(4, 60, 370, 30);

        btnCreate.setText("Cancel");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreate);
        btnCreate.setBounds(240, 105, 90, 30);

        btnCancel.setText("Create");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
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
        jc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int i = jc.showOpenDialog(this);
        if (i == JFileChooser.APPROVE_OPTION) {
            directory = jc.getSelectedFile().getAbsolutePath();
            txtDirectory.setText(directory);
            //JOptionPane.showConfirmDialog(this, "Approve button is selected...");
        } else if (i == JFileChooser.CANCEL_OPTION) {
            //JOptionPane.showConfirmDialog(this, "Cancel button is selected...");
        }

    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        if (!txtDirectory.getText().equalsIgnoreCase("Select Directory")) {

            try {

                int processComplete; // to verify that either process completed or not

                Process runtimeProcess = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqldump -u " + username + " -p" + password + " " + database + " -r " + directory + "/backUp.sql");
                // Process runtimeProcess = Runtime.getRuntime().exec("C:\\Program Files\\MySQL\\MySQL Server 5.0\\bin\\mysqldump -u root -p websms -r D:/backUp.sql");

                // call the mysqldump in terminal and execute it

                processComplete = runtimeProcess.waitFor();//store the state in variable

                if (processComplete == 1) {//if values equal 1 process failed

                    JOptionPane.showMessageDialog(null, "Backup Failed");//display message
                } else if (processComplete == 0) {//if values equal 0 process failed

                    JOptionPane.showMessageDialog(null, "\n Backup created Successfully..\n Check the Backup File in the " + directory + " named as backup.sql");
                    //display message
                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);//exeception handling

            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Mention the directory");
        }

    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCreateActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateBackUpDatabase().setVisible(true);
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
