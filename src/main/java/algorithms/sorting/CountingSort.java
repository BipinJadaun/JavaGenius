package algorithms.sorting;

import java.util.Arrays;

/**
 * @author Bipin Jadaun
 * CountingSort sorts the elements by counting the number of occurrences of each element in the array.
 * The count is stored in a temp array.
 * The sorting is done by mapping the count as an index of the temp array.
 * Counting sort only works when elements are non-negative, integers and the range of elements is known.
 * and the variation in elemets is not significantly greater than the number of elemets.
 */
public class CountingSort {
    public static void main(String[] args) {
        //an array where elements are between 5 to 15.
        int[] array = {5, 9, 15, 13, 6, 8, 11, 5, 12, 10, 14, 7};

        countingSort(array, 5, 15);

        System.out.println(Arrays.toString(array));
    }

    public static void countingSort(int[] array, int min, int max) {
        //since input array is ranging between 5 to 15(both inclusive) so counting array will be of size 11.
        int[] countingArray = new int[(max - min) + 1];

        // the countingArray will store count of 5s at 0th position, count of 6s at 1st and so on..
        for (int value : array) {
            countingArray[value - min]++;
        }

        int j = 0;
        for(int i = min; i <= max; i++){
            //in case an element occurred more than once
            while(countingArray[i - min] > 0){
                array[j++] = i;
                countingArray[i - min]--;
            }
        }
    }
}
