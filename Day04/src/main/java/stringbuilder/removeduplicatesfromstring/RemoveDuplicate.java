package stringbuilder.removeduplicatesfromstring;

import java.util.HashSet;

public class RemoveDuplicate {
    public static String removeDuplicateByHashSet(String text) {
        // creating the stringBuilder object
        StringBuilder uniqueCharFromText = new StringBuilder(text.length());

        // creating a hashSet to keep track of character occurrence
        HashSet<Character> charOccur = new HashSet<>();

        // looping through the text string
        for (int i = 0; i < text.length(); i++) {
            Character curChar = text.charAt(i);
            // checking if current character is already present in hashSet
            if (!charOccur.contains(curChar) && curChar != ' ') {
                // if char is not preset in hashSet then we add it to stringBuilder object
                uniqueCharFromText.append(curChar);
            }
            charOccur.add(curChar);
        }
        // returning the string builder object as string
        return uniqueCharFromText.toString();
    }
}
