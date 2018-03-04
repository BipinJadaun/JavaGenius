package algorithms.warmup;

public class BirthdayCakeCandles {

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
