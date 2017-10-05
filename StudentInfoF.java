

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StudentInfoF.java
 *
 * Created on Jan 22, 2012, 4:21:39 PM
 */
/**
 *
 * @author kiranroma
 */
import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.sql.*;
import java.net.URL.*;

public class StudentInfoF extends javax.swing.JFrame {

    /** Creates new form StudentInfoF */
    private String photoPath = null;
    private String sid = "", gradeIn = "";
    private int id = 0, rollc = 0;

    /** Creates new form Student_Info */
    public StudentInfoF(ResultSet rs) {
        initComponents();
        fname.setEditable(false);
        mname.setEditable(false);
        lname.setEditable(false);
        dob.setEditable(false);
        address.setEditable(false);
        gender.setEnabled(false);
        gardian.setEditable(false);
        contact.setEditable(false);
        enroll.setEditable(false);
        cmbgrade.setEditable(false);
        roll.setEditable(false);
        change.setEnabled(false);
        btnsave.setEnabled(false);
        Fee.setEnabled(false);
        studentid.setEnabled(false);
        connectionToDatabase(rs);
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
        jPanel3 = new javax.swing.JPanel();
        mname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        gardian = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dob = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        change = new javax.swing.JButton();
        photo = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        enroll = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Fee = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        studentid = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        roll = new javax.swing.JTextField();
        cmbgrade = new javax.swing.JComboBox();
        btnsave = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        btnok = new javax.swing.JButton();

        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/studentInfo1.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 64);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Student's Personal Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel3.setMinimumSize(new java.awt.Dimension(400, 300));
        jPanel3.setPreferredSize(new java.awt.Dimension(699, 300));
        jPanel3.setLayout(null);

