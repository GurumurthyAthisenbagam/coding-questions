/**
Optimal Approach (Two Pointers)
Use two pointers:

lastNonZeroIndex tracks the position to put the next non-zero element.

Iterate through the array:

If the current element is non-zero, place it at lastNonZeroIndex, and increment lastNonZeroIndex.

After that, fill the rest of the array with 0s.
 */

class Solution {
    public void moveZeroes(int[] nums) {

        int nonZeroIndex = 0;

        for (int i = 0; i<nums.length; i++) {
            if(nums[i] !=0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }

        for(int i = nonZeroIndex; i<nums.length; i++) {
            nums[i] =0;
        }
        
    }
}
