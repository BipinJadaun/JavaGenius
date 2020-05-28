package algorithms.searching;

/**
 * @author bipin.kumar
 * Linear or sequential search algorithm searches the required element by comparing it with all the array elements one by one.
 * The time complexity of linear search algorithm is O(n).
 */
public class LinearSearch {

    public static void main(String[] args) {
        int[] array = {20, 35, 7, -22, 55, 1, 9, -5};
        int elementToBeSearched = 55;

        int index = searchElement(array, elementToBeSearched);

        if (index == -1){
            System.out.println("element not found");
        }else{
            System.out.println(String.format("element %s found at index %s", elementToBeSearched, index));
        }
    }

    private static int searchElement(int[] array, int elementToBeSearched) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == elementToBeSearched){
                return i;
            }
        }
        return -1;
    }
}
