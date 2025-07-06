package array.twopointer;

import java.util.Arrays;

/**
 * 🧠 Problem: Square of a Sorted Array
 *
 * Given a sorted array of integers (in non-decreasing order), return a new array containing
 * the squares of each number, **also sorted in non-decreasing order**.
 *
 * ⚠️ Note: The input array may contain **negative numbers**. Squaring a negative value
 * can make it larger than some positive numbers, so we cannot simply square and return.
 *
 * This is a perfect candidate for the **Two Pointers** approach:
 * - One pointer starts at the beginning of the array (`left`)
 * - One pointer starts at the end of the array (`right`)
 * - Compare the absolute values and insert the **larger square** at the end of the result array
 *
 * 🔍 Input:
 *   int[] array = {-7, -3, 0, 2, 5};
 *
 * ✅ Output:
 *   [0, 4, 9, 25, 49]
 *
 * 🧭 Steps to Solve:
 * 1. Create a result array of the same size.
 * 2. Use two pointers: `left = 0`, `right = array.length - 1`.
 * 3. Start filling the result array from the **end** (largest square first).
 * 4. In each step:
 *    - Compare `Math.abs(array[left])` and `Math.abs(array[right])`
 *    - Square the larger one and place it at the current end of result
 *    - Move the respective pointer (left or right)
 * 5. Continue until all positions in the result are filled.
 *
 * 📈 Time Complexity: O(n)
 * 📦 Space Complexity: O(n) for output array
 */

public class SquareOfSortedArray {
    public static void main(String[] args) {
        int[] array = {-7, -3, 0, 2, 5};
        System.out.println("Input Array  : " + Arrays.toString(array));

        int[] result = sortedSquares(array);

        System.out.println("Output Array : " + Arrays.toString(result));
    }

    /**
     * Returns a new array containing squares of each number in the input array,
     * sorted in non-decreasing order.
     *
     * @param array the input sorted array (may contain negatives)
     * @return the sorted array of squared values
     */
    public static int[] sortedSquares(int[] array) {
        int[] outputArray=new int[array.length];
        int left=0;
        int right=array.length-1;
        int position=right;
        while(left<=right){
            int leftAbs =Math.abs(array[left]);
            int rightAbs =Math.abs(array[right]);

            if(leftAbs>rightAbs){
                outputArray[position]=leftAbs*leftAbs;
                left++;
            }
            else{
                outputArray[position]=rightAbs*rightAbs;
                right--;
            }
            position--;
        }
        return outputArray;
    }
}
