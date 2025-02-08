package algorithmruntimeanalysis.largefilereading;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadUsingInputStreamReader {

    // Method to read from a file using input stream reader
    static void readFile(String filePath) throws IOException {
        try(FileInputStream fileInputStream = new FileInputStream(filePath);
            InputStreamReader reader = new InputStreamReader(fileInputStream);){
            int c;
            while((c = reader.read()) != -1) {
//                  System.out.print((char) c);
            }
            reader.close();
            fileInputStream.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}