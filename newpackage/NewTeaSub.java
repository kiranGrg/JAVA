package newpackage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewTeaSub.java
 *
 * Created on Dec 22, 2011, 3:55:31 PM
 */

/**
 *
 * @author kiranroma
 */
import javax.swing.*;
import java.sql.*;
public class NewTeaSub extends javax.swing.JFrame {

        private Connection con = null;
   private PreparedStatement pst = null;
   private String driver = "com.mysql.jdbc.Driver";
   private String conUrl = "jdbc:mysql://localhost:3306/system";
   private String query = null;
   private ResultSet rs = null;

   ////// for 1st split pane...
   private String[] name1 = new String[50];
   private String[] id1 = new String[50];
   private String[] qua1 = new String[50];

   private String[] name2 = new String[50];
   private String[] id2 = new String[50];
   //private String[] id11 = new String[50];
//   private float[] salary = new float[50];
//   private String[] toc = new String[50];
//   private String[] sub = new String[50];

   ////// for loop or flags*************
   private int f =0;
   //private int m = 0;
   private int s = 0;
   //private int c = 0;
   private int i = 0;
   //private int check = 0;
   private String[] csdel = new String[50];
   //private String[] subdel = new String[50];
   private int count = 0;
   //private int del = 0;

    /** Creates new form NewTeaSub */

