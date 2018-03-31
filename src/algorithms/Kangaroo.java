//https://www.hackerrank.com/challenges/kangaroo/problem

package algorithms;

import java.util.Scanner;

public class Kangaroo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();

        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
        in.close();

	}

	private static String kangaroo(int x1, int v1, int x2, int v2) {
		if(v2 >= v1)	
            return "NO";
		else if((x1-x2)%(v2-v1)	== 0)
			return "YES";
		else
		    return "NO";
		
		/*long sum1 = x1;
		long sum2 = x2;
		
		if(x2>x1 && v2>v1)	
            return "NO";
		else {
			for(int i =0; i<3000; i++){
                sum1 += v1;
                sum2 += v2;
                if(sum1 == sum2)
                	return "YES";
            }			
		}
		return "NO";*/
	}

}
