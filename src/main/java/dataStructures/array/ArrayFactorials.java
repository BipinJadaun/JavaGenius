package dataStructures.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayFactorials {

    public static void main(String[] args) {
        long[] arr = new long[] {2,5,3};
        Solution sol = new Solution();
        long[] factorials = sol.factorial(arr, arr.length);
        System.out.println(Arrays.toString(factorials));

    }
}

class Solution {
    Map<Long, Long> facts = new HashMap<>();
    public long[] factorial(long a[], int n) {
        long[] fact = new long[n];

        for(int i=0; i<n; i++){
            calcFact(a[i]);
            fact[i] = facts.get(a[i]);
        }
        return fact;
    }

    long calcFact(long num){
        if(num == 1){
            return 1;
        }
        if(facts.containsKey(num)){
            return facts.get(num);
        } else {
            long fact = num * calcFact(num-1);
            facts.put(num, fact);
            return fact;
        }
    }
}
