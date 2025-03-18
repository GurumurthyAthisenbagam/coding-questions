/**
wiggle sort is alernate small and large numbers
close the array and sort it

**/

class Solution {
    public void wiggleSort(int[] nums) {

        int[] sorted = nums.clone();

        Arrays.sort(sorted);
        

        int mid = (nums.length-1)/2;
        int last = nums.length-1;

        for(int i=0; i<nums.length; i++) {
            if (i%2 ==0) {
                nums[i] = sorted[mid];
                mid--;
            } else {
                nums[i] = sorted[last];
                last--;
            }
        }

        
    }
}


