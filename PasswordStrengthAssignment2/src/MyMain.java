import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 * 
 * @author seanoh
 * @version 1.0
 *
 */
public class MyMain {

	private JFrame frmPasswordStrengthApp;
	private JTextField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyMain window = new MyMain();
					window.frmPasswordStrengthApp.setVisible(true);
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
		frmPasswordStrengthApp = new JFrame();
		frmPasswordStrengthApp.setTitle("Password Strength App");
		frmPasswordStrengthApp.setBounds(100, 100, 450, 300);
		frmPasswordStrengthApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPasswordStrengthApp.getContentPane().setLayout(null);
		
		JLabel instructions = new JLabel("Enter Password");
		instructions.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		instructions.setHorizontalAlignment(SwingConstants.CENTER);
		instructions.setBounds(6, 20, 444, 52);
		frmPasswordStrengthApp.getContentPane().add(instructions);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(25, 75, 402, 26);
		frmPasswordStrengthApp.getContentPane().add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JButton btn = new JButton("Check Password");
		btn.setBounds(141, 119, 180, 29);
		frmPasswordStrengthApp.getContentPane().add(btn);
		
		JTextArea answer = new JTextArea();
		answer.setLineWrap(true);
		answer.setBounds(43, 167, 363, 73);
		frmPasswordStrengthApp.getContentPane().add(answer);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// check length of input
				if (passwordTextField.getText().length() < 8 || passwordTextField.getText().length() > 12) {
					answer.setText("Enter a password with length between 8 and 12.");
				}
				// check if contains space
				else if (passwordTextField.getText().contains(" ")) {
					answer.setText("Enter password without a space.");
				}
				// check password strength if input is correct
				else {
					answer.setText(checkPassword(passwordTextField.getText()));
				}
			}
		});
	}
	
	/**
	 * 
	 * @return a String with the password strength
	 * @param s the password inputed by user
	 */
	public String checkPassword(String s) {
		// ArrayList to hold the blocks
		ArrayList<Integer> blocks = new ArrayList<>();
		// counter
		int counter = 0;
		
		// check each character in String s
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i+1)) {
				counter++;
			}
			else {
				counter++;
				blocks.add(counter);
				counter = 0;
			}
		}
		
		// find the largest block in String s
		int max = 0;
		for (int i = 0; i < blocks.size(); i++) {
			if (blocks.get(i) > max) {
				max = blocks.get(i);
			}
		}
		
		// output
		if (max <= 2) {
			return "The largest block in the password is " + max + ". This is a decent password";
		}
		else {
			return "The largest block in the password is " + max + ". This password can be made stronger by reducing this block by " + (max - 2) + ".";
		}
	}
}
