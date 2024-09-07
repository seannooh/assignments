// Sean Oh
// CS-341-01
// 9/7/24

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Window.Type;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BigNumberApp {

	private JFrame frmBigNumberAdder;
	private JTextField xTextField;
	private JTextField yTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BigNumberApp window = new BigNumberApp();
					window.frmBigNumberAdder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BigNumberApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBigNumberAdder = new JFrame();
		frmBigNumberAdder.setTitle("Big Number Adder");
		frmBigNumberAdder.setBounds(100, 100, 450, 300);
		frmBigNumberAdder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBigNumberAdder.getContentPane().setLayout(null);

		JLabel topLabel = new JLabel("Enter ONLY positive integers");
		topLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		topLabel.setHorizontalAlignment(SwingConstants.CENTER);
		topLabel.setBounds(68, 25, 341, 51);
		frmBigNumberAdder.getContentPane().add(topLabel);

		xTextField = new JTextField();
		xTextField.setBounds(62, 80, 382, 26);
		frmBigNumberAdder.getContentPane().add(xTextField);
		xTextField.setColumns(10);

		yTextField = new JTextField();
		yTextField.setBounds(62, 116, 382, 26);
		frmBigNumberAdder.getContentPane().add(yTextField);
		yTextField.setColumns(10);

		JLabel xLabel = new JLabel("X");
		xLabel.setHorizontalAlignment(SwingConstants.CENTER);
		xLabel.setBounds(36, 85, 25, 16);
		frmBigNumberAdder.getContentPane().add(xLabel);

		JLabel yLabel = new JLabel("Y");
		yLabel.setHorizontalAlignment(SwingConstants.CENTER);
		yLabel.setBounds(39, 121, 19, 16);
		frmBigNumberAdder.getContentPane().add(yLabel);

		JButton addBtn = new JButton("Add");
		addBtn.setBounds(167, 163, 117, 29);
		frmBigNumberAdder.getContentPane().add(addBtn);

		JTextArea answer = new JTextArea();
		answer.setBounds(6, 199, 438, 67);
		frmBigNumberAdder.getContentPane().add(answer);

		// ActionListener for button
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// try catch error
				try {
					// instantiate object
					BigNumber x = new BigNumber(xTextField.getText());
					BigNumber y = new BigNumber(yTextField.getText());
					BigNumber z = x.add(y);
					answer.setText(z.getValue());
				// if xTextField or yTextField not an integer, set error message
				} catch (Exception e2) {
					answer.setText("input error");
				}
			}
		});
	}
}