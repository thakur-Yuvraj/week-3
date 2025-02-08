package algorithmruntimeanalysis.largefilereading;

import java.io.FileReader;
import java.io.IOException;

class ReadUsingFileReader {

    // Method to read file
    static void readFile(String filePath) {
        try (FileReader fileReader = new FileReader(filePath);){
            int c;
            while((c = fileReader.read()) != -1) {
//                  System.out.print((char)c);
            }
        } catch (IOException e) {
            System.out.println("Exception Occured");
            throw new RuntimeException(e);
        }
    }
}
