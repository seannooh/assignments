import java.awt.EventQueue;

/**
 * @author Sean Oh
 * @version 1.0
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyMain {

	private JFrame frmScrabbleApp;
	private JTextField word;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyMain window = new MyMain();
					window.frmScrabbleApp.setVisible(true);
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
		frmScrabbleApp = new JFrame();
		frmScrabbleApp.setTitle("Scrabble App");
		frmScrabbleApp.setBounds(100, 100, 450, 300);
		frmScrabbleApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScrabbleApp.getContentPane().setLayout(null);
		
		JLabel instructions = new JLabel("Enter 7 letters.");
		instructions.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		instructions.setHorizontalAlignment(SwingConstants.CENTER);
		instructions.setBounds(0, 22, 450, 44);
		frmScrabbleApp.getContentPane().add(instructions);
		
		word = new JTextField();
		word.setBounds(6, 66, 438, 26);
		frmScrabbleApp.getContentPane().add(word);
		word.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(160, 104, 117, 29);
		frmScrabbleApp.getContentPane().add(btnEnter);
		
		JTextArea answer = new JTextArea();
		answer.setLineWrap(true);
		answer.setBounds(12, 145, 432, 121);
		frmScrabbleApp.getContentPane().add(answer);
		
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// check if the input is correct
				if (word.getText().length() > 7 || word.getText().length() < 7) {
					answer.setText("input error");
				}
				else if (word.getText().matches(".*\\d.*")) {
					answer.setText("input error");
				}
				else {
					answer.setText(generate(word.getText()));
				}
			}
		});
	}
	
	/**
	 * Method to generate all of the permutations of the 7 letters
	 * 
	 * @param s 7 letter word
	 * @return A string with all the permutations
	 */
	public String generate(String s) {
		String ans = "";
		for (int i = 0; i < s.length(); i++) {
			String c = "" + s.charAt(i);
			String temp = s.substring(0,i) + s.substring(i+1);
			for (int j = 0; j < temp.length(); j++) {
				ans = ans + " " + temp.substring(0,j) + c + temp.substring(j);
			}
			ans = ans + " " + temp + c;
		}
		return ans;
	}
}
