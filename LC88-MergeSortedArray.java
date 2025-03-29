/**
Start from ends of array and sort in descending order
Start filling from the end of first array which has space for m+n. 
 */
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
