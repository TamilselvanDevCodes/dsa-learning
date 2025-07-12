package array.slidingwindow;

import java.util.Arrays;

/**
 * 🧠 Problem: Longest Subarray of 1s After Replacing at Most K 0s
 * <p>
 * Given a binary array (consisting of only 0s and 1s) and an integer k,
 * find the length of the longest contiguous subarray that contains only 1s
 * after replacing at most k 0s with 1s.
 * <p>
 * This is a classic variable-sized Sliding Window problem.
 * <p>
 * 🔍 Input:
 * int[] inputArray = {1, 1, 0, 0, 1, 1, 1, 0, 1};
 * int k = 2;
 * <p>
 * ✅ Output:
 * 7
 * Explanation: Replace two 0s (at index 2 and 3), resulting in subarray [1, 1, 1, 1, 1, 1, 1]
 * <p>
 * 🧭 Steps to Solve:
 * 1. Use two pointers to maintain a window.
 * 2. Track the number of 0s in the current window.
 * 3. If count of 0s > k → shrink the window from the left.
 * 4. Track the maximum window size at each step.
 * <p>
 * 🧪 Edge Cases:
 * - If array has no 0s → return array length
 * - If k = 0 → return length of the longest block of consecutive 1s
 * - If array is empty → return 0
 * <p>
 * 📈 Time Complexity: O(n)
 * 📦 Space Complexity: O(1)
 */

public class LongestOnesAfterReplacement {
    public static void main(String[] args) {
        int[] inputArray = {1, 1, 0, 0, 1, 1, 1, 0, 1};
        int k = 2;

        System.out.println("Input Array: " + Arrays.toString(inputArray));
        System.out.println("Max 0s allowed to replace: " + k);

        int result = findLongestOnesAfterReplacement(inputArray, k);

        System.out.println("Longest Subarray Length after replacing at most " + k + " 0s: " + result);
    }

    /**
     * Finds the length of the longest subarray containing only 1s
     * after replacing at most k 0s with 1s.
     *
     * @param inputArray the binary array (containing only 0s and 1s)
     * @param k          the maximum number of 0s allowed to replace
     * @return the length of the longest valid subarray
     */
    public static int findLongestOnesAfterReplacement(int[] inputArray, int k) {
        int left = 0, right = 0, maxLength = 0, zeroCount = 0;
        for (; right < inputArray.length; right++) {

            if (inputArray[right] == 0) {
                zeroCount++;
                if (zeroCount > k) {
                    //checking for the left pointer for 0 value
                    while (inputArray[left] != 0) {
                        left++;
                    }
                    zeroCount--;
                    left++;
                }
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
