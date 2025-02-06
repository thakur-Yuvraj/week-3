package linearsearch.searchfirstnegativenumber;

public class FirstNegativeNumber {
    public static void main(String[] args) {
        int[] array = {5, 7, 8, -2, 10, -3, 4}; // Example array
        int result = findFirstNegativeNumber(array);

        if (result != -1) {
            System.out.println("First negative number found at index: " + result);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }

    // Method to find the first negative number in the array
    public static int findFirstNegativeNumber(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                return i; // Return the index of the first negative number
            }
        }
        return -1; // Return -1 if no negative number is found
    }
}
