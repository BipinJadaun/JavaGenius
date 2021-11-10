package dataStructures.linkedlist;


import dataStructures.models.ListNode;
import dataStructures.utils.Util;
/**
 * 
 * @author rohitmishra
 * @link https://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
 */
public class SwapNodesInLinkedList {
	public static void main(String[] args) {
		LinkedListImpl<Integer> list = new LinkedListImpl<>();
		Integer[] arr = new Integer[]{1,2,3,5,7,8,9,10,11};
		Node<Integer> head = list.addAll(arr);

    	int x = 4;
    	int y = 1;
    	
    	list.printList(head);
    	Node headSwapped = swapNodes(head, x, y);
    	System.out.println();
		list.printList(headSwapped);
    	
	}

	private static Node<Integer> swapNodes(Node<Integer> head, int x, int y) {
		if(head == null || x == y)
			return head;
		Node<Integer> xPrev = null, xNode = null, yNode = null, yPrev = null, prev = null, tmp = head;
		
		while(tmp != null) {
			if(tmp.value == x) {
				xNode = tmp;
				xPrev = prev;
			} 
			if(tmp.value == y) {
				yNode = tmp;
				yPrev = prev;
			}
			
			if(xNode != null && yNode != null) {
				if(yPrev != null) {
					Node xNext = xNode.next;
					yPrev.next = xNode;
					xNode.next = yNode.next;
					yNode.next = xNext;
					
					if(head == xNode) {
						head = yNode;
					}					
				} else if(xPrev != null) {
					Node yNext = yNode.next;
					xPrev.next = yNode;
					yNode.next = xNode.next;
					xNode.next = yNext;
					
					if(head == yNode) {
						head = xNode;
					}					
				}
				

				break;
			}
				
			prev = tmp;
			tmp = tmp.next;
		}
		
		return head;
	}
}
