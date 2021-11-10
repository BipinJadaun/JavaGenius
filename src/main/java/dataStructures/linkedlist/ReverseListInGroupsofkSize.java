package dataStructures.linkedlist;

public class ReverseListInGroupsofkSize {
	public static void main(String[] args) {

		LinkedListImpl<Integer> list = new LinkedListImpl<>();
		Integer[] arr = new Integer[]{1,2,3,5,7,8,9,10,11};
		Node<Integer> head = list.addAll(arr);
    	
    	int K = 3;
    	Node reversedHeadHybrid = reverseListInKSize(head, K);
    	list.printList(reversedHeadHybrid);
    	Node reversedHeadRecursive = reverseListInKSizeRecursively(reversedHeadHybrid, K);
		list.printList(reversedHeadRecursive);
	}

	private static Node reverseListInKSizeRecursively(Node head, int K) {
		Node currNode = head;
		Node prevNode = null;
		Node nextNode = null;
		
		int count = 0; 
		//verify there are K nodes available
		Node tmp = currNode;
		while(count < K && tmp != null) {
			tmp = tmp.next;
			count++;
		}
		if(count < K)
			return head;
		
		//verified for availability of K nodes, now reverse
		count = 0;
		while(count < K && currNode != null) {
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
			count++;
		}
		
		if(nextNode != null)
			head.next = reverseListInKSizeRecursively(nextNode, K);
		
		return prevNode;
	}

	private static Node reverseListInKSize(Node head, int K) {
        if(head == null || head.next == null)
			return head;
		Node newHead = null, prevHead = null, curr = head;

		while(curr != null) {
			int count = 1;
			Node startNode = curr;
			for(; count < K && curr != null; count++) {
				curr = curr.next;
			}
			if(count == K && curr != null) {
				Node nextHead = curr.next;
				Node reversedHead = reverseList(startNode, curr);
				if(newHead == null)
					newHead = reversedHead;
				else
					prevHead.next = reversedHead;
				prevHead = startNode;
				curr = nextHead;
			} else if(prevHead != null) {
				prevHead.next = startNode;
			} else{
                return head;
            }
		}

		return newHead;
	}

	private static Node reverseList(Node startNode, Node curr) {
		if(curr == null && startNode == null)
			return null;
		if(curr == null)
			return startNode;
		if(startNode == null)
			return curr;
		
		if(startNode == curr)
			return curr;
		Node nextNode = startNode.next;
		startNode.next = null;
		Node reversed = reverseList(nextNode, curr);
		nextNode.next = startNode;
		
		return reversed;
	}

}
