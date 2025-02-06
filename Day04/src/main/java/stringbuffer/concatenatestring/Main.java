package stringbuffer.concatenatestring;

public class Main {
    public static void main(String[] args) {
        // example array of strings
        String[] words = {"some", "example", "words", "that", "need", "to", "be", "Concatenate"};

        // concatenating the array by get concat string method
        String concatWord = ConcatenateString.getConcatenateString(words);

        // printing the concat word
        System.out.println(concatWord);
    }
}

