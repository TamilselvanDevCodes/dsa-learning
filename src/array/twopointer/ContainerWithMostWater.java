package array.twopointer;

import java.util.Arrays;

/**
 * 🧠 Problem: Container With Most Water
 * <p>
 * You are given an array of positive integers `height`, where each element represents the height of a vertical line drawn at that index.
 * The lines form sides of containers. Find **two lines** that together with the x-axis form a container, such that the container contains the **most water**.
 * <p>
 * The **amount of water** a container can store is determined by:
 * - `min(height[left], height[right]) * (right - left)`
 * <p>
 * This can be solved efficiently using the **Two Pointers** technique:
 * - One pointer starts from the beginning (`leftPointer`)
 * - One from the end (`rightPointer`)
 * - Move the pointer that points to the **shorter** line inward to find potentially higher area
 * <p>
 * 🔍 Input:
 * int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
 * <p>
 * ✅ Output:
 * 49
 * <p>
 * 💡 Why 49?
 * - max area is formed between lines at index 1 and 8:
 * min(8, 7) * (8 - 1) = 7 * 7 = 49
 * <p>
 * 🧭 Steps to Solve:
 * 1. Initialize two pointers: `left = 0`, `right = height.length - 1`
 * 2. Calculate current area: min(height[left], height[right]) * (right - left)
 * 3. Track the max area seen so far
 * 4. Move the pointer pointing to the shorter line inward (why? potential for taller line)
 * 5. Repeat until left meets right
 * <p>
 * 📈 Time Complexity: O(n)
 * 📦 Space Complexity: O(1)
 */

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heightArray = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println("Input Height Array: " + Arrays.toString(heightArray));

        int maxArea = getMaxWaterContainerArea(heightArray);

        System.out.println("Maximum Water Container Area: " + maxArea);
    }

    /**
     * Calculates the maximum area of water that can be contained between two lines.
     *
     * @param heightArray array of heights representing lines
     * @return the maximum area of water the container can store
     */
    public static int getMaxWaterContainerArea(int[] heightArray) {
        int left = 0, right = heightArray.length - 1, maxArea = 0;
        while (left < right) {
            int currentArea = Math.min(heightArray[left], heightArray[right]) * (right - left);
            maxArea=Math.max(maxArea,currentArea);
            if (heightArray[left] < heightArray[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
