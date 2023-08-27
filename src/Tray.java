
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Tray 
{
   

    SpotifyController controller;
      
       
       

    Tray()
    {
        controller = new SpotifyController("http://192.168.188.74/api/custom?name=Spotify");
    }

    public void loadTray() throws AWTException
    {
        TrayIcon trayIcon = null;
      
        if(SystemTray.isSupported())
        {
            SystemTray tray = SystemTray.getSystemTray();

            
            Image image = Toolkit.getDefaultToolkit().getImage("icon.png");

            PopupMenu popup = new PopupMenu();

            MenuItem spotify= new MenuItem("Activate Spotify");
            MenuItem exit = new MenuItem("Exit");

            exit.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
                
            });

          
           spotify.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) 
                {
                   
                   if(controller.getactive() == false)
                   {
                        spotify.setLabel("Disable Spotify");
                        controller.register();
                        controller.setactive(true);
                   }
                   else
                   {
                        spotify.setLabel("Enable Spotify");
                        controller.stop();
                        controller.setactive(false);
                   }
                   
                    
                }
                
            });


            popup.add(spotify);
            popup.add(exit);





            trayIcon = new TrayIcon(image, "AWT-SPOT",popup);
            trayIcon.setImageAutoSize(true);

            tray.add(trayIcon);
    
   
           

    

        } 
        else
        {
            System.out.println("error");
        }
        
    }
}
