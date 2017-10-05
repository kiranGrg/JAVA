

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kiranroma
 */
import javax.swing.*;
import java.sql.*;

public class CurrentPay {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/system";
    private Connection con = null;
    private PreparedStatement pst = null;
    private String query = null;

    CurrentPay(JFrame j,String tname, String tid, Float salary){
        dbConnect db = new dbConnect();
        con = db.Connect();
        if(con != null){
        try{
//            Class.forName(driver);
//            con = DriverManager.getConnection(url,"root","");
            query = "INSERT INTO tsalary (id,teacherId,name,year,month,salary) "
                    + "VALUES (null,?,?,"
                    + "year(now()),month(now()),"
                    + "?";
            pst = con.prepareStatement(query);
            int result = pst.executeUpdate();
            if(result > 0 ){
                JOptionPane.showMessageDialog(j,"Data Inserted Successfully!!","Notice",JOptionPane.PLAIN_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(j,"Data Insertion Failed!!","Notice",JOptionPane.PLAIN_MESSAGE);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(j,"Error: "+e.getMessage(),"Notice",JOptionPane.PLAIN_MESSAGE);
        }
        finally{
            try{
                if(con != null){
                    con.close();
                }
            }
            catch(Exception e){}
        }
    }
    
    else{
        JOptionPane.showMessageDialog(null,"Error in Connection");
    }

}
}
