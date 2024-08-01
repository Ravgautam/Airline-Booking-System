package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class JourneyDetails extends JFrame implements ActionListener {
    
    JTable table;
    JTextField pnr;
    JButton show;
    
    public JourneyDetails(){
    
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel lblPnr= new JLabel("PNR Details");
        lblPnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPnr.setBounds(50, 50, 100, 25);
        add(lblPnr);
        
        pnr = new JTextField();
        pnr.setBounds(160, 54, 120, 25);
        add(pnr);
        
        show = new JButton("Show Details");
        show.setBackground(Color.WHITE);
        show.setForeground(Color.GRAY);
        show.setBounds(290, 54, 120, 25);
        show.addActionListener(this);
        add(show);
        
        
        table = new JTable();
        
        
        JScrollPane jsp= new JScrollPane(table);
        jsp.setBounds(10, 100, 860, 150);
        jsp.setBackground(Color.WHITE);
        add(jsp);
        
        setSize(890,410);
        setLocation(200,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
    
        try{
            Conn conn= new Conn();
            
            ResultSet rs= conn.s.executeQuery("select * from reservation where PNR= '"+pnr.getText()+"'");
            
            if(!rs.isBeforeFirst()){
            
                JOptionPane.showMessageDialog(null, "No Information Found");
                return;
            }
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
        
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new JourneyDetails();
    }
    
}
