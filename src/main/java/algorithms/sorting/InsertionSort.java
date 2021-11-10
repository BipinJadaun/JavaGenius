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

		insertionSort(array);

		System.out.println(Arrays.toString(array));
	}

	//20, 19, 7, -15, 55, 1, 9, -22
	public static void insertionSort(int[] array) {
		for(int i = 1; i < array.length; i++) {
			int selected = array[i];
			int j;
			for(j = i; j > 0 && selected < array[j-1]; j--) {
				array[j] = array[j-1];
			}
			array[j] = selected;
		}
	}
}
