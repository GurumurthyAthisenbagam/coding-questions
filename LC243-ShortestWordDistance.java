/***
Algorithm

Initialize:
index1 = -1 → tracks the last seen index of word1.
index2 = -1 → tracks the last seen index of word2.
minDistance = Integer.MAX_VALUE → stores the minimum distance.

Iterate through wordsDict:
If wordsDict[i] == word1, update index1.
If wordsDict[i] == word2, update index2.
If both indices are updated, compute abs(index1 - index2) and update minDistance.
Return minDistance.

Time Complexity
O(n) → We scan wordsDict once.

Space Complexity
O(1) → No extra space is used.

 */

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int minDist = Integer.MAX_VALUE;

        for (int i=0; i<wordsDict.length; i++) {
            if (word1.equals(wordsDict[i])) {
                index1 = i;
            }
            else if (word2.equals(wordsDict[i])) {
                index2 = i;
            }
            if (index1!=-1 && index2!=-1) {
                minDist = Math.min(minDist, Math.abs(index1-index2));
            }
        }

        return minDist;
    }
}
