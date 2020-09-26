package dataStructures.stack;

public class StackImpl {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>(3);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(50);	
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		
		Stack<String> stack1 = new Stack<>(3);
		stack1.push("10");
		stack1.push("20");
		stack1.push("30");
		stack1.push("40");	
		
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
	}

}

class Stack <E>{
	private Object[] stack ;
	private int size;
	private int top = 0;
	
	public Stack(int size){
		if(size >= 0) {
			this.size = size;
			stack = new Object [size];
		}
		else
			System.out.println("illegal size");
	}
	
	public void push(E data){
		if(top >= size){
			System.out.println("stack overflow");
		}
		else{
			stack[top] = data;
			top++;
		}	
	}
	
	@SuppressWarnings("unchecked")
	public E pop(){
		if(top <= 0){
			System.out.println("stack underflow");
			return null;
		}
		else{
			top--;
			E value = (E) stack[top];
			return value;
		}		
	}	
}
