package array.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 🧠 Problem: 3Sum
 * <p>
 * Given an integer array, return all **unique triplets** [a, b, c] such that:
 * a + b + c == 0
 * <p>
 * ⚠️ Constraints:
 * - Elements in the triplet must be in different positions (i ≠ j ≠ k)
 * - Result should not contain duplicate triplets
 * <p>
 * ✅ Input:
 * int[] inputArray = {-1, 0, 1, 2, -1, -4};
 * <p>
 * ✅ Output:
 * [[-1, -1, 2], [-1, 0, 1]]
 * <p>
 * 🧭 Steps to Solve:
 * 1. Sort the array first.
 * 2. Loop through the array from index 0 to n-3 (as current element).
 * 3. For each current element, apply **two-pointer** strategy on the subarray to the right:
 * - left = i + 1, right = array.length - 1
 * - While left < right:
 * - If the sum == 0 → save triplet, skip duplicates, move both pointers
 * - If sum < 0 → move left++
 * - If sum > 0 → move right--
 * 4. Skip duplicate values for the main loop to avoid repeated triplets.
 * <p>
 * 🔄 Edge Cases:
 * - Empty array → return empty list
 * - Less than 3 elements → return empty list
 * - Many duplicates → skip while scanning
 * <p>
 * 📈 Time Complexity: O(n²)
 * 📦 Space Complexity: O(1) (excluding result list)
 */

public class ThreeSumProblem {
    public static void main(String[] args) {
        int[] inputArray = {-1, 0, 1, 2, -1, -4};

        System.out.println("Input Array: " + Arrays.toString(inputArray));

        List<int[]> result = threeSum(inputArray);

        System.out.println("Triplets with sum zero:");
        for (int[] triplet : result) {
            System.out.println(Arrays.toString(triplet));
        }
    }

    /**
     * Returns all unique triplets in the array that sum up to zero.
     *
     * @param inputArray the array of integers
     * @return a list of unique triplets
     */
    public static List<int[]> threeSum(int[] inputArray) {
        if (inputArray == null || inputArray.length < 3) {
            return null;
        }
        List<int[]> resultList= new ArrayList<>();
        Arrays.sort(inputArray);
        for(int i=0;i<inputArray.length-2;i++){
            int left = i+1, right = inputArray.length-1;
            if(i>0&&inputArray[i]==inputArray[i-1]){
                continue;//To skip the duplicates
            }
            while (left<right){
                int sum=inputArray[i]+inputArray[left]+inputArray[right];
                if(sum==0){
                    resultList.add(new int[]{inputArray[i],inputArray[left],inputArray[right]});
                    //To skip the same value in the left
                    while (left < right && inputArray[left] == inputArray[left + 1]) left++;
                    //To skip the same value in the right
                    while (left < right && inputArray[right] == inputArray[right - 1]) right--;
                    left++;
                    right--;
                }
                else if(sum<0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return resultList;
    }
}
