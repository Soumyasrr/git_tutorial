class RunnableDemo implements Runnable
{
	public void run()
	{
		for(int i=0;i<=10;i++)
		{
			System.out.println("Ascend "+i);
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