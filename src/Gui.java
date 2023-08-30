import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui 
{

    
    Gui()
    {

    }


    public String enterIP()
    {   
       

        JTextField IP = new JTextField(9);
       
        //JLabel text = new JLabel("Please enter Season & Episode");
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
    
}
