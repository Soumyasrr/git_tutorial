import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class chatServerNew
{
    ServerSocket ss;
    Socket soc;
    BufferedReader brClient;
    BufferedReader brServer;
    PrintWriter printOut;

    public chatServerNew()
    {
        try 
        {
            ss = new ServerSocket(8059);
            soc = ss.accept();
            brClient = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            printOut = new PrintWriter(soc.getOutputStream());
            startReading();
            startWriting();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }        
    }
    public void startReading()
    {
        Runnable r1 = ()->
        {
            System.out.println("Reader started");
            try
            {
                while(true)
                {
                    String strIn = brClient.readLine();
                    if(strIn.equals("exit"))
                    {
                        System.out.println("Client ended session");
                        break;
                    }
                    System.out.println("Client: "+strIn);

                }    
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }            
        };
        new Thread(r1).start();
    }
    
    public void startWriting()
    {
        Runnable r2 = ()->
        {
            System.out.println("Writer started");
            try
            {
                while(true)
                {
                    brServer = new BufferedReader(new InputStreamReader(System.in));
                    String outStr = brServer.readLine();
                    printOut.println(outStr);
                    printOut.flush();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        };
        new Thread(r2).start();
    }
    
    public static void main(String[] args) 
    {
        new chatServerNew();

    }    
}
