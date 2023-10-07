package userinterface;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.dv8tion.jda.api.entities.User;

public class Gui 
{

    
    Gui()
    {

    }


    public String enterIP()
    {   
       

        JTextField IP = new JTextField(9);
       
    
        JPanel myPanel = new JPanel();
       
        //myPanel.add(text);
        myPanel.add(new JLabel("Enter IP: "));
        myPanel.add(IP);
        
    
        int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Please enter IP Adress from AWTRIX", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) 
        {
            System.out.println("IP:" + IP.getText());
          
        }
       
        return IP.getText();
    }

    public String enterToken()
    {
        JTextField Token = new JTextField(15);
       
      
        JPanel myPanel = new JPanel();
       
        //myPanel.add(text);
        myPanel.add(new JLabel("Enter Token: "));
        myPanel.add(Token);
        
    
        int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Please enter Discord Bot Token", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) 
        {
            System.out.println("Token:" + Token.getText());
          
        }
       
        return Token.getText();
    }


    public String enterUserID() 
    {
          JTextField UserID = new JTextField(15);
      
        JPanel myPanel = new JPanel();
    
        myPanel.add(new JLabel("Enter Discord-User ID: "));
        myPanel.add(UserID);
        
    
        int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Please enter Discord Bot Token", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) 
        {
            System.out.println("UserID:" + UserID.getText());
          
        }
       
        return UserID.getText();
    }
    
}
