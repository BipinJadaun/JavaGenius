package dataStructures.array;

public class FrequencyCount {
    public static void main(String[] args) {
        int [] arr = new int[]{3,2,2,1,2};
        countFrequency(arr, arr.length, 3);
    }

    private static void countFrequency(int[] arr, int N, int P) {
        int[] freq = new int[P];

        for(int i = 0; i<N; i++){
            int num = arr[i];
            freq[num-1]++;
        }

        System.arraycopy(freq,0, arr, 0, N);
    }
}
