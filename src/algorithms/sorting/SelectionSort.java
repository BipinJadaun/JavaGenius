package algorithms.sorting;

/**
 * @author bipin.kumar
 * The upper part of an array is maintained to be sorted.
 * The algorithm proceeds by finding the largest element in the unsorted sublist,
 * swaps it with the rightmost unsorted element (putting it in sorted order), 
 * and moving the unsorted sublist boundaries one element to the left.
 * selection sort is an "In-place" and "Unstable" sorting algorithm. It has an O(n^2) time complexity.
 */
public class SelectionSort {

	public static void main(String[] args) {
		
		int[] array = {20, 35, 7, -22, 55, 1, 9, -5};
		
		for(int lastSortedIndex = array.length-1; lastSortedIndex > 0; lastSortedIndex--) {
			int maxIndex = 0;
			for(int i = 1; i <= lastSortedIndex; i++) {
				if(array[i] > array[maxIndex]) {
					maxIndex = i;
				}
			}
			swap(array, maxIndex, lastSortedIndex);
		}
		
		for(int i : array) {
			System.out.println(i);
		}
	}
	
	public static void swap(int[] array, int i, int j) {
		if (i == j) {
			return;
		}
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
