package algorithms.sorting;
import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = new int[]{20, 35, 7, -15, 55, 1, 9, -22};

		sort(array, 0, array.length);

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static void sort(int[] arr, int start, int end){
		//Base Case: if array partition has only 1 value, return
		if(end - start < 2){
			return;
		}
		int mid = (start + end) / 2;
		sort(arr, start, mid);
		sort(arr, mid, end);
		merge(arr, start, mid, end);
	}

	//20, 35, 7, -15, 55, 1, 9, -22
	private static void merge(int[] arr, int start, int mid, int end) {
		// Optimisation1: while merging 2 sorted arrays,
		// if first element of second array is >= last element of first array
		// then elements of both the array's are already in its right position in main array
		if (arr[mid-1] <= arr[mid]){
			return;
		}
		int i = start;
		int j = mid;
		int tempIndex = 0;
		int[] tempArr = new int[end - start];
		// //20, 35, 7, -15, 55, 1, 9, -22
		while (i < mid && j < end){
			tempArr[tempIndex++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
		}
		// Optimization2: we need to copy the remaining elements only from left array to the main array
		// because the remaining element of right array are greater than last element in temp array
		// and will already in its right position in main array
		System.arraycopy(arr, i, arr, start + tempIndex, mid -i);
		System.arraycopy(tempArr, 0, arr, start, tempIndex);
	}
}
