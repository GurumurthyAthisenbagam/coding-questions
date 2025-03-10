/**
same logic as palindromic substring, keep track fo length and return the 
maxLength substring
 */

class Solution {
    String str;
    int maxPal = Integer.MIN_VALUE;
    public String longestPalindrome(String s) {

        for(int i=0; i<s.length(); i++) {
            String str1 = expandToPalindrome(s, i,i);
            if (maxPal< str1.length()) {
                maxPal = str1.length();
                str = str1;

            }
            String str2 = expandToPalindrome(s, i,i+1);

            if (maxPal< str2.length()) {
                maxPal = str2.length();
                str = str2;

            }
        }
        return str;
    }

    String expandToPalindrome (String s, int left, int right) {
        String str = "";
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            str = s.substring(left, right+1);
            right++;
            left--;
        }
        
        return str;
    }
}
