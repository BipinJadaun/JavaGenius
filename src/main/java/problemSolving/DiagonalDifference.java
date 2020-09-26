package problemSolving;

import java.util.Scanner;

public class DiagonalDifference {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] metrix = new int[n][n];
		int sum1 =0, sum2=0;
		for(int i=0; i<n; i++){
			for(int j=0;j<n;j++){
				metrix[i][j] = sc.nextInt();
				if(i==j)
					sum1 = sum1 + metrix[i][j];
				if(i+j == n-1)
					sum2 = sum2 + metrix[i][j];
			}
		}
		if(sum1>sum2)
			System.out.println(sum1-sum2);
		else
			System.out.println(sum2-sum1);

		sc.close();
	}

}
