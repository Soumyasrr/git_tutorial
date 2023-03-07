
import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class chatClient extends JFrame
{
    Socket soc;
    BufferedReader brClient; //client writes
    BufferedReader brServer; //self write
    PrintWriter printOut; //server sends

    JLabel lbl1;
    JTextArea txa1;
    JTextField txt1;
    Font font;

    public chatClient()
    {
        try
        {
            lbl1 = new JLabel("Client");
            txa1 = new JTextArea();
            txt1 = new JTextField();
            font = new Font("Roboto",Font.PLAIN,20);

            soc = new Socket("192.168.0.102",8059);
            System.out.println("Connection made");

            brClient = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            printOut = new PrintWriter(soc.getOutputStream());
            
            createGUI();
            handleEvents();
            startReading();
            // startWriting();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    public void createGUI()
    {
        this.setTitle("Client Application");
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl1.setFont(font);
        txa1.setFont(font);
        txt1.setFont(font);

        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl1.setHorizontalTextPosition(SwingConstants.CENTER);
        lbl1.setVerticalTextPosition(SwingConstants.BOTTOM);
        lbl1.setIcon(new ImageIcon("clogo.png"));
        lbl1.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        txt1.setHorizontalAlignment(SwingConstants.CENTER);
        this.setLayout(new BorderLayout());
        txa1.setEditable(false);

        this.add(lbl1,BorderLayout.NORTH);
        JScrollPane jScrollPane = new JScrollPane(txa1);
        this.add(jScrollPane,BorderLayout.CENTER);
        
        this.add(txt1,BorderLayout.SOUTH);
        

        this.setVisible(true);
    }
    public void handleEvents()
    {
        txt1.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {

            }
            @Override
            public void keyPressed(KeyEvent e) 
            {
                                
            }
            @Override
            public void keyReleased(KeyEvent e) 
            {
                // System.out.println("Key released "+e.getKeyCode());
                if(e.getKeyCode()==10)
                {
                    String clientMessage = txt1.getText();
                    txa1.append("Me: "+clientMessage+"\n");
                    printOut.println(clientMessage);
                    printOut.flush();
                    txt1.setText("");
                    txt1.requestFocus();
                }        
            }
            
        });
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
                        // System.out.println("Server ended session");
                        JOptionPane.showMessageDialog(null,"Server Terminated chat");
                        txt1.setEnabled(false);
                        soc.close();
                        break;
                    }
                    // System.out.println("Server: "+strIn);
                    txa1.append("Server: "+strIn+"\n");
                    txa1.setCaretPosition(txa1.getDocument().getLength());

                }                    
            }
            catch (Exception e)
            {
                System.exit(0); 
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
                while(!soc.isClosed())
                {
                    brServer = new BufferedReader(new InputStreamReader(System.in));
                    String outStr = brServer.readLine();
                    printOut.println(outStr);
                    printOut.flush();
                    if(outStr.equals("exit"))
                    {
                        System.out.println("Client closed connection");
                        soc.close();
                        break;                        
                    }
                }                
            }
            catch (Exception e)
            {
                System.exit(0); 
            }            
        };
        new Thread(r2).start();
    }
    public static void main(String[] args) 
    {
        new chatClient();    
    }
}
