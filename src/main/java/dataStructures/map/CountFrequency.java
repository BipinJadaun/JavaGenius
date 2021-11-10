package dataStructures.map;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountFrequency {
    public static void main(String[] args) {
        System.out.println(findFirstRepeatingChar1("geeksforgeeks"));
    }

    private static String findFirstRepeatingChar(String str) {
        int[] freq = new int[26];

        str.chars().forEach(ch -> freq[ch - 'a']++);

        char firstRepeatingChar = 'a';
        for(int i =0; i < freq.length; i++){
            if(freq[i] > 1){
                firstRepeatingChar += i;
                break;
            }
        }
        return String.valueOf(firstRepeatingChar);
    }

    private static String findFirstRepeatingChar1(String str){
        Map<Character, Integer> freq = new LinkedHashMap<>();


        str.chars()
                .map(i -> (char)i)
                .forEach(ch -> {
                    System.out.println(ch);
                   // freq.computeIfPresent(ch , (k,v) -> v+1);
                  //  freq.putIfAbsent(ch, 1);
                });

        return null;
    }
}
