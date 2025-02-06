//Challenge Problem: Compare StringBuilder, StringBuffer, FileReader, and InputStreamReader
//Problem:
//Write a program that:
//Uses StringBuilder and StringBuffer to concatenate a list of strings 1,000,000 times.
//Uses FileReader and InputStreamReader to read a large file (e.g., 100MB) and print the number of words in the file.
//Approach:
//StringBuilder and StringBuffer:
//Create a list of strings (e.g., "hello").
//Concatenate the strings 1,000,000 times using both StringBuilder and StringBuffer.
//Measure and compare the time taken for each.
//FileReader and InputStreamReader:
//Read a large text file (100MB) using FileReader and InputStreamReader.
//Count the number of words by splitting the text on whitespace characters.
//Print the word count and compare the time taken for reading the file.



package challengeproblem.comparestringbuilderstringbufferfilereaderandinputstreamreader;

public class Main {
    public static void main(String[] args) {

        // example text file
        String filePath = "src/main/java/filereader/linebylineread/someText.txt";

        // Measure time for FileReader
        long startTime = System.nanoTime();
        int wordCountFileReader = CompareFileReaderInputStreamReader.countWordsUsingFileReader(filePath);
        long endTime = System.nanoTime();
        System.out.println("Word count using FileReader: " + wordCountFileReader);
        System.out.println("Time taken using FileReader: " + (endTime - startTime) + " ms");

        // Measure time for InputStreamReader
        startTime = System.nanoTime();
        int wordCountInputStreamReader = CompareFileReaderInputStreamReader.countWordsUsingInputStreamReader(filePath);
        endTime = System.nanoTime();
        System.out.println("Word count using InputStreamReader: " + wordCountInputStreamReader);
        System.out.println("Time taken using InputStreamReader: " + (endTime - startTime) + " ms");

        // Measuring time for String Builder by appending hello multiple times
        CompareStringBuilderStringBuffer.appendWordsUsingStringBuilder("hello");

        // Measuring time for String buffer by appending hello multiple times
        CompareStringBuilderStringBuffer.appendWordsUsingStringBuffer("hello");

    }
}