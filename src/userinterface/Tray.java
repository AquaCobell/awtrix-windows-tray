package userinterface;

import java.awt.AWTException;
import java.awt.CheckboxMenuItem;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import Spotify.SpotifyController;
import main.Controller;
import model.Config;
import utils.Savecontroller;
import weather.Weather;



public class Tray 
{
   

    Controller contr;
    Config config;
    Gui gui;
    Savecontroller save;
   
 
       

    public Tray()
    {
        gui = new Gui();
        save = new Savecontroller();
        try 
        {
            config = save.loadsettings();
        } 
        catch (ClassNotFoundException e) {
           
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        

        if(config != null)
        {
            contr = new Controller(config.getUrl(), config.getToken(),config.getUserID());
            
        }
        else
        {
            contr = new Controller();  
        }
       
    }

    public void loadTray() throws AWTException
    {
        TrayIcon trayIcon = null;
      
        if(SystemTray.isSupported())
        {
            SystemTray tray = SystemTray.getSystemTray();

            
            Image image = Toolkit.getDefaultToolkit().getImage("icon.png");

            PopupMenu popup = new PopupMenu();

            Menu programs = new Menu("Programs");

            CheckboxMenuItem spotify= new  CheckboxMenuItem("Activate Spotify");
            CheckboxMenuItem discord= new  CheckboxMenuItem("Activate Discord");
            
             
            
            Menu settings = new Menu("Settings");

            Menu discordsettings = new Menu("Discord");
            Menu spotifysettings = new Menu("Spotify");
            Menu generalsettings = new Menu("General");


            MenuItem setAdress = new MenuItem("Set IP");
            MenuItem progressBar = new MenuItem("Disable Progress Bar");

            MenuItem setToken = new MenuItem("Set Discord Token");
            MenuItem setDiscordUserId = new MenuItem("Set Discord UserID");

            MenuItem saveSettings = new MenuItem("Safe all Settings");
            MenuItem loadSettings = new MenuItem("Load all Settings");



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
                   
                    System.out.println("Test");
               
                    spotify.setLabel("Disable Spotify");
                   
                
                    spotify.setLabel("Enable Spotify");
                  
                   
  
                }
                
            });


             setAdress.addActionListener(new ActionListener() 
             {

                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    String ip = gui.enterIP();
                    System.out.println("Got" + ip);
                    contr.setURL(ip);
                    contr.reloadApps();
                     
                }
                
            }
            );

            setToken.addActionListener(new ActionListener() 
            {

                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    String Token = gui.enterToken();
                    System.out.println("Got" + Token);
                    contr.setToken(Token);
                    contr.reloadApps();
                     
                }
                
            }
            );

            setDiscordUserId.addActionListener(new ActionListener() 
            {

                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    String UserID = gui.enterUserID();
                    System.out.println("Got" + UserID);
                    contr.setUserID(UserID);
                    contr.reloadApps();
                     
                }
                
            }
            );

            saveSettings.addActionListener(new ActionListener() 
            {
                
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    contr.safeSettings();
                     
                }  

            });

            loadSettings.addActionListener(new ActionListener() 
            {
                
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    contr.loadSettings();
                }  
            });


            discord.addItemListener(new ItemListener() 
            {
             
                @Override
                public void itemStateChanged(ItemEvent e)
                {
                     System.out.println("Triggered");
                    if(contr.getDiscordStatus() == false)
                    {
                        System.out.println("Activating Discord");
                        discord.setState(true);
                        discord.setLabel("Deactivate Discord");
                        contr.enableDiscord();
                    }
                    else
                    {
                        System.out.println("Deactivating Discord");
                        discord.setState(false);
                        discord.setLabel("Activate Discord");
                        contr.disableDiscord();
                    }

                }



            });


            popup.add(spotify);
            popup.add(discord);
            popup.add(settings);

            
            popup.add(exit);
            settings.add(generalsettings);
            settings.add(discordsettings);
            settings.add(spotifysettings);

            generalsettings.add(setAdress);
            discordsettings.add(setToken);
            discordsettings.add(setDiscordUserId);

            settings.add(saveSettings);
            settings.add(loadSettings);






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
