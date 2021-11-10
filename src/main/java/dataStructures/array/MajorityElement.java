package dataStructures.array;

import java.util.HashMap;
import java.util.Map;

/*
Given an array A of N elements. Find the majority element in the array.
A majority element in an array A of size N is an element that appears more than N/2 times in the array.
 */
public class MajorityElement {
    public static void main(String[] args) {

        int[] arr = new int[]{1,3,2,3,3};
        System.out.println(majorityElement(arr, arr.length));
    }

    static int majorityElement(int a[], int size)
    {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<a.length; i++){
            map.computeIfPresent(a[i], (key, value) -> value+1);
            map.putIfAbsent(a[i], 1);
        }
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            if(e.getValue()>size/2){
                return e.getKey();
            }
        }
        return -1;
    }
}
