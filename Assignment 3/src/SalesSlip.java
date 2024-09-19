import java.util.ArrayList;

public class SalesSlip {
	
	private ArrayList<SalesItem> ss = new ArrayList<>();
	
	public SalesSlip(SalesItem item) {
		ss.add(item);
	}
	
	// method to generate result string
	public String toString() {
		String ans = "";
		for (int i = 0; i < ss.size(); i++) {
			ans = ans + "\n" + ss.get(i).getName() + "   " + "$" + ss.get(i).getPrice() * ss.get(i).getQuantity() + "   " + ss.get(i).getQuantity();
		}
		return ans;
	}
	
	// method to add total price
	public double addTotal() {
		double ans = 0;
		for(int i = 0; i < ss.size(); i++) {
			ans += ss.get(i).getPrice() * ss.get(i).getQuantity();
		}
		return ans;
	}
}
