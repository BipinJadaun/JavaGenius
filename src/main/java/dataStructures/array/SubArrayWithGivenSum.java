package dataStructures.array;

/*
Given an unsorted array A of size N that contains integers,
find a continuous sub-array which adds to a given number S.
 */

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {

         int[] arr = new int[]{1, 2, 3, 7, 5, 4, 6};   // sum: 12

        int[] arr1 = new int[]{1, 2, 3, 7, 5, 4, 6, -3};   // sum: 12

        printSubArrayWithGivenSum(arr, arr.length, 12);

        printSubArrayWithGivenSumWithNegatives(arr1, 12);

    }

    static void printSubArrayWithGivenSum(int[] arr, int n, int s){
        int currSum=0;
        int start = 0;
        int end = 0;
        int count = 0;

        while(end < n) {
            if (currSum < s) {
                currSum = currSum + arr[end++];
            }
            if(currSum > s) {
                while(currSum > s)
                    currSum = currSum - arr[start++];
            }
            if(currSum == s){
                printSubArray(arr, start, end);
                count++;
                if(end < n){
                    currSum = currSum - arr[start++];
                }
            }
        }
        if(count == 0) {
            System.out.println(-1);
        }
    }

    //1, 2, 3, 7, 5, 4, 6, -3
    static void printSubArrayWithGivenSumWithNegatives(int[] nums, int k) {
        int start = 0, end = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                
            }
        }
    }

    private static void printSubArray(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
