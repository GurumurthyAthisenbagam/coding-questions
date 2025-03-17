/**
Steps
Sort the array (O(N log N)).

Triangle Property: If the two smallest sides sum to a value greater than the largest side, a triangle is valid.

Use Two Pointers:
Fix the largest side nums[k] (start from k = n-1).
Use two pointers left = 0, right = k - 1:
If nums[left] + nums[right] > nums[k], all pairs (left to right-1) are valid, so add (right - left) to count and decrement right.
Else, increment left since we need a larger sum.
Time Complexity
Sorting: O(N log N)
Two Pointers for each k: O(N²)
Total Complexity: O(N²)



 */

class Solution {
    public int triangleNumber(int[] nums) {

        int validCombinations = 0;
        Arrays.sort(nums);


        for (int k=nums.length-1; k>=2; k--) {
            int fixedOne = nums[k];

            int left = 0;
            int right = k-1;

            while (left<right) {
                if(nums[left] + nums[right] > fixedOne) {
                    validCombinations += right-left;
                    right--; // after finding a big number, you move right pointer to left to check if more combinations exist. 
                }
                else{
                    left++; // if no combination exist, move left pointer to right to find a bigger value
                }

            }
            
        }

        return validCombinations;
        }
        
}
