//Problem Statement: Recursive vs Iterative Fibonacci Computation
//Objective:
//Compare Recursive (O(2ⁿ)) vs Iterative (O(N)) Fibonacci solutions.


package algorithmruntimeanalysis.fibonacciseries;

public class Main {
    public static void main(String[] args) {
        // comparing the time of iterative fibonacci vs recursive fibonacci

        // example nth term
        int term = 40;

        // iterative fibonacci time taken
        long startTime = System.nanoTime();
        System.out.println(FibonacciByIteration.getNthTerm(term));
        long endTime = System.nanoTime();
        System.out.println("Time taken by iteration : "+ Math.abs(startTime - endTime));

        // recursive fibonacci time taken
        startTime = System.nanoTime();
        System.out.println(FibonacciByRecursion.getNthTerm(term));
        endTime = System.nanoTime();
        System.out.println("Time taken by recursion : "+ Math.abs(startTime - endTime));
    }
}
