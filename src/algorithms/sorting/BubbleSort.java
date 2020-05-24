package algorithms.sorting;

 /**
 * @author bipin.kumar
 * Bubble sort (or sinking sort) is a simple sorting algorithm that repeatedly steps through the list, 
 * compares adjacent elements and swaps them if they are in the wrong order. 
 * The pass through the list is repeated until the list is sorted. 
 * The algorithm is named for the way smaller or larger elements "bubble" to the top of the list.
 * it's an "In-place" and "Stable" sorting algorithm. It has an O(n^2) time complexity.
 */
public class BubbleSort {

	public static void main(String[] args) {
		
		int[] array = {20, 35, 7, -22, 55, 1, 9, -5};
		
		for(int lastSortedIndex = array.length-1; lastSortedIndex > 0; lastSortedIndex--) {
			for(int i = 0; i < lastSortedIndex; i++) {
				if(array[i] > array[i + 1]) {
					swap(array, i, i+1);
				}
			}
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
