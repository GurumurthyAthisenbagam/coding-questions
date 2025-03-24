/**
Use two pointers, left and right.
While left < right, check if s.charAt(left) != s.charAt(right).
If yes, change the lexicographically greater character to the smaller one.
Since only one change is allowed, stop after the first change.
If already a palindrome, check if changing any character (ideally leftmost non-'a') can make it lex smaller.

Time: O(N)
Space: O(N) — for the character array
 */

class Solution {
    public String makeSmallestPalindrome(String s) {

        char[] chars = s.toCharArray();

        int left =0;
        int right = s.length()-1; // right is n-1

        
        while (left<right) { // use < 
            if (chars[left] != chars[right]) {
                char minChar = (char) Math.min(chars[left], chars[right]);
                chars[left] = minChar;
                chars[right] = minChar;
            }
            left++;
            right--;
        }

        return new String(chars);
        
    }
}

