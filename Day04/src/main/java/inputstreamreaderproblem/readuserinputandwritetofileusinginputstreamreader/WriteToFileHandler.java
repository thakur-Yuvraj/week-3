//InputStreamReader Problem 2: Read User Input and Write to File Using InputStreamReader
//Problem:
//Write a program that uses InputStreamReader to read user input from the console and write the input to a file. Each input should be written as a new line in the file.
//Approach:
//Create an InputStreamReader to read from System.in (the console).
//Wrap the InputStreamReader in a BufferedReader for efficient reading.
//Create a FileWriter to write to the file.
//Read user input using readLine() and write the input to the file.
//Repeat the process until the user enters "exit" to stop inputting.
//Close the file after the input is finished.


package inputstreamreaderproblem.readuserinputandwritetofileusinginputstreamreader;

import java.io.*;

public class WriteToFileHandler {
    public static void main(String[] args) {

        // file path of an empty file
        String filePath = "src/main/java/inputstreamreaderproblem/readuserinputandwritetofileusinginputstreamreader/sample.txt";

        // using try block to handle any io exception that may arise
        try(InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader =  new BufferedReader(inputStreamReader);
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            // consoleInput variable to store the input provided in the console
            String consoleInput;
            System.out.println("Enter text");

            // while loop to write to sample.txt file
            while ((consoleInput = bufferedReader.readLine()) != null) {

                // if text given in console is exit then we break the while loop
                if (consoleInput.equals("exit")) {
                    break;
                }

                // writing to file
                bufferedWriter.write(consoleInput);

                // for the newline
                bufferedWriter.newLine();

                // to update the file immediately
                bufferedWriter.flush();
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
