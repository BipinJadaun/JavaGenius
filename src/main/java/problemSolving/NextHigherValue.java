package problemSolving;

import java.util.Stack;

public class NextHigherValue {

	public static void main(String[] args) {

		int[] arr = {5,4,9,6,7,8,12,3,2,17,0,19};

		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);

		for(int i=1; i<arr.length; i++) {
			if(!stack.isEmpty()) {
				int element = stack.pop();
				while(arr[i] > element) {					
					System.out.println("next higher value for " + element +" is "+ arr[i]);	
					if(stack.isEmpty())
						break;
					element = stack.pop();
				}
				if(arr[i] < element)
					stack.push(element);
			}
			stack.push(arr[i]);
		}
	}
}
