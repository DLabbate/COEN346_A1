
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");

		FileHelper fileHelper = new FileHelper("C:\\Users\\domen\\Documents\\Concordia\\Winter 2020\\COEN_346\\Code\\COEN346_A1\\COEN346_A1\\src\\Input.txt");
		fileHelper.FillLightbulbArray();
		boolean lightbulbs[] = fileHelper.getLightbulbArray();
		
		//boolean lightbulbs[] = new boolean[8];
		/*
		lightbulbs[0] = true;
		lightbulbs[1] = true;
		lightbulbs[2] = false;
		lightbulbs[3] = true;
		lightbulbs[4] = true;
		lightbulbs[5] = false;
		lightbulbs[6] = true;
		lightbulbs[7] = true;
		*/
		
		LightBulbFinder lightBulbFinder = new LightBulbFinder(lightbulbs);
		//lightBulbFinder.FindDefective(0, 7);
		//lightBulbFinder.printNumThreads();
		
		Thread mainThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				lightBulbFinder.FindDefective(0, 7);
			}
		});
		mainThread.start();
		
		try
		{
			mainThread.join();
			lightBulbFinder.printNumThreads();
		}
		
		catch(Exception e)
		{
			System.out.println("THREADING EXCEPTION");
		}
		
	}
}
