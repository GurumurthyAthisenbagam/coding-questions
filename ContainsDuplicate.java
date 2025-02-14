/**
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.


HINT: use Hashset
add() method will return false when the entry already exists. 
so can be used in condition.
 */

class Solution {
    Set<Integer> countNum = new HashSet<>();
    public boolean containsDuplicate(int[] nums) {
        
        for(int i=0; i<nums.length; i++) {
            if(!countNum.add(nums[i])) {
                return true;
            }
        }
        return false;
        
    }
}
