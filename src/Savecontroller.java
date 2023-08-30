import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Savecontroller 
{

    Savecontroller()
    {

    }

    public void safesettings(Config conf) 
    {
        // private static final String filepath="C:\\Users\\nikos7\\Desktop\\obj";
        
        try
        {   
            FileOutputStream fileOut = new FileOutputStream("settings.obj");  
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(conf);
            objectOut.close();  
            System.out.println("Serien gespeichert");
            
        }
        catch(Exception e)
        {
            System.out.println("Beim Speichern ist ein Fehler aufgetreten." + e);
        }
        
    }

    public Config loadsettings() throws IOException, ClassNotFoundException 
    {
         Object obj = null;
       

            FileInputStream fileIn = new FileInputStream("settings.obj");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            obj = objectIn.readObject();
           
            objectIn.close();
       
    
        return (Config) obj;
 
           
            
            
    }
}
