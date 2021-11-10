package dataStructures.array;

import java.util.Arrays;

public class RearrangeArrayWithMaxAndMinAlternative {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        rearrange(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void rearrange(int arr[], int n){
        int start = 0, end = n-1;
        int i = 0;
        int[] temp = new int[n];
        while(start < end){
            int curMax = arr[end];
            int curMin = arr[start];
            temp[i] = curMax;
            temp[i+1] = curMin;

            i = i+2;
            start++;
            end--;
        }
        for (int j = 0; j < n; j++) {
            arr[j] = temp[j];
        }
    }
}
