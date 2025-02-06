package stringbuffer.concatenatestring;

public class ConcatenateString {
    public static String getConcatenateString(String[] words) {
        // string buffer object
        StringBuffer text = new StringBuffer(words.length * words[0].length());

        // looping through the words array
        for (String word : words) {
            text.append(word);
        }

        // returning the concat string
        return text.toString();
    }
}


