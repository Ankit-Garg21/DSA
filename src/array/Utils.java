package array;

public class Utils {

	public Utils() {
		// TODO Auto-generated constructor stub
	}
	
	public  <T> void printArray(T[] LA) {
		int n = LA.length;
		for (int i = 0; i < n; i++) {
			System.out.print("LA[" + i + "] = " + LA[i] + ", ");
		}
	}

}
