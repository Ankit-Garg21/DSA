package array;

import java.util.Arrays;

/**
 * @author Ankit_Garg18
 *
 */
public class Insert {

	public Insert() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arrayGrowth = 1;
		Integer[] LA = { 1, 3, 5, 7, 8 };
		int item = 10, k = 3;
		LA = Arrays.copyOf(LA, LA.length + arrayGrowth);
		System.out.println(LA.length);
		insert(LA, item, k);
	}

	public static void insert(Integer[] LA, int item, int k) {
		int n = LA.length;
		int j = n-2;
		Utils utils = new Utils();
		System.out.println("The original array elements are :\n");
		utils.printArray(LA);

		while (j >= k) {
			LA[j + 1] = LA[j];
			j = j - 1;
		}

		LA[k] = item;
		utils.printArray(LA);
	}

}
