import java.io.*;
import java.util.Scanner;

public class FileHelper 										//*This class is used to help parse the Input.txt file
{		
	Scanner scanner;											//Using scanner to read input
	boolean lightbulbs[];
	
	public FileHelper(String string)
	{
		
		try 
		{
			File file = new File(string);
			scanner = new Scanner(file);						//Create scanner with appropriate file 
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("FILE NOT FOUND!");
		}
		
	}
	
	public void FillLightbulbArray()
	{
		int size = scanner.nextInt();							//Here we take the first line as the size of the lightbulb array
		lightbulbs = new boolean[size];
		
		int count = 0;

		while (scanner.hasNextLine())							//Next we parse through the lightbulb line by line
		{
			lightbulbs[count++] = (scanner.nextInt() == 1);		//Fill the lightbulb array
		//	System.out.print(scanner.nextLine());
		}
		scanner.close();
		
	}
	
	public boolean[] getLightbulbArray()						//Return the lightbulb array
	{
		return lightbulbs;
	}
}
