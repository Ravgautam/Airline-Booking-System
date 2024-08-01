package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
 
public class FlightInfo extends JFrame {
    
    public FlightInfo(){
    
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JTable table = new JTable();
        
        try{
            Conn conn= new Conn();
            
            ResultSet rs= conn.s.executeQuery("select * from flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
        
            e.printStackTrace();
        }
        
        JScrollPane jsp= new JScrollPane(table);
        jsp.setBounds(10, 10, 680, 355);
        add(jsp);
        
        setSize(710,410);
        setLocation(200,100);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new FlightInfo();
    }
    
}
