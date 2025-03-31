/**
Approach: HashSet + Sequence Start Check
🧠 Key Insight:
Put all numbers in a HashSet for O(1) lookup

For each number, only start expanding if num - 1 is not in the set (i.e., it's the start of a new sequence)
**/

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int i =0; i<nums.length; i++) {
            numSet.add(nums[i]);
        }

        int longest = 0;

        for (int num: numSet) {
            int length = 0;
            if (!numSet.contains(num-1)) { // making sure this number is the first number in sequence
                length = 1;
                while (numSet.contains(num + length)) { // incrementing and checking sequence
                    length++;
                }
                longest = Math.max(longest, length);
            }

        }
        
        return longest;
    }
}
