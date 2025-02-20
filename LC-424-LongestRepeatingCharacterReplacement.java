/**
Optimal Approach: Sliding Window (O(N))
Logic:
Use a sliding window with two pointers: left and right.
Expand the window (right++) while keeping track of:
Frequency of each character.
Most frequent character count (maxFreq) inside the window.
If the number of characters to replace (window_size - maxFreq) exceeds k, shrink the window (left++).
Track the maximum window size.

 */

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int maxWindowSize =0;
        for (right = 0; right<s.length(); right++) {
            char ch = s.charAt(right);
            int count = map.getOrDefault(ch,0) + 1;
            map.put(ch,count);
            maxFreq = Math.max(maxFreq, count);
            int windowSize = (right - left) +1;
            if((windowSize - maxFreq)>k){
                char leftChar = s.charAt(left);
                int leftCount = map.get(leftChar) - 1;
                map.put(s.charAt(left),leftCount);
                left++;
            }
            maxWindowSize = Math.max(maxWindowSize, (right - left) +1);
        }
        return maxWindowSize;

    }
}