        mname.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel3.add(mname);
        mname.setBounds(320, 30, 140, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setText("Last Name:");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(470, 30, 70, 30);

        lname.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel3.add(lname);
        lname.setBounds(550, 30, 140, 30);

        contact.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel3.add(contact);
        contact.setBounds(430, 180, 130, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel8.setForeground(new java.awt.Color(51, 51, 255));
        jLabel8.setText("Address:");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(20, 130, 70, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel9.setForeground(new java.awt.Color(51, 51, 255));
        jLabel9.setText("Gender:");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(340, 130, 50, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("M. Name:");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(260, 30, 60, 30);

        fname.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel3.add(fname);
        fname.setBounds(110, 30, 140, 30);

        gardian.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel3.add(gardian);
        gardian.setBounds(130, 180, 160, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("Contact No:");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(340, 180, 80, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("First Name:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(20, 30, 70, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("Date of Birth:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(20, 80, 90, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel10.setForeground(new java.awt.Color(51, 51, 255));
        jLabel10.setText("Gardian's Name:");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(20, 180, 100, 30);

        dob.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel3.add(dob);
        dob.setBounds(110, 80, 140, 30);

        address.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel3.add(address);
        address.setBounds(110, 130, 210, 30);

        change.setFont(new java.awt.Font("Tahoma", 1, 5));
        change.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/upload.png"))); // NOI18N
        change.setText("Upload Image");
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActionPerformed(evt);
            }
        });
        jPanel3.add(change);
        change.setBounds(570, 210, 120, 30);

        photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/NO PHOTO.png"))); // NOI18N
        jPanel3.add(photo);
        photo.setBounds(580, 70, 110, 140);

        gender.setFont(new java.awt.Font("Tahoma", 1, 12));
        gender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MALE", "FEMALE" }));
        jPanel3.add(gender);
        gender.setBounds(410, 130, 120, 30);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 70, 700, 250);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Academic Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 51, 51))); // NOI18N
        jPanel1.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel12.setForeground(new java.awt.Color(51, 51, 255));
        jLabel12.setText("Grade:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(300, 30, 41, 17);

        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("A.D");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(250, 30, 30, 14);

        enroll.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel1.add(enroll);
        enroll.setBounds(120, 20, 120, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel11.setForeground(new java.awt.Color(51, 51, 255));
        jLabel11.setText("Enrolled Date:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 30, 86, 17);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel15.setForeground(new java.awt.Color(51, 51, 255));
        jLabel15.setText("Fee/Month:");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(290, 70, 70, 17);

        Fee.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel1.add(Fee);
        Fee.setBounds(370, 61, 80, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel16.setForeground(new java.awt.Color(51, 51, 255));
        jLabel16.setText("Student ID:");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(20, 70, 72, 17);

        studentid.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel1.add(studentid);
        studentid.setBounds(120, 61, 120, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel13.setForeground(new java.awt.Color(51, 51, 255));
        jLabel13.setText("Roll No:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(490, 30, 47, 17);

        roll.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel1.add(roll);
        roll.setBounds(560, 21, 70, 30);

        cmbgrade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "X1", "X2", "X3", "X4", "X5", "X6", "X7", "X8", "X9", "X10" }));
        jPanel1.add(cmbgrade);
        cmbgrade.setBounds(370, 20, 90, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 320, 700, 110);

        btnsave.setText("save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnsave);
        btnsave.setBounds(320, 440, 100, 30);

        edit.setFont(new java.awt.Font("Tahoma", 1, 14));
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        getContentPane().add(edit);
        edit.setBounds(100, 440, 100, 30);

        btnok.setFont(new java.awt.Font("Tahoma", 1, 14));
        btnok.setText("OK");
        btnok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnokActionPerformed(evt);
            }
        });
        getContentPane().add(btnok);
        btnok.setBounds(570, 440, 70, 30);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-715)/2, (screenSize.height-521)/2, 715, 521);
    }// </editor-fold>//GEN-END:initComponents

    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        //chooser.showOpenDialog(null);
        chooser.showOpenDialog(this);

        File file = chooser.getSelectedFile();
        photoPath = file.getPath();
        ImageIcon icon = new ImageIcon(photoPath);
        photo.setIcon(icon);
}//GEN-LAST:event_changeActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        fname.setEditable(true);
        mname.setEditable(true);
        lname.setEditable(true);
        dob.setEditable(true);
        address.setEditable(true);
        gender.setEnabled(true);
        gardian.setEditable(true);
        contact.setEditable(true);
        enroll.setEditable(true);
        cmbgrade.setEditable(true);
        change.setEnabled(true);
        btnsave.setEnabled(true);
        edit.setEnabled(false);
}//GEN-LAST:event_editActionPerformed

    private void btnokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnokActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_btnokActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed

        // TODO add your handling code here:
        String Sname = "", query = null;
        Student s = new Student();
        if ((mname.getText()).equalsIgnoreCase("")) {
            Sname = fname.getText().trim() + " " + lname.getText().trim();
        } else {
            Sname = fname.getText().trim() + " " + mname.getText().trim() + " " + lname.getText().trim();
        }
        String[] values = {Sname, dob.getText().trim(), gender.getSelectedItem().toString(), gardian.getText().trim(),
            address.getText().trim(), contact.getText().trim(), enroll.getText().trim(),
            cmbgrade.getSelectedItem().toString(), photoPath};
        if(!cmbgrade.getSelectedItem().toString().equalsIgnoreCase(gradeIn)){
            rollc = s.getNewRoll("SELECT max(roll) FROM student_info WHERE grade = '"+values[7]+"' AND year = YEAR(now())");
            System.out.println(rollc);
             query = "UPDATE student_info SET name = ?, dob = ?, gender = ?, gardianName = ?,address = ?,contact = ? ,enrolled = ?,grade =?,"
                + "fee = (SELECT amount FROM feeamount WHERE grade = '" + values[7] + "'),roll = '"+rollc+"', photo = ?  WHERE studentId = ?";
        }
        else{
            query = "UPDATE student_info SET name = ?, dob = ?, gender = ?, gardianName = ?,address = ?,contact = ? ,enrolled = ?,grade =?,"
                + "fee = (SELECT amount FROM feeamount WHERE grade = '" + values[7] + "'), photo = ?  WHERE studentId = ?";
        }
        

        
        //s.Connect();
        boolean report = s.updateInfo(query, values, sid);
        //s.Close();
        if (report) {
            JOptionPane.showMessageDialog(this, "Updated Successfully");
        } else {
            JOptionPane.showMessageDialog(this, "Error During Updating.");
        }

        query = "SELECT * FROM student_info WHERE name = '"+Sname+"' AND grade = '"+cmbgrade.getSelectedItem().toString()+"' AND roll = '"+rollc+"'";
                //s.Connect();
        ResultSet rs = s.getInfo(query);
        if(rs != null){
            connectionToDatabase(rs);
        }
        //btnsave.setEnabled(false);

    }//GEN-LAST:event_btnsaveActionPerformed

    private void connectionToDatabase(ResultSet rs) {
        try {
            int i, j, len1, len2;
            sid = rs.getString("studentId");
            id = rs.getInt("id");
            rollc = rs.getInt("roll");
            gradeIn = rs.getString("grade");
            String s1 = null, s2 = null, s3 = null, s4 = null;
            String name = (rs.getString("name")).trim().toUpperCase();
            len1 = name.length();
            if (len1 > 0) {
                i = name.indexOf(" ");
                s1 = name.substring(0, i);
                s2 = (name.substring(i, len1)).trim();
                len2 = s2.length();
                j = s2.indexOf(" ");
                if (j > 0) {
                    s3 = s2.substring(0, j);
                    s4 = (s2.substring(j, len2)).trim();
                    fname.setText(s1);
                    mname.setText(s3);
                    lname.setText(s4);
                } else {
                    fname.setText(s1);
                    lname.setText(s2);
                }
            }
            dob.setText(rs.getDate("dob").toString());
            gardian.setText(rs.getString("gardianName"));
            address.setText(rs.getString("address"));
            contact.setText(rs.getString("contact"));
            enroll.setText(rs.getDate("enrolled").toString());
            cmbgrade.setSelectedItem((rs.getString("grade")));
            Fee.setText(String.valueOf(rs.getFloat("fee")));
            studentid.setText(rs.getString("studentId"));
            roll.setText(String.valueOf(rs.getInt("roll")));

            gender.setSelectedItem(rs.getString("gender"));
            photoPath = rs.getString("photo");

            File file = new File(photoPath);
            ImageIcon icon;
            if (file.exists()) {
                icon = new ImageIcon(photoPath);

            } else {
                icon = new ImageIcon("C:/Users/kiranroma/Documents/NetBeansProjects/System/src/images/NO PHOTO.png");
            }
            photo.setIcon(icon);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: hhhh " + e.getMessage(), "Notice", JOptionPane.PLAIN_MESSAGE);
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
        }
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new StudentInfoF().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Fee;
    private javax.swing.JTextField address;
    private javax.swing.JButton btnok;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton change;
    private javax.swing.JComboBox cmbgrade;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField dob;
    private javax.swing.JButton edit;
    private javax.swing.JTextField enroll;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField gardian;
    private javax.swing.JComboBox gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField mname;
    private javax.swing.JLabel photo;
    private javax.swing.JTextField roll;
    private javax.swing.JTextField studentid;
    // End of variables declaration//GEN-END:variables
}
