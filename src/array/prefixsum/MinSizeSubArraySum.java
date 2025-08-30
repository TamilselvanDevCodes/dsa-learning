package array.prefixsum;

import java.util.Arrays;

/**
 * 🧠 Problem: Minimum Size SubArray Sum
 *
 * Given an array of positive integers and a target sum, find the minimal length
 * of a contiguous SubArray for which the sum is greater than or equal to the target.
 * If there is no such subarray, return 0.
 *
 * 📌 Input:
 * int[] inputArray = {2, 3, 1, 2, 4, 3};
 * int targetSum = 7;
 *
 * ✅ Output:
 * 2
 *
 * Explanation:
 * The SubArray [4, 3] has the minimal length with sum = 7.
 *
 * 📈 Time Complexity: O(n)
 * 📦 Space Complexity: O(1)
 */
public class MinSizeSubArraySum {

    public static void main(String[] args) {
        int[] inputArray = {2, 3, 1, 2, 4, 3};
        int targetSum = 7;

        System.out.println("Input Array: " + Arrays.toString(inputArray));
        System.out.println("Target Sum : " + targetSum);

        int minLength = findMinSubArrayLength(inputArray, targetSum);

        System.out.println("Minimum Length of SubArray with Sum ≥ Target: " + minLength);
    }

    /**
     * Finds the minimum length of a contiguous SubArray
     * whose sum is greater than or equal to targetSum.
     *
     * @param inputArray the input array of positive integers
     * @param targetSum  the required minimum sum
     * @return the length of the smallest such SubArray, or 0 if no such SubArray exists
     */
    public static int findMinSubArrayLength(int[] inputArray, int targetSum) {
        int n = inputArray.length;
        int minLength = Integer.MAX_VALUE; // start with a large value
        int currentSum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            currentSum += inputArray[right];

            // Shrink window while sum is valid
            while (currentSum >= targetSum) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= inputArray[left++];
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}
