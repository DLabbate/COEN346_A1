import java.io.*;
import java.util.Scanner;

public class FileHelper {
	Scanner scanner;
	boolean lightbulbs[];
	
	public FileHelper(String string)
	{
		
		try 
		{
			File file = new File(string);
			scanner = new Scanner(file);
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("FILE NOT FOUND!");
		}
		
	}
	
	public void FillLightbulbArray()
	{
		int size = scanner.nextInt();
		lightbulbs = new boolean[size];
		
		int count = 0;

		while (scanner.hasNextLine())
		{
			lightbulbs[count++] = (scanner.nextInt() == 1);
		//	System.out.print(scanner.nextLine());
		}
		scanner.close();
		
	}
	
	public boolean[] getLightbulbArray()
	{
		return lightbulbs;
	}
}
