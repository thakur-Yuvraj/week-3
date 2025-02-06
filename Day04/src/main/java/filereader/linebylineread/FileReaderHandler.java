//FileReader Problem 1: Read a File Line by Line Using FileReader
//Problem:
//Write a program that uses FileReader to read a text file line by line and print each line to the console.
//        Approach:
//Create a FileReader object to read from the file.
//Wrap the FileReader in a BufferedReader to read lines efficiently.
//Use a loop to read each line using the readLine() method and print it to the console.
//Close the file after reading all the lines.


package filereader.linebylineread;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileReaderHandler {
    public static void main(String[] args) {

        // example file text to demonstrate buffered reader
        String filePath = "C:\\Users\\DEVIL\\Desktop\\Capgemni\\week03Temp\\Day-4\\src\\main\\java\\filereader\\linebylineread\\someText.txt";

        // creating buffer reader object form fileReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            // first line
            String line = bufferedReader.readLine();
            do {
                System.out.println(line);

                // getting the next line
                line = bufferedReader.readLine();
            }while(line != null);
        }
        // using try catch block for file not found exception
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}