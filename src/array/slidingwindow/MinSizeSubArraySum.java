package array.slidingwindow;

import java.util.Arrays;

/**
 * 🧠 Problem: Smallest SubArray with Sum ≥ Target
 *
 * Given an array of positive integers and a target sum, find the length of the ** smallest contiguous SubArray**
 * whose sum is **greater than or equal to** the target. If no such SubArray exists, return 0.
 *
 * This is a classic **Variable Size Sliding Window** problem.
 * - Use a growing/shrinking window to track the current sum.
 * - Expand the window by moving the right pointer.
 * - Shrink the window from the left as long as the window sum is ≥ target.
 * - Track the minimum length of such a window.
 *
 * 🔍 Input:
 *   int[] inputArray = {2, 3, 1, 2, 4, 3};
 *   int targetSum = 7;
 *
 * ✅ Output:
 *   2 → (SubArray [4, 3] has sum 7 and length 2)
 *
 * 🧭 Steps to Solve:
 * 1. Initialize leftPointer = 0, windowSum = 0, minLength = Integer.MAX_VALUE
 * 2. Loop rightPointer from 0 to end of array:
 *    - Add current value to windowSum
 *    - While windowSum >= target:
 *        - Update minLength with the smaller window
 *        - Subtract inputArray[leftPointer] and move leftPointer++
 * 3. If no window is found, return 0
 *
 * 📈 Time Complexity: O(n)
 * 📦 Space Complexity: O(1)
 */

public class MinSizeSubArraySum {
    public static void main(String[] args) {
        int[] inputArray = {2, 3, 1, 2, 4, 3};
        int targetSum = 7;

        System.out.println("Input Array : " + Arrays.toString(inputArray));
        System.out.println("Target Sum  : " + targetSum);

        int result = findMinSubArrayLength(inputArray, targetSum);
        System.out.println("Smallest SubArray Length with sum ≥ Target: " + result);
    }

    /**
     * Finds the length of the smallest contiguous SubArray
     * whose sum is greater than or equal to the target sum.
     *
     * @param inputArray the input array of positive integers
     * @param targetSum the target sum to meet or exceed
     * @return the minimum length of such a SubArray, or 0 if none exists
     */
    public static int findMinSubArrayLength(int[] inputArray, int targetSum) {
      int leftPointer=0,currentSum=0,minLength=Integer.MAX_VALUE;
      for(int rightPointer=0;rightPointer<inputArray.length;rightPointer++){
          currentSum+=inputArray[rightPointer];

          while(currentSum>=targetSum){
              int currentLength=rightPointer-leftPointer+1;
              minLength=Math.min(minLength,currentLength);
              currentSum-=inputArray[leftPointer];
              leftPointer++;
          }
      }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }
}