/**
We want the shortest subarray that includes all occurrences of the most frequent element(s).

Steps:
Calculate degree of the array.

For each number, store:

First occurrence
Last occurrence
Frequency

For all numbers with frequency == degree:
Calculate length = last - first + 1
Track the minimum length
 */

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>(); // num -> count
        Map<Integer, Integer> firstMap = new HashMap<>(); // num -> first index
        Map<Integer, Integer> lastMap = new HashMap<>(); // num -> last index

        for (int i=0; i<nums.length; i++) {
            freqMap.put(nums[i] , freqMap.getOrDefault(nums[i], 0) + 1);
            if(!firstMap.containsKey(nums[i])) firstMap.put(nums[i], i);
            lastMap.put(nums[i], i);
        }

        int minLength = nums.length;

        int maxFreq = Collections.max(freqMap.values());

        for (int num: freqMap.keySet()) {
            if (freqMap.get(num) == maxFreq) {
                minLength = Math.min(minLength, lastMap.get(num) - firstMap.get(num) + 1);
            }
        }

        return minLength;
    }
}
