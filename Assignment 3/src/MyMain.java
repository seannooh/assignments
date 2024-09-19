import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class MyMain {

	private JFrame frame;
	private JTextField textFieldItem;
	private JTextField textFieldCost;
	private JTextField textFieldQuantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyMain window = new MyMain();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setTitle("Sales List");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelItem = new JLabel("Item:");
		labelItem.setBounds(56, 31, 61, 16);
		frame.getContentPane().add(labelItem);
		
		JLabel labelCost = new JLabel("Cost: $");
		labelCost.setBounds(56, 59, 61, 16);
		frame.getContentPane().add(labelCost);
		
		JLabel labelQuantity = new JLabel("Quantity:");
		labelQuantity.setBounds(56, 86, 61, 16);
		frame.getContentPane().add(labelQuantity);
		
		textFieldItem = new JTextField();
		textFieldItem.setBounds(129, 26, 280, 26);
		frame.getContentPane().add(textFieldItem);
		textFieldItem.setColumns(10);
		
		textFieldCost = new JTextField();
		textFieldCost.setBounds(129, 56, 163, 26);
		frame.getContentPane().add(textFieldCost);
		textFieldCost.setColumns(10);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(129, 83, 163, 26);
		frame.getContentPane().add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		JButton btnAdd = new JButton("Add Item to the Sales List");
		btnAdd.setBounds(74, 111, 272, 29);
		frame.getContentPane().add(btnAdd);
		
		JTextArea resultArea = new JTextArea();
		resultArea.setWrapStyleWord(true);
		resultArea.setLineWrap(true);
		resultArea.setBounds(42, 142, 365, 80);
		frame.getContentPane().add(resultArea);
		
		JLabel labelTotal = new JLabel("Total Sales:");
		labelTotal.setBounds(56, 238, 80, 16);
		frame.getContentPane().add(labelTotal);
		
		JTextArea totalArea = new JTextArea();
		totalArea.setBounds(138, 238, 149, 16);
		frame.getContentPane().add(totalArea);
		
		btnAdd.addActionListener(new ActionListener() {
			// error here
			// need to make the program keep running
			public void actionPerformed(ActionEvent e) {
				SalesItem item = new SalesItem(textFieldItem.getText(), Double.parseDouble(textFieldCost.getText()), Integer.parseInt(textFieldQuantity.getText()));
				SalesSlip slip = new SalesSlip(item);
				resultArea.setText(slip.toString());
				totalArea.setText("$" + slip.addTotal());
			}
		});
	}
}
