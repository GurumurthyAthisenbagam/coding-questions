/**
Optimal Approach: Sorting + One-Pass Comparison
Pattern: Sorting + Single Pass to Find Minimum Difference

Steps:

Sort the Array:

Sort arr to simplify finding consecutive pairs with minimum absolute difference.
Find Minimum Absolute Difference:

Use a single pass to calculate the minimum absolute difference between consecutive elements.
Collect Pairs:

Perform another pass to collect all pairs with the minimum absolute difference.


 */

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pair = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        Arrays.sort(arr);

        for (int i=0; i<arr.length-1; i++) {
            int diff = Math.abs(arr[i] - arr[i+1]);
            if(diff < minDiff) {
                minDiff = diff;
                res = new ArrayList<>();
                pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i+1]);
                res.add(pair);
            } 
            else if(diff == minDiff) {
                pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i+1]);
                res.add(pair);
            }
            // if greater than minDiff skip
        }

        return res;
    }
}
