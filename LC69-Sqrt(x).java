/**
Approach 1: Binary Search (Efficient)

Intuition
The square root of x lies between 0 and x.
We use binary search to find the integer part of sqrt(x).
If mid * mid == x, return mid.
If mid * mid < x, move left to mid + 1 and store mid as a potential answer.
If mid * mid > x, move right to mid - 1.

Time Complexity:
O(log x) → Binary search reduces the range by half in each step.
Space Complexity:
O(1) → No extra space used.


 */

class Solution {
    public int mySqrt(int x) {

        if (x == 0 || x == 1) return x;

        long right =x; // test fails for when x = int max; use long
        long left  =1;
        long ans =0;
        while (left<=right) {
            long mid = left+(right-left)/2;

            if (mid*mid == x) { 
                return (int) mid;
            }
            else if (mid*mid < x) {
                ans = mid; // when mid is less than x, we choose answer as mid because we want to  we round it down to the nearest integer.
                left = mid+1;
            }
            else if(mid*mid > x) {
                right = mid-1;
            }

        }
        return (int )ans;
    }
}
