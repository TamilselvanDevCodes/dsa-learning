package array.twopointer;

import java.util.Arrays;

/**
 * 🧠 Problem: Move Zeroes to End using Two Pointers
 *
 * Given an array of integers, move all the 0's to the end of the array
 * while maintaining the relative order of the non-zero elements.
 *
 * This must be done **in-place** without using an extra array.
 *
 * This is a classic use-case of the **Two Pointers** technique where:
 * - One pointer (`right`) scans the array.
 * - The other pointer (`left`) tracks the position to place the next non-zero element.
 *
 * 🔍 Input:
 *   int[] array = {0, 1, 0, 3, 12};
 *
 * ✅ Output:
 *   [1, 3, 12, 0, 0]
 *
 * 🧭 Steps to Solve:
 * 1. Initialize `left = 0`, which will point to the next position to place a non-zero value.
 * 2. Loop through the array using `right` from 0 to array.length:
 *    - If array[right] is non-zero, swap array[left] with array[right] and increment left.
 * 3. This ensures non-zero values move forward and zeroes shift to the back.
 *
 * 📈 Time Complexity: O(n) — single pass through the array
 * 📦 Space Complexity: O(1) — in-place, no extra memory used
 */

public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] array = {0, 1, 0, 3, 12};
        System.out.println("Input Array  : " + Arrays.toString(array));
        moveZeroes(array);
        System.out.println("Output Array : " + Arrays.toString(array));
    }

    /**
     * Moves all zeroes in the array to the end while preserving the order of non-zero elements.
     * This should modify the array in-place.
     *
     * @param array the input array to process
     */
    public static void moveZeroes(int[] array) {
       int left=0;
       for(int right=0;right<array.length;right++){
           if(array[right]!=0){
               int temp=array[right];
               array[right]=array[left];
               array[left]=temp;
               left++;
           }
       }
    }
}
