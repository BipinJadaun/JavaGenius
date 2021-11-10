package dataStructures.linkedlist;

import java.util.Stack;

import dataStructures.models.ListNode;
import dataStructures.utils.Util;
/**
 * 
 * @link https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
 */
public class CheckIfLinkedListIsPalindrome {

	public static void main(String[] args) {

		LinkedListImpl<Integer> list = new LinkedListImpl<>();
		Integer[] arr = new Integer[]{1,2,3,4,5,4,3,2,1};
		Node<Integer> head = list.addAll(arr);
		
		System.out.println(isListPalindromeUsingStack(head));
		System.out.println(isListPalindromeByReversingFromMid(head));
		list.printList(head);

	}

	private static <E> boolean isListPalindromeByReversingFromMid(Node<E> head) {
		if(head == null || head.next == null)
			return true;
		
		Node<E> slow = head, fast = head, prev = null;
		boolean isPalindrome = false;
		while(fast != null  && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		prev.next = ReverseLinkedList.reverseListIteratively(slow);
		slow = head;
		fast = prev.next;
		while(slow.value == fast.value && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		if(fast.next == null) {
			isPalindrome = true;
		}
		
		prev.next = ReverseLinkedList.reverseListIteratively(prev.next);
		
		return isPalindrome;
	}

	private static <E> boolean isListPalindromeUsingStack(Node<E> head) {
		if(head == null || head.next == null)
			return true;
		Stack<Node> stack = new Stack<Node>();
		
		Node slow = head, fast = head;
		
		while(fast != null  && fast.next != null) {
			stack.push(slow);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast != null && fast.next == null)
			slow = slow.next;

			
		while(!stack.isEmpty()) {
			if(stack.pop().value != slow.value) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
}
