package algorithmruntimeanalysis.fibonacciseries;

public class FibonacciByRecursion {

    // method to find nth term in fib series by recursion
    public static int getNthTerm(int n) {
        // base cases
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return getNthTerm(n-1) + getNthTerm(n-2);
    }
}
