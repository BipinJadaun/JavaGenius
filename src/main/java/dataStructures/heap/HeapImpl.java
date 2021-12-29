package dataStructures.heap;

import javax.management.MBeanException;

public class HeapImpl {
    private int[] arr;
    private int size;
    private final int MAX_SIZE;

    public HeapImpl(int capacity) {
        this.MAX_SIZE = capacity;
        this.arr = new int[MAX_SIZE];
        this.size = 0;
    }

    public void add(int value){
        if(isFull()){
            System.out.println("Heap is full");
            return;
        }
        arr[size] = value;
        heapifyUp(size);
        size++;
    }

    public int poll(){
        if(isEmpty()){
            System.out.println("Heap is empty");
            return -1;
        }
        int min = arr[0];
        arr[0] = arr[size-1];
        size--;
        heapifyDown(0);
        return min;
    }

    public int peak(){
        if(isEmpty()){
            System.out.println("Heap is empty");
        }
        return arr[0];
    }

    private void heapifyDown(int index) {
        int left = leftChild(index);
        int right = rightChild(index);

        int smallest = index;
        if(left < size && arr[left] < arr[index]){
            smallest = left;
        }
        if(right < size && arr[right] < arr[smallest]){
            smallest = right;
        }
        if(smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void heapifyUp(int index) {
        if(index == 0){
            return;
        }
        if (index > 0 && arr[parent(index)] > arr[index]) {
            swap(index, parent(index));
            heapifyUp(parent(index));
        }
    }

    public int size(){
        return this.size;
    }
    private boolean isFull(){
        return this.size == MAX_SIZE;
    }
    private boolean isEmpty(){
        return this.size == 0;
    }
    private int parent(int i){
        return (i-1)/2;
    }
    private int leftChild(int i){
        return 2*i + 1;
    }
    private int rightChild(int i){
        return 2*i + 2;
    }
    private void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class Test{
    public static void main(String[] args) {
        HeapImpl heap = new HeapImpl(5);
        heap.add(3);
        heap.add(9);
        heap.add(2);
        heap.add(4);
        heap.add(6);
        heap.add(1); // heap is full

        System.out.println(heap.size());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll()); // heap is empty
    }
}


