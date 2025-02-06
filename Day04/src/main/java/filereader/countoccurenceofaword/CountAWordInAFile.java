//FileReader Problem 2: Count the Occurrence of a Word in a File Using FileReader
//Problem:
//Write a program that uses FileReader and BufferedReader to read a file and count how many times a specific word appears in the file.
//Approach:
//Create a FileReader to read from the file and wrap it in a BufferedReader.
//Initialize a counter variable to keep track of word occurrences.
//For each line in the file, split it into words and check if the target word exists.
//Increment the counter each time the word is found.
//Print the final count.


package filereader.countoccurenceofaword;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class CountAWordInAFile {
    public static void main(String[] args) {

        // example file text to demonstrate buffered reader
        String filePath = "C:\\Users\\DEVIL\\Desktop\\Capgemni\\week03Temp\\Day-4\\src\\main\\java\\filereader\\linebylineread\\someText.txt";

        // example target word
        String targetWord = "FileReader";
        // counter
        int occurrenceOfTargetWord = 0;
        // creating buffer reader object form fileReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            // first line
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] lineArr = line.split(" ");

                for (String s : lineArr) {
                    if (s.equals(targetWord)) {
                        occurrenceOfTargetWord++;
                    }
                }
                // getting the next line
                line = bufferedReader.readLine();
            }
        }
        // using try catch block for file not found exception
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // printing the occurrence of target word
        System.out.println("the word " + targetWord + " occurred : " + occurrenceOfTargetWord + " Times");

    }
}