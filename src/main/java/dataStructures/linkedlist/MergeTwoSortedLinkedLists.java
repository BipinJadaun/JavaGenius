package dataStructures.linkedlist;


public class MergeTwoSortedLinkedLists {
	public static void main(String[] args) {

		LinkedListImpl<Integer> list1 = new LinkedListImpl<>();
		Integer[] arr1 = new Integer[]{1,2,4,6,7,9};
		Node<Integer> head1 = list1.addAll(arr1);

		LinkedListImpl<Integer> list2 = new LinkedListImpl<>();
		Integer[] arr2 = new Integer[]{1,3,5,8,11,12};
		Node<Integer> head2 = list2.addAll(arr2);

    	Node mergedHead = mergeSortedLinkedLists(head1, head2);

    	list1.printList(mergedHead);
	}

	public static Node<Integer> mergeSortedLinkedLists(Node<Integer> head, Node<Integer> root) {
		if(head == null && root == null)
			return null;
		if(head == null)
			return root;
		if(root == null)
			return head;
		
		if(head.value < root.value) {
			head.next = mergeSortedLinkedLists(head.next, root);
			return head;
		} else {
			root.next = mergeSortedLinkedLists(head, root.next);	
			return root;
		}
	}
}
