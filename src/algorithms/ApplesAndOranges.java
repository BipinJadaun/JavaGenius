//https://www.hackerrank.com/challenges/apple-and-orange/problem

package algorithms;

import java.util.Scanner;

public class ApplesAndOranges {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int t = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int m = in.nextInt();
		int n = in.nextInt();
		int[] apple = new int[] {-2,2,1};
		for(int apple_i=0; apple_i < m; apple_i++){
			apple[apple_i] = in.nextInt();
		}
		int[] orange = new int[] {5,-6};
		for(int orange_i=0; orange_i < n; orange_i++){
			orange[orange_i] = in.nextInt();
		}

		int apples = totalApples(s,t,a,apple);
		int oranges = totalOranges(s,t,b,orange);

		System.out.println(apples);
		System.out.println(oranges);
		in.close();

	}

	private static int totalOranges(int s, int t, int b, int[] orange) {
		int totalOrange = 0;
		for(int i=0; i< orange.length; i++ ) {
			if((b + orange[i]) >= s && (b + orange[i]) <= t)
				totalOrange++;
		}
		return totalOrange;
	}

	private static int totalApples(int s, int t, int a, int[] apple) {
		int totalApples = 0;
		for(int i=0; i< apple.length; i++ ) {
			if((a + apple[i]) >= s && (a + apple[i]) <= t)
				totalApples++;
		}
		return totalApples;
	}

}
