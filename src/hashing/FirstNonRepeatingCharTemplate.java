package hashing;

import java.util.*;

/**
 * 🧠 Problem: First Non-Repeating Character in a String
 *
 * Given a string s, return the index of the first non-repeating character.
 * If it does not exist, return -1.
 *
 * ✨ Examples
 *  - Input:  "leetcode"      → Output: 0  (char: 'l')
 *  - Input:  "loveleetcode"   → Output: 2  (char: 'v')
 *  - Input:  "aabb"           → Output: -1
 *
 * 🧭 Typical Approaches
 *  1) Frequency array (O(n), O(1) extra space if charset is known and small, e.g., lowercase a–z)
 *  2) HashMap<Character, Integer> for counts (O(n), works for general ASCII/Unicode)
 *
 * ✅ Time Complexity: O(n)
 * ✅ Space Complexity: O(1) for fixed alphabet / O(k) for unique chars with HashMap
 *
 * 🔒 Constraints (typical; adjust as needed)
 *  - 1 <= s.length() <= 10^5
 *  - s consists of letters; may generalize to any characters
 */
public class FirstNonRepeatingCharTemplate {

    public static void main(String[] args) {
        List<String> sampleInputs = Arrays.asList(
                "leetcode",
                "loveleetcode",
                "aabb",
                "swiss",
                "x"
        );

        for (String input : sampleInputs) {
            int indexByMap   = firstUniqueCharUsingHashMap(input);

            System.out.println("Input: \"" + input + "\"");
            System.out.println("  → Index (HashMap approach): " + indexByMap);
            System.out.println();
        }
    }

    /**
     * Approach 2: HashMap for general characters (works with any charset).
     * Steps:
     *  1) Use a HashMap<Character, Integer> to count occurrences.
     *  2) Second pass: return the first index whose char has count == 1.
     *
     * @param input The input string
     * @return index of first unique character, or -1 if none
     */
    public static int firstUniqueCharUsingHashMap(String input) {
        HashMap<Character,Integer> frequency=new HashMap<>();
        for(int i=0;i<input.length();i++){
           int count= frequency.getOrDefault(input.charAt(i),0);
           count++;
           frequency.put(input.charAt(i),count);
        }
        for (int i=0;i<input.length();i++){
            if(frequency.get(input.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
