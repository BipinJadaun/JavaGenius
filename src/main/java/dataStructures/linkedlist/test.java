package dataStructures.linkedlist;

public class test {
    public static void main(String[] args) {
        LinkedListImpl<Integer> list = new LinkedListImpl<>();
        Integer[] arr = new Integer[]{1,2,7,4,8,6,3,5,9};
        Node<Integer> head = list.addAll(arr);

        list.printList(head);
        Node mergedHead = mergeSort(head);
        list.printList(mergedHead);
    }

    static Node mergeSort(Node head)
    {
        if(head == null || head.next == null){
            return head;
        }

        Node mid = findMiddleNode(head);
        Node nextToMid = mid.next;

        mid.next = null;

        Node start = mergeSort(head);
        Node end = mergeSort(nextToMid);

        return merge(start, end);

    }

    static Node findMiddleNode(Node head){
        if(head == null || head.next == null){
            return null;
        }

        Node slow = head, fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            if(fast != null)
                slow = slow.next;
        }
        return slow;
    }

    static Node merge(Node<Integer> start, Node<Integer> end){
        if(start == null && end == null)
            return null;
        if(start == null)
            return end;
        if(end == null)
            return start;

        if(start.value < end.value){
            start.next = merge(start.next, end);
            return start;
        } else {
            end.next = merge(start, end.next);
            return end;
        }
    }
}
