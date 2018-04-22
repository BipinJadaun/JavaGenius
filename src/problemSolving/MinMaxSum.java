package problemSolving;

import java.util.Scanner;

public class MinMaxSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int i=0; i < 5; i++){
            arr[i] = in.nextInt();
        }
		
        long smallest = arr[0]; 
        long largest = arr[0]; 
        long sum = 0; 
        for(int i=0; i < arr.length; i++){
            if(smallest > arr[i])
                smallest = arr[i];
            if(largest <  arr[i])
                largest = arr[i];
            
            sum = sum + arr[i];
        }
        
        System.out.println((sum-largest) + " " + (sum-smallest)); 
        in.close();

	}

}
