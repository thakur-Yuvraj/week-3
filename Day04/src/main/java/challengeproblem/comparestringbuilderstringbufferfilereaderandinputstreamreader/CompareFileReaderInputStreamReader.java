package challengeproblem.comparestringbuilderstringbufferfilereaderandinputstreamreader;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CompareFileReaderInputStreamReader {
    // Method to count words using FileReader
    public static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += countWordsInLine(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file using FileReader: " + e.getMessage());
        }
        return wordCount;
    }

    // Method to count words using InputStreamReader
    public static int countWordsUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try (InputStream inputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += countWordsInLine(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file using InputStreamReader: " + e.getMessage());
        }
        return wordCount;
    }

    // Helper method to count words in a single line
    private static int countWordsInLine(String line) {
        if (line == null || line.isEmpty()) {
            return 0;
        }
        String[] words = line.split("\\s+"); // Split on whitespace
        return words.length;
    }
}
