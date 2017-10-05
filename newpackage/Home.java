package newpackage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Home.java
 *
 * Created on Jan 21, 2012, 8:33:26 AM
 */
/**
 *
 * @author kiranroma
 */
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.text.*;
import java.util.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

public class Home extends javax.swing.JFrame implements ActionListener {

//    private PreparedStatement pst = null;
//    private ResultSet rs = null;
//    private Connection con = null;
//    private Statement stm = null;
//    private String Driver = "com.mysql.jdbc.Driver";
//    private String Url = "jdbc:mysql://localhost:3306/System";
    private String query = null;
    private String grade = null;
    Timer t = new Timer(1000, this);
    Timer it = new Timer(4000, this);
    int i = 1;
    private String str = "This software is meant for the management of the school\n "
                        + "regarding to make the day to day work ease for its management.\n "
                        + "With the help of this software school can get be benefits like \n"
                        + "save, retrieve and update, the records of both students and staffs\n"
                        + " in simple and well managed form. This software helps to cover all \n"
                        + "the day to day work within the school.";

    /** Creates new form Home */
    public Home() {
        initComponents();
        lblimage.setIcon(new ImageIcon(getClass().getResource("images/image1.jpg")));
        t.start();
        it.start();


        //pnlTree.add(createJTree());
        desktopPane.add(createJTree());
        


        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int b = (int) d.getWidth();
        int h = (int) d.getHeight();

        setJMenuBar(createMenuBar());
        setExtendedState(this.MAXIMIZED_BOTH);
        

        setSize(d);
    }

    public void actionPerformed(ActionEvent e) {
        //int i = 1;
        if (e.getSource() == t) {

            //System.
            Calendar today = Calendar.getInstance();
            SimpleDateFormat formatter =
                    new SimpleDateFormat("yyyy.MM.dd G 'at' hh:mm:ss z", Locale.getDefault());
            datetime.setText(formatter.format(today.getTime()));

        }
        else if(e.getSource() == it){
            i++;
            if(i == 5){
                i = 1;
            }
            lblimage.setIcon(new ImageIcon(getClass().getResource("images/image"+i+".jpg")));
        }
    }

