package oh;

public class BigInteger {
	// DATA MEMBERS
	private int num;
	
	// EXPLICIT CONSTRUCTOR
	public BigInteger(int n) {
		num = n;
	}
	
	// MOD METHOD
	public BigInteger mod(BigInteger n) {
		BigInteger ans = new BigInteger(this.getNum() % n.getNum());
		return ans;
	}
	
	// ADD METHOD
	public BigInteger add(BigInteger n) {
		int ans = this.getNum() + n.getNum();
		BigInteger i = new BigInteger(ans);
		return i;
	}

	// SETTERS, GETTERS, TOSTRING, EQUALS
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public String toString() {
		return "" + num;
	}

}
