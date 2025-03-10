/**
Approach: Sliding Window with Frequency Count
Pattern: Sliding Window + Hashing
Time Complexity: O(N) where N is the length of s
Space Complexity: O(1) (since only 26 characters are considered)
**/


class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> startIndexes = new ArrayList<>();

        int left = 0;
        int right = left + p.length()-1;

        int[] pArray = new int[26];
        int[] sArray = new int[26];

        for(char ch: p.toCharArray()){
            pArray[ch-'a']++;
        }
        
        while(right<s.length()) {
            sArray = new int[26];
            String str=s.substring(left, right+1);
            for(char ch: str.toCharArray()){
                sArray[ch-'a']++;
            }

            if(isMatch(pArray, sArray)) {
                startIndexes.add(left);
            }


            left++; 
            right++;
            //right = left + p.length()-1;
        }

        return startIndexes;
        
    }

    boolean isMatch(int[] pArray, int[] sArray) {
        for(int i =0; i<pArray.length; i++) {
            if(pArray[i] != sArray[i]) return false;
        }
        return true;
    }
}


/**
import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] p_count = new int[26];
        int[] s_count = new int[26];

        // Fill the frequency array for p
        for (char c : p.toCharArray()) {
            p_count[c - 'a']++;
        }

        int windowSize = p.length();

        // Fill the first window
        for (int i = 0; i < windowSize; i++) {
            s_count[s.charAt(i) - 'a']++;
        }

        // Check the first window
        if (matches(p_count, s_count)) {
            result.add(0);
        }

        // Move the sliding window across s
        for (int i = windowSize; i < s.length(); i++) {
            // Include the next character in the window
            s_count[s.charAt(i) - 'a']++;

            // Exclude the character left out of the window
            s_count[s.charAt(i - windowSize) - 'a']--;

            // Check if current window is an anagram of p
            if (matches(p_count, s_count)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }

    // Helper function to compare two frequency arrays
    private boolean matches(int[] p_count, int[] s_count) {
        for (int i = 0; i < 26; i++) {
            if (p_count[i] != s_count[i]) return false;
        }
        return true;
    }
}
**/
