package dataStructures.linkedlist;

import dataStructures.utils.Util;

public class DeleteRandomNode {
    public static void main(String[] args) {

        LinkedListImpl<Integer> list = new LinkedListImpl<>();
        Integer[] arr = new Integer[]{1,2,3,5,7,8,9};
        Node<Integer> head = list.addAll(arr);
        Node<Integer> toDelete = list.find(5);

        list.printList(head);
        delete(toDelete);
        list.printList(head);

        LinkedListImpl<String> list1 = new LinkedListImpl<>();
        String[] arr1 = new String[]{"A","B","C","D","E","F"};
        Node<String> head1 = list1.addAll(arr1);
        Node<String> toDelete1 = list1.find("D");

        list1.printList(head1);
        delete(toDelete1);
        list1.printList(head1);

    }

    private static <E> void delete(Node<E> nodeToDelete) {
        nodeToDelete.value = nodeToDelete.next.value;
        nodeToDelete.next = nodeToDelete.next.next;
    }
}
