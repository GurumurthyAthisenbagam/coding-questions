/**
Group skipping using two pointer. 
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int left = 0; 
        int right = 0;
        while(right<nums.length) {
            while(right+1<nums.length && nums[right] == nums[right+1]) right++;
            nums[left] = nums[right];
            right++;
            left++;
        }
        return left;
    }
}
