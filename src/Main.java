import java.awt.AWTException;
import java.util.List;
import java.util.ResourceBundle.Control;
import java.util.concurrent.TimeUnit;



import Discord.Discord;
import main.Controller;

import userinterface.Tray;
import utils.Sender;
import utils.Timer;


public class Main {
    public static void main(String[] args) throws InterruptedException 
    {
       
        
        Tray tray = new Tray();
        try {
            tray.loadTray();
        } catch (AWTException e) {
            
            e.printStackTrace();
        }

        /*SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer ha = si.getHardware();

        Sensors sensor = ha.getSensors();
        System.out.println(sensor.toString());

        */
       
  


    }

      



      


}