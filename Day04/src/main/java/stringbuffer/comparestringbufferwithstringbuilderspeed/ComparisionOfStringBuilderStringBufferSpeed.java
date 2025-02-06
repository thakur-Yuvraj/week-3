//StringBuffer Problem 2: Compare StringBuffer with StringBuilder for String Concatenation
//Problem:
//Write a program that compares the performance of StringBuffer and StringBuilder for concatenating strings. For large datasets (e.g., concatenating 1 million strings), compare the execution time of both classes.
//Approach:
//Initialize two StringBuffer and StringBuilder objects.
//Perform string concatenation in both objects, appending 1 million strings (e.g., "hello").
//Measure the time taken to complete the concatenation using System.nanoTime() for both StringBuffer and StringBuilder.
//Output the time taken by both classes for comparison.


package stringbuffer.comparestringbufferwithstringbuilderspeed;

public class ComparisionOfStringBuilderStringBufferSpeed {
    public static void main(String[] args) {
        // creating object of string buffer and string builder
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();

        // concatenating 1 million strings to both object
        int n = 10_00_000;

        // example string
        String word = "hello";

        // starting time of string builder
        long startTime = System.nanoTime();

        // adding hello to stringbuilder object
        for (int i = 0; i < n; i++) {
            stringBuilder.append(word);
        }

        // ending time of the above for loop
        long endTime = System.nanoTime();

        // printing the time taken by string builder
        System.out.println("StringBuilder Time: " + (endTime - startTime) + " ns");

        // starting time of string buffer
        startTime = System.nanoTime();

        // adding hello to stringbuilder object
        for (int i = 0; i < n; i++) {
            stringBuffer.append(word);
        }

        // ending time of the above for loop
        endTime = System.nanoTime();

        // printing the time taken by string buffer
        System.out.println("StringBuffer Time : " + (endTime - startTime) + " ns");

    }

}
