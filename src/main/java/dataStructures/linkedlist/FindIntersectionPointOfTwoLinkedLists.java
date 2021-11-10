package dataStructures.linkedlist;
/**
 * 
 * @link https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
 */
public class FindIntersectionPointOfTwoLinkedLists {
	public static void main(String[] args) {

		LinkedListImpl<Integer> list1 = new LinkedListImpl<>();
		Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,9};
		Node<Integer> head1 = list1.addAll(arr);
		Node<Integer> intPoint = list1.find(6);

		LinkedListImpl<Integer> list2 = new LinkedListImpl<>();
		Integer[] arr1 = new Integer[]{1,2,3};
		Node<Integer> head2 = list2.addAll(arr);
		Node<Integer> lastNode = list2.find(3);

		lastNode.next = intPoint;


		System.out.println(findIntersectioNodeOfTwoLists(head1, head2).value);
	}

	private static Node findIntersectioNodeOfTwoLists(Node head, Node root) {
		if(head == null || root == null)
			return null;
		
		int len1 = FindLengthOfLinkedList.countNumberOfNodesRecursively(head);
		int len2 = FindLengthOfLinkedList.countNumberOfNodesRecursively(root);
		
		
		Node slow, fast;
		if(len1 < len2) {
			slow = head;
			fast = root;
		}
		else {
			slow = root;
			fast = head;
		}
		
		int diff = len1 - len2;
		
		while(diff-- > 0) {
			fast = fast.next;
		}
		
		while(fast != slow) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}


}
