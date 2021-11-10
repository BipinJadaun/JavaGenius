package dataStructures.linkedlist;

import java.util.HashSet;
import java.util.Set;

import dataStructures.models.ListNode;
import dataStructures.utils.Util;
/**
 * @link https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
 */
public class RemoveDuplicatesFromUnSortedLinkedList {
	public static void main(String[] args) {
		LinkedListImpl<Integer> list = new LinkedListImpl<>();
		Integer[] arr = new Integer[]{1, 4, 7, 3, 9, 7, 6, 10, 10, 11};
		Node<Integer> head = list.addAll(arr);

		list.printList(head);
		Node modifiedListHead = removeDuplicate(head);
		list.printList(modifiedListHead);

	}

	static Node<Integer> removeDuplicate(Node<Integer> head){

		Set<Integer> set = new HashSet<>();

		Node<Integer> temp = head;

		while(temp != null){
			if(set.contains(temp.value)){
				//if a value already preset in set, remove the node
				temp.value = temp.next.value;
				temp.next = temp.next.next;
			} else {
				set.add(temp.value);
			}
			temp = temp.next;
		}
		return head;
	}
}
