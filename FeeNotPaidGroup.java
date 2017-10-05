


import java.sql.*;
import java.util.Calendar;
import java.util.Locale;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FeeNotPaidGroup.java
 *
 * Created on Mar 15, 2012, 9:47:08 PM
 */

/**
 *
 * @author kiranroma
 */
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
public class FeeNotPaidGroup extends javax.swing.JFrame implements MouseListener{

    /** Creates new form FeeNotPaidGroup */
    private JTable table;
    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private DefaultTableModel modal;
    private String money = "", div = "", id = "", years = "", mon = "",name = "";
    private java.sql.Date date;
    private String[] months = new String[] {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    private String[] values;
    private int cmbindex;
    private int statusbit, index;
    //for repayment
    private String pdate,amount;
    private int feeid;
    private String title = "";

    public FeeNotPaidGroup(String title, int status, int index) {
        statusbit = status;
        this.index = index;
        //this.title = title;
        initComponents();
        lblheader.setText(title);

        modal = new DefaultTableModel();
        table = new JTable(modal);


        cmbsel.setSelectedIndex(index);
            modal.addColumn("S.No.");
            modal.addColumn("Name");
            modal.addColumn("Id");

        if(statusbit == 1){
            lblresult.setText("List Of Unpaid Fee Students Of Current Month");
            lblheader.setText("UNPAID FEE RECORDS");
            modal.addColumn("Grade");
            modal.addColumn("Roll");
        }
        else if(statusbit == 2){
            lblresult.setText("List Of Unpaid Salary Teachers Of Current Month");
            lblheader.setText("UNPAID TEACHER'S SALARY");
            modal.addColumn("Qua");
            modal.addColumn("Contact");
        }
        else{
            lblresult.setText("List Of Unpaid Salary Staff Of Current Month");
            lblheader.setText("UNPAID STAFF'S SALARY");
            modal.addColumn("Post");
            modal.addColumn("Contact");
        }
            modal.addColumn("Amount");
            modal.addColumn("Enrolled");

//        if(statusbit == 1){
//            modal.addColumn("Status");
//        }
        
        
        JScrollPane sp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        getContentPane().add(sp);
        sp.setBounds(10, 100, 745, 270);
        table.addMouseListener(this);

        display(0);

    }
    


        public void mouseClicked(MouseEvent e){
         
            int r = table.getSelectedRow();
            name = table.getModel().getValueAt(r, 1).toString();
            id = table.getModel().getValueAt(r, 2).toString();
            div = table.getModel().getValueAt(r, 3).toString();
            money = table.getModel().getValueAt(r, 5).toString();
    //        if(statusbit >1){
                values = new String[]{name,id,date.toString(),div,money};//,""};
    //        }
    //        else{
    //            values = new String[]{name,id,date.toString(),div,money,table.getModel().getValueAt(r, 7).toString()};
    //        }

    //        for(String d:values){
    //            System.out.println(d);
    //        }
            
            int status = 0;
            if(statusbit == 1){
                status =  partialCheck(values);
            }
            if(status == 1){
                this.dispose();
                new PartialPay(values,pdate,amount,cmbindex,statusbit,feeid,title).setVisible(true);
            }
            else if(status == 0){
                this.dispose();
                new Payment(statusbit,values,cmbindex,title).setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(this, "Error From partialCheck()");
            }
        }

        public void mouseExited(MouseEvent e){}
        public void mouseEntered(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mousePressed(MouseEvent e){}

        protected int partialCheck(String[] values){
            dbConnect db = new dbConnect();
            con = db.Connect();
            if(con != null){
                try{
                    String query = "SELECT id,ldate,pamount FROM fee WHERE studentId = '"+values[1]+"' AND grade = '"+values[3]+"' AND fstatus = 'p'";
                    stm = con.createStatement();
                    rs = stm.executeQuery(query);
                    if(rs.next()){
                        feeid = rs.getInt(1);
                        pdate = rs.getObject(2).toString();
                        amount = rs.getObject(3).toString();
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                catch(Exception e){
                     //JOptionPane.showMessageDialog(this, "Error in Sql: "+e.getMessage());
                     return 2;
                }
            }
            else{ return 2;}

            //return 0;
        }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbsel = new javax.swing.JComboBox();
        lblheader = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblresult = new javax.swing.JLabel();
        btncancel = new javax.swing.JButton();
        btnsearch = new javax.swing.JButton();

        getContentPane().setLayout(null);

        cmbsel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Current", "1", "2", "3", "4", "5" }));
        cmbsel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbselActionPerformed(evt);
            }
        });
        getContentPane().add(cmbsel);
        cmbsel.setBounds(230, 65, 80, 34);

        lblheader.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblheader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblheader);
        lblheader.setBounds(0, 0, 763, 50);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Specify Months:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 70, 90, 25);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("month/s before.");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(320, 70, 90, 25);

        lblresult.setForeground(new java.awt.Color(255, 51, 51));
        lblresult.setText("List Of Unpaid Fee Students Of Month ");
        getContentPane().add(lblresult);
        lblresult.setBounds(410, 70, 275, 25);

        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        getContentPane().add(btncancel);
        btncancel.setBounds(650, 370, 100, 35);

        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnsearch);
        btnsearch.setBounds(320, 370, 100, 35);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-780)/2, (screenSize.height-451)/2, 780, 451);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbselActionPerformed
        // TODO add your handling code here:
        
        //btnpay.setEnabled(false);
        //System.out.println(modal.getRowCount());
        cmbindex = cmbsel.getSelectedIndex();
        //int month = 0;
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

        Calendar cd = Calendar.getInstance();
        int y = cd.get(Calendar.YEAR), m = cd.get(Calendar.MONTH)+1, d = cd.get(Calendar.DAY_OF_MONTH);
        //System.out.println(format.format(cd.getTime()));
        System.out.println(y+"-"+m+"-"+d);
        if(cmbindex > 0){
            if(m - cmbindex < 1){
                m = (m-cmbindex) * -1;
                m = 12 - m;
                y = y - 1;
            }
            else{
                m = m-cmbindex;
            }
        }
          //  System.out.println(y+" "+m+" "+d);

            if(m <10 || d<10){
                if(m < 10 && d <10){
                    System.out.println(String.valueOf(y)+"-0"+String.valueOf(m)+"-0"+String.valueOf(d));
                }
                else if(m < 10)
                {
                    //System.out.println(String.valueOf(y)+"-0"+String.valueOf(m)+"-"+String.valueOf(d));
                    //Calender cd1 = new Calender(java.sql.Date.valueOf(String.valueOf(y)+"-0"+String.valueOf(m)+"-"+String.valueOf(d)));
                    date = java.sql.Date.valueOf(String.valueOf(y)+"-0"+String.valueOf(m)+"-"+String.valueOf(d));
                }
                else if(d < 10){
                    //System.out.println(String.valueOf(y)+"-0"+String.valueOf(m)+"-"+String.valueOf(d));
                    date = java.sql.Date.valueOf(String.valueOf(y)+"-"+String.valueOf(m)+"-0"+String.valueOf(d));
                }
            }
            else{
                //System.out.println(String.valueOf(y)+"-0"+String.valueOf(m)+"-"+String.valueOf(d));
                date = java.sql.Date.valueOf(String.valueOf(y)+"-"+String.valueOf(m)+"-"+String.valueOf(d));
            }

        
        //System.out.println(date);
        //System.out.println(modal.getRowCount());
    }//GEN-LAST:event_cmbselActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
            if(modal.getRowCount() > -1){
                    for(int j = modal.getRowCount()-1; j>= 0; j--){
                    modal.removeRow(j);
                }
            }

            if(statusbit == 1){
                if(cmbindex == 0){
                    lblresult.setText("List Of Unpaid Fee Students Of Current Month");
                }
                else if(cmbindex > 0){
                    lblresult.setText("List Of Unpaid Fee Students Of "+String.valueOf(date.getYear()+1900)+" - "+months[date.getMonth()]);
                }
            }
            else if(statusbit == 2){
                if(cmbindex == 0){
                    lblresult.setText("List Of Unpaid Salary Teachers Of Current Month");
                }
                else if(cmbindex > 0){
                    lblresult.setText("List Of Unpaid Salary Teachers Of "+String.valueOf(date.getYear()+1900)+" - "+months[date.getMonth()]);
                }
            }
            else{
                if(cmbindex == 0){
                    lblresult.setText("List Of Unpaid Salary Staffs Of Current Month");
                }
                else if(cmbindex > 0){
                    lblresult.setText("List Of Unpaid Salary Staffs Of "+String.valueOf(date.getYear()+1900)+" - "+months[date.getMonth()]);
                }
            }

            display(1);
        
    }//GEN-LAST:event_btnsearchActionPerformed

    protected void display(int i){
      String query = "";
        dbConnect db = new dbConnect();
        con = db.Connect();
        if(con != null){
            if(statusbit == 1){
                query = "SELECT name,studentId,grade,roll,fee,enrolled FROM student_info WHERE studentId NOT IN (SELECT studentId FROM fee WHERE "+
                        "date_format(dpay,'%y%m') = date_format('"+date+"','%y%m') AND fstatus != 'p')";// AND date_format(enrolled,'%y%m') <= date_format('"+date+"','%y%m')";
            }
            else if(statusbit == 2){
                query = "SELECT name,teacherId,qfc,contact,salary,empd FROM teacher_info WHERE teacherId NOT IN "+
                        "(SELECT teacherId FROM teachersalary WHERE date_format(dop,'%y%m') = date_format('"+date+"','%y%m')) "+
                        "AND date_format(empd,'%y%m') <= date_format('"+date+"','%y%m')";
            }
            else{
                query = "SELECT name,staffId,post,contact,salary,empd FROM staff_info WHERE staffId NOT IN "+
                        "(SELECT staffId FROM staffsalary WHERE date_format(dop,'%y%m') = date_format('"+date+"','%y%m')) "+
                        "AND date_format(empd,'%y%m') <= date_format('"+date+"','%y%m')";
            }
            try{
//                String query = "SELECT name,studentId,grade,roll,fee FROM student_info WHERE studentId NOT IN (SELECT studentId FROM fee WHERE "+
//                        "date_format(dpay,'%y%m') = date_format('"+date+"','%y%m')) AND date_format(enrolled,'%y%m') <= date_format('"+date+"','%y%m')";

                stm = con.createStatement();
                rs = stm.executeQuery(query);
                if(rs.next()){
                    int c = 1;
                    //System.out.println("list of non paid fee of previous months :");
                    do{

                        modal.addRow(new Object[] {c,rs.getObject(1),rs.getObject(2),rs.getObject(3),rs.getObject(4),rs.getObject(5),rs.getObject(6)});
                        c++;
                    }while(rs.next());
                }
                else{
                    if(i != 0){

                        String result = "";
                        if(statusbit == 1){
                            result = "Every Student has paid fee for the "+date;
                        }
                        else if(statusbit > 1){
                            result = "The Salary has been paid to everybody for the "+date;
                        }
                        JOptionPane.showMessageDialog(this, result+"\nThank You!!");
                    }
                    
                }
            }
            catch(Exception e){
                //JOptionPane.showMessageDialog(this, "Error in Sql: "+e.getMessage());
            }
            finally{
            db.Close(con);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Connection Error:");
        }
    }

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btncancelActionPerformed

    /**
    * @param args the command line arguments
    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FeeNotPaidGroup(1,0).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnsearch;
    private javax.swing.JComboBox cmbsel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblheader;
    private javax.swing.JLabel lblresult;
    // End of variables declaration//GEN-END:variables

}
