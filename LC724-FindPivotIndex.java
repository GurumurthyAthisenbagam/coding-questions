class Solution {
    public int pivotIndex(int[] nums) {

        int leftSum;
        int rightSum;

        int [] prefixSum = new int[nums.length];
        int [] suffixSum = new int[nums.length];

        prefixSum[0] = nums[0];
        suffixSum[nums.length-1] = nums[nums.length-1];

        for (int i = 1, j = nums.length-2; i<nums.length && j>=0; i++, j--) {
            prefixSum[i] = nums[i] + prefixSum[i-1];
            suffixSum[j] = nums[j] + suffixSum[j+1];
        }

        for (int i =0; i<nums.length; i++) {
            if (prefixSum[i] == suffixSum[i]) return i;
        }
        
        return -1;
    }
}


/**

Compute total sum of array once.
Initialize leftSum = 0.
Traverse the array:
At each index i, check if:
    leftSum * 2 + nums[i] == totalSum
If true → return i as the pivot index.
After checking all, return -1 if no pivot found.

public class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum * 2 + nums[i] == totalSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}
 */
