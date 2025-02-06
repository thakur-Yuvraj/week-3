//StringBuilder Problem 1: Reverse a String Using StringBuilder
//Problem:
//Write a program that uses StringBuilder to reverse a given string. For example, if the input is "hello", the output should be "olleh".
//Approach:
//Create a new StringBuilder object.
//Append the string to the StringBuilder.
//Use the reverse() method of StringBuilder to reverse the string.
//Convert the StringBuilder back to a string and return it.



package stringbuilder.reversestringusingstringbuilder;

public class ReverseStringByStringBuilder {
    public static void main(String[] args) {
        // example string
        String word = "hello";

        // creating string builder object
        StringBuilder revString = new StringBuilder(word.length());

        // appending the string to the string builder
        revString.append(word);

        // Use the reverse() method of StringBuilder to reverse the string.
        revString.reverse();

        // converting the string builder back to a string
        String wordReverse = revString.toString();

        // printing the reverse word
        System.out.println(wordReverse);

    }
}
