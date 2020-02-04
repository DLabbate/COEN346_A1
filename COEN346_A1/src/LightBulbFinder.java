
public class LightBulbFinder {
	protected boolean lightbulbs[];											//Lightbulb array
	int numThreads = 1;														//Number of threads, initialized to 1 to include main thread
	
	public LightBulbFinder(boolean lightbulbs[])							//Constructor, initializes array of lightbulbs
	{
		//System.out.println("hello");
		this.lightbulbs = lightbulbs;
	}
	
	public void FindDefective(int start,int end)
	{
		if (start == end)													//If sub-array is size 1, we check if lightbulb is functional or not
		{
			if (lightbulbs[start] == false)
			{
				int num = start +1;
				System.out.println("Bulb #: "+num+" is defective");
			}
			return;
		}
		
		else if ((end - start) == 1)										//If sub-array is size 2, and both elements are 1, we do not need to use recursion
		{
			if ((lightbulbs[start] == true) && (lightbulbs[end] == true))
			{
				return;
			}
		}
		
		int pivot = (end + start)/2;										//Pivot is the halfway point
		
		Thread leftThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				numThreads++;
				FindDefective(start,pivot);									//Call recursion on left half of array
			}
		});
		
		Thread rightThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				numThreads++;
				FindDefective(pivot+1,end);									//Call recursion on right half of array
			}
		});
		
		leftThread.start();													//Start left and right thread concurrently
		rightThread.start();
		try
		{
			leftThread.join();												//Wait for both left and right thread to finish
			rightThread.join();												//(before we move on to the next recursion level)
		}
		catch (Exception e)
		{
			System.out.println("THREADING EXCEPTION");
		}
	}
	
	public void printNumThreads()											//Returns the number of threads 
	{
		System.out.println("Number of Threads: "+numThreads);
	}
}
