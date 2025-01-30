import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    // method to return maximum form each window
    public static int[] getWindowMaximum(int[] nums, int k) {
        // checking if input is valid or not
        if (k == 0 || nums.length == 0) {
            return new int[]{};
        }
        // answer array to store the maximum number
        int[] ans = new int[nums.length - k + 1];

        // a deque to store the k sized window
        Deque<Integer[]> dq = new ArrayDeque<Integer[]>();

        // iterator i to treverse the nums array
        int i;
        for (i = 0; i < k; i++) {
            // removing element in dq if they are smaller than current number
            while(!dq.isEmpty() && dq.peekLast()[0] < nums[i]) {
                dq.pollLast();
            }
            // adding element to the que
            dq.addLast(new Integer[]{nums[i], i});
        }

        // checking if dq is null
        assert dq.peekFirst() != null;

        // first maximum number
        ans[i-k] = dq.peekFirst()[0];
        for (; i < nums.length; i++) {
            assert dq.peekFirst() != null;
            ans[i-k] = dq.peekFirst()[0];

            // removing element in dq if they are smaller than current number
            while((!dq.isEmpty() && dq.peekLast()[0] < nums[i])) {
                dq.pollLast();
            }

            // adding the current number
            dq.addLast(new Integer[]{nums[i], i});
            if (dq.size() > k) {
                dq.pollFirst();
            }

            // edge case if the que is not full and peek front is out of bounds for window length k
            assert dq.peekFirst() != null;
            if (dq.peekFirst()[1] == (i-k)) {
                dq.pollFirst();
            }

            // last maximum number
            if (i == nums.length - 1) {
                assert dq.peekFirst() != null;
                ans[i-k + 1] = dq.peekFirst()[0];
            }

        }
        // returning the output
        return ans;
    }
}
