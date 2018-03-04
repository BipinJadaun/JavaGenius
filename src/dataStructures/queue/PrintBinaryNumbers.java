package dataStructures.queue;

import java.util.LinkedList;
import java.util.Queue;

public class PrintBinaryNumbers {

	public static void main(String[] args) {
		
		Queue<String> q = new LinkedList<>();
		q.add("1");
		String sb ;
		
		for(int i=1; i<=10; i++) {
			sb = q.poll();
			System.out.println(sb);
			q.add(sb+"0");
			q.add(sb+"1");
		}
	}
}
