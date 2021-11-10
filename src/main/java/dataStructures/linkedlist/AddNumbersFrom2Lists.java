package dataStructures.linkedlist;

import java.util.Stack;

public class AddNumbersFrom2Lists {
    public static void main(String[] args) {
        LinkedListImpl<Integer> list1 = new LinkedListImpl<>();
        Integer[] arr1 = new Integer[]{8,2,9};
        Node<Integer> head1 = list1.addAll(arr1);

        LinkedListImpl<Integer> list2 = new LinkedListImpl<>();
        Integer[] arr2 = new Integer[]{1,8,9};
        Node<Integer> head2 = list2.addAll(arr2);

        Node<Integer> addedList = addLists(head1, head2);

        list1.printList(addedList);

    }

    private static Node<Integer> addLists(Node<Integer> head1, Node<Integer> head2) {

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        LinkedListImpl<Integer> result = new LinkedListImpl<>();

        while(head1 != null){
            st1.push(head1.value);
            head1 = head1.next;
        }
        while(head2 != null){
            st2.push(head2.value);
            head2 = head2.next;
        }
        int carry = 0, sum = 0;
        while(!st1.isEmpty() || !st2.isEmpty()){
            int a = 0, b = 0;
            if(!st1.isEmpty()){
                a = st1.pop();
            }
            if(!st2.isEmpty()){
                b = st2.pop();
            }
            sum = a + b + carry;
            carry = sum / 10;
            sum = sum % 10;

            result.addFirst(sum);
        }
        if(carry != 0){
            result.addFirst(carry);
        }

        return result.getHeadNode();
    }
}

