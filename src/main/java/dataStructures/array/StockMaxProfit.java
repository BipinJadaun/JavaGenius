package dataStructures.array;

public class StockMaxProfit {

    public static void main(String[] args) {
        int price[] = { 100, 180, 260, 310, 40, 535, 695 };

    }

    private static void findMaxProfit(int[] stocks){
        int size = stocks.length;
        for (int i = 0; i < size; i++) {
            while(i < size-1 && stocks[i] < stocks[i+1])
                i++;
        }
    }
}