    protected JMenuBar createMenuBar() {
        mb = new JMenuBar();
        JMenu file = new JMenu("File");
        file.setMnemonic('F');
        mb.add(file);

        JMenuItem aboutUs = new JMenuItem("About This");
        aboutUs.setIcon(new ImageIcon(getClass().getResource("/images/abos.png")));
        aboutUs.setMnemonic('O');
        aboutUs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        aboutUs.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, str);
//                new AboutUs(null, true, "About Me").setVisible(rootPaneCheckingEnabled);
            }
        });
        file.add(aboutUs);



        JMenu people = new JMenu("People");
        people.setMnemonic('P');
        mb.add(people);

        JMenu stu = new JMenu("Student");
        stu.setMnemonic('U');
        people.add(stu);

        JMenuItem stu1 = new JMenuItem("Add Student");
        stu1.setIcon(new ImageIcon(getClass().getResource("/images/stuas.png")));
        stu1.setMnemonic('N');
        stu1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        stu1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new NewStudentF().setVisible(true);
            }
        });
        stu.add(stu1);

        JMenuItem stu2 = new JMenuItem("Student Info");
        stu2.setIcon(new ImageIcon(getClass().getResource("/images/stis.png")));
        stu2.setMnemonic('D');
        stu2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        stu2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                grade = JOptionPane.showInputDialog(null, "Enter the Grade", "Student Information", JOptionPane.QUESTION_MESSAGE);
                //new TabulateData("STUDENT",grade.trim().toUpperCase(),1).setVisible(true);
                createTableForm(8);
            }
        });
        stu.add(stu2);

        JMenu tea = new JMenu("Teacher");
        //tea.setIcon(new ImageIcon(getClass().getResource("/images/teacs.png")));
        tea.setMnemonic('T');
        people.add(tea);

        JMenuItem tea1 = new JMenuItem("Add Teacher");
        tea1.setIcon(new ImageIcon(getClass().getResource("/images/teas.png")));
        tea1.setMnemonic('C');
        tea1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        tea1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new NewTeacherF().setVisible(true);
            }
        });
        tea.add(tea1);

        JMenuItem tea2 = new JMenuItem("Teacher Info");
        tea2.setIcon(new ImageIcon(getClass().getResource("/images/teais.png")));
        tea2.setMnemonic('R');
        tea2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        tea2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //new TabulateData("Teacher_menu","info",4).setVisible(true);
                createTableForm(2);
            }
        });
        tea.add(tea2);

        JMenu sta = new JMenu("Staff");
        //sta.setIcon(new ImageIcon(getClass().getResource("/images/stas_1.png")));
        sta.setMnemonic('S');
        people.add(sta);

        JMenuItem sta1 = new JMenuItem("Add Staff");
        sta1.setIcon(new ImageIcon(getClass().getResource("/images/staffs.png")));
        sta1.setMnemonic('A');
        sta1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        sta1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new NewStaffF().setVisible(true);
            }
        });
        sta.add(sta1);

        JMenuItem sta2 = new JMenuItem("Staff Info");
        sta2.setIcon(new ImageIcon(getClass().getResource("/images/staffis.png")));
        sta2.setMnemonic('F');
        sta2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        sta2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // new TabulateData("Staff_menu","info",6).setVisible(true);
                createTableForm(3);
            }
        });
        sta.add(sta2);

        JMenu Inquiry = new JMenu("Group Inquiry");
        Inquiry.setMnemonic('I');
        mb.add(Inquiry);

        JMenuItem Fee = new JMenuItem("Fee Payment");
        Fee.setIcon(new ImageIcon(getClass().getResource("/images/feees.png")));
        Fee.setMnemonic('S');
        Fee.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        Fee.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "need to be created");
                new FeeMenuF().setVisible(true);
            }
        });
        Inquiry.add(Fee);

        JMenuItem exam = new JMenuItem("Exam Report");
        exam.setIcon(new ImageIcon(getClass().getResource("/images/repb.png")));
        exam.setMnemonic('T');
        exam.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        exam.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "need to be created");
                new ResultFRep().setVisible(true);
            }
        });
        Inquiry.add(exam);

        Inquiry.addSeparator();
        JMenuItem subject = new JMenuItem("Subject Assign.");
        subject.setIcon(new ImageIcon(getClass().getResource("/images/book.png")));
        subject.setMnemonic('J');
        subject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, ActionEvent.CTRL_MASK));
        subject.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new NewTeaSub().setVisible(true);
            }
        });
        Inquiry.add(subject);

        JMenuItem tea_salary = new JMenuItem("Teacher Salary");
        tea_salary.setIcon(new ImageIcon(getClass().getResource("/images/salarys.png")));
        tea_salary.setMnemonic('H');
        tea_salary.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        tea_salary.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String ObjButtons[] = {"All", "Current"};
                int PromptResult = JOptionPane.showOptionDialog(null, "How you want to view the Data", "School Managenemt System", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
                if (PromptResult == 0) {
                    //System.exit(0);
                    createTableForm(5);
                } else if (PromptResult == 1) {
                    createTableForm(6);
                }
            }
        });
        Inquiry.add(tea_salary);

        Inquiry.addSeparator();

        JMenuItem sta_salary = new JMenuItem("Staff Salary");
        sta_salary.setIcon(new ImageIcon(getClass().getResource("/images/salarys.png")));
        sta_salary.setMnemonic('Y');
        sta_salary.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        sta_salary.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String ObjButtons[] = {"All", "Current"};
                int PromptResult = JOptionPane.showOptionDialog(null, "How you want to view the Data", "School Managenemt System", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
                if (PromptResult == 0) {
                    //System.exit(0);
                    createTableForm(4);
                } else if (PromptResult == 1) {
                    createTableForm(7);
                }
            }
        });
        Inquiry.add(sta_salary);


        JMenu expense = new JMenu("Expense");
        expense.setMnemonic('X');
        mb.add(expense);

        JMenuItem add = new JMenuItem("Add Item");
        add.setMnemonic('M');
        add.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        add.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "need to be created soon");
                new EntryExpense().setVisible(true);
            }
        });
        expense.add(add);


        JMenu help = new JMenu("Excel File");
        help.setMnemonic('H');
        mb.add(help);

        JMenuItem hp = new JMenuItem("Create Excel of Database");
        hp.setIcon(new ImageIcon(getClass().getResource("/images/helps.png")));
        hp.setMnemonic('H');
        hp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        hp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new CreateExcelFileOfTable().setVisible(true);
            }
        });
        help.add(hp);

        JMenu exit = new JMenu("Close");
        exit.setMnemonic('L');
        mb.add(exit);

        JMenuItem close = new JMenuItem("Exit");
        close.setIcon(new ImageIcon(getClass().getResource("/images/exit.png")));
        close.setMnemonic('E');
        close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        exit.add(close);
        close.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                UnloadWindow();
            }
        });


        mb.setBackground(Color.cyan);
        return (mb);
    }

    protected JTree createJTree() {
        //JScrollPane js;
        DefaultMutableTreeNode main = new DefaultMutableTreeNode("School Management System");

        DefaultMutableTreeNode student = new DefaultMutableTreeNode("Student Section");
        main.add(student);

        DefaultMutableTreeNode fee = new DefaultMutableTreeNode("Fee Inquiry");
        student.add(fee);

        DefaultMutableTreeNode exam = new DefaultMutableTreeNode("Exam Inquiry");
        student.add(exam);

        DefaultMutableTreeNode teacher = new DefaultMutableTreeNode("Teacher Section");
        main.add(teacher);

        DefaultMutableTreeNode subject = new DefaultMutableTreeNode("Subject Inquiry");
        teacher.add(subject);

        DefaultMutableTreeNode salary = new DefaultMutableTreeNode("Salary Payment");
        main.add(salary);

        DefaultMutableTreeNode salaryP = new DefaultMutableTreeNode("Salary Payment Record");
        salary.add(salaryP);


        DefaultMutableTreeNode expense = new DefaultMutableTreeNode("Exepnse Section");
        main.add(expense);

        DefaultMutableTreeNode view = new DefaultMutableTreeNode("Entry/View Expense");
        expense.add(view);

        DefaultMutableTreeNode system = new DefaultMutableTreeNode("System Section");
        main.add(system);

        DefaultMutableTreeNode backUP = new DefaultMutableTreeNode("BackUP Database");
        system.add(backUP);

        DefaultMutableTreeNode reStore = new DefaultMutableTreeNode("Restore Database");
        system.add(reStore);

        DefaultMutableTreeNode load = new DefaultMutableTreeNode("Load Excel File");
        main.add(load);

        DefaultMutableTreeNode examFile = new DefaultMutableTreeNode("Exam Report");
        load.add(examFile);

        DefaultMutableTreeNode expenseFile = new DefaultMutableTreeNode("Expense Record");
        load.add(expenseFile);

        DefaultMutableTreeNode remain = new DefaultMutableTreeNode("Querying on Unpaid Fee/Salary");
        main.add(remain);

        DefaultMutableTreeNode feeNot = new DefaultMutableTreeNode("Unpaid Fee Record");
        remain.add(feeNot);

        DefaultMutableTreeNode tsalaryNot = new DefaultMutableTreeNode("Unpaid Teacher's Salary Record");
        remain.add(tsalaryNot);

        DefaultMutableTreeNode ssalaryNot = new DefaultMutableTreeNode("Unpaid Staff's Salary Record");
        remain.add(ssalaryNot);

        DefaultMutableTreeNode upgrade = new DefaultMutableTreeNode("Upgrade Student's Record");
        main.add(upgrade);

        DefaultMutableTreeNode upgradestudent = new DefaultMutableTreeNode("Upgrading Students");
        upgrade.add(upgradestudent);

        //JLabel logo = new JLabel(new ImageIcon(getClass().getResource("/images/prs.png")));

        final JTree T = new JTree(main);

//        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
//        renderer.setLeafIcon(new ImageIcon("/images/prs.png"));
//        T.setCellRenderer(renderer);
        //T.add(BorderLayout.SOUTH, logo);

        T.addTreeSelectionListener(new TreeSelectionListener() {
            String title = "";

            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) T.getLastSelectedPathComponent();
                if (node == null) {
                    return;
                }

                Object nodeSource = node.getUserObject();
                if (node.isLeaf()) {
                    if (nodeSource.toString().equalsIgnoreCase("Fee Inquiry")) {
                        new FeeMenuF().setVisible(true);
                    } else if (nodeSource.toString().equalsIgnoreCase("Exam Inquiry")) {
                        new ResultFRep().setVisible(true);
                    } else if (nodeSource.toString().equalsIgnoreCase("Subject Inquiry")) {
                        new NewTeaSub().setVisible(true);
                    } else if (nodeSource.toString().equalsIgnoreCase("Salary Payment Record Of current Month")) {
                        new SalaryMenuF().setVisible(true);
                    } else if (nodeSource.toString().equalsIgnoreCase("Entry/View Expense")) {
                        new EntryExpense().setVisible(true);
                    } else if (nodeSource.toString().equalsIgnoreCase("BackUp Database")) {
                        //JOptionPane.showMessageDialog(null, "Need to Be Created");
                        new CreateBackUpDatabase().setVisible(true);
                    } else if (nodeSource.toString().equalsIgnoreCase("ReStore Database")) {
                        //JOptionPane.showMessageDialog(null, "Nedd to Be Created");
                        new RestoreDatabase().setVisible(true);
                    } else if (nodeSource.toString().equalsIgnoreCase("Exam Report")) {
                        //JOptionPane.showMessageDialog(null, "Nedd to Be Created");
                        new LoadExcelData(1).setVisible(true);
                    } else if (nodeSource.toString().equalsIgnoreCase("Expense Record")) {
                        //JOptionPane.showMessageDialog(null, "Nedd to Be Created");
                        new LoadExcelData(2).setVisible(true);
                    } else if (nodeSource.toString().equalsIgnoreCase("Unpaid Fee Record")) {
                        title = "UNPAID FEE RECORDS";
                        new FeeNotPaidGroup(title, 1, 0).setVisible(true);
                    } else if (nodeSource.toString().equalsIgnoreCase("Unpaid Teacher's Salary Record")) {
                        title = "UNPAID TEACHER'S SALARY";
                        new FeeNotPaidGroup(title, 2, 0).setVisible(true);
                    } else if (nodeSource.toString().equalsIgnoreCase("Unpaid Staff's Salary Record")) {
                        title = "UNPAID STAFF'S SALARY";
                        new FeeNotPaidGroup(title, 3, 0).setVisible(true);
                    } else if (nodeSource.toString().equalsIgnoreCase("Upgrading Students")) {
                        //JOptionPane.showMessageDialog(null, "need to be created");
                        new UpgradeClass().setVisible(true);
                    }

                }
            }
        });


        DefaultTreeCellRenderer renderer =
                (DefaultTreeCellRenderer) T.getCellRenderer();
        renderer.setTextSelectionColor(Color.red);
        renderer.setBackgroundSelectionColor(Color.white);
        renderer.setBorderSelectionColor(Color.black);
        renderer.setTextNonSelectionColor(Color.blue);
        renderer.setBackgroundNonSelectionColor(Color.lightGray);
