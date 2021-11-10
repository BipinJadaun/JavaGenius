package dataStructures.linkedlist;

public class FindNthNodeFromEndOfLinkedList {
	public static void main(String[] args) {

		LinkedListImpl<Integer> list = new LinkedListImpl<>();
		Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,9};
		Node<Integer> head = list.addAll(arr);
    	
    	int n = 6;
    	Node node = findNthNodeFromEnd(head, n);
    	System.out.println(node != null ? node.value : -1);

	}

	private static Node findNthNodeFromEnd(Node head, int n) {
		if(head == null)
			return head;
		
		int count = n;
		Node slow = head, fast = head;
		while(count-- > 0 && fast != null) {
			fast = fast.next;
		}
		
		if(fast == null) {
			System.out.println("Position does not exist");
			return null;
		}
		
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return slow;
	}
}
