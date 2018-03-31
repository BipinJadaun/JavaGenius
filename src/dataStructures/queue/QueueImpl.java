package dataStructures.queue;



public class QueueImpl {

	public static void main(String[] args) { 
		Queue<Integer> queue = new Queue<>(3);
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}

class Queue<E>{
	private Object[] queue;
	private int size;
	private int rear;
	private int front;
	
	public Queue(int capacity) {
		if(capacity >=0) {
			this.size = capacity;
			queue = new Object[capacity];
			this.rear = 0;
			this.front = 0;
		}			
	}
	
	public void enqueue(E data) {
		if(rear >= size)
			System.out.println("queue overflow");
		else {
			queue[rear] = data;
			rear++;
		}
	}
	
	@SuppressWarnings("unchecked")
	public E dequeue() {
		if(front >= size) {
			System.out.println("queue underflow");
			return null;
		}else {
			E value = (E) queue[front];
			front ++;
			return value;
		}
	}	
}
