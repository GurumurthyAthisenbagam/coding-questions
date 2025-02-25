/**

Algorithm for Permutations
Initialize Data Structures:

Create a list res to store all possible permutations.
Define the Main Function (permute):

This function takes an integer array nums as input.
It initializes an empty list perm to store the current permutation.
It initializes a boolean array pick of size nums.length to track whether an element is already included in the current permutation.
It calls the recursive helper function backTrack(perm, nums, pick).
Recursive Backtracking Function (backTrack):

Base Case: If the perm list size equals nums.length, add a copy of perm to res and return.
Iterate Over Elements:
Loop through nums and check if the element is already picked using pick[i].
If nums[i] is not picked:
Mark it as picked (pick[i] = true).
Add nums[i] to perm.
Recursively call backTrack(perm, nums, pick).
After returning from recursion:
Remove the last element from perm (backtrack).
Mark pick[i] as false to allow reuse of the number in future iterations.
Return Result:

After recursion completes, return res, which contains all possible permutations.

Time Complexity: 
𝑂(𝑁!)
Since there are N! permutations of nums, and each permutation takes O(N) operations in the worst case.
Space Complexity: 
O(N) (excluding output storage)
Due to recursion depth of at most 
O(N) and the pick array storing N elements.

 */

class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backTrack(new ArrayList<Integer>(),nums, new boolean[nums.length]);
        return res;
    }

    public void backTrack(ArrayList<Integer> perm, int[] nums, boolean[] pick){

    if(perm.size() == nums.length) {
        res.add(new ArrayList(perm));
        return;
    }

    for(int i=0; i<nums.length; i++) {
        if(!pick[i]) {
            pick[i] = true;
            perm.add(nums[i]);
            backTrack(perm,nums,pick);
            perm.remove(perm.size()-1);
            pick[i] = false;
        }
    }
    return;

    }
}
