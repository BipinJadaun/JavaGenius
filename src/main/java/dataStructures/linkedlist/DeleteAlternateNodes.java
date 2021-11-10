package dataStructures.linkedlist;

import dataStructures.models.ListNode;
import dataStructures.utils.Util;

/**
 * 
 * @link https://www.geeksforgeeks.org/delete-alternate-nodes-of-a-linked-list/
 */
public class DeleteAlternateNodes {
	public static void main(String[] args) {

		LinkedListImpl<Integer> list = new LinkedListImpl<>();
		Integer[] arr = new Integer[]{1,2,3,4,5,4,3,2,1};
		Node<Integer> head = list.addAll(arr);
    	
    	deleteAlternateNodes(head);
		list.printList(head);
	}

	private static void deleteAlternateNodes(Node head) {
		if(head == null || head.next == null)
			return;
		deleteAlternateNodes(head.next.next);
		head.next = head.next.next;
	}
	
}
