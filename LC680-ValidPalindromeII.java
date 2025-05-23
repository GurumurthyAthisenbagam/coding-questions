/**
🧠 Pattern:
✅ Two Pointers
✅ Skip and Try (when mismatch is found, try skipping either character)

Use two pointers: left at start, right at end.
While characters match, move both pointers inward.
If mismatch:
Try removing either s[left] or s[right], and check if either resulting substring is a palindrome.
If you find such a case → return true.
If more than one mismatch can't be fixed → return false.
 */

class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while (left<right) {

            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(left+1, right, s) || isPalindrome(left, right-1, s);
            }

            left ++;
            right --;
        }

        return true;
    }

    public boolean isPalindrome(int left, int right, String s) {
        while(left<right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

}

