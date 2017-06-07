package gfg;

import java.util.Arrays;

public class Kadane {

	public Kadane() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
	}

	private static int maxSubArraySum(int[] a) {
		int size = a.length;
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
		
		Integer[] LA = {};
		int arrayGrowth = 1;

		for (int i = 0; i < size; i++) {
			max_ending_here = max_ending_here + a[i];
			if(max_so_far < max_ending_here) {
			    max_so_far = max_ending_here;
			    LA = Arrays.copyOf(LA, LA.length + arrayGrowth);
			    LA[LA.length - 1] = i;
			}
			if(max_ending_here < 0) {
			    max_ending_here = 0;
			}
		}
		
		for (int i = 0; i < LA.length; i++) {
			System.out.print(LA[i] + " ");
		}
		
		return max_so_far;
	}
}
