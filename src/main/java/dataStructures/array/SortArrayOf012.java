package dataStructures.array;

import java.util.Arrays;

public class SortArrayOf012 {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 1, 2, 0};
        sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int length) {
        int[] count = new int[3];
        for(int i : arr){
            count[i]++;
        }
        int j=0, n=0;
        while(j < count.length){
            for(int i=0; i < count[j]; i++){
                arr[n++] = j;
            }
            j++;
        }
    }
}
