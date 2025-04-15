/**
Initialize two booleans: increasing = true, decreasing = true

Loop through the array:
If any pair violates increasing order → set increasing = false
If any pair violates decreasing order → set decreasing = false
If either flag is still true after the loop → it's monotonic

No need to check for values when it is same as previous 
 */

class Solution {
    public boolean isMonotonic(int[] nums) {

        if (nums.length == 1 ||nums.length == 0) return true;

        boolean increasing = true;
        boolean decreasing = true;

        for (int i=1; i< nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                decreasing = false;
            }
            else if (nums[i-1] > nums[i]) {
                increasing = false;
            }
        }

        return increasing || decreasing;
        
    }
}
