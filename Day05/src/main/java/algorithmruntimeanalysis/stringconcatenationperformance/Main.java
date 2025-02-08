//Problem Statement: String Concatenation Performance
//        Objective:
//        Compare the performance of String (O(N²)), StringBuilder (O(N)), and StringBuffer (O(N)) when concatenating a million strings.
//        Approach:
//        Using String (Immutable, creates new object each time)
//        Using StringBuilder (Fast, mutable, thread-unsafe)
//        Using StringBuffer (Thread-safe, slightly slower than StringBuilder)


package algorithmruntimeanalysis.stringconcatenationperformance;


import java.util.Arrays;
import java.util.Random;

public class Main {

    // method to generate a random string array
    private static String[] generateRandStringArray(int size) {
        String[] data = new String[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int strLen = random.nextInt(0, 20);
            StringBuilder stringBuilder = new StringBuilder(20);
            for (int j = 0; j < strLen; j++) {
                char c = (char) (random.nextInt(26) + 'a');
                stringBuilder.append(c);
            }
            data[i] = stringBuilder.toString();
        }
        return data;
    }
    public static void main(String[] args) {
        // example data set size
        int dataSetSize = 10_000;

        // generating a random data-set
        String[] dataSet = generateRandStringArray(dataSetSize);
        System.out.println(Arrays.toString(dataSet));

        //Comparing the performance of String (O(N²)), StringBuilder (O(N)), and StringBuffer (O(N)) when concatenating thousands of strings.

        // performance of normal immutable string
        String str = "";

        System.out.println("Normal string time taken :-");
        long startTime = System.nanoTime();
        for (int i = 0; i < dataSetSize; i++) {
            str += dataSet[i];
        }
        long endTime = System.nanoTime();

        // printing the time taken by String
        System.out.println(Math.abs(startTime - endTime));

        System.out.println("String builder time taken :-");
        // performance of stringBuilder
        StringBuilder stringBuilder = new StringBuilder();

        startTime = System.nanoTime();
        for (int i = 0; i < dataSetSize; i++) {
            stringBuilder.append(dataSet[i]);
        }
        endTime = System.nanoTime();

        // printing the time taken by String builder
        System.out.println(Math.abs(startTime - endTime));

        System.out.println("String buffer time taken :-");
        // performance of stringBuffer
        StringBuffer stringBuffer = new StringBuffer();

        startTime = System.nanoTime();
        for (int i = 0; i < dataSetSize; i++) {
            stringBuffer.append(dataSet[i]);
        }
        endTime = System.nanoTime();

        // printing the time taken by String buffer
        System.out.println(Math.abs(startTime - endTime));

    }
}
