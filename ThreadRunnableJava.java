class ThreadRunnableJava
{
	public static void main(String[] args) 
	{
		// ThreadDemo td = new ThreadDemo();

		// RunnableDemo rd = new RunnableDemo();
		// Thread thread = new Thread(rd);
		// td.start();
		// thread.start();
		// System.out.println(td.getName());
		// System.out.println(thread.getName());
		// System.out.println(td.getPriority());
		// System.out.println(thread.getPriority());
		// System.out.println(td.getId());
		// System.out.println(thread.getId());

		Thread t = Thread.currentThread();
		System.out.println(t.getName());

	}
}