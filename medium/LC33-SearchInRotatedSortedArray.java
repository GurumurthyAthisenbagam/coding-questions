/**
Optimal Approach: Modified Binary Search
Pattern: Binary Search with Conditions for Rotated Array

Idea:

Use Binary Search with left and right pointers.

For each midpoint (mid):

Check if nums[mid] is the target.
Determine which half of the array is sorted:
Left half is sorted: If nums[left] ≤ nums[mid].
Right half is sorted: Otherwise.
Narrow the search based on:
Left sorted: Check if target is in this range.
Right sorted: Check if target is in this range.
Return the index if found; otherwise, return -1.

 */

class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;

        while(left<=right) {

            int mid =left+ (right-left)/2;
            // System.out.println("mid: " + mid + " nums[mid]: " + nums[mid] + " left: " + left + " right: " + right);
            if(nums[mid] == target) return mid;
            if (nums[left]<=nums[mid]) { // left is sorted
                if(target< nums[mid] && target >= nums[left]) {
                    right = mid -1;
                    continue;
                }
                else {
                    left = mid + 1;
                    continue;
                }
            } else if (nums[right]> nums[mid]) { // right is sorted
                if(target > nums[mid] && target<= nums[right]) {
                    left = mid + 1;
                    continue;
                } else {
                    right = mid -1;
                    continue;
                }
            }

    
        }
        return -1;
        
    }
}
