/**
We want:

The biggest value before position j (for nums[i])
The biggest value after position j (for nums[k])

To compute (nums[i] - nums[j]) * nums[k] and track the maximum

🎯 Pattern:
✅ Prefix Maximum: Best nums[i] seen so far before j
✅ Suffix Maximum: Best nums[k] after j

 */

class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        
        long[] suffixMax = new long[n];
        long[] prefixMax = new long[n];

        prefixMax[0] = nums[0];
        suffixMax[n-1] = nums[n-1];

        for (int i=1; i<n; i++) {
            prefixMax[i] = Math.max(nums[i], prefixMax[i-1]);
        }

        for (int i=n-2; i>=0; i--) {
            suffixMax[i] = Math.max(nums[i], suffixMax[i+1]);
        }

        long result = 0;
        for (int j=1; j<n-1; j++) {
            long value = (prefixMax[j-1] - nums[j]) * suffixMax[j+1];
            result = Math.max(value, result);
        }

        return result;
    }
}
