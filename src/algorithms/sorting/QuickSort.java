package algorithms.sorting;

import java.util.Arrays;

/**
 * @author Bipin Jadaun
 * Quicksort leverages the "divide-and-conquer" principle.
 * An element from the array is used as pivot to divide the list into two sub-lists.
 * The elements from the array are reordered in such a way that –
 * The smaller elements are placed left to pivot, and greater elements are placed right.
 * After this step, the pivot is in its sorted position. This is the important partition step.
 * The above steps used recursively on both sub arrays on the left and right of the pivot.
 * It's an "In-place" but "Un-Stable" sorting algorithm. It has an  O(nlogn) time complexity.
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {20, 35, 7, -15, 55, 1, 9, -22};

		 quickSort(arr, 0, arr.length);

		 System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int start, int end) {
		if(start < end) {
			int p = partition(arr, start, end);
			quickSort(arr, start, p);
			quickSort(arr, p + 1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[start];
		int i = start;
		int j = end;
		
		while(i < j) {
			//empty loop from end (decrementing first because j is equals to array's length)
			//to find element smaller than pivot. After this loop j'th element will be smaller than pivot.
			while (i < j && arr[--j] >= pivot) ;

			if (i < j) {
				arr[i] = arr[j];
			}

			//empty loop from start (incrementing first because i is pivot)
			//to find element greater than pivot. After this loop i'th element will be greater than pivot.
			while (i < j && arr[++i] <= pivot) ;

			if (i < j) {
				arr[j] = arr[i];
			}
		}
		//now j is the position where all the elements smaller than pivot are at left side of j
		// and all the elements greater than pivot are at right side of j.
		// so J is the correct and sorted position for pivot.

		arr[j] = pivot;
		return j;
	}
}
