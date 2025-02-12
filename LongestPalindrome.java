
/**

Given a string s which consists of lowercase or uppercase letters, return the length of the longest 
palindrome
 that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

**/

/**

Approach:
Use a frequency map (via an integer array or HashMap) to count occurrences of each character.
Count even occurrences fully because they can symmetrically be used in the palindrome.
Allow at most one odd occurrence (as the central character in the palindrome).
Return the maximum possible length of the palindrome.

Explanation:
We count the frequency of each character.
If a character appears an even number of times, all of them can be used.
If a character appears an odd number of times, we can use count - 1 (the largest even portion).
If at least one odd frequency exists, we can place one odd character in the middle, increasing the palindrome length by 

Time Complexity:
O(n) where n is the length of the string (since we iterate through it twice, once for counting and once for summing the frequencies).

Optimized Approach:
Use an integer array of size 128 (since ASCII characters for English letters range within 128) to store character counts.

**/


import java.util.HashMap;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        int length = 0;
        boolean hasOdd = false;
        
        for (int count : charCount.values()) {
            if (count % 2 == 0) {
                length += count; // Even counts can be fully used
            } else {
                length += count - 1; // Use the largest even portion
                hasOdd = true; // Mark that an odd count exists
            }
        }
        
        return hasOdd ? length + 1 : length; // If any odd count exists, place one in the center
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome("abccccdd")); // Output: 7
        System.out.println(lp.longestPalindrome("AaBbCc")); // Output: 1
    }
}
