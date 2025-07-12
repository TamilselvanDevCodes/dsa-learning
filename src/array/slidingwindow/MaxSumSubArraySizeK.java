package array.slidingwindow;

import java.util.Arrays;

/**
 * 🧠 Problem: Maximum Sum SubArray of Size K
 *
 * Given an integer array and a number `k`, find the maximum sum of any contiguous SubArray of size `k`.
 *
 * This is a classic **Sliding Window** problem:
 * - Instead of calculating the sum of every window of size `k` using nested loops (which is O(n * k)),
 *   we can slide a window of size `k` across the array and compute the sum in O(1) for each move.
 *
 * 🔍 Input:
 *   int[] array = {2, 1, 5, 1, 3, 2};
 *   int k = 3;
 *
 * ✅ Output:
 *   9  → (from SubArray [5, 1, 3])
 *
 * 🧭 Steps to Solve:
 * 1. Initialize windowSum = 0, maxSum = 0
 * 2. Loop through the array:
 *    - Add current element to windowSum
 *    - If we’ve hit size `k`, update maxSum and subtract the element going out of the window
 * 3. Return maxSum
 *
 * 📈 Time Complexity: O(n)
 * 📦 Space Complexity: O(1)
 */

public class MaxSumSubArraySizeK {
    public static void main(String[] args) {
        int[] inputArray = {2, 1, 5, 1, 3, 2};
        int windowSize = 3;

        System.out.println("Input Array  : " + Arrays.toString(inputArray));
        System.out.println("Window Size  : " + windowSize);

        int result = findMaxSumSubArray(inputArray, windowSize);
        System.out.println("Maximum Sum of SubArray of size K: " + result);
    }

    /**
     * Returns the maximum sum of any contiguous SubArray of size k.
     *
     * @param inputArray the input array of integers
     * @param windowSize the size of the sliding window (k)
     * @return the maximum sum found
     */
    public static int findMaxSumSubArray(int[] inputArray, int windowSize){
        int arrayLength=inputArray.length;
        if(arrayLength<windowSize){
            return -1;
        }
        int maxSum=0,windowSum=0;
        //Calculate the sum for the first window
        for(int i=0;i<windowSize;i++){
            windowSum+=inputArray[i];
        }
        maxSum=windowSum;
        //Calculating the sums for the remaining windows
        for(int i=windowSize;i<arrayLength;i++){
            windowSum+=inputArray[i]-inputArray[i-windowSize];
            maxSum=Math.max(windowSum,maxSum);
        }
        return maxSum;
    }
}
