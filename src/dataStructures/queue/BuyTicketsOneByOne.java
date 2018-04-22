package dataStructures.queue;

import java.util.LinkedList;
import java.util.Queue;

public class BuyTicketsOneByOne {

	public static void main(String[] args) {
		
		int[] arr = {2,6,3,4,5};
		System.out.println(waitingTime(arr, 2));

	}	
	
	static long waitingTime(int[] tickets, int p) {
        Queue<Integer> queue = new LinkedList<>();
        int reqTckts = tickets[p];
        int position = p;
        int count = 0;
        
        for(int i : tickets)
            queue.add(i);
        
        while(reqTckts != 0){
        	int value = queue.poll();
        	value--;
        	count++;
        	if(value!=0) {
        		queue.add(value);
        	} 
        	
        	if(position == 0) {
        		reqTckts--;
        		position = queue.size()-1;
        	}
        	else {
        		position--;
        	}
        	 	 
        }
		return count;
    }

}
