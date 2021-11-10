package dataStructures.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

public class ArrayToNumber {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 6, 8, 9, 2};
        int number = convertToNumber(arr);
        System.out.println(number);
        int[] arr1 = convertToArray(number);
        System.out.println(Arrays.toString(arr1));


        ArrayList<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(2);
        list.add(3);
        System.out.println(incrementArray(list));
    }

    private static int[] convertToArray(int number) {
        return Integer.toString(number).chars().map(a -> a - '0').toArray();
    }

    private static int convertToNumber(int[] arr) {

        StringBuilder s = new StringBuilder();
        IntStream.of(arr).forEach(a -> s.append(a));
        return Integer.parseInt(s.toString());
    }

    private static ArrayList<Integer> incrementArray(ArrayList<Integer> num) {
        int carry = 0;
        int N = num.size();

        if (num.get(N - 1) != 9) {
            num.set(N - 1, num.get(N - 1) + 1);
            return num;
        } else {
            num.set(N - 1, 0);
            carry = 1;
            if(N == 1){
                num.add(0, carry);
                return num;
            } else {
                int i = N - 2;
                while (i >= 0 && num.get(i) == 9) {
                    num.set(i, 0);
                    i--;
                }
                if (i >= 0) {
                    num.set(i, num.get(i) + carry);
                    carry = 0;
                }
                if (i == -1 && carry == 1) {
                    num.add(0, 1);
                }
            }
        }
        return num;
    }
}
