package array;

public class vipulkasort {

	int[] numbers = { 1, 8, 3, 2, 0, 9, 4, 7, 5, 6 };
	
	public vipulkasort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		vipulkasort q = new vipulkasort();
		q.quicksort(0, 9);
		
		
	}

	private void quicksort(int low, int high) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		int pivot = high;
	}

	private void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
