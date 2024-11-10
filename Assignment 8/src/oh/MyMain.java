package oh;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class MyMain {

	private JFrame frmTextbookInventoryApp;
	private JTextField sku;
	private JTextField title;
	private JTextField price;
	private JTextField quantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyMain window = new MyMain();
					window.frmTextbookInventoryApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTextbookInventoryApp = new JFrame();
		frmTextbookInventoryApp.setTitle("Textbook Inventory App");
		frmTextbookInventoryApp.setBounds(100, 100, 450, 300);
		frmTextbookInventoryApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTextbookInventoryApp.getContentPane().setLayout(null);
		
		sku = new JTextField();
		sku.setBounds(6, 30, 130, 26);
		frmTextbookInventoryApp.getContentPane().add(sku);
		sku.setColumns(10);
		
		title = new JTextField();
		title.setBounds(6, 93, 130, 26);
		frmTextbookInventoryApp.getContentPane().add(title);
		title.setColumns(10);
		
		price = new JTextField();
		price.setBounds(6, 160, 130, 26);
		frmTextbookInventoryApp.getContentPane().add(price);
		price.setColumns(10);
		
		quantity = new JTextField();
		quantity.setBounds(6, 229, 130, 26);
		frmTextbookInventoryApp.getContentPane().add(quantity);
		quantity.setColumns(10);
		
		JLabel skuLabel = new JLabel("Sku");
		skuLabel.setHorizontalAlignment(SwingConstants.CENTER);
		skuLabel.setBounds(37, 16, 61, 16);
		frmTextbookInventoryApp.getContentPane().add(skuLabel);
		
		JLabel titleLabel = new JLabel("Title");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(37, 78, 61, 16);
		frmTextbookInventoryApp.getContentPane().add(titleLabel);
		
		JLabel priceLabel = new JLabel("Price");
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setBounds(37, 146, 61, 16);
		frmTextbookInventoryApp.getContentPane().add(priceLabel);
		
		JLabel quantityLabel = new JLabel("Quantity");
		quantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		quantityLabel.setBounds(37, 215, 61, 16);
		frmTextbookInventoryApp.getContentPane().add(quantityLabel);
		
		JButton addBtn = new JButton("Add Textbook");
		addBtn.setBounds(264, 30, 155, 29);
		frmTextbookInventoryApp.getContentPane().add(addBtn);
		
		JButton removeBtn = new JButton("Remove Textbook");
		removeBtn.setBounds(264, 93, 155, 29);
		frmTextbookInventoryApp.getContentPane().add(removeBtn);
		
		JButton displayTextbookBtn = new JButton("Display Textbook");
		displayTextbookBtn.setBounds(264, 160, 155, 29);
		frmTextbookInventoryApp.getContentPane().add(displayTextbookBtn);
		
		JButton displayInventoryBtn = new JButton("Display Inventory");
		displayInventoryBtn.setBounds(264, 229, 155, 29);
		frmTextbookInventoryApp.getContentPane().add(displayInventoryBtn);
		
		// Functionality
		Inventory i = new Inventory();
		
		// Add Textbook
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i.addTextbook(Integer.parseInt(sku.getText()), title.getText(), Double.parseDouble(price.getText()), Integer.parseInt(quantity.getText()));
			}
		});
		
		// Remove Textbook
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i.removeTextbook(Integer.parseInt(sku.getText()));
			}
		});
		
		// Display Textbook
		displayTextbookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i.displayTextbook(Integer.parseInt(sku.getText()));
			}
		});
		
		// Display Inventory
		displayInventoryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i.displayInventory();
			}
		});
		
		/*
		 * Serialization is not working properly.
		 * Program does not store the inventory between executions of the program
		 */
	}
}
