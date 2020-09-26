package algorithms.sorting;

import java.util.Arrays;

/**
 * @author bipin.kumar
 * Shellsort is an optimization of insertion sort that allows the exchange of items that are far apart.
 * i.e if a smallest element is rightmost in array, insertion short will use n shifts to move it to it's appropriate postion.
 * In shell sort, elements at a specific gap are sorted. The gap between the elements is gradually decreased.
 * Finaly when the gap reduced to 1, it sorts the rest of the elements silmilarly as insertion sort.
 * it's an "In-place" and "Un-Stable" sorting algorithm. It has an O(n^2) time complexity.
 */

public class ShellSort {
    public static void main(String[] args) {

        int[] array = new int[]{20, 35, 7, -15, 55, 1, 9, -22};

        shellSort(array, 0, array.length);

        System.out.println(Arrays.toString(array));
    }

    public static void shellSort(int[] array, int start, int end) {
        for (int gap = end/2; gap > start ; gap/=2) {
            for (int i = gap; i < array.length; i++) {
                int key = array[i];
                int j = i;
                while (j >=gap && array[j-gap] > key){
                    array[j] = array[j-gap];
                    j -= gap ;
                }
                array[j] = key;
            }
        }
    }
}
