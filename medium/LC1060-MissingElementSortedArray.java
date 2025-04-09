/**
Between nums[i] and nums[i-1]:
Missing numbers = nums[i] - nums[i-1] -1;

k = k - missingNumbers;

Go through the array
Keep subtracting missing counts until you find where the k-th missing number lies.

 */

class Solution {
    public int missingElement(int[] nums, int k) {

        for (int i=1 ; i<nums.length; i++) {

            int missingNumbers = nums[i] - nums[i-1] -1;
            if (k <= missingNumbers) { // k is within range, so find lowest number and add k to it.
                return nums[i-1]+k;
            }
            k = k - missingNumbers;
        }
        
        return nums[nums.length-1] + k; // didnt find k in the array. k is after the last element. 
    }
}
