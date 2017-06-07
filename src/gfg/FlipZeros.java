package gfg;

public class FlipZeros {

	public FlipZeros() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int arr[] = { 1, 0, 0, 1, 1, 0, 1, 0, 1, 1 };
		int m = 2;
		int n = arr.length;
		findZeroes(arr, n, m);
	}

	private static void findZeroes(int[] arr, int n, int m) {
		// TODO Auto-generated method stub
		int left = 0, right = 0, zeros = 0, window = 0;
		int leftPos = 0, rightPos = 0;
		while(right < n) {
			if(zeros <= m) {
				if(arr[right] == 0) {
					zeros++;
				}
				right++;
			}
			
			if(zeros > m) {
				if(arr[left] == 0) {
					zeros--;
				}
				left++;
			}
			
			if(right - left > window) {
				window = right - left;
				leftPos = left;
				rightPos = right;
			}
		}
		
		System.out.println(leftPos + " " + (rightPos-1));
		
		for(int i = leftPos; i<rightPos; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
