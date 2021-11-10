package dataStructures.linkedlist;

/**
 * 
 * @link https://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
 */
public class PairwiseSwapElements {
	public static void main(String[] args) {

		LinkedListImpl<Integer> list = new LinkedListImpl<>();
		Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,9};
		Node<Integer> head = list.addAll(arr);

    	list.printList(head);
    	Node modifiedHeadRecursive = pairWiseSwapRecursively(head);
		list.printList(modifiedHeadRecursive);
    	Node modifiedHeadIterative = pairWiseSwapIteratively(modifiedHeadRecursive);
		list.printList(modifiedHeadIterative);
    	
	}

	private static Node pairWiseSwapIteratively(Node head) {
		if(head == null)
			return null;
		Node prevNode = null, nextNode = null, newHead = null;
		
		while(head != null && head.next != null) {
			nextNode = head.next;
			head.next = nextNode.next;
			nextNode.next = head;
			if(newHead == null) {
				newHead = nextNode;
			} else {
				prevNode.next = nextNode;
			}
			
			prevNode = head;
			head = head.next;
		}
		
		return newHead;
	}

	private static Node pairWiseSwapRecursively(Node head) {
		if(head == null || head.next == null)
			return head;
		Node curr = head, next = head.next;
		
		if(curr != null && curr.next != null) {
			curr.next = pairWiseSwapRecursively(next.next);
			next.next = curr;
		}
		
		return next;
	}
}
