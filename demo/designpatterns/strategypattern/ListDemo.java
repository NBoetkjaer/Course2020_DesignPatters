package demo.designpatterns.strategypattern;

import java.util.*;
import java.io.*;

public class ListDemo {

	public static void main(String[] args) {

		// Declare a List variable (List is an interface in Java).
		List<String> myList = null;

		// Create either an ArrayList or a LinkedList.
		if (args.length != 1) {
			System.out.println("Usage:  java ListDemo -arraylist | -linkedlist");
			System.exit(0);
		} 
		else if (args[0].toLowerCase().equals("-arraylist")) {
			myList = new ArrayList<String>();
		} 
		else if (args[0].toLowerCase().equals("-linkedlist")) {
			myList = new LinkedList<String>();
		} 
		else {
			System.out.println("Usage:  java ListDemo -arraylist | -linkedlist");
			System.exit(0);
		}

		// Use the List object.
		doDemo(myList);
	}

	private static void doDemo(List<String> myList) {

		// Ask user to enter some items (enter "quit" to stop).
		String item;
		do {
			System.out.print("Enter an item: ");
			item = inputStr();

			if (!item.equals("quit")) {
				myList.add(item);
			}
		} while (!item.equals("quit"));

		// Set items at particular positions.
		myList.add(0, "Huey");
		myList.add(1, "Lewey");
		myList.add(2, "Dewey");

		// Get items at particular positions
		System.out.println(myList.get(0));
		System.out.println(myList.get(1));
		System.out.println(myList.get(2));

		// Loop through the items in the list, by using an Iterator.
		// This is the standard way to loop through sets and lists.

		System.out.println("\nHere are the items, in sequential order:");
		Iterator<String> iter = myList.iterator();
		while (iter.hasNext()) {
			String s = iter.next();
			System.out.println("\t" + s);
		}
	}

	private static String inputStr() {
		String str = "";

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			str = br.readLine();
		} 
		catch (IOException ex) {
		}

		return str;
	}
}
