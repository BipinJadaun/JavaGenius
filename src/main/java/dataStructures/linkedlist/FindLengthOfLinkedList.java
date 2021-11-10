package dataStructures.linkedlist;

import dataStructures.models.ListNode;
/**
 * 
 * @link https://www.geeksforgeeks.org/find-length-of-a-linked-list-iterative-and-recursive/
 */
public class FindLengthOfLinkedList {
	public static void main(String[] args) {

		LinkedListImpl<Integer> list = new LinkedListImpl<>();
		Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,9};
		Node<Integer> head = list.addAll(arr);

        
        System.out.println(countNumberOfNodesIteratively(head));
        System.out.println(countNumberOfNodesRecursively(head));
	}

	public static int countNumberOfNodesRecursively(Node head) {
		if(head == null)
			return 0;
		return countNumberOfNodesRecursively(head.next) + 1;
	}

	public static int countNumberOfNodesIteratively(Node head) {
		int count = 0;
		while(head != null) {
			head = head.next;
			count++;
		}
		return count;
	}
}