//        renderer.setOpenIcon(null);
//        renderer.setClosedIcon(null);

        // js = new JScrollPane(T);
        T.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        T.setBounds(60, 150, 210, 433);
        //T.setBackground(new java.awt.Color(255, 255, 51));
        //T.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        T.setAutoscrolls(true);
        
        //js.setViewportView(T);
        T.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.GRAY));
        T.setBackground(Color.lightGray);
        //T.setSelectionModel(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
        //T.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        T.putClientProperty("JTree.lineStyle", "Angled");

        return T;
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
        tb = new javax.swing.JToolBar();
        btnStudentInq = new javax.swing.JButton();
        btnTeacherInq = new javax.swing.JButton();
        btnStaffInq = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnFee = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnSalary = new javax.swing.JButton();
        btnTeacherSub = new javax.swing.JButton();
        pnlMani = new javax.swing.JPanel();
        desktopPane = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        pnl3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        datetime = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblimage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(51, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Copy right @ by: NCIT-09 BEIT");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_END);

        tb.setBackground(new java.awt.Color(153, 153, 153));
        tb.setRollover(true);
        tb.setToolTipText("Student's Info");

        btnStudentInq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stib.png"))); // NOI18N
        btnStudentInq.setToolTipText("Student's Info");
        btnStudentInq.setFocusable(false);
        btnStudentInq.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStudentInq.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStudentInq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentInqActionPerformed(evt);
            }
        });
        tb.add(btnStudentInq);

        btnTeacherInq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teacib.png"))); // NOI18N
        btnTeacherInq.setToolTipText("Teacher's Info");
        btnTeacherInq.setFocusable(false);
        btnTeacherInq.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTeacherInq.setMaximumSize(new java.awt.Dimension(31, 31));
        btnTeacherInq.setMinimumSize(new java.awt.Dimension(31, 31));
        btnTeacherInq.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTeacherInq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeacherInqActionPerformed(evt);
            }
        });
        tb.add(btnTeacherInq);

        btnStaffInq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staffib.png"))); // NOI18N
        btnStaffInq.setToolTipText("Staff's Info");
        btnStaffInq.setFocusable(false);
        btnStaffInq.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStaffInq.setMaximumSize(new java.awt.Dimension(31, 31));
        btnStaffInq.setMinimumSize(new java.awt.Dimension(31, 31));
        btnStaffInq.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStaffInq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffInqActionPerformed(evt);
            }
        });
        tb.add(btnStaffInq);

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator1.setSeparatorSize(new java.awt.Dimension(2, 2));
        tb.add(jSeparator1);

        btnFee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/groupf.png"))); // NOI18N
        btnFee.setToolTipText("Student's Fee");
        btnFee.setFocusable(false);
        btnFee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFee.setMaximumSize(new java.awt.Dimension(31, 31));
        btnFee.setMinimumSize(new java.awt.Dimension(31, 31));
        btnFee.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeeActionPerformed(evt);
            }
        });
        tb.add(btnFee);

        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/groupr.png"))); // NOI18N
        btnReport.setToolTipText("Student's Result");
        btnReport.setFocusable(false);
        btnReport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReport.setMaximumSize(new java.awt.Dimension(31, 31));
        btnReport.setMinimumSize(new java.awt.Dimension(31, 31));
        btnReport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });
        tb.add(btnReport);

        jSeparator2.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator2.setSeparatorSize(new java.awt.Dimension(2, 2));
        tb.add(jSeparator2);

        btnSalary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/groups.png"))); // NOI18N
        btnSalary.setToolTipText("Staff's Salary");
        btnSalary.setFocusable(false);
        btnSalary.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalary.setMaximumSize(new java.awt.Dimension(31, 31));
        btnSalary.setMinimumSize(new java.awt.Dimension(31, 31));
        btnSalary.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalaryActionPerformed(evt);
            }
        });
        tb.add(btnSalary);

        btnTeacherSub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/groupsub.png"))); // NOI18N
        btnTeacherSub.setToolTipText("Subject Assign..");
        btnTeacherSub.setFocusable(false);
        btnTeacherSub.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTeacherSub.setMaximumSize(new java.awt.Dimension(31, 31));
        btnTeacherSub.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTeacherSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeacherSubActionPerformed(evt);
            }
        });
        tb.add(btnTeacherSub);

        getContentPane().add(tb, java.awt.BorderLayout.PAGE_START);

        pnlMani.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlMani.setLayout(new java.awt.BorderLayout());

        desktopPane.setBackground(new java.awt.Color(102, 102, 102));
        desktopPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        desktopPane.setForeground(new java.awt.Color(255, 255, 255));
        desktopPane.setDragMode(javax.swing.JDesktopPane.OUTLINE_DRAG_MODE);
        desktopPane.setOpaque(false);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Staff Section", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 51))); // NOI18N
        jPanel2.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Individual Area"));
        jPanel6.setLayout(null);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staffab.png"))); // NOI18N
        jButton6.setText("New Staff");
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.setIconTextGap(0);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6);
        jButton6.setBounds(10, 20, 140, 30);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staffib.png"))); // NOI18N
        jButton7.setText("Staff Info");
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton7);
        jButton7.setBounds(170, 20, 140, 30);

        jPanel2.add(jPanel6);
        jPanel6.setBounds(20, 30, 320, 70);

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Group Search"));
        jPanel7.setLayout(null);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/groups.png"))); // NOI18N
        jButton8.setText("Salary Pay");
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton8);
        jButton8.setBounds(10, 20, 140, 30);

        jButton9.setText("Staff's Record");
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton9);
        jButton9.setBounds(170, 20, 140, 30);

        jPanel2.add(jPanel7);
        jPanel7.setBounds(350, 30, 320, 70);

        jPanel2.setBounds(320, 460, 690, 120);
        desktopPane.add(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        pnl3.setBackground(new java.awt.Color(153, 153, 153));
        pnl3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Student Section", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 51))); // NOI18N
        pnl3.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Group Search"));
        jPanel4.setLayout(null);

        jButton2.setText("Inquiry");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);
        jButton2.setBounds(110, 20, 100, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/groupf.png"))); // NOI18N
        jLabel2.setText("Fee");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(20, 20, 60, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/groupr.png"))); // NOI18N
        jLabel4.setText("Report");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel4.add(jLabel4);
        jLabel4.setBounds(240, 20, 70, 30);

        pnl3.add(jPanel4);
        jPanel4.setBounds(350, 30, 320, 70);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Individual Area"));
        jPanel5.setLayout(null);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stub.png"))); // NOI18N
        jButton4.setText("New Student");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4);
        jButton4.setBounds(10, 20, 140, 30);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stib.png"))); // NOI18N
        jButton5.setText("Student Info");
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.setInheritsPopupMenu(true);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5);
        jButton5.setBounds(170, 20, 140, 30);

        pnl3.add(jPanel5);
        jPanel5.setBounds(20, 30, 320, 70);

        pnl3.setBounds(320, 150, 690, 120);
        desktopPane.add(pnl3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Teacher Section", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 51))); // NOI18N
        jPanel8.setLayout(null);

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Individual Area"));
        jPanel9.setLayout(null);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teab.png"))); // NOI18N
        jButton11.setText("New Teacher");
        jButton11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton11);
        jButton11.setBounds(10, 20, 140, 30);

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teacib.png"))); // NOI18N
        jButton21.setText("Teacher Info");
        jButton21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton21);
        jButton21.setBounds(170, 20, 140, 30);

        jPanel8.add(jPanel9);
        jPanel9.setBounds(20, 30, 320, 70);

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Group Search"));
        jPanel10.setLayout(null);

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/groups.png"))); // NOI18N
        jButton12.setText("Salary Pay");
        jButton12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton12);
        jButton12.setBounds(10, 20, 140, 30);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/groupsub.png"))); // NOI18N
        jButton13.setText("Subject ");
        jButton13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton13);
        jButton13.setBounds(170, 20, 140, 30);

        jButton3.setText("Teacher's Record");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton3);
        jButton3.setBounds(80, 73, 170, 30);

        jPanel8.add(jPanel10);
        jPanel10.setBounds(350, 30, 320, 120);

        jButton14.setText("Assign Subject");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton14);
        jButton14.setBounds(220, 130, 120, 23);

        jPanel8.setBounds(320, 280, 690, 170);
        desktopPane.add(jPanel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/newbanner.png"))); // NOI18N
        jLabel3.setBounds(60, 30, 1250, 100);
        desktopPane.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        datetime.setBounds(600, 590, 180, 30);
        desktopPane.add(datetime, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Graphical Demo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(255, 255, 0))); // NOI18N
        jPanel1.setLayout(null);
        jPanel1.add(lblimage);
        lblimage.setBounds(4, 14, 280, 240);

        jPanel1.setBounds(1030, 150, 290, 260);
        desktopPane.add(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        pnlMani.add(desktopPane, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlMani, java.awt.BorderLayout.CENTER);

        setLocation(new java.awt.Point(0, 0));
    }// </editor-fold>//GEN-END:initComponents
