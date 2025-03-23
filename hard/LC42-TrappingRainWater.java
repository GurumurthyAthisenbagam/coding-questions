/**

prefix suffix technique

find maximum of left and right from any given point in array. 
find the minimum of the max left and max right - we doing this ebcause the water trapped will be at minimum level

then to find how much water is trapped at a specific point; 
we compute current height - minimum of the max left and max right.


 */

class Solution {
    public int trap(int[] height) {

        int n = height.length;

        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];

        for (int i= 1; i<n ; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        for (int i= n-2; i>=0 ; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int res = 0;
        for (int i=0; i<n; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return res;
    }
}
