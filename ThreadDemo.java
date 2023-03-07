class ThreadDemo extends Thread
{
	public void run()
	{
		try
		{
			Thread.sleep(500);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		for(int i=10;i>=0;i--)
		{
			System.out.println("Desc "+i);
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}