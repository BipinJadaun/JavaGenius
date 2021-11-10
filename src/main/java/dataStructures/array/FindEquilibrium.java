package dataStructures.array;

/*
Given an array A of n positive numbers. The task is to find the first Equilibium Point in the array.
Equilibrium Point in an array is a position such that the sum of elements before it is equal to the sum of elements after it.
 */

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FindEquilibrium {
    public static void main(String[] args) {
        long[] arr = new long[]{20,17,42,25,32,32,30,32,37,9,2,33,31,17,14,40,9,12,36,21,8,33,6,6,10,37,12,26,21,3};
        System.out.println(findEquilibrium(arr, arr.length));
    }

    private static int findEquilibrium(long[] arr, int length) {
        if(length == 1){
            return 1;
        }
        long leftSum = 0;
        long rightSum = LongStream.of(arr).sum();

        for(int i = 0; i<length; i++){
            rightSum = rightSum - arr[i];

            if(leftSum == rightSum){
                return i;
            } else {
                leftSum = leftSum + arr[i];
            }
        }
        return -1;
    }
}
