package algorithmruntimeanalysis.fibonacciseries;

public class FibonacciByIteration {
    // method to find nth term in fib series by iteration
    public static int getNthTerm(int n) {

        // first two term
        int a = 0;
        int b = 1;
        // next term
        int c = a + b;
        if (n == 0) return a;
        if (n == 1) return b;
        for (int i = 3; i <= n; i++) {
            a = b;
            b = c;
            c = a + b;
        }

        return c;
    }
}
