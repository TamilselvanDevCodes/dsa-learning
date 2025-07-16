package array.prefixsum;

import java.util.Arrays;

/**
 * 🧠 Problem: Range Sum Query – Immutable
 *
 * You are given an integer array nums. Implement a class NumArray that supports:
 *
 * - NumArray(int[] nums): Initializes the object with the integer array nums.
 * - int sumRange(int left, int right): Returns the sum of the elements of nums between indices left and right (inclusive).
 *
 * This problem is a direct application of the Prefix Sum technique.
 * Precompute prefix sums in the constructor to allow O(1) query time.
 *
 * 🔍 Input:
 *   nums = [-2, 0, 3, -5, 2, -1]
 *   sumRange(0, 2) → 1
 *   sumRange(2, 5) → -1
 *   sumRange(0, 5) → -3
 *
 * 💡 Explanation:
 *   You build a prefix array:
 *     prefix[0] = 0
 *     prefix[i] = prefix[i-1] + nums[i-1]
 *   Then sumRange(left, right) = prefix[right + 1] - prefix[left]
 *
 * 🧭 Steps to Solve:
 * 1. In the constructor, build a prefix array of length n+1
 * 2. prefix[0] = 0
 * 3. For each index i, prefix[i+1] = prefix[i] + nums[i]
 * 4. To get sum from index left to right, return prefix[right+1] - prefix[left]
 *
 * 📈 Time Complexity:
 *   Constructor: O(n)
 *   sumRange: O(1)
 *
 * 📦 Space Complexity: O(n) for the prefix array
 */

public class RangeSumImmutable {
    public static void main(String[] args) {
        int[] inputArray = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(inputArray);

        System.out.println("Input Array: " + Arrays.toString(inputArray));
        System.out.println("sumRange(0, 2): " + numArray.sumRange(0, 2));  // Expected: 1
        System.out.println("sumRange(2, 5): " + numArray.sumRange(2, 5));  // Expected: -1
        System.out.println("sumRange(0, 5): " + numArray.sumRange(0, 5));  // Expected: -3
    }
}

/**
 * Class to support range sum queries using prefix sum.
 */
class NumArray {
    // Define prefix array (optional until implemented)
    private int[] prefixSum;

    /**
     * Constructor to initialize and build prefix array
     * @param nums the original input array
     */
    public NumArray(int[] nums) {
        prefixSum =new int[nums.length];
        if(nums.length==0){
            return;
        }
        prefixSum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        System.out.println("PrefixSum : "+Arrays.toString(prefixSum));
    }

    /**
     * Returns the sum of elements between indices left and right (inclusive)
     * @param left left index
     * @param right right index
     * @return sum of elements from left to right
     */
    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left - 1];
    }

}
