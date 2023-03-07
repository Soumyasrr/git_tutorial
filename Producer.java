class Producer extends Thread
{
	Company c;

	Producer(Company c) // we pass Company object when we create Producer object 
	{
		this.c = c; // we assign this Company object to Company object of Producer class
	}
	public void run()
	{
		int i = 1;
		while(true)
		{
			
			try{this.c.produce_item(i);
			Thread.sleep(1000);}catch(Exception e){}
			i++;
			
		}
	}
}