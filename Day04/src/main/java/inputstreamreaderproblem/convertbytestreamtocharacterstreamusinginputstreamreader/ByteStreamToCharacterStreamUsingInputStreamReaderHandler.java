//InputStreamReader Problem 1: Convert Byte Stream to Character Stream Using InputStreamReader
//Problem:
//Write a program that uses InputStreamReader to read binary data from a file and print it as characters. The file contains data encoded in a specific charset (e.g., UTF-8).
//Approach:
//Create a FileInputStream object to read the binary data from the file.
//Wrap the FileInputStream in an InputStreamReader to convert the byte stream into a character stream.
//Use a BufferedReader to read characters efficiently from the InputStreamReader.
//Read the file line by line and print the characters to the console.
//Handle any encoding exceptions as needed.


package inputstreamreaderproblem.convertbytestreamtocharacterstreamusinginputstreamreader;

import java.io.*;

public class ByteStreamToCharacterStreamUsingInputStreamReaderHandler {
    public static void main(String[] args) {

        // example file text to demonstrate buffered reader
        String filePath = "src/main/java/filereader/linebylineread/someText.txt";

        // file encoding
        String charset = "                                                                                       ";

        // making all objects in try block to handle exception
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line;

            // reading the file line by line
            while ((line = bufferedReader.readLine()) != null) {
                // printing each line to the console
                System.out.println(line);
            }
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }

    }

}

