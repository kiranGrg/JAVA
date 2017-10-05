

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CreateExcelFileOfTable.java
 *
 * Created on Sep 9, 2011, 1:49:53 PM
 */

/**
 *
 * @author kiranroma
 *
 */
import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.sql.*;
public class CreateExcelFileOfTable extends javax.swing.JFrame {
private Connection con = null;
private   Statement stm = null;
private ResultSet rs = null;
private ResultSetMetaData rsmd = null;
private DatabaseMetaData dmda = null;
private int cols, rows;
private String query = null, path = "";
private String[] types = {"TABLE"};

    /** Creates new form CreateExcelFileOfTable */
    public CreateExcelFileOfTable() {
        initComponents();
        getDatabaseTables();
    }

    protected void getDatabaseTables(){
        dbConnect db = new dbConnect();
        con = db.Connect();
        if(con != null){
            try{
                dmda = con.getMetaData();
                rs = dmda.getTables(null, null, "%", types);
                while(rs.next()){
                    cmbtable.addItem(rs.getString("TABLE_NAME"));
                }
            }
            catch(Exception e){}
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btncreate = new javax.swing.JButton();
        txtbrowse = new javax.swing.JTextField();
        btnbrowse = new javax.swing.JButton();
        lblheader = new javax.swing.JLabel();
        txtfile = new javax.swing.JTextField();
        btncancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbtable = new javax.swing.JComboBox();

        jLabel3.setText("jLabel3");

        getContentPane().setLayout(null);

        jLabel4.setText("File Name:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 60, 70, 30);

        btncreate.setText("Create");
        btncreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreateActionPerformed(evt);
            }
        });
        getContentPane().add(btncreate);
        btncreate.setBounds(170, 150, 100, 30);

        txtbrowse.setText("Select a Diretory to Save a File");
        getContentPane().add(txtbrowse);
        txtbrowse.setBounds(10, 100, 470, 30);

        btnbrowse.setText("Browse");
        btnbrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbrowseActionPerformed(evt);
            }
        });
        getContentPane().add(btnbrowse);
        btnbrowse.setBounds(485, 100, 80, 30);

        lblheader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblheader.setText("Create Excel File Of a Table From Database");
        getContentPane().add(lblheader);
        lblheader.setBounds(0, 0, 580, 50);
        getContentPane().add(txtfile);
        txtfile.setBounds(110, 60, 120, 30);

        btncancel.setText("Cancel");
        getContentPane().add(btncancel);
        btncancel.setBounds(313, 150, 90, 30);

        jLabel1.setText("Table:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 60, 50, 30);

        cmbtable.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        getContentPane().add(cmbtable);
        cmbtable.setBounds(340, 60, 140, 30);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-597)/2, (screenSize.height-248)/2, 597, 248);
    }// </editor-fold>//GEN-END:initComponents

    private void btnbrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbrowseActionPerformed
        // TODO add your handling code here:
        JFileChooser jc = new JFileChooser();
        jc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jc.showOpenDialog(this);
        path = jc.getSelectedFile().getAbsolutePath();
        txtbrowse.setText(path);
    }//GEN-LAST:event_btnbrowseActionPerformed

    private void btncreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncreateActionPerformed
        // TODO add your handling code here:
        //new CreateExcelFile(s+"/myfile.xls");
        String[][] values = null;
        int i,j;
        String filePath = path + "/" + txtfile.getText().trim() + ".xls";
        dbConnect db = new dbConnect();
        con = db.Connect();
        if(con != null){
            query = "SELECT * FROM "+(String)cmbtable.getSelectedItem();
            System.out.println(query);
            try{
                stm = con.createStatement();
                rs = stm.executeQuery(query);
                if(rs.next()){
                    rsmd = rs.getMetaData();
                    cols = rsmd.getColumnCount();
                    rs.last();
                    rows = rs.getRow();
                    rs.beforeFirst();
                    //System.out.println(rows + " "+ cols);
                    values = new String[rows + 1][cols];
                    int k = 0;
                    for(i = 0; i<cols; i++){
                        values[k][i] = rsmd.getColumnName(i+1);
                        //System.out.println(values[k][i]);
                    }
                    k++;
                    while(rs.next()){
                            for(j = 0; j<cols; j++){
                                values[k][j] = String.valueOf(rs.getObject(j+1));
                                //System.out.println(values[k][j]);
                            }
                            k++;
                    }
                    new CreateExcelFile(values,filePath,cols,rows);
                }
                else{
                    JOptionPane.showMessageDialog(this, "No data found");
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error : 11111"+e.getMessage());
            }
            finally{
                db.Close(con);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Error in Connection");
        }
        //System.out.println(filePath);
        
    }//GEN-LAST:event_btncreateActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateExcelFileOfTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbrowse;
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btncreate;
    private javax.swing.JComboBox cmbtable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblheader;
    private javax.swing.JTextField txtbrowse;
    private javax.swing.JTextField txtfile;
    // End of variables declaration//GEN-END:variables

}
