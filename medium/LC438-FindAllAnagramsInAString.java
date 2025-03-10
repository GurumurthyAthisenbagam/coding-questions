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
