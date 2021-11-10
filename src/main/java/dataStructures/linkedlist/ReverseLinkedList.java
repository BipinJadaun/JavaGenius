package dataStructures.linkedlist;

import dataStructures.models.ListNode;
import dataStructures.utils.Util;

public class ReverseLinkedList {
	public static void main(String[] args) {

		LinkedListImpl<Integer> list = new LinkedListImpl<>();
		Integer[] arr = new Integer[]{1,2,3,5,7,8,9};
		Node<Integer> head = list.addAll(arr);

        list.printList(head);
        Node reversedHead = reverseListIteratively(head);
        list.printList(reversedHead);
        Node originalHead = reverseListRecursively(reversedHead);
        list.printList(originalHead);
        
        
	}

	public static Node reverseListIteratively(Node head) {
		if(head == null || head.next == null)
			return head;
		Node prev = null, curr = head, next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}

	public static Node reverseListRecursively(Node head) {
		if(head == null || head.next == null)
			return head;
		Node headNext = head.next;
		head.next = null;
		Node reversedHead = reverseListRecursively(headNext);
		headNext.next = head;
		
		return reversedHead;
	}
}
