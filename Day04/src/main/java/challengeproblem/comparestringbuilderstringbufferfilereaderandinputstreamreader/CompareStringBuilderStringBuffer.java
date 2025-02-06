package challengeproblem.comparestringbuilderstringbufferfilereaderandinputstreamreader;

public class CompareStringBuilderStringBuffer {

    // method to append word to string builder
    public static void appendWordsUsingStringBuilder(String word) {
        // creating object of string builder

        StringBuilder stringBuilder = new StringBuilder();

        // concatenating 1 million strings to both object
        int n = 10_00_000;

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
    }

    // method to append word to string builder
    public static void appendWordsUsingStringBuffer(String word) {
        // creating object of string builder

        StringBuffer stringBuffer = new StringBuffer();

        // concatenating 1 million strings to both object
        int n = 10_00_000;

        // starting time of string builder
        long startTime = System.nanoTime();

        // adding hello to stringbuilder object
        for (int i = 0; i < n; i++) {
            stringBuffer.append(word);
        }

        // ending time of the above for loop
        long endTime = System.nanoTime();

        // printing the time taken by string builder
        System.out.println("stringBuffer Time: " + (endTime - startTime) + " ns");
    }
}
