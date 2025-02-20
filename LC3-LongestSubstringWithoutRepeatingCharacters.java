/*** 

Given a string s, find the length of the longest 
substring without duplicate characters.


Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Optimized Sliding Window Approach (O(N))
Logic:

Use two pointers (left, right) to create a window.
Expand right to include new characters.
If a duplicate is found:
Move left forward until the duplicate is removed.
Track the max length.

**/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength =0;
        HashSet<Character> charSet = new HashSet<>();
        int left=0, right =0;
        for(right =0; right< s.length(); right++){
            while(charSet.contains(s.charAt(right))) {
                // duplicate is found, move left until you remove the duplicate
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right)); // add current right to the set
            maxLength = Math.max(maxLength, (right-left)+1);
        }
        return maxLength;
    }
        
    
}
