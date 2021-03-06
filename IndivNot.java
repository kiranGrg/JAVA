

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IndivNot.java
 *
 * Created on Mar 16, 2012, 6:22:12 PM
 */

/**
 *
 * @author kiranroma
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory.*;
import java.sql.*;
import java.util.Calendar;
import java.util.Vector;


public class IndivNot extends javax.swing.JFrame {

    /** Creates new form IndivNot */
    private DefaultTableModel modal = new DefaultTableModel();
    private JTable table;
    private JScrollPane scrollPane;

    private Connection con = null;
    private ResultSet rs = null;
    private String query = null;
    private Statement stm = null;
    private PreparedStatement pst = null;

    public IndivNot() {
        initComponents();
        table = new JTable(modal);
        int v = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        scrollPane = new JScrollPane(table,v,h);
        getContentPane().add(scrollPane);
        scrollPane.setBounds(5, 55, 500, 260);
            modal.addColumn("S.No.");
            modal.addColumn("Grade");
            modal.addColumn("Roll");
            modal.addColumn("Amount");
            displaydata();
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
        btncancel = new javax.swing.JButton();
        btnpay = new javax.swing.JButton();
        lblid = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblname1 = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        lblcontact = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtamount = new javax.swing.JTextField();
        txtgiven = new javax.swing.JTextField();
        txtreturn = new javax.swing.JTextField();
        txtdate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Indiv");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 710, 50);

        btncancel.setText("Cancel");
        getContentPane().add(btncancel);
        btncancel.setBounds(210, 330, 100, 30);

        btnpay.setText("Pay");
        getContentPane().add(btnpay);
        btnpay.setBounds(520, 330, 100, 30);

        lblid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(lblid);
        lblid.setBounds(580, 90, 130, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("ID:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(520, 90, 50, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Name:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(520, 50, 50, 20);

        lblname1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(lblname1);
        lblname1.setBounds(580, 50, 130, 20);

        lblname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(lblname);
        lblname.setBounds(70, 60, 110, 20);

        lblcontact.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(lblcontact);
        lblcontact.setBounds(580, 130, 130, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Return:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(520, 290, 50, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Contact:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(520, 130, 50, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Date:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(520, 170, 50, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Amount:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(520, 210, 50, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Given:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(520, 250, 50, 20);

        txtamount.setEnabled(false);
        getContentPane().add(txtamount);
        txtamount.setBounds(580, 210, 100, 25);
        getContentPane().add(txtgiven);
        txtgiven.setBounds(580, 250, 100, 25);
        getContentPane().add(txtreturn);
        txtreturn.setBounds(580, 290, 100, 25);

        txtdate.setEnabled(false);
        getContentPane().add(txtdate);
        txtdate.setBounds(580, 170, 100, 25);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-728)/2, (screenSize.height-403)/2, 728, 403);
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IndivNot().setVisible(true);
            }
        });
    }

    protected void displaydata(){
        String[] dates = null;
        String enroll = "";
        dbConnect db = new dbConnect();
        con = db.Connect();
        if(con != null){
            try{
                query = "SELECT dpay FROM fee WHERE studentId = 'XYZ0001'";
                stm = con.createStatement();
                rs = stm.executeQuery(query);
                if(rs.next()){
                    rs.last();
                    int row = rs.getRow(), i = 0;
                    rs.beforeFirst();
                    dates = new String[row];
                    while(rs.next()){
                        
                        dates[i] = returndates(rs.getDate(1).toString());
                        System.out.println(dates[i]);
                        i++;
                    }
                    query = "SELECT enrolled FROM student_info WHERE studentId = 'XYZ0001'";
                    stm = con.createStatement();
                    rs = stm.executeQuery(query);
                    if(rs.next()){

                        enroll = returndates(rs.getObject(1).toString());
                        System.out.println(enroll);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "No Payment has been Done yet");
                }

            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error: "+e.getMessage());
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Error in Connection");
        }

        calculateUnPaid(dates,enroll);
        
    }

    protected String returndates(String dateString){

        String[] date = dateString.split("-");
        //String dates = "";
        return date[0]+"-"+date[1];
    }

    protected void calculateUnPaid(String[] dates, String enroll){
        Vector newdates = new Vector();
        String[] enrollyear = enroll.split("-");
        int eyear = Integer.parseInt(enrollyear[0]), emonth = Integer.parseInt(enrollyear[1]);
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR), month = cal.get(Calendar.MONTH)+1;
        if(year != eyear){
            for(int i = emonth; i>0; i--){
                if(i > 9){
                    newdates.addElement(new String(enrollyear[0]+"-"+String.valueOf(i)));
                }
                else{
                    newdates.addElement(new String(enrollyear[0]+"-"+String.valueOf("0"+i)));
                }
            }
            eyear = eyear - 1;
            while(year != eyear){
                for(int i = emonth; i>0; i--){
                    if(i > 9){
                        newdates.addElement(new String(enrollyear[0]+"-"+String.valueOf(i)));
                    }
                    else{
                        newdates.addElement(new String(enrollyear[0]+"-"+String.valueOf("0"+i)));
                    }
                }
                eyear = eyear - 1;
            }
        }
        String[] testdates = null;
        newdates.copyInto(testdates);
        for(String a: testdates){
            System.out.println(a);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnpay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblcontact;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblname1;
    private javax.swing.JTextField txtamount;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtgiven;
    private javax.swing.JTextField txtreturn;
    // End of variables declaration//GEN-END:variables

}