//
//    protected boolean isLoaded(String FormTitle) {
//
//        JInternalFrame Form[] = desktopPane.getAllFrames();
//        for (int i = 0; i < Form.length; i++) {
//            if (Form[i].getTitle().equalsIgnoreCase(FormTitle)) {
//                Form[i].show();
//                try {
//                    Form[i].setIcon(false);
//                    Form[i].setSelected(true);
//                } catch (PropertyVetoException e) {
//                }
//                return true;
//            }
//        }
//        return false;
//
//    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new StudentGroupF().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new NewStudentF().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new StudentSecF().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        new NewStaffF().setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        new StaffSecF().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        //String[] buttons = new String ["All","Current"];
        String ObjButtons[] = {"All", "Current"};
        int PromptResult = JOptionPane.showOptionDialog(null, "How you want to view the Data", "School Managenemt System", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
        if (PromptResult == 0) {
            //System.exit(0);
            createTableForm(4);
        } else if (PromptResult == 1) {
            createTableForm(7);
        }

        //JDailog d = new JDailog();
        //new TabulateData("STAFF_SALARY","SALARY",7).setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        createTableForm(3);
        // new TabulateData("STAFF_INFO","INFO",6).setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        //createTableForm();
        new NewTeacherF().setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        String ObjButtons[] = {"All", "Current"};
        int PromptResult = JOptionPane.showOptionDialog(null, "How you want to view the Data", "School Managenemt System", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
        if (PromptResult == 0) {
            //System.exit(0);
            createTableForm(5);
        } else if (PromptResult == 1) {
            createTableForm(6);
        }

        // createTableForm(5);
        //new TabulateData("TEACHER_SALARY","SALARY",5).setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        createTableForm(1);
        // new TabulateData("Teacher","dami",4).setVisible(true);
        //  new TableDemo().setVisible(true);
}//GEN-LAST:event_jButton13ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        new TeacherSecF().setVisible(true);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        new NewTeaSub().setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        UnloadWindow();
    }//GEN-LAST:event_formWindowClosing

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        createTableForm(2);
        // new TabulateData("TEACHER_INFO","INFO",5).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnStudentInqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentInqActionPerformed
        // TODO add your handling code here:
        new StudentSecF().setVisible(true);
    }//GEN-LAST:event_btnStudentInqActionPerformed

    private void btnTeacherInqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeacherInqActionPerformed
        // TODO add your handling code here:
        new TeacherSecF().setVisible(true);
    }//GEN-LAST:event_btnTeacherInqActionPerformed

    private void btnStaffInqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffInqActionPerformed
        // TODO add your handling code here:
        new StaffSecF().setVisible(true);
    }//GEN-LAST:event_btnStaffInqActionPerformed

    private void btnTeacherSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeacherSubActionPerformed
        // TODO add your handling code here:
        new NewTeaSub().setVisible(true);
    }//GEN-LAST:event_btnTeacherSubActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        // TODO add your handling code here:
        new ResultFRep().setVisible(true);
    }//GEN-LAST:event_btnReportActionPerformed

    private void btnFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeeActionPerformed
        // TODO add your handling code here:
        new FeeMenuF().setVisible(true);

    }//GEN-LAST:event_btnFeeActionPerformed

    private void btnSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalaryActionPerformed
        // TODO add your handling code here:
        new SalaryMenuF().setVisible(true);
    }//GEN-LAST:event_btnSalaryActionPerformed

    protected void createTableForm(int status) {
        String title = "";
        switch (status) {

            case 1:
                query = "SELECT teacher_info.name,teacher_sub.class,teacher_sub.subject from teacher_info,teacher_sub WHERE teacher_info.teacherId = teacher_sub.teacherId";
                title = "TEACHER'S SUBJECT ASSIGNMENT RECORD";
                break;
            case 2:
                query = "SELECT teacherId,name,address,contact,qfc,empd FROM teacher_info";
                title = "TEACHER'S RECORD";
                break;

            case 3:
                query = "SELECT staffId,name,address,contact,post FROM staff_info";
                title = "STAFF'S RECORD";
                break;

            case 4:
                query = "SELECT staff_info.staffId,staff_info.name,staff_info.contact,staff_info.post,staffsalary.dop FROM staff_info,staffsalary"
                        + " WHERE staff_info.staffId = staffsalary.staffId AND staffsalary.report = 'p'";
                title = "STAFF'S SALARY PAYMENT RECORD";
                break;

            case 5:
                query = "SELECT teacher_info.teacherId,teacher_info.name,teacher_info.contact,teachersalary.dop FROM teacher_info,teachersalary"
                        + " WHERE teacher_info.teacherId = teachersalary.teacherId AND teachersalary.report = 'p'";
                title = "TEACHER'S SALARY PAYMENT";
                break;

            case 6:
                query = "SELECT teacher_info.teacherId,teacher_info.name,teacher_info.contact FROM teacher_info,teachersalary"
                        + " WHERE teacher_info.teacherId = teachersalary.teacherId AND teachersalary.report = 'p' AND date_format(teachersalary.dop,'%y%m') = date_format(now(),'%y%m')";
                title = "TEACHER'S SALARY PAYMENT RECORD OF CURRENT MONTH";
                break;
            case 7:
                query = "SELECT staff_info.staffId,staff_info.name,staff_info.contact,staff_info.post FROM staff_info,staffsalary"
                        + " WHERE staff_info.staffId = staffsalary.staffId AND staffsalary.report = 'p'"
                        + " AND date_format(staffsalary.dop,'%y%m') = date_format(now(),'%y%m')";
                title = "STAFF'S SALARY PAYMENT RECORD OF CURRENT MONTH";
                break;

            case 8:
                query = "SELECT studentId,name,gardianName,address,contact,grade,enrolled FROM "
                        + "student_info WHERE grade = '" + grade + "'";

        }
        CommonTabulateData td = new CommonTabulateData();

        //td.Close();
        if (td.dataValidCheck(query)) {
            new TabulateData(title,query).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "There is No Data to Display. Sorry");
        }

    }

    protected void UnloadWindow() {
        String ObjButtons[] = {"Yes", "No"};
        int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "School Managenemt System", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
        if (PromptResult == 0) {
            System.exit(0);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (Exception e) {
        }
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
        new Home().setVisible(true);
//            }
//        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFee;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnSalary;
    private javax.swing.JButton btnStaffInq;
    private javax.swing.JButton btnStudentInq;
    private javax.swing.JButton btnTeacherInq;
    private javax.swing.JButton btnTeacherSub;
    private javax.swing.JLabel datetime;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JLabel lblimage;
    private javax.swing.JPanel pnl3;
    private javax.swing.JPanel pnlMani;
    private javax.swing.JToolBar tb;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JMenuBar mb;
}
