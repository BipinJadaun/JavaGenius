//You are given an array of integers and a positive integer k Find and print the number of (1,j) pairs where
//i < j and a[i] + a[j] is divisible by k.

package problemSolving;

import java.util.HashMap;
import java.util.Map;

public class DivisibleSumPairs {

	public static void main(String[] args) {
		int[] arr = {1,3,2,6,2,1};
		System.out.println(divisibleSumPairs(arr, 3));
	}

	private static int divisibleSumPairs(int[] arr, int k) {
		
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i : arr) {
			int mod = i % k;
	        int need = (k-mod) % k;
	            
	          if(map.containsKey(need)){
	              count += map.get(need);
	          }
	          
	          if(map.containsKey(mod)){
	              int value = map.get(mod);
	              map.put(mod, ++value);
	          }
	          else{
	           map.put(mod, 1);    
	          }
		}
		
		return count;
	}

}
