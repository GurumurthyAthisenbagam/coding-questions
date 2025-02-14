/**
Given two strings s and t, return true if t is an 
anagram
 of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

Complexity:
O(n+n)

Optizimzation: 
Use char array of size 26 for and subtract with 'a'
Then store the count as value in the integer array
Iterate and check for non zero count

**/



class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for(char c: s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c,0)+1);
        }
        for(char d: t.toCharArray()) {
            if(charCountMap.containsKey(d)){
                int count = charCountMap.get(d);
                charCountMap.put(d, count-1);
                count--;
                if(count == 0) {
                    charCountMap.remove(d);
                }
            }
            else {
                return false;
            }
        }
        return charCountMap.isEmpty()?true: false;

    }
}
