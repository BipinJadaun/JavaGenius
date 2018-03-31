package algorithms;

import java.util.Scanner;

public class TripletComparison {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a0 = in.nextInt();
		int a1 = in.nextInt();
		int a2 = in.nextInt();
		int b0 = in.nextInt();
		int b1 = in.nextInt();
		int b2 = in.nextInt();

		int A = 0, B = 0;
		if(a0>b0)
			A++;
		else if(b0>a0)
			B++;

		if(a1>b1)
			A++;
		else if(b1>a1)
			B++;

		if(a2>b2)
			A++;
		else if(b2>a2)
			B++;

		System.out.println(A +" "+ B);

		in.close();

	}

}
