class Company
{
	int n;
//synchronized: no other thread will run untill produce_item has stopped
	boolean flag = false;
	synchronized public void produce_item(int n) throws Exception
	{
		if(flag == true)
		{
			wait();
		}
		this.n = n;
		System.out.println("Produce item no :"+this.n);
		flag = true;
		System.out.println("Flag "+flag);
		notify(); // lets other waiting thread know that his work is done
	}
	synchronized public int consume_item() throws Exception
	{
		if(flag == false)
		{
			wait();
		}
		System.out.println("Consume item no :"+this.n);
		flag = false;
		System.out.println("Flag "+flag);
		notify();
		return this.n;
	}
}