/**
Approach: Binary Search
Search between 1 and max(ribbons[]) for the possible ribbon length.

For each mid length:
Count how many ribbons we can cut.
If count >= k → possible → try longer ribbon.
If count < k → ribbon length too big → try smaller ribbon.

✅ Binary search for the maximum valid ribbon length.

 */
class Solution {
    public int maxLength(int[] ribbons, int k) {
        int left = 1; // cannot have left = 0
        int right = 0;

        for(int i: ribbons) {
            right = Math.max(right, i);
        }

        int res = 0;

        while (left<=right) {
            int mid = left + (right-left)/2;

            if (canCut(ribbons, k, mid)) {
                res = mid;
                left = mid + 1; // may be check for higher length that can be cut to k 
            }
            else {
                right = mid - 1;
            }
        }

        return res;
    }

    boolean canCut(int[] ribbons, int k, int length) {
        int count =0;
        for (int i=0; i<ribbons.length; i++) {
                count+=ribbons[i]/length;
        }

        return count >=k;
    }
}
