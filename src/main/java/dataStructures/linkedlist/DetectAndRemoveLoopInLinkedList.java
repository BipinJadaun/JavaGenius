package dataStructures.linkedlist;

import dataStructures.models.ListNode;
import dataStructures.utils.Util;

public class DetectAndRemoveLoopInLinkedList {
	public static void main(String[] args) {

		LinkedListImpl<Integer> list = new LinkedListImpl<>();
		Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,9};
		Node<Integer> head = list.addAll(arr);

		Node<Integer> lastNode = list.find(9);
		Node<Integer> loopNode = list.find(5);
		lastNode.next = loopNode;
    	
        Node loopRemovedHead = detectAndRemoveLoop(head);
        list.printList(loopRemovedHead);
	}

	private static Node detectAndRemoveLoop(Node head) {
		if(head == null || head.next == null)
			return head;

		Node slow = head, fast = head;
		slow = slow.next;
		fast = fast.next.next;

		// Detect Loop
		while(fast != null && fast.next != null) {
			if(slow == fast) {
				System.out.println("Loop found");
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		// No Loop
		if(slow != fast){
			System.out.println("No Loop found");
			return head;
		}

		//Start removing loop
		slow = head;
		while(slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}
		fast.next = null;

		return head;
	}
}
