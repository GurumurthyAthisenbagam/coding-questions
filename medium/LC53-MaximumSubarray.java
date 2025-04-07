/**
Dynamic Programming Approach
Initialize:
currentSum = nums[0]
largestSum = nums[0]

For each element starting from index 1:
currentSum = max(nums[i], currentSum + nums[i])
maxSum = max(maxSum, currentSum)

Return maxSum.

✅ This is O(n) time, O(1) space, and extremely efficient.
 */
class Solution {
    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int largestSum = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i] , nums[i]);
            largestSum = Math.max(largestSum, dp[i]);
        }
        
        return largestSum;
    }
}
