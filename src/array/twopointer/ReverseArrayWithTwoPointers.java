package array.twopointer;

import java.util.Arrays;

/**
 * 🧠 Problem: Reverse an Array using Two Pointers
 *
 * Given an array of integers, reverse the elements of the array **in-place**
 * (i.e., without using any extra array).
 *
 * This is a classic use of the **Two Pointers** technique where:
 * - One pointer starts from the beginning (`left`)
 * - One pointer starts from the end (`right`)
 * - The two pointers move toward each other while swapping elements
 *
 * 🔍 Input:
 *   int[] array = {1, 2, 3, 4, 5};
 *
 * ✅ Output:
 *   [5, 4, 3, 2, 1]
 *
 * 📈 Time Complexity: O(n)
 * 📦 Space Complexity: O(1) — in-place
 */

public class ReverseArrayWithTwoPointers {
    public static void main(String[] args) {
    int [] array ={1,2,3,4,5,6,7,8,9};
        System.out.println("Input Array :"+ Arrays.toString(array));
        reverseTheArray(array);
        System.out.println("Output Array :"+ Arrays.toString(array));
    }
    public static void reverseTheArray(int[]array){
        int left=0;
        int right=array.length-1;
        while(left<right){
            int temp=array[left];
            array[left]=array[right];
            array[right]=temp;
            left++;
            right--;
        }
    }
}

