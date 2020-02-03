
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");

		
		boolean lightbulbs[] = new boolean[8];
		lightbulbs[0] = true;
		lightbulbs[1] = true;
		lightbulbs[2] = false;
		lightbulbs[3] = true;
		lightbulbs[4] = true;
		lightbulbs[5] = false;
		lightbulbs[6] = true;
		lightbulbs[7] = true;
	
		
		LightBulbFinder lightBulbFinder = new LightBulbFinder(lightbulbs);
		lightBulbFinder.FindDefective(0, 7);
	}
}
