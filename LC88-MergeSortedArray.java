/**

Use three pointers:
first → last real element in nums1: m - 1
second → last element in nums2: n - 1

index → last index of nums1: m + n - 1

Compare nums1[first] and nums2[second] from the back and fill nums1[index] from the end to start. This avoids overwriting.
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = m - 1;
        int second = n - 1;
        int index = m + n - 1;

        // Merge from the back
        while (first >= 0 && second >= 0) {
            if (nums1[first] > nums2[second]) {
                nums1[index--] = nums1[first--];
            } else {
                nums1[index--] = nums2[second--];
            }
        }

        // If nums2 has remaining elements
        while (second >= 0) {
            nums1[index--] = nums2[second--];
        }

        // No need to copy from nums1 — remaining nums1 values are already in place
    }
}









/**
Start from ends of array and sort in descending order
Start filling from the end of first array which has space for m+n. 
 
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int first = m-1;
        int second = n-1;
        int firstEnd = nums1.length-1;

        while (first >= 0 && second >= 0 && firstEnd>0) {
            if (nums1[first] > nums2[second]) {
                nums1[firstEnd] = nums1[first];
                first--;
                firstEnd--;
            }
            else if (nums2[second] > nums1[first]) {
                nums1[firstEnd] = nums2[second];
                second--;
                firstEnd--;
            }
            else if (nums2[second] == nums1[first]) {
                nums1[firstEnd] = nums2[second];
                second--;
                firstEnd--;
                nums1[firstEnd] = nums1[first];
                first--;
                firstEnd--;
            }
        }

        while (first >= 0 && firstEnd>=0) {
            nums1[firstEnd] = nums1[first];
                first--;
                firstEnd--;
        }

        while (second >= 0 && firstEnd>=0) {
            nums1[firstEnd] = nums2[second];
                second--;
                firstEnd--;
        }
    }
}
*/
