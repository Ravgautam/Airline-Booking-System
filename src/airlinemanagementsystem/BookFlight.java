package airlinemanagementsystem;
import javax.swing.*; //for frames
import java.awt.*;  // for color
import java.awt.event.*; //for event handler
import java.sql.*; // for databse
import com.toedter.calendar.JDateChooser; // for calender
import java.util.*;

public class BookFlight extends JFrame implements ActionListener {
    
    JLabel tfName, tfNationality, tfAddress, labelGender, labelFname, labelFcode;
    JTextField tfAadhar;
    JButton flight, bookFlight, fetchButton;
    Choice source, destination;
    JDateChooser dcdate;
    
    public BookFlight(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading= new JLabel("Book Flight");
        heading.setBounds(250, 15, 500, 50);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        heading.setForeground(Color.darkGray);
        add(heading);
        
        JLabel lblAadhar= new JLabel("Aadhar Number");
        lblAadhar.setBounds(60, 62, 200, 30);
        lblAadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblAadhar);
        
        tfAadhar= new JTextField();
        tfAadhar.setBounds(190, 66, 160, 25);
        add(tfAadhar);
        
        fetchButton = new JButton("Fetch User");
        fetchButton.setBackground(Color.gray);
        fetchButton.setForeground(Color.white);
        fetchButton.setBounds(360, 66, 100, 24);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblName= new JLabel("Name");
        lblName.setBounds(60, 100, 200, 30);
        lblName.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblName);
        
        tfName= new JLabel();
        tfName.setBounds(190, 104, 160, 25);
        add(tfName);
        
        JLabel lblNationality= new JLabel("Nationality");
        lblNationality.setBounds(60, 138, 200, 30);
        lblNationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblNationality);
        
        tfNationality= new JLabel();
        tfNationality.setBounds(190, 142, 160, 25);
        add(tfNationality);
        
        
        
        JLabel lblAddress= new JLabel("Address");
        lblAddress.setBounds(60, 176, 200, 30);
        lblAddress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblAddress);
        
        tfAddress= new JLabel();
        tfAddress.setBounds(190, 180, 160, 25);
        add(tfAddress);
        
        JLabel lblGender= new JLabel("Gender");
        lblGender.setBounds(60, 214, 200, 30);
        lblGender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblGender);
        
        labelGender= new JLabel();
        labelGender.setBounds(190, 215, 160, 30);
        add(labelGender);
        
        JLabel lblSource= new JLabel("Source");
        lblSource.setBounds(60, 252, 120, 30);
        lblSource.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblSource);
        
        source= new Choice();       //Choice for drop down menu
        source.setBounds(190, 257, 120, 25);
        add(source);
        
        JLabel lblDest= new JLabel("Destination");
        lblDest.setBounds(60, 290, 120, 30);
        lblDest.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblDest);
        
        destination= new Choice();  //Choice for drop down menu
        destination.setBounds(190, 295, 120, 25);
        add(destination);
        
        try{
        
            Conn c= new Conn();
            String query= "select * from flight";
            ResultSet rs= c.s.executeQuery(query);
            
            while(rs.next()){ // this next run loop
            source.add(rs.getString("source"));
            destination.add(rs.getString("destination"));
        }
            
        }catch(Exception e){
        
            e.printStackTrace();
        }
        
        flight= new JButton("Fetch Flights");
        flight.setBounds(330, 295, 130, 23);
        flight.setBackground(Color.GRAY);
        flight.setForeground(Color.WHITE);
        flight.addActionListener(this);
        add(flight);
        
        JLabel lblFname= new JLabel("Flight Name");
        lblFname.setBounds(60, 333, 130, 30);
        lblFname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblFname);
        
        labelFname= new JLabel();
        labelFname.setBounds(190, 337, 160, 25);
        add(labelFname);
        
        JLabel lblFcode= new JLabel("Flight Code");
        lblFcode.setBounds(60, 371, 130, 30);
        lblFcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblFcode);
        
        labelFcode= new JLabel();
        labelFcode.setBounds(190, 375, 160, 25);
        add(labelFcode);
        
        JLabel lblDate= new JLabel("Date of Travel");
        lblDate.setBounds(60, 409, 130, 30);
        lblDate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblDate);
        
        dcdate= new JDateChooser(); // to open calender from jar file
        dcdate.setBounds(190, 412, 160, 24);
        add(dcdate);
        
        bookFlight= new JButton("Book Flight");
        bookFlight.setBounds(300, 460, 130, 30);
        bookFlight.setBackground(Color.GRAY);
        bookFlight.setForeground(Color.WHITE);
        bookFlight.addActionListener(this);
        add(bookFlight); 
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
        Image i2= i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon image= new ImageIcon(i2);
        JLabel lblImage= new JLabel(image);
        lblImage.setBounds(420, 20, 280, 400);
        add(lblImage);
        
        setSize(700,600);
        setLocation(250,60);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource()==fetchButton){
       
        String aadhar= tfAadhar.getText();
              
        try{
                
                Conn conn = new Conn();
                String query="select * from passenger where aadhar='"+aadhar+"'";
                
               ResultSet rs= conn.s.executeQuery(query);
               
               if(rs.next()){
               
                   tfName.setText(rs.getString("name"));
                   tfNationality.setText(rs.getString("nationality"));
                   tfAddress.setText(rs.getString("address"));
                   labelGender.setText(rs.getString("gender"));
               }else{
               
                   JOptionPane.showMessageDialog(null, "User does not exist");
               }
     
            
        }catch(Exception e){
        
            e.printStackTrace();
        }
        
        }else if(ae.getSource()==flight){
       
        String src= source.getSelectedItem();
        String dest= destination.getSelectedItem();
              
        try{
                
                Conn conn = new Conn();
                String query="select * from flight where source='"+src+"' and destination='"+dest+"'";
                
               ResultSet rs= conn.s.executeQuery(query);
               
               if(rs.next()){
               
                   labelFname.setText(rs.getString("f_name"));
                   labelFcode.setText(rs.getString("f_code"));
                 
               }else{
               
                   JOptionPane.showMessageDialog(null, "No Flights Found");
               }
     
            
        }catch(Exception e){
        
            e.printStackTrace();
        }
        
        }
        else{
            
        Random random= new Random();
            String name= tfName.getText();
            String nationality= tfNationality.getText();
            //String address= tfAddress.getText();
           // String gender= labelGender.getText();
            String flightName= labelFname.getText();
            String flightCode= labelFcode.getText();
            String aadhar= tfAadhar.getText();
            String src= source.getSelectedItem();
            String dest= destination.getSelectedItem();
            String date= ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            
            try{
                
                Conn conn = new Conn();
                String query="insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"', '"+aadhar+"', '"+name+"', '"+nationality+"', '"+flightName+"', '"+flightCode+"', '"+src+"','"+dest+"', '"+date+"')";
                
               conn.s.executeUpdate(query);
               
               
                   JOptionPane.showMessageDialog(null, "Ticket Booked Successfully!");         
                   
                   setVisible(false);
            
        }catch(Exception e){
        
            e.printStackTrace();
        }
        
        }
        }
    
    public static void main(String[] args) {
        new BookFlight();
    }
    
}
