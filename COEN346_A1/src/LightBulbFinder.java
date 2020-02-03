
public class LightBulbFinder {
	protected boolean lightbulbs[];
	int numThreads = 1;
	
	public LightBulbFinder(boolean lightbulbs[])
	{
		//System.out.println("hello");
		this.lightbulbs = lightbulbs;
	}
	
	public void FindDefective(int start,int end)
	{
		if (start == end)
		{
			if (lightbulbs[start] == false)
			{
				int num = start +1;
				System.out.println("Bulb #: "+num+" is defective");
			}
			return;
		}
		
		else if ((end - start) == 1)
		{
			if ((lightbulbs[start] == true) && (lightbulbs[end] == true))
			{
				return;
			}
		}
		
		int pivot = (end + start)/2;
		
		Thread leftThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				numThreads++;
				FindDefective(start,pivot);
			}
		});
		
		Thread rightThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				numThreads++;
				FindDefective(pivot+1,end);
			}
		});
		
		leftThread.start();
		rightThread.start();
		try
		{
			leftThread.join();
			rightThread.join();
		}
		catch (Exception e)
		{
			System.out.println("THREADING EXCEPTION");
		}
	}
	
	public void printNumThreads()
	{
		System.out.println("Number of Threads: "+numThreads);
	}
}
