package dataStructures.array;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * There is a large pile of socks that must be paired by color for sale.
 * Given an array of integers representing the color of each sock,
 * determine how many pairs of socks with matching colors there are.
 */
public class MakePairsInArray {
    public static void main(String[] args) {
        int[] socks = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        pairSocks(socks);
    }

    private static void pairSocks(int[] socks) {
        int pairs =  ((Long) Arrays.stream(socks).boxed()
                .collect(Collectors.groupingBy(sock -> sock, Collectors.counting()))
                .values().stream().mapToLong(aLong -> aLong / 2).sum())
                .intValue();

        System.out.println(pairs);

    }
}
