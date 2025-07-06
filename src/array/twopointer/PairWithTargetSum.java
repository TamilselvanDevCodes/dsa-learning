package array.twopointer;


import java.util.Arrays;

/**
 * 🧠 Problem: Pair with Target Sum (Two Pointers Technique)
 *
 * Given a sorted array of integers and a target value, determine whether
 * there exists a **pair of elements** in the array whose **sum equals the target**.
 *
 * This is a classic use-case for the **Two Pointers** technique, which is highly efficient
 * for sorted arrays. Instead of using nested loops (O(n²)), we use two pointers to reduce
 * the time complexity to O(n).
 *
 * 🔍 Input:
 * - A sorted array of integers (in ascending order).
 * - An integer value `target`, which we want to find as a sum of two elements in the array.
 *
 * ✅ Output:
 * - `true` if a pair is found such that arr[i] + arr[j] == target
 * - `false` otherwise
 *
 * 🎯 Example:
 * Input:
 *   int[] arr = {1, 3, 4, 5, 7, 10, 11};
 *   int target = 9;
 * Output:
 *   true  // because 4 + 5 = 9
 *
 */
public class PairWithTargetSum {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int targetSumValue=18;
        boolean isTargetedValue=hasPairWithSum(array,targetSumValue);
        System.out.println("array : "+ Arrays.toString(array));
        System.out.println("targetSumValue : "+targetSumValue);
        System.out.println("isTargetedValue : "+isTargetedValue);

    }
    public static boolean hasPairWithSum(int[] array,int target){
        int left=0;
        int right=array.length-1;
        while (left<right){
            if(array[left]+array[right]==target){
                return  true;
            }
            else if(array[left]+array[right]<target){
                left++;
            }
            else {
                right--;
            }
        }
        return false;
    }
}
 /** 🚀 Approach:
         * 1. Initialize two pointers:
         *    - `left` at the beginning of the array (index 0)
         *    - `right` at the end of the array (index arr.length - 1)
         *
         * 2. Loop while `left < right`:
        *    - Calculate the sum of elements at left and right
        *    - If the sum equals target, return true (pair found)
        *    - If the sum is less than target, increment `left` (to increase the sum)
        *    - If the sum is greater than target, decrement `right` (to decrease the sum)
        *
        * 3. If no pair is found after the loop ends, return false
        *
        * 📈 Time Complexity: O(n)
        * 📦 Space Complexity: O(1)
        *
        * ✅ Suitable when the input array is sorted, and you need to find a target pair efficiently.*/
