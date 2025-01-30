//Stock Span Problem
//Problem: For each day in a stock price array, calculate the span (number of consecutive days the price was less than or equal to the current day's price).
//        Hint: Use a stack to keep track of indices of prices in descending order.


public class Main {
    // method to print array
    public static void printArr(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // example of stock price array
        int[] stock = {2, 3, 2, 1, 9, 6, 4, 7, 2, 1};
        // getting the stock span
        int[] stockSpan = StockSpanSolver.getStockSpan(stock);
        printArr(stockSpan);
    }
}