    public NewTeaSub() {
        initComponents();
        conToDataBase();
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        addTea = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        c2 = new javax.swing.JComboBox();
        c1 = new javax.swing.JComboBox();
        add = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        delTea = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        cancel = new javax.swing.JButton();

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TEACHER'S SUBJECT ASIGNMENT SECTION");
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jSplitPane1.setDividerLocation(180);
        jSplitPane1.setDividerSize(10);
        jSplitPane1.setOneTouchExpandable(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Subject", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel2.setLayout(null);

        jPanel2.add(addTea);
        addTea.setBounds(10, 60, 140, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Select Teacher");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 30, 90, 20);

        jLabel3.setText("Class:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 130, 40, 20);

        c2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "X1", "X2", "X3", "X4", "X5", "X6", "X7", "X8", "X9", "X10" }));
        jPanel2.add(c2);
        c2.setBounds(50, 170, 90, 30);

        c1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "X1", "X2", "X3", "X4", "X5", "X6", "X7", "X8", "X9", "X10" }));
        jPanel2.add(c1);
        c1.setBounds(50, 120, 90, 30);

        add.setText("Assign Subject");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel2.add(add);
        add.setBounds(20, 220, 140, 23);

        jSplitPane1.setLeftComponent(jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Delete Subject", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel3.setLayout(null);

        jPanel3.add(delTea);
        delTea.setBounds(10, 60, 140, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Select Teacher");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(10, 30, 90, 20);

        delete.setText("Delete Subject");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel3.add(delete);
        delete.setBounds(20, 220, 130, 23);

        jSplitPane1.setRightComponent(jPanel3);

        jPanel1.add(jSplitPane1, java.awt.BorderLayout.CENTER);

        jPanel4.setPreferredSize(new java.awt.Dimension(400, 50));

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-400)/2, (screenSize.height-401)/2, 400, 401);
    }// </editor-fold>//GEN-END:initComponents

   

    
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        dbConnect db = new dbConnect();
        con = db.Connect();
        if(con != null){
        int index = addTea.getSelectedIndex();
        String name = (String)addTea.getSelectedItem();
        String id = id1[index];
        String qua = qua1[index];
        String cl1 = null;// ((String)c1.getSelectedItem()).trim();
        String cl2 = null; //((String)c2.getSelectedItem()).trim();
        System.out.println( id);
        System.out.println( name);
        System.out.println( qua);
        //        System.out.println( cl1);
        //        System.out.println( cl1);

        if((c1.getSelectedIndex() == 0 && c2.getSelectedIndex() == 0)) {
            JOptionPane.showMessageDialog(this, "Please Select the Class");
        } else if(c1.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Please Select the Serially");
        } else if(c1.getSelectedIndex() > 0 && c2.getSelectedIndex() > 0) {
            int result = 0;
            try{
//                Class.forName(driver);
//                con = DriverManager.getConnection(conUrl,"root","");
                query = "SELECT count(*) FROM teacher_sub WHERE teacherId = ?";
                pst = con.prepareStatement(query);
                pst.setString(1, id);
                rs = pst.executeQuery();
                if(rs.next() == true){
                    result = rs.getInt("count(*)");
                }
                //System.out.println(result);
                cl1 = ((String)c1.getSelectedItem()).toUpperCase();
                cl2 = ((String)c2.getSelectedItem()).toUpperCase();
                if(result == 1 ){
                   // if(c1.getSelectedIndex() != 0 && c2.getSelectedIndex() != 0) {
                        JOptionPane.showMessageDialog(this, "Can not take more than two subject. Already taken 1!!!","Warnings!!",JOptionPane.PLAIN_MESSAGE);
//                    } else {
//
//                        new Teacher_Sub(cl1.trim(),cl2.trim(),name.trim(),qua.trim(),id.trim()).setVisible(true);
//                    }
                } else if(result == 0){
                    this.dispose();
                    new Teacher_Sub(cl1.trim(),cl2.trim(),name.trim(),qua.trim(),id.trim()).setVisible(true);
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error in SubtTea "+e.getMessage());
            } finally{
                db.Close(con);
            }
        } else if(c1.getSelectedIndex() > 0) {
            System.out.println("yaha");
            System.out.println(((String)c1.getSelectedItem()).toUpperCase());
            this.dispose();
            new Teacher_Sub(((String)c1.getSelectedItem()).toUpperCase().trim(),"",name.trim(),qua.trim(),id.trim()).setVisible(true);
        }
        }
 else{
    JOptionPane.showMessageDialog(this, "Error in Connection");
 }

    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int index = delTea.getSelectedIndex();
        String teacher = ((String)delTea.getSelectedItem()).toUpperCase();
        String teacherId = id2[index];
        System.out.println(id2[index]);
        getData(teacher, teacherId);
        this.dispose();
        new SubDel(teacher,teacherId,csdel,count-1).setVisible(true);
    }//GEN-LAST:event_deleteActionPerformed

     private void getData(String teacher, String teacherId){

         dbConnect db = new dbConnect();
         con = db.Connect();
         if(con != null){
        try{
//        Class.forName(driver);
//        con = DriverManager.getConnection(conUrl,"root","");
        query = "SELECT class, subject FROM teacher_sub WHERE "
                + "teacherId = ?";
        pst = con.prepareStatement(query);
        //pst.setString(1,teacher);
        pst.setString(1, teacherId);

        rs = pst.executeQuery();
        while(rs.next()){
            csdel[count] = rs.getString("class");
            count++;
            csdel[count] = rs.getString("subject");
            count++;
        }
        System.out.println(count);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error in database query part "+e.getMessage(),"Warnnings !!!!!!",JOptionPane.PLAIN_MESSAGE);
        }
        finally{
        db.Close(con);
        }
         }
 else{
    JOptionPane.showMessageDialog(this, "Error in Connection");
 }
    }


    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_cancelActionPerformed

     private void conToDataBase(){
         dbConnect db = new dbConnect();
         con = db.Connect();
         if(con != null){
    try{
//    Class.forName(driver);
//    con = DriverManager.getConnection(conUrl,"root","");
    Statement st = con.createStatement();
    ResultSet rs1 = st.executeQuery("SELECT teacherId,name,qfc FROM teacher_info WHERE teacherId NOT IN "
            + "(SELECT distinct(teacherId) FROM teacher_sub"
            + ") ");

    //if(rs1.next()==true){
        while(rs1.next()){
        name1[f] = rs1.getString("name");
        id1[f] = rs1.getString("teacherId");
        qua1[f] = rs1.getString("qfc");
        //System.out.println(name[0]);
        //System.out.println(f);
        f++;
      //  }
        }
   // System.out.println("outside" +f);
     //System.out.println(name1[0]);

    rs1 = st.executeQuery("SELECT count(*),teacher_sub.teacherId, teacher_info.name, teacher_info.qfc FROM teacher_sub,teacher_info WHERE "+
            "teacher_sub.teacherId = teacher_info.teacherId group by teacherId");
    while(rs1.next()){
    if(rs1.getInt("count(*)") == 2){
//        idm1[c] = rs1.getString("teacherId");
//        System.out.println(rs1.getInt("count(*)"));
//        c++;
         name2[s] = rs1.getString("teacher_info.name");
         id2[s] = rs1.getString("teacher_sub.teacherId");
         s++;
    }
 else
    {
//        idm2[m] = rs1.getString("teacherId");
//        System.out.println(rs1.getInt("count(*)"));
//        m++;
            name1[f] = rs1.getString("teacher_info.name");
            qua1[f] = rs1.getString("teacher_info.qfc");
            id1[f] = rs1.getString("teacher_sub.teacherId");
            f++;

            name2[s] = rs1.getString("teacher_info.name");
            id2[s] = rs1.getString("teacher_sub.teacherId");
//            toc[s] = rs1.getString("toc");
//            sub[s] = rs1.getString("subject");
//            salary[s] = rs1.getFloat("salary");
            s++;
 }


    }
   // System.out.println("c "+ c+" and m "+m+" and f "+f+" and s "+s);

 //   rs1 = st.executeQuery("SELECT teacherId,teacher,qfc,toc,subject,salary FROM teacher_sub");
//    while(rs1.next()){
//        int flag = 0;
//        for(i=0; i<c; i++){
//        if(rs1.getString("teacherId").equalsIgnoreCase(idm1[i])){
//            flag = 1;
//
//            name2[s] = rs1.getString("teacher");
//            id2[s] = rs1.getString("teacherId");
////            toc[s] = rs1.getString("toc");
////            sub[s] = rs1.getString("subject");
////            salary[s] = rs1.getFloat("salary");
//            s++;
//            break;
//        }
//        }
//        System.out.println(flag);
//        if(flag == 0){
//            name1[f] = rs1.getString("teacher");
//            qua1[f] = rs1.getString("qfc");
//            id1[f] = rs1.getString("teacherId");
//            f++;
//
//            name2[s] = rs1.getString("teacher");
//            id2[s] = rs1.getString("teacherId");
////            toc[s] = rs1.getString("toc");
////            sub[s] = rs1.getString("subject");
////            salary[s] = rs1.getFloat("salary");
//            s++;
//        }
////        else{
////            name2[s] = rs1.getString("teacher");
////            id2[s] = rs1.getString("teacherId");
////            toc[s] = rs1.getString("toc");
////            sub[s] = rs1.getString("subject");
////            salary[s] = rs1.getFloat("salary");
////            s++;
////        }
//
//
//    }
   // }
// else {    JOptionPane.showMessageDialog(this, "Data not found");  }

    //System.out.println(name.length);
    if(f>0){
    for(i=0; i<f;i++){
        addTea.addItem(name1[i]);
        System.out.println(name1[i]);
    }
        }
 else
    {
        addTea.setEnabled(false);
        c1.setEnabled(false);
        c2.setEnabled(false);
        add.setEnabled(false);
 }

    if(s>0){
    for(i=0; i<s;i++){
        delTea.addItem(name2[i]);
    }
    }
 else {
    delTea.setEnabled(false);
    delete.setEnabled(false);
 }
        }
    catch(Exception e){
        JOptionPane.showMessageDialog(this,"error  "+ e.getMessage());
    }
    finally{
        db.Close(con);
    }
         }
 else{
            JOptionPane.showMessageDialog(this,"Error in Connection");
 }

    }
    /**
    * @param args the command line arguments
    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new NewTeaSub().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JComboBox addTea;
    private javax.swing.JComboBox c1;
    private javax.swing.JComboBox c2;
    private javax.swing.JButton cancel;
    private javax.swing.JComboBox delTea;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables

}
