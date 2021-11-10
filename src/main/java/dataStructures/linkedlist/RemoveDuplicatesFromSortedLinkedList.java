package dataStructures.linkedlist;


import dataStructures.models.ListNode;
import dataStructures.utils.Util;
/**
 * 
 * @author rohitmishra
 * @link https://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/
 */
public class RemoveDuplicatesFromSortedLinkedList {
	public static void main(String[] args) {
		LinkedListImpl<Integer> list = new LinkedListImpl<>();
		Integer[] arr = new Integer[]{1,1,3,5,7,7,9,10,11};
		Node<Integer> head = list.addAll(arr);

    	list.printList(head);
    	Node modifiedListHead = removeDuplicates(head);
		list.printList(modifiedListHead);
    	
	}

	private static Node removeDuplicates(Node head) {
		if(head == null || head.next == null)
			return null;
		Node curr = head;
		
		while(curr != null && curr.next != null) {
			if(curr.value == curr.next.value) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}
		
		return head;
		
	}
}
