

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TeacherInfoF.java
 *
 * Created on Jan 24, 2012, 8:41:59 AM
 */
/**
 *
 * @author kiranroma
 */
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class TeacherInfoF extends javax.swing.JFrame {

    private String teacherId = "";
    private String photoPath = null;
    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pstmt = null;
    private String query = null;

    /** Creates new form TeacherInfoF */
    public TeacherInfoF(ResultSet rs) {
        this.rs = rs;

        initComponents();

        fname.setEditable(false);
        mname.setEditable(false);
        lname.setEditable(false);
        doby.setEditable(false);
        dobm.setEditable(false);
        dobd.setEditable(false);
        dobye.setEditable(false);
        dobme.setEditable(false);
        dobde.setEditable(false);
        address.setEditable(false);
        gender.setEnabled(false);
        contact.setEditable(false);
        qua.setEditable(false);
        tid.setEditable(false);
        txtsalary.setEditable(false);
        change.setEnabled(false);
        save.setEnabled(false);
        retrieveData(rs);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        mname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        txtsalary = new javax.swing.JTextField();
        tid = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        photo = new javax.swing.JLabel();
        change = new javax.swing.JButton();
        qua = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        dobd = new javax.swing.JTextField();
        dobm = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        doby = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox();
        dobye = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        dobme = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        dobde = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        edit = new javax.swing.JButton();
        save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel2.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("First Name:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 30, 70, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("M. Name:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(250, 30, 60, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setText("Last Name:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(470, 30, 70, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel8.setForeground(new java.awt.Color(51, 51, 255));
        jLabel8.setText("Employed Year:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 200, 100, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel9.setForeground(new java.awt.Color(51, 51, 255));
        jLabel9.setText("Qualification:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(470, 90, 80, 30);

        fname.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel2.add(fname);
        fname.setBounds(100, 30, 140, 30);

        mname.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel2.add(mname);
        mname.setBounds(320, 30, 140, 30);

        lname.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel2.add(lname);
        lname.setBounds(550, 30, 140, 30);

        txtsalary.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(txtsalary);
        txtsalary.setBounds(120, 240, 100, 30);

        tid.setFont(new java.awt.Font("Tahoma", 1, 12));
        tid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidActionPerformed(evt);
            }
        });
        jPanel2.add(tid);
        tid.setBounds(450, 200, 120, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel10.setForeground(new java.awt.Color(51, 51, 255));
        jLabel10.setText("Salary/Month:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(20, 240, 90, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel11.setForeground(new java.awt.Color(51, 51, 255));
        jLabel11.setText("Address:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(20, 140, 60, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel12.setForeground(new java.awt.Color(51, 51, 255));
        jLabel12.setText("Contact No:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(360, 140, 80, 30);

        address.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel2.add(address);
        address.setBounds(100, 140, 160, 30);

        contact.setFont(new java.awt.Font("Tahoma", 1, 12));
        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactActionPerformed(evt);
            }
        });
        jPanel2.add(contact);
        contact.setBounds(450, 140, 120, 30);

        photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(photo);
        photo.setBounds(580, 120, 110, 140);

        change.setFont(new java.awt.Font("Tahoma", 1, 5));
        change.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/upload.png"))); // NOI18N
        change.setText("Upload Image");
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActionPerformed(evt);
            }
        });
        jPanel2.add(change);
        change.setBounds(590, 260, 90, 25);

        qua.setFont(new java.awt.Font("Tahoma", 1, 12));
        qua.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GENERAL", "SLC", "BACHELOR", "MASTER", "PH.D" }));
        jPanel2.add(qua);
        qua.setBounds(550, 90, 120, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel14.setForeground(new java.awt.Color(51, 51, 255));
        jLabel14.setText("Teacher ID:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(360, 200, 80, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("A.D.");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(270, 100, 30, 14);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("D");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(240, 70, 20, 14);

        dobd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobdActionPerformed(evt);
            }
        });
        jPanel2.add(dobd);
        dobd.setBounds(230, 90, 40, 30);

        dobm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobmActionPerformed(evt);
            }
        });
        jPanel2.add(dobm);
        dobm.setBounds(180, 90, 40, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("M");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(190, 70, 20, 14);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Y");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(120, 70, 30, 14);
        jPanel2.add(doby);
        doby.setBounds(110, 90, 60, 30);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel19.setForeground(new java.awt.Color(51, 51, 255));
        jLabel19.setText("Date of Birth:");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(20, 100, 90, 20);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel20.setForeground(new java.awt.Color(51, 51, 255));
        jLabel20.setText("Gender:");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(310, 90, 50, 30);

        gender.setFont(new java.awt.Font("Tahoma", 1, 12));
        gender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        jPanel2.add(gender);
        gender.setBounds(370, 90, 90, 30);
        jPanel2.add(dobye);
        dobye.setBounds(120, 200, 60, 30);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Y");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(130, 180, 30, 14);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("M");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(200, 180, 30, 14);

        dobme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobmeActionPerformed(evt);
            }
        });
        jPanel2.add(dobme);
        dobme.setBounds(190, 200, 40, 30);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("D");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(240, 180, 30, 14);

        dobde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobdeActionPerformed(evt);
            }
        });
        jPanel2.add(dobde);
        dobde.setBounds(240, 200, 40, 30);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("A.D.");
        jPanel2.add(jLabel24);
        jLabel24.setBounds(290, 210, 40, 20);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 70, 700, 300);

        jPanel3.setPreferredSize(new java.awt.Dimension(699, 50));
        jPanel3.setLayout(null);

        edit.setFont(new java.awt.Font("Tahoma", 1, 14));
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel3.add(edit);
        edit.setBounds(490, 10, 90, 30);

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel3.add(save);
        save.setBounds(110, 9, 90, 30);

        cancel.setFont(new java.awt.Font("Tahoma", 1, 14));
        cancel.setText("OK");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel3.add(cancel);
        cancel.setBounds(310, 10, 90, 30);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(-1, 370, 700, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teacherInfo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 699, 64);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-715)/2, (screenSize.height-461)/2, 715, 461);
    }// </editor-fold>//GEN-END:initComponents

    private void tidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_tidActionPerformed

    private void contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_contactActionPerformed

    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser("E:/Pic Memo/kiran pp photo");
        chooser.showOpenDialog(null);

        File file = chooser.getSelectedFile();
        
        ImageIcon icon = new ImageIcon(file.getPath());
        photoPath = file.getAbsolutePath();
        photo.setIcon(icon);
}//GEN-LAST:event_changeActionPerformed

    private void dobdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobdActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dobdActionPerformed

    private void dobmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobmActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dobmActionPerformed

    private void dobmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobmeActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dobmeActionPerformed

    private void dobdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobdeActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dobdeActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        fname.setEditable(true);
        mname.setEditable(true);
        lname.setEditable(true);
        doby.setEditable(true);
        dobm.setEditable(true);
        dobd.setEditable(true);
        dobye.setEditable(true);
        dobme.setEditable(true);
        dobde.setEditable(true);
        address.setEditable(true);
        gender.setEnabled(true);
        contact.setEditable(true);
        qua.setEditable(true);
        change.setEnabled(true);
        save.setEnabled(true);
    }//GEN-LAST:event_editActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        String name = "";
        if (mname.getText().trim().equalsIgnoreCase("")) {
            name = fname.getText().trim() + " " + lname.getText().trim();
        } else {
            name = fname.getText().trim() + " " + mname.getText().trim() + " " + lname.getText().trim();
        }

        String[] values = {name,
            (doby.getText() + "-" + dobm.getText() + "-" + dobd.getText()),
            address.getText(),
            contact.getText(),
            gender.getSelectedItem().toString(),
            qua.getSelectedItem().toString(),
            (dobye.getText() + "-" + dobme.getText() + "-" + dobde.getText()),
            photoPath};
        query = "UPDATE teacher_info SET "
                + "name = ?, "
                + "dob = ?, "
                + "address = ?, "
                + "contact = ?, "
                + "gender = ?, "
                + "qfc = ?, "
                + "salary = (SELECT salary FROM tsalaryamount WHERE qfc = '" + values[5] + "'), "
                + "empd = ?, "
                + "photo = ? "
                + "WHERE teacherId = ?";

        Teacher t = new Teacher();
        int report = t.updateTeacher(values, query, teacherId);
        t.Close();
        if (report > 0) {
            JOptionPane.showMessageDialog(this, "Data Updated Successfully. Thank You.");
        } else {
            JOptionPane.showMessageDialog(this, "Error in Updating. Sorry");
        }

    }//GEN-LAST:event_saveActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void retrieveData(ResultSet rs) {

        try {
            int i, j, len1, len2;
            teacherId = rs.getString("teacherId");
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
            String[] dob = getDateString((rs.getDate("dob")).toString());
            String[] doe = getDateString((rs.getDate("empd")).toString());
            doby.setText(dob[0]);
            dobm.setText(dob[1]);
            dobd.setText(dob[2]);
            dobye.setText(doe[0]);
            dobme.setText(doe[1]);
            dobde.setText(doe[2]);
            txtsalary.setText(rs.getString("salary"));
            address.setText(rs.getString("address"));
            contact.setText(rs.getString("contact"));
            tid.setText(rs.getString("teacherId"));
            qua.setSelectedItem(rs.getString("qfc"));
            gender.setSelectedItem(rs.getString("gender"));
            photoPath = rs.getString("photo");
            File file = new File(photoPath);
            ImageIcon icon;
            if (file.exists()) {
                icon = new ImageIcon(photoPath);

            } else {
                icon = new ImageIcon(getClass().getResource("/images/NO PHOTO.png"));
            }
            photo.setIcon(icon);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: inside TeacherInfo: " + e.getMessage(), "Notice", JOptionPane.PLAIN_MESSAGE);
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
        }
    }

    private String[] getDateString(String date) {
        String y = null, m = null, d = null, ex = null;

        int f, s, l1, l2;
        l1 = date.length();
        f = date.indexOf("-");
        y = date.substring(0, f);
        ex = date.substring(f + 1, l1);
        l2 = ex.length();
        s = ex.indexOf("-");
        m = ex.substring(0, s);
        d = ex.substring(s + 1, l2);
        String[] dateSt = {y, m, d};
        return (dateSt);

    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TeacherInfoF().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JButton cancel;
    private javax.swing.JButton change;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField dobd;
    private javax.swing.JTextField dobde;
    private javax.swing.JTextField dobm;
    private javax.swing.JTextField dobme;
    private javax.swing.JTextField doby;
    private javax.swing.JTextField dobye;
    private javax.swing.JButton edit;
    private javax.swing.JTextField fname;
    private javax.swing.JComboBox gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField mname;
    private javax.swing.JLabel photo;
    private javax.swing.JComboBox qua;
    private javax.swing.JButton save;
    private javax.swing.JTextField tid;
    private javax.swing.JTextField txtsalary;
    // End of variables declaration//GEN-END:variables
}
