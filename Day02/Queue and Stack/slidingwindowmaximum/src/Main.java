//Sliding Window Maximum
//Problem: Given an array and a window size k, find the maximum element in each sliding window of size k.
//Hint: Use a deque (double-ended queue) to maintain indices of useful elements in each window.
//


public class Main {
    public static void main(String[] args) {
        // test case
        int[] nums = {7, 2, 4};
        int k = 2;

        // getting the sliding window maximum
        int[] ans = SlidingWindowMaximum.getWindowMaximum(nums, k);

        // printing the answer array
        for (int item : ans) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}