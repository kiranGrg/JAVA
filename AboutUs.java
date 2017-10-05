



import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AboutUs extends JDialog{
    private JPanel myPanel = null;
    private JLabel info = null, title = null, lblpic = null;
    private String str = "This software is meant for the management of the school\n "
                        + "regarding to make the day to day work ease for its management.\n "
                        + "With the help of this software school can get be benefits like \n"
                        + "save, retrieve and update, the records of both students and staffs\n"
                        + " in simple and well managed form. This software helps to cover all \n"
                        + "the day to day work within the school.";
    
    public AboutUs(JFrame frame, boolean status, String msg){
        super(frame, status);
        setLayout(null);
        myPanel = new JPanel();
        myPanel.setLayout(null);
        getContentPane().add(myPanel);
        myPanel.setBounds(0, 0, 400, 170);
        title = new JLabel();
        title.setText(msg);
        title.setForeground(Color.BLUE);
        //title.setBorder(BorderFactory.createL)
        myPanel.add(title);
        title.setFont(new Font("Times New Roman", 1, 20));
        title.setBounds(140, 10, 150, 30);

        info = new JLabel();
        info.setText(str);
        info.setFont(new Font("Times New Roman", 1, 15));
        info.setForeground(Color.BLACK);
        info.setFont(new Font("Times New Roman",Font.BOLD,12));
        myPanel.add(info);
        info.setBounds(10, 50, 380, 20);
        info.setHorizontalAlignment(SwingConstants.CENTER);


        
        setSize(400,170);
        setLocationRelativeTo(frame);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}








//
//    public void actionPerformed(ActionEvent e) {
//        try{
//        String name = JOptionPane.showInputDialog(this, "Do you Wanna Play? Please Register Your Name:", "Start a Game", JOptionPane.QUESTION_MESSAGE);
//        if(!name.equalsIgnoreCase("")) {
//           // playerName = name;
//        }
//        else{
//            JOptionPane.showMessageDialog(this, "PlayerLater On");
//        }
//        }
//        catch(Exception ex){
//            JOptionPane.showMessageDialog(this, "PlayerLater On");
//        }
//    }