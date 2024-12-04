//Written by Joe Hardy
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
public class FileIOSolutions {
	
	final static int MAX_WORDS = 100;
	final static int MAX_TUBES = 100;
	
	//The input and output strings are the names of the files that the method will read from and write to.
	public static void pastTense(String input, String output) {
		
		String[] words = new String[MAX_WORDS];
		int word_count = 0;
		try {
			Scanner scanner = new Scanner(new File(input));
			
			//Make an array of strings, where each string is a word in the input file.
			while (scanner.hasNext() && word_count < words.length) {
				words[word_count] = scanner.next();
				word_count++;
			}
			
			//Iterate through the array of strings, replacing every instance of "is" with 'was".
			for (int i = 0; i < word_count; i++) {
				if (words[i].toLowerCase().equals("is")) {
					words[i] = "was";
				}
			}
			
			//Write a new file with a string from our new array on each line.
			try {
				FileWriter writer = new FileWriter(new File(output));
				for (int i = 0; i < word_count; i++) {
					writer.write(words[i] + "\n");
					System.out.print(words[i] + "\n");
				}
				writer.close();
				
				
			}
			catch (IOException e) {
				System.out.println(e);
			}
			
			scanner.close();
			
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}

	//The input string is the name of the file that the method will read from.
	public static double totalTubeVolume(String input)  {
		
		double totalVolume = 0;
		
		try {
			
			Scanner scanner = new Scanner(new File(input));
			
			//Iterate through each individual test tube.
			while (scanner.hasNextLine()) {
				String tube_line = scanner.nextLine();
				Scanner mini_scanner = new Scanner(tube_line);
				
				//Skip through the first two strings, which only give the word 'Tube' and the number tube it is.
				mini_scanner.next();
				mini_scanner.next();
				
				//Use the remaining elements to calculate the volume.
				double radius = mini_scanner.nextDouble();
				double height = mini_scanner.nextDouble();
				double volume = radius * radius * Math.PI * height;
				totalVolume += volume;
				
				mini_scanner.close();
				
			}
			
			scanner.close();
			
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
		}
		
		return totalVolume;
		
	}
	
}
