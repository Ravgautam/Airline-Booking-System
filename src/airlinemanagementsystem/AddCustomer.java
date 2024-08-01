package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener {
    
    JTextField tfName, tfPhone, tfAadhar, tfNationality, tfAddress;
    JRadioButton rdMale, rdFemale, rdOther;
    JButton save, close;
    
    public AddCustomer(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading= new JLabel("Add Customer Details");
        heading.setBounds(150, 20, 500, 50);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        heading.setForeground(Color.darkGray);
        add(heading);
        
        JLabel lblName= new JLabel("Name");
        lblName.setBounds(60, 78, 200, 30);
        lblName.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblName);
        
        tfName= new JTextField();
        tfName.setBounds(190, 82, 200, 25);
        add(tfName);
        
        JLabel lblNationality= new JLabel("Nationality");
        lblNationality.setBounds(60, 120, 200, 30);
        lblNationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblNationality);
        
        tfNationality= new JTextField();
        tfNationality.setBounds(190, 124, 200, 25);
        add(tfNationality);
        
        JLabel lblAadhar= new JLabel("Aadhar Number");
        lblAadhar.setBounds(60, 162, 200, 30);
        lblAadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblAadhar);
        
        tfAadhar= new JTextField();
        tfAadhar.setBounds(190, 166, 200, 25);
        add(tfAadhar);
        
        JLabel lblAddress= new JLabel("Address");
        lblAddress.setBounds(60, 204, 200, 30);
        lblAddress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblAddress);
        
        tfAddress= new JTextField();
        tfAddress.setBounds(190, 208, 200, 25);
        add(tfAddress);
        
        JLabel lblGender= new JLabel("Gender");
        lblGender.setBounds(60, 244, 200, 30);
        lblGender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblGender);
        
        ButtonGroup genderGroup= new ButtonGroup();
        
        rdMale= new JRadioButton("Male");
        rdMale.setBounds(190, 248, 70, 25);
        rdMale.setBackground(Color.WHITE);
        add(rdMale);
        
        rdFemale= new JRadioButton("Female");
        rdFemale.setBounds(270, 248, 70, 25);
        rdFemale.setBackground(Color.WHITE);
        add(rdFemale);
        
        rdOther= new JRadioButton("Other");
        rdOther.setBounds(350, 248, 70, 25);
        rdOther.setBackground(Color.WHITE);
        add(rdOther);
        
        genderGroup.add(rdMale);
        genderGroup.add(rdFemale);
        genderGroup.add(rdOther);
        
        JLabel lblphone= new JLabel("Phone Number");
        lblphone.setBounds(60, 284, 200, 30);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        
        tfPhone= new JTextField();
        tfPhone.setBounds(190, 288, 200, 25);
        add(tfPhone);
        
        save= new JButton("Save");
        save.setBounds(150, 350, 100, 30);
        save.setBackground(Color.GRAY);
        save.setForeground(Color.WHITE);
        save.addActionListener(this);
        add(save);
        
        close= new JButton("Close");
        close.setBounds(300, 350, 100, 30);
        close.setBackground(Color.GRAY);
        close.setForeground(Color.WHITE);
        close.addActionListener(this);
        add(close);
        
        ImageIcon image= new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblImage= new JLabel(image);
        lblImage.setBounds(430, 50, 280, 400);
        add(lblImage);
        
        setSize(700,500);
        setLocation(250,100);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
    
        String name= tfName.getText();
        String nationality= tfNationality.getText();
        String phone = tfPhone.getText();
        String address= tfAddress.getText();
        String aadhar= tfAadhar.getText();
        String gender= null;
                
               if(rdMale.isSelected()){
                   gender= "Male";
               }
                else if(rdFemale.isSelected()){
                    gender= "Female";
                }
                else{
                    gender="Other";
                }
        try{
            if(ae.getSource()==save){
                
                Conn conn = new Conn();
                String query="insert into passenger values('"+name+"' , '"+nationality+"' , '"+phone+"' , '"+address+"' , '"+aadhar+"' , '"+gender+"')";
                
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
            }
            
            else if(ae.getSource()==close){
            
                setVisible(false);
            }
            
        }catch(Exception e){
        
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new AddCustomer();
    }
    
}
