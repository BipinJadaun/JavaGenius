package dataStructures.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MinMaxStack {

	static Stack<Integer> minStack = new Stack<>();    
	static Stack<Integer> maxStack = new Stack<>();
	static Queue<Integer> mainQueue = new LinkedList<>();
	
	public static void main(String[] args) {
		String[] operations = {"push","push","push","pop"};
		int[] x = {1,2,3,1};
		long[] arr = maxMin(operations, x);
		
		for(long t: arr)
		System.out.println(t);
	}

	static long[] maxMin(String[] operations, int[] x) {
		long[] result = new long[x.length];

		for(int i = 0; i< x.length; i++ ){
			if(operations[i] == "push"){
				push(x[i]);
			}
			else if(operations[i] == "pop"){
				pop();
			}
			result[i] = getMin()*getMax();
		}
		return result;
	}

	public static void push(int value){
		if (value <= getMin()) { 
			minStack.push(value);
		}

		if (value >= getMax()) {
			maxStack.push(value);
		}

		mainQueue.add(value);
	}

	public static Integer pop() {
		int value = mainQueue.poll();

		if (value == getMin()) {
			minStack.pop();         
		}
		if (value == getMax()) {
			maxStack.pop();         
		}
		return value;
	}

	public static int getMin() {
		if (minStack.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return minStack.peek();
		}
	}

	public static int getMax() {
		if (maxStack.isEmpty()) {
			return Integer.MIN_VALUE;
		} else {
			return maxStack.peek();
		}
	}

}
