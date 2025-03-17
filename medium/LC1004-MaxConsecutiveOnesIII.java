/**
use sliding window
left pointer starts at 0
right pointer goes from 0 to end of input in a for loop
maintain a zeroCounter

when you encounter 1 at right keep moving stop when you encounter a 0, increment zero counter
move the left pointer until you encounter k number of 0s. decrement the zero counter

maintain a max count and return the max count


 */

class Solution {
    public int longestOnes(int[] nums, int k) {

        int zeroCount =0;
        int left = 0;
        int right =0;
        int max=0;

        for (right =0; right<nums.length; right++) {
            if(nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount>k) {
                if(nums[left] ==0) {
                    zeroCount--;
                }

                left++;
            }
            max = Math.max(max, (right-left) + 1);
        }
        
        return max;
    }
}
