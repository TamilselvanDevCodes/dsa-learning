package hashing;

import java.util.*;

/**
 * 🧠 Problem: Two Sum
 *
 * Given an array of integers `nums` and an integer `target`,
 * return the indices of the two numbers such that they add up to `target`.
 *
 * You may assume that each input has exactly one solution,
 * and you may not use the same element twice.
 *
 * ✨ Examples
 *  - Input: nums = [2,7,11,15], target = 9  → Output: [0,1]
 *  - Input: nums = [3,2,4], target = 6      → Output: [1,2]
 *  - Input: nums = [3,3], target = 6        → Output: [0,1]
 *
 * 🧭 Typical Approaches
 *  1) Brute Force (O(n²)) → check all pairs
 *  2) HashMap for complements (O(n)) → store value→index while iterating
 *
 * ✅ Time Complexity: O(n)
 * ✅ Space Complexity: O(n) for HashMap
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;

        int[] nums2 = {3, 2, 4};
        int target2 = 6;

        int[] nums3 = {3, 3};
        int target3 = 6;

        System.out.println("Input: " + Arrays.toString(nums1) + ", Target: " + target1);
        System.out.println("  → Output: " + Arrays.toString(twoSum(nums1, target1)));

        System.out.println("Input: " + Arrays.toString(nums2) + ", Target: " + target2);
        System.out.println("  → Output: " + Arrays.toString(twoSum(nums2, target2)));

        System.out.println("Input: " + Arrays.toString(nums3) + ", Target: " + target3);
        System.out.println("  → Output: " + Arrays.toString(twoSum(nums3, target3)));
    }

    /**
     * Approach: HashMap for complements
     * Steps:
     *  1) Initialize a HashMap<Integer, Integer> to store value → index.
     *  2) Iterate over the array:
     *      - For each number, compute complement = target - current.
     *      - If complement is already in the map, return {indexOfComplement, currentIndex}.
     *      - Otherwise, store current number and its index in the map.
     *  3) If no pair found, return {-1, -1}.
     *
     * @param nums   input array of integers
     * @param target the target sum
     * @return indices of the two numbers, or [-1, -1] if not found
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>data=new HashMap<>();
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
            int num2=target-nums[i];
            if(data.containsKey(num2)){

                result[0]=data.get(num2);
                result[1]=i;
                return  result;
            }
            data.put(nums[i],i);
        }
        return result;
    }
}
