package dataStructures.array;

public class searchOrInsert {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        System.out.println(searchInsert(arr, 7));
    }

    private static int searchInsert(int[] arr, int target) {
        return searchInsert(arr, 0, arr.length-1, target);
    }

    private static int searchInsert(int[] arr, int start, int end, int target) {

        while(start <= end) {
          int mid = (start + end) / 2;
          if (arr[mid] == target) {
              return mid;
          } else if (target > arr[mid]) {
              start = mid + 1;
          } else {
              end = mid - 1;
          }
      }
        return start;
    }
}
