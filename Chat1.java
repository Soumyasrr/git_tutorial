import java.net.*;
import java.io.*;

class Chat1
{
	public static void main(String[] args) 
	{
		try
		{
			Socket soc = new Socket("localhost",8059);
			
			InputStream is = soc.getInputStream();
			DataInputStream in = new DataInputStream(is);

			OutputStream os = soc.getOutputStream();
			DataOutputStream out = new DataOutputStream(os);

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Chat started");
		
		while(true)
		{
			String uMsg = br.readLine();
			out.writeUTF(uMsg);
			String str = in.readUTF();
			System.out.println("Server "+str);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}