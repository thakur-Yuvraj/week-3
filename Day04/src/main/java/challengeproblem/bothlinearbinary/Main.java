package challengeproblem.bothlinearbinary;


// Challenge class definition
class Challenge {
    // Method declaration finding the first positive missing value
    public static int firstMissingPositiveNumber(int[] array) {
        // Maximum element declaration

        int maxm = 0;

        // Iterating over the array, store the maximum from the array
        for (int j : array) {
            // Store the largest
            if (j > maxm) maxm = j;
        }

        // Visited array of the maximum size
        boolean[] visited = new boolean[maxm + 1];

        // Loop the array again, and mark the number presence in visited array
        for (int j : array) {
            // If number in array is greater than 0, mark the number in visited as true.
            if (j > 0) visited[j] = true;
        }

        // Iterate from 1 to maximum and look for first false element return it's index
        for(int i=1; i<=maxm; i++) {
            // Return first absent positive number
            if(!visited[i]) return i;
        }

        // If not found in visited array, then mark the maximum + 1 element as absent.
        return (maxm + 1);
    }

    // Method definition for finding the index of given target
    public static int binarySearch(int[] arr, int start, int end, int target) {
        // loop while start is smaller and equal to end
        while(start <= end) {
            // Finding mid
            int mid = start + (end - start) / 2;

            if(arr[mid] == target) return mid; // mid element is equal to target return it.
            else if(arr[mid] > target) end = mid - 1;  // mid element is greater than target, set end to mid - 1
            else start = mid + 1; // mid element is smaller than target, set start to mid + 1
        }

        // If not found in passed array return -1.
        return -1;
    }
}
public class Main {
    public static void main(String[] args) {
        // Array declaration
        int[] arr = {1, 4, 2, 56, 34};

        System.out.println("First missing positive element is: " + Challenge.firstMissingPositiveNumber(arr));

        int start = 0, end = arr.length - 1, target = 33;
        System.out.println("Result of searching for given target is: " + Challenge.binarySearch(arr, start, end, target));
    }
}