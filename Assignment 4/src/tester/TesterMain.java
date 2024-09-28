package tester;

import oh.BigInteger;

public class TesterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger a = new BigInteger(123456789);
		BigInteger b = new BigInteger(7891011);
		
		// TEST 1: TOSTRING
		System.out.println(a.toString());
		System.out.println(b.toString());
		
		// TEST 2: MOD METHOD
		System.out.println(a.toString() + " % " + b.toString() + ": " + a.mod(b));
		
		// TEST 3: ADD METHOD
		System.out.println(a.toString() + " + " + b.toString() + ": " + a.add(b));
	}

}
