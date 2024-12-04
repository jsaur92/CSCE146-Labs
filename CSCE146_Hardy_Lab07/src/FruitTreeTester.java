//Written by Joe Hardy

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FruitTreeTester {
	
	private static LinkedBST<Fruit> tree;
	private static Scanner input;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		tree = new LinkedBST<Fruit>();
		startDialogue();
	}
	
	private static void startDialogue() {
		System.out.println("Welcome to the fruit tree!");
		System.out.println("Please enter a Fruit File Name");
		
		String filename = input.nextLine();
		
		try {
			setTree( new Scanner(new File(filename)) );
		} catch (FileNotFoundException e) {
			System.out.println("Sorry, I couldn't find that.");
			startDialogue();
		}
		
		tree.printInOrder();
		System.out.println();
		
		tree.printPreOrder();
		System.out.println();
		
		tree.printPostOrder();
		System.out.println();
		
		tree.remove(new Fruit("Apple", 0.4859853412170728));
		System.out.println("Deleting Apple\t0.4859853412170728");
		tree.printInOrder();
		
	}
	
	private static void setTree(Scanner fileScanner) {
		System.out.println("Populating the tree file");
		while (fileScanner.hasNext()) {
			String[] parts = fileScanner.nextLine().split("\t");
			if (parts.length == 2) {
				tree.add( new Fruit(parts[0], Double.parseDouble(parts[1])) );
			}
		}
	}
	
}
