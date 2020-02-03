
public class LightBulbFinder {
	protected boolean lightbulbs[];
	
	public LightBulbFinder(boolean lightbulbs[])
	{
		//System.out.println("hello");
		this.lightbulbs = lightbulbs;
	}
	
	public void FindDefective(int start,int end)
	{
		if (start == end)
		{
			System.out.println("Bulb #: "+start+1+" is defective");
			return;
		}
		
		else if ((end - start) == 1)
		{
			if ((lightbulbs[start] == true) && (lightbulbs[end] == true))
			{
				return;
			}
		}
		
		
		else
		{
			int pivot = (end - start)/2;
			FindDefective(start,pivot);
			FindDefective(pivot+1,end);
		}
		
	}

}
