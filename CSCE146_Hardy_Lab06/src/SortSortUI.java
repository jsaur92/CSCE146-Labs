//Written by Joe Hardy
import java.util.Scanner;

public class SortSortUI {
	
	private static Scanner input;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		startDialogue();
	}
	
	public static void startDialogue() {
		System.out.println("Enter any number of strings and I will sort by SORT’s.  Once you’re done entering sentences enter “quit”.");
		
		Queue<String> queue = new Queue<String>();
		
		String s = input.nextLine();
		while (!s.toLowerCase().equals("quit")) {
			queue.enqueue(s);
			s = input.nextLine();
		}
		
		String[] sorts = new String[queue.size()];
		
		for (int i = 0; i < sorts.length; i++) {
			sorts[i] = queue.dequeue();
		}
		
		SortSorter sorter = new SortSorter(sorts);
		sorter.sort();
		String[] sorted = sorter.toStringArray();
		
		System.out.println("sort SORTED!");
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i]);
		}
		
		endDialogue();
	}
	
	public static void endDialogue() {
		System.out.println("Would you like to sort more Strings? (type \"no\" to quit)");
		String answer = input.nextLine();
		if (answer.toLowerCase().equals("no")) {
			System.out.println("Goodbye!");
			System.exit(0);
		}
		else {
			startDialogue();
		}
	}
	
}
