/**
Step-by-step thinking:
Start from the end of the array (rightmost element).
Keep track of the current maximum you've seen so far.

For each element:
Store the original value temporarily.
Replace the current element with the current maximum.
Update the current maximum if needed.
 */

class Solution {
    public int[] replaceElements(int[] arr) {

        int n = arr.length;
        int currentMax = -1;
        
        
        for(int i = n-1; i>=0; i--) {
            int current = arr[i];
            arr[i] = currentMax;
            currentMax = Math.max(current, currentMax); 
            // memorizing current value for next interation since we override the current with max from remaining array in right
        }
        
        return arr;
    }
}
