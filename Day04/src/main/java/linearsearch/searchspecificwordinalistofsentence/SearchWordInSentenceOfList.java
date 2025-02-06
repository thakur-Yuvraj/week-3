package linearsearch.searchspecificwordinalistofsentence;

public class SearchWordInSentenceOfList {
    // Method to find the first sentence containing the target word
    public static String findSentenceWithWord(String[] sentences, String targetWord) {
        for (String sentence : sentences) {
            if (sentence.contains(targetWord)) {
                return sentence; // Return the sentence if the word is found
            }
        }
        return "Not Found"; // Return "Not Found" if the word is not found in any sentence
    }

    public static void main(String[] args) {
        // example sentence
        String[] sentences = {
                "Hello this is capgemni",
                "You are given an array of sentences (strings).",
                "Iterate through the list of sentences",
                "For each sentence, check if it contains the specific word."
        };

        // printing the found sentence otherwise if not found
        System.out.println(findSentenceWithWord(sentences, "through"));

    }
}
