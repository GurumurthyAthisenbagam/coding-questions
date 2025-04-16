/**
Find second largest and replace all occurance of first largest with second largest. 
Repeat this until all elements in array is equal to K
If any element in array <k return -1; 

num of operations is dependent on the numbe of numbers greater than k. 
so suffice to check the number of unique numbers greater than k.  
 */
class Solution {
    public int minOperations(int[] nums, int k) {
        
        Set<Integer> set = new HashSet<>();

        for(int n: nums) {
            if (n > k) {
                set.add(n);
            } 
            else if(n < k ) {
                return -1;
            }

        }

        return set.size();
    }
}
