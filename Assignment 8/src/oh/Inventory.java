package oh;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class Inventory implements Serializable {
	
	// Data members
	private HashMap<Integer, Textbook> inventory;
	private File file;
	
	public Inventory() {
		inventory = new HashMap<>();
		file = new File("inventory.ser");
		start();
	}
	
	// Serialization
	public void start() {
		try {
			ObjectInputStream a = new ObjectInputStream(new FileInputStream(file));
			inventory = (HashMap<Integer, Textbook>) a.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not find previous file.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error loading previous file.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error loading previous file.");
		}
	}
	
	public void save() {
		try (ObjectOutputStream a = new ObjectOutputStream(new FileOutputStream(file))) {
            a.writeObject(inventory);
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
	}
	
	// Method adding textbook to inventory
	public void addTextbook(int sku, String title, double price, int quantity) {
		if (inventory.containsKey(sku)) {
			System.out.println("Textbook already exists in inventory.");
		}
		else {
			Textbook t = new Textbook(sku, title, price, quantity);
			inventory.put(sku, t);
		}
	}
	
	// Method to remove textbook from inventory
	public void removeTextbook(int sku) {
		if (inventory.containsKey(sku)) {
			inventory.remove(sku);
		}
		else {
			System.out.println("Textbook does not exist in inventory.");
		}
	}
	
	// Display textbook
	public void displayTextbook(int sku) {
		if (inventory.containsKey(sku)) {
			System.out.println(inventory.get(sku));
		}
		else {
			System.out.println("Textbook is not in the inventory.");
		}
	}
	
	// Display inventory
	public void displayInventory() {
		for (Textbook t: inventory.values()) {
			System.out.println(t.toString());
		}
	}
}
