// Sean Oh
// CS-341-01
// 9/7/24

public class BigNumber {
	
	// store each digit in an array
	private int[] digits;
	
	public BigNumber(String n) {
		// reverse the digits to make adding easier
		digits = new int[n.length()];
		for (int i = 0; i < n.length(); i++) {
			digits[i] = Integer.parseInt(n.substring(n.length() - i - 1, n.length() - i));
		}
	}
	
	// add method
	public BigNumber add(BigNumber bn) {
		// size of result array
		int size = 0;
		
		// second array added to first array
		int[] second = bn.digits;
		
		// compare size of both arrays and set size to largest + 1 for carry
		if (digits.length > second.length) {
			size = digits.length + 1;
		}
		else {
			size = second.length + 1;
		}
		
		// array for addition digits
		int[] result = new int[size + 1];
		// carry
		int carry = 0;
		
		// for loop to add to result array
		for (int i = 0; i < size; i++) {
			// check array in bound
			int firstNum = 0;
			if (i < digits.length) {
				firstNum = digits[i];
			}
			int secondNum = 0;
			if (i < second.length) {
				secondNum = second[i];
			}
			
			// add
			int add = firstNum + secondNum + carry;
			// carry
			carry = add/10;
			result[i] = add % 10;
		}
		
		// last carry
		result[result.length - 1] = carry;
	
		// convert and reverse to String
		String num = "";
		// if carry = 1, add it to String, if 0 do not add
		if (result[result.length - 1] == 1) {
			num = "" + 1;
		}
		for (int i = result.length - 3; i >= 0; i--) {
			num = num + "" + result[i];
		}
		
		BigNumber ans = new BigNumber(num);
		return ans;
	}
	
	// returns the digit back into String
	public String getValue() {
		String ans = "";
		for (int i = digits.length - 1; i >= 0; i--) {
			ans = ans + "" + digits[i];
		}
		
		return ans;
	}
}
