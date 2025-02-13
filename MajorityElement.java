/** 
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2

**/

/**
Approach
Create a HashMap to store the frequency of each element.
Iterate through the array and update the count in the map.
Check if any element appears more than n/2 times.
Return that element as the majority element.

Time & Space Complexity
Time Complexity: O(n) (We traverse the array once)
Space Complexity: O(n) (We store up to n elements in the HashMap)
**/


import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;
        
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            
            // If this number appears more than n/2 times, return it early
            if (countMap.get(num) > n / 2) {
                return num;
            }
        }
        
        return -1; // This should never be reached as majority element is guaranteed to exist
    }
}
