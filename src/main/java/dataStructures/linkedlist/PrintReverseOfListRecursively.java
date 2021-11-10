package dataStructures.linkedlist;

import dataStructures.models.ListNode;

public class PrintReverseOfListRecursively {
		public static void main(String[] args) {

			LinkedListImpl<Integer> list = new LinkedListImpl<>();
			Integer[] arr = new Integer[]{1,2,3,5,7,8,9,10,11};
			Node<Integer> head = list.addAll(arr);
			
			printReverseOfList(head);
			
		}

		private static void printReverseOfList(Node head) {
			if(head == null)
				return;
			printReverseOfList(head.next);
			System.out.println(head.value);
		}
}
