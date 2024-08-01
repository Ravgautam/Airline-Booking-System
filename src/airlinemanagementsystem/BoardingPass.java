package airlinemanagementsystem;
import javax.swing.*; //for frames
import java.awt.*;  // for color
import java.awt.event.*; //for event handler
import java.sql.*; // for databse
import java.util.*;

public class BoardingPass extends JFrame implements ActionListener {
    
    JLabel tfName, tfNationality, labelSrc, labelDest, labelFname, labelFcode, labelDate;
    JTextField tfPnr;
    JButton fetchButton;
   
    
    public BoardingPass(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading= new JLabel("AIR INDIA");
        heading.setBounds(300, 10, 500, 50);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        heading.setForeground(Color.darkGray);
        add(heading);
        
        JLabel subHeading= new JLabel("Boarding Pass");
        subHeading.setBounds(290, 60, 300, 30);
        subHeading.setFont(new Font("Tahoma",Font.BOLD,20));
        subHeading.setForeground(Color.GRAY);
        add(subHeading);
        
        JLabel lblPnr= new JLabel("PNR Details");
        lblPnr.setBounds(60, 110, 200, 30);
        lblPnr.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblPnr);
        
        tfPnr= new JTextField();
        tfPnr.setBounds(190, 114, 160, 25);
        add(tfPnr);
        
        fetchButton = new JButton("Enter");
        fetchButton.setBackground(Color.gray);
        fetchButton.setForeground(Color.white);
        fetchButton.setBounds(360, 114, 100, 24);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblName= new JLabel("NAME");
        lblName.setBounds(60, 150, 200, 30);
        lblName.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblName);
        
        tfName= new JLabel();
        tfName.setBounds(190, 154, 160, 25);
        add(tfName);
        
        JLabel lblNationality= new JLabel("NATIONALITY");
        lblNationality.setBounds(60, 190, 200, 30);
        lblNationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblNationality);
        
        tfNationality= new JLabel();
        tfNationality.setBounds(190, 194, 160, 25);
        add(tfNationality);
        
        
        
        JLabel lblSrc= new JLabel("SOURCE");
        lblSrc.setBounds(60, 230, 200, 30);
        lblSrc.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblSrc);
        
        labelSrc= new JLabel();
        labelSrc.setBounds(190, 234, 160, 25);
        add(labelSrc);
        
        JLabel lblDest= new JLabel("DESTINATION");
        lblDest.setBounds(60, 270, 200, 30);
        lblDest.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblDest);
        
        labelDest= new JLabel();
        labelDest.setBounds(190, 274, 160, 30);
        add(labelDest);
        
        
        JLabel lblFname= new JLabel("Flight Name");
        lblFname.setBounds(350, 230, 130, 30);
        lblFname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblFname);
        
        labelFname= new JLabel();
        labelFname.setBounds(450, 234, 160, 25);
        add(labelFname);
        
        JLabel lblFcode= new JLabel("Flight Code");
        lblFcode.setBounds(350, 270, 130, 30);
        lblFcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblFcode);
        
        labelFcode= new JLabel();
        labelFcode.setBounds(450, 274, 160, 25);
        add(labelFcode);
        
        JLabel lblDate= new JLabel("DATE");
        lblDate.setBounds(60, 310, 130, 30);
        lblDate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblDate);
        
        labelDate= new JLabel(); // to open calender from jar file
        labelDate.setBounds(190, 314, 160, 24);
        add(labelDate);
        
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
        Image i2= i1.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT);
        ImageIcon image= new ImageIcon(i2);
        JLabel lblImage= new JLabel(image);
        lblImage.setBounds(500, 15, 300, 250);
        add(lblImage);
        
        setSize(800,390);
        setLocation(250,110);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
       
        String pnr= tfPnr.getText();
              
        try{
                
                Conn conn = new Conn();
                String query="select * from reservation where PNR='"+pnr+"'";
                
               ResultSet rs= conn.s.executeQuery(query);
               
               if(rs.next()){
               
                   tfName.setText(rs.getString("name"));
                   tfNationality.setText(rs.getString("nationality"));
                   labelSrc.setText(rs.getString("src"));
                   labelDest.setText(rs.getString("dest"));
                   labelFname.setText(rs.getString("flightName"));
                   labelFcode.setText(rs.getString("flightCode"));
                   labelDate.setText(rs.getString("date"));
                   
               }else{
               
                   JOptionPane.showMessageDialog(null, "Please Enter Correct PNR");
               }
     
            
        }catch(Exception e){
        
            e.printStackTrace();
        }
        
        
     
        }
    
    public static void main(String[] args) {
        new BoardingPass();
    }
    
}
