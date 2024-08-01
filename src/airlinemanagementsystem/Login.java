package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton reset, submit, close; 
    JTextField tfUsername;
    JPasswordField tfPassword;
    public Login(){
        
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        
        JLabel lblUsername= new JLabel("Username");
        lblUsername.setBounds(40, 10, 200, 40);
        add(lblUsername);
        
        tfUsername= new JTextField();
        tfUsername.setBounds(160, 22, 170, 20);
        add(tfUsername);
        
       
        JLabel lblPassword= new JLabel("Password");
        lblPassword.setBounds(40, 60, 200, 40);
        add(lblPassword);
        
        tfPassword= new JPasswordField();
        tfPassword.setBounds(160, 72, 170, 20);
        add(tfPassword);
        
        reset= new JButton("Reset");
        reset.setBounds(50, 120, 70, 20);
        reset.addActionListener(this);
        add(reset);
        
        submit= new JButton("Submit");
        submit.setBounds(150, 120, 80, 20);
        submit.addActionListener(this);
        add(submit);
        
        close= new JButton("Close");
        close.setBounds(260, 120, 70, 20);
        close.addActionListener(this);
        add(close);
        
        setVisible(true);
        setSize(420,240);
        setLocation(400,200);
}
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String username= tfUsername.getText();
            String password= tfPassword.getText();
            
            try{
                Conn c= new Conn();
                String query= "select * from login where username= '"+username+"'and password= '"+password+"'";
                
                ResultSet rs= c.s.executeQuery(query);
                
                if(rs.next()){
                    new Home();
                    setVisible(false);
                }else{
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            } 
        }
        else if(ae.getSource()==close){
            setVisible(false);
        }
        else if(ae.getSource()==reset){
            tfUsername.setText("");
            tfPassword.setText("");
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
