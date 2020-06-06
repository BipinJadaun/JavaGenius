package problemSolving;

import java.util.HashSet;
import java.util.Set;

public class ProductNotContainingDigits {

	public static void main(String[] args) {
		
		System.out.println(nonRepeatingDigitProductCount(2, 10, 15));
	}
	
	static int nonRepeatingDigitProductCount(int x, int y, int z) {
        int product = 0;
        int count = 0;
        for(int i = y; i <=z ; i++){
            product = x*i;
            if(isProductContainsDigit(product, i)){
                count++;
            }            
        }
        return count;
    }

    static boolean isProductContainsDigit(int product, int n){
        Set<Integer> digitSet = new HashSet<>();
        while(product != 0){
            int lastDigit = product%10;
            digitSet.add(lastDigit);
            product = product/10;
        }
        while(n != 0){
            int lastDigit = n%10;
            if(digitSet.contains(lastDigit))
                return true;
            else
                n = n/10;
        }
        return false;
    }

}
