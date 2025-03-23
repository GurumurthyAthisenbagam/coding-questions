/**
"Prepare frequency count of t:
Create a map (tFreqCount) to count how many times each character appears in string t.
Set up sliding window
Use two pointers l and r to define the current window in string s.
Create another map (windowFreqCount) to track the count of characters in the current window.
Track how many required characters we ""have"":
need = number of unique characters in t.
have = number of characters that meet the required count in the current window.
Expand the window (move r from left to right):
For each character at position r in s:
Add it to windowFreqCount.
If this character is in t and its count in the window matches the required count, increment have.
Try to shrink the window (while it still satisfies the condition):
While have == need (i.e., the current window has all required characters):
Check if the current window is smaller than the previous minimum. If so, update the result.
Then try to shrink the window from the left (l):
Decrease the count of the character at s[l] in windowFreqCount.
If this character is in t and its count in the window is now less than what's required in t, decrement have.
Move the left pointer l to the right.
Continue expanding and shrinking the window until the end of the string is reached.
Return the result:
If a valid window was found, return the substring between the saved indices.
If no valid window exists, return an empty string.


Time complexity: O(s.length + t.length)
Space Complexity: O(1)"
 */

class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> tFreqCount = new HashMap<>();
        Map<Character, Integer> windowFreqCount = new HashMap<>();

        for (char ch: t.toCharArray()) {
            tFreqCount.put(ch, tFreqCount.getOrDefault(ch, 0) + 1);
        }
        
        int have = 0;
        int need = tFreqCount.size();
        int minLength = Integer.MAX_VALUE;
        int[] res = {-1, -1};

        int l=0;

        for (int r=0; r<s.length(); r++) {

            char ch = s.charAt(r);

            windowFreqCount.put(ch, windowFreqCount.getOrDefault(ch, 0) + 1);

            if (tFreqCount.containsKey(ch) && tFreqCount.get(ch).equals(windowFreqCount.get(ch))) {
                // have to use equals to compare because the maps return integer class instance
                have++;
            }

            while (have == need) {
                int currLength = r - l + 1;

                if (currLength < minLength) {
                    minLength = currLength;
                    res[0] = l;
                    res[1] = r;
                }

                // shrink the window from left
                char currLeft = s.charAt(l);
                windowFreqCount.put(currLeft, windowFreqCount.get(currLeft) - 1);

                if (tFreqCount.containsKey(currLeft) && windowFreqCount.get(currLeft) < tFreqCount.get(currLeft)) {
                    // have to check for < and not == because windowFreqCount can get bigger than tFreqCount for inputs with repetited characters.
                    have--;
                }

                l++;

            }

        }

        return (minLength == Integer.MAX_VALUE) ? "" : s.substring(res[0], res[1] +1);

    }
}
