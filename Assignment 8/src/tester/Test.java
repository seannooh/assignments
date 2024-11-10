package tester;

import oh.Inventory;
import oh.Textbook;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Test 1: Generate 2 new textbook objects
		Textbook textbook1 = new Textbook(1, "Book1", 9.99, 1);
		Textbook textbook2 = new Textbook(2, "Book2", 10.99, 2);
		System.out.println(textbook1.toString());
		System.out.println(textbook2.toString());
		
		// Test 2: Display inventory
		Inventory inventory = new Inventory();
		inventory.displayInventory();
		
		// Test 3: Remove a textbook
		inventory.removeTextbook(2);
		inventory.displayInventory();
	}
}