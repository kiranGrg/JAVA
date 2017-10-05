package newpackage;

//TablePreviewPrint.java
import javax.swing.*;
import java.awt.event.*;
import java.awt.print.*;
import java.text.*;

class TablePreviewPrint extends JFrame implements ActionListener
{
    PrinterJob pj = PrinterJob.getPrinterJob();
    javax.print.attribute.HashPrintRequestAttributeSet att =
    new javax.print.attribute.HashPrintRequestAttributeSet();
    JEditorPane tp = null;
    JTable tab = null;
    private Object[][] val = null;
    private String[] title = null;

    public TablePreviewPrint(Object [][]data, String []Col) {
//    public TablePreviewPrint() {
        super("Test of Print Preview");
        val = data;
        title = Col;
        tab.setEnabled(false);
        //JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        //sp.setTopComponent(createTextPane());
        //sp.setBottomComponent(createTable());
        java.awt.Dimension d = this.getToolkit().getScreenSize();
        this.setSize(d.width/2, d.height-50);
        this.setLocation((d.width-500)/2, 0);
        this.getContentPane().add(createTable());
        //this.getContentPane().add(sp);
        //this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        //sp.setDividerLocation(0.5);
        this.validate();
    }

//    private JPanel createTextPane() {
//        tp = new JEditorPane("text/html","");
//        tp.setEditable(false);
//        try {tp.setPage(new java.io.File("prod02.htm").toURI().toURL()); } catch(Exception ex) {}
//        JButton ps = new JButton("Page Setup"), b = new JButton("Preview Text");
//        ps.addActionListener(this);
//        b.addActionListener(this);
//        JPanel p = new JPanel(new java.awt.BorderLayout()), top = new JPanel(new java.awt.FlowLayout());
//        top.add(ps);
//        top.add(b);
//        p.add(top, "North");
//        p.add(new JScrollPane(tp), "Center");
//        return p;
//    }

    private JPanel createTable() {
//        String val[][] = {{"India", "New Delhi"}, {"Nepal","Katmandu"}};//,{"Afghanistan","Kabul"},
//        //{"Burma","Myanmar"}, {"China","Beijing"},{"Thailand","Bankok"}
//        //};
//        String title[] = {"Nation","Capital"};
        tab = new JTable(val,title);
        tab.setRowHeight(25);
        tab.setFont(new java.awt.Font("Times New Roman",java.awt.Font.BOLD,16));
        JButton ps = new JButton("Page Setup"), b = new JButton("Preview Table");
        ps.addActionListener(this);
        b.addActionListener(this);
        JPanel p = new JPanel(new java.awt.BorderLayout()), top = new JPanel(new java.awt.FlowLayout());
        top.add(ps);
        top.add(b);
        p.add(top, "North");
        p.add(new JScrollPane(tab), "Center");

        return p;
    }

    public void actionPerformed(ActionEvent ae) {
        String com = ae.getActionCommand();
        if(com.equals("Page Setup")){
            pj.pageDialog(att);
            }
        //else if(com.equals("Preview Text"))
        //new PrintPreview(tp.getPrintaSble(new MessageFormat("Permutation and Combination"),
        //new MessageFormat("{0}")), pj.getPageFormat(att));
        else if(com.equals("Preview Table")){
            new PrintPreview(tab.getPrintable(javax.swing.JTable.PrintMode.FIT_WIDTH,new MessageFormat("Details To Be Printed:"), new MessageFormat("{0}")), pj.getPageFormat(att));
        }
    }

//    public static void main(String arg[]) {
//    //new TablePreviewPrint();
//    }
}
