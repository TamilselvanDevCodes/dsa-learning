package array.twopointer;

import java.util.Arrays;

/**
 * 🧠 Problem: Two Sum II – Input Array is Sorted
 *
 * Given a **1-indexed** sorted array of integers, find two numbers such that they add up to a specific target number.
 * Return the indices of the two numbers as a new int array of size 2.
 *
 * The solution must use **constant extra space** and run in **O(n)** time.
 *
 * ✅ Important Notes:
 * - The input array is sorted in **non-decreasing** order.
 * - Exactly one solution exists.
 * - Return **1-based** indices (not zero-based).
 *
 * This is a classic **Two Pointers** problem:
 * - Use one pointer starting from the beginning (`leftPointer`)
 * - One pointer from the end (`rightPointer`)
 * - Move the pointers inward depending on the sum
 *
 * 🔍 Input:
 *   int[] sortedArray = {2, 7, 11, 15};
 *   int targetSum = 9;
 *
 * ✅ Output:
 *   [1, 2]   // Because 2 + 7 = 9
 *
 * 🧭 Steps to Solve:
 * 1. Initialize `leftPointer = 0`, `rightPointer = array.length - 1`
 * 2. While left < right:
 *    - Calculate current sum = array[left] + array[right]
 *    - If sum == target → return [left+1, right+1]
 *    - If sum < target → move leftPointer rightward
 *    - If sum > target → move rightPointer leftward
 *
 * 📈 Time Complexity: O(n)
 * 📦 Space Complexity: O(1)
 */

public class TwoSumSortedArray {
    public static void main(String[] args) {
        int[] sortedArray = {2, 7, 11, 15};
        int targetSum = 9;

        System.out.println("Input Array : " + Arrays.toString(sortedArray));
        System.out.println("Target Sum  : " + targetSum);

        int[] result = findTwoSum(sortedArray, targetSum);

        System.out.println("Output Indexes (1-based): " + Arrays.toString(result));
    }

    /**
     * Finds two numbers in the sorted array that add up to the given target sum.
     * Returns the 1-based indices of those two numbers.
     *
     * @param sortedArray the input sorted array
     * @param targetSum the target sum to find
     * @return an int array with two 1-based indices
     */
    public static int[] findTwoSum(int[] sortedArray, int targetSum) {
        int left=0,right=sortedArray.length-1;
        while (left<right){
            int currentSum=sortedArray[left]+sortedArray[right];
            if(currentSum==targetSum){
                int [] array=new int[2];
                array[0]=left+1;
                array[1]=right+1;
                return array;
            }
            else if(currentSum<targetSum){
                left++;
            }
            else {
                right--;
            }
        }
        return null;
    }
}
