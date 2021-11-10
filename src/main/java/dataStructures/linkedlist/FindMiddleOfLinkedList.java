package dataStructures.linkedlist;

/**
 * 
 * @link https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
 */
public class FindMiddleOfLinkedList {
	public static void main(String[] args) {

		LinkedListImpl<Integer> list = new LinkedListImpl<>();
		Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,9};
		Node<Integer> head = list.addAll(arr);

        Node midNode = findMiddleOfList(head);
        System.out.println(midNode.value);
	}

	public static Node findMiddleOfList(Node head) {
		if(head == null || head.next == null)
			return null;
		
		Node slow = head, fast = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			if(fast != null)
				slow = slow.next;
				
		}
		
		return slow;
	}
}
