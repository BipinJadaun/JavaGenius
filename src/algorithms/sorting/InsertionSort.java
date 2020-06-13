package algorithms.sorting;

import java.util.Arrays;

/**
 * @author bipin.kumar
 * Insertion sort algorithm works the way we sort playing cards in our hands.
 * the lower part of an array is maintained to be sorted. it selects an element from the unsorted part,
 * and finds it's appropriate place in sorted part and then it has to be inserted there.
 * it's an "In-place" and "Stable" sorting algorithm. It has an O(n^2) time complexity.
 */
public class InsertionSort {

	public static void main(String[] args) {

		int[] array = {20, 35, 7, -15, 55, 1, 9, -22};

		insertionSort(array, 0, array.length);

		System.out.println(Arrays.toString(array));
	}

	public static void insertionSort(int[] array, int start, int end) {
		for(int lastSortedIndex = start; lastSortedIndex < end; lastSortedIndex++) {
			int selected = array[lastSortedIndex];
			int i;
			for(i = lastSortedIndex; i > 0 && array[i-1] > selected ; i--) {
				array[i] = array[i-1];
			}
			array[i] = selected;
		}
	}
}
