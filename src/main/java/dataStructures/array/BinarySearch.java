package dataStructures.array;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        System.out.println(search(arr, 4));
    }

    private static int search(int[] arr, int target) {
        return binarySearch(arr, 0, arr.length-1, target);
    }

    private static int binarySearch(int[] arr, int start, int end, int target) {
        if(start > end){
            return -1;
        }
        int mid = (end+start)/2;

        if(arr[mid] == target){
            return mid;
        } else if(target  > arr[mid]){
            return binarySearch(arr, mid+1, end, target);
        } else{
            return binarySearch(arr, start, mid-1, target);
        }
    }
}
