/**
    p is pile array
    o(log(max(p)) * size(p))
 */

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r= Arrays.stream(piles).max().getAsInt();
        int res=r;

        while (l<=r) {
            long totalTime = 0; // the testcase was checking for pile size larger than int MAX
            //int k = (l + r) / 2;
            int k = l + (r-l)/2;

            for (int pile: piles) {
               
                totalTime = totalTime + (int )Math.ceil((double)pile/k);
            }

            if(totalTime > h) {
                l= k+1;
            } else {
                r=k-1;
                res = k;
            }
        }
        return res;
    }
}
