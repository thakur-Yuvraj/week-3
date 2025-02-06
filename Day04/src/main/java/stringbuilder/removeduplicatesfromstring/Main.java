//StringBuilder Problem 2: Remove Duplicates from a String Using StringBuilder
//Problem:
//Write a program that uses StringBuilder to remove all duplicate characters from a given string while maintaining the original order.
//Approach:
//Initialize an empty StringBuilder and a HashSet to keep track of characters.
//Iterate over each character in the string:
//If the character is not in the HashSet, append it to the StringBuilder and add it to the HashSet.
//Return the StringBuilder as a string without duplicates.



package stringbuilder.removeduplicatesfromstring;


public class Main {
    public static void main(String[] args) {
        // example string
        String text = "Hello, this is example text";

        // calling the removeDuplicate function to remove duplicate from string
        text = RemoveDuplicate.removeDuplicateByHashSet(text);

        // printing the text String which contains no duplicate
        System.out.println(text);

    }

}
