package dataStructures.queue;

import java.util.PriorityQueue;

public class MaxMinHeapUsingPriorityQueue {

	public static void main(String[] args) {

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
		
		maxHeap.add(4);
		maxHeap.add(14);
		maxHeap.add(42);
		maxHeap.add(8);
		maxHeap.add(49);
		maxHeap.add(24);
		maxHeap.add(18);
		
		while(!maxHeap.isEmpty()) {
			System.out.println(maxHeap.poll());
		}
		
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		minHeap.add(4);
		minHeap.add(14);
		minHeap.add(42);
		minHeap.add(8);
		minHeap.add(49);
		minHeap.add(24);
		minHeap.add(18);
		
		while(!minHeap.isEmpty()) {
			System.out.println(minHeap.poll());
		}

	}

}
