

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kiranroma
 */
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class GetTables extends JFrame{
    private JComboBox tableslist;

    private String[] tables;

    private JTable table;

    private DefaultTableModel modal;

    private JScrollPane scrollpane;
    
    public GetTables(){
        super("Table Listed");
        setLayout(null);
        tableslist = new JComboBox(new DefaultComboBoxModel(new String[] {"Select"}));
        tableslist.setBounds(10, 10, 200, 40);
        modal = new DefaultTableModel();
        table = new JTable(modal);
        scrollpane = new JScrollPane(table);
        getContentPane().add(scrollpane);
        
        scrollpane.setBounds(10, 60, 550, 300);


        tableslist.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                getTableData(ie);
            }
        });
        getContentPane().add(tableslist);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((d.width-452)/2, (d.height-302)/2, 600, 400);
        //setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getTableList();
        //setLocation((d.getWidth()-300)/2, (d.getHeight()-300)/2);
    }

    private void getTableData(ItemEvent ie){
        if(ie.getStateChange() == ItemEvent.SELECTED){
            String tableName = (String)ie.getItem();
            //System.out.println(tableName);
            if(!tableName.equalsIgnoreCase("Select")){
                if(modal.getRowCount() != 0){
                    //modal.setValueAt(null, 0, 0);
                    //modal.setColumnCount(0);
                    System.out.println(modal.getRowCount());
                    for(int i = modal.getRowCount(); i > 0; i--){
                        //modal.removeRow(i);
                    }
                }

                getTableListedData(tableName);
            }
            else{
                JOptionPane.showMessageDialog(this, "Please Select the Table");
            }
        }
    }

    private void getTableListedData(String tableName){
        dbConnect db = new dbConnect();
        Connection con = db.Connect();
        if(con != null){
            try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From exam");

            if(rs.next()){

                Object data[];
                ResultSetMetaData rsm = rs.getMetaData();
                int col = rsm.getColumnCount();
                rs.last();
                int row = rs.getRow();
                rs.beforeFirst();
                for(int i = 0; i < col; i++){
                   // System.out.println(rsm.getColumnName(i+1));
                    modal.addColumn(rsm.getColumnName(i+1));
                }

                data = new Object[col];
                while(rs.next()){
                    for(int i=0; i<col; i++){
                        data[i] = rs.getObject(i+1);
                    }
                    modal.addRow(data);
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Error Message "+" No Data Has Been Added to this Table");
            }


            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error Message "+e.getMessage());
            }
        }
        

    }

    public void getTableList(){

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/System","root","");
            DatabaseMetaData md = con.getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);
            while (rs.next()) {
              tableslist.addItem(rs.getString(3));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error Message "+e.getMessage());
        }
    }
//
//    public static void main(String args[]){
//        new GetTables().setVisible(true);
//    }
}
