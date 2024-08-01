package airlinemanagementsystem;
import javax.swing.*; //for frames
import java.awt.*;  // for color
import java.awt.event.*; //for event handler
import java.sql.*; // for databse
import java.util.*;

public class Cancel extends JFrame implements ActionListener {
    
    JLabel tfName, cancellationno, lblCode, labelDate;
    JTextField tfPnr;
    JButton cancel, fetchButton;
    
    public Cancel(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        Random random = new Random();
        
        JLabel heading= new JLabel("Cancellation");
        heading.setBounds(290, 10, 250, 45);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        heading.setForeground(Color.darkGray);
        add(heading);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
        Image i2= i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(470, 100, 200, 200);
        add(image);
        
        JLabel lblPnr= new JLabel("PNR Number");
        lblPnr.setBounds(60, 62, 200, 30);
        lblPnr.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblPnr);
        
        tfPnr= new JTextField();
        tfPnr.setBounds(190, 66, 160, 25);
        add(tfPnr);
        
        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.gray);
        fetchButton.setForeground(Color.white);
        fetchButton.setBounds(360, 66, 120, 24);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblName= new JLabel("Name");
        lblName.setBounds(60, 100, 200, 30);
        lblName.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblName);
        
        tfName= new JLabel();
        tfName.setBounds(190, 104, 160, 25);
        add(tfName);
        
        JLabel lblCancellation= new JLabel("Cancellation No");
        lblCancellation.setBounds(60, 138, 200, 30);
        lblCancellation.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblCancellation);
        
        cancellationno= new JLabel(""+random.nextInt(1000000));
        cancellationno.setBounds(190, 142, 160, 25);
        add(cancellationno);
        
        
        
        JLabel lblFlightCode= new JLabel("Flight Code");
        lblFlightCode.setBounds(60, 176, 200, 30);
        lblFlightCode.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblFlightCode);
        
        lblCode= new JLabel();
        lblCode.setBounds(190, 180, 160, 25);
        add(lblCode);
        
        JLabel lblDate= new JLabel("Date");
        lblDate.setBounds(60, 214, 200, 30);
        lblDate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblDate);
        
        labelDate= new JLabel();
        labelDate.setBounds(190, 215, 160, 30);
        add(labelDate);
        
       
        cancel= new JButton("Cancel");
        cancel.setBounds(280, 295, 130, 23);
        cancel.setBackground(Color.GRAY);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
     
        setSize(750,400);
        setLocation(250,110);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource()==fetchButton){
       
        String pnr= tfPnr.getText();
              
        try{
                
                Conn conn = new Conn();
                String query="select * from reservation where PNR='"+pnr+"'";
                
               ResultSet rs= conn.s.executeQuery(query);
               
               if(rs.next()){
               
                   tfName.setText(rs.getString("name"));
                   lblCode.setText(rs.getString("flightCode"));
                   labelDate.setText(rs.getString("date"));
                   
               }else{
               
                   JOptionPane.showMessageDialog(null, "Please Enter Correct PNR");
               }
     
            
        }catch(Exception e){
        
            e.printStackTrace();
        }
        
        }else if(ae.getSource()==cancel){
       
        String name= tfName.getText();
        String pnr= tfPnr.getText();
        String cancelno = cancellationno.getText();
        String fCode = lblCode.getText();
        String date = labelDate.getText();
              
        try{
                
                Conn conn = new Conn();
                String query="insert into cancel values('"+pnr+"', '"+name+"', '"+cancelno+"', '"+fCode+"', '"+date+"')";
                
               conn.s.executeUpdate(query);
               conn.s.executeUpdate("delete from reservation where PNR= '"+pnr+"'");
     
               
                   JOptionPane.showMessageDialog(null, "Ticket Cancelled Successfully");
                   setVisible(false);
         
     
            
        }catch(Exception e){
        
            e.printStackTrace();
        }
        
        }
  
        }
    
    public static void main(String[] args) {
        new Cancel();
    }
    
}
