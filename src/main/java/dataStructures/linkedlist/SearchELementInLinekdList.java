package dataStructures.linkedlist;


public class SearchELementInLinekdList {
	public static void main(String[] args) {
		LinkedListImpl<Integer> list = new LinkedListImpl<>();
		Integer[] arr = new Integer[]{1,2,3,5,7,8,9,10,11};
		Node<Integer> head = list.addAll(arr);
    	

    	Node resultIterative = searchElementIteratively(head, 6);
    	Node resultRecursive = searchElementRecursively(head, 6);
    	System.out.println(resultIterative == null ? resultIterative : resultIterative.value);
    	System.out.println(resultRecursive == null ? resultRecursive : resultRecursive.value);
    	
	}

	private static Node<Integer> searchElementIteratively(Node<Integer> head, int element) {
		if(head == null)
			return null;
		while(head != null) {
			if(head.value == element)
				return head;
			head = head.next;
		}
		
		return null;
	}

	private static Node searchElementRecursively(Node<Integer> head, int element) {
		if(head == null)
			return null;
		if(head.value == element)
			return head;
		return searchElementRecursively(head.next, element);
	}
}
