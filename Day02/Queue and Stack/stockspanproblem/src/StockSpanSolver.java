
import java.util.Stack;

public class StockSpanSolver {
    // method to find and return stock span
    public static int[] getStockSpan(int[] stock) {
        // stack object to store a pair
        Stack<Pair> stk = new Stack<>();

        // answer array to store number of consecutive days
        int[] span = new int[stock.length];

        // looping through the stock and observing the price and storing the price in stack stk
        for (int i = 0; i < stock.length; i++) {
            int curPrice = stock[i];

            // if stock price is bigger then the last day in stack
            while(!stk.isEmpty() && stk.peek().first < curPrice) {
                Pair temp = stk.pop();
                // updating the span array
                span[temp.second] = Math.abs(temp.second - i);
            }
            // pushing the current price
            stk.push(new Pair(curPrice, i));
        }

        // some pairs are not compared so we need to calculate with respect to stock endpoint
        while(!stk.isEmpty()) {
            Pair temp = stk.pop();
            // stock endpoint is stock.length
            span[temp.second] = Math.abs(temp.second - stock.length);
        }
        return span;
    }
}
