package array.twopointer;

/**
 * 🧠 Problem: Valid Palindrome
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * A string is a palindrome if it reads the same backward as forward.
 *
 * This problem can be efficiently solved using the **Two Pointers** approach:
 * - One pointer starts at the beginning (`left`)
 * - One pointer starts at the end (`right`)
 * - Move both pointers inward:
 *   - Skip characters that are not letters or digits.
 *   - Compare characters ignoring case.
 *
 * 🔍 Input:
 *   String input = "A man, a plan, a canal: Panama";
 *
 * ✅ Output:
 *   true
 *
 * 🧭 Steps to Solve:
 * 1. Initialize two pointers: `left = 0`, `right = s.length() - 1`
 * 2. While left < right:
 *    a. Skip all non-alphanumeric characters on both sides.
 *    b. Compare characters after converting them to lowercase.
 *    c. If mismatch → return false.
 *    d. Else move both pointers.
 * 3. If loop completes → return true (it's a palindrome).
 *
 * 🧪 Edge Cases:
 * - Empty string → true
 * - String with only spaces/punctuation → true
 *
 * 📈 Time Complexity: O(n)
 * 📦 Space Complexity: O(1)
 */

public class ValidPalindrome {
    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        System.out.println("Input String : " + input);
        boolean result = isPalindrome(input);
        System.out.println("Is Palindrome: " + result);
    }

    /**
     * Checks if a given string is a valid palindrome,
     * considering only alphanumeric characters and ignoring case.
     *
     * @param inputString the input string
     * @return true if it's a valid palindrome, false otherwise
     */
    public static boolean isPalindrome(String inputString) {
        int left=0,right=inputString.length()-1;
        while (left<right){
            if(!Character.isLetterOrDigit(inputString.charAt(left))){
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(inputString.charAt(right))){
                right--;
                continue;
            }
            char leftChar=inputString.charAt(left);
            char rightChar=inputString.charAt(right);
            if(Character.toLowerCase(leftChar)!=Character.toLowerCase(rightChar)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
