package dataStructures.linkedlist;

/**
 * 
 * @link https://www.geeksforgeeks.org/merge-sort-for-linked-list/
 */
public class MergeSortLinkedList {
	public static void main(String[] args) {
		
		LinkedListImpl<Integer> list = new LinkedListImpl<>();
		Integer[] arr = new Integer[]{1,2,7,4,8,6,3,5,9};
		Node<Integer> head = list.addAll(arr);
		
    	list.printList(head);
    	Node mergedHead = mergeSortForLinkedList(head);
		list.printList(mergedHead);
		
	}

	private static Node mergeSortForLinkedList(Node head) {
		if(head == null || head.next == null)
			return head;
		
		Node midNode = FindMiddleOfLinkedList.findMiddleOfList(head);
		Node nextToMidNode = midNode.next;
		midNode.next = null;
		
		Node start = mergeSortForLinkedList(head);
		Node mid = mergeSortForLinkedList(nextToMidNode);
		
		return merge(start, mid);
	}

	private static Node merge(Node head, Node root) {
		return MergeTwoSortedLinkedLists.mergeSortedLinkedLists(head, root);
	}
}
