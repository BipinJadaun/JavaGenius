package dataStructures.array;

import java.util.Arrays;

public class TripletsWithGivenSum {
    public static void main(String[] args) {
        //int[] arr = new int[]{5, 1, 3, 4, 7}; //sum 12 output - 5,1,3  5,1,4  1,2,3  1,3,7
        int[] arr = new int[]{9, 4, 6, 1, 2, 3, 8};
        int tripletsCount = findTriplets(arr, 14);
        System.out.println(tripletsCount);

    }

    private static int findTriplets(int[] arr, int sum) {
        int n = arr.length;
        int count = 0;
        int curSum = 0;
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            // for every ith element find the other 2 elements in remaining array.
            int j = i+1;
            int k = n-1;

            while(j < k){
                //if sum of the triplets is bigger than given sum, reduce k
                if(arr[i] + arr[j] + arr[k] >= sum) {
                    k--;
                }else{
                    // now there are k-j elements whose sum along with arr[i] is less than given sum
                    count = count + (k-j);
                    j++;
                }
            }
        }
        return count;
    }
}
