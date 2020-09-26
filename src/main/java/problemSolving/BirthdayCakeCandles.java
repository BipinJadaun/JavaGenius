/*You are in-charge of the cake for your niece's birthday and have decided the cake will have one candle for each year of her total age.
When she blows out the candles, she’ll only be able to blow out the tallest ones.
For example, if your niece is turning 4 years old, and the cake will have 4 candles of height 3, 2, 3, 1, 
she will be able to blow out 2 candles successfully, since the tallest candle is of height 3 and there are 2 such candles.
*/
package problemSolving;

import java.util.Scanner;

public class BirthdayCakeCandles {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for(int ar_i = 0; ar_i < n; ar_i++){
			ar[ar_i] = in.nextInt();
		}
		int result = birthdayCakeCandles(n, ar);
		System.out.println(result);
		in.close();
	}

	private static int birthdayCakeCandles(int length, int[] ar) 
	{		
		int count = 0;
		int hight = 0;

		for(int i=0; i<ar.length; i++){
			if(ar[i]>hight){
				hight = ar[i];
				count = 0;
			}
			if(ar[i]==hight){
				count++;
			}            
		}
		return count;
	}
}
