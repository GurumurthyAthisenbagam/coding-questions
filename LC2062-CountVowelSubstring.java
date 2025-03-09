/***
Optimal Approach: Sliding Window + HashSet
Pattern: Sliding Window + HashSet for Unique Vowels

Idea:

Use a sliding window to find substrings containing only vowels.
Use a HashSet to track unique vowels in the current window.
Expand the window to the right:
If the current character is a vowel, add it to the set.
If it’s not a vowel, reset the window and the set.
Check if the set contains all 5 vowels:
If yes, count the substring.
Move the starting point of the window when a non-vowel is encountered.

 */


class Solution {
    Set<Character> vowels = new HashSet<>();
    List<String> subStrs = new ArrayList<>(); 
    int count =0;

    public int countVowelSubstrings(String word) {

        for(int i=0; i<word.length();i++) {
            vowels = new HashSet<>();
            for(int j =i; j<word.length(); j++) {
                char ch = word.charAt(j);
                if ((ch == 'a') || (ch =='e') || (ch == 'i')|| (ch == 'o')|| (ch == 'u')) {
                    vowels.add(ch);
                    if (vowels.size() == 5) count++;
                } else {
                    break;
                }
            }
        }
            
        return count;

        
    }
}
