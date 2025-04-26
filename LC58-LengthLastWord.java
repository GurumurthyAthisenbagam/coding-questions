class Solution {
    public int lengthOfLastWord(String s) {

       s = s.trim();
       int length = 0;
       int i = s.length()-1;

        while (i>=0 && s.charAt(i) != ' ') {
            i--;
        }
        return s.length()-1 - i;
    }
   
}

/**
public int lengthOfLastWord(String s) {

        String[] strs = s.split(" ");
        return strs[strs.length-1].length();
    }
 */
