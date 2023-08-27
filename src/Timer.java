public class Timer
{

    private long duration;
    private long starttime;
    private long expectedendtime;

    Timer(long duration)
    {
        this.duration = duration;
    }


    public void startTimer()
    {
        this.starttime = System.currentTimeMillis();
        expectedendtime = starttime+duration;
    }

    public void pauseTimer()
    {

    }
    
    public boolean checkend()
    {
        if(expectedendtime < System.currentTimeMillis())
        {
            System.out.println("ENDED");
            return true;
        }
        return false;
    }

    public long getPercentagetillEnd()
    {
       long second =(expectedendtime - starttime); //0%

        
       long current = System.currentTimeMillis(); //currentx in millis
    
       
       long y = expectedendtime - current;

       long ergebnis = (y*100)/second;
    
       long end = 100 - ergebnis;


       if(end > 100)
       {
        return 100;
       }
       return end;
      

      
    }
}