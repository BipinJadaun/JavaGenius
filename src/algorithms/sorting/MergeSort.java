package algorithms.sorting;

/**
 * @author Bipin Jadaun
 * MergeSort leverages the "divide-and-conquer" principle. wherein we first divide the problem into sub-problems.
 * When the solutions for the sub-problems are ready, we combine them together to get the final solution to the problem.
 * Divide: In this step, we divide the input array into 2 halves, the pivot being the midpoint of the array.
 * 			This step is carried out recursively for all the half arrays until there are no more half arrays to divide.
 * Conquer: In this step, we sort and merge the divided arrays from bottom to top and get the sorted array.
 * * It's not "In-place" but "Stable" sorting algorithm. It has an  O(nlogn) time complexity.
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] array = new int[]{20, 35, 7, -15, 55, 1, 9, -22};
		//int[] array = new int[]{20, 35, 7};

		mergeSort(array, 0, array.length);

		for (int value : array) {
			System.out.println(value);
		}
	}

	public static void mergeSort(int[] arr, int start, int end){
		//Base Case: if array partition has only 1 value, return
		if(end - start < 2){
			return;
		}
		int mid = (start + end) / 2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid, end);
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
			//copy the elements from both the arrays in sorted order
			tempArr[tempIndex++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
		}
		// Optimization2: we need to copy the remaining elements only from left array to the main array
		// because the remaining element of right array are greater than last element in temp array
		// and already will be at their correct positions in main array

		while(i < mid){
			tempArr[tempIndex++] = arr[i++];
		}
		//alternatively we can add remaining elements of left array directly to main array
		//System.arraycopy(arr, i, arr, start + tempIndex, mid -i);

		//finally add the sorted element from temp array to main array.
		System.arraycopy(tempArr, 0, arr, start, tempIndex);
	}
}
