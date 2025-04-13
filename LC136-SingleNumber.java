/**
XOR - when you XOR same number twice it gets cancelled out.
 */
class Solution {
    public int singleNumber(int[] nums) {
        int xorNum = 0;
        for(int i=0; i<nums.length; i++) {
            xorNum ^= nums[i];
        }
        return xorNum;
    }
}
