package dataStructures.array;

import java.util.HashMap;
import java.util.Map;

public class QuadruplesWithGivenSumInFourArrays {

    public static void main(String[] args) {
        int[] jeansPrices = new int[] {2,3};
        int[] shoesPrices = new int[] {4};
        int[] topsPrices = new int[] {2,3};
        int[] capsPrices = new int[] {1,2};
        int budget = 10;

        int shopingOptions = findShopingOptions(jeansPrices, shoesPrices, topsPrices, capsPrices, budget);
        System.out.println(shopingOptions);
    }

    private static int findShopingOptions(int[] jeansPrices, int[] shoesPrices,
                                           int[] topsPrices, int[] capsPrices, int budget) {

        Map<Integer, Integer> map = new HashMap<>();
        int count= 0;

        for(int i=0; i<jeansPrices.length; i++){
            for (int j = 0; j < shoesPrices.length; j++) {
                int sum = jeansPrices[i] + shoesPrices[j];
                map.computeIfPresent(sum, (k, v)-> v+1);
                map.putIfAbsent(sum,1);
            }
        }

        for (int i = 0; i < topsPrices.length; i++) {
            for (int j = 0; j < capsPrices.length; j++) {
                int sum = topsPrices[i] + capsPrices[j];
                if(map.containsKey(budget-sum)){
                    count = count + map.get(budget-sum);
                }
            }
        }

        return count;
    }
}

