package array.prefixsum;

import java.util.Arrays;

/**
 * 🧠 Problem: Find Pivot Index
 *
 * Given an array of integers, return the pivot index if it exists.
 * The pivot index is the index where the sum of the numbers to the left of the index
 * is equal to the sum of the numbers to the right.
 *
 * If no such index exists, return -1. If there are multiple pivot indexes, return the left-most one.
 *
 * 🔍 Input:
 *   int[] inputArray = {1, 7, 3, 6, 5, 6};
 *
 * ✅ Output:
 *   3
 *
 * 💡 Explanation:
 *   - The sum of elements to the left of index 3: 1 + 7 + 3 = 11
 *   - The sum of elements to the right of index 3: 5 + 6 = 11
 *   - So index 3 is the pivot
 *
 * 🧭 Steps to Solve:
 * 1. Compute total sum of the array
 * 2. Traverse the array while maintaining a running left sum
 * 3. At each index, check if: leftSum == totalSum - leftSum - currentElement
 * 4. If condition holds, return that index
 *
 * 📈 Time Complexity: O(n)
 * 📦 Space Complexity: O(1)
 */

public class FindPivotIndex {
    public static void main(String[] args) {
        int[] inputArray = {1, 7, 3, 6, 5, 6};

        System.out.println("Input Array: " + Arrays.toString(inputArray));

        int result = getPivotIndex(inputArray);

        System.out.println("Pivot Index: " + result);  // Expected: 3
    }

    /**
     * Finds the pivot index where left sum equals right sum
     *
     * @param inputArray the input integer array
     * @return pivot index or -1 if not found
     */
    public static int getPivotIndex(int[] inputArray) {
        if(inputArray.length<2){
            return -1;
        }
        for(int i=1;i<inputArray.length;i++){
            inputArray[i]=inputArray[i-1]+inputArray[i];
        }
        int totalSum=inputArray[inputArray.length-1];
        System.out.println("Prefix Sum "+Arrays.toString(inputArray));
        System.out.println("totalSum : "+totalSum);
        for(int i=1;i<inputArray.length-2;i++){
            if(totalSum-inputArray[i]==inputArray[i-1]){
                return i;
            }
        }
        return -1;
    }
}
