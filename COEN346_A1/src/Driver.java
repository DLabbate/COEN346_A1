//COEN 346 - ASSIGNMENT 1
//Written by:
//Domenic Labbate (40063296)
//Gianluca Lepore(40064389)


public class Driver {

	public static void main(String[] args) {
		
		System.out.println("COEN 346 - Assignment 1");
		
		FileHelper fileHelper = new FileHelper("src/Input.txt"); 			//Input File
		fileHelper.FillLightbulbArray(); 									//Read Input File
		boolean lightbulbs[] = fileHelper.getLightbulbArray();				//Returns the lighbulb array (boolean)
		
		LightBulbFinder lightBulbFinder = new LightBulbFinder(lightbulbs);	//Pass the lightbulb array to the LightBulbFinder reference
		
		Thread mainThread = new Thread(new Runnable() {						//MAIN THREAD
			
			@Override
			public void run() {
				lightBulbFinder.FindDefective(0,lightbulbs.length-1);		//Calls FindDefective 
			}
		});
		mainThread.start();
		
		try
		{
			mainThread.join();												//Wait for main thread to finish
			lightBulbFinder.printNumThreads();								//Print number of threads
		}
		
		catch(Exception e)
		{
			System.out.println("THREADING EXCEPTION");
		}
		
	}
}
