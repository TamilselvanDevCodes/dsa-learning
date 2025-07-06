package array.twopointer;

import java.util.Arrays;

/**
 * 🧠 Problem: Remove Duplicates from Sorted Array
 *
 * Given a **sorted array** of integers, remove the duplicates **in-place** such that each element appears only once.
 * The relative order of the elements should be maintained.
 *
 * You must do this using **O(1)** extra memory (modify the input array in-place).
 *
 * This is a classic **Two Pointers** problem where:
 * - One pointer (`slow`) keeps track of the last unique position.
 * - The other pointer (`fast`) scans ahead to find a new unique number.
 *
 * 🔍 Input:
 *   int[] array = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
 *
 * ✅ Output:
 *   New Length = 5
 *   Modified array = [0, 1, 2, 3, 4, _, _, _, _, _]
 *
 * 🧭 Steps to Solve:
 * 1. Initialize two pointers:
 *    - `slow = 0` (index of last unique element)
 *    - `fast = 1` (starts from second element)
 * 2. Traverse the array:
 *    - If array[fast] != array[slow], it's a new unique element:
 *      - Increment slow
 *      - Set array[slow] = array[fast]
 *    - Move fast-forward in every iteration
 * 3. After the loop, all unique values are stored from index 0 to `slow`.
 * 4. The function returns `slow + 1` as the count of unique elements.
 *
 * 📈 Time Complexity: O(n)
 * 📦 Space Complexity: O(1)
 */

public class RemoveDuplicatesSortedArray {
    public static void main(String[] args) {
        int[] array = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println("Input Array  : " + Arrays.toString(array));

        int newLength = removeDuplicates(array);

        System.out.println("Output Length: " + newLength);
        System.out.println("Output Array  : " + Arrays.toString(array));
        System.out.print("Output Expected Array : ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * Removes duplicates in-place from a sorted array.
     * Returns the new length of the array with unique elements.
     *
     * @param array the sorted input array
     * @return the number of unique elements
     */
    public static int removeDuplicates(int[] array) {
        int slow=0;
        for(int fast=1;fast<array.length;fast++){
            if(array[slow]!=array[fast]){
                slow++;
                array[slow]=array[fast];
            }
        }
        return slow+1;
    }
}
