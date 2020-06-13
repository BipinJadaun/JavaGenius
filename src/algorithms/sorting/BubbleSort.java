package algorithms.sorting;

import dataStructures.utils.Util;

import java.util.Arrays;

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

		bubbleSort(array, 0, array.length);

		System.out.println(Arrays.toString(array));
	}

	 public static void bubbleSort(int[] array, int start, int end) {
		 for(int lastSortedIndex = end-1; lastSortedIndex > start; lastSortedIndex--) {
			 for(int i = 0; i < lastSortedIndex; i++) {
				 if(array[i] > array[i + 1]) {
					 Util.swap(array, i, i+1);
				 }
			 }
		 }
	 }
}
