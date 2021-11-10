package dataStructures.linkedlist;

public class LinkedListImpl<E> {

    Node<E> head;
    int size = 0;

    public Node<E> addFirst(E value){
        if(head == null){
            head = new Node<>(value);
        } else {
            Node<E> temp = new Node<>(value);
            temp.next = head;
            head = temp;
        }
        size++;
        return this.head;
    }
    // add last
    public Node<E> add(E value){
        if(head == null){
            head = new Node<>(value);
        } else {
            Node<E> temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node<>(value);
        }
        size++;
        return this.head;
    }

    public Node<E> addAll(E[] arr) {
        for (E e: arr) {
            this.add(e);
        }
        return this.head;
    }

    public Node<E> find(E value){
        Node<E> temp = head;
        while(temp != null){
            if(temp.value == value){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void printList(Node<E> headNode){
        Node<E> temp = headNode;
        while (temp != null){
            System.out.print(temp.value +" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node<E> getHeadNode() {
        return head;
    }
}

class Node<E> {
    E value;
    Node<E> next;

    public Node(E value) {
        this.value = value;
        this.next = null;
    }
}