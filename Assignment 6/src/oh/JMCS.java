package oh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class JMCS {
	
	// DATA MEMBERS
	private File inputFile;
	private ArrayList<String> catalog;
	
	// CONSTRUCTOR
	public JMCS(File inputFile) {
		this.inputFile = inputFile;
		catalog = new ArrayList<>();
	}
	
	public void buildCatalog() {
		
		// CREATE A SCANNER TO READ THE FILE
		Scanner fileInputScan = null;
		
		// OPENS THE SCANNER TO THE INPUT FILE AND SEARCHES FOR CATALOG ELEMENTS
		try {
			fileInputScan = new Scanner(inputFile);
			search(fileInputScan);
		} catch (FileNotFoundException e) {
			System.out.println("Error - This file could not be found.");
		} finally {
			if (fileInputScan != null) {
				fileInputScan.close();
			}
		}
	}
	
	// SEARCH UTILITY: FINDS CLASSES, METHODS, AND CONTROL STRUCTURES
	private void search(Scanner fileInputScan) {
		catalog = new ArrayList<>();
		Stack<String> stack = new Stack<>();
		String codeLine = "";
		String possibleMCS = ""; // Possible Method, Class, or Structure
		
		while(fileInputScan.hasNextLine()) {
			// TASK 1: GRAB A SINGLE LINE OF CODE AND TRIM WHITESPACE FROM FRONT
			codeLine = fileInputScan.nextLine();
			codeLine = codeLine.trim();
			
			// TASK 2: CHECK IF THE CODELINE IS THE START OF AN MCS
			if (codeLine.length() > 0) {
				if (!codeLine.equals("{") && !codeLine.equals("}")) {
					possibleMCS = codeLine;
				}
				else if (codeLine.equals("{")) {
					stack.push(possibleMCS);
				}
				else {
					catalog.add(0, stack.pop());
				}
			}
		}
		
	}
	
	public String toString() {
		String MCSString = "";
		for (int i = 0; i < catalog.size(); i++) {
			MCSString += catalog.get(i) + "\n";
		}
		
		return MCSString;
	}

}